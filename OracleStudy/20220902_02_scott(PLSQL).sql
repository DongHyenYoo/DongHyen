--○TBL_입고 테이블에 『입고』 이벤트가 발생시
-- 관련 테이블에 수행되어야 하는 내용

--①INSERT -> TBL_입고테이블

--②UPDATE -> TBL_상품

--○TBL_상품, TBL_입고 테이블을 대상으로
-- TBL_입고 테이블에 데이터 입력 시(즉, 입고 이벤트 발생 시)
--TBL_입고 테이블의 데이터 입력 뿐 아니라
-- TBL_상품 테이블의 재고 수량이 함께 변동될 수 있는 기능을 가진 프로시저를 작성한다.
-- 단, 이 과정에서 입고번호는 자동 증가 처리한다. (시퀀스 사용 X)

--TBL_입고 테이블 구성 컬럼(구조)
-- 입고번호,상품코드,입고일자,입고수량,입고단가
-- 프로시저 명: PRC_입고_INSERT(상품코드,입고수량,입고단가)

CREATE OR REPLACE PROCEDURE PRC_입고_INSERT
( V_상품코드 IN TBL_입고.상품코드%TYPE
, V_입고수량 IN TBL_입고.입고수량%TYPE
, V_입고단가 IN TBL_입고.입고단가%TYPE
)

IS
  V_입고번호 TBL_입고.입고번호%TYPE;
BEGIN
  
  SELECT NVL(MAX(입고번호),0)+1 INTO V_입고번호
  FROM TBL_입고;
 --INSERT 쿼리문 수행
  INSERT INTO TBL_입고(입고번호,상품코드,입고일자,입고수량,입고단가)
  VALUES(V_입고번호, V_상품코드, SYSDATE, V_입고수량, V_입고단가);
  --UPDATE 쿼리문 수행
  UPDATE TBL_상품
  SET 재고수량 = 재고수량 + V_입고수량
  WHERE 상품코드 = V_상품코드;
  
  
  --예외 처리
  EXCEPTION
    WHEN OTHERS THEN ROLLBACK; --위 구문중에서 정상적으로 처리되지 못한 상황이 발생한다면 롤백해라
    
  --커밋  
  COMMIT;
  
END;


------------------------------------------------------------------------
--■■■프로시저 내에서의 예외 처리■■■----

--1번 시트 61줄
--○TBL_MEMBER 테이블에 데이터를 입력하는 프로시저를 작성
--  단, 이 프로시저를 통해 데이터를 입력할 겨우
--  CITY(지역) 항목 '서울', '경기' ,'대전'만 입력이 가능하도록 구성한다.
-- 이 지역 외의 다른 지역을 프로시저 호출을 통해 입력하고자 하는 경우
-- (즉, 입력을 시도하는 경우)
-- 예외에 대한 처리를 하려고 한다.
-- 프로시저 명 : PRC_MEMBER_INSERT()

/*
실행 예)
EXEC PRC_MEMBER_INSERT('임시연', '010-1111-1111', '서울');
--==>> 데이터 입력 ○

EXEC PRC_MEMBER_INSERT('김보경', '010-2222-2222', '부산');
데이터 입력 X
*/

CREATE OR REPLACE PROCEDURE PRC_MEMBER_INSERT
( V_NAME IN TBL_MEMBER.NAME%TYPE
, V_TEL  IN TBL_MEMBER.TEL%TYPE
, V_CITY IN TBL_MEMBER.CITY%TYPE
)

IS
    --실행 영역의 쿼리문 수행을 위해 필요한 변수 추가 선언
    V_NUM   TBL_MEMBER.NUM%TYPE;
    
    --예외도 변수이기에 
    -- 사용자 정의 예외에 대한 변수 선언
    USER_DEFINE_ERROR EXCEPTION;

BEGIN
        
    --단 입력받은 DATA가 구조에 없다면 애초에 안받아야한다.
    --즉 프로시저를 통해 입력 처리를 정상적으로 해줘야할 데이터인지
    -- 아닌지의 여부를 가장 먼저 확인할 수 있도록 코드 구성

--    IF (지역이 서울 경기 인천이 아니라면)
--      THEN 예외를 발생시키겠다. --java 에서의 THROW 와 같은것
--    END IF;
    
    IF (V_CITY NOT IN ('서울', '경기', '대전'))
        THEN RAISE USER_DEFINE_ERROR;
    END IF;

    --INSERT 쿼리문을 수행하기에 앞서
    --선언한 변수에 값 담아내기
    SELECT NVL(MAX(NUM),0) INTO V_NUM
    FROM TBL_MEMBER;
    
    --V_NUM = TBL_MEMBER.MEMBER 처럼 할 수 없다.
    
    --쿼리문 구성 -> INSERT
    
    INSERT INTO TBL_MEMBER(NUM, NAME, TEL, CITY)
    VALUES((V_NUM+1), V_NAME, V_TEL, V_CITY);
    
    --예외 처리 구문
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001,'서울,경기,대전만 입력이 가능합니다.');   --2만번까지는 오라클이 사용중인 번호
                                                    --프로젝트시 에러번호를 팀원들과 소통해서 번호를 약속해서 처리한다.
            WHEN OTHERS
                THEN ROLLBACK;
END;

--Procedure PRC_입고_INSERT이(가) 컴파일되었습니다.


------------------------------------------------------------------------

--○TBL_출고 테이블에 데이터 입력 시(즉, 출고 이벤트 발생 시)
-- TBL_상품 테이블의 재고 수량이 변동되는 프로시저를 작성한다.
-- 단, 출고번호는 입고번호와 마찬가지로 자동 증가 처리한다.
-- 또한, 출고 수량이 재고 수량보다 많은 경우..
-- 출고 액션 처리 자체를 취소할 수 있도록 처리한다.
-- 프로시저 명 : PRC_출고_INSERT()

/*EX)
EXEC PRC_출고_INSERT('H001', 50, 1000);
*/

CREATE OR REPLACE PROCEDURE PRC_출고_INSERT
( V_상품코드 IN TBL_상품.상품코드%TYPE 
, V_출고수량 IN TBL_출고.출고수량%TYPE
, V_출고단가 IN TBL_출고.출고단가%TYPE
)

IS  
    V_출고번호 TBL_출고.출고번호%TYPE; --출고번호
    V_재고수량 TBL_상품.재고수량%TYPE;--상품재고를 담을 변수
    USER_DEFINE_ERROR EXCEPTION;    -- 재고보다 많이 출고할 수 없음을 알려줄 변수
BEGIN

    --재고수량부터 담기
    
    SELECT 재고수량 INTO V_재고수량 
    FROM TBL_상품 
    WHERE 상품코드 = V_상품코드;

    --출고량>상품재고 일경우 예외처리
    IF (V_출고수량 > V_재고수량)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
    
    --출고번호 담당한 변수에 숫자 넣기
    SELECT NVL(MAX(출고번호),0)+1 INTO V_출고번호
    FROM TBL_출고;

    --출고테이블
    INSERT INTO TBL_출고(출고번호, 상품코드, 출고일자, 출고수량, 출고단가)
    VALUES(V_출고번호, V_상품코드, SYSDATE, V_출고수량, V_출고단가);
    
    
    --상품테이블 업데이트
    UPDATE TBL_상품
    SET 재고수량 = 재고수량-V_출고수량
    WHERE 상품코드 = V_상품코드;
    
    
    --예외처리
    EXCEPTION
    WHEN USER_DEFINE_ERROR
        THEN RAISE_APPLICATION_ERROR(-20002, '재고보다 많이 출고할수는 없습니다.');
             ROLLBACK; --이렇게도 써도된다.
        WHEN OTHERS
            THEN ROLLBACK;
        
END;



--○ TBL_출고 테이블에서 출고 수량을 수정(변경)하는 프로시저를 작성한다.
-- 프로시저 명: PRC_출고_UPDATE()
/*
EXEC PRC_출고_UPDATE(출고번호, 변경할수량);
*/

CREATE OR REPLACE PROCEDURE PRC_출고_UPDATE
( V_출고번호 TBL_출고.출고번호%TYPE
, V_출고수량 TBL_출고.출고수량%TYPE  --①.매개변수 선언
)

IS
    --③.필요한 변수 추가 선언
    USER_DEFINE_ERROR EXCEPTION;
    USER_DEFINE_ERROR1 EXCEPTION;
    V_상품코드 TBL_상품.상품코드%TYPE;
    V_변경전출고 TBL_출고.출고수량%TYPE;
    V_변경전재고 TBL_상품.재고수량%TYPE;
    
BEGIN
    
    
  --④.선언한 변수에 값 담기
  
   --출고번호로 상품번호, 이전출고 찾기
   SELECT 상품코드, 출고수량 INTO V_상품코드,V_변경전출고
   FROM TBL_출고
   WHERE 출고번호 = V_출고번호;
   
   --변경전 재고
   
   SELECT 재고수량 INTO V_변경전재고
   FROM TBL_상품
   WHERE 상품코드 = V_상품코드;
   

   -- ⑤.출고 정상 수행여부 판단
   -- 변경 이전의 출고수량 및 현재의 재고수량 확인
   IF (V_출고수량 > V_변경전출고 + V_변경전재고)
        THEN RAISE USER_DEFINE_ERROR;
   END IF;
   
    
    -- ②. 수행될 쿼리문 update    
    --UPDATE 출고
    UPDATE TBL_출고
    SET 출고수량 = V_출고수량
    WHERE 출고번호 = V_출고번호;
    
    --⑥
     --UPDATE 상품
    UPDATE TBL_상품
    SET 재고수량 = (재고수량 + V_변경전출고) - V_출고수량
    WHERE 상품코드 = V_상품코드;
    
    
    
    --예외처리
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '재고 부족');
                ROLLBACK;
    COMMIT;
    
END;

/*
    
    --UPDATE 상품
    UPDATE  (SELECT S.상품코드, S.재고수량, C.출고번호, C.출고수량 
            FROM TBL_상품 S JOIN TBL_출고 C
            ON S.상품코드 = C.상품코드) T
    SET T.재고수량 = T.재고수량 + (T.출고수량 - V_출고수량)
    WHERE T.출고번호 =  V_출고번호;
    
*/

--과제
/*
1.PRC_입고_UPDATE(입고번호, 입고수량) --입고번호 이후에 출고된것들을 다 고려해야한다.(원래는)
2.PRC_입고_DELETE(입고번호)  --입고번호의 입고수량이 지워진 만큼 상품에서 감소
3.PRC_출고_DELETE(출고번호) --delete된만큼 상품에 증가
*/
--3.
CREATE OR REPLACE PROCEDURE PRC_출고_DELETE
(V_출고번호 IN TBL_출고.출고번호%TYPE
)

IS
    --필요변수 1.제거될 출고수량
          --   2.현재 상품재고량
          --  3.제거될 출고상품의 코드
    V_출고수량 TBL_출고.출고수량%TYPE; 
    V_현재재고 TBL_상품.재고수량%TYPE;
    V_상품코드 TBL_출고.상품코드%TYPE;
BEGIN
    
    --해야할것
    --1.제거전 변수에 이전 출고수량담기
    
    SELECT 출고수량, 상품코드 INTO V_출고수량, V_상품코드 
    FROM TBL_출고
    WHERE 출고번호 = V_출고번호;
    --2.DELETE
    DELETE
    FROM TBL_출고
    WHERE 출고번호 = V_출고번호;
    
    --3.UPDATE TBL_상품 에서 출고수량+재고
    UPDATE TBL_상품
    SET 재고수량 = 재고수량+V_출고수량
    WHERE 상품코드 = V_상품코드;
    
    COMMIT;
    
END;


--2.PRC_입고_DELETE(입고번호)  --입고번호의 입고수량이 지워진 만큼 상품에서 감소

CREATE OR REPLACE PROCEDURE PRC_입고_DELETE
(V_입고번호 IN TBL_입고.입고번호%TYPE
)

IS
    --필요변수
    --1.지워지기전의 입고수량
    --2.어떤 상품인지 알기위해 상품코드
    V_상품코드 TBL_입고.상품코드%TYPE;
    V_입고수량 TBL_입고.입고수량%TYPE;
    V_재고수량 TBL_상품.재고수량%TYPE;
    V_출고수량 TBL_출고.출고수량%TYPE;
    USER_DEFINE_ERROR EXCEPTION;
BEGIN
    --해야할 쿼리
    
    
    
    
    --1.지워지기전 입고수량 변수에 저장
    SELECT 입고수량, 상품코드 INTO V_입고수량, V_상품코드
    FROM TBL_입고
    WHERE 입고번호 = V_입고번호;
    
    --2.재고수량
    SELECT 재고수량 INTO V_재고수량
    FROM TBL_상품
    WHERE 상품코드 = V_상품코드;
    
    --3.재고수량보다 제거하려는 입고수량이 많을때
    IF (V_재고수량 < V_입고수량)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
   
    
    --4.입고 데이터 제거
    DELETE
    FROM TBL_입고
    WHERE 입고번호 = V_입고번호;
    --5.상품에서 입고수량만큼 차감
    UPDATE TBL_상품
    SET 재고수량 = 재고수량 - V_입고수량 
    WHERE 상품코드 = V_상품코드;
    
    --6예외처리
    EXCEPTION
        WHEN USER_DEFINE_ERROR
        THEN RAISE_APPLICATION_ERROR(-20002,'데이터 삭제시 재고가 없습니다.');
            ROLLBACK;
        WHEN OTHERS
            ROLLBACK;
            
     COMMIT;       
             
END;


--1.PRC_입고_UPDATE(입고번호, 입고수량) --입고번호 이후에 출고된것들을 다 고려해야한다.(원래는)

CREATE OR REPLACE PROCEDURE PRC_입고_UPDATE
( V_입고번호 IN TBL_입고.입고번호%TYPE
, V_입고수량 IN TBL_입고.입고수량%TYPE
)

IS
    --선언해야할 변수들
    V_이전입고수량 TBL_입고.입고수량%TYPE;
    V_상품코드 TBL_입고.상품코드%TYPE;
    V_재고수량 TBL_상품.재고수량%TYPE;
    
    --사용자 정의 예외변수
    USER_DEFINE_ERROR EXCEPTION;
BEGIN

    --변수에 값 담기
    SELECT 상품코드, 입고수량 INTO V_상품코드, V_이전입고수량
    FROM TBL_입고
    WHERE 입고번호 = V_입고번호;
    
    SELECT 재고수량 INTO V_재고수량
    FROM TBL_상품
    WHERE 상품코드 = V_상품코드;
    
    --수행해야할 쿼리문
    --1. 재고 = 재고 - 이전 입고 + V_입고수량 <0 는 안된다. 재고가 -일수는 없음
        --필요변수 : 현재 재고
        --           현재 재고파악을 위한 상품코드
        --          사용자정의 예외변수
        
        IF (V_재고수량 - V_이전입고수량 + V_입고수량 <0)
            THEN RAISE USER_DEFINE_ERROR;
        END IF;
        
    --2.UPDATE 입고 입고수량 = V_입고수량
        
        UPDATE TBL_입고
        SET 입고수량 = V_입고수량
        WHERE 입고번호 = V_입고번호;
        
    --3.UPDATE 상품 이전 재고만큼 빼고 변경수량만큼 더해주기 
        --필요변수 : 이전 재고 
        
        UPDATE TBL_상품
        SET 재고수량 = 재고수량 - V_이전입고수량 + V_입고수량
        WHERE 상품코드 = V_상품코드;
        
    --예외처리
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '변경될 재고가 -입니다');
                 ROLLBACK;
        WHEN OTHERS
            ROLLBACK;
        
        COMMIT;
END;




/*
DECLARE
    EMPNUM NUMBER;
    --NUM NUMBER;
    NUM EMPLOYEES.EMPLOYEE_ID%TYPE;
BEGIN
    SELECT COUNT(*) INTO EMPNUM
    FROM EMPLOYEES;
    
    FOR NUM IN 100..(99+EMPNUM) LOOP --FOR 시작
    
    DECLARE --내부 D-B-E 시작
    EMP EMPLOYEES%ROWTYPE; 
    BEGIN
    SELECT FIRST_NAME , PHONE_NUMBER, EMAIL
    INTO EMP.FIRST_NAME, EMP.PHONE_NUMBER, EMP.EMAIL
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = NUM;
    
    DBMS_OUTPUT.PUT_LINE(EMP.FIRST_NAME ||',   ' || EMP.PHONE_NUMBER|| ',     ' || EMP.EMAIL);
    END; --내부 D-B-E 끝
    END LOOP; --FOR문 끝
*/




--■■■ CURSOR(커서) ■■■--

-- 1. 오라클에서는 하나의 레코드가 아닌 여러 레코드로 구성된
--    작업 영역에서 SQL 문을 실행하고 그 과정에서 발생한 데이터를
--    저장하기 위해 커서(CURSOR)를 사용하며,
--    커서에는 암시적인 커서와 명시적인 커서가 있다

-- 2. 암시적 커서는 모든 SQL 문에 존재하며
--    SQL 문 실행 후 오직 하나의 행(ROW)만 출력하게 된다
--    그러나 SQL 문을 실행한 결과물(RESULT SET)이
--    여러 행(ROW)으로 구성된 경우
--    커서(CURSOR)를 명시적으로 선언해야 여러 행(ROW)을 다룰 수 있다


--○커서 이용 전 상황(단일 행 접근 시)
DECLARE
    V_NAME  TBL_INSA.NAME%TYPE;
    V_TEL   TBL_INSA.TBL%TYPE;
BEGIN
    SELECT NAME, TEL INTO V_NAME, V_TEL
    FROM TBL_INSA
    WHERE NUM = 1001;
    
    

END;

--○ 커서 이용 전 상황(다중 행 접근 시 - 반복문 활용)
DECLARE
    V_NAME  TBL_INSA.NAME%TYPE;
    V_TEL   TBL_INSA.TEL%TYPE;
    V_NUM   TBL_INSA.NUM%TYPE := 1001;
BEGIN
    LOOP
        SELECT NAME, TEL INTO V_NAME, V_TEL
        FROM TBL_INSA
        WHERE NUM = V_NUM;
        
        DBMS_OUTPUT.PUT_LINE(V_NAME || ' -- ' || V_TEL);
        V_NUM := V_NUM + 1;
        
        EXIT WHEN V_NUM >= 1062;
    END LOOP;   
END;
--==>> 
/*
홍길동 -- 011-2356-4528
이순신 -- 010-4758-6532
이순애 -- 010-4231-1236
김정훈 -- 019-5236-4221
한석봉 -- 018-5211-3542
이기자 -- 010-3214-5357
장인철 -- 011-2345-2525
김영년 -- 016-2222-4444
나윤균 -- 019-1111-2222
김종서 -- 011-3214-5555
유관순 -- 010-8888-4422
정한국 -- 018-2222-4242
조미숙 -- 019-6666-4444
황진이 -- 010-3214-5467
이현숙 -- 016-2548-3365
이상헌 -- 010-4526-1234
엄용수 -- 010-3254-2542
이성길 -- 018-1333-3333
박문수 -- 017-4747-4848
유영희 -- 011-9595-8585
홍길남 -- 011-9999-7575
이영숙 -- 017-5214-5282
김인수 -- 
김말자 -- 011-5248-7789
우재옥 -- 010-4563-2587
김숙남 -- 010-2112-5225
김영길 -- 019-8523-1478
이남신 -- 016-1818-4848
김말숙 -- 016-3535-3636
정정해 -- 019-6564-6752
지재환 -- 019-5552-7511
심심해 -- 016-8888-7474
김미나 -- 011-2444-4444
이정석 -- 011-3697-7412
정영희 -- 
이재영 -- 011-9999-9999
최석규 -- 011-7777-7777
손인수 -- 010-6542-7412
고순정 -- 010-2587-7895
박세열 -- 016-4444-7777
문길수 -- 016-4444-5555
채정희 -- 011-5125-5511
양미옥 -- 016-8548-6547
지수환 -- 011-5555-7548
홍원신 -- 011-7777-7777
허경운 -- 017-3333-3333
산마루 -- 018-0505-0505
이기상 -- 
이미성 -- 010-6654-8854
이미인 -- 011-8585-5252
권영미 -- 011-5555-7548
권옥경 -- 010-3644-5577
김싱식 -- 011-7585-7474
정상호 -- 016-1919-4242
정한나 -- 016-2424-4242
전용재 -- 010-7549-8654
이미경 -- 016-6542-7546
김신제 -- 010-2415-5444
임수봉 -- 011-4151-4154
김신애 -- 011-4151-4444
조현하 -- 010-7202-6306
*/


/*
테이블 생성은 정의구문임
사용자 생성은 정의구문임

함수정의
프로시저 정의

CREATE TABLE 테이블명
CREATE INDEX 인덱스명
USER 유저명
FUNCTION 함수명
PROCEDURE 프로시저명

이름 + 타입이다
*/

SET SERVEROUTPUT ON;

--○커서 이용 후 상황
DECLARE
    --선언부
    --주요 변수_선언
    V_NAME TBL_INSA.NAME%TYPE;
    V_TEL TBL_INSA.TEL%TYPE;
    
    --커서 이용을 위한 커서 변수 선언(->커서정의)
    --cur_insa_select cursor = 선언
    --CURSOR CUR_INSA_SELECT = 정의
    
    CURSOR CUR_INSA_SELECT
   IS
    SELECT NAME,TEL
    FROM TBL_INSA;
    --현재 커서에는 name,tel이 묶여서 전체 행이 압축되어있다.
    
    BEGIN
    
    --커서 오픈
    OPEN CUR_INSA_SELECT;
    
    --커서 오픈 시 쏟아져 나오는 데이터들 처리
    LOOP
        --한 행 한 행 받아다가 처리하는 행위)1  ->『FETCH』 위에 나왔던 에러
        FETCH CUR_INSA_SELECT INTO V_NAME, V_TEL;
        
        -- )1~)2를 반복하다가 커서에서 더 이상 데이터가 쏟아져 나오지 않는 상태
               --가 된다면 그만! 하고 반복문을 빠져나간다.
          
          EXIT WHEN CUR_INSA_SELECT%NOTFOUND;  --커서를 참조했을때 NOTFOUND상태라면  
            
        --출력)2
        DBMS_OUTPUT.PUT_LINE(V_NAME || ' -- ' || V_TEL);
        
        
    END LOOP;
    
    CLOSE CUR_INSA_SELECT;
    
END; 
---------------------------------------------------------------------
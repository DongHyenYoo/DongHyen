---■■■ TRIGGER(트리거)■■■---

--1.TRIGGER(트리거)란 DML 작업 즉, INSERT, UPDATE, DELETE 작업이 일어날 때
--자동적으로 실행되는 객체로
-- 이와 같은 특징을 강조하여 DML TRIGGER 이라고 부르기도 한다.
-- TRIGGER 는 무결성 뿐 아니라 다음과 같은 작업에도 널리 사용된다.

--자동으로 파생된 열 값 생성
    --관리자가 자리를 비웠을시
    --자동으로 이벤트에 대한 정보 작성?...
-- 잘못된 트랜잭션 방지
    --프로시저의 내용과 동일
-- 복잡한 보안 권한 강제 수행
    --몇시부터 몇시까지만 테이블 이용가능
-- 분산 데이터베이스 노드 상에서 참조 무결성 강제 수행
-- 복잡한 업무 규칙 강제 적용
    --ex)업무시간중 증권사, 쇼핑몰 사이트 접속을 막아두는 회사
-- 투명한 이벤트 로깅 제공
    --해당 테이블에 누군가 이벤트(INSERT, UPDATE,DELETE)작업들을 할때마다
    --해당 내용에 대한것을 다른곳에 저장한다.
-- 복잡한 감사 제공

-- 동기 테이블 복제 유지관리
    --백업테이블에 원본 테이블의 정보를 지속적으로 복제해서 유지
-- 테이블 엑세스 통계 수집
    --테이블에 누가 접근했고 누가 수정했는지 실시간으로 감시

--즉 보통 테이블에 붙여서 만들어지며 사용자는 트리거가 발동됬는지의 여부에 대해서는
-- 알 수 없게 만든다.

--2. TRIGGER 내에서는 COMMIT, ROLLBACK 문을 사용할 수 없다.
    --사용자가 알아서 실행할 것이므로 트리거 안에서 COMMIT ROLLBACK구문을 작성하지 않는다.
    

--3. 특징 및 종류


--  -BEFORE STATEMENT
--  :SQL 구문이 실행되기 전에 그 문장에 대해 한번 실행

--  BEFORE ROW
-- :SQL 구문이 실행되기 전에(DML 작업을 수행하기 전에)
--  : 각 행에 대해 한 번씩 실행

--   -AFTER STATEMENT
--  :SQL 구문이 실행된 후에 그 문장에 대해 한 번 실행

--  -AFTER ROW
--  :SQL 구문이 실행된 후에(DML 작업을 수행한 후에)
--  각 행(ROW)에 대해 한 번씩 실행

--4. 형식 및 구조
/*
CREATE [OR REPLACE] TRIGGER 트리거명
    [BEFORE | AFTER]
    이벤트1  [OR 이벤트2 [이벤트 3] ON 테이블명
    [FOR EACH ROW [ WHEN TRIGGER 조건]] --state trigger에서는 쓰지 않는 조건
[DECLARE]
    --선언 구문;
BEGIN
    --실행 구문;
END;
*/


--■■■ AFTER STATEMENT TRIGGER 상황 실습■■■--

--※ DML작업에 대한 이벤트 기록

--○ TRIGGER(트리거) 생성

--트리거 명: TRG_EVENTLOG
CREATE OR REPLACE TRIGGER TRG_EVENTLOG
        AFTER
        INSERT OR UPDATE OR DELETE ON TBL_TEST1 --3개중 하나라도 TEST1테이블에 일어난다면
--DECLARE 생략가능 
BEGIN
    --이벤트 종류 구분( 조건문을 통한 분기)
    IF (INSERTING)
        THEN INSERT INTO TBL_EVENTLOG(MEMO)
            VALUES('INSERT 쿼리가 실행되었습니다.');
    ELSIF (UPDATING)
        THEN INSERT INTO TBL_EVENTLOG(MEMO)
            VALUES('UPDATE 쿼리가 실행되었습니다.');
    ELSIF (DELETING)
        THEN INSERT INTO TBL_EVENTLOG(MEMO)
            VALUES('DELETE 쿼리가 실행되었습니다.');
    END IF;
    
    --COMMIT;
    -- ※TIGGER 내에서는 COMMIT / ROLLBACK 구문 사용 불가
    
END;


--Trigger TRG_EVENTLOG이(가) 컴파일되었습니다.

--■■■ BEFORE STATEMENT TRIGGER 상황 실습■■■--
--※ DML 작업 수행 전에 작업에 대한 가능 여부 확인

--○TRIGGER(트리거) 생성
-- 트리거 명 : TRG_TEST1_DML
CREATE OR REPLACE TRIGGER TRG_TEST1_DML
        BEFORE
        INSERT OR UPDATE OR DELETE ON TBL_TEST1
BEGIN
    IF(작업시간이 오전11시 이전이거나 오후 6시 이후라면..)
        THEN 작업을 수행하지 못하도록 처리하겠다.
    END IF;
END;


CREATE OR REPLACE TRIGGER TRG_TEST1_DML
        BEFORE
        INSERT OR UPDATE OR DELETE ON TBL_TEST1
BEGIN
    IF(TO_NUMBER(TO_CHAR(SYSDATE,'HH24'))<11  OR TO_NUMBER(TO_CHAR(SYSDATE,'HH24'))>17 )
        THEN RAISE_APPLICATION_ERROR(-20003, '작업은 08:00 ~ 18:00 까지만 가능합니다.');
    END IF;
END;

--Trigger TRG_TEST1_DML이(가) 컴파일되었습니다.



--■■■ BEFORE ROW TRIGGER 상황 실습■■■--
--※참조 관계가 설정된 데이터(자식) 삭제를 먼저 수행하는 모델

--○TRIGGER 생성
CREATE OR REPLACE TRIGGER TRG_TEST2_DELETE
        BEFORE 
        DELETE ON TBL_TEST2
        FOR EACH ROW
BEGIN
    DELETE
    FROM TBL_TEST3
    WHERE CODE = :OLD.CODE;
END;
--Trigger TRG_TEST2_DELETE이(가) 컴파일되었습니다.

--※ 『:OLD』
--  참조 전 열의 값이라는 뜻
-- INSERT :OLD = 입력하기 이전의 데이터
-- DELETE :OLD = 삭제하기 이전 데이터, 즉 삭제할 데이터

--※ UPDATE : INSERT 와 DELETE가 결합된 형태로 오라클내부에는 UPDATE라는 것이 없음
             --그러므로 UPDATE하기 이전의 데이터는 INSERT이므로 『:OLD』 로 표현
             -- UPDATE 한 후의 데이터는 『:NEW』
  
  
  
  
--■■■ AFTER ROW TRIGGER 상황 실습■■■--  
--※참조 테이블 관련 트랜잭션 처리

--TBL_입고, TBL_출고, TBL_상품

--○TBL_입고 테이블의 데이터 입력 시(즉, 입고 이벤트 발생 시)
-- TBL_상품 테이블의 재고수량 변동 트리거 생성
-- 트리거 명: TRG_IBGO

CREATE OR REPLACE TRIGGER TRG_IBGO
        AFTER
        INSERT ON TBL_입고
        FOR EACH ROW
BEGIN
    IF(INSERTING)
        THEN UPDATE TBL_상품
            SET 재고수량 = 기존 재고수량 + 새로 입고되는 상품의 입고수량
            WHERE 상품코드 = 새로 입고될 상품의 상품코드;
    END IF;
END;

-----------------------------------------------
CREATE OR REPLACE TRIGGER TRG_IBGO
        AFTER
        INSERT ON TBL_입고
        FOR EACH ROW
BEGIN
    IF(INSERTING)
        THEN UPDATE TBL_상품
            SET 재고수량 = 재고수량 + :NEW.입고수량
            WHERE 상품코드 = :NEW.상품코드;
    END IF;
END;
----------------------------------------
CREATE OR REPLACE TRIGGER TRG_IBGO
            AFTER
            INSERT ON TBL_입고
            FOR EACH ROW
BEGIN
    
        UPDATE TBL_상품
             SET 재고수량 = 재고수량 + :NEW.입고수량
             WHERE 상품코드 = :NEW.상품코드;

END;
--===>>Trigger TRG_IBGO이(가) 컴파일되었습니다.


--○tbl_입고 테이블의 데이터 입력, 수정 삭제 시
-- tbl_상품 테이블의 재고수량 변동 트리거 작성
-- 트리거 명: TRG_IBGO


--○TBL_출고 테이블의 데이터 입력, 수정, 삭제 시
-- TBL_상품 테이블의 재고수량 변동 트리거 작성
--  트리거 명: TRG_CHULGO


--○ TBL_입고 테이블의 데이터 입력, 수정, 삭제 시
--   TBL_상품 테이블의 재고수량 변동 트리거 작성
--   트리거 명 : TRG_IBGO
CREATE OR REPLACE TRIGGER TRG_IBGO
            AFTER
            INSERT OR UPDATE OR DELETE ON TBL_입고
            FOR EACH ROW
BEGIN
    IF(INSERTING)   -- 재고가 없던 상품의 새로운 입고 추가
        THEN UPDATE TBL_상품
             SET 재고수량 = 재고수량 + :NEW.입고수량
             WHERE 상품코드 = :NEW.상품코드;
    ELSIF(UPDATING) -- 재고가 있던 상품의 새로운 입고 추가
        THEN UPDATE TBL_상품
             SET 재고수량 = 재고수량 + (:NEW.입고수량 + :OLD.입고수량)
             WHERE 상품코드 = :NEW.상품코드;
    ELSIF(DELETING) -- 이미 과거에 입고가 이루어져, 재고가 있던 상품의 입고 제거
        THEN UPDATE TBL_상품
             SET 재고수량 = 재고수량 - :OLD.입고수량
             WHERE 상품코드 = :OLD.상품코드;
    END IF;
END;
--==>> Trigger TRG_IBGO이(가) 컴파일되었습니다.


--○ TBL_출고 테이블의 데이터 입력, 수정, 삭제 시
--   TBL_상품 테이블의 재고수량 변동 트리거 작성
--   트리거 명 : TRG_CHULGO
CREATE OR REPLACE TRIGGER TRG_CHULGO
            AFTER
            INSERT OR UPDATE OR DELETE ON TBL_출고
            FOR EACH ROW
BEGIN
    IF(INSERTING)   -- 출고가 없던 상품의 새로운 출고
        THEN UPDATE TBL_상품
             SET 재고수량 = 재고수량 - :NEW.출고수량
             WHERE 상품코드 = :NEW.상품코드;
    ELSIF(UPDATING)    -- 출고가 있던 상품의 새로운 출고
        THEN UPDATE TBL_상품
             SET 재고수량 = 재고수량 + :OLD.출고수량 - :NEW.출고수량
--           (→ 현재 재고수량에 이전 출고량을 더해서 다시 새로운 출고량을 빼서 업데이트한다)
             WHERE 상품코드 = :NEW.상품코드;
    ELSIF(DELETING)    -- 출고가 있던 상품의 출고 제거
        THEN UPDATE TBL_상품
             SET 재고수량 = 재고수량 + :OLD.출고수량
             WHERE 상품코드 = :OLD.상품코드;
    END IF;
END;
--==>> Trigger TRG_CHULGO이(가) 컴파일되었습니다.
     

-----------------------------------------------------------------

---■■■ PACKAGE(패키지) ■■■----

--1.PL/SQL의 패키지는 관계되는 타입, 프로그램 객체,
-- 서브 프로그램(PROCEDURE, FUNCTION등)을
-- 논리적으로 묶어놓은 것으로
-- 오라클에서 제공하는 패키지 중 하나가 바로 DBMS_OUTPUT이다.

--2.패키지는 서로 유사한 업무에 사용되는 여러개의 프로시저와 함수를
-- 하나의 패키지로 만들어 관리함으로써 향후 유지보수가 편리하고
-- 전체 프로그램을 모듈화 할 수 있는 장점이 있다.

--3. 패키지는 명세부(PACKAGE SPECIFICATION)와
-- 몸체부(PACKAGE BODY)로 구성되어 있으며
-- 명세 부분에는 TYPE, CONSTRAINT, VARIABLE, EXCEPTION, CURSOR, SUBPROGRAM이 선언되고
-- 몸체 부분에는 이들의 실제 내용이 존재한다.
-- 그리고 호출할 때에는 패키지명.프로시저명 형식의 참조를 이용해야 한다.

--4. 형식 및 구조(명세부)
/*
CREATE [ OR REPLACE] PACKAGE 패키지명
IS
    전역변수 선언;
    커서 선언;
    예외 선언;
    함수 선언;
    프로시저 선언;
        .
        .
END 패키지명;
*/

--5.형식 및 구조(몸체부)
/*
CREATE [OR REPLACE] PACKAGE BODY 패키지명
IS
    FUNCTION 함수형[(인수,...)]
    RETURN 자료형
    IS
        변수 선언;
    BEGIN
        함수 몸체 구성 코드;
        RETURN 값;
    END;
    
    PROCEDURE 프로시저명[(인수,...)]
    IS
        변수 선언;
    BEGIN
        프로시저 몸체 구성 코드;
    END;
    
END 패키지명;
*/
-- 패키지 등록 실습

--①명세부 작성
CREATE OR REPLACE PACKAGE INSA_PACK
IS
    FUNCTION FN_GENDER(V_SSN VARCHAR2)
    RETURN VARCHAR2;
    
END INSA_PACK;
--Package INSA_PACK이(가) 컴파일되었습니다.

--②몸체부 작성
CREATE OR REPLACE PACKAGE BODY INSA_PACK
IS
    
    FUNCTION FN_GENDER(V_SSN VARCHAR2)
    RETURN VARCHAR2
    IS
        V_RESULT VARCHAR2(20);
    BEGIN
        IF (SUBSTR(V_SSN, 8, 1) IN ('1','3'))
            THEN V_RESULT := '남자';
        ELSIF (SUBSTR(V_SSN, 8, 1) IN ('2', '4'))
            THEN V_RESULT := '여자';
        ELSE
            V_RESULT := '확인불가';
        END IF;
        
    RETURN V_RESULT;
    
    END;
    
END INSA_PACK;

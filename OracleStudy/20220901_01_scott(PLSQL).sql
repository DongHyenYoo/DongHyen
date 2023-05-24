--○TBL_INSA 테이블의 급여 계산 전용 함수를 정의한다.
--  급여는 『(기본급*12)+수당』 기반으로 연산을 수행한다.
-- 함수명 : FN_PAY(기본급, 수당)

CREATE OR REPLACE FUNCTION FN_PAY( BASICPAY NUMBER, SUDANG NUMBER)
RETURN NUMBER

IS  
    V_RESULT NUMBER;
BEGIN
    V_RESULT := (NVL((BASICPAY*12),0)+NVL(SUDANG,0);
    RETURN V_RESULT;
END;

SELECT NAME "이름", FN_PAY(BASICPAY, SUDANG) "기본급+수당"
FROM TBL_INSA;



--TBL_INSA 테이블에서 입사일을 기준으로
-- 현재까지의 근무년수를 반환하는 함수를 정의한다.
-- 단, 근무년수는 소수점 이하 한자리 까지 계산
-- 함수명: FN_WORKYEAR(입사일)



SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION FN_WORKYEAR(HIREDATE DATE)
RETURN VARCHAR2

IS
    V_RESULT VARCHAR2(20);
BEGIN
    V_RESULT := TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE)/12)
                || '년' || TRUNC(MOD(MONTHS_BETWEEN(SYSDATE,HIREDATE),12));
    RETURN V_RESULT;
END;

SELECT NAME "이름", FN_WORKYEAR(IBSADATE) "근무년수"
FROM TBL_INSA;

----------------------------------------------------------------------

--※참고

--1.INSERT , UPDATE, DELETE , (MERGE)
--==>> DML(Data Manipulation Language) 데이터를 조작하는 언어
-- COMMIT / ROLLBACK이 필요하다.

--2. CREATE, DROP, ALTER, (TRUNCATE) --구조적으로 바꾸는것
--==>> DDL(Data Definition Language)
--실행시 자동으로 COMMIT된다.


--3.GRANT, REVOKE
--==>>DCL(Data Control Language)
-- 실행하면 자동으로 COMMIT된다.


--4.COMMIT , ROLLBACK
--==>> TCL(Transaction Control Language)


-------------------------------------------------------

--■■■PROCEDURE(프로시저) ■■■----

--1. PL/SQL 에서 가장 대표적인 구조인 스토어드 프로시저는
--   개발자가 자주 작성해야 하는 업무의 흐름ㅇ을
--   미리 작성하여 데이터베이스 내에 저장해 두었다가
--   필요할 때 마다 호출하여 실행할 수 있도록 처리해 주는 구문이다.

--2. 형식 및 구조
/*
CREATE [OR RELACE] PROCEDURE 프로시저명
[(매개변수 IN 데이터타입
  , 매개변수 OUT 데이터타입
  , 매개변수 INOUT 데이터타입
)]
IS
  [--주요 변수 선언]
BEGIN
   -- 실행 구문;
   ...
   [EXCEPTION]
     --예외 처리 구문;
END;
*/

--※ FUNCTION 과 비교했을 때
--   『RETURN 반환자료형』부분이 존재하지 않으며,
--   『RETURN』 문 자체도 존재하지 않으며,
-- 프로시저 실행 시 넘겨주게 되는 매개변수는
-- IN,OUT,INOUT 으로 구분된다.


--3.실행(호출)
/*
EXEC[UTE] 프로시저명[(인수1,인수2,..)];
*/

--프로시저 관련 실습 진행을 위해
--20220901_02_scott.sql 파일에 테이블 생성 및 데이터 입력 수행

--○프로시저 생성
-- 프로시저 명 : PRC_STUDENTS_INSERT(아이디,패스워드,이름,전화,주소)

CREATE OR REPLACE PROCEDURE PRC_STUDENTS_INSERT
( V_ID  IN TBL_IDPW.ID%TYPE
, V_PW  IN TBL_IDPW.PW%TYPE
, V_NAME IN TBL_STUDENTS.NAME%TYPE
, V_TEL IN TBL_STUDENTS.TEL%TYPE
, V_ADDR IN TBL_STUDENTS.ADDR%TYPE
)
IS
BEGIN
    INSERT INTO TBL_IDPW(ID,PW)
    VALUES(V_ID,V_PW);
    
    INSERT INTO TBL_STUDENTS(ID,NAME,TEL,ADDR)
    VALUES(V_ID, V_NAME, V_TEL, V_ADDR);
    
    COMMIT;
END;

--==>>Procedure PRC_STUDENTS_INSERT이(가) 컴파일되었습니다


--○TBL_SUNGJUK 테이블에 데이터 입력 시
-- 특정 항목의 데이터만 입력하면
-- -----------------
-- (학번 이름 국어 영어 수학점수)
--내부적으로 총점, 평균, 등급 항목에 대한 처리가 함께 이루어질 수 있도록 하는
-- 프로시저를 작성한다.
-- 프로시저명 : PRC_SUNGJUK_INSERT()

/*실행 예)
EXEC PRC_SUNGJUK_INSERT(1, '엄소연', 90,80,70);

->프로시저 호출로 처리된 결과
학번 이름 국어점수  영어점수  수학점수  총점  평균  등급
1    엄소연  90      80        70      240   80    B
*/

CREATE OR REPLACE PROCEDURE PRC_SUNGJUK_INSERT
( V_HAKBUN IN TBL_SUNGJUK.HAKBUN%TYPE
, V_NAME IN TBL_SUNGJUK.NAME%TYPE
, V_KOR IN TBL_SUNGJUK.KOR%TYPE
, V_ENG IN TBL_SUNGJUK.ENG%TYPE
, V_MAT IN TBL_SUNGJUK.MATN%TYPE
)
IS
   V_AVG TBL_SUNGJUK.AVG%TYPE;
   V_TOT TBL_SUNGJUK.TOT%TYPE;
   V_GRADE TBL_SUNGJUK.GRADE%TYPE;
BEGIN
   V_TOT := V_KOR + V_MAT + V_ENG;
   V_AVG := (V_TOT/3);
   
             IF (V_AVG >= 90)
                 THEN V_GRADE := 'A';
              ELSIF (V_AVG >= 80)
                 THEN V_GRADE := 'B';
              ELSIF (V_AVG >= 70)
                 THEN V_GRADE := 'C';
              ELSIF (V_AVG >= 60)
                 THEN V_GRADE := 'D';
              ELSE
                 V_GRADE := 'F';
              END IF;
   
   /*CASE WHEN V_AVG >=90 THEN 'A'
                  WHEN V_AVG >=80 THEN 'B'
                  WHEN V_AVG >=70 THEN 'C'
                  WHEN V_AVG >=60 THEN 'D'
               ELSE 'F'
               END;
     */          
   INSERT INTO TBL_SUNGJUK(HAKBUN, NAME, KOR, ENG, MATN, TOT, AVG, GRADE)
   VALUES(V_HAKBUN, V_NAME, V_KOR, V_ENG, V_MAT, V_TOT, V_AVG, V_GRADE);
   
   COMMIT;
END;



--○TBL_SUNGJUK 테이블 데이터 수정 시
-- 특정 항목의 데이터만 입력하면
-- -----------------
-- (학번 국어 영어 수학점수)
--내부적으로 총점, 평균, 등급 항목에 대한 처리가 함께 이루어질 수 있도록 하는
-- 프로시저를 작성한다.
-- 프로시저명 : PRC_SUNGJUK_UPDATE()


CREATE OR REPLACE PROCEDURE PRC_SUNGJUK_UPDATE
( V_HAKBUN      IN  TBL_SUNGJUK.HAKBUN%TYPE
, V_KOR         IN  TBL_SUNGJUK.KOR%TYPE
, V_ENG         IN  TBL_SUNGJUK.ENG%TYPE
, V_MAT         IN  TBL_SUNGJUK.MATN%TYPE
)

IS
   V_AVG TBL_SUNGJUK.AVG%TYPE;
   V_TOT TBL_SUNGJUK.TOT%TYPE;
   V_GRADE TBL_SUNGJUK.GRADE%TYPE;
BEGIN
    
    V_TOT := V_KOR + V_MAT + V_ENG;
   V_AVG := (V_TOT/3);
   
             IF (V_AVG >= 90)
                 THEN V_GRADE := 'A';
              ELSIF (V_AVG >= 80)
                 THEN V_GRADE := 'B';
              ELSIF (V_AVG >= 70)
                 THEN V_GRADE := 'C';
              ELSIF (V_AVG >= 60)
                 THEN V_GRADE := 'D';
              ELSE
                 V_GRADE := 'F';
              END IF;
    
    UPDATE TBL_SUNGJUK
    SET KOR = V_KOR
         ,ENG = V_ENG
         ,MATN = V_MAT
         ,TOT = V_TOT
         ,AVG = V_AVG
         ,GRADE = V_GRADE
    WHERE HAKBUN = V_HAKBUN;
END;


--○TBL_STUDENTS 테이블에서 전화번호와 주소 데이터를 변경하는(수정하는)
-- 프로시저 작성
-- 단, ID와 PW가 일치하는 경우에만 수정을 진행 할  수 있도록 처리한다.
-- 프로시저명 : PRC_STUDENTS_UPDATE()

SELECT *
FROM TBL_IDPW;

SELECT *
FROM TBL_STUDENTS;

CREATE OR REPLACE PROCEDURE PRC_STUDENTS_UPDATE
(
-- 매개변수로 받을 것 : 아이디 비밀번호 전화번호 주소
  V_ID IN TBL_IDPW.ID%TYPE
, V_PW IN TBL_IDPW.PW%TYPE
, V_TEL IN TBL_STUDENTS.TEL%TYPE
, V_ADDR IN TBL_STUDENTS.ADDR%TYPE
)
IS
-- 변수 선언 : 따로 할 것이 ,,, 없다!

--방법 4를 위한 변수
    V_PW2 TBL_IDPW.PW%TYPE;
    
    --자바의 플래그변수
    V_FLAG NUMBER := 0;
BEGIN
-- 실행 연산 : "아이디 비밀번호가 TBL_IDPW 와 일치한다면" TBL_STUDENTS를 업데이트 한후 COMMIT 한다.
    
    -- 방법1
--    UPDATE TBL_STUDENTS
--    SET TEL = V_TEL
--      , ADDR=V_ADDR
--    WHERE ID = V_ID 
--      AND (SELECT PW
--           FROM TBL_IDPW
--           WHERE ID=V_ID) = V_PW;
           
    -- 방법2
--    UPDATE TBL_STUDENTS
--    SET TEL = V_TEL
--      , ADDR=V_ADDR
--    WHERE ID = (SELECT P.ID
--                FROM TBL_STUDENTS S JOIN TBL_IDPW P
--                ON S.ID = SA.ID
--                WHERE P.PW = V_PW 
--                  AND P.ID = V_ID);

    -- 방법3
--    UPDATE(SELECT T1.ID, T1.PW, T2.TEL, T2.ADDR
--           FROM TBL_IDPW T1 JOIN TBL_STUDENTS T2
 --          ON T1.ID = T2.ID) T
 --   SET T.TEL = V_TEL
 --     , T.ADDR = V_ADDR
  --  WHERE T.ID = V_ID
  --    AND T.PW = V_PW;
    
    --방법 4
    
    --패스워드가 맞는지 확인
    --(사용자가 입력한 V_PW가 기존 패스워드와 동일한지 확인)
    SELECT PW INTO V_PW2
    FROM TBL_IDPW
    WHERE ID = V_ID;
    
    --패스워드 일치 여부에 따른 분기
    IF (V_PW = V_PW2)
        THEN V_FLAG := 1;
    ELSE
        V_FLAG := 2;
    END IF;
    
    --UPDATE 쿼리문 수행 -> TBL_STUDENTS(분기결과 반영)
    UPDATE TBL_STUDENTS
    SET TEL = V_TEL, ADDR = V_ADDR
    WHERE ID = V_ID
        AND V_FLAG = 1; -- 비밀번호가 맞을때만 UPDATE가 되도록
    
    
    --커밋
     COMMIT;
END;
--==>> Procedure PRC_STUDENTS_UPDATE이(가) 컴파일되었습니다.

--○TBL_INSA 테이블을 대상으로 신규 데이터 입력 프로시저를 작성한다.
-- NAME, SSN, IBSADATE, CITY, TEL, BUSEO, JIKWI, BASICPAY, SUDANG)
--단 번호의 끝이 몇번인지 넣지않고 입력해봐라
--NUM 커럼의 값은
-- 기존 부여된 사원 번호의 마지막 번호 그 다음 번호를 자동으로 입력 처리할 수 있는
-- 프로시저로 구성한다.
-- PRC_INSA_INSERT()

/*
EXEC PRC_INSA_INSERT('조현하'....);
*/

CREATE OR REPLACE PROCEDURE PRC_INSA_INSERT
( V_NAME       IN  TBL_INSA.NAME%TYPE
, V_SSN        IN  TBL_INSA.SSN%TYPE
, V_IBSADATE   IN TBL_INSA.IBSADATE%TYPE
, V_CITY       IN  TBL_INSA.CITY%TYPE
, V_TEL        IN  TBL_INSA.TEL%TYPE
, V_BUSEO      IN  TBL_INSA.BUSEO%TYPE
, V_JIKWI      IN  TBL_INSA.JIKWI%TYPE
, V_BASICPAY    IN  TBL_INSA.BASICPAY%TYPE
, V_SUDANG      IN  TBL_INSA.SUDANG%TYPE
)

IS
    V_NUM TBL_INSA.NUM%TYPE;
BEGIN
   
    SELECT MAX(NVL(NUM,0))+1 INTO V_NUM 
    FROM TBL_INSA;
    
    INSERT INTO TBL_INSA(NUM, NAME, SSN, IBSADATE, CITY, TEL, BUSEO, JIKWI, BASICPAY, SUDANG)
    VALUES(V_NUM, V_NAME, V_SSN, V_IBSADATE, V_CITY, V_TEL, V_BUSEO, V_JIKWI, V_BASICPAY, V_SUDANG);
    
    COMMIT;
END;

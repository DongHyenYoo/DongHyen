SET SERVEROUTPUT ON;
--○ TBL_INSA 테이블의 여러 명의 데이터 여러개를 변수에 저장
--  (반복문 활용)
-- 반복문의 시작점과 끝점을 알아야함
-- 그러나 『커서』라는 것을 배우면 제한사항 없이 활용 가능!
DECLARE
        V_INSA  TBL_INSA%ROWTYPE;
        V_NUM   TBL_INSA.NUM%TYPE := 1001;
BEGIN
        LOOP
                --조회
                SELECT NAME, TEL, BUSEO
                        INTO V_INSA.NAME, V_INSA.TEL, V_INSA.BUSEO
                FROM TBL_INSA
                WHERE NUM = V_NUM;
                
                --출력
                DBMS_OUTPUT.PUT_LINE(V_INSA.NAME|| ' - ' ||V_INSA.TEL ||' - '||V_INSA.BUSEO);
                
                --증감식
                V_NUM := V_NUM +1;
                
                EXIT WHEN V_NUM >1060;
        END LOOP;
END;
---------------------------------------------------------------------------------

--■■■ FUNCTION(함수)■■■--

--1. 함수란 하나 이상의 PL/SQL 문으로 구성된 서브루틴으로
--   코드를 다시 사용할 수 있도록 캡슐화하는데 사용된다.
-- 오라클에서는 오라클에 정의된 기본 제공 함수를 사용하거나
-- 직접 스토어드 함수를 만들 수 있다. (→사용자 정의 함수)
-- 이 사용자 정의 함수는 시스템 함수처럼 쿼리에서 호출하거나
-- 저장 프로시저처럼 EXECUTE 문을 통해 실행할 수 있다.


--2. 형식 및 구조

/*
CREATE [OR REPLACE] FUNCTION 함수명
[( 매개변수명1 자료형
    매개변수명 2 자료형
)]
RETURN 데이터타입
IS
    --주요 변수 선언
BEGIN
    --실행문;
    ...
    RETURN(값); --값 = RETURN 데이터타입 과 같은 타입
    
    [EXCEPTION]
        --예외 처리 구문;
END;
*/


--※ 사용자 정의 함수(스토어드 함수)는
--IN 파라미터(입력 매개변수)만 사용할 수 있으며
-- 반드시 반환될 값의 데이터 타입을 RETURN 문에 선언해야 하고,
--FUNCTION은 반드시 단일 값만 반환한다.

--○TBL_INSA 테이블 전용 성별 확인 함수 정의(생성)
--함수명 : FN_GENDER()
--                 ↑ SSN(주민등록번호) → '771212-1022432' → 'YYMMDD-NNNNN'


CREATE OR REPLACE FUNCTION FN_GENDER(V_SSN VARCHAR2 ) --함수 정의시 매개변수의 자릿수(길이) 지정 안함
RETURN VARCHAR2 --RETURN 반환자료형에도 길이를 명시하지 않는다.

IS
    --선언부 → 주요 변수 선언
    V_RESULT VARCHAR2(24);
BEGIN
    -- 실행부 → 연산 및 처리
    IF (SUBSTR(V_SSN,8,1) IN ('2','4'))
        THEN V_RESULT := '여자';
    ELSIF SUBSTR(V_SSN,8,1) IN ('1','3')
        THEN V_RESULT := '남자';
    ELSE
        V_RESULT := '성별확인불가';
    END IF;
    
    --결과값을 반환해야한다는것을 기억
    RETURN V_RESULT;
END;

--Function FN_GENDER이(가) 컴파일되었습니다.


--○임의의 정수 두개를 매개변수(입력 파라미터)로 넘겨받아 → (A,B)
-- A의 B승의 값을 반환하는 사용자 정의 함수를 작성한다.
--함수명 : FN_POW()

/*
사용 예)
SELECT FN_POW(10,3)
FROM DUAL;
--==>> 1000
*/

CREATE OR REPLACE FUNCTION FN_POW(NUM1 NUMBER , NUM2 NUMBER) --NUM1: 연산될 수 NUM2: 승수 
RETURN NUMBER

IS
    V_RESULT NUMBER := 1;      --V : Variable 변수라는 뜻
    V_SEUNG NUMBER;
BEGIN    
    FOR V_SEUNG IN 1..NUM2  LOOP  --초기 RESULT에 NUM1값을 넣었으므로 NUM2 -1
    V_RESULT := V_RESULT * NUM1;
    END LOOP;
    
    RETURN V_RESULT;
END;

--4번 Scott로 이동
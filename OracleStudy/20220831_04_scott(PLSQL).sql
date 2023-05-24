SELECT *
FROM TBL_INSA;

--○TBL_INSA 테이블을 대상으로 
-- 주민번호(SSN)를 가지고 성별을 조회한다.
SELECT NAME, SSN
      ,DECODE(SUBSTR(SSN,8,1), '1','남자','2','여자','3','남자','4','여자','성별확인불가') "성별"
FROM TBL_INSA;

SELECT NAME, SSN
      ,FN_GENDER(SSN) "성별"
FROM TBL_INSA;

--둘이 같은결과

SELECT FN_GENDER('940601-1024419') "성별확인"
FROM DUAL;


--3번 시트에서 정의한 함수 FN_POW 사용
SELECT FN_POW(2,5)
FROM DUAL;

--==>>32

SELECT *
FROM TBL_INSA;

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
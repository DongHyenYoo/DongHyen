SELECT USER
FROM DUAL;


--○EMPLOYEES 테이블의 직원들 SALARY를 10%인상해라
--  단 부서명이 'IT'인 직원들 한정.
-- (변경에 대한 결과 확인 후 ROLLBACK 수행)

SELECT E.DEPARTMENT_ID
FROM EMPLOYEES E JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE D.DEPARTMENT_NAME LIKE '%IT%';


UPDATE EMPLOYEES
SET SALARY = SALARY * 1.1
WHERE DEPARTMENT_ID IN (SELECT E.DEPARTMENT_ID
FROM EMPLOYEES E JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE D.DEPARTMENT_NAME LIKE 'IT%');

UPDATE EMPLOYEES
SET SALARY = SALARY * 1.1
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
FROM DEPARTMENTS D
WHERE DEPARTMENT_NAME LIKE 'IT%');


SELECT *
FROM EMPLOYEES;

ROLLBACK;

--○EMPLOYEES 테이블에서 JOB_TITLE이 Sales Manager인 사원들의
-- SALARY를 해당 직무(직종)의 최고급여(MAX_SALARY)로 수정한다.
--단 입사일이 2006년 이전(해당년도 제외) 입사자에 한해 적용
--변경 결과 확인후 ROLLBACK수행

SELECT *
FROM EMPLOYEES;
SELECT *
FROM JOBS;


--2006년 이전 입사자 + SALES MANAGER직책인 사원 ID찾기
SELECT E.EMPLOYEE_ID
FROM JOBS J JOIN EMPLOYEES E
ON J.JOB_ID = E.JOB_ID
WHERE TO_CHAR(E.HIRE_DATE,'YYYY') <2006
       AND J.JOB_TITLE='Sales Manager'
       

--MAX SALARY하나로 묶기
SELECT J.MAX_SALARY
FROM JOBS J JOIN EMPLOYEES E
ON J.JOB_ID = E.JOB_ID
WHERE TO_CHAR(E.HIRE_DATE,'YYYY') <2006
       AND J.JOB_TITLE='Sales Manager'
GROUP BY MAX_SALARY;




--2006이전 입사자로 묶기
SELECT TO_CHAR(E.HIRE_DATE,'YYYY')
FROM JOBS J JOIN EMPLOYEES E
ON J.JOB_ID = E.JOB_ID
WHERE J.JOB_TITLE='Sales Manager'
GROUP BY (TO_CHAR(E.HIRE_DATE,'YYYY'))
HAVING TO_NUMBER(TO_CHAR(E.HIRE_DATE,'YYYY'))<2006;


-- 업데이트

UPDATE EMPLOYEES
SET SALARY = (SELECT J.MAX_SALARY
FROM JOBS J JOIN EMPLOYEES E
ON J.JOB_ID = E.JOB_ID
WHERE TO_NUMBER(TO_CHAR(E.HIRE_DATE,'YYYY')) <2006
       AND J.JOB_TITLE='Sales Manager'
GROUP BY MAX_SALARY)

WHERE EMPLOYEE_ID IN (SELECT E.EMPLOYEE_ID
FROM JOBS J JOIN EMPLOYEES E
ON J.JOB_ID = E.JOB_ID
WHERE TO_CHAR(E.HIRE_DATE,'YYYY') <2006
       AND J.JOB_TITLE='Sales Manager');

ROLLBACK;


--○EMPLOYEES 테이블에서 SALARY를
-- 각 부서의 이름별로 다른 인상률을 적용하여 수정 할 수 있도록 한다.
--Finance -> 10%인상
--Excutive -> 15%인상
--Accounting -> 20%인상


SELECT DEPARTMENT_ID
FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'Finance';

--
UPDATE EMPLOYEES
SET SALARY = CASE DEPARTMENT_ID WHEN (SELECT DEPARTMENT_ID
                                    FROM DEPARTMENTS
                                    WHERE DEPARTMENT_NAME = 'Finance') 
                                    THEN SALARY*1.1
                             WHEN (SELECT DEPARTMENT_ID
                                    FROM DEPARTMENTS
                                    WHERE DEPARTMENT_NAME = 'Accounting') 
                                    THEN SALARY*1.2
                            WHEN (SELECT DEPARTMENT_ID
                                    FROM DEPARTMENTS
                                    WHERE DEPARTMENT_NAME = 'Excutive')  
                                    THEN SALARY*1.15
                            ELSE SALARY
                            END;
                            
                            

UPDATE EMPLOYEES
SET SALARY = CASE DEPARTMENT_ID WHEN (SELECT DEPARTMENT_ID
                                    FROM DEPARTMENTS
                                    WHERE DEPARTMENT_NAME = 'Finance') 
                                    THEN SALARY*1.1
                             WHEN (SELECT DEPARTMENT_ID
                                    FROM DEPARTMENTS
                                    WHERE DEPARTMENT_NAME = 'Accounting') 
                                    THEN SALARY*1.2
                            WHEN (SELECT DEPARTMENT_ID
                                    FROM DEPARTMENTS
                                    WHERE DEPARTMENT_NAME = 'Excutive')  
                                    THEN SALARY*1.15
                            ELSE SALARY
                            END
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
                        FROM DEPARTMENTS
                        WHERE DEPARTMENT_NAME IN('Finance','Executive','Accounting'));
                           

SELECT *
FROM DEPARTMENTS;

ROLLBACK;



---------------------------------------------------------------------------------
---■■■ DELETE ■■■------

--1.테이블에서 지정된 행(레코드)을 삭제하는 데 사용하는 구문

--2.형식 및 구조
--DELETE [FROM] 테이블명
-- [WHERE 조건절];


--테이블 복사(데이터 위주)
CREATE TABLE TBL_EMPLOYEES
AS
SELECT *
FROM EMPLOYEES;

SELECT *
FROM TBL_EMPLOYEES
WHERE EMPLOYEE_ID = 198;


DELETE 
FROM TBL_EMPLOYEES
WHERE EMPLOYEE_ID = 198;

ROLLBACK;


--○ EMPLOYEES 테이블에서 직원들의 데이터를 삭제한다.
-- 단, 부서명이 'IT'인 경우로 한정한다.

--※실제로는 EMPLOYEES 테이블의 데이터가(삭제하고자 하는 대상 데이터)
-- 다른 레코드에 의해 참조당하고 있는 경우
-- 삭제되지 않을 수 있다는 사실을 염두해야 하며...
-- 그에 대한 이유도 알아야 한다.

SELECT *
FROM TBL_EMPLOYEES;

SELECT *
FROM DEPARTMENTS;

SELECT DEPARTMENT_ID
FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'IT';

DELETE 
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                        FROM DEPARTMENTS
                        WHERE DEPARTMENT_NAME = 'IT');

ROLLBACK;

--==>EMPLOYEES 로 하면 에러발생
--ORA-02292: integrity constraint (HR.DEPT_MGR_FK) violated - child record found


---------------------------------------------------------------------------


--■■■ 뷰(VIEW) ■■■----


--1.뷰(VIEW)란 이미 특정한 데이터베이스 내에 존재하는
--  하나 이상의 테이블에서 사용자가 얻기 원하는 데이터들만을
--  정확하고 편하게 가져오기 위하여 사전에 원하는 컬럼들만을 모아서
--  만들어놓은 가상의 테이블로 편의성 및 보안에 목적이 있다.

--테이블 원본을 보여주는 방식은 보안상 굉장히 좋지않으므로
--view를 사용하면 사용자에게 노출시킬 레코드만 정해서 보여줄수있다.
--즉 실무에선 보안의 목적으로 VIEW가 많이 사용된다.
--단 테이블처럼 실제 데이터가 들어가있는것이 아닌 테이블에서 가져온 
--데이터들을 보여주는 쿼리문 일뿐임 즉 실행시키면 기존 테이블이 실행되는건
--같다.

--  가상의 테이블이란... 뷰가 실제로 존재하는 테이블(객체)이 아니라
--  하나 이상의 테이블에서 파생된 또 다른 정보를 볼 수 있는 방법이며
--  그 정보를 추출해내는 SQL 문장이라고 볼 수 있다.

--2. 형식 및 구조
--CREATE [OR REPLACE] VIEW 뷰이름
-- [(ALIAS[, ALIAS,...])]
--AS
--서브쿼리(SUBQUERY)
--[WITH CHECK OPTION]
--[WITH READ ONLY]


--○뷰(VIEW)생성
CREATE OR REPLACE VIEW VIEW_EMPLOYEES
AS
SELECT E.FIRST_NAME, E.LAST_NAME, D.DEPARTMENT_NAME, L.CITY
       , C.COUNTRY_NAME, R.REGION_NAME
FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L, COUNTRIES C, REGIONS R
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
    AND D.LOCATION_ID = L.LOCATION_ID
    AND L.COUNTRY_ID = C.COUNTRY_ID
    AND C.REGION_ID = R.REGION_ID;

--==>>View VIEW_EMPLOYEES이(가) 생성되었습니다.


--○뷰(VIEW)조회
SELECT *
FROM VIEW_EMPLOYEES;

--○ 가상으로 구성된 테이블이지만 뷰(VIEW)의 구조도 확인가능
DESC VIEW_EMPLOYEES;
/*
이름              널?       유형           
--------------- -------- ------------ 
FIRST_NAME               VARCHAR2(20) 
LAST_NAME       NOT NULL VARCHAR2(25) 
DEPARTMENT_NAME NOT NULL VARCHAR2(30) 
CITY            NOT NULL VARCHAR2(30) 
COUNTRY_NAME             VARCHAR2(40) 
REGION_NAME              VARCHAR2(25) 
*/

--○뷰(VIEW) 소스확인 -- CHECK!

SELECT VIEW_NAME, TEXT
FROM USER_VIEWS
WHERE VIEW_NAME = 'VIEW_EMPLOYEES';

/*
"SELECT E.FIRST_NAME, E.LAST_NAME, D.DEPARTMENT_NAME, L.CITY
       , C.COUNTRY_NAME, R.REGION_NAME
FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L, COUNTRIES C, REGIONS R
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
    AND D.LOCATION_ID = L.LOCATION_ID
    AND L.COUNTRY_ID = C.COUNTRY_ID
    AND C.REGION_ID = R.REGION_ID"
*/
--뷰를 생성할때 썻던 쿼리문이 그대로 나온다.
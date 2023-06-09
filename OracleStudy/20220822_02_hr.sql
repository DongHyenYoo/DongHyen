SELECT USER
FROM DUAL;




--○세 개 이상의 테이블 조인

--형식 1. (SQL 1992 CODE)

SELECT 테이블명1.컬럼명, 테이블명2.컬럼명, 테이블명3.컬럼명
FROM 테이블명1, 테이블명2, 테이블명3
WHERE 테이블명1.컬럼명1 = 테이블명2.컬럼명1
    AND 테이블명2.컬럼명2 = 테이블명3.컬럼명2;
    
    
    
--형식 2. (SQL 1999 CODE)

SELECT 테이블명1.컬럼명, 테이블명2.컬럼명, 테이블명3.컬럼명
FROM 테이블명1 JOIN 테이블명2 
ON 테이블명1.컬럼명1 = 테이블명2.컬럼명1
        JOIN 테이블명3
    ON 테이블명2.컬럼명2 = 테이블명3.컬럼명2;
    
    
SELECT *
FROM TAB;
/*
COUNTRIES	TABLE	
DEPARTMENTS	TABLE	
EMPLOYEES	TABLE	
EMP_DETAILS_VIEW	VIEW	
JOBS	TABLE	
JOB_HISTORY	TABLE	
LOCATIONS	TABLE	
REGIONS	TABLE	
*/

--○ HR.JOBS HR.EMPLOYEES, HR.DEPARTMENTS 테이블을 대상으로
-- 직원들의 데이터를
-- FIRST_NAME, LAST_NAME, JOB_TITLE, DEPARTMENT_NAME 항목으로 조회한다.

SELECT E.FIRST_NAME "성", E.LAST_NAME "이름", J.JOB_TITLE "직업", D.DEPARTMENT_NAME "부서명"
FROM JOBS J , EMPLOYEES E, DEPARTMENTS D
WHERE J.JOB_ID = E.JOB_ID    --각 테이블의 관계 컬럼
  AND E.DEPARTMENT_ID = D.DEPARTMENT_ID;   --각 테이블의 관계 컬럼

SELECT E.FIRST_NAME "성", E.LAST_NAME "이름", J.JOB_TITLE "직업", D.DEPARTMENT_NAME "부서명"
FROM JOBS J JOIN EMPLOYEES E
     ON J.JOB_ID = E.JOB_ID
     JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;

--==>> 106

SELECT COUNT(*)
FROM EMPLOYEES;
--107

SELECT COUNT(*)
FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;
--107

SELECT COUNT(*)
FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
        JOIN JOBS J
        ON E.JOB_ID = J.JOB_ID;
--107 E 와 D에서만 LEFT JOIN하면됨

SELECT E.FIRST_NAME "성", E.LAST_NAME "이름", J.JOB_TITLE "직업", D.DEPARTMENT_NAME "부서명"
FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
        JOIN JOBS J
        ON E.JOB_ID = J.JOB_ID;
        
        --JOIN할때 빠지는 데이터가 없는지 항상 확인하고 JOIN을 하는 법을 정하기
        
        
--○EMPLOYEES, DEPARTMENTS, JOBS, LOCATIONS, COUNTRIES, REGIONS 테이블을 대상으로
-- 직원들의 데이터를 다음과 같이 조회한다.
-- SFIRST_NAME, LAST_NAME, JOB_TITLE, DEPARTMENT_NAME, CITY
-- , COUNTRY_NAME, REGION_NAME

DESC EMPLOYEES
DESC countries
DESC DEPARTMENTS
DESC JOBS
DESC LOCATIONS
DESC COUNTRIES
DESC REGIONS;

SELECT E.FIRST_NAME, E.LAST_NAME, J.JOB_TITLE, D.DEPARTMENT_NAME, L.CITY, C.COUNTRY_NAME, R.REGION_NAME
FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
         JOIN JOBS J 
         ON E.JOB_ID = J.JOB_ID
                LEFT JOIN LOCATIONS L 
                ON D.LOCATION_ID = L.LOCATION_ID
                     LEFT JOIN COUNTRIES C
                     ON L.COUNTRY_ID = C.COUNTRY_ID
                            LEFT JOIN REGIONS R
                            ON C.REGION_ID = R.REGION_ID
ORDER BY E.EMPLOYEE_ID;


SELECT T.성, T.이름, T.직업, T.부서명 , L.CITY, C.COUNTRY_NAME, R.REGION_NAME
FROM
(
SELECT E.FIRST_NAME "성", E.LAST_NAME "이름" , J.JOB_TITLE "직업", D.DEPARTMENT_NAME "부서명", D.LOCATION_ID
FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
         JOIN JOBS J 
         ON E.JOB_ID = J.JOB_ID
         )T LEFT JOIN LOCATIONS L  ON T.LOCATION_ID = L.LOCATION_ID
            LEFT JOIN COUNTRIES C  ON L.COUNTRY_ID = C.COUNTRY_ID
            LEFT JOIN REGIONS R    ON C.REGION_ID = R.REGION_ID;


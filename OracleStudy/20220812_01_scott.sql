--※위의 구문은 IN 연산자를 활용하여
-- 다음과 같이 처리할 수 있으며
-- 위 구문의 처리결과와 같은 결과를 반환한다.

SELECT EMPNO "사원번호", ENAME "사원명", JOB"직종명",SAL"급여", DEPTNO "부서번호"
FROM EMP
WHERE DEPTNO IN (20, 30);

--○ EMP 테이블에서 직종이 CLERK 인 사원들의 데이터를 모두 조회한다.

SELECT *
FROM EMP
WHERE JOB='CLERK';    --DATA의 값은 대소문자 구분을 한다.

SELECT *
FROM EMP
WHERE JOB='clerk';    --DATA의 값은 대소문자 구분을 한다.
--조회 결과 없음 소문자라서


--○EMP 테이블에서 직종이 CLERK인 사원들 중에 20번 부서에 근무하는 사원들의 
--사원번호,사원명,직종명,급여,부서번호 항목을 조회한다.

SELECT *
FROM EMP;

SELECT EMPNO "사원번호",ENAME "사원명", JOB "직종명", SAL "급여", DEPTNO "부서번호"
FROM EMP
WHERE JOB = 'CLERK' AND DEPTNO = 20;
--처리 순서 FROM WHERE GROUP BY  HAVING SELECT ORDER BY 순서
--즉 WHERE에서는 SELECT에서 정의한 별칭을 알지못함
--FROM 에서 테이블을 가져오고 WHERE절의 조건에 맞는 행들만 메모리에 퍼올린다.
--그중 SELECT에서 필요한 칼럼들만 떼서 출력한다.
/*
7369	SMITH	CLERK	800	20
7876	ADAMS	CLERK	1100	20
*/

--○EMP 테이블의 구조와 데이터를 확인해서
 -- 이와 똑같은 데이터가 들어가있는 테이블의 구조를 생성한다.
 --(팀별로 .. EMP1, EMP2,EMP3,EMP4 로만든다.
 
 SELECT *
 FROM EMP;
 
 
 CREATE TABLE TBL_EMP
 AS
 SELECT*
 FROM EMP;     --이렇게쓰면 수작업 필요없이 그대로 복사해온다.
 /*
 CREATE TABLE EMP4
 (EMPNO NUMBER(4)
 ,ENAME VARCHAR2(10)
 ,JOB VARCHAR2(9)
 ,MGR NUMBER(4)
 ,HIREDATE DATE
 ,SAL NUMBER(7,2)
 ,COMM NUMBER(7,2)
 ,DEPTNO NUMBER(2)
 );*/



--○DEPT 테이블을 복사하여 위와 같이 TBL_DEPT 테이블을 생성한다.
CREATE TABLE TBL_DEPT
AS
SELECT *
FROM DEPT;
-->>Table TBL_DEPT 생성

--○복사한 테이블 확인
SELECT *
FROM TBL_DEPT;

--○테이블의 커멘트 정보 확인

SELECT *
FROM USER_TAB_COMMENTS;
--현재 코멘트는 전부 NULL

--○테이블 레벨의 커멘트 정보 입력
COMMENT ON TABLE TBL_EMP IS '사원 정보';

--○TBL_DEPT 테이블을 대상으로 테이블 레벨의 커멘트 데이터 입력
COMMENT ON TABLE TBL_DEPT IS '부서 정보';

--○커멘트 데이터 입력 후 확인
SELECT *
FROM USER_TAB_COMMENTS;

--○ 컬럼 레벨의 커멘트 데이터 확인 (COL)
SELECT *
FROM USER_COL_COMMENTS;

SELECT *
FROM USER_COL_COMMENTS
WHERE TABLE_NAME='TBL_DEPT';
/*
TBL_DEPT    	DEPTNO	
TBL_DEPT	    DNAME	
TBL_DEPT	    LOC	
*/

--○테이블에 소속된 컬럼에 대한 커멘트 데이터입력(설정)
COMMENT ON COLUMN TBL_DEPT.DEPTNO IS '부서 번호';
--==>>Comment이(가) 생성되었습니다.
COMMENT ON COLUMN TBL_DEPT.DNAME IS  '부서 이름';
--==>Comment이(가) 생성되었습니다.
COMMENT ON COLUMN TBL_DEPT.LOC IS '부서 위치';

SELECT *
FROM USER_COL_COMMENTS
WHERE TABLE_NAME='TBL_DEPT';

DESC TBL_EMP;

COMMENT ON COLUMN TBL_EMP.EMPNO IS '사원번호';
COMMENT ON COLUMN TBL_EMP.ENAME IS '사원명';
COMMENT ON COLUMN TBL_EMP.JOB IS '직종명';
COMMENT ON COLUMN TBL_EMP.MGR IS '관리자 사원번호';
COMMENT ON COLUMN TBL_EMP.HIREDATE IS '입사일';
COMMENT ON COLUMN TBL_EMP.SAL IS '급여';
COMMENT ON COLUMN TBL_EMP.COMM IS '수당';
COMMENT ON COLUMN TBL_EMP.DEPTNO IS '부서번호';

SELECT *
FROM USER_COL_COMMENTS
WHERE TABLE_NAME = 'TBL_EMP';


---■■■ 컬럼 구조의 추가 및 제거 ■■■-----

SELECT *
FROM TBL_EMP;

--○ TBL_EMP 테이블에 주민등록번호 데이터를 담을 수 있는 컬럼 추가
ALTER TABLE TBL_EMP 
ADD SSN CHAR(13);
--구조적으로 수정한다 /TABLE을 /TBL_EMP 라는/ 추가해서  /데이터 타입이 CHAR인 SSN이라는 이름의 칼럼을

SELECT '01035783912'
FROM DUAL;
--01035783912

SELECT 01035783912
FROM DUAL;
--1035783912

--○확인
DESC TBL_EMP;

/*
이름       널? 유형           
-------- -- ------------ 
EMPNO       NUMBER(4)    
ENAME       VARCHAR2(10) 
JOB         VARCHAR2(9)  
MGR         NUMBER(4)    
HIREDATE    DATE         
SAL         NUMBER(7,2)  
COMM        NUMBER(7,2)  
DEPTNO      NUMBER(2)    
SSN         CHAR(13) 
*/

-->SSN(주민등록 번호) 컬럼이 정상적으로 추가됨
--컬럼의 순서는 구조적으로 아무 의미가 없다.

--TBL_EMP 테이블에 추가한 SSN(주민등록번호) 컬럼 제거
ALTER TABLE TBL_EMP
DROP COLUMN SSN;
--구조적 수정/ TBL_EMP 라는 테이블을 / 지운다 COLUMN을 SSN이라는/
--컬럼의 입장에서는 제거되는 것이나 테이블의 입장에선 구조적 수정이기에 ALTER

SELECT *
FROM TBL_EMP;
--SSN 컬럼 삭제 확인

--DELETE TABLE명 해도 DROP과 달리 데이터만 삭제된다.
--테이블의 구조,뼈대는 존재한다.

DROP TABLE TBL_EMP;


--○테이블 다시 복사(생성)
CREATE TABLE TBL_EMP
AS
SELECT *
FROM EMP;


--○NULL 의 처리

SELECT 2, 10+2, 10-2, 10*2, 10/2
FROM DUAL;

SELECT NULL, NULL+2, NULL*2, NULL-2, NULL/2
FROM DUAL;
--==>>(NULL) (NULL) (NULL)   (NULL) (NULL)

--※관찰의 결과
-- NULL 은 상태의 값을 의미하며.. 실제 존재하지 않는 값이기 때문에
-- 이 NULL 이 연산에 포함될 경우...
-- 그 결과는 무조건 NULL 이다.

--○TBL_EMP 테이블에서 커미션(COMM,수당)이 NULL인 직원의
-- 사원명, 직종명, 급여, 커미션 항목조회

SELECT *
FROM USER_COL_COMMENTS
WHERE TABLE_NAME ='TBL_EMP';

SELECT *
FROM TBL_EMP;


SELECT ENAME "사원명",JOB "직종명", SAL "급여", COMM "커미션"
FROM TBL_EMP
WHERE COMM = null;
--조회 결과 x

SELECT ENAME "사원명",JOB "직종명", SAL "급여", COMM "커미션"
FROM TBL_EMP
WHERE COMM = (null);
--조회 결과 x


SELECT ENAME "사원명",JOB "직종명", SAL "급여", COMM "커미션"
FROM TBL_EMP
WHERE COMM IS NULL;
--NULL은 실제로 존재하는 값이 아니므로
--일반적인 연산자를 활용하여 비교할 수 없다.
--NULL을 대상으로 사용할 수 없는 연산자들
--  >=  ,   <=  ,>  ,<  , !=   [<>, ^=(둘이 같지않다)] 이렇게 못씀


--○TBL_EMP 테이블에서 20번 부서에 근무하지 않는 직원들의
-- 사원명, 직종명,부서번호 항목을 조회


SELECT ENAME "사원명", JOB "직종명", DEPTNO "부서번호" 
FROM TBL_EMP
WHERE DEPTNO !=20;

SELECT ENAME "사원명", JOB "직종명", DEPTNO "부서번호" 
FROM TBL_EMP
WHERE DEPTNO ^=20;

SELECT ENAME "사원명", JOB "직종명", DEPTNO "부서번호" 
FROM TBL_EMP
WHERE DEPTNO <>20;

/*
ALLEN	SALESMAN	30
WARD	SALESMAN	30
MARTIN	SALESMAN	30
BLAKE	MANAGER	30
CLARK	MANAGER	10
KING	PRESIDENT	10
TURNER	SALESMAN	30
JAMES	CLERK	30
MILLER	CLERK	10
셋다 같은 결과*/


--○ TBL_EMP 테이블에서 커미션이 NULL 이 아닌 직원들의
--사원명, 직종명, 급여, 커미션 항목 조회

SELECT ENAME, JOB, SAL, COMM
FROM TBL_EMP
WHERE COMM IS NOT NULL; -- ! = NOT 

SELECT ENAME, JOB, SAL, COMM
FROM TBL_EMP
WHERE NOT COMM IS NULL; -- ! = NOT 
/*
ALLEN	SALESMAN	1600	300
WARD	SALESMAN	1250	500
MARTIN	SALESMAN	1250	1400
TURNER	SALESMAN	1500	0
*/

--○TBL_EMP 테이블에서 모든 사원들의
--사원번호, 사원명, 급여,커미션, 연봉 항목을 조회한다.
--단 급여(SAL)는 매월 지급,
-- 또한 수당(COMM)은 연1회 지급하며, 연봉 내역에 포함된다.

ALTER TABLE TBL_EMP ADD YSAL NUMBER(10);

DESC TBL_EMP;

ALTER TABLE TBL_EMP DROP COLUMN YSAL;

SELECT EMPNO "사원번호", ENAME "사원명", SAL "급여", COMM "커미션", (SAL*12)+NVL(COMM,0) "연봉"
FROM TBL_EMP;
--COMM이 NULL이면 연봉이 NULL이 나오므로

--○NVL() --첫번째 파라미터가 NULL 이면 두번째 파라미터를 반환
          --첫번째 파라미터가 NULL이 아닐경우 첫번째 파라미터 반환
SELECT NULL "COL1", NVL(NULL,10) "COL2", NVL(5,10) "COL3"
FROM DUAL;
--(NULL)	10	5

SELECT EMPNO "사원번호", ENAME "사원명", SAL "급여", COMM "커미션", (SAL*12)+NVL(COMM,0) "연봉"
FROM TBL_EMP;

SELECT EMPNO "사원번호", ENAME "사원명", SAL "급여", COMM "커미션"
, NVL((SAL*12)+COMM,SAL*12) "연봉"
FROM TBL_EMP;

--○NVL2()
--첫 번째 파라미터 값이 NULL이 아닌 경우, 두번째 파라미터 값을 반환하고
--첫 번째 파라미터 값이 NULL인 경우, 세번째 파라미터 값을 반환한다.

SELECT ENAME "사원명", NVL2(COMM, '청기', '백기') "수당확인"
FROM TBL_EMP;
--NULL인 경우 백기 , 아닌경우 청기

--1
SELECT EMPNO "사원번호", ENAME "사원명", SAL "급여", COMM "커미션", NVL2(COMM,(SAL*12)+COMM,SAL*12) "연봉"
FROM TBL_EMP;

--2
SELECT EMPNO "사원번호", ENAME "사원명", SAL "급여", COMM "커미션", (SAL*12)+NVL2(COMM,COMM,0) "연봉"
FROM TBL_EMP;

--○ COALESCE()
-->매개변수의 갯수 제한이 없다.
--맨 앞에 있는 매개변수부터 차례로 NULL 인지 아닌지 확인하여
--NULL 이 아닐경우 반환, NULL인 경우 그다음 매개변수의 값을 반환한다.
--NVL() 이나 NVL2() 와 비교하여
--모~~~든 경우의 수를 고려할 수 있다는 특징을 가진다.

SELECT NULL "COL1"
,COALESCE(NULL,NULL,NULL,40) "COL2"
,COALESCE(NULL,NULL,30,NULL,NULL,60) "COL3"
FROM DUAL;
-- (null)  40  30  
--즉 NULL이 아닌값이 나올때까지 찾아보는듯 다만 NULL이 아닌것이 나오면 출력하고 종료

--○데이터 추가 입력
INSERT INTO TBL_EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO)
VALUES(8000,'김영준','SALESMAN',7369,SYSDATE,10);

INSERT INTO TBL_EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO,COMM)
VALUES(8000,'최나윤','SALESMAN',7369,SYSDATE,10,10);

COMMIT;

SELECT *
FROM TBL_EMP;


SELECT EMPNO "사원번호",ENAME "사원명", SAL "급여", COMM "커미션", COALESCE((SAL*12)+COMM,SAL*12,COMM,0) "연봉"
FROM TBL_EMP;

--○날짜에 대한 세션 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';


--○컬럼과 컬럼의 연결(결합)

SELECT 1,2
FROM DUAL;
--1,2
SELECT 1+2
FROM DUAL;
--3

SELECT '영관','킴'
FROM DUAL;

SELECT '영관'+'킴'
FROM DUAL;
--ORA-01722: invalid number 안됨

SELECT '영관'||'킴'
FROM DUAL;
--영관킴 

SELECT ENAME||'    '||JOB
FROM TBL_EMP;
/*
SMITHCLERK
ALLENSALESMAN
WARDSALESMAN
JONESMANAGER
MARTINSALESMAN
BLAKEMANAGER
CLARKMANAGER
SCOTTANALYST
KINGPRESIDENT
TURNERSALESMAN
ADAMSCLERK
JAMESCLERK
FORDANALYST
MILLERCLERK
김영준SALESMAN
최나윤SALESMAN
*/

SELECT '동현이는',SYSDATE,'에 연봉',500,'억을 원한다.'
FROM DUAL;
--동현이는//	2022-08-12 16:04:05	//에 연봉//	500//	억을 원한다.

SELECT SYSDATE, CURRENT_DATE,LOCALTIMESTAMP
FROM DUAL;
--2022-08-12 16:05:23	2022-08-12 16:05:23	22/08/12 16:05:23.000000000

SELECT '동현이는'||SYSDATE||'에 연봉'||500||'억을 원한다.'
FROM DUAL;
--동현이는2022-08-12 16:06:19에 연봉500억을 원한다.
--오라클에서는 문자타입의 형태로 형 변환하는 별도의 과정 없이
-- || 만 삽입해 주면 간단히 컬럼과 컬럼(서로 다른 종류의 데이터)을
-- 결합하는 것이 가능하다.
-- MSSQL 에서는 모든 데이터를 문자열로 CONVERT해야 한다.

--○TBL_DMP 테이블에서 다음과 같은 결과 얻을수 있는 쿼리문 작성
--SMITH의 현재 연봉은 9600인데 희망 연봉은 19200이다.
-- ALLEN의 현재 연봉은 19500인데 희망 연봉은 39000이다.

--단 레코드마다 위와 같은 내용이 한컬럼에 모두 조회될수 있도록 처리한다.

SELECT ENAME
      ||'의 현재 연봉은'
      ||COALESCE((SAL*12)+COMM,SAL*12,COMM,0)
      ||'인데 희망 연봉은'
      ||2*COALESCE((SAL*12)+COMM,SAL*12,COMM,0)
      ||'이다.'
FROM TBL_EMP;

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';


--○TBL_EMP 테이블의 데이터를 활용하여
-- 다음과 같은 결과를 얻을 수 있도록 쿼리문을 구성한다.
-- SMITH's 의 입사일은 1980-12-17이다 그리고 급여는 800이다. 처럼 나오게
-- ALLEN's 의 입사일은 1980-12-17이다 그리고 급여는 1600이다.

SELECT ENAME
       ||'''s 입사일은'
       ||HIREDATE
       ||'이다. 그리고 급여는 '
       ||SAL
       ||'이다.'
FROM TBL_EMP;
--※문자열을 나타내는 홀따옴표 사이의 홀따옴표 2개가 홀따옴표 한개를 의미하게 된다.
--홀따옴표 ' 한개는 문자열의 시작을 나타내고
--홀타옴표 ''두개는 문자열 영역 안에서 ' 한개를 나타낸다.

/*
SMITH's 입사일은1980-12-17이다. 그리고 급여는 800이다.
ALLEN's 입사일은1981-02-20이다. 그리고 급여는 1600이다.
WARD's 입사일은1981-02-22이다. 그리고 급여는 1250이다.
JONES's 입사일은1981-04-02이다. 그리고 급여는 2975이다.
MARTIN's 입사일은1981-09-28이다. 그리고 급여는 1250이다.
BLAKE's 입사일은1981-05-01이다. 그리고 급여는 2850이다.
CLARK's 입사일은1981-06-09이다. 그리고 급여는 2450이다.
SCOTT's 입사일은1987-07-13이다. 그리고 급여는 3000이다.
KING's 입사일은1981-11-17이다. 그리고 급여는 5000이다.
TURNER's 입사일은1981-09-08이다. 그리고 급여는 1500이다.
ADAMS's 입사일은1987-07-13이다. 그리고 급여는 1100이다.
JAMES's 입사일은1981-12-03이다. 그리고 급여는 950이다.
FORD's 입사일은1981-12-03이다. 그리고 급여는 3000이다.
MILLER's 입사일은1982-01-23이다. 그리고 급여는 1300이다.
김영준's 입사일은2022-08-12이다. 그리고 급여는 이다.
최나윤's 입사일은2022-08-12이다. 그리고 급여는 이다.
*/

--○ UPPER(), LOWER(), INITCAP() 
-- 전체 대문자, 전체소문자, 첫글자만 대문자로 변환후 나머지는 소문자로 변환 하고 반환

SELECT 'oRaCle' "COL1", UPPER('oracLe') "COL2" , LOWER('oRaCLe') "COL3" , INITCAP('oRaCle') "COL4"
FROM DUAL;

--○ TBL_EMP 테이블을 대상으로 검색값이 'sALeSmaN' 인 조건으로
--해당 직종 사원의 사원번호, 사원명, 직종명 조회

SELECT EMPNO "사원번호", ENAME "사원명", JOB "직종명"
FROM TBL_EMP
WHERE JOB = UPPER('sALeSmaN');

DESC TBL_EMP;

--추가 데이터 입력
INSERT INTO TBL_EMP(EMPNO, ENAME,JOB,MGR,HIREDATE,SAL,COMM)
VALUES(8002,'김태민','salesman',7369,SYSDATE,20,100);

COMMIT;

--○TBL_EMP 테이블을 대상으로 검색값이 'saLeSmAN'인 조건으로
-- 영업사월(세일즈맨)의 사원번호,사원명,직종명을 조회

SELECT EMPNO "사원번호", ENAME "사원명", INITCAP(JOB) "직종명" 
FROM TBL_EMP
WHERE INITCAP('saLeSmAN') = INITCAP(JOB);

--WHERE LOWER(JOB) = LOWER('saLeSmAN')

--○TBL_EMP 테이블에서 입사일이 1981년 9월 28일 입사한 직원의
--사원명, 직종명, 입사일 항목을 조회한다.
SELECT ENAME "사원명", JOB "직종명", HIREDATE "입사일"
FROM TBL_EMP
WHERE HIREDATE ='1981-09-28'; --이렇게 하는거 아님

--○TO_DATE()

SELECT ENAME "사원명", JOB "직종명", HIREDATE "입사일"
FROM TBL_EMP
WHERE HIREDATE = TO_DATE('1981-09-28','YYYY-MM-DD');
--문자타입을 날짜타입으로 변환해주는 함수
--==>>MARTIN SALESMAN 1981-09-28

--○TBL_EMP 테이블에서 입사일이 1981년 9월 28일 이후(해당일 포함)
--입사한 직원의 사원명, 직종명,입사일 항목을 조회한다.

SELECT ENAME, JOB, HIREDATE
FROM TBL_EMP
WHERE HIREDATE >= TO_DATE('1981-09-28','YYYY-MM-DD');
/*
MARTIN	SALESMAN	1981-09-28
SCOTT	ANALYST	1987-07-13
KING	PRESIDENT	1981-11-17
ADAMS	CLERK	1987-07-13
JAMES	CLERK	1981-12-03
FORD	ANALYST	1981-12-03
MILLER	CLERK	1982-01-23
김영준	SALESMAN	2022-08-12
최나윤	SALESMAN	2022-08-12
김태민	salesman	2022-08-12
*/

--※오라클에서는 날짜 데이터의 크기 비교가 가능하다.
--비교기준으로 미래가 더 큰값

--○TBL_EMP 테이블에서 입사일이 1981 4월 2일부터 
--1981년 9월 28일 사이에 입사한 직원들의 사원명,직종명,입사일 조회(해당일 포함)

SELECT ENAME, JOB, HIREDATE
FROM TBL_EMP
WHERE TO_DATE('1981-04-02','YYYY-MM-DD')<=HIREDATE AND HIREDATE<= TO_DATE('1981-09-28','YYYY-MM-DD');
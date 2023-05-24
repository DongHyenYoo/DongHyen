SELECT USER
from DUAL;

--SCOTT으로 접속됨

CREATE TABLE DEPT
( DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY
, DNAME VARCHAR2(14)
, LOC VARCHAR2(13) 
) ;


CREATE TABLE EMP
( EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY
, ENAME VARCHAR2(10)
, JOB VARCHAR2(9)
, MGR NUMBER(4)
, HIREDATE DATE
, SAL NUMBER(7,2)
, COMM NUMBER(7,2)
, DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT
);



INSERT INTO DEPT VALUES	(10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES	(30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES	(40,'OPERATIONS','BOSTON');

--1 행 이(가) 삽입되었습니다.*4


INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,to_date('13-7-1987','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,to_date('13-7-1987','dd-mm-yyyy'),1100,NULL,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,to_date('23-1-1982','dd-mm-yyyy'),1300,NULL,10);
--1 행 이(가) 삽입되었습니다. * 14

DROP TABLE BONUS;

CREATE TABLE BONUS
( ENAME VARCHAR2(10)
, JOB VARCHAR2(9)
, SAL NUMBER
, COMM NUMBER
);

--Bonus 생성

CREATE TABLE SALGRADE
( GRADE NUMBER
, LOSAL NUMBER
, HISAL NUMBER 
);


INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);

COMMIT;



--SCOTT 계정이 갖고있는 테이블 조회
SELECT *
FROM TAB;

/*
BONUS	TABLE	
DEPT	TABLE	
EMP	TABLE	
SALGRADE	TABLE	
*/

SELECT *
from user_tables;
/*
DEPT	USERS			VALID	10		1	255	65536	1048576	1	2147483645				YES	N									         1	         1	    N	ENABLED			NO		N	N	NO	DEFAULT	DEFAULT	DEFAULT	DISABLED	NO	NO		DISABLED	YES		DISABLED	DISABLED		NO	NO	YES	DEFAULT
EMP	USERS			VALID	10		1	255	65536	1048576	1	2147483645				YES	N									         1	         1	    N	ENABLED			NO		N	N	NO	DEFAULT	DEFAULT	DEFAULT	DISABLED	NO	NO		DISABLED	YES		DISABLED	DISABLED		NO	NO	YES	DEFAULT
BONUS	USERS			VALID	10		1	255	65536	1048576	1	2147483645				YES	N									         1	         1	    N	ENABLED			NO		N	N	NO	DEFAULT	DEFAULT	DEFAULT	DISABLED	NO	NO		DISABLED	YES		DISABLED	DISABLED		NO	NO	YES	DEFAULT
SALGRADE	USERS			VALID	10		1	255	65536	1048576	1	2147483645				YES	N									         1	         1	    N	ENABLED			NO		N	N	NO	DEFAULT	DEFAULT	DEFAULT	DISABLED	NO	NO		DISABLED	YES		DISABLED	DISABLED		NO	NO	YES	DEFAULT
*/

--○위에서 조회한 각각의 테이블들이
-- 어떤 테이블스페이스에 저장되어 있는지 조회
SELECT TABLE_NAME, TABLESPACE_NAME
FROM USER_TABLES;
/*
DEPT	USERS
EMP	USERS
BONUS	USERS
SALGRADE	USERS
*/

--○ 테이블 생성(TBL_EXAMPLE1)
CREATE TABLE TBL_EXAMPLE1
(NO NUMBER(4)
,NAME VARCHAR2(10)
,ADDR VARCHAR2(20)
);
--Table TBL_EXAMPLE1

--○테이블 생성(테이블 명: TBL_EXAMPLE2)
CREATE TABLE TBL_EXAMPLE2
(NO NUMBER(4)
,NAME VARCHAR2(20)
,ADDR VARCHAR2(20)
) TABLESPACE TBS_EDUA;
--Table TBL_EXAMPLE2이(가) 생성되었습니다.

--○TBL_EXAMPLE1 과 TBL_EXAMPLE2 테이블이
--  각각 어떤 테이블스페이스에 저장되어 있는지 조회
SELECT TABLE_NAME, TABLESPACE_NAME
FROM USER_TABLES;
/*
DEPT	USERS
EMP	USERS
BONUS	USERS
SALGRADE	USERS
TBL_EXAMPLE1        	USERS  테이블 뒤에 어디에 저장하겠다는지 지정 않함
TBL_EXAMPLE2	        TBS_EDUA 테이블 뒤에 어디에 저장하겠다했는지 지정
*/


---------------------------------------------------------
--↑이후 프로젝트시 sys에서 뭔가 필요한걸 꺼내쓸때 사용하라는 내용

---------------------------------------------------------
--이제 오라클 수업 시작

---■■■관계형 데이터베이스■■■------

--각각의 데이터를 테이블의 형태로 연결시켜 저장해 놓은 구조
--그리고 이들 각각의 테이블들 간의 관계를 설정하여 연결시켜 놓은 구조

/*============================
※SELECT 문의 처리(PARSING)순서

SELECT 컬럼명      ---⑤┐기본구조
FROM 테이블명      ---①┘
WHERE 조건절       ---②+
GROUP BY 절        ---③+  있을수 있고 없을수 있음
HAVING 조건절      ---④+
ORDER BY 절        ---⑥+

SELECT 컬럼1, 컬럼2, 컬럼4

WHERE 조건절
     (키가 170이상)
     (성별이 여성만) 
즉 한 컬럼에서 조건에 해당되는 행만 나오게 하는것

GROUP BY 절
    (서로 묶는것  성별이 여성인 사람과 남성인사람)
HAVING 조건
   GROUP BY 에서의 묶여있는 그룹에대한 조건
   
ORDER BY 절
       (정렬 기준)을 지정해 정렬을 수행하게 하는절
       
1-2-3-4-5-6 순서대로 외우고 쓸것

=============================*/

--○SCOTT 소유의 테이블 조회
SELECT *
FROM TAB;
/*
BONUS	TABLE   --보너스(BONUS) 데이터 테이블	
DEPT	TABLE	--부서(DEPARTMENTS) 데이터 테이블
EMP	TABLE	   --사원(EMPLOYEES) 데이터 테이블
SALGRADE	TABLE	 --급여(SAL) 데이터 테이블
TBL_EXAMPLE1	TABLE	
TBL_EXAMPLE2	TABLE	
*/

--○각 테이블의 데이터 조회
SELECT *
FROM BONUS;

SELECT *
FROM DEPT;
/*
10	ACCOUNTING	NEW YORK
20	RESEARCH	DALLAS
30	SALES	CHICAGO
40	OPERATIONS	BOSTON
*/
SELECT *
FROM EMP;
/*
7369	SMITH	CLERK	7902    	80/12/17	800		20
7499	ALLEN	SALESMAN	7698	81/02/20	1600	300	30
7521	    WARD	SALESMAN	7698	81/02/22	1250	500	30
7566	JONES	MANAGER	7839	81/04/02	2975		20
7654	MARTIN	SALESMAN	7698	81/09/28	1250	1400	30
7698	BLAKE	MANAGER	7839	81/05/01	2850		30
7782    	CLARK	MANAGER	7839	81/06/09	2450		10
7788	SCOTT	ANALYST	7566	87/07/13	3000		20
7839	KING	PRESIDENT		81/11/17	    5000		10
7844	TURNER	SALESMAN	7698	81/09/08	1500	0	30
7876	ADAMS	CLERK	7788	87/07/13	1100		20
7900    	JAMES	CLERK	7698	81/12/03	950		30
7902    	FORD	ANALYST	7566	81/12/03	3000		20
7934	MILLER	CLERK	7782	82/01/23	1300		10
*/

SELECT *
FROM SALGRADE;
/*
1	700	1200
2	1201	1400
3	1401	2000
4	2001	3000
5	3001	9999
*/

--DEPT 테이블에 존재하는 컬럼의 구조 조회
DESCRIBE DEPT;
/*
이름     널?       유형           
------ -------- ------------ 
DEPTNO NOT NULL NUMBER(2)    
DNAME           VARCHAR2(14) 
LOC             VARCHAR2(13)

NOT NULL = NULL이면 안된다.

--DEPTNO  DNAME    LOC
부서번호   부서명    부서위치
-----------------------------
--10     인사부     서울      ->데이터 입력 가능
--20                서울      ->데이터 입력 가능
--       인사부     서울      ->데이터 입력 불가능
*/

-------------------------------------------------
----■■■ 오라클의 주요 자료형(DATA TYPE)■■■----
/*

cf)MSSQL 서버의 정수 표현 타입

  smallint  -32,768 ~ 72,767 2Byte
  int  -21억 ~ 21억         4Byte
  bigint  엄청큼           8Byte
  
  MSSQL 서버의 실수 표현 타입
  float, real
  
  MSSQL 서버의 숫자 표현 타입
  decimal, numeric
  
  MSSQL 서버의 문자 표현 타입
  char, varchar,Nvarchar
  
  
  --※ ORACLE은 숫자 표현 타입이 한가지로 통일되어 있다.

 1.숫자형 NUMBER를 가장 많이쓴다.
   if NUMBER하고 표현길이를 안정해줬다면 -10 38승-1 ~ 10의 38승
   NUMBER(3) -> -999 ~ + 999
   NUMBER(4) -> -9999 ~ + 9999 까지 표현
   NUMBER(4,1) -> 4= 자리  1 = 소수점 몇번째자리까지 표현
              = -999.9 ~ + 999.9
              
 ※ORACLE의 문자 표현 타입
 
 2.문자형 CHAR        ->고정형 크기 (무조건 지정된 크기를 소모)
        CHAR(10)     ->'강의실' = 6바이트므로 10바이트 안에 담김
                     ->다만 Byte 낭비
        
         VARCHAR2    ->가변형 크기 (상황에따라 크기가 변경된다)
         VARCHAR2(10) <--'박원석' 이럴땐 6Byte만 소모하게된다.
         VARCHAR2(10) <--그렇다고 10바이트를 초과하게 되면 입력 불가능
         
         NCHAR       ->유니코드 기반 고정형 크기(글자 수)
        NCHAR(10)     =10글자
                    
         NVARCHAR2   ->유니코드 기반 가변형 크기(글자 수)
         NVARCHAR2(10) =10글자 들어갈수 있다.

 3.날짜형 DATE
 

*/

SELECT HIREDATE
FROM EMP;

DESCRIBE EMP;
--DESC EMP; 와 같은결과

--※ 날짜 형식에 대한 세션 설정 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
--Session이(가) 변경되었습니다.

SELECT HIREDATE
FROM EMP;
/*
1980-12-17
1981-02-20
1981-02-22
1981-04-02
1981-09-28
1981-05-01
1981-06-09
1987-07-13
1981-11-17
1981-09-08
1987-07-13
1981-12-03
1981-12-03
1982-01-23
*/

SELECT SYSDATE
FROM DUAL;
--2022-08-11 현재 시스템에 대한 DATE

--※ 날짜 형식에 대한 세션 설정 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS';
--Session이(가) 변경되었습니다.

SELECT SYSDATE
FROM DUAL;
--==>>2022-08-11 05:11:22

--※ 날짜 형식에 대한 세션 설정 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
--Session이(가) 변경되었습니다.


SELECT SYSDATE
FROM DUAL;
--2022-08-11 17:11:53

--EMP 테이블 에서 사원번호, 사원명, 급여, 커미션 데이터만 조회
DESC EMP;

SELECT *
FROM EMP;

SELECT EMPNO, ENAME, SAL, COMM 
FROM EMP;
--EMP테이블에서 부서번호가 20번인 직원들의 데이터들중
 --사원번호,사원명,직종명,급여,부서번호 조회
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = 20; --오라클에서는 =이 같다라는뜻
/*
7369	SMITH	CLERK	800	20
7566	JONES	MANAGER	2975	20
7788	SCOTT	ANALYST	3000	20
7876	ADAMS	CLERK	1100	20
7902	FORD	ANALYST	3000	20
*/

---AS " "를 쓰면 " "로 각 컬럼의 별칭을 제공할수있다. AS생략가능
SELECT EMPNO AS "사원번호", ENAME "사원명", JOB 직종명
FROM EMP;

--※테이블을 조회하는 과정에서
-- 각 컬럼의 이름에는 별칭(ALIAS)를 부여할 수 있다.
-- 기본 구분의 형식은 컬럼명 AS "별칭이름" 의 형태로 작성되며
-- 이때 AS는 생략이 가능하다.
-- 또한, 별칭 이름을 감싸는 ""도 생략이 가능하지만 앵간하면 안쓰는걸로
-- 생략하면 띄어쓰기 불가능
-- 공백의 등장은 해당 컬럼의 표현에 대한 종결을 의미함


--○EMP 테이블에서 부서번호가 20번과 30번 직원들의 데이터들중
-- 사원번호, 사원명,직종명,급여 부서번호 항목을 조회한다.
--단 별칭을 사용한다.

SELECT *
FROM EMP;

SELECT EMPNO "사원번호", ENAME "사원명", JOB "직종명", SAL "급여", DEPTNO "부서번호"
FROM EMP
WHERE DEPTNO =20 OR DEPTNO = 30;


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

SELECT *
FROM DEPT;
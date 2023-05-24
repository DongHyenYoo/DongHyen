--○TBL_EMP 테이블에서 입사일이 1981 4월 2일부터 
--1981년 9월 28일 사이에 입사한 직원들의 사원명,직종명,입사일 조회(해당일 포함)

SELECT *
FROM TBL_EMP;

SELECT ENAME, JOB, HIREDATE
FROM TBL_EMP
WHERE TO_DATE('1981-04-02','YYYY-MM-DD') <= HIREDATE 
      AND HIREDATE <= TO_DATE('1981-09-28','YYYY-MM-DD');

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';

--○Between A AND B

SELECT ENAME, JOB, HIREDATE
FROM TBL_EMP
WHERE HIREDATE BETWEEN TO_DATE('1981-04-02','YYYY-MM-DD') 
      AND TO_DATE('1981-09-28','YYYY-MM-DD');

/*
JONES	MANAGER	1981-04-02
MARTIN	SALESMAN	1981-09-28
BLAKE	MANAGER	1981-05-01
CLARK	MANAGER	1981-06-09
TURNER	SALESMAN	1981-09-08
*/

--○TBL_EMP 테이블에서 급여가 2450에서 3000사이의 직원들을 모두 조회

SELECT *
FROM TBL_EMP
WHERE SAL BETWEEN 2450 AND 3000;

--○TBL_EMP 테이블에서 'C'로 시작하는 이름부터 'S'로 시작하는 이름인경우
SELECT*
FROM TBL_EMP
WHERE ENAME BETWEEN 'C' AND 's';

--SMITH 나 SCOTT가 안나오는 이유는 둘다 사전적으로 S보다 뒤에 있기때문이고
--CLARK는 사전적으로 C보다 뒤에있기에 나온것

--※BETWEEN A AND B 는 날짜형 숫자형, 문자형 데이터 모두에 적용된다.
--단 문자형일 경우 아스키코드 순서를 따르기 때문에(사전식 배열)
-- 대문자가 앞쪽에 위치하고 소문자가 뒤쪽에 위치한다.
-- 또한 BETWEEN A AND B는 해당 구문이 수행되는 시점에서
-- 오라클 내부적으로는 부등호 연산자의 형태로 바뀌어 연산 처리된다.

--아스키 코드에 따르면 소문자는 대문자보다 이후에 있으므로
--이름이 대문자로 구성되있을경우 S로 시작하는 모든 이름을 나오게 하고싶다면
--아스키 코드에 따라 소문자 s 로 BETWEEN 'C' AND 's' 로 두면
--S로 시작하는 이름들이 나오게 된다.

SELECT ENAME, JOB, SAL
FROM TBL_EMP
WHERE JOB = 'SALESMAN'
    OR JOB = 'CLERK';

SELECT ENAME, JOB, SAL
FROM TBL_EMP
WHERE JOB IN ('SALESMAN','CLERK');

SELECT ENAME, JOB, SAL
FROM TBL_EMP
WHERE JOB =ANY ('SALESMAN','CLERK');
/*
SMITH	CLERK	800
ALLEN	SALESMAN	1600
WARD	SALESMAN	1250
MARTIN	SALESMAN	1250
TURNER	SALESMAN	1500
ADAMS	CLERK	1100
JAMES	CLERK	950
MILLER	CLERK	1300
김영준	SALESMAN	
최나윤	SALESMAN	

세개의 결과가 같다.
단 세개중 OR 쿼리문이 가장 빠르게 처리된다.
물론 메모리에 대한 내용이 아닌 CPU에 대한 내용일뿐
이 부분까지 감안해 쿼리문을 구성하는경우는 거의없고
INT = ANY 모두 OR로 변경되어 연산처리됨
*/

DROP TABLE TBL_SAWON;

PURGE RECYCLEBIN;

--○추가 실습 테이블 구성(TBL_SAWON)
CREATE TABLE TBL_SAWON
(SANO NUMBER(4)
,SANAME VARCHAR2(30)
,JUBUN CHAR(13)
,HIREDATE DATE DEFAULT SYSDATE
,SAL NUMBER(10)
);

--생성된 테이블에 데이터입력(TBL_SAWON)
INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1001, '고연수', '9409252234567', TO_DATE('2005-01-03', 'YYYY-MM-DD'), 3000);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1002, '김보경', '9809022234567', TO_DATE('1999-11-23', 'YYYY-MM-DD'), 2000);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1003, '정미경', '9810092234567', TO_DATE('2006-08-10', 'YYYY-MM-DD'), 4000);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1004, '김인교', '9307131234567', TO_DATE('1998-05-13', 'YYYY-MM-DD'), 2000);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1005, '이정재', '7008161234567', TO_DATE('1998-05-13', 'YYYY-MM-DD'), 1000);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1006, '아이유', '9309302234567', TO_DATE('1999-10-10', 'YYYY-MM-DD'), 3000);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1007, '이하이', '0302064234567', TO_DATE('2010-10-23', 'YYYY-MM-DD'), 4000);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1008, '인순이', '6807102234567', TO_DATE('1998-03-20', 'YYYY-MM-DD'), 1500);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1009, '선동렬', '6710261234567', TO_DATE('1998-03-20', 'YYYY-MM-DD'), 1300);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1010, '선우용녀', '6511022234567', TO_DATE('1998-12-20', 'YYYY-MM-DD'), 2600);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1011, '선우선', '0506174234567', TO_DATE('2011-10-10', 'YYYY-MM-DD'), 1300);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1012, '남궁민', '0102033234567', TO_DATE('2010-10-10', 'YYYY-MM-DD'), 2400);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1013, '남진', '0210303234567', TO_DATE('2011-10-10', 'YYYY-MM-DD'), 2800);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1014, '반보영', '9903142234567', TO_DATE('2012-11-11', 'YYYY-MM-DD'), 5200);

INSERT INTO TBL_SAWON(SANO, SANAME, JUBUN, HIREDATE, SAL)
VALUES(1015, '한은영', '9907292234567', TO_DATE('2012-11-11', 'YYYY-MM-DD'), 5200);
COMMIT;


SELECT *
FROM TBL_SAWON;
/*
1001	고연수	    940925 2234567	2005-01-03	3000
1002	김보경	    980902 2234567	1999-11-23	2000
1003	정미경	    981009 2234567	2006-08-10	4000
1004	김인교	    930713 1234567	1998-05-13	2000
1005	이정재	    700816 1234567	1998-05-13	1000
1006	아이유	    930930 2234567	1999-10-10	3000
1007	이하이	    030206 4234567	2010-10-23	4000
1008	인순이	    680710 2234567	1998-03-20	1500
1009	선동렬	    671026 1234567	1998-03-20	1300
1010	선우용녀	    651102 2234567	1998-12-20	2600
1011	선우선	    050617 4234567	2011-10-10	1300
1012	남궁민	    010203 3234567	2010-10-10	2400
1013	남진	        021030 3234567	2011-10-10	2800
1014	반보영	    990314 2234567	2012-11-11	5200
1015	한은영	    990729 2234567	2012-11-11	5200
*/

--○고연수 데이터 조회
SELECT *
FROM TBL_SAWON
WHERE SANAME = '고연수';

SELECT *
FROM TBL_SAWON
WHERE SANAME LIKE '고연수';
--1001	고연수	9409252234567	2005-01-03	3000

--LIKE : 부사 -> ~와같이 ,~처럼

--WILD CARD(CHARACTER) -> %
-- LIKE와 함께 사용되는 % 는 모든 글자를 의미한다.
-- LIKE와 함께 사용되는 _ 는 아무글자 한개를 의미한다.

--※TBL_SAWON에서 성씨가 고 씨인 사원의 
-- 사원명 주민번호 급여 항목을 조회한다.
SELECT SANAME, JUBUN, SAL
FROM TBL_SAWON
WHERE SANAME LIKE '고__';

SELECT SANAME, JUBUN, SAL
FROM TBL_SAWON
WHERE SANAME LIKE '고%';
--글자가 뒤에 없어도 몇글자가 되도 상관없다는 %

--○TBL_SAWON 에서 성씨가 이 씨인 사원의 
--사원명,주민번호,급여 항목 조회

SELECT SANAME,JUBUN,SAL
FROM TBL_SAWON
WHERE SANAME LIKE '이%';
/*
이정재	7008161234567	1000
이하이	0302064234567	4000
*/

--○TBL_SAWON 테이블에서 사원의 이름이 영으로 끝나느 사원의
-- 사원명,주민번호,급여 항목 조회
SELECT SANAME, JUBUN, SAL
FROM TBL_SAWON
WHERE SANAME LIKE '__영';
--%영 해도 같은결과 나옴
/*
반보영	9903142234567	5200
한은영	9907292234567	5200
*/


--○TBL_SAWON에 추가데이터
DESC TBL_SAWON;
INSERT INTO TBL_SAWON(SANO,SANAME,JUBUN,HIREDATE,SAL)
VALUES(1016,'이이경','0605063234567',TO_DATE('2015-01-20','YYYY-MM-DD'),1500);

SELECT *
FROM TBL_SAWON;

COMMIT;


--○TBL_SAWON 테이블에서 사원의 이름에 이라는 글자가
-- 하나라도 포함되어 있다면 그 사원의 
-- 사원번호,사원명,급여항목 조회

SELECT SANO,SANAME,SAL
FROM TBL_SAWON
WHERE SANAME LIKE '%이%';
/*
1005	이정재	1000
1006	아이유	3000
1007	이하이	4000
1008	인순이	1500
1016	이이경	1500
*/

--○TBL_SAWON 테이블에서 사원의 이름에 이 라는 글자가 두번 들어있는 사원의
-- 사원번호,사원명,급여 항목 조회
SELECT SANO,SANAME,SAL
FROM TBL_SAWON
WHERE SANAME LIKE '%이%이%';
/*
1007	이하이	4000
1016	이이경	1500
*/

--○TBL_SAWON 테이블에서 사원의 이름에 이 라는 글자가
--연속으로 두번 들어있는 사원의
--사원번호,사원명,급여 항목을 조회한다.
SELECT SANO,SANAME,SAL
FROM TBL_SAWON
WHERE SANAME LIKE '%이이%';

--사원 중간이름이 보 인 사원의 데이터 검색
SELECT SANO,SANAME,SAL
FROM TBL_SAWON
WHERE SANAME LIKE '_보_';

SELECT SANO,SANAME,SAL
FROM TBL_SAWON
WHERE SANAME LIKE '_보%'; --외자 세글자 전부 가능
/*
1002	김보경	2000
1014	반보영	5200
*/

--○TBL_SAWON에서 성씨가 선 씨인 사원의 데이터 

SELECT SANO,SANAME,SAL
FROM TBL_SAWON
WHERE SANAME LIKE '선%';
--선우 는 선우가 성이므로 이럴경우를 대비해
--테이블에서 성컬럼과 이름컬럼을 분리해서 구성하는게 좋다


--○TBL_SAWON 테이블에서 여직원들의 
--사원명, 주민번호,급여 항목을 조회한다.

SELECT *
FROM TBL_SAWON;

SELECT SANAME,JUBUN,SAL
FROM TBL_SAWON
WHERE JUBUN LIKE '______2%' 
     OR JUBUN LIKE '______4%';

SELECT SANAME,JUBUN,SAL
FROM TBL_SAWON
WHERE JUBUN NOT LIKE '______1______' 
AND NOT JUBUN LIKE '______3______';
/*
고연수	9409252234567	3000
김보경	9809022234567	2000
정미경	9810092234567	4000
아이유	9309302234567	3000
이하이	0302064234567	4000
인순이	6807102234567	1500
선우용녀	6511022234567	2600
선우선	0506174234567	1300
반보영	9903142234567	5200
한은영	9907292234567	5200
*/

--○실습 테이블 생성(TBL_WATCH)

CREATE TABLE TBL_WATCH
( WATCH_NAME VARCHAR2(20) 
, BIGO       VARCHAR2(100)
);

INSERT INTO TBL_WATCH(WATCH_NAME,BIGO)
VALUES('금시계','순금 99.99% 함유된 최고급 시계');

INSERT INTO TBL_WATCH(WATCH_NAME,BIGO)
VALUES('은시계','고객 만족도 99.99점을 획득한 최고의 시계');

COMMIT;

SELECT *
FROM TBL_WATCH;

--○TBL_WATCH 테이블의 BIGO 컬럼에서
-- 99.99% 라는 글자가 포함된 행의 데이터를 조회

SELECT *
FROM TBL_WATCH
WHERE BIGO LIKE '%99.99\%%' ESCAPE '\';
--\다음에 오는문자를 wild card에서 탈출시켜라 라는 의미
--$,@ 등 대부분의 특수문자 뭐로든 가능하다. 다만 쿼리문에서
--사용하지 않는 특수문자를 쓰는게 좋다.

--※ESCAPE로 정한 문자의 다음 한글자를 와일드 카드에서 탈출시켜라..
--일반적으로 사용 빈도가 낮은 특수문자(특수기호)를 사용한다.


---------------------------------------------------------

---■■■ COMMIT / ROLLBACK ■■■---
SELECT *
FROM TBL_DEPT;
/*
10	ACCOUNTING	NEW YORK
20	RESEARCH	DALLAS
30	SALES	CHICAGO
40	OPERATIONS	BOSTON
*/

--○데이터 입력
INSERT INTO TBL_DEPT VALUES(50,'개발부','서울');
--이렇게 사용할시 하나를 빼고 넣거나 그렇게 할 수 없다.
/*
10	ACCOUNTING	NEW YORK
20	RESEARCH	DALLAS
30	SALES	CHICAGO
40	OPERATIONS	BOSTON
50	개발부	서울
*/

--50번 개발부 서울..
--이 데이터는 TBL_dEPT 테이블이 저장되어 있는
-- 하드디스크상에 물리적으로 적용되어 저장된 것이 아니다.
--메모리(RAM)상에 입력된 것이다.

--○롤백
ROLLBACK;

SELECT *
FROM TBL_DEPT;
/*
10	ACCOUNTING	NEW YORK
20	RESEARCH	DALLAS
30	SALES	CHICAGO
40	OPERATIONS	BOSTON
*/
-->50번 개발부 서울 에대한 데이터가 소실

--○다시 데이터입력
INSERT INTO TBL_DEPT VALUES(50, '개발부','서울');

SELECT *
FROM TBL_DEPT;

--50번 개발부 서울..
--이 데이터는 TBL_dEPT 테이블이 저장되어 있는
-- 하드디스크상에 물리적으로 적용되어 저장된 것이 아니다.
--메모리(RAM)상에 입력된 것이다. 이걸 실제 하드디스크상에 물리적으로 저장하기 위해서는
--COMMIT를 수행해야 한다.

--커밋
COMMIT;

ROLLBACK;

SELECT *
FROM TBL_DEPT;
--ROLLBACK을 수행했읍에도
--50번 개발부 서울 의 데이터는 없어지지 않았다.

--※COMMIT을 실행한 이후로 DML 구문(INSERT, UPDATE,DELETE)을 통해
--변경된 데이터를 취소할 수 있는 것일뿐..
--DML 명령을 사용한후 COMMIT을 수행하고 나서 ROLLBACK을 실행해도
--아무것도 변하지 않는다.

--○데이터 수정(UPDATE -> TBL_DEPT)

UPDATE TBL_DEPT  --1
SET DNAME = '연구부', LOC = '경기' --3
WHERE DEPTNO = 50; --50인 행을 찾아서 메모리에 퍼올린다. --2
--1 행 이(가) 업데이트되었습니다.
--WHERE가 없을경우 모든 DNAME이 연구부로 바뀌고 모든 LOC가 경기로 바뀐다.

ROLLBACK;
--롤백

UPDATE TBL_DEPT  --1
SET DNAME = '연구부', LOC = '인천' --3
WHERE DEPTNO = 50; --50인 행을 찾아서 메모리에 퍼올린다. --2

SELECT *
FROM TBL_DEPT;

COMMIT;

--○데이터 삭제(DELETE -> TBL_DEPT)

SELECT *
FROM TBL_DEPT
WHERE DEPTNO = 50;

DELETE 
FROM TBL_DEPT
WHERE DEPTNO = 50;

ROLLBACK;

SELECT *
FROM TBL_DEPT
WHERE DEPTNO = 50;

COMMIT;
--하드디스크에서 삭제

--■■■ ORDER BY 절 ■■■----

SELECT ENAME "사원명", DEPTNO "부서번호", JOB "직종", SAL "급여"
      ,SAL*12+NVL(COMM,0) "연봉"
FROM EMP;
/*
SMITH	20	CLERK	800	9600
ALLEN	30	SALESMAN	1600	19500
WARD	30	SALESMAN	1250	15500
JONES	20	MANAGER	2975	35700
MARTIN	30	SALESMAN	1250	16400
BLAKE	30	MANAGER	2850	34200
CLARK	10	MANAGER	2450	29400
SCOTT	20	ANALYST	3000	36000
KING	10	PRESIDENT	5000	60000
TURNER	30	SALESMAN	1500	18000
ADAMS	20	CLERK	1100	13200
JAMES	30	CLERK	950	11400
FORD	20	ANALYST	3000	36000
MILLER	10	CLERK	1300	15600
*/
SELECT ENAME "사원명", DEPTNO "부서번호", JOB "직종", SAL "급여"
      ,SAL*12+NVL(COMM,0) "연봉"
FROM EMP
ORDER BY DEPTNO ASC; --ASC(오름차순)
--DEPTNO = 정렬기준 : 부서번호
--ASC = 정렬유형 : 오름차순
/*
CLARK	10	MANAGER	2450	29400
KING	10	PRESIDENT	5000	60000
MILLER	10	CLERK	1300	15600
JONES	20	MANAGER	2975	35700
FORD	20	ANALYST	3000	36000
ADAMS	20	CLERK	1100	13200
SMITH	20	CLERK	800	9600
SCOTT	20	ANALYST	3000	36000
WARD	30	SALESMAN	1250	15500
TURNER	30	SALESMAN	1500	18000
ALLEN	30	SALESMAN	1600	19500
JAMES	30	CLERK	950	11400
BLAKE	30	MANAGER	2850	34200
MARTIN	30	SALESMAN	1250	16400
*/
SELECT ENAME "사원명", DEPTNO "부서번호", JOB "직종", SAL "급여"
      ,SAL*12+NVL(COMM,0) "연봉"
FROM EMP
ORDER BY DEPTNO; --ASC(오름차순) 생략가능

SELECT ENAME "사원명", DEPTNO "부서번호", JOB "직종", SAL "급여"
      ,SAL*12+NVL(COMM,0) "연봉"
FROM EMP
ORDER BY DEPTNO DESC; --(내림차순)
/*
BLAKE	30	MANAGER	2850	34200
TURNER	30	SALESMAN	1500	18000
ALLEN	30	SALESMAN	1600	19500
MARTIN	30	SALESMAN	1250	16400
WARD	30	SALESMAN	1250	15500
JAMES	30	CLERK	950	11400
SCOTT	20	ANALYST	3000	36000
JONES	20	MANAGER	2975	35700
SMITH	20	CLERK	800	9600
ADAMS	20	CLERK	1100	13200
FORD	20	ANALYST	3000	36000
KING	10	PRESIDENT	5000	60000
MILLER	10	CLERK	1300	15600
CLARK	10	MANAGER	2450	29400
*/

SELECT ENAME "사원명", DEPTNO "부서번호", JOB "직종", SAL "급여"
      ,SAL*12+NVL(COMM,0) "연봉"
FROM EMP
ORDER BY 연봉 DESC; --(내림차순)
--SELECT 이후 ORDER BY 가 수행되어 명칭을 인식할수 있으므로
--명칭을 기준으로 정렬할 수 있다.

SELECT ENAME "사원명", DEPTNO "부서번호", JOB "직종", SAL "급여"
      ,SAL*12+NVL(COMM,0) "연봉"
FROM EMP
ORDER BY 2; --SELECT에서 처리한 2번째 컬럼을 의미한다.
         --즉 부서번호를 기준으로 오름차순 정렬을 해라는 의미가 된다.
-->EMP테이블이 가지고 있는 테이블의 고유한 컬럼의 순서가 아니다
-->SELECT에서 처리한 두번째 컬럼인 DEPTNO를 의미하는 것
-->EMP테이블의 2번째 컬럼은 ENAME로 사원이름이다. 
--ORDER BY DEPTNO ASC와 같다.

SELECT ENAME, DEPTNO, JOB , SAL
FROM EMP
ORDER BY 2, 4;
--부서번호를 기준으로 1차정렬 급여를 기준으로 2차정렬을 수행한다.

SELECT ENAME, DEPTNO, JOB , SAL
FROM EMP
ORDER BY 2,3,4 DESC;
--부서번호를 기준으로 1차 오름차순 정렬 
--직종을 기준으로 2차 오름차순 정렬을 
--급여를 기준으로 내림차순 정렬
--DESC는 급여에만 해당된다.

--○CONCAT()

SELECT ENAME || JOB "첫번째 컬럼"
      , CONCAT(ENAME, JOB) "두번째 컬럼"
FROM EMP;
--문자열 기반으로 데이터 결합을 수행하는 함수 CONCAT()
--오로지 2개의 문자열만 결합시킬 수 있다.

SELECT ENAME||JOB||DEPTNO "첫번쨰컬럼"
,     CONCAT(CONCAT(ENAME,JOB), DEPTNO) "두번째칼럼"
FROM EMP;
--하지만 중첩으로 극복!
/*
SMITHCLERK20	SMITHCLERK20
ALLENSALESMAN30	ALLENSALESMAN30
WARDSALESMAN30	WARDSALESMAN30
JONESMANAGER20	JONESMANAGER20
MARTINSALESMAN30	MARTINSALESMAN30
BLAKEMANAGER30	BLAKEMANAGER30
CLARKMANAGER10	CLARKMANAGER10
SCOTTANALYST20	SCOTTANALYST20
KINGPRESIDENT10	KINGPRESIDENT10
TURNERSALESMAN30	TURNERSALESMAN30
ADAMSCLERK20	ADAMSCLERK20
JAMESCLERK30	JAMESCLERK30
FORDANALYST20	FORDANALYST20
MILLERCLERK10	MILLERCLERK10
*/

-->내부적인 형 변환이 일어나며 결합을 수행하게 된다.
--CONCAT()은 문자열과 문자열을 결합시켜주는 함수이지만
--내부적으로 숫자나 날짜를 문자로 바꾸어주는 과정이 포함되어 있다.

--○SUBSTR()= 갯수기반 / SUBSTRB() = 바이트 기반(이때 인코딩을 조심)
--자바의 obj.substring()
----
--문자열.subString(n,m);
--  문자열의 n부터 m-1까지..(인덱스는 0부터)

SELECT ENAME "COL1"
      ,SUBSTR(ENAME,1,2)"COL2" --ENAME의 1번 인덱스부터 2개라는뜻
FROM EMP;
-->문자열을 추출하는 기능을 가진 함수
-- 첫번째 파라미터 값은 대상 문자열(추출의 대상, TARGET)
-- 두번째 파라미터 값은 추출을 시작하는 위치(인덱스,START) 인덱스는 1부터시작
-- 세번째 파라미터 값은 추출할 문자열의 개수(갯수,COUNT) -> 생략시 문자열의 길이 끝까지

SELECT ENAME "COL1"
      ,SUBSTR(ENAME,3,2)"COL2"
      ,SUBSTR(ENAME,3,5)"COL3"
      ,SUBSTR(ENAME,3)"COL4"
      ,SUBSTR(ENAME,6,1)"COL5"
FROM EMP;

/*
SMITH	IT	ITH	    ITH	
ALLEN	LE	LEN	    LEN	
WARD	RD	RD	    RD	
JONES	NE	NES	    NES	
MARTIN	RT	RTIN	RTIN	N
BLAKE	AK	AKE	    AKE	
CLARK	AR	ARK	    ARK	
SCOTT	OT	OTT	    OTT	
KING	NG	NG	    NG	
TURNER	RN	RNER	RNER	R
ADAMS	AM	AMS	    AMS	
JAMES	ME	MES	    MES	
FORD	RD	RD	    RD	
MILLER	LL	LLER	LLER	R
*/

--○TBL_SAWON 테이블에서 성별이 남성인 사원만
 -- 사원번호, 사원명, 주민번호, 급여 항목을 조회한다.
 -- SUBSTR()함수 이용할것
 SELECT SANO,SANAME,JUBUN,SAL
 FROM TBL_SAWON
 WHERE SUBSTR(JUBUN,7,1) IN ('1','3'); 
 
  SELECT SANO,SANAME,JUBUN,SAL
 FROM TBL_SAWON
 WHERE SUBSTR(JUBUN,7,1) =ANY ('1','3');
 
 --○LENGTH() 글자수 반환 / LENGTHB() 바이트 수를 반환
 
 SELECT ENAME "COL1"
       ,LENGTH(ENAME) "COL2"
       ,LENGTHB(ENAME) "COL3"
 FROM EMP;
 
 
 --○INSTR()
 
 SELECT 'ORACLE ORAHOME BIORA' "COL1"
        , INSTR('ORACLE ORAHOME BIORA','ORA',1,1)"COL2"
        , INSTR('ORACLE ORAHOME BIORA','ORA',1,2)"COL3"
        , INSTR('ORACLE ORAHOME BIORA','ORA',2,1)"COL4"
        , INSTR('ORACLE ORAHOME BIORA','ORA',2)"COL5"
        , INSTR('ORACLE ORAHOME BIORA','ORA',2,3)"COL6" --3번째는 없으니까 0을 반환한다.
FROM DUAL;
-->첫 번째 파라미터 값에 해당하는 문자열에서..(대상 문자열, TARGET)
--두 번째 파라미터 값을 통해 넘겨준 문자열이 등장하는 위치를 찾아라~!!!
--세번째 파라미터 값은 찾기 시작하는 위치
--네 번째 파라미터 값은 몇 번째 등장하는 값을 찾을것인지에 대한 설정(->1은 생략 가능)
--이후 찾은 인덱스 값을 반환한다.

SELECT '나의오라클 집으로오라 합니다.' "COL1"
       ,INSTR('나의오라클 집으로오라 합니다.','오라',1)"COL2"
       ,INSTR('나의오라클 집으로오라 합니다.','오라',2)"COL3"
       ,INSTR('나의오라클 집으로오라 합니다.','오라',10)"COL4"
       ,INSTR('나의오라클 집으로오라 합니다.','오라',11)"COL5"
FROM DUAL;
--3	 3	10	0

--○REVERSE()

SELECT 'ORACLE' "COL1"
       ,REVERSE('ORACLE') "COL2"
FROM DUAL;
--단 한글은 뒤집을 수 없다. 한글은 한문자가 1바이트가 아니기에
--ORACLE	ELCARO

--○TBL_FILES 실습용 테이블 생성
CREATE TABLE TBL_FILES
(FILENO NUMBER(3)
,FILENAME VARCHAR2(100)
);

--○데이터 입력(TBL_FILES)
INSERT INTO TBL_FILES VALUES(1,'C:\AAA\BBB\CCC\SALES.DOC');
INSERT INTO TBL_FILES VALUES(2,'C:\AAA\PANMAE.XXLS');
INSERT INTO TBL_FILES VALUES(3,'D:\RESEARCH.PPT');
INSERT INTO TBL_FILES VALUES(4,'C:\DOCUMENTS\STUDY.HWP');
INSERT INTO TBL_FILES VALUES(5,'C:\DOCUMENTS\TEMP\HOMEWORK\SQL.TXT');
INSERT INTO TBL_FILES VALUES(6,'C:\SHARE\F\TEST\FLOWER.PNG');
INSERT INTO TBL_FILES VALUES(7,'E:\STUDY\ORACLE\20220816_01_SCOTT.SQL');

COMMIT;

SELECT FILENO "파일번호"
      ,FILENAME "파일명"
FROM TBL_FILES;
/*
1	C:\AAA\BBB\CCC\SALES.DOC
2	C:\AAA\PANMAE.XXLS
3	D:\RESEARCH.PPT
4	C:\DOCUMENTS\STUDY.HWP
5	C:\DOCUMENTS\TEMP\HOMEWORK\SQL.TXT
6	C:\SHARE\F\TEST\FLOWER.PNG
7	E:\STUDY\ORACLE\20220816_01_SCOTT.SQL
*/

--○TBL_FILES 테이블을 조회하여
-- 다음과 같은 결과를 얻을 수 있도록 쿼리문을 구성한다.

SELECT FILENO "파일번호"
      ,REVERSE(SUBSTR(REVERSE(FILENAME),1,INSTR(REVERSE(FILENAME),'\',1)-1)) "파일명"
FROM TBL_FILES;

SELECT FILENO "파일번호"
      ,SUBSTR(FILENAME,INSTR(FILENAME,'\',-1)+1) "파일명" --Index값은 양수가 나온다.
FROM TBL_FILES;



SELECT USER
FROM DUAL;

SELECT JECODE , COUNT(*)
FROM 
(SELECT *
FROM TBL_JUMUN
UNION ALL
SELECT *
FROM TBL_JUMUNBACKUP
)T
GROUP BY JECODE;

--○지금까지 주문받은 데이터를 통해
--제품 별 총 주문량을 조회할 수 있는 쿼리문을 구성한다.



SELECT T.JECODE, SUM(JUSU)
FROM(
SELECT JECODE,JUSU
FROM TBL_JUMUNBACKUP
UNION ALL
SELECT JECODE, JUSU
FROM TBL_JUMUN
)T
GROUP BY T.JECODE;

--○INTERSECT / MINUS (교집합과 차집합)

--TBL_JUMUNBACKUP 테이블과 TBL_JUMUN 테이블에서
--제품코드와 수문수량의 값이 똑같은 행만 추출하고자 한다.

SELECT JECODE, JUSU
FROM TBL_JUMUNBACKUP
INTERSECT
SELECT JECODE, JUSU
FROM TBL_JUMUN;
/*
감자깡	20
맛동산	30
홈런볼	10
*/

SELECT JECODE, JUSU
FROM TBL_JUMUNBACKUP
MINUS
SELECT JECODE, JUSU
FROM TBL_JUMUN;
/*
꼬깔콘	20
꼬북칩	20
다이제	10
빼빼로	10
사또밥	20
새우깡	10
스윙칩	20
오감자	20
오레오	10
죠리퐁	10
치토스	20
포스틱	10
포스틱	20
포카칩	20
*/

--○TBL_JUMUNBACKUP 테이블과 TBL_JUMUN 테이블을 대상으로
-- 제품코드와 주문량의 값이 똑같은 행의 정보를
-- 주문번호, 제품코드, 주문량, 주문일자 항목으로 조회한다.

SELECT T2.JUNO "주문번호", T.JECODE "제품코드", T.JUSU "주문량", T2.JUDAY "주문일자"
FROM
(
SELECT JECODE, JUSU
FROM TBL_JUMUNBACKUP
INTERSECT
SELECT JECODE, JUSU
FROM TBL_JUMUN
)T 
JOIN
(
SELECT *
FROM TBL_JUMUNBACKUP
UNION ALL
SELECT *
FROM TBL_JUMUN
)T2 ON T.JECODE = T2.JECODE
WHERE T.JUSU = T2.JUSU
ORDER BY 2,4;

--방법 1.

SELECT T2.JUNO "주문번호" , T1.JECODE "제품코드"
       ,T1.JUSU "주문수량" , T2.JUDAY "주문일자"
FROM
(
    SELECT JECODE, JUSU
    FROM TBL_JUMUNBACKUP
    INTERSECT
    SELECT JECODE, JUSU
    FROM TBL_JUMUN
)T1
JOIN
(
    SELECT *
    FROM TBL_JUMUNBACKUP
    UNION ALL
    SELECT *
    FROM TBL_JUMUN
) T2
ON T1.JECODE = T2.JECODE
AND T1.JUSU = T2.JUSU;

--○방법 2

SELECT T.*
FROM
(
    SELECT *
    FROM TBL_JUMUNBACKUP
    UNION ALL
    SELECT *
    FROM TBL_JUMUN
) T
WHERE CONCAT(T.JECODE, T.JUSU) = ANY ( SELECT CONCAT(JECODE,JUSU)
                                     FROM TBL_JUMUNBACKUP
                                    INTERSECT
                                    SELECT CONCAT(JECODE,JUSU)
                                     FROM TBL_JUMUN ); 
                                     
SELECT T.*
FROM 
(   
    SELECT *
    FROM TBL_JUMUNBACKUP
    UNION ALL
    SELECT *
    FROM TBL_JUMUN
)T
WHERE CONCAT(T.JECODE, T.JUSU) IN(SELECT CONCAT(JECODE,JUSU)
                                  FROM TBL_JUMUNBACKUP
                                  INTERSECT
                                  SELECT CONCAT(JECODE,JUSU)
                                  FROM TBL_JUMUN);


/*
3	맛동산	30	2001-11-01
7	감자깡	20	2001-11-04
11	홈런볼	10	2001-11-05
12	홈런볼	10	2001-11-05
18	홈런볼	10	2001-11-11
98768	홈런볼	10	2022-08-22
98769	감자깡	20	2022-08-22
98772	맛동산	30	2022-08-22
*/



---------------------------------------------------------------------
SELECT D.DEPTNO, D.DNAME, E.ENAME, E.SAL
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;


SELECT DEPTNO, DNAME, ENAME, SAL
FROM EMP E NATURAL JOIN DEPT D;
/*
10	ACCOUNTING	CLARK	2450
10	ACCOUNTING	KING	5000
10	ACCOUNTING	MILLER	1300
20	RESEARCH	JONES	2975
20	RESEARCH	FORD	3000
20	RESEARCH	ADAMS	1100
20	RESEARCH	SMITH	800
20	RESEARCH	SCOTT	3000
30	SALES	WARD	1250
30	SALES	TURNER	1500
30	SALES	ALLEN	1600
30	SALES	JAMES	950
30	SALES	BLAKE	2850
30	SALES	MARTIN	1250
*/

SELECT DEPTNO, DNAME, ENAME, SAL
FROM EMP E JOIN DEPT D
USING(DEPTNO);



-----------------------------------------------------------------------------
--실무에서 가장 많이 일어나는 에로사항
--○TBL_EMP 테이블에서 급여가 가장 많은 사원의
-- 사원번호, 사원명, 직종명, 급여 항목을 조회하는 쿼리문을 구성한다.


SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL = (SELECT MAX(SAL) FROM TBL_EMP);
-- 7839	KING	PRESIDENT	5000

-- 『=ALL』 자바에서 AND와 같은 것 안에들어있는 모든 조건을 만족해야 한다.

SELECT SAL
FROM TBL_EMP;
/*
800
1600
1250
2975
1250
2850
2450
3000
5000
1500
1100
950
3000
1300
1500
2000
1700
2500
1000
*/
SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL =ANY(800, 1600, 1250, 2975, 1250, 2850, 2450, 3000, 5000, 1500, 1100, 950, 3000, 1300, 1500, 2000, 1700, 2500, 1000);
/*
7369	SMITH	CLERK	800
7499	ALLEN	SALESMAN	1600
7521	WARD	SALESMAN	1250
7566	JONES	MANAGER	2975
7654	MARTIN	SALESMAN	1250
7698	BLAKE	MANAGER	2850
7782	CLARK	MANAGER	2450
7788	SCOTT	ANALYST	3000
7839	KING	PRESIDENT	5000
7844	TURNER	SALESMAN	1500
7876	ADAMS	CLERK	1100
7900	JAMES	CLERK	950
7902	FORD	ANALYST	3000
7934	MILLER	CLERK	1300
8001	김태민	CLERK	1500
8002	조현하	CLERK	2000
8003	김보경	SALESMAN	1700
8004	유동현	SALESMAN	2500
8005	장현성	SALESMAN	1000
*/
SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL >=ANY(800, 1600, 1250, 2975, 1250, 2850, 2450, 3000, 5000, 1500, 1100, 950, 3000, 1300, 1500, 2000, 1700, 2500, 1000);
--위와 같은 결과 

SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL >=ALL(800, 1600, 1250, 2975, 1250, 2850, 2450, 3000, 5000, 1500, 1100, 950, 3000, 1300, 1500, 2000, 1700, 2500, 1000);
--7839	KING	PRESIDENT	5000 MAX를 쓰지 않더라고 최대값을 구할 수 있다.

SELECT EMPNO, ENAME, JOB, SAL
FROM TBL_EMP
WHERE SAL >=ALL(SELECT SAL FROM TBL_EMP);
--7839	KING	PRESIDENT	5000

--○TBL_EMP 테이블에서 20번 부서에 근무하는 사원들 중
-- 급여가 가장 많은 사원의
-- 사원번호, 사원명, 직종명, 급여 항목을 조회하는 쿼리문을 구성한다.

SELECT EMPNO , ENAME, JOB, SAL
FROM TBL_EMP
WHERE DEPTNO = 20
      AND SAL >= ALL(SELECT SAL FROM TBL_EMP WHERE DEPTNO = 20);
      
      
SELECT EMPNO , ENAME, JOB, SAL
FROM TBL_EMP
WHERE DEPTNO = 20
      AND SAL = (SELECT MAX(SAL) FROM TBL_EMP WHERE DEPTNO = 20);



--○TBL_EMP 테이블에서 수당(커미션, COMM)이 가장 많은 사원의
-- 사원번호, 사원명, 부서번호, 직종명, 커미션 항목을 조회한다.
SELECT *
FROM TBL_EMP
WHERE COMM >= ALL( SELECT NVL(COMM,0) FROM TBL_EMP);

SELECT *
FROM TBL_EMP
WHERE COMM = ( SELECT MAX(COMM) FROM TBL_EMP);
--MAX는 NULL값 무시하는듯

SELECT COMM
FROM TBL_EMP
WHERE COMM IS NOT NULL;
/*
300
500
1400
0
10
10
*/


--○DISTINCT() 중복 행(레코드)을 제거하는 함수

--TBL_EMP 테이블에서 관리자로 등록된 사원의
-- 사원번호, 사원명, 직종명을 조회한다.

SELECT T2.ENAME, T2.EMPNO, T2.JOB
FROM
(
SELECT MGR
FROM TBL_EMP
GROUP BY MGR
HAVING MGR IS NOT NULL
)T1
JOIN
(SELECT *
FROM TBL_EMP
)T2
ON T1.MGR = T2.EMPNO;


SELECT EMPNO, ENAME, JOB
FROM TBL_EMP
WHERE EMPNO IN( SELECT DISTINCT(MGR) FROM TBL_EMP);
/*
7902	FORD	ANALYST
7698	BLAKE	MANAGER
7839	KING	PRESIDENT
7566	JONES	MANAGER
7788	SCOTT	ANALYST
7782	CLARK	MANAGER
*/


SELECT JOB
FROM TBL_EMP;
/*
CLERK
SALESMAN
SALESMAN
MANAGER
SALESMAN
MANAGER
MANAGER
ANALYST
PRESIDENT
SALESMAN
CLERK
CLERK
ANALYST
CLERK
CLERK
CLERK
SALESMAN
SALESMAN
SALESMAN
*/

SELECT DISTINCT(JOB)
FROM TBL_EMP;
/*
CLERK
SALESMAN
PRESIDENT
MANAGER
ANALYST
*/

SELECT DISTINCT(DEPTNO)
FROM TBL_EMP;
/*
30
(NULL)   --단 NULL을 거르지는 못하는듯
20
10
*/

--부서번호 등 모두 같음

-------------------------------------------------------------------------
SELECT *
FROM TBL_SAWON;

--TBL_SAWO 테이블 백업(데이터 위주) -> 각 테이블 간의 관계나 제약조건 등은 제외한 상태

CREATE TABLE TBL_SAWONBACKUP
AS
SELECT *
FROM TBL_SAWON;

--Table TBL_SAWONBACKUP이(가) 생성되었습니다
--TBL_SAWON 테이블의 데이터들만 백업을 수행
-- 즉, 다른 이름의 테이블 형태로 저장해 둔 상황

--○ 데이터 수정

UPDATE TBL_SAWON
SET SANAME = '똘똘이'; -- WHERE -> SET -> UPDATE문 작성

SELECT *
FROM TBL_SAWON;
--다 바낌
--원래대로 돌리자
/*
1001	똘똘이	9409252234567	2005-01-03	3000
1002	똘똘이	9809022234567	1999-11-23	2000
1003	똘똘이	9810092234567	2006-08-10	4000
1004	똘똘이	9307131234567	1998-05-13	2000
1005	똘똘이	7008161234567	1998-05-13	1000
1006	똘똘이	9309302234567	1999-10-10	3000
1007	똘똘이	0302064234567	2010-10-23	4000
1008	똘똘이	6807102234567	1998-03-20	1500
1009	똘똘이	6710261234567	1998-03-20	1300
1010	똘똘이	6511022234567	1998-12-20	2600
1011	똘똘이	0506174234567	2011-10-10	1300
1012	똘똘이	0102033234567	2010-10-10	2400
1013	똘똘이	0210303234567	2011-10-10	2800
1014	똘똘이	9903142234567	2012-11-11	5200
1015	똘똘이	9907292234567	2012-11-11	5200
1016	똘똘이	0605063234567	2015-01-20	1500
*/


UPDATE TBL_SAWON
SET SANAME = (SELECT SANAME FROM TBL_SAWONBACKUP WHERE SANO = TBL_SAWON.SANO)
WHERE SANAME = '똘똘이';

SELECT *
FROM TBL_SAWON;
/*
1001	고연수	9409252234567	2005-01-03	3000
1002	김보경	9809022234567	1999-11-23	2000
1003	정미경	9810092234567	2006-08-10	4000
1004	김인교	9307131234567	1998-05-13	2000
1005	이정재	7008161234567	1998-05-13	1000
1006	아이유	9309302234567	1999-10-10	3000
1007	이하이	0302064234567	2010-10-23	4000
1008	인순이	6807102234567	1998-03-20	1500
1009	선동렬	6710261234567	1998-03-20	1300
1010	선우용녀	6511022234567	1998-12-20	2600
1011	선우선	0506174234567	2011-10-10	1300
1012	남궁민	0102033234567	2010-10-10	2400
1013	남진	0210303234567	2011-10-10	2800
1014	반보영	9903142234567	2012-11-11	5200
1015	한은영	9907292234567	2012-11-11	5200
1016	이이경	0605063234567	2015-01-20	1500
*/
--복구완료

SELECT DEPTNO "부서번호", SUM(SAL) "급여합"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);

/*
10	8750
20	10875
30	9400
	8700
	37725   --모든부서 직원들의 급여합
*/

SELECT NVL(TO_CHAR(DEPTNO),'모든부서' )"부서번호", SUM(SAL) "급여합"
FROM EMP
GROUP BY ROLLUP(DEPTNO);

SELECT NVL2(DEPTNO, TO_CHAR(DEPTNO),'모든부서')"부서번호",SUM(SAL)"급여합"
FROM EMP
GROUP BY ROLLUP(DEPTNO);

/*
10	8750
20	10875
30	9400
모든부서	29025

*/

SELECT NVL2(DEPTNO, TO_CHAR(DEPTNO),'모든부서')"부서번호",SUM(SAL)"급여합"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);
/*
10	8750
20	10875
30	9400
모든부서	8700
모든부서	37725
*/

--GROUPING()
SELECT GROUPING(DEPTNO) "GROUPING", DEPTNO "부서번호", SUM(SAL) "급여합"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);
/*
GROUPING  부서번호  급여합
0	        10      	8750
0	        20      	10875
0	        30      	9400
0		   (null)   8700
1	       (null) 	37725
*/

--GROUPING 반환값이 1인 것은 ROLLUP이 수행된것

SELECT DEPTNO "부서번호", SUM(SAL) "급여합"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);
/*
10	8750
20	10875
30	9400
	8700
	37725
*/

--위 내용을
/*
10	8750
20	10875
30	9400
인턴	8700
모든부서	37725
*/
--이와 같이 조회되도록 쿼리문 구성
--힌트

SELECT CASE GROUPING(DEPTNO) 0 THEN '단일부서' ELSE '모든부서' END  DEPTNO "부서번호", SUM(SAL) "급여합"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);

SELECT CASE GROUPING(DEPTNO) WHEN 0 THEN TO_CHAR(DEPTNO)  
            ELSE '모든부서'
        END "부서"
            ,SUM(SAL) "급여합"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);

/*
10	8750
20	10875
30	9400
(null)	8700
모든부서	37725
*/


SELECT CASE GROUPING(DEPTNO) WHEN 0 THEN NVL(TO_CHAR(DEPTNO),'인턴')  
            ELSE '모든부서'
        END "부서"
            ,SUM(SAL) "급여합"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);


--○TBL_SAWON 테이블을 대상으로
--다음과 같이 조회될 수있도록 쿼리문 작성
/*
----------------------------
성별           급여합
-----------------------------
남             xxxx
여             xxxxx
모든사원        xxxx
*/


SELECT *
FROM TBL_SAWON;

SELECT  CASE GROUPING(T.성) WHEN 0 THEN T.성
        ELSE '모든사원'
        END "성별"
        ,SUM(T.급여) "급여합"
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','3') THEN '남'
            WHEN SUBSTR(JUBUN,7,1) IN ('2','4') THEN '여'
            ELSE '성별확인안됨'
        END "성"
        ,SAL "급여"
FROM TBL_SAWON
)T
GROUP BY (T.성);
/*
여	31800
남	11000
*/



SELECT  NVL(T.성별,'모든사원') 
        ,SUM(T.급여) "급여합"
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','3') THEN '남'
            WHEN SUBSTR(JUBUN,7,1) IN ('2','4') THEN '여'
            ELSE '성별확인안됨'
        END "성별"
        ,SAL "급여"
FROM TBL_SAWON
)T
GROUP BY ROLLUP(T.성별);

/*
여	31800
남	11000
*/

SELECT  NVL(T.성별,'모든사원') 
        ,SUM(T.급여) "급여합"
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','3') THEN '남'
            WHEN SUBSTR(JUBUN,7,1) IN ('2','4') THEN '여'
            ELSE '성별확인안됨'
        END "성별"
        ,SAL "급여"
FROM TBL_SAWON
)T
GROUP BY ROLLUP(T.성별);

SELECT  CASE GROUPING(T.성) WHEN 0 THEN T.성
        ELSE '모든사원'
        END "성별"
        ,SUM(T.급여) "급여합"
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','3') THEN '남'
            WHEN SUBSTR(JUBUN,7,1) IN ('2','4') THEN '여'
            ELSE '성별확인안됨'
        END "성"
        ,SAL "급여"
FROM TBL_SAWON
)T
GROUP BY ROLLUP(T.성);
/*
남	11000
여	31800
모든사원	42800
*/

--○TBL_SAWON 테이블을 대상으로
--다음과 같이 조회될 수있도록 쿼리문 작성
/*
----------------------------
연령대           인원수
-----------------------------
10               x
20             x
30              x
50              x
전체             16
*/

SELECT *
FROM TBL_SAWON;


SELECT NVL(T2.나이대,'전체') "연령대"  --CASE GROUPING(T.나이대) WHEN 0 TO_CHAR(T.나이대) ELSE '전체' END
       ,COUNT(*) "인원"
FROM(
SELECT CASE WHEN T1.나이>=50 THEN '50'
            WHEN T1.나이>=30 THEN '30'
            WHEN T1.나이>=20 THEN '20'
            WHEN T1.나이>=10 THEN '10'
            ELSE '확인필요'
        END "나이대"
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','2') THEN TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - (TO_NUMBER(SUBSTR(JUBUN,1,2)) + 1899)
            ELSE TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - (TO_NUMBER(SUBSTR(JUBUN,1,2)) + 1999)
            END "나이"
FROM TBL_SAWON
)T1
)T2
GROUP BY ROLLUP(나이대);




------------------VIEW 사용

CREATE OR REPLACE VIEW VIEW_SAWONTEMP
AS
SELECT CASE WHEN T.나이>=50 THEN '50'
            WHEN T.나이>=30 THEN '30'
            WHEN T.나이>=20 THEN '20'
            WHEN T.나이>=10 THEN '10'
            ELSE '확인필요'
        END "나이대"
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','2') THEN TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - (TO_NUMBER(SUBSTR(JUBUN,1,2)) + 1899)
            ELSE TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - (TO_NUMBER(SUBSTR(JUBUN,1,2)) + 1999)
            END "나이"
FROM TBL_SAWON
)T;


SELECT NVL(나이대,'전체') "나이대", COUNT(나이대)
FROM VIEW_SAWONTEMP
GROUP BY ROLLUP(나이대);

DROP VIEW VIEW_SAWONTEMP;

--방법 2. ->INLINE VIEW를 한번만 사용
---------------------TRUNC()
SELECT NVL(TO_CHAR(T1.나이),'전체') ,COUNT(*)
FROM(
SELECT TRUNC(CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','2') THEN EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(JUBUN,1,2))+1899)
            WHEN SUBSTR(JUBUN,7,1) IN ('3','4') THEN EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(JUBUN,1,2))+1999)
            ELSE -1
            END,-1) "나이"
FROM TBL_SAWON
)T1  --T1
GROUP BY ROLLUP(T1.나이);



----------------나이대 붙이기 GROUPING(숫자형) GROUP BY ROLLUP(숫자형) 이라는걸 기억하자.
SELECT CASE GROUPING(T1.나이) WHEN 0 THEN T1.나이||'대'
            ELSE '전체' END "나이대" ,COUNT(*)
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','2') THEN TRUNC(EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(JUBUN,1,2))+1899),-1)
            WHEN SUBSTR(JUBUN,7,1) IN ('3','4') THEN TRUNC(EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(JUBUN,1,2))+1999),-1)
            ELSE -1
            END "나이"
FROM TBL_SAWON
)T1  --T1
GROUP BY ROLLUP(T1.나이);



--ROLLUP은 하나만 묶을수 있는 애가 아니다.

SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY 1,2;

/*
10	CLERK	1300
10	MANAGER	2450
10	PRESIDENT	5000
20	ANALYST	6000
20	CLERK	1900
20	MANAGER	2975
30	CLERK	950
30	MANAGER	2850
30	SALESMAN	5600
*/




SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY 1,2;
/*
10	    CLERK	    1300   --10번 부서 CLERK 직종의 급여합
10	    MANAGER	    2450   --10번 부서 MANAGER 직종의 급여합
10	    PRESIDENT	5000   --10번 부서 PRESIDENT 직종의 급여합
10	    (null)	    8750   --10번 부서 모든 직종의 급여합
20	    ANALYST     	6000
20	    CLERK	    1900
20	    MANAGER 	2975
20	    (null)	    10875  --20번 부서 모든 직종의 급여합
30	    CLERK	    950
30	    MANAGER	    2850
30	    SALESMAN    	5600
30	    (null)  	9400   --30번 부서 모든 직종의 급여합
(null)	(null)  	29025  --모든 부서 모든 직종의 급여합
*/

--○CUBE() -> ROLLUP()보다 더 자세한 결과를 반환받는다.

SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY 1,2;

/*
10	    CLERK	    1300
10	    MANAGER	    2450
10	    PRESIDENT	5000
10	    (null)  	8750
20	    ANALYST 	    6000
20	    CLERK	    1900
20	    MANAGER	    2975
20	    (null)  	10875
30	    CLERK   	950
30	    MANAGER	    2850
30	    SALESMAN	    5600
30	    (null)  	9400
(null)	ANALYST	    6000 --모든 부서 ANALYST 직종의 급여합  --추가
(null)	CLERK	    4150 --모든 부서 CLERK 직종의 급여합    --추가
(null)	MANAGER	    8275 --모든 부서 MANAGER 직종의 급여합  --추가
(null)	PRESIDENT	5000 --모든 부서 PRESIDENT 직종의 급여합 --추가
(null)	SALESMAN	    5600 --모든 부서 SALESMAN 직종의 급여합  --추가
(null)	(null)  	29025
*/

--※ROLLUP() 과 CUBE() 는
-- 그룹을 묶어주는 방식이 다르다. (차이)

--ex.

--ROLLUP(A,B,C)
---> (A,B,C) / (A,B) / (A) / ()

-- CUBE(A,B,C)
-- -> (A,B,C) / (A,B) / (A,C) / (B,C) / (A) / (B) / (C) / ()

--==>>위의 과정은(ROLLUP()) 묶음 방식이 다소 모자랄 떄가 있고
--    아래 과정은(CUBE()) 묶음 방식이 다소 지나칠 떄가 있기 때문에
--      다음과 같은 방식의 쿼리를 더 많이 사용하게 된다.
--      다음 작성하는 쿼리는 조회하고자 하는 그룹만
--      GROUPING SETS 를 이용하여 묶어주는 방식이다.

SELECT CASE GROUPING(DEPTNO) WHEN 0 THEN NVL(TO_CHAR(DEPTNO),'인턴')
       ELSE '전체부서'
    END "부서번호"
       , CASE GROUPING(JOB) WHEN 0 THEN JOB
          ELSE '전체직종'
        END "직종"
        , SUM(SAL) "급여합"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY 1, 2;
/*
10	    CLERK	    1300
10	    MANAGER 	2450
10	    PRESIDENT	5000
10	    전체직종    	8750
20	    ANALYST	    6000
20	    CLERK	    1900
20	    MANAGER 	2975
20	    전체직종    	10875
30      	CLERK	    950
30	    MANAGER 	2850
30	    SALESMAN	    5600
30	    전체직종    	9400
인턴  	CLERK	    3500
인턴	    SALESMAN	    5200
인턴	    전체직종	    8700
전체부서	전체직종	    37725
*/

SELECT CASE GROUPING(DEPTNO) WHEN 0 THEN NVL(TO_CHAR(DEPTNO),'인턴')
       ELSE '전체부서'
    END "부서번호"
       , CASE GROUPING(JOB) WHEN 0 THEN JOB
          ELSE '전체직종'
        END "직종"
        , SUM(SAL) "급여합"
FROM TBL_EMP
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY 1, 2;
/*
10	    CLERK	    1300
10	    MANAGER	    2450
10	    PRESIDENT	5000
10	    전체직종	    8750
20	    ANALYST     	6000
20	    CLERK	    1900
20	    MANAGER	    2975
20	    전체직종	    10875
30	    CLERK	    950
30   	MANAGER 	2850
30	    SALESMAN    	5600
30	    전체직종    	9400
인턴	    CLERK	    3500
인턴	    SALESMAN	    5200
인턴	    전체직종	    8700

전체부서	ANALYST	    6000
전체부서	CLERK	    7650
전체부서	MANAGER	    8275
전체부서	PRESIDENT	5000
전체부서	SALESMAN	    10800

전체부서	전체직종	    37725
*/

SELECT CASE GROUPING(DEPTNO) WHEN 0 THEN NVL(TO_CHAR(DEPTNO),'인턴')
       ELSE '전체부서'
    END "부서번호"
       , CASE GROUPING(JOB) WHEN 0 THEN JOB
          ELSE '전체직종'
        END "직종"
        , SUM(SAL) "급여합"
FROM TBL_EMP
GROUP BY GROUPING SETS((DEPTNO, JOB), (DEPTNO),())
ORDER BY 1, 2;
--ROLLUP을 사용한 결과와 같은 조회 결과 반환
/*
10	CLERK	1300
10	MANAGER	2450
10	PRESIDENT	5000
10	전체직종	8750
20	ANALYST	6000
20	CLERK	1900
20	MANAGER	2975
20	전체직종	10875
30	CLERK	950
30	MANAGER	2850
30	SALESMAN	5600
30	전체직종	9400
인턴	CLERK	3500
인턴	SALESMAN	5200
인턴	전체직종	8700
전체부서	전체직종	37725
*/

--환경설정 -> 데이터베이스 -> NLS -> 날짜형식 바꾸기 가능


--○TBL_EMP 테이블을 대상으로 입사년도별 인원수를 조회한다.

SELECT *
FROM TBL_EMP;

SELECT EXTRACT(YEAR FROM HIREDATE) "입사년도"
    , COUNT(*) "인원수"
FROM TBL_EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE)
ORDER BY 1;
--==>>
/*
1980   1
1981   10
1982   1
1987   2
2022   5
*/
SELECT EXTRACT(YEAR FROM HIREDATE) "입사년도"
    , COUNT(*) "인원수"
FROM TBL_EMP
GROUP BY ROLLUP(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;


SELECT TO_CHAR(HIREDATE, 'YYYY') "입사년도"
       ,COUNT(*) "인원수"
FROM TBL_EMP
GROUP BY ROLLUP(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;
--ORA-00979: not a GROUP BY expression

SELECT EXTRACT(YEAR FROM HIREDATE) "입사년도"
       ,COUNT(*) "인원수"
FROM TBL_EMP
GROUP BY ROLLUP(TO_CHAR(HIREDATE,'YYYY'))
ORDER BY 1;
--ORA-00979: not a GROUP BY expression

SELECT TO_CHAR(HIREDATE, 'YYYY') "입사년도"
       ,COUNT(*) "인원수"
FROM TBL_EMP
GROUP BY ROLLUP(TO_CHAR(HIREDATE,'YYYY'));
--실행됨
--ROLLUP에서 TO_CHAR 로 묶었으면 TO_CHAR로 SELECT
--EXTRACT 로 묶었으면 EXTRACT 로 SELECT
/*
1980	1
1981	10
1982	1
1987	2
2022	5
	19
*/
SELECT CASE GROUPING(EXTRACT(YEAR FROM HIREDATE)) WHEN 0
            THEN EXTRACT(YEAR FROM HIREDATE)
            ELSE '전체'
        END "입사년도"
        , COUNT(*) "인원수"
FROM TBL_EMP
GROUP BY CUBE(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;
--ORA-00932: inconsistent datatypes: expected NUMBER got CHAR
--CASE 에서 EXTRACT는 숫자인데 ELSE 는 문자라서 에러


SELECT CASE GROUPING(TO_CHAR(HIREDATE,'YYYY')) WHEN 0
            THEN EXTRACT(YEAR FROM HIREDATE)
            ELSE '전체'
        END "입사년도"
        , COUNT(*) "인원수"
FROM TBL_EMP
GROUP BY CUBE(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;
--ORA-00932: inconsistent datatypes: expected NUMBER got CHAR
-- GROUPING(TO_CHAR(HIREDATE,'YYYY')) WHEN 0
--   여전히 숫자         THEN EXTRACT(YEAR FROM HIREDATE)
--     문자       ELSE '전체'
--이기때문에 에러발생

SELECT CASE GROUPING(TO_CHAR(HIREDATE,'YYYY')) WHEN 0
            THEN TO_CHAR(HIREDATE,'YYYY')
            ELSE '전체'
        END "입사년도"
        , COUNT(*) "인원수"
FROM TBL_EMP
GROUP BY CUBE(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;
--ORA-00979: not a GROUP BY expression 
--에러가 달라졌다.
--GROUP BY로 묶을떄는 숫자로 묶꼬 GROUPING에서는 TO_CHAR로 문자형을 썻다.


SELECT CASE GROUPING(EXTRACT(YEAR FROM HIREDATE)) WHEN 0
            THEN TO_CHAR(HIREDATE,'YYYY')
            ELSE '전체'
        END "입사년도"
        , COUNT(*) "인원수"
FROM TBL_EMP
GROUP BY CUBE(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;
--ORA-00979: not a GROUP BY expression

SELECT CASE GROUPING(TO_CHAR(HIREDATE,'YYYY')) WHEN 0
            THEN TO_CHAR(HIREDATE,'YYYY')
            ELSE '전체'
        END "입사년도"
        , COUNT(*) "인원수"
FROM TBL_EMP
GROUP BY CUBE(TO_CHAR(HIREDATE,'YYYY'))
ORDER BY 1;

--혹은

SELECT CASE GROUPING(EXTRACT(YEAR FROM HIREDATE)) WHEN 0
            THEN EXTRACT(YEAR FROM HIREDATE)
            ELSE -1
        END "입사년도"
        , COUNT(*) "인원수"
FROM TBL_EMP
GROUP BY CUBE(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;

/*
-1	19
1980	1
1981	10
1982	1
1987	2
2022	5
*/
--숫자면 숫자로 맞추고  문자면 문자로 맞추기
--쿼리문 작성할때 조심


-------------------------------------------------------------------



--■■■ HAVING ■■■------

--○EMP 테이블에서 부서번호가 20,30인 부서를 대상으로
--  부서의 총 급여가 10000보다 적을 경우만 부서별 총 급여를 조회한다.

SELECT *
FROM EMP;

SELECT DEPTNO "부서번호"
        , SUM(SAL) "부서 총 급여"
FROM EMP
WHERE DEPTNO IN (20,30)
   AND SUM(SAL) <10000   --ORA-00934: group function is not allowed here 그룹함수인 SUM은 여기서 쓸수 없다.
GROUP BY DEPTNO;


SELECT DEPTNO "부서번호"
        , SUM(SAL) "부서 총 급여"
FROM EMP
WHERE DEPTNO IN (20,30)
GROUP BY DEPTNO
HAVING SUM(SAL) < 10000;
--30	    9400
--주의 할점 


SELECT DEPTNO "부서번호"
        , SUM(SAL) "부서 총 급여"
FROM EMP
GROUP BY DEPTNO
HAVING SUM(SAL) < 10000
       AND DEPTNO IN (20,30);
       
--30	 9400 되긴 되지만
--AND DEPTNO IN (20,30) 이 구문은 WHERE에 있는게 바람직하다 왜냐면
--FROM 으로 테이블을 조회하고 WHERE 절에 만족하는 것만 메모리에 퍼올리기때문
--오라클 입장에서는 EMP 테이블을 싹다 올려서 그 안에서 데이터 정리 VS  EMP테이블중 필요한 메모리만 올려서 데이터를 정리하기
--이런것 

--■■■ 중첩 그룹함수 / 분석함수 ■■■------

--그룹 함수는 2 LEVEL 까지 중첩해서 사용할 수 있다.
-- MSSQL은 이마저도 불가능하다.

SELECT SUM(SAL)
FROM EMP
GROUP BY DEPTNO;
--9400
--10875
--8750


SELECT MAX(SUM(SAL))
FROM EMP
GROUP BY DEPTNO;
--10875

--RANK() / DENSE_RANK()
--> ORACLE 9i부터 적용된함수...MSSQL 2005부터 적용된 함수이다.

--->하위 버전에서는 RANK() 나 DENSE_RANK()를 사용할 수 없기 때문에
--  예를 들어.. 급여순위를 구하고자 한다면
-- 해당 사원의 급여보다 더 큰 값이 몇 개인지 확인한 후
-- 확인한 숫자에 +1 을 추가 연산해주면...
-- 그 값이 곧 해당 사원의 등수가 된다.\


SELECT ENAME, SAL
FROM EMP;

SELECT COUNT(*)+1
FROM EMP
WHERE SAL > 800;    --SMITH의 급여
--==>      14         --SMITH의 급여 등수

SELECT COUNT(*)+1
FROM EMP
WHERE SAL > 1600;   --ALLEN의 급여
--==>   7            --ALLEN의 급여 등수

--※서브 상관 쿼리(상관 서브 쿼리)
-- 메인 쿼리가 있는 테이블의 컬럼이
--  서브 쿼리의 조건절(WHERE절, HAVING절)에 사용되는 경우
-- 우리는 이 쿼리문을 서브 상관 쿼리(상관 서브 쿼리) 라고 부른다.

SELECT ENAME "사원명" , SAL "급여" , 1 "급여등수"
FROM EMP;

SELECT ENAME "사원명" , SAL "급여" , (SELECT COUNT(*)+1
                                    FROM EMP
                                    WHERE SAL > 800) "급여등수"
FROM EMP;

SELECT ENAME "사원명" , E.SAL "급여" , (SELECT COUNT(*)+1
                                    FROM EMP
                                    WHERE SAL > E.SAL) "급여등수"
FROM EMP E
ORDER BY 3;
/*
KING	5000    	1
FORD	3000    	2
SCOTT	3000    	2
JONES	2975    	4
BLAKE	2850	    5
CLARK	2450	    6
ALLEN	1600    	7
TURNER	1500	    8
MILLER	1300    	9
WARD	1250    	10
MARTIN	1250	    10
ADAMS	1100	    12
JAMES	950	    13
SMITH	800	    14
*/

--EMP 테이블을 대상으로
-- 사원명, 급여, 부서번호, 부서내 급여등수, 전체급여 등수 항목을 조회한다.
-- 단 서브 상관 쿼리를 활용할 수 있도록 한다.
SELECT E.ENAME "사원명" , E.SAL"급여", E.DEPTNO"부서번호"
    ,   (1) "부서내 급여등수"      
    ,   (1)"전체급여등수"
FROM EMP E  
ORDER BY 5;


SELECT E.ENAME "사원명" , E.SAL"급여", E.DEPTNO"부서번호"
    ,   (SELECT COUNT(*) + 1
        FROM EMP
        WHERE SAL > 800 AND DEPTNO = 20) "부서내 급여등수"      
    ,   (SELECT COUNT(*) + 1
            FROM EMP
            WHERE SAL > 800)"전체급여등수"
FROM EMP E  
ORDER BY 5;
--==> 전부 SMITH의 정보


SELECT ENAME "사원명", E.SAL "급여", DEPTNO
       ,(SELECT COUNT(*)+1  FROM EMP  WHERE SAL > E.SAL) "전체급여등수"
       ,(SELECT COUNT(*)+1  FROM EMP WHERE SAL > E.SAL AND DEPTNO = E.DEPTNO) "부서내 급여등수"
FROM EMP E
ORDER BY 3,5;


--○EMP 테이블을 대상으로 다음과 같이 조회될 수 있도록 쿼리문을 구성한다.
/*
                                  -각 부서내에서 입사일자별로 누적된 급여의 합 
---------------------------------------------------------------
사원명   부서번호   입사일    급여  부서내입사별급여누적  
-------------------------------------------------------------
SMITH   20          1980-12-17 800         800 
JONES    20        1981-04-02   2975       3775
FORD    20         1981-12-03  3000        6775
                                           :
*/

SELECT *
FROM EMP;


SELECT SUM(SAL)
FROM EMP
WHERE HIREDATE <= TO_DATE('1981-02-22','YYYY-MM-DD');


SELECT E.HIREDATE "입사일",(SELECT SUM(SAL) FROM EMP WHERE DEPTNO = E. DEPTNO AND HIREDATE <= E.HIREDATE) "부서내 입사별 누적"
FROM EMP E;


SELECT  ENAME "사원명", DEPTNO "부서번호", HIREDATE "입사일", SAL "급여", (SELECT SUM(SAL) FROM EMP WHERE DEPTNO = E. DEPTNO AND HIREDATE <= E.HIREDATE) "부서내 입사별 누적"
FROM EMP E;


SELECT  E1.ENAME "사원명", E1.DEPTNO "부서번호", E1.HIREDATE "입사일", E1.SAL "급여", ( SELECT SUM(E2.SAL) FROM EMP E2 WHERE E2.DEPTNO = E1.DEPTNO) "부서내 입사별누적"
FROM SCOTT.EMP E1
ORDER BY 2, 3;

SELECT  E1.ENAME "사원명", E1.DEPTNO "부서번호", E1.HIREDATE "입사일", E1.SAL "급여", ( SELECT SUM(E2.SAL) FROM EMP E2 WHERE E2.DEPTNO = E1.DEPTNO AND E2.HIREDATE <= E1.HIREDATE) "부서내 입사별누적"
FROM SCOTT.EMP E1
ORDER BY 2, 3;

--EMP 테이블을 대상으로
-- 입사한 사원의 수가 가장 많았을 때의
-- 입사년월과 인원수를 조회할 수 있도록 쿼리문을 구성한다.

SELECT *
FROM EMP;


SELECT TO_CHAR(HIREDATE,'YYYY-MM') "입사년월", COUNT(*) "입사원수"
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
HAVING COUNT(*)=(SELECT MAX(COUNT(*)) FROM EMP GROUP BY TO_CHAR(HIREDATE,'YYYY-MM'));

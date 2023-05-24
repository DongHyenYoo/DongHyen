SELECT T1.입사년월, T1.인원수
FROM
(
    SELECT TO_CHAR(HIREDATE, 'YYYY-MM') "입사년월"
        , COUNT(*) "인원수"
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'YYYY-MM')
)T1
WHERE T1.인원수 = ( SELECT MAX(T2.인원수)
                    FROM (
                SELECT TO_CHAR(HIREDATE, 'YYYY-MM') "입사년월"
                  , COUNT(*) "인원수"
                      FROM EMP
                     GROUP BY TO_CHAR(HIREDATE, 'YYYY-MM')
                     )T2
                     )
ORDER BY 1;

/*
1981-02	2
1981-09	2
1981-12	2
1987-07	2
*/

-------------------------------------------------------------------------
-----■■■ ROW_NUMBER ■■■-----

SELECT ENAME "사원명", SAL "급여", HIREDATE "입사일"
FROM EMP;

--나오는 데이터의 행갯수 = sql developer 에서 세주는것뿐

SELECT ROW_NUMBER() OVER(ORDER BY SAL DESC) "테스트"
        ,ENAME "사원명", SAL "급여", HIREDATE "입사일"
FROM EMP;
/*
1	KING	5000	1981-11-17
2	FORD	3000	1981-12-03
3	SCOTT	3000	1987-07-13
4	JONES	2975	1981-04-02
5	BLAKE	2850	1981-05-01
6	CLARK	2450	1981-06-09
7	ALLEN	1600	1981-02-20
8	TURNER	1500	1981-09-08
9	MILLER	1300	1982-01-23
10	WARD	1250	1981-02-22
11	MARTIN	1250	1981-09-28
12	ADAMS	1100	1987-07-13
13	JAMES	950	1981-12-03
14	SMITH	800	1980-12-17
*/
SELECT ROW_NUMBER() OVER(ORDER BY SAL DESC) "테스트"
        ,ENAME "사원명", SAL "급여", HIREDATE "입사일"
FROM EMP
ORDER BY ENAME;
/*
12	ADAMS	1100	1987-07-13
7	ALLEN	1600	1981-02-20
5	BLAKE	2850	1981-05-01
6	CLARK	2450	1981-06-09
2	FORD	3000	1981-12-03
13	JAMES	950	1981-12-03
4	JONES	2975	1981-04-02
1	KING	5000	1981-11-17
11	MARTIN	1250	1981-09-28
9	MILLER	1300	1982-01-23
3	SCOTT	3000	1987-07-13
14	SMITH	800	1980-12-17
8	TURNER	1500	1981-09-08
10	WARD	1250	1981-02-22
*/ --ENAME 으로 정렬하는 것과는 다르다.
--ENAME으로 정렬해서 번호 붙이기
SELECT ROW_NUMBER() OVER(ORDER BY ENAME) "테스트"
        ,ENAME "사원명", SAL "급여", HIREDATE "입사일"
FROM EMP
ORDER BY ENAME;
/*
1	ADAMS	1100	1987-07-13
2	ALLEN	1600	1981-02-20
3	BLAKE	2850	1981-05-01
4	CLARK	2450	1981-06-09
5	FORD	3000	1981-12-03
6	JAMES	950	1981-12-03
7	JONES	2975	1981-04-02
8	KING	5000	1981-11-17
9	MARTIN	1250	1981-09-28
10	MILLER	1300	1982-01-23
11	SCOTT	3000	1987-07-13
12	SMITH	800	1980-12-17
13	TURNER	1500	1981-09-08
14	WARD	1250	1981-02-22
*/

SELECT ROW_NUMBER() OVER(ORDER BY ENAME) "테스트"
        ,ENAME "사원명", SAL "급여", HIREDATE "입사일"
FROM EMP
WHERE DEPTNO = 20
ORDER BY ENAME;
/*
1	ADAMS	1100	1987-07-13
2	FORD	3000	1981-12-03
3	JONES	2975	1981-04-02
4	SCOTT	3000	1987-07-13
5	SMITH	800	1980-12-17
*/ --인터넷 게시판에서 주로 쓰이는 기능

--※ 게시판의 게시물 번호를 SEQUENCE 나 IDENTITY 를 사용하게 되면
--  게시물을 삭제했을 경우.. 삭제한 게시물의 자리에 다음 번호를 가진
-- 게시물이 등록되는 상황이 발생하게 된다.
-- 이는... 보안성 측면이나... 미관상.. 바람직하지 않은 상태일 수 있기 때문에
-- ROW_NUMBER() 의 사용을 고려해 볼 수 있다.
-- 관리의 목적으로 사용할 때에는 SEQUENCE 나 IDENTITY를 사용하지만
-- 단순히 게시물을 목록화 하여 사용자에게 리스트 형식으로 보여줄 때에는
-- 사용하지 않는 것이 바람직할 수 있다.

--○SEQUENCE(시퀀스 : 주문번호)
-- ->사전적인 의미 : 1.(사건 행동 등의) 순서,  2.(일련의) 연속적인 사건들

CREATE SEQUENCE SEQ_BOARD   --기본적인 시퀀스 생성 구문
START WITH 1  --1부터 시작하게하겠다.
INCREMENT BY 1 -- 1씩 증가하게 만들겠다.
NOMAXVALUE  --최대값을 정해놓기... 다만 쓰지 않는것이 일반적이다.
NOCACHE; -- 캐시 사용 안함(없음)

-- 캐시에 대한 부연 설명
-- 시퀀스 값을 생성할 때 미리 생성된 시퀀스 값을 빠르게 제공
-- 하지만, DB를 중지시키거나 전원이 off 되는 경우와 같이
-- 미리 생성된 시퀀스 값들이 다 사용되지 못할지라도 
-- 다음의 시퀀스 값은 미리 생성된 값 다음 값이 사용된다는 점

--Sequence SEQ_BOARD이(가) 생성되었습니다.

--○실습 테이블 생성
CREATE TABLE TBL_BOARD
( NO        NUMBER          --게시물 번호 X    사용자 작성 X
, TITLE     VARCHAR2(50)    --게시물 제목 ○
, CONTENTS  VARCHAR2(1000)  --게시물 내용 ○  사용자 작성
, NAME      VARCHAR2(20)    --게시물 작성자 △ 사용자가 작성할수도 아닐수도
, PW        VARCHAR2(20)    --게시물 패스워드 △ 사용자가 작성할수도 아닐수도
, CREATED   DATE DEFAULT SYSDATE --게시물 작성일 X
);
--Table TBL_BOARD이(가) 생성되었습니다.

--○ 데이터 입력 -> 게시판에 게시물을 작성한 액션
INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '아~자고
싶다', '10분만 자고 올께요', '장현성', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '아~웃겨', 'ㅋㅋㅋㅋㅋㅋㅋㅋ', '엄소연', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '보고싶다', '원석이가 보고 싶어요', '조영관', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '배고파요', '아침인데 배고파요', '유동현', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '너무멀어요', '집에서 교육원까지 너무 멀어요', '김태민', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '모자라요', '아직 잠이 모자라요', '장현성', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '저두요', '저도 아직 잠이 모자라요', '유동현', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '비온대요', '오늘밤부터 비온대요', '박원석', 'java002$', DEFAULT);

SELECT *
FROM TBL_BOARD;
--데이터 삽입 확인

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';

DROP TABLE TBL_BOARD PURGE;
--==>>Table TBL_BOARD이(가) 삭제되었습니다.

DROP SEQUENCE SEQ_BOARD;
--==>>Sequence SEQ_BOARD이(가) 삭제되었습니다.



COMMIT;
--○ 게시물 삭제
DELETE
FROM TBL_BOARD
WHERE NO = 1;

DELETE
FROM TBL_BOARD
WHERE NO = 6;

DELETE
FROM TBL_BOARD
WHERE NO = 8;

--삭제 확인
SELECT*
FROM TBL_BOARD;

--○게시물 작성
INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '집중합시다' , '전 전혀졸리지 않아요', '유동현','java002$', DEFAULT);

DELETE
FROM TBL_BOARD
WHERE NO = 7;

--확인
SELECT *
FROM TBL_BOARD;


SELECT ROW_NUMBER() OVER(ORDER BY CREATED) "글번호"
       ,TITLE, NAME, CREATED
FROM TBL_BOARD
ORDER BY 4 DESC;
/*
5	집중합시다	유동현	2022-08-22 10:39:50
2	보고싶다	조영관	2022-08-22 10:39:41
4	너무멀어요	김태민	2022-08-22 10:39:41
1	아~웃겨	엄소연	2022-08-22 10:39:41
3	배고파요	유동현	2022-08-22 10:39:41
*/

-----------------------------------------------------

-----■■■ JOIN(조인) ■■■------  매우 중요

--1. SQL 1992 CODE


--CROSS JOIN
SELECT *
FROM EMP, DEPT;
--56건의 데이터 EMP 14건 DEPT 4건
--데카르트 곱하기(CATERSIAN PRODUCT)
-- 두 테이블을 결합한 모든 경우의 수

--EQUI JOIN : 서로 정확히 일치하는 것들끼리 연결하여 결합시키는 결합 방법
SELECT *
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;
--14건의 결과

SELECT *
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;


--NON EQUI JOIN
SELECT *
FROM SALGRADE;

SELECT * 
FROM EMP;

SELECT *
FROM EMP E, SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL;
--낮은 SAL~ 높은 SAL 까지에 존재하는 것들끼리 합쳐라

--EQUI JOIN 시 + 를 활용한 결합 방법
SELECT *
FROM TBL_EMP; --19건

SELECT *
FROM TBL_DEPT; --4건

SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO = D.DEPTNO; --14건
-->총 14건의 데이터가 결합되어 조회된 상황
-- 즉, 부서번호를 갖지 못한 사원들 5명이 전무 누락
-- 또한, 소속 사원을 갖지 못한 부서 1 모두 누락

SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO = D.DEPTNO(+); --19건의 데이터 부서번호 없는 사원들 등장
--소속 사원을 갖지못한 부서(40번) 누락 -----(+)가 붙은 테이블의 데이터
-- 부서번호를 갖지 못한 사원들 5명 등장

SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO; --15건의 데이터 소속사원이 없는 부서 등장
--부서 번호를 갖지 못한 사원들 5명 누락---------------(+)가 붙은 테이블의 데이터
--소속 사원을 갖지 못한 부서(40번) 등장

--즉 + 가 없는 쪽의 데이터를 전부 메모리에 적재후      --기준
--+가 있는 쪽 테이블의 데이터를 하나하나 확인하여 결합시키는 형태로 --추가(첨가)
-- JOIN이 이루어 진다.

--외와 같은 이유로...
SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO(+)
-- 이런 형식의 JOIN은 존재하지 않는다.
--즉 논리적으로 기준이 되는 테이블이 존재하지 않는다.


--2. SQL 1999 CODE -> JOIN 키워드 등장 -> 『JOIN』(결합)의 유형 명시하도록 문법적으로 만들어 놓음
                                    ---> 『ON』 키워드의 등장 -> 결합 조건은 WHERE 대신 ON

--CROSS JOIN
SELECT *
FROM EMP CROSS JOIN DEPT;

--EQUI JOIN NON EQUI JOIN 이 없어졌다.

--대신
--INNER JOIN
SELECT *
FROM EMP INNER JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO;

SELECT *
FROM EMP E INNER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;
--둘이 같은 결과

SELECT *
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;
--INNER JOIN 에서 INNER은 생략가능

--OUTER JOIN
SELECT *
FROM TBL_EMP E LEFT OUTER JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO;   -- + 대신 기준이 왼쪽인 LEFT OUTER JOIN

SELECT *
FROM TBL_EMP E RIGHT OUTER JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO; -- + 대신 기준이 오른쪽인 RIGHT OUTER JOIN

SELECT *
FROM TBL_EMP E FULL OUTER JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO;   --누락됬던 부서와 사원들 모두 나오게 된다.

--OUTER 도 생략 가능하다. 즉 방향이 붙어있으면 OUTER 없으면 INNER JOIN이다.

---------------------------------------------------------------------
SELECT *
FROM TBL_EMP E JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO
AND E.JOB = 'CLERK'; --이러면 WHERE 대신 ON을 쓴 의미가 없다...


SELECT *
FROM TBL_EMP E JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO
WHERE E.JOB = 'CLERK';
--이처럼 쓰기를 권장하는데 이는 ON = 결합조건 WHERE = 선택조건
--으로 누가 봐도 한눈에 알 수 있게 만드는것
---------------------------------------------------------------------

--○EMP 테이블과 DEPT 테이블을 대상으로
-- 직종이 MANAGER와 CLERK인 사원들만
-- 부서번호, 부서명, 사원명, 직종명, 급여 항목을 조회한다.

SELECT DEPT.DEPTNO "부서번호" , DEPT.DNAME "부서명", EMP.ENAME "사원명", EMP.JOB "직종명", EMP.SAL "급여"
FROM EMP LEFT JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO
WHERE JOB IN ('MANAGER','CLERK')
ORDER BY 4;
--에러 발생
--ORA-00918: column ambiguously defined
--두 테이블 간 중복되는 컬럼에 대한
-- 소속 테이블을 정해줘야(명시해줘야)한다.

--중복되는 컬럼값이 단 하나(ex, 20, 30, 40, 10)인 DEPTNO 가 부모테이블이되고
--각 데이터들에 DEPTNO의 값(20,30)이 여러개가 들어있는 EMP가 자식테이블이 된다.
--즉 이떄는 부모의 컬럼값 DEPT.DEPTNO로 값을 가져와야한다.

--두 테이블에 모두 포함되어 있는 중복된 컬림이 아니더라도
--컬럼의 소속 테이블을 명시해 줄 수 있도록 권장한다. 오라클이 일을 덜하기 위해


----------------------------------------------------------------------------
--○SELF JOIN (자기조인)
--EMP 테이블의 데이터를 다음과 같이 조회할 수 있도록 쿼리문을 구성한다.
----------------------------------------------------------------------------
-- 사원번호  사원명    직종명 관리자번호   관리자명    관리자직종명
----------------------------------------------------------------------------
SELECT *
FROM EMP;

SELECT E.EMPNO "사원번호" , E.ENAME "사원명"  , E.JOB "직종명"
        ,E.MGR "관리자번호" , M.ENAME "관리자 명" , M.JOB "관리자 직종명"
FROM EMP E JOIN EMP M
ON E.MGR = M.EMPNO;

SELECT E.EMPNO "사원번호" , E.ENAME "사원명"  , E.JOB "직종명"
        ,E.MGR "관리자번호" , M.ENAME "관리자 명" , M.JOB "관리자 직종명"
FROM EMP E LEFT JOIN EMP M  --King 이 나오게 하기
ON E.MGR = M.EMPNO;


SELECT E.EMPNO "사원번호" , E.ENAME "사원명"  , E.JOB "직종명"
        ,E.MGR "관리자번호" , M.ENAME "관리자 명" , M.JOB "관리자 직종명"
FROM EMP E , EMP M  --King 이 나오게 하기
WHERE E.MGR = M.EMPNO(+);
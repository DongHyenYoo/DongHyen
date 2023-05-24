SELECT USER
FROM DUAL;


--○CASE 구문(조건문,분기문)
/*
CASE
WHEN
THEN
ELSE
END
*/

SELECT CASE 5+2 WHEN 4 THEN '5+2=4' ELSE '5+2는 몰라요' END
FROM DUAL;
--==>>5+2는 몰라요

SELECT CASE 5+2 WHEN 7 THEN '5+2=7' ELSE '5+2는 몰라요' END
FROM DUAL;

--CASE에서 연산한 구문이 WHEN 절과 같을경우 THEN을  아니면 ELSE구문을 수행한다.

SELECT CASE 1+1 WHEN 2 THEN '1+1=2'
                WHEN 3 THEN '1+1=3'
                WHEN 4 THEN '1+1=4'
                ELSE '몰라'
                END
FROM DUAL;
--==>>1+1=2

SELECT CASE 1+1 WHEN 2 THEN '1+1=2'
                WHEN 3 THEN '1+1=3'
                WHEN 2 THEN '1+1=4'
                ELSE '몰라'
                END
FROM DUAL;
--==>>1+1=2
--자바의 if-else와 같이 하나만 보고 찾으면 끝난다.

SELECT CASE WHEN 5+2 = 4 THEN '5+2=4'
            WHEN 6-3 = 2 THEN '6-3=2'
            WHEN 2*1 = 2 THEN '2*1=2'
            WHEN 6/3 = 3 THEN '6/6=3'
            ELSE 'ㅁ?ㄹ'
    END
    --CASE WHEN을 합쳐서 어떤게 참인지 바로 걸러낼수 있다.
FROM DUAL;

SELECT CASE WHEN 5+2 = 7 THEN '5+2=7'
            WHEN 6-3 = 3 THEN '6-3=3'
            WHEN 2*1 = 2 THEN '2*1=2'
            WHEN 6/3 = 2 THEN '6/6=1'
            ELSE 'ㅁ?ㄹ'
        END
    --CASE WHEN을 합쳐서 어떤게 참인지 바로 걸러낼수 있다.
FROM DUAL;


--○DECODE()
SELECT DECODE(5-2,1,'5-2=1',2,'5-2=2',3,'5-2=3', '5-2는 몰라요') "결과확인"
FROM DUAL;


--CASE WHEN THEN ELSE END (조건문,분기문) 활용

SELECT CASE WHEN 5<2 THEN '5<2'
            WHEN 5>2 THEN '5>2'
            ELSE '5와 2는 비교불가'
        END "결과확인"
FROM DUAL;
--==>>5>2

SELECT CASE WHEN 5<2 OR 3>1 AND 2=2 THEN '소연만세'
            WHEN 5>2  OR 2=3 THEN '시연'
            ELSE '5와 2는 비교불가'
        END "결과확인"
FROM DUAL;


SELECT CASE WHEN 3<1 AND 5<2 OR 3>1 AND 2=2 THEN '보경만세'
            WHEN 5<2 AND 2=3 THEN '은영만세'
            ELSE '현하만세'
        END "결과확인"
FROM DUAL;
                 --F        --T       --F
SELECT CASE WHEN 3<1 AND (5<2 OR 3>1) AND 2=2 THEN '보경만세'
            WHEN 5<2 AND 2=3 THEN '은영만세'
            ELSE '현하만세'
        END "결과확인"
FROM DUAL;

SELECT *
FROM TBL_SAWON;

/*
1001	고연수	9409252234567	05/01/03	3000
1002	김보경	9809022234567	99/11/23	2000
1003	정미경	9810092234567	06/08/10	4000
1004	김인교	9307131234567	98/05/13	2000
1005	이정재	7008161234567	98/05/13	1000
1006	아이유	9309302234567	99/10/10	3000
1007	이하이	0302064234567	10/10/23	4000
1008	인순이	6807102234567	98/03/20	1500
1009	선동렬	6710261234567	98/03/20	1300
1010	선우용녀	6511022234567	98/12/20	2600
1011	선우선	0506174234567	11/10/10	1300
1012	남궁민	0102033234567	10/10/10	2400
1013	남진	0210303234567	11/10/10	2800
1014	반보영	9903142234567	12/11/11	5200
1015	한은영	9907292234567	12/11/11	5200
1016	이이경	0605063234567	15/01/20	1500
*/

--○TBL_SAWON 테이블을 활용하여 다음과 같은 항목을 조회할 수 있도록 쿼리문을 구성한다.
--사원번호, 사원명, 주민번호, 성별, 현재나이, 입사일
-- 정년퇴직일, 근무일수, 남은일수, 급여, 보너스
-- 단 현재나이는 기본 한국나이 계산법에 따라 연산을 수행한다.
-- 또한, 정년 퇴직일은 해당 직원의 나이가 한국 나이로 60세가 되는 해의 
-- 그 직원의 입사월, 입사일로 연산을 수행한다.
--그리고, 보너스는 1000일 이상 2000일 미만 근무한 사원은
-- 그 사원의 원래 급여 기준 30% 지급, 2000일 이상 근무한 사원은
-- 그 사원의 원래 급여 기준 50% 지급을 할 수 있도록 처리

SELECT TO_NUMBER(SUBSTR(TO_CHAR(SYSDATE),1,2))-10
FROM DUAL;

SELECT TO_NUMBER(SUBSTR(TO_CHAR(SYSDATE),1,2))
,TO_NUMBER(EXTRACT(YEAR FROM SYSDATE))
FROM DUAL;

SELECT  CASE WHEN SUBSTR(TO_CHAR(JUBUN),7,1) IN ('1','2') THEN 19||TO_NUMBER(SUBSTR(JUBUN,1,2))
            ELSE '10'
            END
FROM TBL_SAWON;

SELECT 60+(19||TO_NUMBER(SUBSTR(JUBUN,1,2)))||SUBSTR(TO_CHAR(HIREDATE),3)
FROM TBL_SAWON;

SELECT (TO_DATE(60+TO_NUMBER(CASE WHEN SUBSTR(TO_CHAR(JUBUN),7,1) IN ('1','2') THEN 19||(SUBSTR(TO_CHAR(JUBUN),1,2))
             WHEN SUBSTR(TO_CHAR(JUBUN),7,1) IN ('3','4') THEN 20||(SUBSTR(TO_CHAR(JUBUN),1,2))
          ELSE '0'
          END)|| SUBSTR(HIREDATE,5),'YYYY-MM-DD'))
FROM TBL_SAWON;


SELECT  SUBSTR(HIREDATE,5)
FROM TBL_SAWON;




SELECT SANO "사원번호" ,SANAME "사원명", JUBUN "주민번호"
       , CASE WHEN SUBSTR(JUBUN,7,1) IN('1','3') THEN  '남' ELSE '여' END "성별"
       , 1+TO_NUMBER(EXTRACT(YEAR FROM SYSDATE)) 
       - TO_NUMBER(CASE WHEN SUBSTR(TO_CHAR(JUBUN),7,1) IN ('1','2') THEN '19'||(SUBSTR(JUBUN,1,2))
          WHEN SUBSTR(TO_CHAR(JUBUN),7,1) IN ('3','4') THEN '20'||(SUBSTR(JUBUN,1,2))
          ELSE '-1'
          END) "현재나이"
      , HIREDATE "입사일"
      , TO_CHAR(ADD_MONTHS(SYSDATE,((60-((TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'))+1)
       - CASE WHEN SUBSTR(JUBUN,0,2)<22 THEN SUBSTR(JUBUN,0,2)+2000
          ELSE SUBSTR(JUBUN,0,2)+1900
          END))*12)), 'YYYY') ||'-'||TO_CHAR(HIREDATE,'MM-DD')"정년퇴직일"
      , ROUND(SYSDATE - HIREDATE) "근무일수"
      ,ROUND(TO_DATE(59+TO_NUMBER(CASE WHEN SUBSTR(TO_CHAR(JUBUN),7,1) IN ('1','2') THEN '19'||(SUBSTR(TO_CHAR(JUBUN),1,2))
          ELSE 20||(SUBSTR(TO_CHAR(JUBUN),1,2))
          END)||SUBSTR(HIREDATE,5),'YYYY-MM-DD')-SYSDATE) "남은일수"
      ,SAL "급여"
      ,CASE WHEN TO_NUMBER(TO_CHAR(SYSDATE-HIREDATE))>=2000 THEN SAL*0.5 
            WHEN TO_NUMBER(TO_CHAR(SYSDATE-HIREDATE))>=1000 THEN SAL*0.3
             
            ELSE 0
            END "보너스"
            
FROM TBL_SAWON;

SELECT *
FROM TBL_SAWON;

/*
SELECT ROUND(TO_DATE(59+TO_NUMBER(CASE WHEN SUBSTR(TO_CHAR(JUBUN),7,1) IN ('1','2') THEN 19||(SUBSTR(TO_CHAR(JUBUN),1,2))
             WHEN SUBSTR(TO_CHAR(JUBUN),7,1) IN ('3','4') THEN 20||(SUBSTR(TO_CHAR(JUBUN),1,2))
          ELSE '0'
          END) || SUBSTR(HIREDATE,3),'YYYY-MM-DD')-SYSDATE) "남은일수"
FROM TBL_SAWON;
  */    
--급여, 보너스

--그리고, 보너스는 1000일 이상 2000일 미만 근무한 사원은
-- 그 사원의 원래 급여 기준 30% 지급, 2000일 이상 근무한 사원은
-- 그 사원의 원래 급여 기준 50% 지급을 할 수 있도록 처리
--만약 CASE WHEN THEN 결과값이 숫자인데
--ELSE 에 문자를 넣으면
--제대로 작성했어도 정체성이 없어 에러가 난다.
--고로 ELSE에 -1을 넣어준다.

CREATE VIEW VIEW_EMP
AS
SELECT EMPNO, ENAME, SAL, COMM, SAL*12+NVL(COMM,0)"연봉"
FROM EMP;
--==>>에러발생
--   (ORA-01031: insufficient privileges)

--○ SYS계정으로 SCOTT계정에 CREATE VIEW 권한 부여 후 다시 실행
CREATE VIEW VIEW_EMP
AS
SELECT EMPNO, ENAME, SAL, COMM, SAL*12+NVL(COMM,0)"연봉"
FROM EMP;
--==>>View VIEW_EMP이(가) 생성되었습니다.


SELECT *
FROM VIEW_EMP;
--내부적으로는 SELECT EMPNO, ENAME, SAL, COMM, SAL*12+NVL(COMM,0)"연봉"
--FROM EMP;
--EMP 자체의 쿼리문이 실행되는 것임 , 데이터를 가지고 있는 것이 아님

--서브쿼리(인라인 뷰)
SELECT T.사원명 , T.사원번호, T.주민번호, T.성별, T.현재나이, T.입사일, T.급여
    --정년퇴직일
    --정년퇴직년도    → 해당직원의 나이가 한국나이로 60세가 되는 해
    --현재나이가 ...57세 ...3년 후   2022→ 2025
    --현재나이가 ...28세 ...32년 후  2022→ 2054
    --ADD_MONTHS(SYSDATE, 남은년수*12)
    --                    -------- 
    --                     60 - 현재나이
    --ADD_MONTHS(SYSDATE, (60-현재나이)*12) → 특정날짜
    --TO_CHAR('특정날짜','YYYY')            → 정년퇴직 년도만 추출
    --TO_CHAR('입사일','MM-DD')             → 입사 월일만 추출
    --TO_CHAR('특정날짜','YYYY')|| '-' || TO_CHAR('입사일','MM-DD') -> 정년퇴직일
    --TO_CHAR(ADD_MONTHS(SYSDATE,(60-현재나이)*12),'YYYY') || '-' || TO_CHAR('입사일','MM-DD')
      , TO_CHAR(ADD_MONTHS(SYSDATE,(60-T.현재나이)*12),'YYYY')
      || '-' || TO_CHAR(T.입사일,'MM-DD') "정년 퇴직일"
      
      --근무일수
      --근무일수 = 현재일 - 입사일
      ,TRUNC(SYSDATE - T.입사일) "근무일수"
      
      --남은일수
      --남은일수 = 정년퇴직일 - 현재일
      ,TRUNC(TO_DATE( TO_CHAR(ADD_MONTHS(SYSDATE,(60-T.현재나이)*12),'YYYY')
      || '-' || TO_CHAR(T.입사일,'MM-DD'), 'YYYY-MM-DD') - SYSDATE) "남은일수"
      
      --급여
      ,T.급여
      
      --보너스
      --근무일수가 1000일 이상 2000일 미만 -> 급여의 30% 지급
      --근무일수가 2000일 이상 -> 급여의 50%지급
      ---------------------------------------------------
      --근무일수가 2000일 이상            -> 급여 * 0.5
      --근무일수가 1000일 이상            -> 급여 * 0.3
      ,CASE WHEN TRUNC(SYSDATE - T.입사일) >= 2000 THEN T.급여 * 0.5
            WHEN TRUNC(SYSDATE - T.입사일) >= 1000 THEN T.급여 * 0.3
            ELSE 0
        END "보너스"
FROM
(   
    SELECT SANO"사원번호", SANAME"사원명", JUBUN"주민번호"
        ,  CASE WHEN SUBSTR(JUBUN, 7, 1) IN ('1', '3') THEN '남성'
                WHEN SUBSTR(JUBUN, 7, 1) IN ('2','4') THEN '여성'
                ELSE '성별확인불가'
                END "성별"
          -- 현재나이 = 현재년도 - 태어난년도 + 1(1900년대 /2000년대)
          , CASE WHEN SUBSTR(JUBUN, 7, 1) IN('1', '2') 
                THEN EXTRACT(YEAR FROM SYSDATE) - (TO_NUMBER(SUBSTR(JUBUN,1,2)) +1899)
                WHEN SUBSTR(JUBUN,7,1) IN('3','4')
                THEN EXTRACT(YEAR FROM SYSDATE) - (TO_NUMBER(SUBSTR(JUBUN,1,2)) +1999)
                ELSE -1
            END "현재나이"
          -- 입사일
         , HIREDATE "입사일"
          -- 급여
         , SAL "급여"
    FROM TBL_SAWON
)T;

--위에서 처리한 내용을 기반으로
--특정 근무일수의 사원을 확인해야 한다거나...
--특정 보너스 금액을 받는 사원을 확이해야 할 경우가 발생할 수 있다.
--(즉, 추가적인 조회 조건이 발생하거나, 업무가 파생되는 경우)
--이와같은경우..해당 쿼리문을 다시 구성해야 하는 번거로움을 줄일 수 있도록
--뷰(VIEW)를 만들어저장해둘수있다.



CREATE OR REPLACE VIEW VIEW_SAWON --이미 같은 이름의 뷰가 존재하면 REPLACE하고 없으면 생성한다. 
AS
SELECT T.사원번호, T.사원명, T.주민번호, T.성별, T.현재나이, T.입사일
    
  
      , TO_CHAR(ADD_MONTHS(SYSDATE, (60 - T.현재나이) * 12),'YYYY')
        || '-' || TO_CHAR(T.입사일, 'MM-DD') "정년퇴직일"
        
   
    , TRUNC(SYSDATE - T.입사일) "근무일수"
    
    
    , TRUNC(TO_DATE(TO_CHAR(ADD_MONTHS(SYSDATE, (60 - T.현재나이) * 12),'YYYY')
        || '-' || TO_CHAR(T.입사일, 'MM-DD'), 'YYYY-MM-DD') - SYSDATE) "남은일수"
        
   
    , T.급여 
    
                             
    , CASE WHEN TRUNC(SYSDATE - T.입사일) >= 2000 THEN T.급여 * 0.5
           WHEN TRUNC(SYSDATE - T.입사일) >= 1000 THEN T.급여 * 0.3
           ELSE 0
           END "보너스"
    
    
    
    
FROM
(
    SELECT SANO "사원번호", SANAME "사원명", JUBUN "주민번호"
    , CASE WHEN SUBSTR(JUBUN,7,1) IN ('1' , '3') THEN '남성' 
           WHEN SUBSTR(JUBUN,7,1) IN ('2' , '4') THEN '여성'
           ELSE '성별확인불가'
           END "성별"
           , CASE WHEN SUBSTR(JUBUN,7,1) IN ('1' , '2') 
                  THEN EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(JUBUN, 1, 2)) + 1899)
                  WHEN SUBSTR(JUBUN,7,1) IN ('3' , '4') 
                  THEN EXTRACT(YEAR FROM SYSDATE) -(TO_NUMBER(SUBSTR(JUBUN, 1, 2)) + 1999)
                  ELSE -1
             END "현재나이"
        , HIREDATE "입사일"
        , SAL "급여"
            
    FROM TBL_SAWON
) T;


SELECT *
FROM VIEW_SAWON
WHERE 근무일수 >= 5000;


SELECT *
FROM VIEW_SAWON
WHERE 보너스>= 2000;

--○서브 쿼리를 사용하여
-- TBL_SAWON 테이블을 다음과 같이 조회할 수 있도록 한다.
/*
사원명  성별  현재나이  급여  나이보너스
*/
-- 단, 나이보너스는 현재 나이가 40세 이상이면 급여의 70%
--   30세 이상 40세 미만이면 급여의 50%
--   20세 이상 30세 미만이면 급여의 30%로 한다.

-- 또한, 이렇게 완성된 조회 구문을 통해
-- VIEW_SAWON2 라는 이름의 구문을 생성한다
CREATE OR REPLACE VIEW VIEW_SAWON2
AS
SELECT T.*
       ,CASE WHEN T.현재나이 >=40 THEN T.급여*0.7
             WHEN T.현재나이 >=30 THEN T.급여*0.5
             WHEN T.현재나이 >=20 THEN T.급여*0.3
             ELSE 0
        END "나이보너스"
FROM(
SELECT SANAME "사원명"
       ,CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','3') THEN '남성'
       WHEN SUBSTR(JUBUN,7,1) IN ('2','4') THEN '여성'
       ELSE '성별확인안됨'
       END "성별"
       , CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','2') THEN 
       EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(JUBUN,1,2))+1899)
       WHEN SUBSTR(JUBUN,7,1) IN ('3','4') 
       THEN EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(JUBUN,1,2))+1999)
       ELSE -1
       END "현재나이"
       ,SAL "급여"
       
FROM TBL_SAWON
)T;

----------------------------------------------------------------

--○RANK() : 등수(순위)를 반환하는 함수

SELECT EMPNO "사원번호", ENAME "사원명", DEPTNO"부서번호", SAL "급여" 
       ,RANK() OVER(PARTITION BY DEPTNO ORDER BY SAL DESC) "부서별급여순위"
       ,RANK() OVER(ORDER BY SAL DESC) "전체급여순위"
FROM EMP
ORDER BY 3, 4 DESC;
/*
7839	KING	10	5000	    1	1
7902    	FORD	20	3000    	1	2
7788	SCOTT	20	3000	    1	2
7566	JONES	20	2975	    3	4
7698	BLAKE	30	2850	    1	5
7782    	CLARK	10	2450	    2	6
7499	ALLEN	30	1600	    2	7
7844	TURNER	30	1500	    3	8
7934	MILLER	10	1300	    3	9
7521    	WARD	30	1250	    4	10
7654	MARTIN	30	1250	    4	10
7876	ADAMS	20	1100	    4	12
7900	    JAMES	30	950     6	13
7369	SMITH	20	800	    5	14
*/

--DENSE_RANK() -> 서열을 반환하는 함수 위의 RANK는 
--동일 등수가 있으면 그만큼 뒤로 밀려서 나오지만 이건 아님
--○ DENSE_RANK() → 서열을 반환하는 함수
SELECT EMPNO "사원번호", ENAME "사원명", DEPTNO "부서번호", SAL "급여"
     , DENSE_RANK() OVER(PARTITION BY DEPTNO ORDER BY SAL DESC) "부서별급여서열"     
     , DENSE_RANK() OVER(ORDER BY SAL DESC) "전체급여서열"     
FROM EMP
ORDER BY 3,4 DESC;
--==>>
/*
7839   KING   10   5000   1    1
7782   CLARK   10   2450   2    5
7934   MILLER   10   1300   3    8
7902   FORD   20   3000   1     2
7788   SCOTT   20   3000   1     2
7566   JONES   20   2975   2    3
7876   ADAMS   20   1100   3   10
7369   SMITH   20    800   4   12
7698   BLAKE   30   2850   1    4
7499   ALLEN   30   1600   2    6
7844   TURNER   30   1500   3    7
7654   MARTIN   30   1250   4    9
7521   WARD   30   1250   4    9
7900   JAMES   30    950   5   11
*/


SELECT *
FROM EMP;
--○EMP 테이블의 사원 데이터를
--   사원명, 부서번호, 연봉, 부서내연봉순위, 전체연봉순위 항목으로 조회한다.

SELECT ENAME, DEPTNO, SAL*12+NVL(COMM,0) "연봉"
       ,RANK() OVER(PARTITION BY DEPTNO ORDER BY SAL*12+NVL(COMM,0) DESC) "전체급여순위"
       ,RANK() OVER(ORDER BY SAL*12+NVL(COMM,0) DESC) "부서내연봉순위"
FROM EMP;
/*
KING	10	60000	1	1
FORD	20	36000	1	2
SCOTT	20	36000	1	2
JONES	20	35700	3	4
BLAKE	30	34200	1	5
CLARK	10	29400	2	6
ALLEN	30	19500	2	7
TURNER	30	18000	3	8
MARTIN	30	16400	4	9
MILLER	10	15600	3	10
WARD	30	15500	5	11
ADAMS	20	13200	4	12
JAMES	30	11400	6	13
SMITH	20	9600    	5	14
*/
SELECT T.*
       ,RANK() OVER(PARTITION BY DEPTNO ORDER BY T.연봉 DESC) "전체급여순위"
       ,RANK() OVER(ORDER BY T.연봉 DESC) "부서내연봉순위"

FROM(
SELECT ENAME, DEPTNO, SAL*12+NVL(COMM,0) "연봉"
FROM EMP
) T;


--○EMP 테이블에서 전체 연봉 순위(등수)가 1등부터 5등 까지만..
-- 사원명, 부서번호,연봉,전체연봉순위 항목으로 조회

SELECT ENAME "사원명" , DEPTNO "부서번호", SAL*12+NVL(COMM,0) "연봉"
       ,RANK() OVER(ORDER BY SAL*12+NVL(COMM,0) DESC) "전체연봉순위"
FROM EMP
WHERE RANK() OVER(ORDER BY SAL*12+NVL(COMM,0) DESC) <=5;
--window  functions are not allowed here
--WHERE에서 RANK() OVER를 쓸수없다.


SELECT T.*
FROM
(
SELECT ENAME "사원명" , DEPTNO "부서번호", SAL*12+NVL(COMM,0) "연봉"
       ,RANK() OVER(ORDER BY SAL*12+NVL(COMM,0) DESC) "전체연봉순위"
FROM EMP
)T
WHERE T.전체연봉순위 <=5;

--○EMP 테이블에서 각 부서별로 연봉 등수가 1등 부터 2등 까지만 조회한다.
--  사원명,부서번호,연봉,부서내연봉등수,전체연봉등수
--  항목을 조회할 수 있도록 한다.

SELECT T.*
FROM(
SELECT ENAME "사원명" ,DEPTNO "부서번호", SAL*12+NVL(COMM,0) "연봉"
       , RANK() OVER(PARTITION BY DEPTNO ORDER BY SAL*12+NVL(COMM,0) DESC) "부서내연봉등수"
       , RANK() OVER(ORDER BY SAL*12+NVL(COMM,0) DESC) "전체연봉등수"
FROM EMP
) T
WHERE T.부서내연봉등수<=2;

--※ 정정
--TRIM() 함수 존재함~!!!
SELECT TRIM('     TEST     ') "결과"
FROM DUAL;
--TEST

--LN() 자연 로그 함수 존재함~!!!
SELECT LN(95) "RESULT"
FROM DUAL;

--■■■ 그룹 함수 ■■■---

--SUM() 합, AVG() 평균, COUNT() 카운트, MAX() 최대값, MIN() 최소값
-- , VARIENCE() 분산, STDDEV()표준편차

--※그룹 함수의 가장 큰 특징
-- 처리해야 할 데이터들 중 NULL이 존재한다면(포함되어 있다면)
-- 이 NULL은 제외한 상태로 연산을 수행한다는 것이다.
-- 즉,NULL은 연산의 대상에서 제외된다.

--○SUM() 합
-- EMP 테이블을 대상으로 전체 사원들의 급여 총합을 조회한다.
SELECT SUM(SAL)
FROM EMP;
--29025 총합

SELECT SUM(COMM) --NULL+300+500.... (x)
FROM EMP;
--==>2200 NULL을 제외하고 연산한다.

--○COUNT() 행(레코드)의 갯수 조회 -> 데이터가 몇 건인지 확인...
SELECT COUNT(ENAME)
FROM EMP;
--==>>14

SELECT COUNT(COMM)
FROM EMP;
--==>>4 NULL을 세지 않음

SELECT COUNT(*)
FROM EMP;
--특정 컬럼을 명시하지않고 보통 이렇게 쓴다.

--○AVG() 평균 반환
SELECT AVG(SAL) "COL"
       ,SUM(SAL) / COUNT(SAL) "COL2"
FROM EMP;
--2073.214285714285714285714285714285714286	
--2073.214285714285714285714285714285714286

SELECT AVG(COMM) "COL1"
      ,SUM(COMM) / COUNT(COMM) "COL2"
      FROM EMP;
      
      --==>>550	550

SELECT 2200 /14 "result"
FROM DUAL;
--==>>157.142857142857142857142857142857142857
--550이 아니라 이게 맞는값이다.

--※데이터가 NULL인 컬럼의 레코드는 연산대상에서 제외되기 때문에
--  주의하여 연산 처리해야 한다.

--VARIANCE(), STDDEV()
--※표준편차의 제곱이 분산, 분산의 제곱근이 표준편차다.

SELECT VARIANCE(SAL), STDDEV(SAL)
FROM EMP;
--==>>1398313.87362637362637362637362637362637
--==>>1182.503223516271699458653359613061928508
SELECT POWER(STDDEV(SAL),2) "COL1"   --표준 편차 제곱
       ,VARIANCE(SAL) "COL2"
FROM EMP;
--1398313.87362637362637362637362637362637
--1398313.87362637362637362637362637362637


SELECT SQRT(VARIANCE(SAL)) "COL1"
    ,   STDDEV(SAL) "COL2"
FROM EMP;
--==>>
/*
1182.503223516271699458653359613061928508
1182.503223516271699458653359613061928508
*/

--○MAX() / MIN()
--   최대값 / 최소값 반환

SELECT MAX(SAL) "COL1"
       ,MIN(SAL) "COL2"
FROM EMP;
--5000	800


--※주의
SELECT ENAME, SUM(SAL)
FROM EMP;
--ORA-00937: not a single-group group function

SELECT SUM(SAL)
FROM EMP;

SELECT DEPTNO, SUM(SAL)
FROM EMP;
-->에러
--ORA-00937: not a single-group group function

SELECT DEPTNO, SUM(SAL)
FROM EMP
GROUP BY DEPTNO;
--==>>
/*
30	9400
20	10875
10	8750
*/

SELECT DEPTNO, SUM(SAL)
FROM EMP
GROUP BY DEPTNO
ORDER BY 1;
/*
10	8750
20	10875
30	9400
*/

SELECT DEPTNO,SAL
FROM EMP
ORDER BY 1;

/*
10	2450ㄱ
10	5000 ｜
10	1300」
20	2975ㄱ
20	3000｜
20	1100｜
20	800 ｜
20	3000」
30	1250ㄱ
30	1500｜
30	1600｜
30	950 ｜
30	2850｜
30	1250」
*/

DROP TABLE TBL_EMP;

--○실습 테이블 다시 생성
CREATE TABLE TBL_EMP
AS 
SELECT *
FROM EMP;

--○실습 데이터 추가 입력
INSERT INTO TBL_EMP VALUES
(8001, '김태민', 'CLERK',7566,SYSDATE,1500,10,NULL);

INSERT INTO TBL_EMP VALUES
(8002, '조현하', 'CLERK',7566,SYSDATE,2000,10,NULL);

INSERT INTO TBL_EMP VALUES
(8003, '김보경', 'SALESMAN',7698,SYSDATE,1700,NULL,NULL);

INSERT INTO TBL_EMP VALUES
(8004, '유동현', 'SALESMAN',7698,SYSDATE,2500,NULL,NULL);

INSERT INTO TBL_EMP VALUES
(8005, '장현성', 'SALESMAN',7698,SYSDATE,1000,NULL,NULL);

SELECT*
FROM TBL_EMP;
/*
7369	SMITH	CLERK	7902    	80/12/17    	800		    20
7499	ALLEN	SALESMAN	7698	81/02/20	    1600    	300	30
7521    	WARD	SALESMAN	7698	81/02/22	    1250    	500	30
7566	JONES	MANAGER	7839	81/04/02	    2975		    20
7654	MARTIN	SALESMAN	7698	81/09/28	    1250	    1400	30
7698	BLAKE	MANAGER	7839	81/05/01    	2850		    30
7782	    CLARK	MANAGER	7839	81/06/09    	2450		    10
7788	SCOTT	ANALYST	7566	87/07/13    	3000	    	20
7839	KING	PRESIDENT		81/11/17	5000		    10
7844	TURNER	SALESMAN	7698	81/09/08    	1500	    0	30
7876	ADAMS	CLERK	7788	87/07/13	    1100	    	20
7900	    JAMES	CLERK	7698	81/12/03    	950		    30
7902    	FORD	ANALYST	7566	81/12/03	    3000		    20
7934	MILLER	CLERK	7782	    82/01/23	    1300	    	10
8001    	김태민	CLERK	7566	22/08/18	    1500      	10	
8002	    조현하	CLERK	7566	22/08/18	    2000	        10	
8003	    김보경	SALESMAN	7698	22/08/18	    1700		
8004	    유동현	SALESMAN	7698	22/08/18    	2500		
8005	    장현성	SALESMAN	7698	22/08/18    	1000		
*/

COMMIT;

SELECT DEPTNO, SAL, COMM
FROM TBL_EMP
ORDER BY COMM DESC;
/*
20	800	
	1700	
	1000	
10	1300	
20	2975	
30	2850	
10	2450	
20	3000	
10	5000	
	2500	
20	1100	
30	950	
20	3000	
30	1250	    1400
30	1250	    500
30	1600    	300
	1500    	10
	2000	    10
30	1500    	0

*/

--※오라클은 NULL을 가장 큰값으로 간주한다.
--(ORACLE 9i 까지는 NULL이 가장 작은값이었다.)
--MSSQL 은 NULL을 가장 작은 값으로 간주한다.

--TBL_EMP 테이블을 대상으로 부서별 급여합 조회
-- 부서번호, 급여합 항목 조회
SELECT DEPTNO "부서번호", SUM(SAL) "급여합"
FROM TBL_EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;
/*
10	8750
20	10875
30	9400
	8700    --부서번호가 NULL인 사원들의 급여합
*/

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

/*10	8750
20	10875
30	9400
모든부서	29025

*/

SELECT NVL2(DEPTNO, TO_CHAR(DEPTNO),'모든부서')"부서번호",SUM(SAL)"급여합"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);

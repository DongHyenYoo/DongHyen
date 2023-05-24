
--○TBL_FILES 테이블을 조회하여
-- 다음과 같은 결과를 얻을 수 있도록 쿼리문을 구성한다.

SELECT FILENO "파일번호"
      ,REVERSE(SUBSTR(REVERSE(FILENAME),1,INSTR(REVERSE(FILENAME),'\',1)-1)) "파일명"
FROM TBL_FILES;

SELECT FILENO "파일번호"
      ,SUBSTR(FILENAME,INSTR(FILENAME,'\',-1)+1) "파일명" --Index값은 양수가 나온다.
FROM TBL_FILES;

--○LPAD()
-->BYTE를 확보하여 왼쪽부터 문자로 채우는 기능을 가진 함수
SELECT 'ORACLE' "COL1"
       ,LPAD('ORACLE',10,'*') "COL2" --10바이트의 공간을 확보해라 
FROM DUAL;
--1.10Byte 공간을 확보한다.
--2.확보한 공간에 첫번째 파라미터인 'ORACLE'을 담는다.
--3.남은 Byte공간을 세번째 파라미터인 * 로 왼쪽부터 채운다.

--○RPAD()
-->Byte를 확보하여 오른쪽부터 문자로 채우는 기능을 가진 함수
SELECT 'ORACLE' "COL1"
       ,RPAD('ORACLE',10,'*') "COL2" --10바이트의 공간을 확보해라 
FROM DUAL;

--○LTRIM()
SELECT 'ORAORAORAORAORAORACLEORACLE' "COL1"
      , LTRIM('ORAORAORAORAORACLEORACLE','ORA') "COL2"
      , LTRIM('AAAAAAORAORACLEORACLE','ORA') "COL3"
      , LTRIM('ORAORAORAoRAORACLEORACLE','ORA') "COL4" --대소문자를 구별해서 잘라내므로 소문자를 만나면 작동중지
      , LTRIM('ORAORAOR AORAORACLEORACLE','ORA') "COL5"
      , LTRIM('             RACLEORACLE',' ') "COL6" --공백을 자를때는 두번째 파라미터 생략 가능
FROM DUAL;
--ORAORAORAORAORAORACLEORACLE	CLEORACLE
--자른부분을 버리고 남은부분을 반환한다.
--'O','R','A'이렇게 하나씩 자른다.
--ORAORAORAORAORAORACLEORACLE
--CLEORACLE
--CLEORACLE
--oRAORACLEORACLE
--AORAORACLEORACLE
--RACLEORACLE
--첫 번째 파라미터 값에 해당하는 문자열을
--왼쪽부터 연속적으로 등장하는 두 번째 파라미터 값에서 지정한 글자와
-- 같은 글자가 등장할 경우 이를 제거한 결과 값을 반환
--단, 완성형 처리는 x
--중간에 두번째 파라미터에 없는 문자를 만나면 작동중지된다.

--○RTRIM()
--위와 동일


--○TRANSLATE()
-->1:1 로 바꿔준다.--문자열을 문자별로 1:1 교환
SELECT TRANSLATE('MY ORACLE SERVER'
                 , 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
                 , 'abcdefghijklmnopqrstuvwxyz') "COL1"
FROM DUAL;
--my oracle server

SELECT TRANSLATE('010-3578-3912'
                 , '0'
                 , '공') "COL1"
FROM DUAL;
--공1공-3578-3912

SELECT TRANSLATE('010-3578-3912'
                 , '0123456789'
                 , '공일이삼사오육칠팔구') "COL1"
FROM DUAL;
--공일공-삼오칠팔-삼구일이


--○REPLACE() --뭉텡이로 바꾸기
SELECT REPLACE('MY ORACLE SERVER ORAHOME','ORA','오라')"COL1"
FROM DUAL;

--ROUND() 반올림을 처리해 주는 함수
SELECT 48.678 "COL1"
      ,ROUND(48.678,2) "COL2" --소수점 이하 둘째자리까지 표현해라
      ,ROUND(48.674,2) "COL3"
      ,ROUND(48.678,1) "COL4"
      ,ROUND(48.678,0) "COL5"
      ,ROUND(48.678) "COL6"
      ,ROUND(48.678,-1) "COL7"
      ,ROUND(48.678,-2) "COL8"
      ,ROUND(48.678,-3) "COL9"
FROM DUAL;

--○TRUNC() 절삭을 처리해 주는 함수
SELECT 48.678 "COL1"
      , TRUNC(48.678,2) "COL2"
      , TRUNC(48.674,2) "COL3"
      , TRUNC(48.674,1) "COL4"
      , TRUNC(48.674,0) "COL5"
      , TRUNC(48.674) "COL6"
      , TRUNC(48.674,-1) "COL7"
      , TRUNC(48.674,-2) "COL8"
      , TRUNC(48.674,-3) "COL9"
FROM DUAL;

--○MOD() 나머지를 반환하는 함수
SELECT MOD(5,2) "COL1"
FROM DUAL;
-->5를 2로 나눈 나머지 결과값 반환
--==>>1

--○POWER() 제곱의 결과를 반환하는 함수
SELECT POWER(5,3) "COL1"
FROM DUAL;
-->5의 3승을 결과값으로 반환
--==>>125

--○SQRT() 루트 결과값을 반환하는 함수
SELECT SQRT(2) "COL1"
FROM DUAL;
-->루트 2에 대한 결과값
--=>1.41421356237309504880168872420969807857

--○LOG() 로그 함수
-- 오라클은 상용로그만 지원하는 반면, MYSQL은 상용로그,자연로그 모두 지원
SELECT LOG(10,100)"COL1"
      ,LOG(10,20) "COL2"
FROM DUAL;

--==>>2	1.30102999566398119521373889472449302677


--○삼각함수(범위: -1 ~ 1)
SELECT SIN(0.5), COS(0.5), TAN(0.5)
FROM DUAL;

--0.4794255386042030002732879352155713880819	0.8775825618903727161162815826038296520119	0.5463024898437905132551794657802853832851

--○삼각함수의 역함수(범위: -1 ~ 1)
SELECT ASIN(0.5), ACOS(0.5), ATAN(0.5)
FROM DUAL;
/*
0.52359877559829887307710723054658381405	1.04719755119659774615421446109316762805	0.4636476090008061162142562314612144020295
*/
-->각각 어싸인, 어코싸인, 어탄젠트 결과 값을 반환한다.

--SIGN() 서명 부호 특징
-->연산 결과값이 양수이면 1, 0이면 0, 음수이면 -1을 반환한다.
SELECT SIGN(5-2) "COL1"
       ,SIGN(5-5) "COL2"
       ,SIGN(5-7) "COL3"
FROM DUAL;
-->>1	0	-1
-->매출이나 수지에 관련하여 적자 및 흑자의 개념을 나타낼때 종종 사용된다.

--○ASCII(), CHR() -> 서로 대응(상응)하는 함수
SELECT ASCII('A') "COL1"
      ,CHR(65) "COL2"
FROM DUAL;
--==>65	A
-->ASCII() : 매개변수로 넘겨받은 문자의 아스키코드 값을 반환
-->CHR() : 매개변수로 넘겨받은 아스키코드 값으로 해당 문자를 반환한다.


--------------------------------------------------
--※날짜 관련 세션 설정 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
--==>Session이 변경되었습니다.

--※날짜 연산의 기본단위 : day 즉 일수이다.
SELECT SYSDATE "COL1"   --2022-08-17 11:14:40
       ,SYSDATE+1 "COL2"  --2022-08-18 11:14:40
       ,SYSDATE-2 "COL3" --2022-08-15 11:14:40
       ,SYSDATE+30 "COL4" --2022-09-16 11:14:40
FROM DUAL;


--○시간 단위 연산
SELECT SYSDATE "COL1"
    ,SYSDATE + 1/24 "COL2"
    ,SYSDATE - 2/24 "COL3"
FROM DUAL;


--○현재 시간과 현재시간 기준 1일 2시간 3분 4초후를 조회

SELECT SYSDATE "현재시간"
       ,SYSDATE+1+2/24+3/(24*60)+4/(24*60*60) "이후"
FROM DUAL;

SELECT SYSDATE + ((1*24*60*60) + (2*60*60) + (3*60) + 4) / (24*60*60) "COL4" 
FROM DUAL;

--○날짜 - 날짜 -> 일수
SELECT TO_DATE('2023-01-16','YYYY-MM-DD') - TO_DATE('2022-06-27','YYYY-MM-DD') "COL1"
FROM DUAL;
--203

SELECT TO_DATE('2022-13-17', 'YYYY-MM-DD') "COL1"
FROM DUAL;
--TO_DATE()함수를 통해 문자 타입을 날짜 타입으로 변환을 수행하는 과정에서
-- 내부적으로 해당 날짜에 대한 유효성 검사가 이루어진다.
--ORA-01843: not a valid month

--○ADD_MONTHS() 개월 수를 더해주는 함수
SELECT SYSDATE "COL1"
      ,ADD_MONTHs(SYSDATE ,2) "COL2"
      ,ADD_MONTHs(SYSDATE ,3) "COL3"
      ,ADD_MONTHs(SYSDATE ,-2) "COL4"
      ,ADD_MONTHs(SYSDATE ,-3) "COL5"
FROM DUAL;
/*
2022-08-17 11:38:15	
2022-10-17 11:38:15
2022-11-17 11:38:15
2022-06-17 11:38:15	
2022-05-17 11:38:15
*/

--○MONTHS_BETWEEN()
--첫번째 인자값에서 두번째 인자값을 뺀 개월 수를 반환한다. -> 단위 : 개월 수

SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE('2002-05-31','YYYY-MM-DD')) "COL1"
FROM DUAL;
--242.564126344086021505376344086021505376

-->개월 수의 차이를 반환하는 함수
-- 결과값의 부호가 - 음수 로 반환되었을 경우에는
-- 첫 번째 인자값에 해당하는 날짜보다
-- 두 번째 인자값에 해당하는 날짜가 미래 라는 의미로 확인할 수 있다.

--○NEXT_DAY()
SELECT NEXT_DAY(SYSDATE,'토') "COL1"
      ,NEXT_DAY(SYSDATE,'월') "COL2"
FROM DUAL;
-->>2022-08-20 11:44:06
--  2022-08-22 11:46:30


--※추가 세션 설정 변경
ALTER SESSION SET NLS_DATE_LANGUAGE = 'ENGLISH';
--이렇게 바꾸면 한글이 들어간부분이 에러가 나게됨
--한글로 썻던걸 다시 영어로

SELECT NEXT_DAY(SYSDATE,'SAT') "COL1"
      ,NEXT_DAY(SYSDATE,'MON') "COL2"
FROM DUAL;

ALTER SESSION SET NLS_DATE_LANGUAGE = 'KOREAN';

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
--년월일만 나오게 세션변경

--○ LAST_DAY()
--> 해당 날짜가 포함되어 있는 그 달의 마지막 날을 반환한다
SELECT LAST_DAY(SYSDATE) "COL1"
    ,  LAST_DAY(TO_DATE('2020-02-10','YYYY-MM-DD')) "COL2"
    ,  LAST_DAY(TO_DATE('2019-02-10','YYYY-MM-DD')) "COL3"    
FROM DUAL;
--==>>2022-08-31   2020-02-29   2019-02-28

--○ 오늘부로... 태민이가 군대에 다시 끌려(?)간다......
--   복무 기간은 22개월로 한다

-- 1. 전역 일자를 구한다.

-- 2. 하루 꼬박꼬박 3끼 식사를 한다고 가정하면
--    태민이가 몇 끼를 먹어야 집에 보내줄까...

SELECT (ADD_MONTHS(SYSDATE,22)-SYSDATE)*3
FROM DUAL;


--○현재 날짜 및 시각으로부터..
-- 수료일(2023-01-16 18:00:00)까지
-- 남은 기간을... 다음과 같은 형태로 조회할 수 있도록 쿼리문을 구성한다.



SELECT SYSDATE "현재시각"
       ,TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS') "수료일"
       ,TRUNC((TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')
       - SYSDATE),0)"일"
       ,TRUNC(24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)),0)"시간"
       ,TRUNC(60*((24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)))
       -TRUNC(24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)),0)),0)  "분"
       ,TRUNC(60*(60*((24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)))
     -TRUNC(24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)),0))
     -TRUNC(60*((24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)))
     -TRUNC(24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)),0)))),0)  "초"
FROM DUAL;


-- 『1일 2시간 3분 4초』를... 『초』로 환산하면...
SELECT (1일) + (2시간) + (3분) + (4초)
FROM DUAL;

SELECT (1*24*60*60) + (2*60*60) + (3*60) + (4)
FROM DUAL;
--==>>93784

-- 『93784』를... 다시 『일, 시간, 분, 초』로 환산하면...

SELECT  TRUNC(TRUNC(TRUNC(93784/60)/60)/24)"일"
    ,   MOD(TRUNC(TRUNC(93784/60)/60),24)"시간"
    ,   MOD(TRUNC(93784/60),60) "분" --60으로 나누어지지 않은 것은 60분=1시간이 안되는 진짜 분을 의미할것!
    ,   MOD(93784, 60) "초"
FROM DUAL;


SELECT SYSDATE "현재"
       ,TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS') "수료일"
       ,TRUNC(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-SYSDATE) "일"
       ,TRUNC(MOD((TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-SYSDATE)*24,24)) "시"
       ,TRUNC(MOD((TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-SYSDATE)*24*60,60)) "분"
       ,TRUNC(MOD((TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-SYSDATE)*24*60*60,60)) "초"
FROM DUAL;


ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';

--※날짜 데이터를 대상으로 반올림, 절삭 등의 연산을 수행할 수 있다.
--○날짜 반올림
SELECT SYSDATE "COL1"                 --기본 현재 날짜
       ,ROUND(SYSDATE, 'YEAR') "COL2" -- 2023-01-01연도까지 유효한 데이터(상반기/하반기 기준)
       ,ROUND(SYSDATE, 'MONTH') "COL3" -- 2022-09-01월까지 유효한 데이터(15일 기준)
       ,ROUND(SYSDATE, 'DD') "COL4"   --2022-08-18일까지 유효한 데이터(정오 기준)
       ,ROUND(SYSDATE, 'DAY') "COL5"  -- 2022-08-21일까지 유효한 데이터(수요일 정오기준)
FROM DUAL;

--○날짜 절삭
SELECT SYSDATE "COL1"                 --기본 현재 날짜
       ,TRUNC(SYSDATE, 'YEAR') "COL2" -- 2022-01-01연도까지 유효한 데이터
       ,TRUNC(SYSDATE, 'MONTH') "COL3" --2022-08-01 월까지 유효한 데이터
       ,TRUNC(SYSDATE, 'DD') "COL4"   --2022-08-17일까지 유효한 데이터
       ,TRUNC(SYSDATE, 'DAY') "COL5"  -- 2022-08-14그 전 주에 해당하는 일요일
FROM DUAL;

---■■■ 변환 함수 ■■■-----

--TO_CHAR() 숫자나 날짜 데이터를 문자 타입으로 변환시켜주는 함수
--TO_DATE() 문자 데이터를 날짜 타입으로 변환시켜주는 함수
--TO_NUMBER() 문자 데이터를 숫자 타입으로 변환시켜주는 함수


--○날짜형 -> 문자형
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') "COL1" --2022-08-17
       ,TO_CHAR(SYSDATE, 'YYYY') "COL2"      --2022
       ,TO_CHAR(SYSDATE, 'YEAR') "COL3"     --TWENTY TWENTY-TWO
       ,TO_CHAR(SYSDATE, 'MM') "COL4"       --08
       ,TO_CHAR(SYSDATE, 'MONTH') "COL5"    --AUGUST   
       ,TO_CHAR(SYSDATE, 'MON') "COL6"      --AUG
       ,TO_CHAR(SYSDATE, 'DD') "COL7"       --17
       ,TO_CHAR(SYSDATE, 'MM-DD') "COL8"    --08-17
       ,TO_CHAR(SYSDATE, 'DAY') "COL9"      --WEDNESDAY
       ,TO_CHAR(SYSDATE, 'DY') "COL10"      --WED
       ,TO_CHAR(SYSDATE, 'HH24') "COL11"    --17
       ,TO_CHAR(SYSDATE, 'HH') "COL12"      --05
       ,TO_CHAR(SYSDATE, 'HH AM') "COL13"   --05 PM
       ,TO_CHAR(SYSDATE, 'HH PM') "COL14"   --05 PM
       ,TO_CHAR(SYSDATE, 'MI') "COL15"      --11
       ,TO_CHAR(SYSDATE, 'SS') "COL16"      --46
       ,TO_CHAR(SYSDATE, 'SSSSS') "COL17"   --61906 시간초
       ,TO_CHAR(SYSDATE, 'Q') "COL18"       --3 분기
       FROM DUAL;
       
--※날짜나 통화 형식이 맞지 않을 경우...
--  설정값을 통해 세션을 설정할 수 있다.

ALTER SESSION SET NLS_LANGUAGE = 'ENGLISH';
ALTER SESSION SET NLS_DATE_LANGUAGE = 'ENGLISH';
ALTER SESSION SET NLS_CURRENCY = '$'; --￦ 표시
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';

--○숫자형 -> 문자형
SELECT 7 "COL1"
       ,'7' "COL2"
       ,TO_CHAR(7) "COL3"
FROM DUAL;
-->조회결과의 정렬이 어떤지 확인
--숫자는 우측정렬
--문자는 좌측정렬

--○문자형 -> 숫자형
SELECT TO_NUMBER('4') "COL1"
      ,'4' "COL2"
      ,4 "COL3"
      ,TO_NUMBER('04') "COL4" --숫자로 변환되며 0이 탈락되어 4
FROM DUAL;
--4	4	4	4
--조회 결과가 좌측 정렬인지 우측 정렬인지 확인~!!!


--○현재 날짜에서 현재 년도(2022)를 숫자 형태로 조회(반환)

SELECT TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) "연도(숫자형)"
FROM DUAL;
--조회결과 우측정렬로 숫자형 확인

--○EXTRACT()

SELECT TO_CHAR(SYSDATE, 'YYYY') "COL1" --2022 ->연도를 추출하여 문자 타입으로..
       ,TO_CHAR(SYSDATE,'MM') "COL2"   --08  -> 월을 추출하여 문자 타입으로...
       ,TO_CHAR(SYSDATE,'DD') "COL3"   --17  -> 일을 추출하여 문자 타입으로..
       ,EXTRACT(YEAR FROM SYSDATE) "COL4" --2022(숫자형)  -> 연도를 추출하여 숫자 타입으로
       ,EXTRACT(MONTH FROM SYSDATE) "COL5"    --8(숫자형) -> 월을 추출하여 숫자 타입으로
       ,EXTRACT(DAY FROM SYSDATE) "COL6"    --17 -> 일을 추출해서 숫자 타입으로..
FROM DUAL;

-->년,월,일 이외의 다른 항목은 불가~!!

--○ TO_CHAR() 활용 → 형식 맞춤 표기 결과값 반환
SELECT 60000 "COL1"
     , TO_CHAR(60000, '99,999') "COL2"
     , TO_CHAR(60000, '$99,999') "COL3"
     , TO_CHAR(60000, 'L99,999') "COL4"
     , LTRIM(TO_CHAR(60000, 'L99,999')) "COL5"
FROM DUAL;
--==>> 60000    60,000    $60,000           ￦60,000   ￦60,000


ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
--==>> Session이(가) 변경되었습니다.

--○ 현재 시간을 기준으로 1일 2시간 3분 4초 후를 조회한다.

SELECT SYSDATE "현재시간"
     , SYSDATE + 1 + (2/24) + (3/(24*60)) + (4/(24*60*60)) "1일 2시간 3분 4초 후"
FROM DUAL;

--○ 현재 시간을 기준으로 1년 2개월 3일 4시간 4분 6초 후를 조회한다.
-- TO_YMINTERVAL(), TO_DSINTERVAL()
--  연월              일부터 초까지

SELECT SYSDATE "현재시간"
     , SYSDATE + TO_YMINTERVAL('01-02') "연산결과"
     , SYSDATE + TO_DSINTERVAL('003 04:05:06') "연산결과"
FROM DUAL;
 
--==>>     2023-10-17 17:47:49   
--         2022-08-20 21:52:55



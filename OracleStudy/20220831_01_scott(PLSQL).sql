SELECT USER
FROM DUAL;

SET SERVEROUTPUT ON; --첫 접속시 무조건 실행

--○변수에 임의의 값을 대입하고 출력하고 구문 작성
DECLARE
    GRADE CHAR;
    
BEGIN
    GRADE := 'A';
    
    IF GRADE = 'A'
        THEN DBMS_OUTPUT.PUT_LINE('EXCELLENT');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('FAIL');
    END IF;
END;

--EXCELLENT


DECLARE
    GRADE CHAR;
BEGIN
    GRADE := 'B';
    
    IF GRADE = 'A'
        THEN DBMS_OUTPUT.PUT_LINE('EXCELLENT');
    ELSIF GRADE = 'B'
        THEN DBMS_OUTPUT.PUT_LINE('GOOD');
    ELSE
        DBMS_OUTPUT.PUT_LINE('FAIL');
    END IF;
END;

--GOOD

--○ CASE 문(조건문)
-- CASE ~ WHEN ~ THEN ~ ELSE ~ END CASE;
--앞의 CASE와 기능은 같으나 END CASE로 끝난다.

--1.형식 및 구조

/*
CASE 변수
    WHEN 값1 THEN 실행문1;
    WHEN 값2 THEN 실행문2;
    ELSE 실행문N+1;
END CASE;
*/

--남자1 여자2 입력하세요
--1
--남자입니다.


--남자1 여자2 입력하세요
--2
--여자입니다.

--입력하라는 안내 자바에서 BR.READLINE전에 쓰는 PRINT 같은구문

ACCEPT NUM PROMPT '남자1 여자2 입력하세요';

DECLARE
    --선언부 →주요 변수 선언
    SEL NUMBER := &NUM; --위의 남자1 여자2 에서 입력받은 NUM값을 가져오기위한 변수선언
    RESULT VARCHAR2(10) := '남자';
    
BEGIN
    --테스트
    --DBMS_OUTPUT.PUT_LINE('SEL : ' || SEL);
    --DBMS_OUTPUT.PUT_LINE('RESULT : ' || RESULT);
    
    /*
    CASE SEL
        WHEN 1
        THEN DBMS_OUTPUT.PUT_LINE('남자입니다.');
        WHEN 2
        THEN DBMS_OUTPUT.PUT_LINE('여자입니다.');
        ELSE 
        DBMS_OUTPUT.PUT_LINE('확인불가');
    END CASE;
    */
    
    CASE SEL
        WHEN 1
        THEN RESULT := '남자';
        WHEN 2
        THEN RESULT := '여자';
        ELSE
            RESULT := '확인불가';
    END CASE;
    
    --결과 출력
    DBMS_OUTPUT.PUT_LINE('처리 결과는' || RESULT || '입니다.');
END;

--1,2를 제외한 값에서 ORA-06502: PL/SQL: numeric or value error: character string buffer too small
--이와 같은 에러가 나는이유는
--지금 사용중인 오라클의 캐릭터셋이 AL32UTF8 로 한글이 3바이트를 차지하는 캐릭터셋이기 때문
--즉 ELSE 구문은 12바이트 RESULT에 할당된 바이트는 10으로 변수의 크기를 2바이트 초과하기에 나오는에러
--변수 크기를 12 OR 더 늘리면 에러가 나오지 않는다.

--○ 외부 입력 처리
--ACCEPT 구문

--ACCEPT 변수명 PROMPT '메세지';
--→외부 변수로부터 입력받은 데이터를 내부 변수에 전달할 때
-- 『&외부변수명』 형태로 접근하게 된다.



--○정수 두 개를 외부로부터(사용자로부터)입력받아
-- 이들의 덧셈결과를 출력하는 PL/SQL  문 작성

ACCEPT NUM1 PROMPT '첫번째 숫자 입력';
ACCEPT NUM2 PROMPT '두번째 숫자 입력';

DECLARE
    FIRNUM NUMBER := &NUM1;
    SECNUM NUMBER := &NUM2;
    --TOTAL NUMBER :=0;
BEGIN
    --TOTAL := FIRNUM + SECNUM;
    DBMS_OUTPUT.PUT_LINE('덧셈 결과는' || (FIRNUM+SECNUM) ||'입니다');
    
END;

--○사용자로부터 입력받은 금액을 화폐 단위로 구분하여 출력하는 프로그램을 작성한다.
--  단,반환 금액은 편의상 1천원 미만, 10원 이상만 가능하다고 가정한다.
/*
실행 예)
바인딩 변수 입력 대화창 → 금액 입력 : 990

입력받은 금액 총액 : 990원
화폐단위 : 오백원 1, 백원 4, 오십원 1, 십원 4

*/

ACCEPT M PROMPT '금액을 입력해 주세요';

DECLARE
    MONEY NUMBER := &M;
    OBACK NUMBER;
    BACK NUMBER;
    OSIB NUMBER;
    SIB NUMBER;
    
BEGIN
    
    OBACK := TRUNC(MONEY / 500);
    BACK := TRUNC((MONEY - (OBACK*500))/100);
    OSIB := TRUNC((MONEY - ((OBACK*500)+(BACK*100))) / 50);
    SIB := TRUNC((MONEY - ((OBACK*500)+(BACK*100)+(OSIB*50))) /10);
    
    DBMS_OUTPUT.PUT_LINE('오백원' || OBACK || ', 백원' || BACK || ', 오십원' || OSIB || ', 십원' || SIB);
END;


ACCEPT M PROMPT '금액을 입력해 주세요';

DECLARE

    --주요 변수 선언
    MONEY NUMBER := &M;
    MONEY2 NUMBER := &M; --연산과정에서 MONEY가 줄어들기에
    
    M500 NUMBER;
    M100 NUMBER;
    M50 NUMBER;
    M10 NUMBER;
    
BEGIN
    --연산처리
    --MONEY 를 500으로 나눠서 몫을 취하고 나머지는 버린다. → 500원의 갯수
    M500 := TRUNC(MONEY / 500);
        
    --MONEY를 500으로 나눠서 몫은 버리고 나머지를 취한다. →500원의 갯수 확인하고 남은 금액
    -- 이 결과를 다시 MONEY에 담아낸다.
    MONEY := MOD(MONEY,500);
    
    --MONEY를 100으로 나눠서 몫을 취하고 나머지는 버린다.
    M100 := TRUNC(MONEY / 100);
    MONEY := MOD(MONEY,100);
    
    M50 := TRUNC(MONEY / 50);
    MONEY := MOD(MONEY,50);
    
    M10 := TRUNC(MONEY / 10);
    
    DBMS_OUTPUT.PUT_LINE('입력받은 금액 : ' || MONEY2);
    DBMS_OUTPUT.PUT_LINE('오백원' || M500 || ', 백원' || M100 || ', 오십원' || M50 || ', 십원' || M10);
END;


--○기본 반복문
--LOOP ~ END LOOP;

--1.조건과 상관없이 무조건 반복하는 구문.

--2.형식 및 구조
/*
LOOP
    --실행문
    EXIT WHEN 조건; --조건이 참인 경우 반복문을 빠져나간다.
END LOOP;
*/

DECLARE
    NUM NUMBER := 1;
    
BEGIN
    LOOP
    DBMS_OUTPUT.PUT_LINE(NUM);
    NUM := NUM+1;
    EXIT WHEN NUM>=11;
    END LOOP;
END;


--○WHILE 반복문
-- WHILE LOOP ~ END LOOP;

--1.제어 조건이 TRUE인 동안 일련의 문장을 반복하기 위해
-- WHILE LOOP구문을 사용한다.
-- 조건은 반복이 시작되는 시점에 체크하게 되어
-- LOOP내의 문장이 한번도 수행되지 않을 경우도 있다.
-- LOOP를 시작할 때 조건이 FALSE이면 반복 문장 탈출

--2.형식 및 구조
/*
WHILE 조건 LOOP    --조건이 참일경우 반복 수행
        --실행문;
END LOOP;
*/

--1부터 10까지의 수 출력(WHILE LOOP 이용)

DECLARE
    NUM NUMBER ;
BEGIN
    NUM := 0;
    WHILE NUM < 10 LOOP
    NUM := NUM+1;
    DBMS_OUTPUT.PUT_LINE(NUM);
    END LOOP;
    
END;


--○FOR 반복문
--FOR LOOP ~ END LOOP;

--1.『시작수』에서 1씩 증가하여
--  『끝냄수』가 될 때 까지 반복 수행한다.

--2.형식 및 구조
/*
FOR 카운터 IN [REVERSE] 시작수 ..끝냄수 LOOP
    --실행문
END LOOP;
*/

--○1부터 10까지의 수 출력(FOR LOOP 문 활용)

DECLARE
    N NUMBER;
BEGIN
    
    FOR N IN 1 .. 10 LOOP
    DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;

--○사용자로부터 임의의 단(구구단)을 입력받아
-- 해당단수의 구구단을 출력하는 PL/SQL 구문을 작성한다.
/*
단을 입력 : 2

2*1 = 2
.
.
.
2*9 = 18
*/

--LOOP 문

ACCEPT NUM PROMPT '단을 입력하세요';

DECLARE
    DAN NUMBER := &NUM;
    GOB NUMBER := 1;
    RESULT NUMBER := 0;
BEGIN
    
    LOOP
    RESULT := DAN * GOB;
    DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || RESULT);
    EXIT WHEN GOB =9;
    GOB := GOB+1;
    END LOOP;
END;


--WHILE LOOP 문

ACCEPT NUM PROMPT '단을 입력하세요';

DECLARE
    DAN NUMBER := &NUM;
    GOB NUMBER := 1;
   
BEGIN
    WHILE GOB<10 LOOP
    DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || (DAN*GOB));
    GOB := GOB+1;
    END LOOP;
END;


--FOR LOOP문

ACCEPT NUM PROMPT '단을 입력하세요';

DECLARE
    DAN NUMBER := &NUM;
    GOB NUMBER;
   
BEGIN
    FOR GOB IN 1..9 LOOP
    DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || (DAN*GOB));
    END LOOP;
END;


--○구구단 전체(2단~9단)을 출력하는 PL/SQL구문 작성
-- 이중 반복문(반복문 중첩) 구문을 활용한다.

--FOR문 

DECLARE
    DAN NUMBER;
    GOB NUMBER;
BEGIN
    FOR DAN IN 2..9 LOOP
        DBMS_OUTPUT.PUT_LINE('====[' || DAN || '단]====');
        FOR GOB IN 1..9 LOOP
        DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
        END LOOP;
    END LOOP;
END;

--WHILE LOOP문

DECLARE
    DAN NUMBER;
    GOB NUMBER;
BEGIN
    DAN := 2;
    
    WHILE DAN<10 LOOP
        DBMS_OUTPUT.PUT_LINE('====[' || DAN || '단]====');
            GOB := 1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
        DAN := DAN+1;
    END LOOP; --단 출력
END;


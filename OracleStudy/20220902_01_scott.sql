--Transaction 처리

--ex) UPDATE 쿼리와 UPDATE쿼리를 하나로 묶은것과 같이
--한쪽이라도 쿼리문이 실행이 안되면 ROLLBACK이 되게 만든다.
--EX) 은행거래 계좌거래 같은것 한쪽에서 돈이 나가는 쿼리문 & 다른쪽에서 돈이 들어오는 쿼리문 두개중 하나라도
-- 실행되지 않는다면 전부 ROLLBACK 한다.
-- 이는 INSERT , DELETE도 써진다.


--○실습 테이블 생성(TBL_상품)

CREATE TABLE TBL_상품
( 상품코드      VARCHAR2(20)
, 상품명       VARCHAR2(100)
, 소비자가격     NUMBER
, 재고수량      NUMBER DEFAULT 0
, CONSTRAINT 상품_상품코드_PK PRIMARY KEY(상품코드)
);

--실습 테이블 생성(TBL_입고)
CREATE TABLE TBL_입고
( 입고번호  NUMBER
, 상품코드  VARCHAR2(20)
, 입고일자  DATE DEFAULT SYSDATE
, 일고수량  NUMBER
, 입고단가  NUMBER
, CONSTRAINT 입고_입고번호_PK PRIMARY KEY(입고번호)
, CONSTRAINT 입고_상품코드_FK FOREIGN KEY(상품코드) 
                            REFERENCES TBL_상품(상품코드)
);


--○TBL_상품 테이블에 상품 데이터 입력
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('C001','구구콘',1500);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('C002','월드콘',1500);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('C003','브라보콘',1300);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('C004','누가콘',1800);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('C005','슈퍼콘',1900);

INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('H001','스크류바',1000);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('H002','캔디바',300);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('H003','쌍쌍바',500);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('H004','돼지바',600);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('H005','메로나',500);

INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('E001','찰떡아이스',2500);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('E002','붕어싸만코',2000);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('E003','빵또아',2300);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('E004','거북알',2300);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('E005','쿠키오',2400);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('E006','국화빵',2000);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('E007','투게더',3000);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('E008','엑설런트',3000);
INSERT INTO TBL_상품(상품코드, 상품명, 소비자가격) VALUES('E009','셀렉션',3000);

COMMIT;

EXEC PRC_입고_INSERT('C001',20,900);


SELECT *
FROM TAB;

--■■■프로시저 내에서의 예외 처리■■■----

--○실습 테이블 생성(TBL_MEMBER)
CREATE TABLE TBL_MEMBER
( NUM   NUMBER
, NAME  VARCHAR2(30)
, TEL   VARCHAR2(60)
, CITY  VARCHAR2(60)
, CONSTRAINT MEMBER_NUM_PK PRIMARY KEY(NUM)
);



EXEC PRC_MEMBER_INSERT('임시연', '010-1111-1111', '서울');
--==>> 데이터 입력 ○

EXEC PRC_MEMBER_INSERT('김보경', '010-2222-2222', '부산');
--데이터 입력 X
--ORA-20001: 서울,경기,대전만 입력이 가능합니다.

SELECT *
FROM TBL_MEMBER;

EXEC PRC_입고_INSERT('C001',30,1200); --구구콘 30개 입고

EXEC PRC_입고_INSERT('C002',30,1200); --월드콘 30개 입고

EXEC PRC_입고_INSERT('H001',50,800);

EXEC PRC_입고_INSERT('H002',50,200);

EXEC PRC_입고_INSERT('H001',50,800);

EXEC PRC_입고_INSERT('H002',50,200);

SELECT *
FROM TBL_입고;

SELECT *
FROM TBL_상품;


--○ 실습 테이블 생성(TBL_출고)
CREATE TABLE TBL_출고
( 출고번호 NUMBER
, 상품코드 VARCHAR2(20)
, 출고일자 DATE DEFAULT SYSDATE
, 출고수량 NUMBER
, 출고단가 NUMBER
);

--Table TBL_출고 생성

--출고번호 PK 지정
ALTER TABLE TBL_출고
ADD CONSTRAINTS 출고_출고번호_PK PRIMARY KEY(출고번호);

--상품코드 FK 지정
ALTER TABLE TBL_출고
ADD CONSTRAINTS 출고_출고번호_FK FOREIGN KEY(상품코드)
                                REFERENCES TBL_상품(상품코드);

SELECT NVL(출고번호,0) --비어있다고 NULL인것이 아닌 진짜 그냥 비어있기에 아무값도 나오지 않는다.                                
FROM TBL_출고;


EXEC PRC_출고_INSERT('H001', 50, 1000);


SELECT *
FROM TBL_출고;

SELECT *
FROM TBL_상품;

ROLLBACK;

EXEC PRC_출고_UPDATE(1,50);


EXEC PRC_출고_DELETE(7);

--2번 Test 위한 입고

EXEC PRC_입고_INSERT('C001',30,1200); --구구콘 30개 입고

EXEC PRC_입고_INSERT('C002',30,1200); --월드콘 30개 입고

EXEC PRC_입고_INSERT('H001',50,800);

EXEC PRC_입고_INSERT('H002',50,200);

EXEC PRC_입고_INSERT('H001',50,800);

EXEC PRC_입고_INSERT('H005',100,200);

EXEC PRC_입고_INSERT('E001',200,200);

SELECT *
FROM TBL_입고;


SELECT *
FROM TBL_상품;

SELECT *
FROM TBL_출고;

ROLLBACK;

EXEC PRC_입고_DELETE(6);
EXEC PRC_입고_UPDATE(13,20);

EXEC PRC_출고_INSERT('E001',35,200);


EXEC PRC_출고_DELETE(9);



SELECT *
FROM TBL_상품;
/*
C001	구구콘	    1500    0
C002	월드콘	    1500	    0
C003	브라보콘	    1300	    0
C004	누가콘	    1800	    0
C005	슈퍼콘	    1900	    0
H001	스크류바	    1000	    0
H002	캔디바	    300	    0
H003	쌍쌍바	    500	    0
H004	돼지바	    600	    0
H005	메로나	    500	    0
E001	찰떡아이스	2500	    0
E002	붕어싸만코	2000	    0
E003	빵또아	    2300	    0
E004	거북알	    2300	    0
E005	쿠키오	    2400	    0
E006	국화빵	    2000	    0
E007	투게더	    3000	    0
E008	엑설런트	    3000	    0
E009	셀렉션	    3000    	0
*/

SELECT *
FROM TBL_입고;


/*
내역없음
*/

SELECT *
FROM TBL_출고;

/*
내역없음
*/


EXEC PRC_입고_INSERT('C001',30,1200); 

EXEC PRC_입고_INSERT('C002',30,1200); 

EXEC PRC_입고_INSERT('H001',50,800);

EXEC PRC_입고_INSERT('H002',50,200);

EXEC PRC_입고_INSERT('H005',100,200);

EXEC PRC_입고_INSERT('E001',200,200);


SELECT *
FROM TBL_입고;
/*
1	H001	2022-09-05	50	800
2	H002	2022-09-05	50	200
3	H005	2022-09-05	100	200
4	E001	2022-09-05	200	200
5	C001	2022-09-05	30	1200
6	C002	2022-09-05	30	1200
*/


SELECT *
FROM TBL_상품;

/*
C001	구구콘	    1500	30
C002	월드콘	    1500	30
C003	브라보콘	    1300	0
C004	누가콘	    1800	0
C005	슈퍼콘	    1900	0
H001	스크류바	    1000	50
H002	캔디바	    300	50
H003	쌍쌍바	    500	0
H004	돼지바	    600	0
H005	메로나	    500	100
E001	찰떡아이스	2500	200
E002	붕어싸만코	2000	0
E003	빵또아	    2300	0
E004	거북알	    2300	0
E005	쿠키오	    2400	0
E006	국화빵	    2000	0
E007	투게더	    3000	0
E008	엑설런트	    3000	0
E009	셀렉션	    3000	0
*/

EXEC PRC_출고_INSERT('E001',35,200);
EXEC PRC_출고_INSERT('H005',20,200);
EXEC PRC_출고_INSERT('H001',40,200);
EXEC PRC_출고_INSERT('H005',80,200);
EXEC PRC_출고_INSERT('H002',25,1200);

SELECT *
FROM TBL_출고;

/*
1	E001	2022-09-05	35	200
2	H005	2022-09-05	20	200
3	H001	2022-09-05	40	200
4	H005	2022-09-05	80	200
5	H002	2022-09-05	25	1200
*/


EXEC PRC_입고_UPDATE(3,150);
--PL/SQL 프로시저가 성공적으로 완료되었습니다.

SELECT *
FROM TBL_입고;

/*
1	H001	2022-09-05	50	800
2	H002	2022-09-05	50	200
3	H005	2022-09-05	150	200
4	E001	2022-09-05	200	200
5	C001	2022-09-05	30	1200
6	C002	2022-09-05	30	1200
*/


SELECT *
FROM TBL_상품;

--H005	메로나	500	50
-- 100 - 100 -100 + 150 = 50 (O)

EXEC PRC_입고_UPDATE(1,30);

/*
EGIN PRC_입고_UPDATE(1,30); END;
오류 보고 -
ORA-20002: 변경될 재고가 -입니다
ORA-06512: at "SCOTT.PRC_입고_UPDATE", line 51
ORA-06512: at line 1
*/

EXEC PRC_입고_UPDATE(1,30); --커서 사용

/*
출고번호      출고일자      출고수량
   3          2022-09-05    40
에 의해 업데이트 불가
*/


EXEC PRC_입고_DELETE(6);
--PL/SQL 프로시저가 성공적으로 완료되었습니다.

SELECT *
FROM TBL_입고;

/*
1	H001	2022-09-05	50	800
2	H002	2022-09-05	50	200
3	H005	2022-09-05	150	200
4	E001	2022-09-05	200	200
5	C001	2022-09-05	30	1200
*/

EXEC PRC_입고_DELETE(7);
-- 예외처리에서 WHEN OTHERS에 의해 ROLLBACK실행
-- PL/SQL 프로시저가 성공적으로 완료되었습니다.

EXEC PRC_입고_DELETE(3);
/*
EGIN PRC_입고_DELETE(3); END;
오류 보고 -
ORA-20002: 데이터 삭제시 재고가 없습니다.
ORA-06512: at "SCOTT.PRC_입고_DELETE", line 48
ORA-06512: at line 1
*/




----------------------------------------- 커서
EXEC PRC_입고_DELETE(7);

--해당 입고번호는 존재하지 않습니다.

EXEC PRC_입고_DELETE(3);
/*
출고번호      출고일자      출고수량
   2          2022-09-05    20
   4          2022-09-05    80
에 의해 삭제 불가
*/


SELECT *
FROM TBL_출고;
/*
1	E001	2022-09-05	35	200
2	H005	2022-09-05	20	200
3	H001	2022-09-05	40	200
4	H005	2022-09-05	80	200
5	H002	2022-09-05	25	1200
*/


EXEC PRC_출고_DELETE(3);

/*
1	E001	2022-09-05	35	200
2	H005	2022-09-05	20	200
4	H005	2022-09-05	80	200
5	H002	2022-09-05	25	1200
*/



--결과

SELECT *
FROM TBL_상품;
/*
C001	구구콘	    1500    	30
C002	월드콘	    1500	    0
C003	브라보콘	    1300	    0
C004	누가콘	    1800	    0
C005	슈퍼콘	    1900	    0
H001	스크류바	    1000	    50
H002	캔디바	    300	    25
H003	쌍쌍바	    500	    0
H004	돼지바	    600	    0
H005	메로나	    500	    50
E001	찰떡아이스	2500	    165
E002	붕어싸만코	2000	    0
E003	빵또아	    2300	    0
E004	거북알	    2300	    0
E005	쿠키오	    2400	    0
E006	국화빵	    2000	    0
E007	투게더	    3000	    0
E008	엑설런트	    3000	    0
E009	셀렉션	    3000	    0
*/

SELECT *
FROM TBL_입고;
/*
1	H001	2022-09-05	50	800
2	H002	2022-09-05	50	200
3	H005	2022-09-05	150	200
4	E001	2022-09-05	200	200
5	C001	2022-09-05	30	1200
*/

SELECT *
FROM TBL_출고;

/*
1	E001	2022-09-05	35	200
2	H005	2022-09-05	20	200
4	H005	2022-09-05	80	200
5	H002	2022-09-05	25	1200
*/
-----------------------------------------------------------------
--프로시저 관련 실습 진행

--실습 테이블 생성
CREATE TABLE TBL_STUDENTS
( ID  VARCHAR2(10)
, NAME VARCHAR2(40)
, TEL VARCHAR2(30)
, ADDR VARCHAR2(100)
);


--실습 테이블 생성

CREATE TABLE TBL_IDPW
( ID VARCHAR2(10)
, PW VARCHAR2(20)
, CONSTRAINT IDPW_ID_PK PRIMARY KEY(ID)
); 
--1:1 데이터 테이블이라고 가

--두 테이블에 데이터 입력
INSERT INTO TBL_STUDENTS(ID, NAME, TEL, ADDR)
VALUES('superman', '최동현', '010-1111-1111', '제주도 서귀포시');
INSERT INTO TBL_IDPW(ID, PW)
VALUES('superman', 'java002$');

--확인
SELECT *
FROM TBL_STUDENTS;
--==>>superman 최동현 010-1111-1111 제주도 서귀포시

SELECT *
FROM TBL_IDPW;
--superman	java002$

--커밋
COMMIT;
--==>>커밋 완료.

--위의 업무를 수행하는 프로시저(INSERT 프로시저, 입력 프로시저)를 생성하게 되면
-- EXEC PRC_STUDENT_INSERT('batman', 'java002$','김태민','010-2222-2222','서울 마포구');
--이와 같은 구문 한 줄로 양쪽 테이블에 모두 제대로 입력할 수 있다.

--※프로시저 생성 구문은
--  20220901_01_scott(plsql).sql 파일 참조~!!!


--○프로시저 호출을 통한 확인
EXEC PRC_STUDENTS_INSERT('batman', 'java002$','김태민','010-2222-2222','서울 마포구');
--PL/SQL 프로시저가 성공적으로 완료되었습니다.


--프로시저 호출 이후 다시 확인
SELECT *
FROM TBL_STUDENTS;
/*
superman	최동현	010-1111-1111	제주도 서귀포시
batman	김태민	010-2222-2222	서울 마포구
*/

SELECT *
FROM TBL_IDPW;
/*
superman	java002$
batman	java002$
*/


--○실습 테이블 생성(TBL_SUNGJUK)
CREATE TABLE TBL_SUNGJUK
( HAKBUN NUMBER
, NAME  VARCHAR2(40)
, KOR   NUMBER(3)
, ENG   NUMBER(3)
, MATN  NUMBER(3)
, CONSTRAINT SUNGJUK_HAKBUN_PK PRIMARY KEY(HAKBUN)
);

--○생성된 테이블에 컬럼 추가
-- (총점, 평균, 등급)
-- (총점 -> TOT, 평균 -> AVG, 등급 -> GRADE)

--위의 과정이 옳지 않은이유
--※※※※정규화 마지막 단계
--만약 컬럼 데이터로 구할수있는 것이라면 테이블 데이터에 따론 컬럼을 추가하지 않는다.
--컬럼내 국영수로 구할수 있는 3가지라서 바람직하지 않은 과정이다.

ALTER TABLE TBL_SUNGJUK
ADD (TOT NUMBER(3), AVG NUMBER(4,1), GRADE CHAR);
--Table TBL_SUNGJUK이(가) 변경되었습니다.

--※여기서 추가한 컬럼에 대한 항목은
-- 프로시저 실습을 위해 추가한 것일 뿐
-- 실제 테이블 구조에 적합하지도, 바람직하지도 않은 내용이다.

--○변경된 테이블 구조 확인
DESC TBL_SUNGJUK;
--===>
/*
이름     널?       유형           
------ -------- ------------ 
HAKBUN NOT NULL NUMBER       
NAME            VARCHAR2(40) 
KOR             NUMBER(3)    
ENG             NUMBER(3)    
MATN            NUMBER(3)    
TOT             NUMBER(3)    
AVG             NUMBER(4,1)  
GRADE           CHAR(1)  
*/

EXEC PRC_SUNGJUK_INSERT(1, '엄소연', 90,80,70);

SELECT *
FROM TBL_SUNGJUK;

EXEC PRC_SUNGJUK_UPDATE(1,70,60,80);

EXEC PRC_SUNGJUK_INSERT(2, '정미경', 80,70,60);
EXEC PRC_SUNGJUK_INSERT(3, '임시연', 82,71,60);
EXEC PRC_SUNGJUK_INSERT(4, '유동현', 54,63,72);
EXEC PRC_SUNGJUK_INSERT(5, '장현성', 44,33,22);
/*
엄소연	70	60	80	210	70	C
정미경	80	70	60	210	70	C
임시연	82	71	60	213	71	C
유동현	54	63	72	189	63	D
장현성	44	33	22	99	33	F
*/

EXEC PRC_SUNGJUK_UPDATE(5,100,99,98);
--5	장현성	100	99	98	297	99	A

EXEC PRC_STUDENTS_UPDATE('batman' , 'java002$', '010-9999-5571', '서울 종로구');

SELECT *
FROM TBL_STUDENTS;

SELECT EMPNO, ENAME, JOB, DEPTNO
FROM EMP
WHERE DEPTNO = 20
      AND 1 =2; --1=2 는 거짓이므로 조회결과 자체가 안나온다.

SELECT T1.ID, T1.PW, T2.TEL, T2.ADDR      
FROM TBL_IDPW T1 JOIN TBL_STUDENTS T2
ON T1.ID = T2.ID;




--○TBL_INSA 테이블을 대상으로 신규 데이터 입력 프로시저를 작성한다.
-- NAME, SSN, IBSADATE, CITY, TEL, BUSEO, JIKWI, BASICPAY, SUDANG)

EXEC PRC_INSA_INSERT('조현하', '970124-2234567', SYSDATE, '서울', '010-7202-6306', '개발부', '대리', 2000000, 2000000);

SELECT *
FROM TBL_INSA;


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
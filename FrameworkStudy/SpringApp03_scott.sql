SELECT USER
FROM DUAL;


SELECT * 
FROM TBL_MEMBER;

--○테이블 생성
CREATE TABLE TBL_MEMBERLIST
(ID VARCHAR2(30) NOT NULL
, PW VARCHAR2(50) NOT NULL
, NAME VARCHAR2(50) NOT NULL
, TEL VARCHAR2(50) NOT NULL
, EMAIL VARCHAR2(100)
, CONSTRAINT MEMBERLIST_ID_PK PRIMARY KEY(ID)
);
--==>Table TBL_MEMBERLIST이(가) 생성

--○ 데이터 입력(암호화 패키지 사용)
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL)
VALUES('admin', CRYPTPACK.ENCRYPT('java002$', 'admin'), '관리자', '010-1234-1234', 'admin@test.com');
--> 한 줄 구성
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL) VALUES('admin', CRYPTPACK.ENCRYPT('java002$', 'admin'), '관리자', '010-1234-1234', 'admin@test.com')
;
--==>> 1 행 이(가) 삽입되었습니다.

--○확인
SELECT *
FROM TBL_MEMBERLIST
--admin	??a?	관리자	010-1234-1234	admin@test.com

--○커밋
COMMIT;

--○리스트 전체 조회 쿼리문 구성
SELECT ID, NAME, TEL, EMAIL
FROM TBL_MEMBERLIST;
-->한 줄 구성
SELECT ID, NAME, TEL, EMAIL FROM TBL_MEMBERLIST
;
--==> admin	관리자	010-1234-1234	admin@test.com

--○ 데이터 입력(암호화 패키지 사용) 자신의 데이터
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL)
VALUES('YDH', CRYPTPACK.ENCRYPT('java002$', 'rucy'), '유동현', '010-3578-3912', 'wingit061@gmail.com');
--1 행 이(가) 삽입되었습니다.

SELECT ID, NAME, TEL, EMAIL FROM TBL_MEMBERLIST
;
/*
admin	관리자	010-1234-1234	admin@test.com
YDH	유동현	010-3578-3912	wingit061@gmail.com
*/

--○커밋
COMMIT;

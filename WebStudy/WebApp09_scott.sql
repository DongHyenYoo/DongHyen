
SELECT *
FROM TAB;

PURGE RECYCLEBIN;

DROP TABLE TBL_MEMBER;


CREATE TABLE TBL_MEMBER
( SID NUMBER
, NAME VARCHAR2(30)
, TEL  VARCHAR2(40)
, CONSTRAINT MEMBER_SID_PK PRIMARY KEY(SID)
);


DESC TBL_MEMBER;
/*
SID  NOT NULL NUMBER       
NAME          VARCHAR2(30) 
TEL           VARCHAR2(40) 
*/

--○ 시퀀스 생성(MEMBERSEQ
CREATE SEQUENCE MEMBERSEQ
NOCACHE;

--○데이터 입력 및 입력 쿼리문 구성
INSERT INTO TBL_MEMBER(SID, NAME, TEL)
VALUES(MEMBERSEQ.nextval, '고연수', '010-1111-1111');

--한줄 구성
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.nextval, '고연수', '010-1111-1111')
;

--○테이블 데이터 전체 조회 쿼리문 구성
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;

--한줄
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID
;

--○인원수 확인 쿼리문
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBER;

--한줄
SELECT COUNT(*) AS COUNT FROM TBL_MEMBER
;


--커밋
COMMIT;

--추가 입력
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '엄소연', '010-2222-2222')
;

--○테이블 데이터 전체 조회 쿼리문 구성
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;


COMMIT;

DELETE 
FROM TBL_MEMBER
WHERE SID = 8;


COMMIT;
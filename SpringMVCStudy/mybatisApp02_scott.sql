--기존 테이블 제거
DROP TABLE TBL_MEMBERLIST;


--실습 테이블 구성(TBL_MEMBERLIST)
CREATE TABLE TBL_MEMBERLIST
( MID   NUMBER
, NAME  VARCHAR2(30)
, TELEPHONE VARCHAR2(40)
, CONSTRAINT MEMBERLIST_MID_PK PRIMARY KEY(MID)
);
--==>> Table TBL_MEMBERLIST이(가) 생성되었습니다.



--기존 시퀀스 제거
DROP SEQUENCE MEMBERLISTSEQ;
--==>>Sequence MEMBERLISTSEQ가 삭제되었습니다.

--○실습 시퀀스 구성(MEMBERLISTSEQ)
CREATE SEQUENCE MEMBERLISTSEQ
NOCACHE;
--Sequence MEMBERLISTSEQ이(가) 생성되었습니다.


--○데이터 입력
INSERT INTO TBL_MEMBERLIST(MID, NAME, TELEPHONE)
VALUES(MEMBERLISTSEQ.NEXTVAL, '민찬우', '010-1111-1111');


--○확인(리스트 조회)
SELECT MID, NAME, TELEPHONE
FROM TBL_MEMBERLIST
ORDER BY MID;

--○ 인원 수 확인
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBERLIST;
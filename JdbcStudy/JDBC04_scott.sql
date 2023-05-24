SELECT USER
FROM DUAL;

--○기존 테이블 제거
DROP TABLE TBL_SCORE;

--Table TBL_SCORE이(가) 삭제되었습니다.


--○실습 테이블 생성(TBL_SCORE)

CREATE TABLE TBL_SCORE
( SID NUMBER
, NAME VARCHAR2(30)
, KOR NUMBER(3)
, ENG NUMBER(3)
, MAT NUMBER(3)
);

--Table TBL_SCORE이(가) 생성되었습니다.

--○ 제약조건 추가(SID 컬럼에 PK 제약조건 추가)
ALTER TABLE TBL_SCORE
ADD CONSTRAINT SCORE_SID_PK PRIMARY KEY(SID);

--Table TBL_SCORE이(가) 변경되었습니다.

--○ 제약조건 추가(KOR, ENG, MAT 컬럼에 CK 제약조건 추가)
ALTER TABLE TBL_SCORE
ADD ( CONSTRAINT SCORE_KOR_CK CHECK(KOR BETWEEN 0 AND 100)
    , CONSTRAINT SCORE_ENG_CK CHECK(ENG BETWEEN 0 AND 100)
    , CONSTRAINT SCORE_MAT_CK CHECK(MAT BETWEEN 0 AND 100));
--Table TBL_SCORE이(가) 변경되었습니다.   

--○시퀀스 생성
CREATE SEQUENCE SCORESEQ
NOCACHE;
--Sequence SCORESEQ이(가) 생성되었습니다.

--○데이터베이스 액션 처리에 필요한 쿼리문 준비
INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT)
VALUES(SCORESEQ.NEXTVAL, '홍길동', 90, 80, 70);

SELECT *
FROM SCORESEQ;

--한줄로
INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT) VALUES(SCORESEQ.NEXTVAL, '홍길동', 90, 80, 70)
;

COMMIT;

--2.리스트 출력 쿼리문 구성(총점, 평균, 석차 포함)
SELECT SID, NAME, KOR, ENG, MAT
       , (KOR + ENG + MAT) AS TOT
       , (KOR + ENG + MAT) / 3 AS AVG
       , RANK() OVER(ORDER BY (KOR + ENG + MAT) DESC) AS RANK
FROM TBL_SCORE;
ORDER BY SID ASC;


--한줄로
SELECT SID, NAME, KOR, ENG, MAT, (KOR + ENG + MAT) AS TOT, (KOR + ENG + MAT) / 3 AS AVG, RANK() OVER(ORDER BY (KOR + ENG + MAT) DESC) AS RANK FROM TBL_SCORE ORDER BY SID ASC
;


--3. 인원 수 조회 쿼리문 구성
SELECT COUNT(*) AS COUNT
FROM TBL_SCORE;

--한줄 구성
SELECT COUNT(*) AS COUNT FROM TBL_SCORE
;



--4.이름 검색 쿼리문 구성(총점, 평균, 석차 포함)

SELECT SID, NAME, KOR, ENG, MAT, TOT, AVG, RANK
FROM
(
SELECT SID, NAME, KOR, ENG, MAT
       , (KOR + ENG + MAT) AS TOT
       , (KOR + ENG + MAT) / 3 AS AVG
       , RANK() OVER(ORDER BY (KOR + ENG + MAT) DESC) AS RANK
FROM TBL_SCORE
)
WHERE NAME LIKE '%길동%';



SELECT SID, NAME, KOR, ENG, MAT, TOT, AVG, RANK FROM (SELECT SID, NAME, KOR, ENG, MAT, (KOR + ENG + MAT) AS TOT, (KOR + ENG + MAT) / 3 AS AVG, RANK() OVER(ORDER BY (KOR + ENG + MAT) DESC) AS RANK FROM TBL_SCORE) WHERE NAME LIKE '%길동%'
;




--5.번호 검색 쿼리문 구성(총점, 평균, 석차 포함)
SELECT SID, NAME, KOR, ENG, MAT, TOT, AVG, RANK
FROM
(
SELECT SID, NAME, KOR, ENG, MAT
       , (KOR + ENG + MAT) AS TOT
       , (KOR + ENG + MAT) / 3 AS AVG
       , RANK() OVER(ORDER BY (KOR + ENG + MAT) DESC) AS RANK
FROM TBL_SCORE
)
WHERE SID = 1;

--한 줄 구성
SELECT SID, NAME, KOR, ENG, MAT, TOT, AVG, RANK FROM (SELECT SID, NAME, KOR, ENG, MAT, (KOR + ENG + MAT) AS TOT, (KOR + ENG + MAT) / 3 AS AVG, RANK() OVER(ORDER BY (KOR + ENG + MAT) DESC) AS RANK FROM TBL_SCORE) WHERE SID = 1
;


--6. 데이터 수정 쿼리문 구성
UPDATE TBL_SCORE
SET NAME = '고길동', KOR = 100, ENG = 100, MAT = 100
WHERE SID = 1;

--6.1한줄 구성

UPDATE TBL_SCORE SET NAME = '고길동', KOR = 100, ENG = 100, MAT = 100 WHERE SID = 1
;

--7.데이터 삭제 쿼리문 구성
DELETE
FROM TBL_SCORE
WHERE SID = 1;

DELETE FROM TBL_SCORE WHERE SID = 1
;



--자바에서쓸 insert 구문

INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT) VALUES(%s, '%s', %s, %s, %s)
;

--전체 인원수 구문

SELECT COUNT(*) AS COUNT FROM TBL_SCORE
;

--전체 출력 주문

SELECT SID, NAME, KOR, ENG, MAT FROM TBL_SCORE
;

TRUNCATE TABLE TBL_SCORE;

ROLLBACK;
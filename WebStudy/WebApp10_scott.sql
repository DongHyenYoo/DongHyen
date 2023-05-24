DROP TABLE TBL_SCORE;

DROP SEQUENCE SCORESEQ;

CREATE TABLE TBL_SCORE
( SID NUMBER
, NAME VARCHAR2(30)
, KOR NUMBER
, ENG NUMBER
, MAT NUMBER
, CONSTRAINT SCORE_SID_PK PRIMARY KEY(SID)
);

CREATE SEQUENCE SCORESEQ
NOCACHE;


INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT) VALUES(SCORESEQ.NEXTVAL, '������', 70,70,70)
;

SELECT SID,NAME,KOR,ENG,MAT , (KOR+ENG+MAT) AS TOT, ROUND((KOR+ENG+MAT)/3,1) AS AVG FROM TBL_SCORE
;


commit;
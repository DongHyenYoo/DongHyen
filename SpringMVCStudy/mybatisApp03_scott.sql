SELECT USER
FROM DUAL;

CREATE TABLE TBL_STUDENT
( SID NUMBER
, NAME VARCHAR2(30)
, TEL VARCHAR2(40)
, CONSTRAINT STU_SID_PK PRIMARY KEY(SID)
);



DROP TABLE TBL_GRADE;

CREATE TABLE TBL_GRADE
( SID NUMBER
, SUB1 NUMBER(3)
, SUB2 NUMBER(3)
, SUB3 NUMBER(3)
, CONSTRAINT GRADE_SID_PK PRIMARY KEY(SID)
, CONSTRAINT GRADE_SID_FK FOREIGN KEY(SID)
                        REFERENCES TBL_STUDENT(SID)
, CONSTRAINT GRADE_SUB1_CK CHECK(SUB1 BETWEEN 0 AND 100)
, CONSTRAINT GRADE_SUB2_CK CHECK(SUB2 BETWEEN 0 AND 100)
, CONSTRAINT GRADE_SUB3_CK CHECK(SUB3 BETWEEN 0 AND 100)

);


SELECT *
FROM user_constraints
WHERE TABLE_NAME = 'TBL_GRADE';


--샘플 데이터 입력
INSERT INTO TBL_STUDENT(SID,NAME,TEL)
VALUES(1, '최나윤', '010-1111-1111');

INSERT INTO TBL_STUDENT(SID,NAME,TEL)
VALUES(2, '박원석', '010-2222-2222');

INSERT INTO TBL_STUDENT(SID,NAME,TEL)
VALUES(3, '한은영', '010-3333-3333');

INSERT INTO TBL_STUDENT(SID,NAME,TEL)
VALUES(4, '조현하', '010-4444-4444');


--샘플 데이터 입력
INSERT INTO TBL_GRADE(SID, SUB1, SUB2, SUB3)
VALUES(1, 90, 80, 70);
INSERT INTO TBL_GRADE(SID, SUB1, SUB2, SUB3)
VALUES(2, 77, 55, 66);
INSERT INTO TBL_GRADE(SID, SUB1, SUB2, SUB3)
VALUES(3, 80, 80, 80);
INSERT INTO TBL_GRADE(SID, SUB1, SUB2, SUB3)
VALUES(4, 50, 60, 30);

--1 행 이(가) 삽입되었습니다.*4

SELECT *
FROM TBL_STUDENT;
SELECT *
FROM TBL_GRADE;

--○ 커밋
COMMIT;


--뷰 생성(STUDENTVIEW)
--뷰 구조 : SID, NAME, TEL, SUB
			                    --- 참조 레코드 수
 

CREATE OR REPLACE VIEW STUDENTVIEW
AS
SELECT SID, NAME, TEL
      , (SELECT COUNT(*) FROM TBL_GRADE WHERE SID = T.SID) AS SUB 
FROM TBL_STUDENT T;


SELECT *
FROM STUDENTVIEW;

/*
뷰 : GRADEVIEW   
뷰 구조 : SUD, NAME, SUB1, SUB2, SUB3, TOT, AVG, CH
                                      ---  ---  --
                                      총점 평균 등급(합격, 과락, 불합격)

*/

CREATE OR REPLACE VIEW GRADEVIEW
AS
SELECT SID,NAME,SUB1, SUB2, SUB3, TOT, ROUND(AVG,1) AS AVG
      , (CASE WHEN SUB1< 40 OR SUB2<40 OR SUB3<40 THEN '불합격'
         WHEN AVG>=60 THEN '합격'  
         ELSE '확인불가' END) AS CH
FROM
(
SELECT G.SID, NAME, SUB1, SUB2, SUB3
      , (SELECT (SUB1+SUB2+SUB3) FROM TBL_GRADE WHERE SID = G.SID) AS TOT
      , (SELECT (SUB1+SUB2+SUB3)/3 FROM TBL_GRADE WHERE SID = G.SID) AS AVG
FROM TBL_GRADE G JOIN TBL_STUDENT T
ON G.SID = T.SID)T
;

/*
--쌤
CREATE OR REPLACE VIEW GRADEVIEW
AS
SELECT S.SID AS SID
     , S.NAME AS NAME
     , G.SUB1 AS SUB1
     , G.SUB2 AS SUB2
     , G.SUB3 AS SUB3
     , (G.SUB1 + G.SUB2 + G.SUB3) AS TOT
     , (G.SUB1 + G.SUB2 + G.SUB3)/3 AS AVG
     , (CASE WHEN (G.SUB1 + G.SUB2 + G.SUB3)/3 < 60 THEN '불합격'
             WHEN (G.SUB1 <= 40) OR (G.SUB2 <= 40) OR (G.SUB3 <= 40) THEN '과락'
             ELSE '합격'
             END) AS CH
FROM TBL_STUDENT S JOIN TBL_GRADE G
ON S.SID = G.SID;
--==>> View GRADEVIEW이(가) 생성되었습니다.

*/



COMMIT;


SELECT *
FROM GRADEVIEW;


SELECT SID,NAME,TEL
FROM TBL_STUDENT
WHERE SID = 1;


SELECT SID,NAME,SUB1,SUB2,SUB3,TOT,AVG,CH
FROM GRADEVIEW
ORDER BY SID;


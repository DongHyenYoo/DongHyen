SELECT USER
FROM DUAL;


DROP TABLE TBL_MEMBER;

PURGE RECYCLEBIN;


CREATE TABLE TBL_MEMBER
( SID NUMBER
, NAME VARCHAR2(30)
, TEL VARCHAR2(40)
, CONSTRAINT MEMBER_SID_PK PRIMARY KEY(SID)
);


--������ ����
DROP SEQUENCE MEMBERSEQ;


CREATE SEQUENCE MEMBERSEQ
NOCACHE;



--���� ������ �Է�
INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES(MEMBERSEQ.NEXTVAL, '������', '010-1111-1111');
INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES(MEMBERSEQ.NEXTVAL, '�ӽÿ�', '010-2222-2222');
INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES(MEMBERSEQ.NEXTVAL, '�ֳ���', '010-3333-3333');
INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES(MEMBERSEQ.NEXTVAL, '�ݺ���', '010-4444-4444');
INSERT INTO TBL_MEMBER(SID,NAME,TEL) VALUES(MEMBERSEQ.NEXTVAL, '������', '010-5555-5555');

--Ȯ��

SELECT SID,NAME,TEL
FROM TBL_MEMBER
ORDER BY SID;

--���ٷ�
SELECT SID,NAME,TEL FROM TBL_MEMBER ORDER BY SID
;


COMMIT;


--�ο��� Ȯ��
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBER;

--����

SELECT COUNT(*) AS COUNT FROM TBL_MEMBER
;

--SID�� ȸ�������� �˻�

SELECT SID, NAME, TEL
FROM TBL_MEMBER
WHERE SID = 1;

--����

SELECT SID, NAME, TEL FROM TBL_MEMBER WHERE SID = 1
;

--ȸ�� ������ ����

UPDATE TBL_MEMBER
SET NAME='������', TEL='010-1110-0111'
WHERE SID=1;

--����

UPDATE TBL_MEMBER SET NAME='������', TEL='010-1110-0111' WHERE SID=1
;

ROLLBACK;

--��ȸ�� ������ ���� ������ ����
SELECT SID, NAME, TEL
FROM TBL_MEMBER
WHERE SID = 1;

--����

DELETE FROM TBL_MEMBER WHERE SID = 1
;

ROLLBACK;



--�������̺� ����

DROP TABLE TBL_SCORE;


PURGE RECYCLEBIN;


CREATE TABLE TBL_MEMBERSCORE
( SID NUMBER
, KOR NUMBER(3)
, ENG NUMBER(3)
, MAT NUMBER(3)
, CONSTRAINT MEMBERSCORE_SID_PK PRIMARY KEY(SID)
, CONSTRAINT MEMBERSCORE_KOR_CK CHECK(KOR BETWEEN 0 AND 100)
, CONSTRAINT MEMBERSCORE_ENG_CK CHECK(ENG BETWEEN 0 AND 100)
, CONSTRAINT MEMBERSCORE_MAT_CK CHECK(MAT BETWEEN 0 AND 100)
, CONSTRAINT MEMBERSCORE_SID_FK FOREIGN KEY(SID)
                                REFERENCES TBL_MEMBER(SID)
);

--Table TBL_MEMBERSCORE��(��) �����Ǿ����ϴ�.

--���õ����� �Է�
INSERT INTO TBL_MEMBERSCORE(SID,KOR,ENG,MAT) VALUES(1, 90, 80, 70)
;


--�� Ȯ��
SELECT SID, KOR, ENG, MAT FROM TBL_MEMBERSCORE
;

COMMIT;

--�ۼ��� �Է� �ο� �� Ȯ��

SELECT COUNT(*) AS COUNT FROM TBL_MEMBERSCORE
;


--���� ������ �˻�
SELECT SID, KOR, ENG, MAT
FROM TBL_MEMBERSCORE
WHERE SID=1;


--���ٷ�
SELECT SID, KOR, ENG, MAT FROM TBL_MEMBERSCORE WHERE SID=1
;


--���� ������ ����

UPDATE TBL_MEMBERSCORE
SET KOR=99, ENG=99, MAT=90
WHERE SID=1;

--����

UPDATE TBL_MEMBERSCORE SET KOR=99, ENG=99, MAT=90 WHERE SID=1
;

--���� ������ ����
SELECT *
FROM TBL_MEMBERSCORE
WHERE SID = 1;

DELETE FROM TBL_MEMBERSCORE WHERE SID = 1
;

--���ٷ�

DELETE FROM TBL_MEMBERSCORE WHERE SID = 1
;



ROLLBACK;

--����ü ������ ��ȸ ������ ����()
SELECT M.SID, M.NAME
      , NVL(MS.KOR,-1)
      , NVL(MS.ENG,-1)
      , NVL(MS.MAT,-1)
FROM TBL_MEMBER M JOIN TBL_MEMBERSCORE MS
ON M.SID = MS.SID(+);


--��ü ������ ��ȸ���� ��(VIEW_MEMBERSCORE)����

CREATE OR REPLACE VIEW VIEW_MEMBERSCORE
AS
SELECT M.SID , M.NAME
      , NVL(MS.KOR,-1) AS KOR
      , NVL(MS.ENG,-1) AS ENG
      , NVL(MS.MAT,-1) AS MAT
FROM TBL_MEMBER M JOIN TBL_MEMBERSCORE MS
ON M.SID = MS.SID(+);


--������ ��(VIEW_MEMBERSCORE) �� Ȱ���� �� ����Ʈ ��ȸ ������ ����
-- ��ȣ �̸� ����,����,�������� ���� ��� ����


SELECT SID, NAME, KOR, ENG, MAT, (KOR+ENG+MAT) AS TOT,(KOR+ENG+MAT)/3 AS AVG
      , RANK() OVER(ORDER BY (KOR+ENG+MAT)  DESC) AS RANK
FROM VIEW_MEMBERSCORE;

/*
1	������	90	80	70	240	80	1
5	������	-1	-1	-1	-3	-1	2
4	�ݺ���	-1	-1	-1	-3	-1	2
2	�ӽÿ�	-1	-1	-1	-3	-1	2
3	�ֳ���	-1	-1	-1	-3	-1	2
*/

--�ۻ����� �� �� Ȱ���� ��ȣ �˻�
SELECT SID, NAME, KOR, ENG, MAT
FROM VIEW_MEMBERSCORE
WHERE SID=1;


--���ٱ���
SELECT SID, NAME, KOR, ENG, MAT FROM VIEW_MEMBERSCORE WHERE SID=1
;


--���� ������ ���ڵ� �� Ȯ��
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBERSCORE
WHERE SID=2;
--���� ó���� �Ǿ����� �ƴϳĸ� �˼��ִ�.
--�ٸ� 1:1����� ������ �ƴ�

--����

SELECT COUNT(*) AS COUNT FROM TBL_MEMBERSCORE WHERE SID=1
;
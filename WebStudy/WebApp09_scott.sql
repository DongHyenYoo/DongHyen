
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

--�� ������ ����(MEMBERSEQ
CREATE SEQUENCE MEMBERSEQ
NOCACHE;

--�۵����� �Է� �� �Է� ������ ����
INSERT INTO TBL_MEMBER(SID, NAME, TEL)
VALUES(MEMBERSEQ.nextval, '������', '010-1111-1111');

--���� ����
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.nextval, '������', '010-1111-1111')
;

--�����̺� ������ ��ü ��ȸ ������ ����
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;

--����
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID
;

--���ο��� Ȯ�� ������
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBER;

--����
SELECT COUNT(*) AS COUNT FROM TBL_MEMBER
;


--Ŀ��
COMMIT;

--�߰� �Է�
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '���ҿ�', '010-2222-2222')
;

--�����̺� ������ ��ü ��ȸ ������ ����
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;


COMMIT;

DELETE 
FROM TBL_MEMBER
WHERE SID = 8;


COMMIT;
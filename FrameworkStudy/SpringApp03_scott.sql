SELECT USER
FROM DUAL;


SELECT * 
FROM TBL_MEMBER;

--�����̺� ����
CREATE TABLE TBL_MEMBERLIST
(ID VARCHAR2(30) NOT NULL
, PW VARCHAR2(50) NOT NULL
, NAME VARCHAR2(50) NOT NULL
, TEL VARCHAR2(50) NOT NULL
, EMAIL VARCHAR2(100)
, CONSTRAINT MEMBERLIST_ID_PK PRIMARY KEY(ID)
);
--==>Table TBL_MEMBERLIST��(��) ����

--�� ������ �Է�(��ȣȭ ��Ű�� ���)
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL)
VALUES('admin', CRYPTPACK.ENCRYPT('java002$', 'admin'), '������', '010-1234-1234', 'admin@test.com');
--> �� �� ����
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL) VALUES('admin', CRYPTPACK.ENCRYPT('java002$', 'admin'), '������', '010-1234-1234', 'admin@test.com')
;
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

--��Ȯ��
SELECT *
FROM TBL_MEMBERLIST
--admin	??a?	������	010-1234-1234	admin@test.com

--��Ŀ��
COMMIT;

--�۸���Ʈ ��ü ��ȸ ������ ����
SELECT ID, NAME, TEL, EMAIL
FROM TBL_MEMBERLIST;
-->�� �� ����
SELECT ID, NAME, TEL, EMAIL FROM TBL_MEMBERLIST
;
--==> admin	������	010-1234-1234	admin@test.com

--�� ������ �Է�(��ȣȭ ��Ű�� ���) �ڽ��� ������
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL)
VALUES('YDH', CRYPTPACK.ENCRYPT('java002$', 'rucy'), '������', '010-3578-3912', 'wingit061@gmail.com');
--1 �� ��(��) ���ԵǾ����ϴ�.

SELECT ID, NAME, TEL, EMAIL FROM TBL_MEMBERLIST
;
/*
admin	������	010-1234-1234	admin@test.com
YDH	������	010-3578-3912	wingit061@gmail.com
*/

--��Ŀ��
COMMIT;
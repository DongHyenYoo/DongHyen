-----------------------------------------------------------------
--���ν��� ���� �ǽ� ����

--�ǽ� ���̺� ����
CREATE TABLE TBL_STUDENTS
( ID  VARCHAR2(10)
, NAME VARCHAR2(40)
, TEL VARCHAR2(30)
, ADDR VARCHAR2(100)
);


--�ǽ� ���̺� ����

CREATE TABLE TBL_IDPW
( ID VARCHAR2(10)
, PW VARCHAR2(20)
, CONSTRAINT IDPW_ID_PK PRIMARY KEY(ID)
); 
--1:1 ������ ���̺��̶�� ��

--�� ���̺� ������ �Է�
INSERT INTO TBL_STUDENTS(ID, NAME, TEL, ADDR)
VALUES('superman', '�ֵ���', '010-1111-1111', '���ֵ� ��������');
INSERT INTO TBL_IDPW(ID, PW)
VALUES('superman', 'java002$');

--Ȯ��
SELECT *
FROM TBL_STUDENTS;
--==>>superman �ֵ��� 010-1111-1111 ���ֵ� ��������

SELECT *
FROM TBL_IDPW;
--superman	java002$

--Ŀ��
COMMIT;
--==>>Ŀ�� �Ϸ�.

--���� ������ �����ϴ� ���ν���(INSERT ���ν���, �Է� ���ν���)�� �����ϰ� �Ǹ�
-- EXEC PRC_STUDENT_INSERT('batman', 'java002$','���¹�','010-2222-2222','���� ������');
--�̿� ���� ���� �� �ٷ� ���� ���̺� ��� ����� �Է��� �� �ִ�.

--�����ν��� ���� ������
--  20220901_01_scott(plsql).sql ���� ����~!!!


--�����ν��� ȣ���� ���� Ȯ��
EXEC PRC_STUDENTS_INSERT('batman', 'java002$','���¹�','010-2222-2222','���� ������');
--PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.


--���ν��� ȣ�� ���� �ٽ� Ȯ��
SELECT *
FROM TBL_STUDENTS;
/*
superman	�ֵ���	010-1111-1111	���ֵ� ��������
batman	���¹�	010-2222-2222	���� ������
*/

SELECT *
FROM TBL_IDPW;
/*
superman	java002$
batman	java002$
*/


--�۽ǽ� ���̺� ����(TBL_SUNGJUK)
CREATE TABLE TBL_SUNGJUK
( HAKBUN NUMBER
, NAME  VARCHAR2(40)
, KOR   NUMBER(3)
, ENG   NUMBER(3)
, MATN  NUMBER(3)
, CONSTRAINT SUNGJUK_HAKBUN_PK PRIMARY KEY(HAKBUN)
);

--�ۻ����� ���̺� �÷� �߰�
-- (����, ���, ���)
-- (���� -> TOT, ��� -> AVG, ��� -> GRADE)

--���� ������ ���� ��������
--�ءءء�����ȭ ������ �ܰ�
--���� �÷� �����ͷ� ���Ҽ��ִ� ���̶�� ���̺� �����Ϳ� ���� �÷��� �߰����� �ʴ´�.
--�÷��� �������� ���Ҽ� �ִ� 3������ �ٶ������� ���� �����̴�.

ALTER TABLE TBL_SUNGJUK
ADD (TOT NUMBER(3), AVG NUMBER(4,1), GRADE CHAR);
--Table TBL_SUNGJUK��(��) ����Ǿ����ϴ�.

--�ؿ��⼭ �߰��� �÷��� ���� �׸���
-- ���ν��� �ǽ��� ���� �߰��� ���� ��
-- ���� ���̺� ������ ����������, �ٶ��������� ���� �����̴�.

--�ۺ���� ���̺� ���� Ȯ��
DESC TBL_SUNGJUK;
--===>
/*
�̸�     ��?       ����           
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

EXEC PRC_SUNGJUK_INSERT(1, '���ҿ�', 90,80,70);

SELECT *
FROM TBL_SUNGJUK;

EXEC PRC_SUNGJUK_UPDATE(1,70,60,80);

EXEC PRC_SUNGJUK_INSERT(2, '���̰�', 80,70,60);
EXEC PRC_SUNGJUK_INSERT(3, '�ӽÿ�', 82,71,60);
EXEC PRC_SUNGJUK_INSERT(4, '������', 54,63,72);
EXEC PRC_SUNGJUK_INSERT(5, '������', 44,33,22);
/*
���ҿ�	70	60	80	210	70	C
���̰�	80	70	60	210	70	C
�ӽÿ�	82	71	60	213	71	C
������	54	63	72	189	63	D
������	44	33	22	99	33	F
*/

EXEC PRC_SUNGJUK_UPDATE(5,100,99,98);
--5	������	100	99	98	297	99	A

EXEC PRC_STUDENTS_UPDATE('batman' , 'java002$', '010-9999-5571', '���� ���α�');

SELECT *
FROM TBL_STUDENTS;

SELECT EMPNO, ENAME, JOB, DEPTNO
FROM EMP
WHERE DEPTNO = 20
      AND 1 =2; --1=2 �� �����̹Ƿ� ��ȸ��� ��ü�� �ȳ��´�.

SELECT T1.ID, T1.PW, T2.TEL, T2.ADDR      
FROM TBL_IDPW T1 JOIN TBL_STUDENTS T2
ON T1.ID = T2.ID;




--��TBL_INSA ���̺��� ������� �ű� ������ �Է� ���ν����� �ۼ��Ѵ�.
-- NAME, SSN, IBSADATE, CITY, TEL, BUSEO, JIKWI, BASICPAY, SUDANG)

EXEC PRC_INSA_INSERT('������', '970124-2234567', SYSDATE, '����', '010-7202-6306', '���ߺ�', '�븮', 2000000, 2000000);

SELECT *
FROM TBL_INSA;


--Transaction ó��

--ex) UPDATE ������ UPDATE������ �ϳ��� �����Ͱ� ����
--�����̶� �������� ������ �ȵǸ� ROLLBACK�� �ǰ� �����.
--EX) ����ŷ� ���°ŷ� ������ ���ʿ��� ���� ������ ������ & �ٸ��ʿ��� ���� ������ ������ �ΰ��� �ϳ���
-- ������� �ʴ´ٸ� ���� ROLLBACK �Ѵ�.
-- �̴� INSERT , DELETE�� ������.


--�۽ǽ� ���̺� ����(TBL_��ǰ)

CREATE TABLE TBL_��ǰ
( ��ǰ�ڵ�      VARCHAR2(20)
, ��ǰ��       VARCHAR2(100)
, �Һ��ڰ���     NUMBER
, ������      NUMBER DEFAULT 0
, CONSTRAINT ��ǰ_��ǰ�ڵ�_PK PRIMARY KEY(��ǰ�ڵ�)
);

--�ǽ� ���̺� ����(TBL_�԰�)
CREATE TABLE TBL_�԰�
( �԰��ȣ  NUMBER
, ��ǰ�ڵ�  VARCHAR2(20)
, �԰�����  DATE DEFAULT SYSDATE
, �ϰ����  NUMBER
, �԰�ܰ�  NUMBER
, CONSTRAINT �԰�_�԰��ȣ_PK PRIMARY KEY(�԰��ȣ)
, CONSTRAINT �԰�_��ǰ�ڵ�_FK FOREIGN KEY(��ǰ�ڵ�) 
                            REFERENCES TBL_��ǰ(��ǰ�ڵ�)
);

--��TBL_��ǰ ���̺� ��ǰ ������ �Է�
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('C001','������',1500);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('C002','������',1500);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('C003','�����',1300);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('C004','������',1800);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('C005','������',1900);

INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('H001','��ũ����',1000);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('H002','ĵ���',300);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('H003','�ֹֽ�',500);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('H004','������',600);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('H005','�޷γ�',500);

INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('E001','�������̽�',2500);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('E002','�ؾ�θ���',2000);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('E003','���Ǿ�',2300);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('E004','�źϾ�',2300);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('E005','��Ű��',2400);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('E006','��ȭ��',2000);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('E007','���Դ�',3000);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('E008','������Ʈ',3000);
INSERT INTO TBL_��ǰ(��ǰ�ڵ�, ��ǰ��, �Һ��ڰ���) VALUES('E009','������',3000);

COMMIT;
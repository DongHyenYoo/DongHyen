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

EXEC PRC_�԰�_INSERT('C001',20,900);


SELECT *
FROM TAB;

--�������ν��� �������� ���� ó������----

--�۽ǽ� ���̺� ����(TBL_MEMBER)
CREATE TABLE TBL_MEMBER
( NUM   NUMBER
, NAME  VARCHAR2(30)
, TEL   VARCHAR2(60)
, CITY  VARCHAR2(60)
, CONSTRAINT MEMBER_NUM_PK PRIMARY KEY(NUM)
);



EXEC PRC_MEMBER_INSERT('�ӽÿ�', '010-1111-1111', '����');
--==>> ������ �Է� ��

EXEC PRC_MEMBER_INSERT('�躸��', '010-2222-2222', '�λ�');
--������ �Է� X
--ORA-20001: ����,���,������ �Է��� �����մϴ�.

SELECT *
FROM TBL_MEMBER;

EXEC PRC_�԰�_INSERT('C001',30,1200); --������ 30�� �԰�

EXEC PRC_�԰�_INSERT('C002',30,1200); --������ 30�� �԰�

EXEC PRC_�԰�_INSERT('H001',50,800);

EXEC PRC_�԰�_INSERT('H002',50,200);

EXEC PRC_�԰�_INSERT('H001',50,800);

EXEC PRC_�԰�_INSERT('H002',50,200);

SELECT *
FROM TBL_�԰�;

SELECT *
FROM TBL_��ǰ;


--�� �ǽ� ���̺� ����(TBL_���)
CREATE TABLE TBL_���
( ����ȣ NUMBER
, ��ǰ�ڵ� VARCHAR2(20)
, ������� DATE DEFAULT SYSDATE
, ������ NUMBER
, ���ܰ� NUMBER
);

--Table TBL_��� ����

--����ȣ PK ����
ALTER TABLE TBL_���
ADD CONSTRAINTS ���_����ȣ_PK PRIMARY KEY(����ȣ);

--��ǰ�ڵ� FK ����
ALTER TABLE TBL_���
ADD CONSTRAINTS ���_����ȣ_FK FOREIGN KEY(��ǰ�ڵ�)
                                REFERENCES TBL_��ǰ(��ǰ�ڵ�);

SELECT NVL(����ȣ,0) --����ִٰ� NULL�ΰ��� �ƴ� ��¥ �׳� ����ֱ⿡ �ƹ����� ������ �ʴ´�.                                
FROM TBL_���;


EXEC PRC_���_INSERT('H001', 50, 1000);


SELECT *
FROM TBL_���;

SELECT *
FROM TBL_��ǰ;

ROLLBACK;

EXEC PRC_���_UPDATE(1,50);


EXEC PRC_���_DELETE(7);

--2�� Test ���� �԰�

EXEC PRC_�԰�_INSERT('C001',30,1200); --������ 30�� �԰�

EXEC PRC_�԰�_INSERT('C002',30,1200); --������ 30�� �԰�

EXEC PRC_�԰�_INSERT('H001',50,800);

EXEC PRC_�԰�_INSERT('H002',50,200);

EXEC PRC_�԰�_INSERT('H001',50,800);

EXEC PRC_�԰�_INSERT('H005',100,200);

EXEC PRC_�԰�_INSERT('E001',200,200);

SELECT *
FROM TBL_�԰�;


SELECT *
FROM TBL_��ǰ;

SELECT *
FROM TBL_���;

ROLLBACK;

EXEC PRC_�԰�_DELETE(6);
EXEC PRC_�԰�_UPDATE(13,20);

EXEC PRC_���_INSERT('E001',35,200);


EXEC PRC_���_DELETE(9);



SELECT *
FROM TBL_��ǰ;
/*
C001	������	    1500    0
C002	������	    1500	    0
C003	�����	    1300	    0
C004	������	    1800	    0
C005	������	    1900	    0
H001	��ũ����	    1000	    0
H002	ĵ���	    300	    0
H003	�ֹֽ�	    500	    0
H004	������	    600	    0
H005	�޷γ�	    500	    0
E001	�������̽�	2500	    0
E002	�ؾ�θ���	2000	    0
E003	���Ǿ�	    2300	    0
E004	�źϾ�	    2300	    0
E005	��Ű��	    2400	    0
E006	��ȭ��	    2000	    0
E007	���Դ�	    3000	    0
E008	������Ʈ	    3000	    0
E009	������	    3000    	0
*/

SELECT *
FROM TBL_�԰�;


/*
��������
*/

SELECT *
FROM TBL_���;

/*
��������
*/


EXEC PRC_�԰�_INSERT('C001',30,1200); 

EXEC PRC_�԰�_INSERT('C002',30,1200); 

EXEC PRC_�԰�_INSERT('H001',50,800);

EXEC PRC_�԰�_INSERT('H002',50,200);

EXEC PRC_�԰�_INSERT('H005',100,200);

EXEC PRC_�԰�_INSERT('E001',200,200);


SELECT *
FROM TBL_�԰�;
/*
1	H001	2022-09-05	50	800
2	H002	2022-09-05	50	200
3	H005	2022-09-05	100	200
4	E001	2022-09-05	200	200
5	C001	2022-09-05	30	1200
6	C002	2022-09-05	30	1200
*/


SELECT *
FROM TBL_��ǰ;

/*
C001	������	    1500	30
C002	������	    1500	30
C003	�����	    1300	0
C004	������	    1800	0
C005	������	    1900	0
H001	��ũ����	    1000	50
H002	ĵ���	    300	50
H003	�ֹֽ�	    500	0
H004	������	    600	0
H005	�޷γ�	    500	100
E001	�������̽�	2500	200
E002	�ؾ�θ���	2000	0
E003	���Ǿ�	    2300	0
E004	�źϾ�	    2300	0
E005	��Ű��	    2400	0
E006	��ȭ��	    2000	0
E007	���Դ�	    3000	0
E008	������Ʈ	    3000	0
E009	������	    3000	0
*/

EXEC PRC_���_INSERT('E001',35,200);
EXEC PRC_���_INSERT('H005',20,200);
EXEC PRC_���_INSERT('H001',40,200);
EXEC PRC_���_INSERT('H005',80,200);
EXEC PRC_���_INSERT('H002',25,1200);

SELECT *
FROM TBL_���;

/*
1	E001	2022-09-05	35	200
2	H005	2022-09-05	20	200
3	H001	2022-09-05	40	200
4	H005	2022-09-05	80	200
5	H002	2022-09-05	25	1200
*/


EXEC PRC_�԰�_UPDATE(3,150);
--PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.

SELECT *
FROM TBL_�԰�;

/*
1	H001	2022-09-05	50	800
2	H002	2022-09-05	50	200
3	H005	2022-09-05	150	200
4	E001	2022-09-05	200	200
5	C001	2022-09-05	30	1200
6	C002	2022-09-05	30	1200
*/


SELECT *
FROM TBL_��ǰ;

--H005	�޷γ�	500	50
-- 100 - 100 -100 + 150 = 50 (O)

EXEC PRC_�԰�_UPDATE(1,30);

/*
EGIN PRC_�԰�_UPDATE(1,30); END;
���� ���� -
ORA-20002: ����� ��� -�Դϴ�
ORA-06512: at "SCOTT.PRC_�԰�_UPDATE", line 51
ORA-06512: at line 1
*/

EXEC PRC_�԰�_UPDATE(1,30); --Ŀ�� ���

/*
����ȣ      �������      ������
   3          2022-09-05    40
�� ���� ������Ʈ �Ұ�
*/


EXEC PRC_�԰�_DELETE(6);
--PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.

SELECT *
FROM TBL_�԰�;

/*
1	H001	2022-09-05	50	800
2	H002	2022-09-05	50	200
3	H005	2022-09-05	150	200
4	E001	2022-09-05	200	200
5	C001	2022-09-05	30	1200
*/

EXEC PRC_�԰�_DELETE(7);
-- ����ó������ WHEN OTHERS�� ���� ROLLBACK����
-- PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.

EXEC PRC_�԰�_DELETE(3);
/*
EGIN PRC_�԰�_DELETE(3); END;
���� ���� -
ORA-20002: ������ ������ ��� �����ϴ�.
ORA-06512: at "SCOTT.PRC_�԰�_DELETE", line 48
ORA-06512: at line 1
*/




----------------------------------------- Ŀ��
EXEC PRC_�԰�_DELETE(7);

--�ش� �԰��ȣ�� �������� �ʽ��ϴ�.

EXEC PRC_�԰�_DELETE(3);
/*
����ȣ      �������      ������
   2          2022-09-05    20
   4          2022-09-05    80
�� ���� ���� �Ұ�
*/


SELECT *
FROM TBL_���;
/*
1	E001	2022-09-05	35	200
2	H005	2022-09-05	20	200
3	H001	2022-09-05	40	200
4	H005	2022-09-05	80	200
5	H002	2022-09-05	25	1200
*/


EXEC PRC_���_DELETE(3);

/*
1	E001	2022-09-05	35	200
2	H005	2022-09-05	20	200
4	H005	2022-09-05	80	200
5	H002	2022-09-05	25	1200
*/



--���

SELECT *
FROM TBL_��ǰ;
/*
C001	������	    1500    	30
C002	������	    1500	    0
C003	�����	    1300	    0
C004	������	    1800	    0
C005	������	    1900	    0
H001	��ũ����	    1000	    50
H002	ĵ���	    300	    25
H003	�ֹֽ�	    500	    0
H004	������	    600	    0
H005	�޷γ�	    500	    50
E001	�������̽�	2500	    165
E002	�ؾ�θ���	2000	    0
E003	���Ǿ�	    2300	    0
E004	�źϾ�	    2300	    0
E005	��Ű��	    2400	    0
E006	��ȭ��	    2000	    0
E007	���Դ�	    3000	    0
E008	������Ʈ	    3000	    0
E009	������	    3000	    0
*/

SELECT *
FROM TBL_�԰�;
/*
1	H001	2022-09-05	50	800
2	H002	2022-09-05	50	200
3	H005	2022-09-05	150	200
4	E001	2022-09-05	200	200
5	C001	2022-09-05	30	1200
*/

SELECT *
FROM TBL_���;

/*
1	E001	2022-09-05	35	200
2	H005	2022-09-05	20	200
4	H005	2022-09-05	80	200
5	H002	2022-09-05	25	1200
*/
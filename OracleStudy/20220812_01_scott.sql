--������ ������ IN �����ڸ� Ȱ���Ͽ�
-- ������ ���� ó���� �� ������
-- �� ������ ó������� ���� ����� ��ȯ�Ѵ�.

SELECT EMPNO "�����ȣ", ENAME "�����", JOB"������",SAL"�޿�", DEPTNO "�μ���ȣ"
FROM EMP
WHERE DEPTNO IN (20, 30);

--�� EMP ���̺��� ������ CLERK �� ������� �����͸� ��� ��ȸ�Ѵ�.

SELECT *
FROM EMP
WHERE JOB='CLERK';    --DATA�� ���� ��ҹ��� ������ �Ѵ�.

SELECT *
FROM EMP
WHERE JOB='clerk';    --DATA�� ���� ��ҹ��� ������ �Ѵ�.
--��ȸ ��� ���� �ҹ��ڶ�


--��EMP ���̺��� ������ CLERK�� ����� �߿� 20�� �μ��� �ٹ��ϴ� ������� 
--�����ȣ,�����,������,�޿�,�μ���ȣ �׸��� ��ȸ�Ѵ�.

SELECT *
FROM EMP;

SELECT EMPNO "�����ȣ",ENAME "�����", JOB "������", SAL "�޿�", DEPTNO "�μ���ȣ"
FROM EMP
WHERE JOB = 'CLERK' AND DEPTNO = 20;
--ó�� ���� FROM WHERE GROUP BY  HAVING SELECT ORDER BY ����
--�� WHERE������ SELECT���� ������ ��Ī�� ��������
--FROM ���� ���̺��� �������� WHERE���� ���ǿ� �´� ��鸸 �޸𸮿� �ۿø���.
--���� SELECT���� �ʿ��� Į���鸸 ���� ����Ѵ�.
/*
7369	SMITH	CLERK	800	20
7876	ADAMS	CLERK	1100	20
*/

--��EMP ���̺��� ������ �����͸� Ȯ���ؼ�
 -- �̿� �Ȱ��� �����Ͱ� ���ִ� ���̺��� ������ �����Ѵ�.
 --(������ .. EMP1, EMP2,EMP3,EMP4 �θ����.
 
 SELECT *
 FROM EMP;
 
 
 CREATE TABLE TBL_EMP
 AS
 SELECT*
 FROM EMP;     --�̷��Ծ��� ���۾� �ʿ���� �״�� �����ؿ´�.
 /*
 CREATE TABLE EMP4
 (EMPNO NUMBER(4)
 ,ENAME VARCHAR2(10)
 ,JOB VARCHAR2(9)
 ,MGR NUMBER(4)
 ,HIREDATE DATE
 ,SAL NUMBER(7,2)
 ,COMM NUMBER(7,2)
 ,DEPTNO NUMBER(2)
 );*/



--��DEPT ���̺��� �����Ͽ� ���� ���� TBL_DEPT ���̺��� �����Ѵ�.
CREATE TABLE TBL_DEPT
AS
SELECT *
FROM DEPT;
-->>Table TBL_DEPT ����

--�ۺ����� ���̺� Ȯ��
SELECT *
FROM TBL_DEPT;

--�����̺��� Ŀ��Ʈ ���� Ȯ��

SELECT *
FROM USER_TAB_COMMENTS;
--���� �ڸ�Ʈ�� ���� NULL

--�����̺� ������ Ŀ��Ʈ ���� �Է�
COMMENT ON TABLE TBL_EMP IS '��� ����';

--��TBL_DEPT ���̺��� ������� ���̺� ������ Ŀ��Ʈ ������ �Է�
COMMENT ON TABLE TBL_DEPT IS '�μ� ����';

--��Ŀ��Ʈ ������ �Է� �� Ȯ��
SELECT *
FROM USER_TAB_COMMENTS;

--�� �÷� ������ Ŀ��Ʈ ������ Ȯ�� (COL)
SELECT *
FROM USER_COL_COMMENTS;

SELECT *
FROM USER_COL_COMMENTS
WHERE TABLE_NAME='TBL_DEPT';
/*
TBL_DEPT    	DEPTNO	
TBL_DEPT	    DNAME	
TBL_DEPT	    LOC	
*/

--�����̺� �Ҽӵ� �÷��� ���� Ŀ��Ʈ �������Է�(����)
COMMENT ON COLUMN TBL_DEPT.DEPTNO IS '�μ� ��ȣ';
--==>>Comment��(��) �����Ǿ����ϴ�.
COMMENT ON COLUMN TBL_DEPT.DNAME IS  '�μ� �̸�';
--==>Comment��(��) �����Ǿ����ϴ�.
COMMENT ON COLUMN TBL_DEPT.LOC IS '�μ� ��ġ';

SELECT *
FROM USER_COL_COMMENTS
WHERE TABLE_NAME='TBL_DEPT';

DESC TBL_EMP;

COMMENT ON COLUMN TBL_EMP.EMPNO IS '�����ȣ';
COMMENT ON COLUMN TBL_EMP.ENAME IS '�����';
COMMENT ON COLUMN TBL_EMP.JOB IS '������';
COMMENT ON COLUMN TBL_EMP.MGR IS '������ �����ȣ';
COMMENT ON COLUMN TBL_EMP.HIREDATE IS '�Ի���';
COMMENT ON COLUMN TBL_EMP.SAL IS '�޿�';
COMMENT ON COLUMN TBL_EMP.COMM IS '����';
COMMENT ON COLUMN TBL_EMP.DEPTNO IS '�μ���ȣ';

SELECT *
FROM USER_COL_COMMENTS
WHERE TABLE_NAME = 'TBL_EMP';


---���� �÷� ������ �߰� �� ���� ����-----

SELECT *
FROM TBL_EMP;

--�� TBL_EMP ���̺� �ֹε�Ϲ�ȣ �����͸� ���� �� �ִ� �÷� �߰�
ALTER TABLE TBL_EMP 
ADD SSN CHAR(13);
--���������� �����Ѵ� /TABLE�� /TBL_EMP ���/ �߰��ؼ�  /������ Ÿ���� CHAR�� SSN�̶�� �̸��� Į����

SELECT '01035783912'
FROM DUAL;
--01035783912

SELECT 01035783912
FROM DUAL;
--1035783912

--��Ȯ��
DESC TBL_EMP;

/*
�̸�       ��? ����           
-------- -- ------------ 
EMPNO       NUMBER(4)    
ENAME       VARCHAR2(10) 
JOB         VARCHAR2(9)  
MGR         NUMBER(4)    
HIREDATE    DATE         
SAL         NUMBER(7,2)  
COMM        NUMBER(7,2)  
DEPTNO      NUMBER(2)    
SSN         CHAR(13) 
*/

-->SSN(�ֹε�� ��ȣ) �÷��� ���������� �߰���
--�÷��� ������ ���������� �ƹ� �ǹ̰� ����.

--TBL_EMP ���̺� �߰��� SSN(�ֹε�Ϲ�ȣ) �÷� ����
ALTER TABLE TBL_EMP
DROP COLUMN SSN;
--������ ����/ TBL_EMP ��� ���̺��� / ����� COLUMN�� SSN�̶��/
--�÷��� ���忡���� ���ŵǴ� ���̳� ���̺��� ���忡�� ������ �����̱⿡ ALTER

SELECT *
FROM TBL_EMP;
--SSN �÷� ���� Ȯ��

--DELETE TABLE�� �ص� DROP�� �޸� �����͸� �����ȴ�.
--���̺��� ����,����� �����Ѵ�.

DROP TABLE TBL_EMP;


--�����̺� �ٽ� ����(����)
CREATE TABLE TBL_EMP
AS
SELECT *
FROM EMP;


--��NULL �� ó��

SELECT 2, 10+2, 10-2, 10*2, 10/2
FROM DUAL;

SELECT NULL, NULL+2, NULL*2, NULL-2, NULL/2
FROM DUAL;
--==>>(NULL) (NULL) (NULL)   (NULL) (NULL)

--�ذ����� ���
-- NULL �� ������ ���� �ǹ��ϸ�.. ���� �������� �ʴ� ���̱� ������
-- �� NULL �� ���꿡 ���Ե� ���...
-- �� ����� ������ NULL �̴�.

--��TBL_EMP ���̺��� Ŀ�̼�(COMM,����)�� NULL�� ������
-- �����, ������, �޿�, Ŀ�̼� �׸���ȸ

SELECT *
FROM USER_COL_COMMENTS
WHERE TABLE_NAME ='TBL_EMP';

SELECT *
FROM TBL_EMP;


SELECT ENAME "�����",JOB "������", SAL "�޿�", COMM "Ŀ�̼�"
FROM TBL_EMP
WHERE COMM = null;
--��ȸ ��� x

SELECT ENAME "�����",JOB "������", SAL "�޿�", COMM "Ŀ�̼�"
FROM TBL_EMP
WHERE COMM = (null);
--��ȸ ��� x


SELECT ENAME "�����",JOB "������", SAL "�޿�", COMM "Ŀ�̼�"
FROM TBL_EMP
WHERE COMM IS NULL;
--NULL�� ������ �����ϴ� ���� �ƴϹǷ�
--�Ϲ����� �����ڸ� Ȱ���Ͽ� ���� �� ����.
--NULL�� ������� ����� �� ���� �����ڵ�
--  >=  ,   <=  ,>  ,<  , !=   [<>, ^=(���� �����ʴ�)] �̷��� ����


--��TBL_EMP ���̺��� 20�� �μ��� �ٹ����� �ʴ� ��������
-- �����, ������,�μ���ȣ �׸��� ��ȸ


SELECT ENAME "�����", JOB "������", DEPTNO "�μ���ȣ" 
FROM TBL_EMP
WHERE DEPTNO !=20;

SELECT ENAME "�����", JOB "������", DEPTNO "�μ���ȣ" 
FROM TBL_EMP
WHERE DEPTNO ^=20;

SELECT ENAME "�����", JOB "������", DEPTNO "�μ���ȣ" 
FROM TBL_EMP
WHERE DEPTNO <>20;

/*
ALLEN	SALESMAN	30
WARD	SALESMAN	30
MARTIN	SALESMAN	30
BLAKE	MANAGER	30
CLARK	MANAGER	10
KING	PRESIDENT	10
TURNER	SALESMAN	30
JAMES	CLERK	30
MILLER	CLERK	10
�´� ���� ���*/


--�� TBL_EMP ���̺��� Ŀ�̼��� NULL �� �ƴ� ��������
--�����, ������, �޿�, Ŀ�̼� �׸� ��ȸ

SELECT ENAME, JOB, SAL, COMM
FROM TBL_EMP
WHERE COMM IS NOT NULL; -- ! = NOT 

SELECT ENAME, JOB, SAL, COMM
FROM TBL_EMP
WHERE NOT COMM IS NULL; -- ! = NOT 
/*
ALLEN	SALESMAN	1600	300
WARD	SALESMAN	1250	500
MARTIN	SALESMAN	1250	1400
TURNER	SALESMAN	1500	0
*/

--��TBL_EMP ���̺��� ��� �������
--�����ȣ, �����, �޿�,Ŀ�̼�, ���� �׸��� ��ȸ�Ѵ�.
--�� �޿�(SAL)�� �ſ� ����,
-- ���� ����(COMM)�� ��1ȸ �����ϸ�, ���� ������ ���Եȴ�.

ALTER TABLE TBL_EMP ADD YSAL NUMBER(10);

DESC TBL_EMP;

ALTER TABLE TBL_EMP DROP COLUMN YSAL;

SELECT EMPNO "�����ȣ", ENAME "�����", SAL "�޿�", COMM "Ŀ�̼�", (SAL*12)+NVL(COMM,0) "����"
FROM TBL_EMP;
--COMM�� NULL�̸� ������ NULL�� �����Ƿ�

--��NVL() --ù��° �Ķ���Ͱ� NULL �̸� �ι�° �Ķ���͸� ��ȯ
          --ù��° �Ķ���Ͱ� NULL�� �ƴҰ�� ù��° �Ķ���� ��ȯ
SELECT NULL "COL1", NVL(NULL,10) "COL2", NVL(5,10) "COL3"
FROM DUAL;
--(NULL)	10	5

SELECT EMPNO "�����ȣ", ENAME "�����", SAL "�޿�", COMM "Ŀ�̼�", (SAL*12)+NVL(COMM,0) "����"
FROM TBL_EMP;

SELECT EMPNO "�����ȣ", ENAME "�����", SAL "�޿�", COMM "Ŀ�̼�"
, NVL((SAL*12)+COMM,SAL*12) "����"
FROM TBL_EMP;

--��NVL2()
--ù ��° �Ķ���� ���� NULL�� �ƴ� ���, �ι�° �Ķ���� ���� ��ȯ�ϰ�
--ù ��° �Ķ���� ���� NULL�� ���, ����° �Ķ���� ���� ��ȯ�Ѵ�.

SELECT ENAME "�����", NVL2(COMM, 'û��', '���') "����Ȯ��"
FROM TBL_EMP;
--NULL�� ��� ��� , �ƴѰ�� û��

--1
SELECT EMPNO "�����ȣ", ENAME "�����", SAL "�޿�", COMM "Ŀ�̼�", NVL2(COMM,(SAL*12)+COMM,SAL*12) "����"
FROM TBL_EMP;

--2
SELECT EMPNO "�����ȣ", ENAME "�����", SAL "�޿�", COMM "Ŀ�̼�", (SAL*12)+NVL2(COMM,COMM,0) "����"
FROM TBL_EMP;

--�� COALESCE()
-->�Ű������� ���� ������ ����.
--�� �տ� �ִ� �Ű��������� ���ʷ� NULL ���� �ƴ��� Ȯ���Ͽ�
--NULL �� �ƴҰ�� ��ȯ, NULL�� ��� �״��� �Ű������� ���� ��ȯ�Ѵ�.
--NVL() �̳� NVL2() �� ���Ͽ�
--��~~~�� ����� ���� ����� �� �ִٴ� Ư¡�� ������.

SELECT NULL "COL1"
,COALESCE(NULL,NULL,NULL,40) "COL2"
,COALESCE(NULL,NULL,30,NULL,NULL,60) "COL3"
FROM DUAL;
-- (null)  40  30  
--�� NULL�� �ƴѰ��� ���ö����� ã�ƺ��µ� �ٸ� NULL�� �ƴѰ��� ������ ����ϰ� ����

--�۵����� �߰� �Է�
INSERT INTO TBL_EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO)
VALUES(8000,'�迵��','SALESMAN',7369,SYSDATE,10);

INSERT INTO TBL_EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO,COMM)
VALUES(8000,'�ֳ���','SALESMAN',7369,SYSDATE,10,10);

COMMIT;

SELECT *
FROM TBL_EMP;


SELECT EMPNO "�����ȣ",ENAME "�����", SAL "�޿�", COMM "Ŀ�̼�", COALESCE((SAL*12)+COMM,SAL*12,COMM,0) "����"
FROM TBL_EMP;

--�۳�¥�� ���� ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';


--���÷��� �÷��� ����(����)

SELECT 1,2
FROM DUAL;
--1,2
SELECT 1+2
FROM DUAL;
--3

SELECT '����','Ŵ'
FROM DUAL;

SELECT '����'+'Ŵ'
FROM DUAL;
--ORA-01722: invalid number �ȵ�

SELECT '����'||'Ŵ'
FROM DUAL;
--����Ŵ 

SELECT ENAME||'    '||JOB
FROM TBL_EMP;
/*
SMITHCLERK
ALLENSALESMAN
WARDSALESMAN
JONESMANAGER
MARTINSALESMAN
BLAKEMANAGER
CLARKMANAGER
SCOTTANALYST
KINGPRESIDENT
TURNERSALESMAN
ADAMSCLERK
JAMESCLERK
FORDANALYST
MILLERCLERK
�迵��SALESMAN
�ֳ���SALESMAN
*/

SELECT '�����̴�',SYSDATE,'�� ����',500,'���� ���Ѵ�.'
FROM DUAL;
--�����̴�//	2022-08-12 16:04:05	//�� ����//	500//	���� ���Ѵ�.

SELECT SYSDATE, CURRENT_DATE,LOCALTIMESTAMP
FROM DUAL;
--2022-08-12 16:05:23	2022-08-12 16:05:23	22/08/12 16:05:23.000000000

SELECT '�����̴�'||SYSDATE||'�� ����'||500||'���� ���Ѵ�.'
FROM DUAL;
--�����̴�2022-08-12 16:06:19�� ����500���� ���Ѵ�.
--����Ŭ������ ����Ÿ���� ���·� �� ��ȯ�ϴ� ������ ���� ����
-- || �� ������ �ָ� ������ �÷��� �÷�(���� �ٸ� ������ ������)��
-- �����ϴ� ���� �����ϴ�.
-- MSSQL ������ ��� �����͸� ���ڿ��� CONVERT�ؾ� �Ѵ�.

--��TBL_DMP ���̺��� ������ ���� ��� ������ �ִ� ������ �ۼ�
--SMITH�� ���� ������ 9600�ε� ��� ������ 19200�̴�.
-- ALLEN�� ���� ������ 19500�ε� ��� ������ 39000�̴�.

--�� ���ڵ帶�� ���� ���� ������ ���÷��� ��� ��ȸ�ɼ� �ֵ��� ó���Ѵ�.

SELECT ENAME
      ||'�� ���� ������'
      ||COALESCE((SAL*12)+COMM,SAL*12,COMM,0)
      ||'�ε� ��� ������'
      ||2*COALESCE((SAL*12)+COMM,SAL*12,COMM,0)
      ||'�̴�.'
FROM TBL_EMP;

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';


--��TBL_EMP ���̺��� �����͸� Ȱ���Ͽ�
-- ������ ���� ����� ���� �� �ֵ��� �������� �����Ѵ�.
-- SMITH's �� �Ի����� 1980-12-17�̴� �׸��� �޿��� 800�̴�. ó�� ������
-- ALLEN's �� �Ի����� 1980-12-17�̴� �׸��� �޿��� 1600�̴�.

SELECT ENAME
       ||'''s �Ի�����'
       ||HIREDATE
       ||'�̴�. �׸��� �޿��� '
       ||SAL
       ||'�̴�.'
FROM TBL_EMP;
--�ع��ڿ��� ��Ÿ���� Ȧ����ǥ ������ Ȧ����ǥ 2���� Ȧ����ǥ �Ѱ��� �ǹ��ϰ� �ȴ�.
--Ȧ����ǥ ' �Ѱ��� ���ڿ��� ������ ��Ÿ����
--ȦŸ��ǥ ''�ΰ��� ���ڿ� ���� �ȿ��� ' �Ѱ��� ��Ÿ����.

/*
SMITH's �Ի�����1980-12-17�̴�. �׸��� �޿��� 800�̴�.
ALLEN's �Ի�����1981-02-20�̴�. �׸��� �޿��� 1600�̴�.
WARD's �Ի�����1981-02-22�̴�. �׸��� �޿��� 1250�̴�.
JONES's �Ի�����1981-04-02�̴�. �׸��� �޿��� 2975�̴�.
MARTIN's �Ի�����1981-09-28�̴�. �׸��� �޿��� 1250�̴�.
BLAKE's �Ի�����1981-05-01�̴�. �׸��� �޿��� 2850�̴�.
CLARK's �Ի�����1981-06-09�̴�. �׸��� �޿��� 2450�̴�.
SCOTT's �Ի�����1987-07-13�̴�. �׸��� �޿��� 3000�̴�.
KING's �Ի�����1981-11-17�̴�. �׸��� �޿��� 5000�̴�.
TURNER's �Ի�����1981-09-08�̴�. �׸��� �޿��� 1500�̴�.
ADAMS's �Ի�����1987-07-13�̴�. �׸��� �޿��� 1100�̴�.
JAMES's �Ի�����1981-12-03�̴�. �׸��� �޿��� 950�̴�.
FORD's �Ի�����1981-12-03�̴�. �׸��� �޿��� 3000�̴�.
MILLER's �Ի�����1982-01-23�̴�. �׸��� �޿��� 1300�̴�.
�迵��'s �Ի�����2022-08-12�̴�. �׸��� �޿��� �̴�.
�ֳ���'s �Ի�����2022-08-12�̴�. �׸��� �޿��� �̴�.
*/

--�� UPPER(), LOWER(), INITCAP() 
-- ��ü �빮��, ��ü�ҹ���, ù���ڸ� �빮�ڷ� ��ȯ�� �������� �ҹ��ڷ� ��ȯ �ϰ� ��ȯ

SELECT 'oRaCle' "COL1", UPPER('oracLe') "COL2" , LOWER('oRaCLe') "COL3" , INITCAP('oRaCle') "COL4"
FROM DUAL;

--�� TBL_EMP ���̺��� ������� �˻����� 'sALeSmaN' �� ��������
--�ش� ���� ����� �����ȣ, �����, ������ ��ȸ

SELECT EMPNO "�����ȣ", ENAME "�����", JOB "������"
FROM TBL_EMP
WHERE JOB = UPPER('sALeSmaN');

DESC TBL_EMP;

--�߰� ������ �Է�
INSERT INTO TBL_EMP(EMPNO, ENAME,JOB,MGR,HIREDATE,SAL,COMM)
VALUES(8002,'���¹�','salesman',7369,SYSDATE,20,100);

COMMIT;

--��TBL_EMP ���̺��� ������� �˻����� 'saLeSmAN'�� ��������
-- �������(�������)�� �����ȣ,�����,�������� ��ȸ

SELECT EMPNO "�����ȣ", ENAME "�����", INITCAP(JOB) "������" 
FROM TBL_EMP
WHERE INITCAP('saLeSmAN') = INITCAP(JOB);

--WHERE LOWER(JOB) = LOWER('saLeSmAN')

--��TBL_EMP ���̺��� �Ի����� 1981�� 9�� 28�� �Ի��� ������
--�����, ������, �Ի��� �׸��� ��ȸ�Ѵ�.
SELECT ENAME "�����", JOB "������", HIREDATE "�Ի���"
FROM TBL_EMP
WHERE HIREDATE ='1981-09-28'; --�̷��� �ϴ°� �ƴ�

--��TO_DATE()

SELECT ENAME "�����", JOB "������", HIREDATE "�Ի���"
FROM TBL_EMP
WHERE HIREDATE = TO_DATE('1981-09-28','YYYY-MM-DD');
--����Ÿ���� ��¥Ÿ������ ��ȯ���ִ� �Լ�
--==>>MARTIN SALESMAN 1981-09-28

--��TBL_EMP ���̺��� �Ի����� 1981�� 9�� 28�� ����(�ش��� ����)
--�Ի��� ������ �����, ������,�Ի��� �׸��� ��ȸ�Ѵ�.

SELECT ENAME, JOB, HIREDATE
FROM TBL_EMP
WHERE HIREDATE >= TO_DATE('1981-09-28','YYYY-MM-DD');
/*
MARTIN	SALESMAN	1981-09-28
SCOTT	ANALYST	1987-07-13
KING	PRESIDENT	1981-11-17
ADAMS	CLERK	1987-07-13
JAMES	CLERK	1981-12-03
FORD	ANALYST	1981-12-03
MILLER	CLERK	1982-01-23
�迵��	SALESMAN	2022-08-12
�ֳ���	SALESMAN	2022-08-12
���¹�	salesman	2022-08-12
*/

--�ؿ���Ŭ������ ��¥ �������� ũ�� �񱳰� �����ϴ�.
--�񱳱������� �̷��� �� ū��

--��TBL_EMP ���̺��� �Ի����� 1981 4�� 2�Ϻ��� 
--1981�� 9�� 28�� ���̿� �Ի��� �������� �����,������,�Ի��� ��ȸ(�ش��� ����)

SELECT ENAME, JOB, HIREDATE
FROM TBL_EMP
WHERE TO_DATE('1981-04-02','YYYY-MM-DD')<=HIREDATE AND HIREDATE<= TO_DATE('1981-09-28','YYYY-MM-DD');
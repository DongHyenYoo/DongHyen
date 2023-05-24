SELECT USER
from DUAL;

--SCOTT���� ���ӵ�

CREATE TABLE DEPT
( DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY
, DNAME VARCHAR2(14)
, LOC VARCHAR2(13) 
) ;


CREATE TABLE EMP
( EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY
, ENAME VARCHAR2(10)
, JOB VARCHAR2(9)
, MGR NUMBER(4)
, HIREDATE DATE
, SAL NUMBER(7,2)
, COMM NUMBER(7,2)
, DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT
);



INSERT INTO DEPT VALUES	(10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES	(30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES	(40,'OPERATIONS','BOSTON');

--1 �� ��(��) ���ԵǾ����ϴ�.*4


INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,to_date('13-7-1987','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,to_date('13-7-1987','dd-mm-yyyy'),1100,NULL,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,to_date('23-1-1982','dd-mm-yyyy'),1300,NULL,10);
--1 �� ��(��) ���ԵǾ����ϴ�. * 14

DROP TABLE BONUS;

CREATE TABLE BONUS
( ENAME VARCHAR2(10)
, JOB VARCHAR2(9)
, SAL NUMBER
, COMM NUMBER
);

--Bonus ����

CREATE TABLE SALGRADE
( GRADE NUMBER
, LOSAL NUMBER
, HISAL NUMBER 
);


INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);

COMMIT;



--SCOTT ������ �����ִ� ���̺� ��ȸ
SELECT *
FROM TAB;

/*
BONUS	TABLE	
DEPT	TABLE	
EMP	TABLE	
SALGRADE	TABLE	
*/

SELECT *
from user_tables;
/*
DEPT	USERS			VALID	10		1	255	65536	1048576	1	2147483645				YES	N									         1	         1	    N	ENABLED			NO		N	N	NO	DEFAULT	DEFAULT	DEFAULT	DISABLED	NO	NO		DISABLED	YES		DISABLED	DISABLED		NO	NO	YES	DEFAULT
EMP	USERS			VALID	10		1	255	65536	1048576	1	2147483645				YES	N									         1	         1	    N	ENABLED			NO		N	N	NO	DEFAULT	DEFAULT	DEFAULT	DISABLED	NO	NO		DISABLED	YES		DISABLED	DISABLED		NO	NO	YES	DEFAULT
BONUS	USERS			VALID	10		1	255	65536	1048576	1	2147483645				YES	N									         1	         1	    N	ENABLED			NO		N	N	NO	DEFAULT	DEFAULT	DEFAULT	DISABLED	NO	NO		DISABLED	YES		DISABLED	DISABLED		NO	NO	YES	DEFAULT
SALGRADE	USERS			VALID	10		1	255	65536	1048576	1	2147483645				YES	N									         1	         1	    N	ENABLED			NO		N	N	NO	DEFAULT	DEFAULT	DEFAULT	DISABLED	NO	NO		DISABLED	YES		DISABLED	DISABLED		NO	NO	YES	DEFAULT
*/

--�������� ��ȸ�� ������ ���̺����
-- � ���̺����̽��� ����Ǿ� �ִ��� ��ȸ
SELECT TABLE_NAME, TABLESPACE_NAME
FROM USER_TABLES;
/*
DEPT	USERS
EMP	USERS
BONUS	USERS
SALGRADE	USERS
*/

--�� ���̺� ����(TBL_EXAMPLE1)
CREATE TABLE TBL_EXAMPLE1
(NO NUMBER(4)
,NAME VARCHAR2(10)
,ADDR VARCHAR2(20)
);
--Table TBL_EXAMPLE1

--�����̺� ����(���̺� ��: TBL_EXAMPLE2)
CREATE TABLE TBL_EXAMPLE2
(NO NUMBER(4)
,NAME VARCHAR2(20)
,ADDR VARCHAR2(20)
) TABLESPACE TBS_EDUA;
--Table TBL_EXAMPLE2��(��) �����Ǿ����ϴ�.

--��TBL_EXAMPLE1 �� TBL_EXAMPLE2 ���̺���
--  ���� � ���̺����̽��� ����Ǿ� �ִ��� ��ȸ
SELECT TABLE_NAME, TABLESPACE_NAME
FROM USER_TABLES;
/*
DEPT	USERS
EMP	USERS
BONUS	USERS
SALGRADE	USERS
TBL_EXAMPLE1        	USERS  ���̺� �ڿ� ��� �����ϰڴٴ��� ���� ����
TBL_EXAMPLE2	        TBS_EDUA ���̺� �ڿ� ��� �����ϰڴ��ߴ��� ����
*/


---------------------------------------------------------
--������ ������Ʈ�� sys���� ���� �ʿ��Ѱ� �������� ����϶�� ����

---------------------------------------------------------
--���� ����Ŭ ���� ����

---��������� �����ͺ��̽�����------

--������ �����͸� ���̺��� ���·� ������� ������ ���� ����
--�׸��� �̵� ������ ���̺�� ���� ���踦 �����Ͽ� ������� ���� ����

/*============================
��SELECT ���� ó��(PARSING)����

SELECT �÷���      ---�릤�⺻����
FROM ���̺��      ---�禥
WHERE ������       ---��+
GROUP BY ��        ---��+  ������ �ְ� ������ ����
HAVING ������      ---��+
ORDER BY ��        ---��+

SELECT �÷�1, �÷�2, �÷�4

WHERE ������
     (Ű�� 170�̻�)
     (������ ������) 
�� �� �÷����� ���ǿ� �ش�Ǵ� �ุ ������ �ϴ°�

GROUP BY ��
    (���� ���°�  ������ ������ ����� �����λ��)
HAVING ����
   GROUP BY ������ �����ִ� �׷쿡���� ����
   
ORDER BY ��
       (���� ����)�� ������ ������ �����ϰ� �ϴ���
       
1-2-3-4-5-6 ������� �ܿ�� ����

=============================*/

--��SCOTT ������ ���̺� ��ȸ
SELECT *
FROM TAB;
/*
BONUS	TABLE   --���ʽ�(BONUS) ������ ���̺�	
DEPT	TABLE	--�μ�(DEPARTMENTS) ������ ���̺�
EMP	TABLE	   --���(EMPLOYEES) ������ ���̺�
SALGRADE	TABLE	 --�޿�(SAL) ������ ���̺�
TBL_EXAMPLE1	TABLE	
TBL_EXAMPLE2	TABLE	
*/

--�۰� ���̺��� ������ ��ȸ
SELECT *
FROM BONUS;

SELECT *
FROM DEPT;
/*
10	ACCOUNTING	NEW YORK
20	RESEARCH	DALLAS
30	SALES	CHICAGO
40	OPERATIONS	BOSTON
*/
SELECT *
FROM EMP;
/*
7369	SMITH	CLERK	7902    	80/12/17	800		20
7499	ALLEN	SALESMAN	7698	81/02/20	1600	300	30
7521	    WARD	SALESMAN	7698	81/02/22	1250	500	30
7566	JONES	MANAGER	7839	81/04/02	2975		20
7654	MARTIN	SALESMAN	7698	81/09/28	1250	1400	30
7698	BLAKE	MANAGER	7839	81/05/01	2850		30
7782    	CLARK	MANAGER	7839	81/06/09	2450		10
7788	SCOTT	ANALYST	7566	87/07/13	3000		20
7839	KING	PRESIDENT		81/11/17	    5000		10
7844	TURNER	SALESMAN	7698	81/09/08	1500	0	30
7876	ADAMS	CLERK	7788	87/07/13	1100		20
7900    	JAMES	CLERK	7698	81/12/03	950		30
7902    	FORD	ANALYST	7566	81/12/03	3000		20
7934	MILLER	CLERK	7782	82/01/23	1300		10
*/

SELECT *
FROM SALGRADE;
/*
1	700	1200
2	1201	1400
3	1401	2000
4	2001	3000
5	3001	9999
*/

--DEPT ���̺� �����ϴ� �÷��� ���� ��ȸ
DESCRIBE DEPT;
/*
�̸�     ��?       ����           
------ -------- ------------ 
DEPTNO NOT NULL NUMBER(2)    
DNAME           VARCHAR2(14) 
LOC             VARCHAR2(13)

NOT NULL = NULL�̸� �ȵȴ�.

--DEPTNO  DNAME    LOC
�μ���ȣ   �μ���    �μ���ġ
-----------------------------
--10     �λ��     ����      ->������ �Է� ����
--20                ����      ->������ �Է� ����
--       �λ��     ����      ->������ �Է� �Ұ���
*/

-------------------------------------------------
----���� ����Ŭ�� �ֿ� �ڷ���(DATA TYPE)����----
/*

cf)MSSQL ������ ���� ǥ�� Ÿ��

  smallint  -32,768 ~ 72,767 2Byte
  int  -21�� ~ 21��         4Byte
  bigint  ��ûŭ           8Byte
  
  MSSQL ������ �Ǽ� ǥ�� Ÿ��
  float, real
  
  MSSQL ������ ���� ǥ�� Ÿ��
  decimal, numeric
  
  MSSQL ������ ���� ǥ�� Ÿ��
  char, varchar,Nvarchar
  
  
  --�� ORACLE�� ���� ǥ�� Ÿ���� �Ѱ����� ���ϵǾ� �ִ�.

 1.������ NUMBER�� ���� ���̾���.
   if NUMBER�ϰ� ǥ�����̸� ��������ٸ� -10 38��-1 ~ 10�� 38��
   NUMBER(3) -> -999 ~ + 999
   NUMBER(4) -> -9999 ~ + 9999 ���� ǥ��
   NUMBER(4,1) -> 4= �ڸ�  1 = �Ҽ��� ���°�ڸ����� ǥ��
              = -999.9 ~ + 999.9
              
 ��ORACLE�� ���� ǥ�� Ÿ��
 
 2.������ CHAR        ->������ ũ�� (������ ������ ũ�⸦ �Ҹ�)
        CHAR(10)     ->'���ǽ�' = 6����Ʈ�Ƿ� 10����Ʈ �ȿ� ���
                     ->�ٸ� Byte ����
        
         VARCHAR2    ->������ ũ�� (��Ȳ������ ũ�Ⱑ ����ȴ�)
         VARCHAR2(10) <--'�ڿ���' �̷��� 6Byte�� �Ҹ��ϰԵȴ�.
         VARCHAR2(10) <--�׷��ٰ� 10����Ʈ�� �ʰ��ϰ� �Ǹ� �Է� �Ұ���
         
         NCHAR       ->�����ڵ� ��� ������ ũ��(���� ��)
        NCHAR(10)     =10����
                    
         NVARCHAR2   ->�����ڵ� ��� ������ ũ��(���� ��)
         NVARCHAR2(10) =10���� ���� �ִ�.

 3.��¥�� DATE
 

*/

SELECT HIREDATE
FROM EMP;

DESCRIBE EMP;
--DESC EMP; �� �������

--�� ��¥ ���Ŀ� ���� ���� ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
--Session��(��) ����Ǿ����ϴ�.

SELECT HIREDATE
FROM EMP;
/*
1980-12-17
1981-02-20
1981-02-22
1981-04-02
1981-09-28
1981-05-01
1981-06-09
1987-07-13
1981-11-17
1981-09-08
1987-07-13
1981-12-03
1981-12-03
1982-01-23
*/

SELECT SYSDATE
FROM DUAL;
--2022-08-11 ���� �ý��ۿ� ���� DATE

--�� ��¥ ���Ŀ� ���� ���� ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH:MI:SS';
--Session��(��) ����Ǿ����ϴ�.

SELECT SYSDATE
FROM DUAL;
--==>>2022-08-11 05:11:22

--�� ��¥ ���Ŀ� ���� ���� ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
--Session��(��) ����Ǿ����ϴ�.


SELECT SYSDATE
FROM DUAL;
--2022-08-11 17:11:53

--EMP ���̺� ���� �����ȣ, �����, �޿�, Ŀ�̼� �����͸� ��ȸ
DESC EMP;

SELECT *
FROM EMP;

SELECT EMPNO, ENAME, SAL, COMM 
FROM EMP;
--EMP���̺��� �μ���ȣ�� 20���� �������� �����͵���
 --�����ȣ,�����,������,�޿�,�μ���ȣ ��ȸ
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = 20; --����Ŭ������ =�� ���ٶ�¶�
/*
7369	SMITH	CLERK	800	20
7566	JONES	MANAGER	2975	20
7788	SCOTT	ANALYST	3000	20
7876	ADAMS	CLERK	1100	20
7902	FORD	ANALYST	3000	20
*/

---AS " "�� ���� " "�� �� �÷��� ��Ī�� �����Ҽ��ִ�. AS��������
SELECT EMPNO AS "�����ȣ", ENAME "�����", JOB ������
FROM EMP;

--�����̺��� ��ȸ�ϴ� ��������
-- �� �÷��� �̸����� ��Ī(ALIAS)�� �ο��� �� �ִ�.
-- �⺻ ������ ������ �÷��� AS "��Ī�̸�" �� ���·� �ۼ��Ǹ�
-- �̶� AS�� ������ �����ϴ�.
-- ����, ��Ī �̸��� ���δ� ""�� ������ ���������� �ް��ϸ� �Ⱦ��°ɷ�
-- �����ϸ� ���� �Ұ���
-- ������ ������ �ش� �÷��� ǥ���� ���� ������ �ǹ���


--��EMP ���̺��� �μ���ȣ�� 20���� 30�� �������� �����͵���
-- �����ȣ, �����,������,�޿� �μ���ȣ �׸��� ��ȸ�Ѵ�.
--�� ��Ī�� ����Ѵ�.

SELECT *
FROM EMP;

SELECT EMPNO "�����ȣ", ENAME "�����", JOB "������", SAL "�޿�", DEPTNO "�μ���ȣ"
FROM EMP
WHERE DEPTNO =20 OR DEPTNO = 30;


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

SELECT *
FROM DEPT;
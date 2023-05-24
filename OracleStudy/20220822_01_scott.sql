SELECT T1.�Ի���, T1.�ο���
FROM
(
    SELECT TO_CHAR(HIREDATE, 'YYYY-MM') "�Ի���"
        , COUNT(*) "�ο���"
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'YYYY-MM')
)T1
WHERE T1.�ο��� = ( SELECT MAX(T2.�ο���)
                    FROM (
                SELECT TO_CHAR(HIREDATE, 'YYYY-MM') "�Ի���"
                  , COUNT(*) "�ο���"
                      FROM EMP
                     GROUP BY TO_CHAR(HIREDATE, 'YYYY-MM')
                     )T2
                     )
ORDER BY 1;

/*
1981-02	2
1981-09	2
1981-12	2
1987-07	2
*/

-------------------------------------------------------------------------
-----���� ROW_NUMBER ����-----

SELECT ENAME "�����", SAL "�޿�", HIREDATE "�Ի���"
FROM EMP;

--������ �������� �హ�� = sql developer ���� ���ִ°ͻ�

SELECT ROW_NUMBER() OVER(ORDER BY SAL DESC) "�׽�Ʈ"
        ,ENAME "�����", SAL "�޿�", HIREDATE "�Ի���"
FROM EMP;
/*
1	KING	5000	1981-11-17
2	FORD	3000	1981-12-03
3	SCOTT	3000	1987-07-13
4	JONES	2975	1981-04-02
5	BLAKE	2850	1981-05-01
6	CLARK	2450	1981-06-09
7	ALLEN	1600	1981-02-20
8	TURNER	1500	1981-09-08
9	MILLER	1300	1982-01-23
10	WARD	1250	1981-02-22
11	MARTIN	1250	1981-09-28
12	ADAMS	1100	1987-07-13
13	JAMES	950	1981-12-03
14	SMITH	800	1980-12-17
*/
SELECT ROW_NUMBER() OVER(ORDER BY SAL DESC) "�׽�Ʈ"
        ,ENAME "�����", SAL "�޿�", HIREDATE "�Ի���"
FROM EMP
ORDER BY ENAME;
/*
12	ADAMS	1100	1987-07-13
7	ALLEN	1600	1981-02-20
5	BLAKE	2850	1981-05-01
6	CLARK	2450	1981-06-09
2	FORD	3000	1981-12-03
13	JAMES	950	1981-12-03
4	JONES	2975	1981-04-02
1	KING	5000	1981-11-17
11	MARTIN	1250	1981-09-28
9	MILLER	1300	1982-01-23
3	SCOTT	3000	1987-07-13
14	SMITH	800	1980-12-17
8	TURNER	1500	1981-09-08
10	WARD	1250	1981-02-22
*/ --ENAME ���� �����ϴ� �Ͱ��� �ٸ���.
--ENAME���� �����ؼ� ��ȣ ���̱�
SELECT ROW_NUMBER() OVER(ORDER BY ENAME) "�׽�Ʈ"
        ,ENAME "�����", SAL "�޿�", HIREDATE "�Ի���"
FROM EMP
ORDER BY ENAME;
/*
1	ADAMS	1100	1987-07-13
2	ALLEN	1600	1981-02-20
3	BLAKE	2850	1981-05-01
4	CLARK	2450	1981-06-09
5	FORD	3000	1981-12-03
6	JAMES	950	1981-12-03
7	JONES	2975	1981-04-02
8	KING	5000	1981-11-17
9	MARTIN	1250	1981-09-28
10	MILLER	1300	1982-01-23
11	SCOTT	3000	1987-07-13
12	SMITH	800	1980-12-17
13	TURNER	1500	1981-09-08
14	WARD	1250	1981-02-22
*/

SELECT ROW_NUMBER() OVER(ORDER BY ENAME) "�׽�Ʈ"
        ,ENAME "�����", SAL "�޿�", HIREDATE "�Ի���"
FROM EMP
WHERE DEPTNO = 20
ORDER BY ENAME;
/*
1	ADAMS	1100	1987-07-13
2	FORD	3000	1981-12-03
3	JONES	2975	1981-04-02
4	SCOTT	3000	1987-07-13
5	SMITH	800	1980-12-17
*/ --���ͳ� �Խ��ǿ��� �ַ� ���̴� ���

--�� �Խ����� �Խù� ��ȣ�� SEQUENCE �� IDENTITY �� ����ϰ� �Ǹ�
--  �Խù��� �������� ���.. ������ �Խù��� �ڸ��� ���� ��ȣ�� ����
-- �Խù��� ��ϵǴ� ��Ȳ�� �߻��ϰ� �ȴ�.
-- �̴�... ���ȼ� �����̳�... �̰���.. �ٶ������� ���� ������ �� �ֱ� ������
-- ROW_NUMBER() �� ����� ����� �� �� �ִ�.
-- ������ �������� ����� ������ SEQUENCE �� IDENTITY�� ���������
-- �ܼ��� �Խù��� ���ȭ �Ͽ� ����ڿ��� ����Ʈ �������� ������ ������
-- ������� �ʴ� ���� �ٶ����� �� �ִ�.

--��SEQUENCE(������ : �ֹ���ȣ)
-- ->�������� �ǹ� : 1.(��� �ൿ ����) ����,  2.(�Ϸ���) �������� ��ǵ�

CREATE SEQUENCE SEQ_BOARD   --�⺻���� ������ ���� ����
START WITH 1  --1���� �����ϰ��ϰڴ�.
INCREMENT BY 1 -- 1�� �����ϰ� ����ڴ�.
NOMAXVALUE  --�ִ밪�� ���س���... �ٸ� ���� �ʴ°��� �Ϲ����̴�.
NOCACHE; -- ĳ�� ��� ����(����)

-- ĳ�ÿ� ���� �ο� ����
-- ������ ���� ������ �� �̸� ������ ������ ���� ������ ����
-- ������, DB�� ������Ű�ų� ������ off �Ǵ� ���� ����
-- �̸� ������ ������ ������ �� ������ �������� 
-- ������ ������ ���� �̸� ������ �� ���� ���� ���ȴٴ� ��

--Sequence SEQ_BOARD��(��) �����Ǿ����ϴ�.

--�۽ǽ� ���̺� ����
CREATE TABLE TBL_BOARD
( NO        NUMBER          --�Խù� ��ȣ X    ����� �ۼ� X
, TITLE     VARCHAR2(50)    --�Խù� ���� ��
, CONTENTS  VARCHAR2(1000)  --�Խù� ���� ��  ����� �ۼ�
, NAME      VARCHAR2(20)    --�Խù� �ۼ��� �� ����ڰ� �ۼ��Ҽ��� �ƴҼ���
, PW        VARCHAR2(20)    --�Խù� �н����� �� ����ڰ� �ۼ��Ҽ��� �ƴҼ���
, CREATED   DATE DEFAULT SYSDATE --�Խù� �ۼ��� X
);
--Table TBL_BOARD��(��) �����Ǿ����ϴ�.

--�� ������ �Է� -> �Խ��ǿ� �Խù��� �ۼ��� �׼�
INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '��~�ڰ�
�ʹ�', '10�и� �ڰ� �ò���', '������', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '��~����', '����������������', '���ҿ�', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '����ʹ�', '�����̰� ���� �;��', '������', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '����Ŀ�', '��ħ�ε� ����Ŀ�', '������', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '�ʹ��־��', '������ ���������� �ʹ� �־��', '���¹�', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '���ڶ��', '���� ���� ���ڶ��', '������', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '���ο�', '���� ���� ���� ���ڶ��', '������', 'java002$', DEFAULT);

INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '��´��', '���ù���� ��´��', '�ڿ���', 'java002$', DEFAULT);

SELECT *
FROM TBL_BOARD;
--������ ���� Ȯ��

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';

DROP TABLE TBL_BOARD PURGE;
--==>>Table TBL_BOARD��(��) �����Ǿ����ϴ�.

DROP SEQUENCE SEQ_BOARD;
--==>>Sequence SEQ_BOARD��(��) �����Ǿ����ϴ�.



COMMIT;
--�� �Խù� ����
DELETE
FROM TBL_BOARD
WHERE NO = 1;

DELETE
FROM TBL_BOARD
WHERE NO = 6;

DELETE
FROM TBL_BOARD
WHERE NO = 8;

--���� Ȯ��
SELECT*
FROM TBL_BOARD;

--�۰Խù� �ۼ�
INSERT INTO TBL_BOARD VALUES
(SEQ_BOARD.NEXTVAL, '�����սô�' , '�� ���������� �ʾƿ�', '������','java002$', DEFAULT);

DELETE
FROM TBL_BOARD
WHERE NO = 7;

--Ȯ��
SELECT *
FROM TBL_BOARD;


SELECT ROW_NUMBER() OVER(ORDER BY CREATED) "�۹�ȣ"
       ,TITLE, NAME, CREATED
FROM TBL_BOARD
ORDER BY 4 DESC;
/*
5	�����սô�	������	2022-08-22 10:39:50
2	����ʹ�	������	2022-08-22 10:39:41
4	�ʹ��־��	���¹�	2022-08-22 10:39:41
1	��~����	���ҿ�	2022-08-22 10:39:41
3	����Ŀ�	������	2022-08-22 10:39:41
*/

-----------------------------------------------------

-----���� JOIN(����) ����------  �ſ� �߿�

--1. SQL 1992 CODE


--CROSS JOIN
SELECT *
FROM EMP, DEPT;
--56���� ������ EMP 14�� DEPT 4��
--��ī��Ʈ ���ϱ�(CATERSIAN PRODUCT)
-- �� ���̺��� ������ ��� ����� ��

--EQUI JOIN : ���� ��Ȯ�� ��ġ�ϴ� �͵鳢�� �����Ͽ� ���ս�Ű�� ���� ���
SELECT *
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;
--14���� ���

SELECT *
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;


--NON EQUI JOIN
SELECT *
FROM SALGRADE;

SELECT * 
FROM EMP;

SELECT *
FROM EMP E, SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL;
--���� SAL~ ���� SAL ������ �����ϴ� �͵鳢�� ���Ķ�

--EQUI JOIN �� + �� Ȱ���� ���� ���
SELECT *
FROM TBL_EMP; --19��

SELECT *
FROM TBL_DEPT; --4��

SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO = D.DEPTNO; --14��
-->�� 14���� �����Ͱ� ���յǾ� ��ȸ�� ��Ȳ
-- ��, �μ���ȣ�� ���� ���� ����� 5���� ���� ����
-- ����, �Ҽ� ����� ���� ���� �μ� 1 ��� ����

SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO = D.DEPTNO(+); --19���� ������ �μ���ȣ ���� ����� ����
--�Ҽ� ����� �������� �μ�(40��) ���� -----(+)�� ���� ���̺��� ������
-- �μ���ȣ�� ���� ���� ����� 5�� ����

SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO; --15���� ������ �Ҽӻ���� ���� �μ� ����
--�μ� ��ȣ�� ���� ���� ����� 5�� ����---------------(+)�� ���� ���̺��� ������
--�Ҽ� ����� ���� ���� �μ�(40��) ����

--�� + �� ���� ���� �����͸� ���� �޸𸮿� ������      --����
--+�� �ִ� �� ���̺��� �����͸� �ϳ��ϳ� Ȯ���Ͽ� ���ս�Ű�� ���·� --�߰�(÷��)
-- JOIN�� �̷�� ����.

--�ܿ� ���� ������...
SELECT *
FROM TBL_EMP E, TBL_DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO(+)
-- �̷� ������ JOIN�� �������� �ʴ´�.
--�� �������� ������ �Ǵ� ���̺��� �������� �ʴ´�.


--2. SQL 1999 CODE -> JOIN Ű���� ���� -> ��JOIN��(����)�� ���� ����ϵ��� ���������� ����� ����
                                    ---> ��ON�� Ű������ ���� -> ���� ������ WHERE ��� ON

--CROSS JOIN
SELECT *
FROM EMP CROSS JOIN DEPT;

--EQUI JOIN NON EQUI JOIN �� ��������.

--���
--INNER JOIN
SELECT *
FROM EMP INNER JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO;

SELECT *
FROM EMP E INNER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;
--���� ���� ���

SELECT *
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;
--INNER JOIN ���� INNER�� ��������

--OUTER JOIN
SELECT *
FROM TBL_EMP E LEFT OUTER JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO;   -- + ��� ������ ������ LEFT OUTER JOIN

SELECT *
FROM TBL_EMP E RIGHT OUTER JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO; -- + ��� ������ �������� RIGHT OUTER JOIN

SELECT *
FROM TBL_EMP E FULL OUTER JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO;   --������ �μ��� ����� ��� ������ �ȴ�.

--OUTER �� ���� �����ϴ�. �� ������ �پ������� OUTER ������ INNER JOIN�̴�.

---------------------------------------------------------------------
SELECT *
FROM TBL_EMP E JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO
AND E.JOB = 'CLERK'; --�̷��� WHERE ��� ON�� �� �ǹ̰� ����...


SELECT *
FROM TBL_EMP E JOIN TBL_DEPT D
ON E.DEPTNO = D.DEPTNO
WHERE E.JOB = 'CLERK';
--��ó�� ���⸦ �����ϴµ� �̴� ON = �������� WHERE = ��������
--���� ���� ���� �Ѵ��� �� �� �ְ� ����°�
---------------------------------------------------------------------

--��EMP ���̺�� DEPT ���̺��� �������
-- ������ MANAGER�� CLERK�� ����鸸
-- �μ���ȣ, �μ���, �����, ������, �޿� �׸��� ��ȸ�Ѵ�.

SELECT DEPT.DEPTNO "�μ���ȣ" , DEPT.DNAME "�μ���", EMP.ENAME "�����", EMP.JOB "������", EMP.SAL "�޿�"
FROM EMP LEFT JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO
WHERE JOB IN ('MANAGER','CLERK')
ORDER BY 4;
--���� �߻�
--ORA-00918: column ambiguously defined
--�� ���̺� �� �ߺ��Ǵ� �÷��� ����
-- �Ҽ� ���̺��� �������(��������)�Ѵ�.

--�ߺ��Ǵ� �÷����� �� �ϳ�(ex, 20, 30, 40, 10)�� DEPTNO �� �θ����̺��̵ǰ�
--�� �����͵鿡 DEPTNO�� ��(20,30)�� �������� ����ִ� EMP�� �ڽ����̺��� �ȴ�.
--�� �̋��� �θ��� �÷��� DEPT.DEPTNO�� ���� �����;��Ѵ�.

--�� ���̺� ��� ���ԵǾ� �ִ� �ߺ��� �ø��� �ƴϴ���
--�÷��� �Ҽ� ���̺��� ����� �� �� �ֵ��� �����Ѵ�. ����Ŭ�� ���� ���ϱ� ����


----------------------------------------------------------------------------
--��SELF JOIN (�ڱ�����)
--EMP ���̺��� �����͸� ������ ���� ��ȸ�� �� �ֵ��� �������� �����Ѵ�.
----------------------------------------------------------------------------
-- �����ȣ  �����    ������ �����ڹ�ȣ   �����ڸ�    ������������
----------------------------------------------------------------------------
SELECT *
FROM EMP;

SELECT E.EMPNO "�����ȣ" , E.ENAME "�����"  , E.JOB "������"
        ,E.MGR "�����ڹ�ȣ" , M.ENAME "������ ��" , M.JOB "������ ������"
FROM EMP E JOIN EMP M
ON E.MGR = M.EMPNO;

SELECT E.EMPNO "�����ȣ" , E.ENAME "�����"  , E.JOB "������"
        ,E.MGR "�����ڹ�ȣ" , M.ENAME "������ ��" , M.JOB "������ ������"
FROM EMP E LEFT JOIN EMP M  --King �� ������ �ϱ�
ON E.MGR = M.EMPNO;


SELECT E.EMPNO "�����ȣ" , E.ENAME "�����"  , E.JOB "������"
        ,E.MGR "�����ڹ�ȣ" , M.ENAME "������ ��" , M.JOB "������ ������"
FROM EMP E , EMP M  --King �� ������ �ϱ�
WHERE E.MGR = M.EMPNO(+);
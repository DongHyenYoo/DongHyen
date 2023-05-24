SELECT DEPTNO "�μ���ȣ", SUM(SAL) "�޿���"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);

/*
10	8750
20	10875
30	9400
	8700
	37725   --���μ� �������� �޿���
*/

SELECT NVL(TO_CHAR(DEPTNO),'���μ�' )"�μ���ȣ", SUM(SAL) "�޿���"
FROM EMP
GROUP BY ROLLUP(DEPTNO);

SELECT NVL2(DEPTNO, TO_CHAR(DEPTNO),'���μ�')"�μ���ȣ",SUM(SAL)"�޿���"
FROM EMP
GROUP BY ROLLUP(DEPTNO);

/*
10	8750
20	10875
30	9400
���μ�	29025

*/

SELECT NVL2(DEPTNO, TO_CHAR(DEPTNO),'���μ�')"�μ���ȣ",SUM(SAL)"�޿���"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);
/*
10	8750
20	10875
30	9400
���μ�	8700
���μ�	37725
*/

--GROUPING()
SELECT GROUPING(DEPTNO) "GROUPING", DEPTNO "�μ���ȣ", SUM(SAL) "�޿���"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);
/*
GROUPING  �μ���ȣ  �޿���
0	        10      	8750
0	        20      	10875
0	        30      	9400
0		   (null)   8700
1	       (null) 	37725
*/

--GROUPING ��ȯ���� 1�� ���� ROLLUP�� ����Ȱ�

SELECT DEPTNO "�μ���ȣ", SUM(SAL) "�޿���"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);
/*
10	8750
20	10875
30	9400
	8700
	37725
*/

--�� ������
/*
10	8750
20	10875
30	9400
����	8700
���μ�	37725
*/
--�̿� ���� ��ȸ�ǵ��� ������ ����
--��Ʈ

SELECT CASE GROUPING(DEPTNO) 0 THEN '���Ϻμ�' ELSE '���μ�' END  DEPTNO "�μ���ȣ", SUM(SAL) "�޿���"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);

SELECT CASE GROUPING(DEPTNO) WHEN 0 THEN TO_CHAR(DEPTNO)  
            ELSE '���μ�'
        END "�μ�"
            ,SUM(SAL) "�޿���"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);

/*
10	8750
20	10875
30	9400
(null)	8700
���μ�	37725
*/


SELECT CASE GROUPING(DEPTNO) WHEN 0 THEN NVL(TO_CHAR(DEPTNO),'����')  
            ELSE '���μ�'
        END "�μ�"
            ,SUM(SAL) "�޿���"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO);


--��TBL_SAWON ���̺��� �������
--������ ���� ��ȸ�� ���ֵ��� ������ �ۼ�
/*
----------------------------
����           �޿���
-----------------------------
��             xxxx
��             xxxxx
�����        xxxx
*/


SELECT *
FROM TBL_SAWON;

SELECT  CASE GROUPING(T.��) WHEN 0 THEN T.��
        ELSE '�����'
        END "����"
        ,SUM(T.�޿�) "�޿���"
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','3') THEN '��'
            WHEN SUBSTR(JUBUN,7,1) IN ('2','4') THEN '��'
            ELSE '����Ȯ�ξȵ�'
        END "��"
        ,SAL "�޿�"
FROM TBL_SAWON
)T
GROUP BY (T.��);
/*
��	31800
��	11000
*/



SELECT  NVL(T.����,'�����') 
        ,SUM(T.�޿�) "�޿���"
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','3') THEN '��'
            WHEN SUBSTR(JUBUN,7,1) IN ('2','4') THEN '��'
            ELSE '����Ȯ�ξȵ�'
        END "����"
        ,SAL "�޿�"
FROM TBL_SAWON
)T
GROUP BY ROLLUP(T.����);

/*
��	31800
��	11000
*/

SELECT  NVL(T.����,'�����') 
        ,SUM(T.�޿�) "�޿���"
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','3') THEN '��'
            WHEN SUBSTR(JUBUN,7,1) IN ('2','4') THEN '��'
            ELSE '����Ȯ�ξȵ�'
        END "����"
        ,SAL "�޿�"
FROM TBL_SAWON
)T
GROUP BY ROLLUP(T.����);

SELECT  CASE GROUPING(T.��) WHEN 0 THEN T.��
        ELSE '�����'
        END "����"
        ,SUM(T.�޿�) "�޿���"
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','3') THEN '��'
            WHEN SUBSTR(JUBUN,7,1) IN ('2','4') THEN '��'
            ELSE '����Ȯ�ξȵ�'
        END "��"
        ,SAL "�޿�"
FROM TBL_SAWON
)T
GROUP BY ROLLUP(T.��);
/*
��	11000
��	31800
�����	42800
*/

--��TBL_SAWON ���̺��� �������
--������ ���� ��ȸ�� ���ֵ��� ������ �ۼ�
/*
----------------------------
���ɴ�           �ο���
-----------------------------
10               x
20             x
30              x
50              x
��ü             16
*/

SELECT *
FROM TBL_SAWON;


SELECT NVL(T2.���̴�,'��ü') "���ɴ�"  --CASE GROUPING(T.���̴�) WHEN 0 TO_CHAR(T.���̴�) ELSE '��ü' END
       ,COUNT(*) "�ο�"
FROM(
SELECT CASE WHEN T1.����>=50 THEN '50'
            WHEN T1.����>=30 THEN '30'
            WHEN T1.����>=20 THEN '20'
            WHEN T1.����>=10 THEN '10'
            ELSE 'Ȯ���ʿ�'
        END "���̴�"
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','2') THEN TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - (TO_NUMBER(SUBSTR(JUBUN,1,2)) + 1899)
            ELSE TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - (TO_NUMBER(SUBSTR(JUBUN,1,2)) + 1999)
            END "����"
FROM TBL_SAWON
)T1
)T2
GROUP BY ROLLUP(���̴�);




------------------VIEW ���

CREATE OR REPLACE VIEW VIEW_SAWONTEMP
AS
SELECT CASE WHEN T.����>=50 THEN '50'
            WHEN T.����>=30 THEN '30'
            WHEN T.����>=20 THEN '20'
            WHEN T.����>=10 THEN '10'
            ELSE 'Ȯ���ʿ�'
        END "���̴�"
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','2') THEN TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - (TO_NUMBER(SUBSTR(JUBUN,1,2)) + 1899)
            ELSE TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - (TO_NUMBER(SUBSTR(JUBUN,1,2)) + 1999)
            END "����"
FROM TBL_SAWON
)T;


SELECT NVL(���̴�,'��ü') "���̴�", COUNT(���̴�)
FROM VIEW_SAWONTEMP
GROUP BY ROLLUP(���̴�);

DROP VIEW VIEW_SAWONTEMP;

--��� 2. ->INLINE VIEW�� �ѹ��� ���
---------------------TRUNC()
SELECT NVL(TO_CHAR(T1.����),'��ü') ,COUNT(*)
FROM(
SELECT TRUNC(CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','2') THEN EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(JUBUN,1,2))+1899)
            WHEN SUBSTR(JUBUN,7,1) IN ('3','4') THEN EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(JUBUN,1,2))+1999)
            ELSE -1
            END,-1) "����"
FROM TBL_SAWON
)T1  --T1
GROUP BY ROLLUP(T1.����);



----------------���̴� ���̱� GROUPING(������) GROUP BY ROLLUP(������) �̶�°� �������.
SELECT CASE GROUPING(T1.����) WHEN 0 THEN T1.����||'��'
            ELSE '��ü' END "���̴�" ,COUNT(*)
FROM(
SELECT CASE WHEN SUBSTR(JUBUN,7,1) IN ('1','2') THEN TRUNC(EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(JUBUN,1,2))+1899),-1)
            WHEN SUBSTR(JUBUN,7,1) IN ('3','4') THEN TRUNC(EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(JUBUN,1,2))+1999),-1)
            ELSE -1
            END "����"
FROM TBL_SAWON
)T1  --T1
GROUP BY ROLLUP(T1.����);



--ROLLUP�� �ϳ��� ������ �ִ� �ְ� �ƴϴ�.

SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY 1,2;

/*
10	CLERK	1300
10	MANAGER	2450
10	PRESIDENT	5000
20	ANALYST	6000
20	CLERK	1900
20	MANAGER	2975
30	CLERK	950
30	MANAGER	2850
30	SALESMAN	5600
*/




SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY 1,2;
/*
10	    CLERK	    1300   --10�� �μ� CLERK ������ �޿���
10	    MANAGER	    2450   --10�� �μ� MANAGER ������ �޿���
10	    PRESIDENT	5000   --10�� �μ� PRESIDENT ������ �޿���
10	    (null)	    8750   --10�� �μ� ��� ������ �޿���
20	    ANALYST     	6000
20	    CLERK	    1900
20	    MANAGER 	2975
20	    (null)	    10875  --20�� �μ� ��� ������ �޿���
30	    CLERK	    950
30	    MANAGER	    2850
30	    SALESMAN    	5600
30	    (null)  	9400   --30�� �μ� ��� ������ �޿���
(null)	(null)  	29025  --��� �μ� ��� ������ �޿���
*/

--��CUBE() -> ROLLUP()���� �� �ڼ��� ����� ��ȯ�޴´�.

SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY 1,2;

/*
10	    CLERK	    1300
10	    MANAGER	    2450
10	    PRESIDENT	5000
10	    (null)  	8750
20	    ANALYST 	    6000
20	    CLERK	    1900
20	    MANAGER	    2975
20	    (null)  	10875
30	    CLERK   	950
30	    MANAGER	    2850
30	    SALESMAN	    5600
30	    (null)  	9400
(null)	ANALYST	    6000 --��� �μ� ANALYST ������ �޿���  --�߰�
(null)	CLERK	    4150 --��� �μ� CLERK ������ �޿���    --�߰�
(null)	MANAGER	    8275 --��� �μ� MANAGER ������ �޿���  --�߰�
(null)	PRESIDENT	5000 --��� �μ� PRESIDENT ������ �޿��� --�߰�
(null)	SALESMAN	    5600 --��� �μ� SALESMAN ������ �޿���  --�߰�
(null)	(null)  	29025
*/

--��ROLLUP() �� CUBE() ��
-- �׷��� �����ִ� ����� �ٸ���. (����)

--ex.

--ROLLUP(A,B,C)
---> (A,B,C) / (A,B) / (A) / ()

-- CUBE(A,B,C)
-- -> (A,B,C) / (A,B) / (A,C) / (B,C) / (A) / (B) / (C) / ()

--==>>���� ������(ROLLUP()) ���� ����� �ټ� ���ڶ� ���� �ְ�
--    �Ʒ� ������(CUBE()) ���� ����� �ټ� ����ĥ ���� �ֱ� ������
--      ������ ���� ����� ������ �� ���� ����ϰ� �ȴ�.
--      ���� �ۼ��ϴ� ������ ��ȸ�ϰ��� �ϴ� �׷츸
--      GROUPING SETS �� �̿��Ͽ� �����ִ� ����̴�.

SELECT CASE GROUPING(DEPTNO) WHEN 0 THEN NVL(TO_CHAR(DEPTNO),'����')
       ELSE '��ü�μ�'
    END "�μ���ȣ"
       , CASE GROUPING(JOB) WHEN 0 THEN JOB
          ELSE '��ü����'
        END "����"
        , SUM(SAL) "�޿���"
FROM TBL_EMP
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY 1, 2;
/*
10	    CLERK	    1300
10	    MANAGER 	2450
10	    PRESIDENT	5000
10	    ��ü����    	8750
20	    ANALYST	    6000
20	    CLERK	    1900
20	    MANAGER 	2975
20	    ��ü����    	10875
30      	CLERK	    950
30	    MANAGER 	2850
30	    SALESMAN	    5600
30	    ��ü����    	9400
����  	CLERK	    3500
����	    SALESMAN	    5200
����	    ��ü����	    8700
��ü�μ�	��ü����	    37725
*/

SELECT CASE GROUPING(DEPTNO) WHEN 0 THEN NVL(TO_CHAR(DEPTNO),'����')
       ELSE '��ü�μ�'
    END "�μ���ȣ"
       , CASE GROUPING(JOB) WHEN 0 THEN JOB
          ELSE '��ü����'
        END "����"
        , SUM(SAL) "�޿���"
FROM TBL_EMP
GROUP BY CUBE(DEPTNO, JOB)
ORDER BY 1, 2;
/*
10	    CLERK	    1300
10	    MANAGER	    2450
10	    PRESIDENT	5000
10	    ��ü����	    8750
20	    ANALYST     	6000
20	    CLERK	    1900
20	    MANAGER	    2975
20	    ��ü����	    10875
30	    CLERK	    950
30   	MANAGER 	2850
30	    SALESMAN    	5600
30	    ��ü����    	9400
����	    CLERK	    3500
����	    SALESMAN	    5200
����	    ��ü����	    8700

��ü�μ�	ANALYST	    6000
��ü�μ�	CLERK	    7650
��ü�μ�	MANAGER	    8275
��ü�μ�	PRESIDENT	5000
��ü�μ�	SALESMAN	    10800

��ü�μ�	��ü����	    37725
*/

SELECT CASE GROUPING(DEPTNO) WHEN 0 THEN NVL(TO_CHAR(DEPTNO),'����')
       ELSE '��ü�μ�'
    END "�μ���ȣ"
       , CASE GROUPING(JOB) WHEN 0 THEN JOB
          ELSE '��ü����'
        END "����"
        , SUM(SAL) "�޿���"
FROM TBL_EMP
GROUP BY GROUPING SETS((DEPTNO, JOB), (DEPTNO),())
ORDER BY 1, 2;
--ROLLUP�� ����� ����� ���� ��ȸ ��� ��ȯ
/*
10	CLERK	1300
10	MANAGER	2450
10	PRESIDENT	5000
10	��ü����	8750
20	ANALYST	6000
20	CLERK	1900
20	MANAGER	2975
20	��ü����	10875
30	CLERK	950
30	MANAGER	2850
30	SALESMAN	5600
30	��ü����	9400
����	CLERK	3500
����	SALESMAN	5200
����	��ü����	8700
��ü�μ�	��ü����	37725
*/

--ȯ�漳�� -> �����ͺ��̽� -> NLS -> ��¥���� �ٲٱ� ����


--��TBL_EMP ���̺��� ������� �Ի�⵵�� �ο����� ��ȸ�Ѵ�.

SELECT *
FROM TBL_EMP;

SELECT EXTRACT(YEAR FROM HIREDATE) "�Ի�⵵"
    , COUNT(*) "�ο���"
FROM TBL_EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE)
ORDER BY 1;
--==>>
/*
1980   1
1981   10
1982   1
1987   2
2022   5
*/
SELECT EXTRACT(YEAR FROM HIREDATE) "�Ի�⵵"
    , COUNT(*) "�ο���"
FROM TBL_EMP
GROUP BY ROLLUP(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;


SELECT TO_CHAR(HIREDATE, 'YYYY') "�Ի�⵵"
       ,COUNT(*) "�ο���"
FROM TBL_EMP
GROUP BY ROLLUP(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;
--ORA-00979: not a GROUP BY expression

SELECT EXTRACT(YEAR FROM HIREDATE) "�Ի�⵵"
       ,COUNT(*) "�ο���"
FROM TBL_EMP
GROUP BY ROLLUP(TO_CHAR(HIREDATE,'YYYY'))
ORDER BY 1;
--ORA-00979: not a GROUP BY expression

SELECT TO_CHAR(HIREDATE, 'YYYY') "�Ի�⵵"
       ,COUNT(*) "�ο���"
FROM TBL_EMP
GROUP BY ROLLUP(TO_CHAR(HIREDATE,'YYYY'));
--�����
--ROLLUP���� TO_CHAR �� �������� TO_CHAR�� SELECT
--EXTRACT �� �������� EXTRACT �� SELECT
/*
1980	1
1981	10
1982	1
1987	2
2022	5
	19
*/
SELECT CASE GROUPING(EXTRACT(YEAR FROM HIREDATE)) WHEN 0
            THEN EXTRACT(YEAR FROM HIREDATE)
            ELSE '��ü'
        END "�Ի�⵵"
        , COUNT(*) "�ο���"
FROM TBL_EMP
GROUP BY CUBE(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;
--ORA-00932: inconsistent datatypes: expected NUMBER got CHAR
--CASE ���� EXTRACT�� �����ε� ELSE �� ���ڶ� ����


SELECT CASE GROUPING(TO_CHAR(HIREDATE,'YYYY')) WHEN 0
            THEN EXTRACT(YEAR FROM HIREDATE)
            ELSE '��ü'
        END "�Ի�⵵"
        , COUNT(*) "�ο���"
FROM TBL_EMP
GROUP BY CUBE(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;
--ORA-00932: inconsistent datatypes: expected NUMBER got CHAR
-- GROUPING(TO_CHAR(HIREDATE,'YYYY')) WHEN 0
--   ������ ����         THEN EXTRACT(YEAR FROM HIREDATE)
--     ����       ELSE '��ü'
--�̱⶧���� �����߻�

SELECT CASE GROUPING(TO_CHAR(HIREDATE,'YYYY')) WHEN 0
            THEN TO_CHAR(HIREDATE,'YYYY')
            ELSE '��ü'
        END "�Ի�⵵"
        , COUNT(*) "�ο���"
FROM TBL_EMP
GROUP BY CUBE(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;
--ORA-00979: not a GROUP BY expression 
--������ �޶�����.
--GROUP BY�� �������� ���ڷ� ���� GROUPING������ TO_CHAR�� �������� ����.


SELECT CASE GROUPING(EXTRACT(YEAR FROM HIREDATE)) WHEN 0
            THEN TO_CHAR(HIREDATE,'YYYY')
            ELSE '��ü'
        END "�Ի�⵵"
        , COUNT(*) "�ο���"
FROM TBL_EMP
GROUP BY CUBE(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;
--ORA-00979: not a GROUP BY expression

SELECT CASE GROUPING(TO_CHAR(HIREDATE,'YYYY')) WHEN 0
            THEN TO_CHAR(HIREDATE,'YYYY')
            ELSE '��ü'
        END "�Ի�⵵"
        , COUNT(*) "�ο���"
FROM TBL_EMP
GROUP BY CUBE(TO_CHAR(HIREDATE,'YYYY'))
ORDER BY 1;

--Ȥ��

SELECT CASE GROUPING(EXTRACT(YEAR FROM HIREDATE)) WHEN 0
            THEN EXTRACT(YEAR FROM HIREDATE)
            ELSE -1
        END "�Ի�⵵"
        , COUNT(*) "�ο���"
FROM TBL_EMP
GROUP BY CUBE(EXTRACT(YEAR FROM HIREDATE))
ORDER BY 1;

/*
-1	19
1980	1
1981	10
1982	1
1987	2
2022	5
*/
--���ڸ� ���ڷ� ���߰�  ���ڸ� ���ڷ� ���߱�
--������ �ۼ��Ҷ� ����


-------------------------------------------------------------------



--���� HAVING ����------

--��EMP ���̺��� �μ���ȣ�� 20,30�� �μ��� �������
--  �μ��� �� �޿��� 10000���� ���� ��츸 �μ��� �� �޿��� ��ȸ�Ѵ�.

SELECT *
FROM EMP;

SELECT DEPTNO "�μ���ȣ"
        , SUM(SAL) "�μ� �� �޿�"
FROM EMP
WHERE DEPTNO IN (20,30)
   AND SUM(SAL) <10000   --ORA-00934: group function is not allowed here �׷��Լ��� SUM�� ���⼭ ���� ����.
GROUP BY DEPTNO;


SELECT DEPTNO "�μ���ȣ"
        , SUM(SAL) "�μ� �� �޿�"
FROM EMP
WHERE DEPTNO IN (20,30)
GROUP BY DEPTNO
HAVING SUM(SAL) < 10000;
--30	    9400
--���� ���� 


SELECT DEPTNO "�μ���ȣ"
        , SUM(SAL) "�μ� �� �޿�"
FROM EMP
GROUP BY DEPTNO
HAVING SUM(SAL) < 10000
       AND DEPTNO IN (20,30);
       
--30	 9400 �Ǳ� ������
--AND DEPTNO IN (20,30) �� ������ WHERE�� �ִ°� �ٶ����ϴ� �ֳĸ�
--FROM ���� ���̺��� ��ȸ�ϰ� WHERE ���� �����ϴ� �͸� �޸𸮿� �ۿø��⶧��
--����Ŭ ���忡���� EMP ���̺��� �ϴ� �÷��� �� �ȿ��� ������ ���� VS  EMP���̺��� �ʿ��� �޸𸮸� �÷��� �����͸� �����ϱ�
--�̷��� 

--���� ��ø �׷��Լ� / �м��Լ� ����------

--�׷� �Լ��� 2 LEVEL ���� ��ø�ؼ� ����� �� �ִ�.
-- MSSQL�� �̸����� �Ұ����ϴ�.

SELECT SUM(SAL)
FROM EMP
GROUP BY DEPTNO;
--9400
--10875
--8750


SELECT MAX(SUM(SAL))
FROM EMP
GROUP BY DEPTNO;
--10875

--RANK() / DENSE_RANK()
--> ORACLE 9i���� ������Լ�...MSSQL 2005���� ����� �Լ��̴�.

--->���� ���������� RANK() �� DENSE_RANK()�� ����� �� ���� ������
--  ���� ���.. �޿������� ���ϰ��� �Ѵٸ�
-- �ش� ����� �޿����� �� ū ���� �� ������ Ȯ���� ��
-- Ȯ���� ���ڿ� +1 �� �߰� �������ָ�...
-- �� ���� �� �ش� ����� ����� �ȴ�.\


SELECT ENAME, SAL
FROM EMP;

SELECT COUNT(*)+1
FROM EMP
WHERE SAL > 800;    --SMITH�� �޿�
--==>      14         --SMITH�� �޿� ���

SELECT COUNT(*)+1
FROM EMP
WHERE SAL > 1600;   --ALLEN�� �޿�
--==>   7            --ALLEN�� �޿� ���

--�ؼ��� ��� ����(��� ���� ����)
-- ���� ������ �ִ� ���̺��� �÷���
--  ���� ������ ������(WHERE��, HAVING��)�� ���Ǵ� ���
-- �츮�� �� �������� ���� ��� ����(��� ���� ����) ��� �θ���.

SELECT ENAME "�����" , SAL "�޿�" , 1 "�޿����"
FROM EMP;

SELECT ENAME "�����" , SAL "�޿�" , (SELECT COUNT(*)+1
                                    FROM EMP
                                    WHERE SAL > 800) "�޿����"
FROM EMP;

SELECT ENAME "�����" , E.SAL "�޿�" , (SELECT COUNT(*)+1
                                    FROM EMP
                                    WHERE SAL > E.SAL) "�޿����"
FROM EMP E
ORDER BY 3;
/*
KING	5000    	1
FORD	3000    	2
SCOTT	3000    	2
JONES	2975    	4
BLAKE	2850	    5
CLARK	2450	    6
ALLEN	1600    	7
TURNER	1500	    8
MILLER	1300    	9
WARD	1250    	10
MARTIN	1250	    10
ADAMS	1100	    12
JAMES	950	    13
SMITH	800	    14
*/

--EMP ���̺��� �������
-- �����, �޿�, �μ���ȣ, �μ��� �޿����, ��ü�޿� ��� �׸��� ��ȸ�Ѵ�.
-- �� ���� ��� ������ Ȱ���� �� �ֵ��� �Ѵ�.
SELECT E.ENAME "�����" , E.SAL"�޿�", E.DEPTNO"�μ���ȣ"
    ,   (1) "�μ��� �޿����"      
    ,   (1)"��ü�޿����"
FROM EMP E  
ORDER BY 5;


SELECT E.ENAME "�����" , E.SAL"�޿�", E.DEPTNO"�μ���ȣ"
    ,   (SELECT COUNT(*) + 1
        FROM EMP
        WHERE SAL > 800 AND DEPTNO = 20) "�μ��� �޿����"      
    ,   (SELECT COUNT(*) + 1
            FROM EMP
            WHERE SAL > 800)"��ü�޿����"
FROM EMP E  
ORDER BY 5;
--==> ���� SMITH�� ����


SELECT ENAME "�����", E.SAL "�޿�", DEPTNO
       ,(SELECT COUNT(*)+1  FROM EMP  WHERE SAL > E.SAL) "��ü�޿����"
       ,(SELECT COUNT(*)+1  FROM EMP WHERE SAL > E.SAL AND DEPTNO = E.DEPTNO) "�μ��� �޿����"
FROM EMP E
ORDER BY 3,5;


--��EMP ���̺��� ������� ������ ���� ��ȸ�� �� �ֵ��� �������� �����Ѵ�.
/*
                                  -�� �μ������� �Ի����ں��� ������ �޿��� �� 
---------------------------------------------------------------
�����   �μ���ȣ   �Ի���    �޿�  �μ����Ի纰�޿�����  
-------------------------------------------------------------
SMITH   20          1980-12-17 800         800 
JONES    20        1981-04-02   2975       3775
FORD    20         1981-12-03  3000        6775
                                           :
*/

SELECT *
FROM EMP;


SELECT SUM(SAL)
FROM EMP
WHERE HIREDATE <= TO_DATE('1981-02-22','YYYY-MM-DD');


SELECT E.HIREDATE "�Ի���",(SELECT SUM(SAL) FROM EMP WHERE DEPTNO = E. DEPTNO AND HIREDATE <= E.HIREDATE) "�μ��� �Ի纰 ����"
FROM EMP E;


SELECT  ENAME "�����", DEPTNO "�μ���ȣ", HIREDATE "�Ի���", SAL "�޿�", (SELECT SUM(SAL) FROM EMP WHERE DEPTNO = E. DEPTNO AND HIREDATE <= E.HIREDATE) "�μ��� �Ի纰 ����"
FROM EMP E;


SELECT  E1.ENAME "�����", E1.DEPTNO "�μ���ȣ", E1.HIREDATE "�Ի���", E1.SAL "�޿�", ( SELECT SUM(E2.SAL) FROM EMP E2 WHERE E2.DEPTNO = E1.DEPTNO) "�μ��� �Ի纰����"
FROM SCOTT.EMP E1
ORDER BY 2, 3;

SELECT  E1.ENAME "�����", E1.DEPTNO "�μ���ȣ", E1.HIREDATE "�Ի���", E1.SAL "�޿�", ( SELECT SUM(E2.SAL) FROM EMP E2 WHERE E2.DEPTNO = E1.DEPTNO AND E2.HIREDATE <= E1.HIREDATE) "�μ��� �Ի纰����"
FROM SCOTT.EMP E1
ORDER BY 2, 3;

--EMP ���̺��� �������
-- �Ի��� ����� ���� ���� ������ ����
-- �Ի����� �ο����� ��ȸ�� �� �ֵ��� �������� �����Ѵ�.

SELECT *
FROM EMP;


SELECT TO_CHAR(HIREDATE,'YYYY-MM') "�Ի���", COUNT(*) "�Ի����"
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY-MM')
HAVING COUNT(*)=(SELECT MAX(COUNT(*)) FROM EMP GROUP BY TO_CHAR(HIREDATE,'YYYY-MM'));

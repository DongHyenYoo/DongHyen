SELECT USER
FROM DUAL;


--��EMPLOYEES ���̺��� ������ SALARY�� 10%�λ��ض�
--  �� �μ����� 'IT'�� ������ ����.
-- (���濡 ���� ��� Ȯ�� �� ROLLBACK ����)

SELECT E.DEPARTMENT_ID
FROM EMPLOYEES E JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE D.DEPARTMENT_NAME LIKE '%IT%';


UPDATE EMPLOYEES
SET SALARY = SALARY * 1.1
WHERE DEPARTMENT_ID IN (SELECT E.DEPARTMENT_ID
FROM EMPLOYEES E JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE D.DEPARTMENT_NAME LIKE 'IT%');

UPDATE EMPLOYEES
SET SALARY = SALARY * 1.1
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
FROM DEPARTMENTS D
WHERE DEPARTMENT_NAME LIKE 'IT%');


SELECT *
FROM EMPLOYEES;

ROLLBACK;

--��EMPLOYEES ���̺��� JOB_TITLE�� Sales Manager�� �������
-- SALARY�� �ش� ����(����)�� �ְ�޿�(MAX_SALARY)�� �����Ѵ�.
--�� �Ի����� 2006�� ����(�ش�⵵ ����) �Ի��ڿ� ���� ����
--���� ��� Ȯ���� ROLLBACK����

SELECT *
FROM EMPLOYEES;
SELECT *
FROM JOBS;


--2006�� ���� �Ի��� + SALES MANAGER��å�� ��� IDã��
SELECT E.EMPLOYEE_ID
FROM JOBS J JOIN EMPLOYEES E
ON J.JOB_ID = E.JOB_ID
WHERE TO_CHAR(E.HIRE_DATE,'YYYY') <2006
       AND J.JOB_TITLE='Sales Manager'
       

--MAX SALARY�ϳ��� ����
SELECT J.MAX_SALARY
FROM JOBS J JOIN EMPLOYEES E
ON J.JOB_ID = E.JOB_ID
WHERE TO_CHAR(E.HIRE_DATE,'YYYY') <2006
       AND J.JOB_TITLE='Sales Manager'
GROUP BY MAX_SALARY;




--2006���� �Ի��ڷ� ����
SELECT TO_CHAR(E.HIRE_DATE,'YYYY')
FROM JOBS J JOIN EMPLOYEES E
ON J.JOB_ID = E.JOB_ID
WHERE J.JOB_TITLE='Sales Manager'
GROUP BY (TO_CHAR(E.HIRE_DATE,'YYYY'))
HAVING TO_NUMBER(TO_CHAR(E.HIRE_DATE,'YYYY'))<2006;


-- ������Ʈ

UPDATE EMPLOYEES
SET SALARY = (SELECT J.MAX_SALARY
FROM JOBS J JOIN EMPLOYEES E
ON J.JOB_ID = E.JOB_ID
WHERE TO_NUMBER(TO_CHAR(E.HIRE_DATE,'YYYY')) <2006
       AND J.JOB_TITLE='Sales Manager'
GROUP BY MAX_SALARY)

WHERE EMPLOYEE_ID IN (SELECT E.EMPLOYEE_ID
FROM JOBS J JOIN EMPLOYEES E
ON J.JOB_ID = E.JOB_ID
WHERE TO_CHAR(E.HIRE_DATE,'YYYY') <2006
       AND J.JOB_TITLE='Sales Manager');

ROLLBACK;


--��EMPLOYEES ���̺��� SALARY��
-- �� �μ��� �̸����� �ٸ� �λ���� �����Ͽ� ���� �� �� �ֵ��� �Ѵ�.
--Finance -> 10%�λ�
--Excutive -> 15%�λ�
--Accounting -> 20%�λ�


SELECT DEPARTMENT_ID
FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'Finance';

--
UPDATE EMPLOYEES
SET SALARY = CASE DEPARTMENT_ID WHEN (SELECT DEPARTMENT_ID
                                    FROM DEPARTMENTS
                                    WHERE DEPARTMENT_NAME = 'Finance') 
                                    THEN SALARY*1.1
                             WHEN (SELECT DEPARTMENT_ID
                                    FROM DEPARTMENTS
                                    WHERE DEPARTMENT_NAME = 'Accounting') 
                                    THEN SALARY*1.2
                            WHEN (SELECT DEPARTMENT_ID
                                    FROM DEPARTMENTS
                                    WHERE DEPARTMENT_NAME = 'Excutive')  
                                    THEN SALARY*1.15
                            ELSE SALARY
                            END;
                            
                            

UPDATE EMPLOYEES
SET SALARY = CASE DEPARTMENT_ID WHEN (SELECT DEPARTMENT_ID
                                    FROM DEPARTMENTS
                                    WHERE DEPARTMENT_NAME = 'Finance') 
                                    THEN SALARY*1.1
                             WHEN (SELECT DEPARTMENT_ID
                                    FROM DEPARTMENTS
                                    WHERE DEPARTMENT_NAME = 'Accounting') 
                                    THEN SALARY*1.2
                            WHEN (SELECT DEPARTMENT_ID
                                    FROM DEPARTMENTS
                                    WHERE DEPARTMENT_NAME = 'Excutive')  
                                    THEN SALARY*1.15
                            ELSE SALARY
                            END
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
                        FROM DEPARTMENTS
                        WHERE DEPARTMENT_NAME IN('Finance','Executive','Accounting'));
                           

SELECT *
FROM DEPARTMENTS;

ROLLBACK;



---------------------------------------------------------------------------------
---���� DELETE ����------

--1.���̺��� ������ ��(���ڵ�)�� �����ϴ� �� ����ϴ� ����

--2.���� �� ����
--DELETE [FROM] ���̺��
-- [WHERE ������];


--���̺� ����(������ ����)
CREATE TABLE TBL_EMPLOYEES
AS
SELECT *
FROM EMPLOYEES;

SELECT *
FROM TBL_EMPLOYEES
WHERE EMPLOYEE_ID = 198;


DELETE 
FROM TBL_EMPLOYEES
WHERE EMPLOYEE_ID = 198;

ROLLBACK;


--�� EMPLOYEES ���̺��� �������� �����͸� �����Ѵ�.
-- ��, �μ����� 'IT'�� ���� �����Ѵ�.

--�ؽ����δ� EMPLOYEES ���̺��� �����Ͱ�(�����ϰ��� �ϴ� ��� ������)
-- �ٸ� ���ڵ忡 ���� �������ϰ� �ִ� ���
-- �������� ���� �� �ִٴ� ����� �����ؾ� �ϸ�...
-- �׿� ���� ������ �˾ƾ� �Ѵ�.

SELECT *
FROM TBL_EMPLOYEES;

SELECT *
FROM DEPARTMENTS;

SELECT DEPARTMENT_ID
FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'IT';

DELETE 
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                        FROM DEPARTMENTS
                        WHERE DEPARTMENT_NAME = 'IT');

ROLLBACK;

--==>EMPLOYEES �� �ϸ� �����߻�
--ORA-02292: integrity constraint (HR.DEPT_MGR_FK) violated - child record found


---------------------------------------------------------------------------


--���� ��(VIEW) ����----


--1.��(VIEW)�� �̹� Ư���� �����ͺ��̽� ���� �����ϴ�
--  �ϳ� �̻��� ���̺��� ����ڰ� ��� ���ϴ� �����͵鸸��
--  ��Ȯ�ϰ� ���ϰ� �������� ���Ͽ� ������ ���ϴ� �÷��鸸�� ��Ƽ�
--  �������� ������ ���̺�� ���Ǽ� �� ���ȿ� ������ �ִ�.

--���̺� ������ �����ִ� ����� ���Ȼ� ������ ���������Ƿ�
--view�� ����ϸ� ����ڿ��� �����ų ���ڵ常 ���ؼ� �����ټ��ִ�.
--�� �ǹ����� ������ �������� VIEW�� ���� ���ȴ�.
--�� ���̺�ó�� ���� �����Ͱ� ���ִ°��� �ƴ� ���̺��� ������ 
--�����͵��� �����ִ� ������ �ϻ��� �� �����Ű�� ���� ���̺��� ����Ǵ°�
--����.

--  ������ ���̺��̶�... �䰡 ������ �����ϴ� ���̺�(��ü)�� �ƴ϶�
--  �ϳ� �̻��� ���̺��� �Ļ��� �� �ٸ� ������ �� �� �ִ� ����̸�
--  �� ������ �����س��� SQL �����̶�� �� �� �ִ�.

--2. ���� �� ����
--CREATE [OR REPLACE] VIEW ���̸�
-- [(ALIAS[, ALIAS,...])]
--AS
--��������(SUBQUERY)
--[WITH CHECK OPTION]
--[WITH READ ONLY]


--�ۺ�(VIEW)����
CREATE OR REPLACE VIEW VIEW_EMPLOYEES
AS
SELECT E.FIRST_NAME, E.LAST_NAME, D.DEPARTMENT_NAME, L.CITY
       , C.COUNTRY_NAME, R.REGION_NAME
FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L, COUNTRIES C, REGIONS R
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
    AND D.LOCATION_ID = L.LOCATION_ID
    AND L.COUNTRY_ID = C.COUNTRY_ID
    AND C.REGION_ID = R.REGION_ID;

--==>>View VIEW_EMPLOYEES��(��) �����Ǿ����ϴ�.


--�ۺ�(VIEW)��ȸ
SELECT *
FROM VIEW_EMPLOYEES;

--�� �������� ������ ���̺������� ��(VIEW)�� ������ Ȯ�ΰ���
DESC VIEW_EMPLOYEES;
/*
�̸�              ��?       ����           
--------------- -------- ------------ 
FIRST_NAME               VARCHAR2(20) 
LAST_NAME       NOT NULL VARCHAR2(25) 
DEPARTMENT_NAME NOT NULL VARCHAR2(30) 
CITY            NOT NULL VARCHAR2(30) 
COUNTRY_NAME             VARCHAR2(40) 
REGION_NAME              VARCHAR2(25) 
*/

--�ۺ�(VIEW) �ҽ�Ȯ�� -- CHECK!

SELECT VIEW_NAME, TEXT
FROM USER_VIEWS
WHERE VIEW_NAME = 'VIEW_EMPLOYEES';

/*
"SELECT E.FIRST_NAME, E.LAST_NAME, D.DEPARTMENT_NAME, L.CITY
       , C.COUNTRY_NAME, R.REGION_NAME
FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L, COUNTRIES C, REGIONS R
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
    AND D.LOCATION_ID = L.LOCATION_ID
    AND L.COUNTRY_ID = C.COUNTRY_ID
    AND C.REGION_ID = R.REGION_ID"
*/
--�並 �����Ҷ� ���� �������� �״�� ���´�.
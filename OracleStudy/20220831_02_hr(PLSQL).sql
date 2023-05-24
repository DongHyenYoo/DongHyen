SELECT USER
FROM DUAL;

SET SERVEROUTPUT ON;

--�� %TYPE

--1.Ư�� ���̺� ���ԵǾ� �ִ� �÷��� �ڷ���(������Ÿ��)�� �����ϴ� ������Ÿ��

--2. ���� �� ����
--������ ���̺��.�÷���%TYPE [:= �ʱⰪ];

--�� HR.EMPLOYEES ���̺��� Ư�������͸� ������ ����

SELECT *
FROM EMPLOYEES;

--�̸�(FIRST_NAME) �÷� Ȯ��

DECLARE
    V_NAME VARCHAR2(20);
BEGIN
    SELECT FIRST_NAME INTO V_NAME
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID=103;
    
    DBMS_OUTPUT.PUT_LINE(V_NAME);
END;

DECLARE
    --V_NAME VARCHAR2(20);
    V_NAME EMPLOYEES.FIRST_NAME%TYPE; --�ڵ����� �´� �ڷ����� ������ �ְ��� 
BEGIN
    SELECT FIRST_NAME INTO V_NAME
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID=103;
    
    DBMS_OUTPUT.PUT_LINE(V_NAME);
END;

--��EMPLOYEES ���̺��� ������� 108�� ���(Nancy)��
-- SALARY�� ������ ��� ����ϴ� PL/SQL ������ �ۼ��Ѵ�.

DECLARE
    EMP_SALARY EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT SALARY INTO EMP_SALARY
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 108;
    
    DBMS_OUTPUT.PUT_LINE(EMP_SALARY);
    
END;

--��EMPLOYEES ���̺��� Ư�� ���ڵ� �׸� �������� ������ ����
-- 103�� ����� FIRST_NAME, PHONE_NUMBER, EMAIL �׸��� ������ �����Ͽ� ���

DECLARE
    EMP_FNAME EMPLOYEES.FIRST_NAME%TYPE;
    EMP_PHONE EMPLOYEES.PHONE_NUMBER%TYPE;
    EMP_EMAIL EMPLOYEES.EMAIL%TYPE;
BEGIN
    SELECT FIRST_NAME , PHONE_NUMBER , EMAIL
            INTO EMP_FNAME, EMP_PHONE, EMP_EMAIL
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 103;
    
    DBMS_OUTPUT.PUT_LINE(EMP_FNAME || ',  ' || EMP_PHONE || ',   ' || EMP_EMAIL);
END;



--�� %ROWTYPE

--1.���̺��� ���ڵ�� ���� ������ ����ü ������ ����(���� ���� �÷�)

--2.���� �� ����
--������ ���̺��%ROWTYPE;

DECLARE
    V_EMP   EMPLOYEES%ROWTYPE; --�� ���� ������ ��� ����Ÿ���� ������.
BEGIN
    SELECT FIRST_NAME, PHONE_NUMBER, EMAIL 
            INTO V_EMP.FIRST_NAME, V_EMP.PHONE_NUMBER, V_EMP.EMAIL
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = 103;
    
    DBMS_OUTPUT.PUT_LINE(V_EMP.FIRST_NAME || ', ' || V_EMP.PHONE_NUMBER ||', '|| V_EMP.EMAIL);
END;
--==>>

--��EMPLOYEES ���̺��� ��ü ���ڵ� �׸� �������� ������ ����
-- ��� ����� FIRST_NAME, PHONE_NUMBER, EMAIL �׸��� ������ �����Ͽ� ���

DECLARE
    EMPNUM NUMBER;
    --NUM NUMBER;
    NUM EMPLOYEES.EMPLOYEE_ID%TYPE;
BEGIN
    SELECT COUNT(*) INTO EMPNUM
    FROM EMPLOYEES;
    
    FOR NUM IN 100..(99+EMPNUM) LOOP --FOR ����
    
    DECLARE --���� D-B-E ����
    EMP EMPLOYEES%ROWTYPE; 
    BEGIN
    SELECT FIRST_NAME , PHONE_NUMBER, EMAIL
    INTO EMP.FIRST_NAME, EMP.PHONE_NUMBER, EMP.EMAIL
    FROM EMPLOYEES
    WHERE EMPLOYEE_ID = NUM;
    
    DBMS_OUTPUT.PUT_LINE(EMP.FIRST_NAME ||',   ' || EMP.PHONE_NUMBER|| ',     ' || EMP.EMAIL);
    END; --���� D-B-E ��
    END LOOP; --FOR�� ��
        
END;

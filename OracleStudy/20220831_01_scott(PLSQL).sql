SELECT USER
FROM DUAL;

SET SERVEROUTPUT ON; --ù ���ӽ� ������ ����

--�ۺ����� ������ ���� �����ϰ� ����ϰ� ���� �ۼ�
DECLARE
    GRADE CHAR;
    
BEGIN
    GRADE := 'A';
    
    IF GRADE = 'A'
        THEN DBMS_OUTPUT.PUT_LINE('EXCELLENT');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('FAIL');
    END IF;
END;

--EXCELLENT


DECLARE
    GRADE CHAR;
BEGIN
    GRADE := 'B';
    
    IF GRADE = 'A'
        THEN DBMS_OUTPUT.PUT_LINE('EXCELLENT');
    ELSIF GRADE = 'B'
        THEN DBMS_OUTPUT.PUT_LINE('GOOD');
    ELSE
        DBMS_OUTPUT.PUT_LINE('FAIL');
    END IF;
END;

--GOOD

--�� CASE ��(���ǹ�)
-- CASE ~ WHEN ~ THEN ~ ELSE ~ END CASE;
--���� CASE�� ����� ������ END CASE�� ������.

--1.���� �� ����

/*
CASE ����
    WHEN ��1 THEN ���๮1;
    WHEN ��2 THEN ���๮2;
    ELSE ���๮N+1;
END CASE;
*/

--����1 ����2 �Է��ϼ���
--1
--�����Դϴ�.


--����1 ����2 �Է��ϼ���
--2
--�����Դϴ�.

--�Է��϶�� �ȳ� �ڹٿ��� BR.READLINE���� ���� PRINT ��������

ACCEPT NUM PROMPT '����1 ����2 �Է��ϼ���';

DECLARE
    --����� ���ֿ� ���� ����
    SEL NUMBER := &NUM; --���� ����1 ����2 ���� �Է¹��� NUM���� ������������ ��������
    RESULT VARCHAR2(10) := '����';
    
BEGIN
    --�׽�Ʈ
    --DBMS_OUTPUT.PUT_LINE('SEL : ' || SEL);
    --DBMS_OUTPUT.PUT_LINE('RESULT : ' || RESULT);
    
    /*
    CASE SEL
        WHEN 1
        THEN DBMS_OUTPUT.PUT_LINE('�����Դϴ�.');
        WHEN 2
        THEN DBMS_OUTPUT.PUT_LINE('�����Դϴ�.');
        ELSE 
        DBMS_OUTPUT.PUT_LINE('Ȯ�κҰ�');
    END CASE;
    */
    
    CASE SEL
        WHEN 1
        THEN RESULT := '����';
        WHEN 2
        THEN RESULT := '����';
        ELSE
            RESULT := 'Ȯ�κҰ�';
    END CASE;
    
    --��� ���
    DBMS_OUTPUT.PUT_LINE('ó�� �����' || RESULT || '�Դϴ�.');
END;

--1,2�� ������ ������ ORA-06502: PL/SQL: numeric or value error: character string buffer too small
--�̿� ���� ������ ����������
--���� ������� ����Ŭ�� ĳ���ͼ��� AL32UTF8 �� �ѱ��� 3����Ʈ�� �����ϴ� ĳ���ͼ��̱� ����
--�� ELSE ������ 12����Ʈ RESULT�� �Ҵ�� ����Ʈ�� 10���� ������ ũ�⸦ 2����Ʈ �ʰ��ϱ⿡ �����¿���
--���� ũ�⸦ 12 OR �� �ø��� ������ ������ �ʴ´�.

--�� �ܺ� �Է� ó��
--ACCEPT ����

--ACCEPT ������ PROMPT '�޼���';
--��ܺ� �����κ��� �Է¹��� �����͸� ���� ������ ������ ��
-- ��&�ܺκ����� ���·� �����ϰ� �ȴ�.



--������ �� ���� �ܺηκ���(����ڷκ���)�Է¹޾�
-- �̵��� ��������� ����ϴ� PL/SQL  �� �ۼ�

ACCEPT NUM1 PROMPT 'ù��° ���� �Է�';
ACCEPT NUM2 PROMPT '�ι�° ���� �Է�';

DECLARE
    FIRNUM NUMBER := &NUM1;
    SECNUM NUMBER := &NUM2;
    --TOTAL NUMBER :=0;
BEGIN
    --TOTAL := FIRNUM + SECNUM;
    DBMS_OUTPUT.PUT_LINE('���� �����' || (FIRNUM+SECNUM) ||'�Դϴ�');
    
END;

--�ۻ���ڷκ��� �Է¹��� �ݾ��� ȭ�� ������ �����Ͽ� ����ϴ� ���α׷��� �ۼ��Ѵ�.
--  ��,��ȯ �ݾ��� ���ǻ� 1õ�� �̸�, 10�� �̻� �����ϴٰ� �����Ѵ�.
/*
���� ��)
���ε� ���� �Է� ��ȭâ �� �ݾ� �Է� : 990

�Է¹��� �ݾ� �Ѿ� : 990��
ȭ����� : ����� 1, ��� 4, ���ʿ� 1, �ʿ� 4

*/

ACCEPT M PROMPT '�ݾ��� �Է��� �ּ���';

DECLARE
    MONEY NUMBER := &M;
    OBACK NUMBER;
    BACK NUMBER;
    OSIB NUMBER;
    SIB NUMBER;
    
BEGIN
    
    OBACK := TRUNC(MONEY / 500);
    BACK := TRUNC((MONEY - (OBACK*500))/100);
    OSIB := TRUNC((MONEY - ((OBACK*500)+(BACK*100))) / 50);
    SIB := TRUNC((MONEY - ((OBACK*500)+(BACK*100)+(OSIB*50))) /10);
    
    DBMS_OUTPUT.PUT_LINE('�����' || OBACK || ', ���' || BACK || ', ���ʿ�' || OSIB || ', �ʿ�' || SIB);
END;


ACCEPT M PROMPT '�ݾ��� �Է��� �ּ���';

DECLARE

    --�ֿ� ���� ����
    MONEY NUMBER := &M;
    MONEY2 NUMBER := &M; --����������� MONEY�� �پ��⿡
    
    M500 NUMBER;
    M100 NUMBER;
    M50 NUMBER;
    M10 NUMBER;
    
BEGIN
    --����ó��
    --MONEY �� 500���� ������ ���� ���ϰ� �������� ������. �� 500���� ����
    M500 := TRUNC(MONEY / 500);
        
    --MONEY�� 500���� ������ ���� ������ �������� ���Ѵ�. ��500���� ���� Ȯ���ϰ� ���� �ݾ�
    -- �� ����� �ٽ� MONEY�� ��Ƴ���.
    MONEY := MOD(MONEY,500);
    
    --MONEY�� 100���� ������ ���� ���ϰ� �������� ������.
    M100 := TRUNC(MONEY / 100);
    MONEY := MOD(MONEY,100);
    
    M50 := TRUNC(MONEY / 50);
    MONEY := MOD(MONEY,50);
    
    M10 := TRUNC(MONEY / 10);
    
    DBMS_OUTPUT.PUT_LINE('�Է¹��� �ݾ� : ' || MONEY2);
    DBMS_OUTPUT.PUT_LINE('�����' || M500 || ', ���' || M100 || ', ���ʿ�' || M50 || ', �ʿ�' || M10);
END;


--�۱⺻ �ݺ���
--LOOP ~ END LOOP;

--1.���ǰ� ������� ������ �ݺ��ϴ� ����.

--2.���� �� ����
/*
LOOP
    --���๮
    EXIT WHEN ����; --������ ���� ��� �ݺ����� ����������.
END LOOP;
*/

DECLARE
    NUM NUMBER := 1;
    
BEGIN
    LOOP
    DBMS_OUTPUT.PUT_LINE(NUM);
    NUM := NUM+1;
    EXIT WHEN NUM>=11;
    END LOOP;
END;


--��WHILE �ݺ���
-- WHILE LOOP ~ END LOOP;

--1.���� ������ TRUE�� ���� �Ϸ��� ������ �ݺ��ϱ� ����
-- WHILE LOOP������ ����Ѵ�.
-- ������ �ݺ��� ���۵Ǵ� ������ üũ�ϰ� �Ǿ�
-- LOOP���� ������ �ѹ��� ������� ���� ��쵵 �ִ�.
-- LOOP�� ������ �� ������ FALSE�̸� �ݺ� ���� Ż��

--2.���� �� ����
/*
WHILE ���� LOOP    --������ ���ϰ�� �ݺ� ����
        --���๮;
END LOOP;
*/

--1���� 10������ �� ���(WHILE LOOP �̿�)

DECLARE
    NUM NUMBER ;
BEGIN
    NUM := 0;
    WHILE NUM < 10 LOOP
    NUM := NUM+1;
    DBMS_OUTPUT.PUT_LINE(NUM);
    END LOOP;
    
END;


--��FOR �ݺ���
--FOR LOOP ~ END LOOP;

--1.�����ۼ������� 1�� �����Ͽ�
--  ������������ �� �� ���� �ݺ� �����Ѵ�.

--2.���� �� ����
/*
FOR ī���� IN [REVERSE] ���ۼ� ..������ LOOP
    --���๮
END LOOP;
*/

--��1���� 10������ �� ���(FOR LOOP �� Ȱ��)

DECLARE
    N NUMBER;
BEGIN
    
    FOR N IN 1 .. 10 LOOP
    DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;

--�ۻ���ڷκ��� ������ ��(������)�� �Է¹޾�
-- �ش�ܼ��� �������� ����ϴ� PL/SQL ������ �ۼ��Ѵ�.
/*
���� �Է� : 2

2*1 = 2
.
.
.
2*9 = 18
*/

--LOOP ��

ACCEPT NUM PROMPT '���� �Է��ϼ���';

DECLARE
    DAN NUMBER := &NUM;
    GOB NUMBER := 1;
    RESULT NUMBER := 0;
BEGIN
    
    LOOP
    RESULT := DAN * GOB;
    DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || RESULT);
    EXIT WHEN GOB =9;
    GOB := GOB+1;
    END LOOP;
END;


--WHILE LOOP ��

ACCEPT NUM PROMPT '���� �Է��ϼ���';

DECLARE
    DAN NUMBER := &NUM;
    GOB NUMBER := 1;
   
BEGIN
    WHILE GOB<10 LOOP
    DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || (DAN*GOB));
    GOB := GOB+1;
    END LOOP;
END;


--FOR LOOP��

ACCEPT NUM PROMPT '���� �Է��ϼ���';

DECLARE
    DAN NUMBER := &NUM;
    GOB NUMBER;
   
BEGIN
    FOR GOB IN 1..9 LOOP
    DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || (DAN*GOB));
    END LOOP;
END;


--�۱����� ��ü(2��~9��)�� ����ϴ� PL/SQL���� �ۼ�
-- ���� �ݺ���(�ݺ��� ��ø) ������ Ȱ���Ѵ�.

--FOR�� 

DECLARE
    DAN NUMBER;
    GOB NUMBER;
BEGIN
    FOR DAN IN 2..9 LOOP
        DBMS_OUTPUT.PUT_LINE('====[' || DAN || '��]====');
        FOR GOB IN 1..9 LOOP
        DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
        END LOOP;
    END LOOP;
END;

--WHILE LOOP��

DECLARE
    DAN NUMBER;
    GOB NUMBER;
BEGIN
    DAN := 2;
    
    WHILE DAN<10 LOOP
        DBMS_OUTPUT.PUT_LINE('====[' || DAN || '��]====');
            GOB := 1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
            DBMS_OUTPUT.PUT_LINE(DAN || '*' || GOB || '=' || DAN*GOB);
            GOB := GOB+1;
        DAN := DAN+1;
    END LOOP; --�� ���
END;


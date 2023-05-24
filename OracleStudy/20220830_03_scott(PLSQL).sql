SELECT USER
FROM DUAL;

--==>>SCOTT

--���� PL/SQL ����---

--1.PL/SQL(Procedural Language extenstion to SQL)��
--  ���α׷� ����� Ư���� ������ SQL �� Ȯ���̸�,
-- ������ ���۰� ���� ������ PL/SQL�� ������ �ڵ� �ȿ� ���Եȴ�.
-- ���⿡�� �����������̶�� �ܾ ������ �ǹ̴�
-- � ���� � ������ ���ļ� ��� �Ϸ�Ǵ���
-- �� ����� ��Ȯ�ϰ� �ڵ忡 ����Ѵٴ� ���� �ǹ��Ѵ�.

--2. PL/SQL �� ���������� ǥ���ϱ� ����
--   ������ ������ �� �ִ� ���,
-- ���� ������ ������ �� �ִ� ���,
-- ���� �帧�� ��Ʈ���� �� �ִ� ��� ���� �����Ѵ�.

--3. PL/SQL �� �� ������ �Ǿ� ������
-- ���� ���� �κ�, ���� �κ�, ���� ó�� �κ���
-- �� ��Ʈ�� �����Ǿ� �ִ�.
-- ����, �ݵ�� ���� �κ��� �����ؾ� �ϸ�, ������ ������ ����.

--4. ���� �� ����
/*
[DECLARE]
    --����(DECLARATIONS)
BEGIN
    --���๮(STATEMENTS)
    
    [EXCEPTION]
       --���� ó����(EXCEPTION HANDLERS)
END;
*/

--5.���� ����
DECLARE
    --�����
    --������ �ڷ���; �ڹٴ� �ڷ��� �������̾��µ� ����Ŭ�� �ٸ�
    -- ����Ŭ���� = �� ���Կ����ڰ� �ƴ϶� ���迬���ڿ����Ƿ�
    --������ �ڷ��� = �ʱⰪ�� �ƴ� (x) 
    --������ �ڷ��� := �ʱⰪ�̴�.
    -- := �� <= �� ���ٰ� �����ϸ� �ȴ�.
BEGIN
END;
--������ �̰ɷ� �����Ѵ�.

--�� ��DBMS_OUTPUT.PUT_LINE()�� �� ����
--   ȭ�鿡 ����� ����ϱ� ���� ȯ�溯�� ����
SET SERVEROUTPUT ON;

--�ۺ����� ������ ���� �����ϰ� ����ϴ� ������ �ۼ�
DECLARE
    --�����
    D1 NUMBER := 10;
    D2 VARCHAR2(30) := 'HELLO';
    D3 VARCHAR2(20) := 'Oracle';
BEGIN
    --�����
    --System.out.println(D1);
    DBMS_OUTPUT.PUT_LINE(D1);
    DBMS_OUTPUT.PUT_LINE(D2);
    DBMS_OUTPUT.PUT_LINE(D3);
END;

--���� ��Ƽ� Ctrl+Enter

/*
10
HELLO
Oracle
*/

--�� ������ ������ ���� �����ϰ� ����ϴ� ���� �ۼ�
DECLARE
    --�����
    V1 NUMBER := 10;
    V2 VARCHAR2(30) := 'HELLO';
    V3 VARCHAR2(20) := 'ORACLE';
BEGIN
    --�����
    --(���� �� ó��)
    V1 := V1*10;            --V1 *=10;
    V2 := V2||' ���̰�';     --V2 +='���̰�';
    V3 := V3||' World~!!!';  --V3 +='World~!!!';
    --(��� ���)
    DBMS_OUTPUT.PUT_LINE(V1);
    DBMS_OUTPUT.PUT_LINE(V2);
    DBMS_OUTPUT.PUT_LINE(V3);
END;
/*
100
HELLO ���̰�
ORACLE World~!!!


PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.

*/

--�� IF ��(���ǹ�)
-- IF ~ THEN ~ ELSE ~ END IF;

-- 1.PL/SQL�� IF ������ �ٸ� ����� IF���ǹ��� ���� �����ϴ�
--   ��ġ�ϴ� ���ǿ� ���� ���������� �۾��� ������ �� �ֵ��� �Ѵ�
--   IF ���ǿ��� ó���� ����� TRUE�̸� THEN�� ELSE ������ ������ �����ϰ�
--   FALSE�� NULL�̸� ELSE��  END IF; ������ ������ �����ϰ� �ȴ�

-- 2. ���� �� ����

/* ��ܵ� IF
IF ����
    THEN ó����;
END IF; 
*/

/* ��IF-ELSE
IF ����
    THEN ó����;
ELSE 
    ó����;  ELSE�� THEN�� ����.
END IF; 
IF�� ���۰� ���� �˷��־�� �Ѵ�.
*/

/* ����ø
IF ����
    THEN ó����;
 ELSIF ����    --�ڹ��� ELES IF �� ����. 
     THEN ó����; 
     
  ELSIF ����     
     THEN ó����;
     
   ELSIF ����    
     THEN ó����; 
     
   ELSIF ����   
     THEN ó����; 

    ELSE
        ó����;
END IF; 
IF�� ���۰� ���� �˷��־�� �Ѵ�.
*/

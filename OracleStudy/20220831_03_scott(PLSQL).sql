SET SERVEROUTPUT ON;
--�� TBL_INSA ���̺��� ���� ���� ������ �������� ������ ����
--  (�ݺ��� Ȱ��)
-- �ݺ����� �������� ������ �˾ƾ���
-- �׷��� ��Ŀ������� ���� ���� ���ѻ��� ���� Ȱ�� ����!
DECLARE
        V_INSA  TBL_INSA%ROWTYPE;
        V_NUM   TBL_INSA.NUM%TYPE := 1001;
BEGIN
        LOOP
                --��ȸ
                SELECT NAME, TEL, BUSEO
                        INTO V_INSA.NAME, V_INSA.TEL, V_INSA.BUSEO
                FROM TBL_INSA
                WHERE NUM = V_NUM;
                
                --���
                DBMS_OUTPUT.PUT_LINE(V_INSA.NAME|| ' - ' ||V_INSA.TEL ||' - '||V_INSA.BUSEO);
                
                --������
                V_NUM := V_NUM +1;
                
                EXIT WHEN V_NUM >1060;
        END LOOP;
END;
---------------------------------------------------------------------------------

--���� FUNCTION(�Լ�)����--

--1. �Լ��� �ϳ� �̻��� PL/SQL ������ ������ �����ƾ����
--   �ڵ带 �ٽ� ����� �� �ֵ��� ĸ��ȭ�ϴµ� ���ȴ�.
-- ����Ŭ������ ����Ŭ�� ���ǵ� �⺻ ���� �Լ��� ����ϰų�
-- ���� ������ �Լ��� ���� �� �ִ�. (������ ���� �Լ�)
-- �� ����� ���� �Լ��� �ý��� �Լ�ó�� �������� ȣ���ϰų�
-- ���� ���ν���ó�� EXECUTE ���� ���� ������ �� �ִ�.


--2. ���� �� ����

/*
CREATE [OR REPLACE] FUNCTION �Լ���
[( �Ű�������1 �ڷ���
    �Ű������� 2 �ڷ���
)]
RETURN ������Ÿ��
IS
    --�ֿ� ���� ����
BEGIN
    --���๮;
    ...
    RETURN(��); --�� = RETURN ������Ÿ�� �� ���� Ÿ��
    
    [EXCEPTION]
        --���� ó�� ����;
END;
*/


--�� ����� ���� �Լ�(������ �Լ�)��
--IN �Ķ����(�Է� �Ű�����)�� ����� �� ������
-- �ݵ�� ��ȯ�� ���� ������ Ÿ���� RETURN ���� �����ؾ� �ϰ�,
--FUNCTION�� �ݵ�� ���� ���� ��ȯ�Ѵ�.

--��TBL_INSA ���̺� ���� ���� Ȯ�� �Լ� ����(����)
--�Լ��� : FN_GENDER()
--                 �� SSN(�ֹε�Ϲ�ȣ) �� '771212-1022432' �� 'YYMMDD-NNNNN'


CREATE OR REPLACE FUNCTION FN_GENDER(V_SSN VARCHAR2 ) --�Լ� ���ǽ� �Ű������� �ڸ���(����) ���� ����
RETURN VARCHAR2 --RETURN ��ȯ�ڷ������� ���̸� ������� �ʴ´�.

IS
    --����� �� �ֿ� ���� ����
    V_RESULT VARCHAR2(24);
BEGIN
    -- ����� �� ���� �� ó��
    IF (SUBSTR(V_SSN,8,1) IN ('2','4'))
        THEN V_RESULT := '����';
    ELSIF SUBSTR(V_SSN,8,1) IN ('1','3')
        THEN V_RESULT := '����';
    ELSE
        V_RESULT := '����Ȯ�κҰ�';
    END IF;
    
    --������� ��ȯ�ؾ��Ѵٴ°��� ���
    RETURN V_RESULT;
END;

--Function FN_GENDER��(��) �����ϵǾ����ϴ�.


--�������� ���� �ΰ��� �Ű�����(�Է� �Ķ����)�� �Ѱܹ޾� �� (A,B)
-- A�� B���� ���� ��ȯ�ϴ� ����� ���� �Լ��� �ۼ��Ѵ�.
--�Լ��� : FN_POW()

/*
��� ��)
SELECT FN_POW(10,3)
FROM DUAL;
--==>> 1000
*/

CREATE OR REPLACE FUNCTION FN_POW(NUM1 NUMBER , NUM2 NUMBER) --NUM1: ����� �� NUM2: �¼� 
RETURN NUMBER

IS
    V_RESULT NUMBER := 1;      --V : Variable ������� ��
    V_SEUNG NUMBER;
BEGIN    
    FOR V_SEUNG IN 1..NUM2  LOOP  --�ʱ� RESULT�� NUM1���� �־����Ƿ� NUM2 -1
    V_RESULT := V_RESULT * NUM1;
    END LOOP;
    
    RETURN V_RESULT;
END;

--4�� Scott�� �̵�
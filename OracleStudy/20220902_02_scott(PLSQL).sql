--��TBL_�԰� ���̺� ���԰� �̺�Ʈ�� �߻���
-- ���� ���̺� ����Ǿ�� �ϴ� ����

--��INSERT -> TBL_�԰����̺�

--��UPDATE -> TBL_��ǰ

--��TBL_��ǰ, TBL_�԰� ���̺��� �������
-- TBL_�԰� ���̺� ������ �Է� ��(��, �԰� �̺�Ʈ �߻� ��)
--TBL_�԰� ���̺��� ������ �Է� �� �ƴ϶�
-- TBL_��ǰ ���̺��� ��� ������ �Բ� ������ �� �ִ� ����� ���� ���ν����� �ۼ��Ѵ�.
-- ��, �� �������� �԰��ȣ�� �ڵ� ���� ó���Ѵ�. (������ ��� X)

--TBL_�԰� ���̺� ���� �÷�(����)
-- �԰��ȣ,��ǰ�ڵ�,�԰�����,�԰����,�԰�ܰ�
-- ���ν��� ��: PRC_�԰�_INSERT(��ǰ�ڵ�,�԰����,�԰�ܰ�)

CREATE OR REPLACE PROCEDURE PRC_�԰�_INSERT
( V_��ǰ�ڵ� IN TBL_�԰�.��ǰ�ڵ�%TYPE
, V_�԰���� IN TBL_�԰�.�԰����%TYPE
, V_�԰�ܰ� IN TBL_�԰�.�԰�ܰ�%TYPE
)

IS
  V_�԰��ȣ TBL_�԰�.�԰��ȣ%TYPE;
BEGIN
  
  SELECT NVL(MAX(�԰��ȣ),0)+1 INTO V_�԰��ȣ
  FROM TBL_�԰�;
 --INSERT ������ ����
  INSERT INTO TBL_�԰�(�԰��ȣ,��ǰ�ڵ�,�԰�����,�԰����,�԰�ܰ�)
  VALUES(V_�԰��ȣ, V_��ǰ�ڵ�, SYSDATE, V_�԰����, V_�԰�ܰ�);
  --UPDATE ������ ����
  UPDATE TBL_��ǰ
  SET ������ = ������ + V_�԰����
  WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
  
  
  --���� ó��
  EXCEPTION
    WHEN OTHERS THEN ROLLBACK; --�� �����߿��� ���������� ó������ ���� ��Ȳ�� �߻��Ѵٸ� �ѹ��ض�
    
  --Ŀ��  
  COMMIT;
  
END;


------------------------------------------------------------------------
--�������ν��� �������� ���� ó������----

--1�� ��Ʈ 61��
--��TBL_MEMBER ���̺� �����͸� �Է��ϴ� ���ν����� �ۼ�
--  ��, �� ���ν����� ���� �����͸� �Է��� �ܿ�
--  CITY(����) �׸� '����', '���' ,'����'�� �Է��� �����ϵ��� �����Ѵ�.
-- �� ���� ���� �ٸ� ������ ���ν��� ȣ���� ���� �Է��ϰ��� �ϴ� ���
-- (��, �Է��� �õ��ϴ� ���)
-- ���ܿ� ���� ó���� �Ϸ��� �Ѵ�.
-- ���ν��� �� : PRC_MEMBER_INSERT()

/*
���� ��)
EXEC PRC_MEMBER_INSERT('�ӽÿ�', '010-1111-1111', '����');
--==>> ������ �Է� ��

EXEC PRC_MEMBER_INSERT('�躸��', '010-2222-2222', '�λ�');
������ �Է� X
*/

CREATE OR REPLACE PROCEDURE PRC_MEMBER_INSERT
( V_NAME IN TBL_MEMBER.NAME%TYPE
, V_TEL  IN TBL_MEMBER.TEL%TYPE
, V_CITY IN TBL_MEMBER.CITY%TYPE
)

IS
    --���� ������ ������ ������ ���� �ʿ��� ���� �߰� ����
    V_NUM   TBL_MEMBER.NUM%TYPE;
    
    --���ܵ� �����̱⿡ 
    -- ����� ���� ���ܿ� ���� ���� ����
    USER_DEFINE_ERROR EXCEPTION;

BEGIN
        
    --�� �Է¹��� DATA�� ������ ���ٸ� ���ʿ� �ȹ޾ƾ��Ѵ�.
    --�� ���ν����� ���� �Է� ó���� ���������� ������� ����������
    -- �ƴ����� ���θ� ���� ���� Ȯ���� �� �ֵ��� �ڵ� ����

--    IF (������ ���� ��� ��õ�� �ƴ϶��)
--      THEN ���ܸ� �߻���Ű�ڴ�. --java ������ THROW �� ������
--    END IF;
    
    IF (V_CITY NOT IN ('����', '���', '����'))
        THEN RAISE USER_DEFINE_ERROR;
    END IF;

    --INSERT �������� �����ϱ⿡ �ռ�
    --������ ������ �� ��Ƴ���
    SELECT NVL(MAX(NUM),0) INTO V_NUM
    FROM TBL_MEMBER;
    
    --V_NUM = TBL_MEMBER.MEMBER ó�� �� �� ����.
    
    --������ ���� -> INSERT
    
    INSERT INTO TBL_MEMBER(NUM, NAME, TEL, CITY)
    VALUES((V_NUM+1), V_NAME, V_TEL, V_CITY);
    
    --���� ó�� ����
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001,'����,���,������ �Է��� �����մϴ�.');   --2���������� ����Ŭ�� ������� ��ȣ
                                                    --������Ʈ�� ������ȣ�� ������� �����ؼ� ��ȣ�� ����ؼ� ó���Ѵ�.
            WHEN OTHERS
                THEN ROLLBACK;
END;

--Procedure PRC_�԰�_INSERT��(��) �����ϵǾ����ϴ�.


------------------------------------------------------------------------

--��TBL_��� ���̺� ������ �Է� ��(��, ��� �̺�Ʈ �߻� ��)
-- TBL_��ǰ ���̺��� ��� ������ �����Ǵ� ���ν����� �ۼ��Ѵ�.
-- ��, ����ȣ�� �԰��ȣ�� ���������� �ڵ� ���� ó���Ѵ�.
-- ����, ��� ������ ��� �������� ���� ���..
-- ��� �׼� ó�� ��ü�� ����� �� �ֵ��� ó���Ѵ�.
-- ���ν��� �� : PRC_���_INSERT()

/*EX)
EXEC PRC_���_INSERT('H001', 50, 1000);
*/

CREATE OR REPLACE PROCEDURE PRC_���_INSERT
( V_��ǰ�ڵ� IN TBL_��ǰ.��ǰ�ڵ�%TYPE 
, V_������ IN TBL_���.������%TYPE
, V_���ܰ� IN TBL_���.���ܰ�%TYPE
)

IS  
    V_����ȣ TBL_���.����ȣ%TYPE; --����ȣ
    V_������ TBL_��ǰ.������%TYPE;--��ǰ��� ���� ����
    USER_DEFINE_ERROR EXCEPTION;    -- ����� ���� ����� �� ������ �˷��� ����
BEGIN

    --���������� ���
    
    SELECT ������ INTO V_������ 
    FROM TBL_��ǰ 
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;

    --���>��ǰ��� �ϰ�� ����ó��
    IF (V_������ > V_������)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
    
    --����ȣ ����� ������ ���� �ֱ�
    SELECT NVL(MAX(����ȣ),0)+1 INTO V_����ȣ
    FROM TBL_���;

    --������̺�
    INSERT INTO TBL_���(����ȣ, ��ǰ�ڵ�, �������, ������, ���ܰ�)
    VALUES(V_����ȣ, V_��ǰ�ڵ�, SYSDATE, V_������, V_���ܰ�);
    
    
    --��ǰ���̺� ������Ʈ
    UPDATE TBL_��ǰ
    SET ������ = ������-V_������
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    
    --����ó��
    EXCEPTION
    WHEN USER_DEFINE_ERROR
        THEN RAISE_APPLICATION_ERROR(-20002, '����� ���� ����Ҽ��� �����ϴ�.');
             ROLLBACK; --�̷��Ե� �ᵵ�ȴ�.
        WHEN OTHERS
            THEN ROLLBACK;
        
END;



--�� TBL_��� ���̺��� ��� ������ ����(����)�ϴ� ���ν����� �ۼ��Ѵ�.
-- ���ν��� ��: PRC_���_UPDATE()
/*
EXEC PRC_���_UPDATE(����ȣ, �����Ҽ���);
*/

CREATE OR REPLACE PROCEDURE PRC_���_UPDATE
( V_����ȣ TBL_���.����ȣ%TYPE
, V_������ TBL_���.������%TYPE  --��.�Ű����� ����
)

IS
    --��.�ʿ��� ���� �߰� ����
    USER_DEFINE_ERROR EXCEPTION;
    USER_DEFINE_ERROR1 EXCEPTION;
    V_��ǰ�ڵ� TBL_��ǰ.��ǰ�ڵ�%TYPE;
    V_��������� TBL_���.������%TYPE;
    V_��������� TBL_��ǰ.������%TYPE;
    
BEGIN
    
    
  --��.������ ������ �� ���
  
   --����ȣ�� ��ǰ��ȣ, ������� ã��
   SELECT ��ǰ�ڵ�, ������ INTO V_��ǰ�ڵ�,V_���������
   FROM TBL_���
   WHERE ����ȣ = V_����ȣ;
   
   --������ ���
   
   SELECT ������ INTO V_���������
   FROM TBL_��ǰ
   WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
   

   -- ��.��� ���� ���࿩�� �Ǵ�
   -- ���� ������ ������ �� ������ ������ Ȯ��
   IF (V_������ > V_��������� + V_���������)
        THEN RAISE USER_DEFINE_ERROR;
   END IF;
   
    
    -- ��. ����� ������ update    
    --UPDATE ���
    UPDATE TBL_���
    SET ������ = V_������
    WHERE ����ȣ = V_����ȣ;
    
    --��
     --UPDATE ��ǰ
    UPDATE TBL_��ǰ
    SET ������ = (������ + V_���������) - V_������
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    
    
    --����ó��
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '��� ����');
                ROLLBACK;
    COMMIT;
    
END;

/*
    
    --UPDATE ��ǰ
    UPDATE  (SELECT S.��ǰ�ڵ�, S.������, C.����ȣ, C.������ 
            FROM TBL_��ǰ S JOIN TBL_��� C
            ON S.��ǰ�ڵ� = C.��ǰ�ڵ�) T
    SET T.������ = T.������ + (T.������ - V_������)
    WHERE T.����ȣ =  V_����ȣ;
    
*/

--����
/*
1.PRC_�԰�_UPDATE(�԰��ȣ, �԰����) --�԰��ȣ ���Ŀ� ���Ȱ͵��� �� ����ؾ��Ѵ�.(������)
2.PRC_�԰�_DELETE(�԰��ȣ)  --�԰��ȣ�� �԰������ ������ ��ŭ ��ǰ���� ����
3.PRC_���_DELETE(����ȣ) --delete�ȸ�ŭ ��ǰ�� ����
*/
--3.
CREATE OR REPLACE PROCEDURE PRC_���_DELETE
(V_����ȣ IN TBL_���.����ȣ%TYPE
)

IS
    --�ʿ亯�� 1.���ŵ� ������
          --   2.���� ��ǰ���
          --  3.���ŵ� ����ǰ�� �ڵ�
    V_������ TBL_���.������%TYPE; 
    V_������� TBL_��ǰ.������%TYPE;
    V_��ǰ�ڵ� TBL_���.��ǰ�ڵ�%TYPE;
BEGIN
    
    --�ؾ��Ұ�
    --1.������ ������ ���� ���������
    
    SELECT ������, ��ǰ�ڵ� INTO V_������, V_��ǰ�ڵ� 
    FROM TBL_���
    WHERE ����ȣ = V_����ȣ;
    --2.DELETE
    DELETE
    FROM TBL_���
    WHERE ����ȣ = V_����ȣ;
    
    --3.UPDATE TBL_��ǰ ���� ������+���
    UPDATE TBL_��ǰ
    SET ������ = ������+V_������
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    COMMIT;
    
END;


--2.PRC_�԰�_DELETE(�԰��ȣ)  --�԰��ȣ�� �԰������ ������ ��ŭ ��ǰ���� ����

CREATE OR REPLACE PROCEDURE PRC_�԰�_DELETE
(V_�԰��ȣ IN TBL_�԰�.�԰��ȣ%TYPE
)

IS
    --�ʿ亯��
    --1.������������ �԰����
    --2.� ��ǰ���� �˱����� ��ǰ�ڵ�
    V_��ǰ�ڵ� TBL_�԰�.��ǰ�ڵ�%TYPE;
    V_�԰���� TBL_�԰�.�԰����%TYPE;
    V_������ TBL_��ǰ.������%TYPE;
    V_������ TBL_���.������%TYPE;
    USER_DEFINE_ERROR EXCEPTION;
BEGIN
    --�ؾ��� ����
    
    
    
    
    --1.���������� �԰���� ������ ����
    SELECT �԰����, ��ǰ�ڵ� INTO V_�԰����, V_��ǰ�ڵ�
    FROM TBL_�԰�
    WHERE �԰��ȣ = V_�԰��ȣ;
    
    --2.������
    SELECT ������ INTO V_������
    FROM TBL_��ǰ
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    --3.���������� �����Ϸ��� �԰������ ������
    IF (V_������ < V_�԰����)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
   
    
    --4.�԰� ������ ����
    DELETE
    FROM TBL_�԰�
    WHERE �԰��ȣ = V_�԰��ȣ;
    --5.��ǰ���� �԰������ŭ ����
    UPDATE TBL_��ǰ
    SET ������ = ������ - V_�԰���� 
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    --6����ó��
    EXCEPTION
        WHEN USER_DEFINE_ERROR
        THEN RAISE_APPLICATION_ERROR(-20002,'������ ������ ��� �����ϴ�.');
            ROLLBACK;
        WHEN OTHERS
            ROLLBACK;
            
     COMMIT;       
             
END;


--1.PRC_�԰�_UPDATE(�԰��ȣ, �԰����) --�԰��ȣ ���Ŀ� ���Ȱ͵��� �� ����ؾ��Ѵ�.(������)

CREATE OR REPLACE PROCEDURE PRC_�԰�_UPDATE
( V_�԰��ȣ IN TBL_�԰�.�԰��ȣ%TYPE
, V_�԰���� IN TBL_�԰�.�԰����%TYPE
)

IS
    --�����ؾ��� ������
    V_�����԰���� TBL_�԰�.�԰����%TYPE;
    V_��ǰ�ڵ� TBL_�԰�.��ǰ�ڵ�%TYPE;
    V_������ TBL_��ǰ.������%TYPE;
    
    --����� ���� ���ܺ���
    USER_DEFINE_ERROR EXCEPTION;
BEGIN

    --������ �� ���
    SELECT ��ǰ�ڵ�, �԰���� INTO V_��ǰ�ڵ�, V_�����԰����
    FROM TBL_�԰�
    WHERE �԰��ȣ = V_�԰��ȣ;
    
    SELECT ������ INTO V_������
    FROM TBL_��ǰ
    WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
    
    --�����ؾ��� ������
    --1. ��� = ��� - ���� �԰� + V_�԰���� <0 �� �ȵȴ�. ��� -�ϼ��� ����
        --�ʿ亯�� : ���� ���
        --           ���� ����ľ��� ���� ��ǰ�ڵ�
        --          ��������� ���ܺ���
        
        IF (V_������ - V_�����԰���� + V_�԰���� <0)
            THEN RAISE USER_DEFINE_ERROR;
        END IF;
        
    --2.UPDATE �԰� �԰���� = V_�԰����
        
        UPDATE TBL_�԰�
        SET �԰���� = V_�԰����
        WHERE �԰��ȣ = V_�԰��ȣ;
        
    --3.UPDATE ��ǰ ���� ���ŭ ���� ���������ŭ �����ֱ� 
        --�ʿ亯�� : ���� ��� 
        
        UPDATE TBL_��ǰ
        SET ������ = ������ - V_�����԰���� + V_�԰����
        WHERE ��ǰ�ڵ� = V_��ǰ�ڵ�;
        
    --����ó��
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '����� ��� -�Դϴ�');
                 ROLLBACK;
        WHEN OTHERS
            ROLLBACK;
        
        COMMIT;
END;




/*
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
*/




--���� CURSOR(Ŀ��) ����--

-- 1. ����Ŭ������ �ϳ��� ���ڵ尡 �ƴ� ���� ���ڵ�� ������
--    �۾� �������� SQL ���� �����ϰ� �� �������� �߻��� �����͸�
--    �����ϱ� ���� Ŀ��(CURSOR)�� ����ϸ�,
--    Ŀ������ �Ͻ����� Ŀ���� ������� Ŀ���� �ִ�

-- 2. �Ͻ��� Ŀ���� ��� SQL ���� �����ϸ�
--    SQL �� ���� �� ���� �ϳ��� ��(ROW)�� ����ϰ� �ȴ�
--    �׷��� SQL ���� ������ �����(RESULT SET)��
--    ���� ��(ROW)���� ������ ���
--    Ŀ��(CURSOR)�� ��������� �����ؾ� ���� ��(ROW)�� �ٷ� �� �ִ�


--��Ŀ�� �̿� �� ��Ȳ(���� �� ���� ��)
DECLARE
    V_NAME  TBL_INSA.NAME%TYPE;
    V_TEL   TBL_INSA.TBL%TYPE;
BEGIN
    SELECT NAME, TEL INTO V_NAME, V_TEL
    FROM TBL_INSA
    WHERE NUM = 1001;
    
    

END;

--�� Ŀ�� �̿� �� ��Ȳ(���� �� ���� �� - �ݺ��� Ȱ��)
DECLARE
    V_NAME  TBL_INSA.NAME%TYPE;
    V_TEL   TBL_INSA.TEL%TYPE;
    V_NUM   TBL_INSA.NUM%TYPE := 1001;
BEGIN
    LOOP
        SELECT NAME, TEL INTO V_NAME, V_TEL
        FROM TBL_INSA
        WHERE NUM = V_NUM;
        
        DBMS_OUTPUT.PUT_LINE(V_NAME || ' -- ' || V_TEL);
        V_NUM := V_NUM + 1;
        
        EXIT WHEN V_NUM >= 1062;
    END LOOP;   
END;
--==>> 
/*
ȫ�浿 -- 011-2356-4528
�̼��� -- 010-4758-6532
�̼��� -- 010-4231-1236
������ -- 019-5236-4221
�Ѽ��� -- 018-5211-3542
�̱��� -- 010-3214-5357
����ö -- 011-2345-2525
�迵�� -- 016-2222-4444
������ -- 019-1111-2222
������ -- 011-3214-5555
������ -- 010-8888-4422
���ѱ� -- 018-2222-4242
���̼� -- 019-6666-4444
Ȳ���� -- 010-3214-5467
������ -- 016-2548-3365
�̻��� -- 010-4526-1234
����� -- 010-3254-2542
�̼��� -- 018-1333-3333
�ڹ��� -- 017-4747-4848
������ -- 011-9595-8585
ȫ�泲 -- 011-9999-7575
�̿��� -- 017-5214-5282
���μ� -- 
�踻�� -- 011-5248-7789
����� -- 010-4563-2587
����� -- 010-2112-5225
�迵�� -- 019-8523-1478
�̳��� -- 016-1818-4848
�踻�� -- 016-3535-3636
������ -- 019-6564-6752
����ȯ -- 019-5552-7511
�ɽ��� -- 016-8888-7474
��̳� -- 011-2444-4444
������ -- 011-3697-7412
������ -- 
���翵 -- 011-9999-9999
�ּ��� -- 011-7777-7777
���μ� -- 010-6542-7412
����� -- 010-2587-7895
�ڼ��� -- 016-4444-7777
����� -- 016-4444-5555
ä���� -- 011-5125-5511
��̿� -- 016-8548-6547
����ȯ -- 011-5555-7548
ȫ���� -- 011-7777-7777
���� -- 017-3333-3333
�긶�� -- 018-0505-0505
�̱�� -- 
�̹̼� -- 010-6654-8854
�̹��� -- 011-8585-5252
�ǿ��� -- 011-5555-7548
�ǿ��� -- 010-3644-5577
��̽� -- 011-7585-7474
����ȣ -- 016-1919-4242
���ѳ� -- 016-2424-4242
������ -- 010-7549-8654
�̹̰� -- 016-6542-7546
����� -- 010-2415-5444
�Ӽ��� -- 011-4151-4154
��ž� -- 011-4151-4444
������ -- 010-7202-6306
*/


/*
���̺� ������ ���Ǳ�����
����� ������ ���Ǳ�����

�Լ�����
���ν��� ����

CREATE TABLE ���̺��
CREATE INDEX �ε�����
USER ������
FUNCTION �Լ���
PROCEDURE ���ν�����

�̸� + Ÿ���̴�
*/

SET SERVEROUTPUT ON;

--��Ŀ�� �̿� �� ��Ȳ
DECLARE
    --�����
    --�ֿ� ����_����
    V_NAME TBL_INSA.NAME%TYPE;
    V_TEL TBL_INSA.TEL%TYPE;
    
    --Ŀ�� �̿��� ���� Ŀ�� ���� ����(->Ŀ������)
    --cur_insa_select cursor = ����
    --CURSOR CUR_INSA_SELECT = ����
    
    CURSOR CUR_INSA_SELECT
   IS
    SELECT NAME,TEL
    FROM TBL_INSA;
    --���� Ŀ������ name,tel�� ������ ��ü ���� ����Ǿ��ִ�.
    
    BEGIN
    
    --Ŀ�� ����
    OPEN CUR_INSA_SELECT;
    
    --Ŀ�� ���� �� ����� ������ �����͵� ó��
    LOOP
        --�� �� �� �� �޾ƴٰ� ó���ϴ� ����)1  ->��FETCH�� ���� ���Դ� ����
        FETCH CUR_INSA_SELECT INTO V_NAME, V_TEL;
        
        -- )1~)2�� �ݺ��ϴٰ� Ŀ������ �� �̻� �����Ͱ� ����� ������ �ʴ� ����
               --�� �ȴٸ� �׸�! �ϰ� �ݺ����� ����������.
          
          EXIT WHEN CUR_INSA_SELECT%NOTFOUND;  --Ŀ���� ���������� NOTFOUND���¶��  
            
        --���)2
        DBMS_OUTPUT.PUT_LINE(V_NAME || ' -- ' || V_TEL);
        
        
    END LOOP;
    
    CLOSE CUR_INSA_SELECT;
    
END; 
---------------------------------------------------------------------
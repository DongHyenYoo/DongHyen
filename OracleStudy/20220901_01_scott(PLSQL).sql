--��TBL_INSA ���̺��� �޿� ��� ���� �Լ��� �����Ѵ�.
--  �޿��� ��(�⺻��*12)+���硻 ������� ������ �����Ѵ�.
-- �Լ��� : FN_PAY(�⺻��, ����)

CREATE OR REPLACE FUNCTION FN_PAY( BASICPAY NUMBER, SUDANG NUMBER)
RETURN NUMBER

IS  
    V_RESULT NUMBER;
BEGIN
    V_RESULT := (NVL((BASICPAY*12),0)+NVL(SUDANG,0);
    RETURN V_RESULT;
END;

SELECT NAME "�̸�", FN_PAY(BASICPAY, SUDANG) "�⺻��+����"
FROM TBL_INSA;



--TBL_INSA ���̺��� �Ի����� ��������
-- ��������� �ٹ������ ��ȯ�ϴ� �Լ��� �����Ѵ�.
-- ��, �ٹ������ �Ҽ��� ���� ���ڸ� ���� ���
-- �Լ���: FN_WORKYEAR(�Ի���)



SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION FN_WORKYEAR(HIREDATE DATE)
RETURN VARCHAR2

IS
    V_RESULT VARCHAR2(20);
BEGIN
    V_RESULT := TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE)/12)
                || '��' || TRUNC(MOD(MONTHS_BETWEEN(SYSDATE,HIREDATE),12));
    RETURN V_RESULT;
END;

SELECT NAME "�̸�", FN_WORKYEAR(IBSADATE) "�ٹ����"
FROM TBL_INSA;

----------------------------------------------------------------------

--������

--1.INSERT , UPDATE, DELETE , (MERGE)
--==>> DML(Data Manipulation Language) �����͸� �����ϴ� ���
-- COMMIT / ROLLBACK�� �ʿ��ϴ�.

--2. CREATE, DROP, ALTER, (TRUNCATE) --���������� �ٲٴ°�
--==>> DDL(Data Definition Language)
--����� �ڵ����� COMMIT�ȴ�.


--3.GRANT, REVOKE
--==>>DCL(Data Control Language)
-- �����ϸ� �ڵ����� COMMIT�ȴ�.


--4.COMMIT , ROLLBACK
--==>> TCL(Transaction Control Language)


-------------------------------------------------------

--����PROCEDURE(���ν���) ����----

--1. PL/SQL ���� ���� ��ǥ���� ������ ������ ���ν�����
--   �����ڰ� ���� �ۼ��ؾ� �ϴ� ������ �帧����
--   �̸� �ۼ��Ͽ� �����ͺ��̽� ���� ������ �ξ��ٰ�
--   �ʿ��� �� ���� ȣ���Ͽ� ������ �� �ֵ��� ó���� �ִ� �����̴�.

--2. ���� �� ����
/*
CREATE [OR RELACE] PROCEDURE ���ν�����
[(�Ű����� IN ������Ÿ��
  , �Ű����� OUT ������Ÿ��
  , �Ű����� INOUT ������Ÿ��
)]
IS
  [--�ֿ� ���� ����]
BEGIN
   -- ���� ����;
   ...
   [EXCEPTION]
     --���� ó�� ����;
END;
*/

--�� FUNCTION �� ������ ��
--   ��RETURN ��ȯ�ڷ������κ��� �������� ������,
--   ��RETURN�� �� ��ü�� �������� ������,
-- ���ν��� ���� �� �Ѱ��ְ� �Ǵ� �Ű�������
-- IN,OUT,INOUT ���� ���еȴ�.


--3.����(ȣ��)
/*
EXEC[UTE] ���ν�����[(�μ�1,�μ�2,..)];
*/

--���ν��� ���� �ǽ� ������ ����
--20220901_02_scott.sql ���Ͽ� ���̺� ���� �� ������ �Է� ����

--�����ν��� ����
-- ���ν��� �� : PRC_STUDENTS_INSERT(���̵�,�н�����,�̸�,��ȭ,�ּ�)

CREATE OR REPLACE PROCEDURE PRC_STUDENTS_INSERT
( V_ID  IN TBL_IDPW.ID%TYPE
, V_PW  IN TBL_IDPW.PW%TYPE
, V_NAME IN TBL_STUDENTS.NAME%TYPE
, V_TEL IN TBL_STUDENTS.TEL%TYPE
, V_ADDR IN TBL_STUDENTS.ADDR%TYPE
)
IS
BEGIN
    INSERT INTO TBL_IDPW(ID,PW)
    VALUES(V_ID,V_PW);
    
    INSERT INTO TBL_STUDENTS(ID,NAME,TEL,ADDR)
    VALUES(V_ID, V_NAME, V_TEL, V_ADDR);
    
    COMMIT;
END;

--==>>Procedure PRC_STUDENTS_INSERT��(��) �����ϵǾ����ϴ�


--��TBL_SUNGJUK ���̺� ������ �Է� ��
-- Ư�� �׸��� �����͸� �Է��ϸ�
-- -----------------
-- (�й� �̸� ���� ���� ��������)
--���������� ����, ���, ��� �׸� ���� ó���� �Բ� �̷���� �� �ֵ��� �ϴ�
-- ���ν����� �ۼ��Ѵ�.
-- ���ν����� : PRC_SUNGJUK_INSERT()

/*���� ��)
EXEC PRC_SUNGJUK_INSERT(1, '���ҿ�', 90,80,70);

->���ν��� ȣ��� ó���� ���
�й� �̸� ��������  ��������  ��������  ����  ���  ���
1    ���ҿ�  90      80        70      240   80    B
*/

CREATE OR REPLACE PROCEDURE PRC_SUNGJUK_INSERT
( V_HAKBUN IN TBL_SUNGJUK.HAKBUN%TYPE
, V_NAME IN TBL_SUNGJUK.NAME%TYPE
, V_KOR IN TBL_SUNGJUK.KOR%TYPE
, V_ENG IN TBL_SUNGJUK.ENG%TYPE
, V_MAT IN TBL_SUNGJUK.MATN%TYPE
)
IS
   V_AVG TBL_SUNGJUK.AVG%TYPE;
   V_TOT TBL_SUNGJUK.TOT%TYPE;
   V_GRADE TBL_SUNGJUK.GRADE%TYPE;
BEGIN
   V_TOT := V_KOR + V_MAT + V_ENG;
   V_AVG := (V_TOT/3);
   
             IF (V_AVG >= 90)
                 THEN V_GRADE := 'A';
              ELSIF (V_AVG >= 80)
                 THEN V_GRADE := 'B';
              ELSIF (V_AVG >= 70)
                 THEN V_GRADE := 'C';
              ELSIF (V_AVG >= 60)
                 THEN V_GRADE := 'D';
              ELSE
                 V_GRADE := 'F';
              END IF;
   
   /*CASE WHEN V_AVG >=90 THEN 'A'
                  WHEN V_AVG >=80 THEN 'B'
                  WHEN V_AVG >=70 THEN 'C'
                  WHEN V_AVG >=60 THEN 'D'
               ELSE 'F'
               END;
     */          
   INSERT INTO TBL_SUNGJUK(HAKBUN, NAME, KOR, ENG, MATN, TOT, AVG, GRADE)
   VALUES(V_HAKBUN, V_NAME, V_KOR, V_ENG, V_MAT, V_TOT, V_AVG, V_GRADE);
   
   COMMIT;
END;



--��TBL_SUNGJUK ���̺� ������ ���� ��
-- Ư�� �׸��� �����͸� �Է��ϸ�
-- -----------------
-- (�й� ���� ���� ��������)
--���������� ����, ���, ��� �׸� ���� ó���� �Բ� �̷���� �� �ֵ��� �ϴ�
-- ���ν����� �ۼ��Ѵ�.
-- ���ν����� : PRC_SUNGJUK_UPDATE()


CREATE OR REPLACE PROCEDURE PRC_SUNGJUK_UPDATE
( V_HAKBUN      IN  TBL_SUNGJUK.HAKBUN%TYPE
, V_KOR         IN  TBL_SUNGJUK.KOR%TYPE
, V_ENG         IN  TBL_SUNGJUK.ENG%TYPE
, V_MAT         IN  TBL_SUNGJUK.MATN%TYPE
)

IS
   V_AVG TBL_SUNGJUK.AVG%TYPE;
   V_TOT TBL_SUNGJUK.TOT%TYPE;
   V_GRADE TBL_SUNGJUK.GRADE%TYPE;
BEGIN
    
    V_TOT := V_KOR + V_MAT + V_ENG;
   V_AVG := (V_TOT/3);
   
             IF (V_AVG >= 90)
                 THEN V_GRADE := 'A';
              ELSIF (V_AVG >= 80)
                 THEN V_GRADE := 'B';
              ELSIF (V_AVG >= 70)
                 THEN V_GRADE := 'C';
              ELSIF (V_AVG >= 60)
                 THEN V_GRADE := 'D';
              ELSE
                 V_GRADE := 'F';
              END IF;
    
    UPDATE TBL_SUNGJUK
    SET KOR = V_KOR
         ,ENG = V_ENG
         ,MATN = V_MAT
         ,TOT = V_TOT
         ,AVG = V_AVG
         ,GRADE = V_GRADE
    WHERE HAKBUN = V_HAKBUN;
END;


--��TBL_STUDENTS ���̺��� ��ȭ��ȣ�� �ּ� �����͸� �����ϴ�(�����ϴ�)
-- ���ν��� �ۼ�
-- ��, ID�� PW�� ��ġ�ϴ� ��쿡�� ������ ���� ��  �� �ֵ��� ó���Ѵ�.
-- ���ν����� : PRC_STUDENTS_UPDATE()

SELECT *
FROM TBL_IDPW;

SELECT *
FROM TBL_STUDENTS;

CREATE OR REPLACE PROCEDURE PRC_STUDENTS_UPDATE
(
-- �Ű������� ���� �� : ���̵� ��й�ȣ ��ȭ��ȣ �ּ�
  V_ID IN TBL_IDPW.ID%TYPE
, V_PW IN TBL_IDPW.PW%TYPE
, V_TEL IN TBL_STUDENTS.TEL%TYPE
, V_ADDR IN TBL_STUDENTS.ADDR%TYPE
)
IS
-- ���� ���� : ���� �� ���� ,,, ����!

--��� 4�� ���� ����
    V_PW2 TBL_IDPW.PW%TYPE;
    
    --�ڹ��� �÷��׺���
    V_FLAG NUMBER := 0;
BEGIN
-- ���� ���� : "���̵� ��й�ȣ�� TBL_IDPW �� ��ġ�Ѵٸ�" TBL_STUDENTS�� ������Ʈ ���� COMMIT �Ѵ�.
    
    -- ���1
--    UPDATE TBL_STUDENTS
--    SET TEL = V_TEL
--      , ADDR=V_ADDR
--    WHERE ID = V_ID 
--      AND (SELECT PW
--           FROM TBL_IDPW
--           WHERE ID=V_ID) = V_PW;
           
    -- ���2
--    UPDATE TBL_STUDENTS
--    SET TEL = V_TEL
--      , ADDR=V_ADDR
--    WHERE ID = (SELECT P.ID
--                FROM TBL_STUDENTS S JOIN TBL_IDPW P
--                ON S.ID = SA.ID
--                WHERE P.PW = V_PW 
--                  AND P.ID = V_ID);

    -- ���3
--    UPDATE(SELECT T1.ID, T1.PW, T2.TEL, T2.ADDR
--           FROM TBL_IDPW T1 JOIN TBL_STUDENTS T2
 --          ON T1.ID = T2.ID) T
 --   SET T.TEL = V_TEL
 --     , T.ADDR = V_ADDR
  --  WHERE T.ID = V_ID
  --    AND T.PW = V_PW;
    
    --��� 4
    
    --�н����尡 �´��� Ȯ��
    --(����ڰ� �Է��� V_PW�� ���� �н������ �������� Ȯ��)
    SELECT PW INTO V_PW2
    FROM TBL_IDPW
    WHERE ID = V_ID;
    
    --�н����� ��ġ ���ο� ���� �б�
    IF (V_PW = V_PW2)
        THEN V_FLAG := 1;
    ELSE
        V_FLAG := 2;
    END IF;
    
    --UPDATE ������ ���� -> TBL_STUDENTS(�б��� �ݿ�)
    UPDATE TBL_STUDENTS
    SET TEL = V_TEL, ADDR = V_ADDR
    WHERE ID = V_ID
        AND V_FLAG = 1; -- ��й�ȣ�� �������� UPDATE�� �ǵ���
    
    
    --Ŀ��
     COMMIT;
END;
--==>> Procedure PRC_STUDENTS_UPDATE��(��) �����ϵǾ����ϴ�.

--��TBL_INSA ���̺��� ������� �ű� ������ �Է� ���ν����� �ۼ��Ѵ�.
-- NAME, SSN, IBSADATE, CITY, TEL, BUSEO, JIKWI, BASICPAY, SUDANG)
--�� ��ȣ�� ���� ������� �����ʰ� �Է��غ���
--NUM Ŀ���� ����
-- ���� �ο��� ��� ��ȣ�� ������ ��ȣ �� ���� ��ȣ�� �ڵ����� �Է� ó���� �� �ִ�
-- ���ν����� �����Ѵ�.
-- PRC_INSA_INSERT()

/*
EXEC PRC_INSA_INSERT('������'....);
*/

CREATE OR REPLACE PROCEDURE PRC_INSA_INSERT
( V_NAME       IN  TBL_INSA.NAME%TYPE
, V_SSN        IN  TBL_INSA.SSN%TYPE
, V_IBSADATE   IN TBL_INSA.IBSADATE%TYPE
, V_CITY       IN  TBL_INSA.CITY%TYPE
, V_TEL        IN  TBL_INSA.TEL%TYPE
, V_BUSEO      IN  TBL_INSA.BUSEO%TYPE
, V_JIKWI      IN  TBL_INSA.JIKWI%TYPE
, V_BASICPAY    IN  TBL_INSA.BASICPAY%TYPE
, V_SUDANG      IN  TBL_INSA.SUDANG%TYPE
)

IS
    V_NUM TBL_INSA.NUM%TYPE;
BEGIN
   
    SELECT MAX(NVL(NUM,0))+1 INTO V_NUM 
    FROM TBL_INSA;
    
    INSERT INTO TBL_INSA(NUM, NAME, SSN, IBSADATE, CITY, TEL, BUSEO, JIKWI, BASICPAY, SUDANG)
    VALUES(V_NUM, V_NAME, V_SSN, V_IBSADATE, V_CITY, V_TEL, V_BUSEO, V_JIKWI, V_BASICPAY, V_SUDANG);
    
    COMMIT;
END;

SELECT *
FROM TBL_INSA;

--��TBL_INSA ���̺��� ������� 
-- �ֹι�ȣ(SSN)�� ������ ������ ��ȸ�Ѵ�.
SELECT NAME, SSN
      ,DECODE(SUBSTR(SSN,8,1), '1','����','2','����','3','����','4','����','����Ȯ�κҰ�') "����"
FROM TBL_INSA;

SELECT NAME, SSN
      ,FN_GENDER(SSN) "����"
FROM TBL_INSA;

--���� �������

SELECT FN_GENDER('940601-1024419') "����Ȯ��"
FROM DUAL;


--3�� ��Ʈ���� ������ �Լ� FN_POW ���
SELECT FN_POW(2,5)
FROM DUAL;

--==>>32

SELECT *
FROM TBL_INSA;

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
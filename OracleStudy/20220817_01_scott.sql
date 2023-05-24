
--��TBL_FILES ���̺��� ��ȸ�Ͽ�
-- ������ ���� ����� ���� �� �ֵ��� �������� �����Ѵ�.

SELECT FILENO "���Ϲ�ȣ"
      ,REVERSE(SUBSTR(REVERSE(FILENAME),1,INSTR(REVERSE(FILENAME),'\',1)-1)) "���ϸ�"
FROM TBL_FILES;

SELECT FILENO "���Ϲ�ȣ"
      ,SUBSTR(FILENAME,INSTR(FILENAME,'\',-1)+1) "���ϸ�" --Index���� ����� ���´�.
FROM TBL_FILES;

--��LPAD()
-->BYTE�� Ȯ���Ͽ� ���ʺ��� ���ڷ� ä��� ����� ���� �Լ�
SELECT 'ORACLE' "COL1"
       ,LPAD('ORACLE',10,'*') "COL2" --10����Ʈ�� ������ Ȯ���ض� 
FROM DUAL;
--1.10Byte ������ Ȯ���Ѵ�.
--2.Ȯ���� ������ ù��° �Ķ������ 'ORACLE'�� ��´�.
--3.���� Byte������ ����° �Ķ������ * �� ���ʺ��� ä���.

--��RPAD()
-->Byte�� Ȯ���Ͽ� �����ʺ��� ���ڷ� ä��� ����� ���� �Լ�
SELECT 'ORACLE' "COL1"
       ,RPAD('ORACLE',10,'*') "COL2" --10����Ʈ�� ������ Ȯ���ض� 
FROM DUAL;

--��LTRIM()
SELECT 'ORAORAORAORAORAORACLEORACLE' "COL1"
      , LTRIM('ORAORAORAORAORACLEORACLE','ORA') "COL2"
      , LTRIM('AAAAAAORAORACLEORACLE','ORA') "COL3"
      , LTRIM('ORAORAORAoRAORACLEORACLE','ORA') "COL4" --��ҹ��ڸ� �����ؼ� �߶󳻹Ƿ� �ҹ��ڸ� ������ �۵�����
      , LTRIM('ORAORAOR AORAORACLEORACLE','ORA') "COL5"
      , LTRIM('             RACLEORACLE',' ') "COL6" --������ �ڸ����� �ι�° �Ķ���� ���� ����
FROM DUAL;
--ORAORAORAORAORAORACLEORACLE	CLEORACLE
--�ڸ��κ��� ������ �����κ��� ��ȯ�Ѵ�.
--'O','R','A'�̷��� �ϳ��� �ڸ���.
--ORAORAORAORAORAORACLEORACLE
--CLEORACLE
--CLEORACLE
--oRAORACLEORACLE
--AORAORACLEORACLE
--RACLEORACLE
--ù ��° �Ķ���� ���� �ش��ϴ� ���ڿ���
--���ʺ��� ���������� �����ϴ� �� ��° �Ķ���� ������ ������ ���ڿ�
-- ���� ���ڰ� ������ ��� �̸� ������ ��� ���� ��ȯ
--��, �ϼ��� ó���� x
--�߰��� �ι�° �Ķ���Ϳ� ���� ���ڸ� ������ �۵������ȴ�.

--��RTRIM()
--���� ����


--��TRANSLATE()
-->1:1 �� �ٲ��ش�.--���ڿ��� ���ں��� 1:1 ��ȯ
SELECT TRANSLATE('MY ORACLE SERVER'
                 , 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
                 , 'abcdefghijklmnopqrstuvwxyz') "COL1"
FROM DUAL;
--my oracle server

SELECT TRANSLATE('010-3578-3912'
                 , '0'
                 , '��') "COL1"
FROM DUAL;
--��1��-3578-3912

SELECT TRANSLATE('010-3578-3912'
                 , '0123456789'
                 , '�����̻�����ĥ�ȱ�') "COL1"
FROM DUAL;
--���ϰ�-���ĥ��-�ﱸ����


--��REPLACE() --�����̷� �ٲٱ�
SELECT REPLACE('MY ORACLE SERVER ORAHOME','ORA','����')"COL1"
FROM DUAL;

--ROUND() �ݿø��� ó���� �ִ� �Լ�
SELECT 48.678 "COL1"
      ,ROUND(48.678,2) "COL2" --�Ҽ��� ���� ��°�ڸ����� ǥ���ض�
      ,ROUND(48.674,2) "COL3"
      ,ROUND(48.678,1) "COL4"
      ,ROUND(48.678,0) "COL5"
      ,ROUND(48.678) "COL6"
      ,ROUND(48.678,-1) "COL7"
      ,ROUND(48.678,-2) "COL8"
      ,ROUND(48.678,-3) "COL9"
FROM DUAL;

--��TRUNC() ������ ó���� �ִ� �Լ�
SELECT 48.678 "COL1"
      , TRUNC(48.678,2) "COL2"
      , TRUNC(48.674,2) "COL3"
      , TRUNC(48.674,1) "COL4"
      , TRUNC(48.674,0) "COL5"
      , TRUNC(48.674) "COL6"
      , TRUNC(48.674,-1) "COL7"
      , TRUNC(48.674,-2) "COL8"
      , TRUNC(48.674,-3) "COL9"
FROM DUAL;

--��MOD() �������� ��ȯ�ϴ� �Լ�
SELECT MOD(5,2) "COL1"
FROM DUAL;
-->5�� 2�� ���� ������ ����� ��ȯ
--==>>1

--��POWER() ������ ����� ��ȯ�ϴ� �Լ�
SELECT POWER(5,3) "COL1"
FROM DUAL;
-->5�� 3���� ��������� ��ȯ
--==>>125

--��SQRT() ��Ʈ ������� ��ȯ�ϴ� �Լ�
SELECT SQRT(2) "COL1"
FROM DUAL;
-->��Ʈ 2�� ���� �����
--=>1.41421356237309504880168872420969807857

--��LOG() �α� �Լ�
-- ����Ŭ�� ���α׸� �����ϴ� �ݸ�, MYSQL�� ���α�,�ڿ��α� ��� ����
SELECT LOG(10,100)"COL1"
      ,LOG(10,20) "COL2"
FROM DUAL;

--==>>2	1.30102999566398119521373889472449302677


--�ۻﰢ�Լ�(����: -1 ~ 1)
SELECT SIN(0.5), COS(0.5), TAN(0.5)
FROM DUAL;

--0.4794255386042030002732879352155713880819	0.8775825618903727161162815826038296520119	0.5463024898437905132551794657802853832851

--�ۻﰢ�Լ��� ���Լ�(����: -1 ~ 1)
SELECT ASIN(0.5), ACOS(0.5), ATAN(0.5)
FROM DUAL;
/*
0.52359877559829887307710723054658381405	1.04719755119659774615421446109316762805	0.4636476090008061162142562314612144020295
*/
-->���� �����, ���ڽ���, ��ź��Ʈ ��� ���� ��ȯ�Ѵ�.

--SIGN() ���� ��ȣ Ư¡
-->���� ������� ����̸� 1, 0�̸� 0, �����̸� -1�� ��ȯ�Ѵ�.
SELECT SIGN(5-2) "COL1"
       ,SIGN(5-5) "COL2"
       ,SIGN(5-7) "COL3"
FROM DUAL;
-->>1	0	-1
-->�����̳� ������ �����Ͽ� ���� �� ������ ������ ��Ÿ���� ���� ���ȴ�.

--��ASCII(), CHR() -> ���� ����(����)�ϴ� �Լ�
SELECT ASCII('A') "COL1"
      ,CHR(65) "COL2"
FROM DUAL;
--==>65	A
-->ASCII() : �Ű������� �Ѱܹ��� ������ �ƽ�Ű�ڵ� ���� ��ȯ
-->CHR() : �Ű������� �Ѱܹ��� �ƽ�Ű�ڵ� ������ �ش� ���ڸ� ��ȯ�Ѵ�.


--------------------------------------------------
--�س�¥ ���� ���� ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
--==>Session�� ����Ǿ����ϴ�.

--�س�¥ ������ �⺻���� : day �� �ϼ��̴�.
SELECT SYSDATE "COL1"   --2022-08-17 11:14:40
       ,SYSDATE+1 "COL2"  --2022-08-18 11:14:40
       ,SYSDATE-2 "COL3" --2022-08-15 11:14:40
       ,SYSDATE+30 "COL4" --2022-09-16 11:14:40
FROM DUAL;


--�۽ð� ���� ����
SELECT SYSDATE "COL1"
    ,SYSDATE + 1/24 "COL2"
    ,SYSDATE - 2/24 "COL3"
FROM DUAL;


--������ �ð��� ����ð� ���� 1�� 2�ð� 3�� 4���ĸ� ��ȸ

SELECT SYSDATE "����ð�"
       ,SYSDATE+1+2/24+3/(24*60)+4/(24*60*60) "����"
FROM DUAL;

SELECT SYSDATE + ((1*24*60*60) + (2*60*60) + (3*60) + 4) / (24*60*60) "COL4" 
FROM DUAL;

--�۳�¥ - ��¥ -> �ϼ�
SELECT TO_DATE('2023-01-16','YYYY-MM-DD') - TO_DATE('2022-06-27','YYYY-MM-DD') "COL1"
FROM DUAL;
--203

SELECT TO_DATE('2022-13-17', 'YYYY-MM-DD') "COL1"
FROM DUAL;
--TO_DATE()�Լ��� ���� ���� Ÿ���� ��¥ Ÿ������ ��ȯ�� �����ϴ� ��������
-- ���������� �ش� ��¥�� ���� ��ȿ�� �˻簡 �̷������.
--ORA-01843: not a valid month

--��ADD_MONTHS() ���� ���� �����ִ� �Լ�
SELECT SYSDATE "COL1"
      ,ADD_MONTHs(SYSDATE ,2) "COL2"
      ,ADD_MONTHs(SYSDATE ,3) "COL3"
      ,ADD_MONTHs(SYSDATE ,-2) "COL4"
      ,ADD_MONTHs(SYSDATE ,-3) "COL5"
FROM DUAL;
/*
2022-08-17 11:38:15	
2022-10-17 11:38:15
2022-11-17 11:38:15
2022-06-17 11:38:15	
2022-05-17 11:38:15
*/

--��MONTHS_BETWEEN()
--ù��° ���ڰ����� �ι�° ���ڰ��� �� ���� ���� ��ȯ�Ѵ�. -> ���� : ���� ��

SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE('2002-05-31','YYYY-MM-DD')) "COL1"
FROM DUAL;
--242.564126344086021505376344086021505376

-->���� ���� ���̸� ��ȯ�ϴ� �Լ�
-- ������� ��ȣ�� - ���� �� ��ȯ�Ǿ��� ��쿡��
-- ù ��° ���ڰ��� �ش��ϴ� ��¥����
-- �� ��° ���ڰ��� �ش��ϴ� ��¥�� �̷� ��� �ǹ̷� Ȯ���� �� �ִ�.

--��NEXT_DAY()
SELECT NEXT_DAY(SYSDATE,'��') "COL1"
      ,NEXT_DAY(SYSDATE,'��') "COL2"
FROM DUAL;
-->>2022-08-20 11:44:06
--  2022-08-22 11:46:30


--���߰� ���� ���� ����
ALTER SESSION SET NLS_DATE_LANGUAGE = 'ENGLISH';
--�̷��� �ٲٸ� �ѱ��� ���κ��� ������ ���Ե�
--�ѱ۷� ������ �ٽ� �����

SELECT NEXT_DAY(SYSDATE,'SAT') "COL1"
      ,NEXT_DAY(SYSDATE,'MON') "COL2"
FROM DUAL;

ALTER SESSION SET NLS_DATE_LANGUAGE = 'KOREAN';

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
--����ϸ� ������ ���Ǻ���

--�� LAST_DAY()
--> �ش� ��¥�� ���ԵǾ� �ִ� �� ���� ������ ���� ��ȯ�Ѵ�
SELECT LAST_DAY(SYSDATE) "COL1"
    ,  LAST_DAY(TO_DATE('2020-02-10','YYYY-MM-DD')) "COL2"
    ,  LAST_DAY(TO_DATE('2019-02-10','YYYY-MM-DD')) "COL3"    
FROM DUAL;
--==>>2022-08-31   2020-02-29   2019-02-28

--�� ���úη�... �¹��̰� ���뿡 �ٽ� ����(?)����......
--   ���� �Ⱓ�� 22������ �Ѵ�

-- 1. ���� ���ڸ� ���Ѵ�.

-- 2. �Ϸ� ���ڲ��� 3�� �Ļ縦 �Ѵٰ� �����ϸ�
--    �¹��̰� �� ���� �Ծ�� ���� �����ٱ�...

SELECT (ADD_MONTHS(SYSDATE,22)-SYSDATE)*3
FROM DUAL;


--������ ��¥ �� �ð����κ���..
-- ������(2023-01-16 18:00:00)����
-- ���� �Ⱓ��... ������ ���� ���·� ��ȸ�� �� �ֵ��� �������� �����Ѵ�.



SELECT SYSDATE "����ð�"
       ,TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS') "������"
       ,TRUNC((TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')
       - SYSDATE),0)"��"
       ,TRUNC(24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)),0)"�ð�"
       ,TRUNC(60*((24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)))
       -TRUNC(24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)),0)),0)  "��"
       ,TRUNC(60*(60*((24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)))
     -TRUNC(24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)),0))
     -TRUNC(60*((24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)))
     -TRUNC(24*(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-(SYSDATE+152)),0)))),0)  "��"
FROM DUAL;


-- ��1�� 2�ð� 3�� 4�ʡ���... ���ʡ��� ȯ���ϸ�...
SELECT (1��) + (2�ð�) + (3��) + (4��)
FROM DUAL;

SELECT (1*24*60*60) + (2*60*60) + (3*60) + (4)
FROM DUAL;
--==>>93784

-- ��93784����... �ٽ� ����, �ð�, ��, �ʡ��� ȯ���ϸ�...

SELECT  TRUNC(TRUNC(TRUNC(93784/60)/60)/24)"��"
    ,   MOD(TRUNC(TRUNC(93784/60)/60),24)"�ð�"
    ,   MOD(TRUNC(93784/60),60) "��" --60���� ���������� ���� ���� 60��=1�ð��� �ȵǴ� ��¥ ���� �ǹ��Ұ�!
    ,   MOD(93784, 60) "��"
FROM DUAL;


SELECT SYSDATE "����"
       ,TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS') "������"
       ,TRUNC(TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-SYSDATE) "��"
       ,TRUNC(MOD((TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-SYSDATE)*24,24)) "��"
       ,TRUNC(MOD((TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-SYSDATE)*24*60,60)) "��"
       ,TRUNC(MOD((TO_DATE('2023-01-16 18:00:00','YYYY-MM-DD HH24:MI:SS')-SYSDATE)*24*60*60,60)) "��"
FROM DUAL;


ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';

--�س�¥ �����͸� ������� �ݿø�, ���� ���� ������ ������ �� �ִ�.
--�۳�¥ �ݿø�
SELECT SYSDATE "COL1"                 --�⺻ ���� ��¥
       ,ROUND(SYSDATE, 'YEAR') "COL2" -- 2023-01-01�������� ��ȿ�� ������(��ݱ�/�Ϲݱ� ����)
       ,ROUND(SYSDATE, 'MONTH') "COL3" -- 2022-09-01������ ��ȿ�� ������(15�� ����)
       ,ROUND(SYSDATE, 'DD') "COL4"   --2022-08-18�ϱ��� ��ȿ�� ������(���� ����)
       ,ROUND(SYSDATE, 'DAY') "COL5"  -- 2022-08-21�ϱ��� ��ȿ�� ������(������ ��������)
FROM DUAL;

--�۳�¥ ����
SELECT SYSDATE "COL1"                 --�⺻ ���� ��¥
       ,TRUNC(SYSDATE, 'YEAR') "COL2" -- 2022-01-01�������� ��ȿ�� ������
       ,TRUNC(SYSDATE, 'MONTH') "COL3" --2022-08-01 ������ ��ȿ�� ������
       ,TRUNC(SYSDATE, 'DD') "COL4"   --2022-08-17�ϱ��� ��ȿ�� ������
       ,TRUNC(SYSDATE, 'DAY') "COL5"  -- 2022-08-14�� �� �ֿ� �ش��ϴ� �Ͽ���
FROM DUAL;

---���� ��ȯ �Լ� ����-----

--TO_CHAR() ���ڳ� ��¥ �����͸� ���� Ÿ������ ��ȯ�����ִ� �Լ�
--TO_DATE() ���� �����͸� ��¥ Ÿ������ ��ȯ�����ִ� �Լ�
--TO_NUMBER() ���� �����͸� ���� Ÿ������ ��ȯ�����ִ� �Լ�


--�۳�¥�� -> ������
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') "COL1" --2022-08-17
       ,TO_CHAR(SYSDATE, 'YYYY') "COL2"      --2022
       ,TO_CHAR(SYSDATE, 'YEAR') "COL3"     --TWENTY TWENTY-TWO
       ,TO_CHAR(SYSDATE, 'MM') "COL4"       --08
       ,TO_CHAR(SYSDATE, 'MONTH') "COL5"    --AUGUST   
       ,TO_CHAR(SYSDATE, 'MON') "COL6"      --AUG
       ,TO_CHAR(SYSDATE, 'DD') "COL7"       --17
       ,TO_CHAR(SYSDATE, 'MM-DD') "COL8"    --08-17
       ,TO_CHAR(SYSDATE, 'DAY') "COL9"      --WEDNESDAY
       ,TO_CHAR(SYSDATE, 'DY') "COL10"      --WED
       ,TO_CHAR(SYSDATE, 'HH24') "COL11"    --17
       ,TO_CHAR(SYSDATE, 'HH') "COL12"      --05
       ,TO_CHAR(SYSDATE, 'HH AM') "COL13"   --05 PM
       ,TO_CHAR(SYSDATE, 'HH PM') "COL14"   --05 PM
       ,TO_CHAR(SYSDATE, 'MI') "COL15"      --11
       ,TO_CHAR(SYSDATE, 'SS') "COL16"      --46
       ,TO_CHAR(SYSDATE, 'SSSSS') "COL17"   --61906 �ð���
       ,TO_CHAR(SYSDATE, 'Q') "COL18"       --3 �б�
       FROM DUAL;
       
--�س�¥�� ��ȭ ������ ���� ���� ���...
--  �������� ���� ������ ������ �� �ִ�.

ALTER SESSION SET NLS_LANGUAGE = 'ENGLISH';
ALTER SESSION SET NLS_DATE_LANGUAGE = 'ENGLISH';
ALTER SESSION SET NLS_CURRENCY = '$'; --�� ǥ��
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';

--�ۼ����� -> ������
SELECT 7 "COL1"
       ,'7' "COL2"
       ,TO_CHAR(7) "COL3"
FROM DUAL;
-->��ȸ����� ������ ��� Ȯ��
--���ڴ� ��������
--���ڴ� ��������

--�۹����� -> ������
SELECT TO_NUMBER('4') "COL1"
      ,'4' "COL2"
      ,4 "COL3"
      ,TO_NUMBER('04') "COL4" --���ڷ� ��ȯ�Ǹ� 0�� Ż���Ǿ� 4
FROM DUAL;
--4	4	4	4
--��ȸ ����� ���� �������� ���� �������� Ȯ��~!!!


--������ ��¥���� ���� �⵵(2022)�� ���� ���·� ��ȸ(��ȯ)

SELECT TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) "����(������)"
FROM DUAL;
--��ȸ��� �������ķ� ������ Ȯ��

--��EXTRACT()

SELECT TO_CHAR(SYSDATE, 'YYYY') "COL1" --2022 ->������ �����Ͽ� ���� Ÿ������..
       ,TO_CHAR(SYSDATE,'MM') "COL2"   --08  -> ���� �����Ͽ� ���� Ÿ������...
       ,TO_CHAR(SYSDATE,'DD') "COL3"   --17  -> ���� �����Ͽ� ���� Ÿ������..
       ,EXTRACT(YEAR FROM SYSDATE) "COL4" --2022(������)  -> ������ �����Ͽ� ���� Ÿ������
       ,EXTRACT(MONTH FROM SYSDATE) "COL5"    --8(������) -> ���� �����Ͽ� ���� Ÿ������
       ,EXTRACT(DAY FROM SYSDATE) "COL6"    --17 -> ���� �����ؼ� ���� Ÿ������..
FROM DUAL;

-->��,��,�� �̿��� �ٸ� �׸��� �Ұ�~!!

--�� TO_CHAR() Ȱ�� �� ���� ���� ǥ�� ����� ��ȯ
SELECT 60000 "COL1"
     , TO_CHAR(60000, '99,999') "COL2"
     , TO_CHAR(60000, '$99,999') "COL3"
     , TO_CHAR(60000, 'L99,999') "COL4"
     , LTRIM(TO_CHAR(60000, 'L99,999')) "COL5"
FROM DUAL;
--==>> 60000    60,000    $60,000           ��60,000   ��60,000


ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
--==>> Session��(��) ����Ǿ����ϴ�.

--�� ���� �ð��� �������� 1�� 2�ð� 3�� 4�� �ĸ� ��ȸ�Ѵ�.

SELECT SYSDATE "����ð�"
     , SYSDATE + 1 + (2/24) + (3/(24*60)) + (4/(24*60*60)) "1�� 2�ð� 3�� 4�� ��"
FROM DUAL;

--�� ���� �ð��� �������� 1�� 2���� 3�� 4�ð� 4�� 6�� �ĸ� ��ȸ�Ѵ�.
-- TO_YMINTERVAL(), TO_DSINTERVAL()
--  ����              �Ϻ��� �ʱ���

SELECT SYSDATE "����ð�"
     , SYSDATE + TO_YMINTERVAL('01-02') "������"
     , SYSDATE + TO_DSINTERVAL('003 04:05:06') "������"
FROM DUAL;
 
--==>>     2023-10-17 17:47:49   
--         2022-08-20 21:52:55



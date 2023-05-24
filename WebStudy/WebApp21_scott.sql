SELECT USER
FROM DUAL;


PURGE RECYCLEBIN;


DROP TABLE TBL_BOARD PURGE;



--�Խ��� ���� ���̺� ����(TBL_BOARD)
CREATE TABLE TBL_BOARD
( NUM       NUMBER(9)                       NOT NULL   --�Խù� ��ȣ
, NAME      VARCHAR2(30)                    NOT NULL   --�Խù� �ۼ���
, PWD       VARCHAR2(20)                    NOT NULL   --�Խù� ��ȣ
, EMAIL     VARCHAR2(50)                               --�ۼ��� �̸���
, SUBJECT   VARCHAR2(100)                   NOT NULL   --�Խù� ����
, CONTENT   VARCHAR2(4000)                  NOT NULL   --�Խù� ����
, IPADDR    VARCHAR2(20)                               --������ Ŭ���̾�Ʈ�� IP�ּ�
, HITCOUNT  NUMBER          DEFAULT 0       NOT NULL   --�Խù� ��ȸ��
, CREATED   DATE            DEFAULT SYSDATE NOT NULL   --�Խù� �ۼ���
, CONSTRAINT BOARD_NUM_PK PRIMARY KEY(NUM)             --�Խù� ��ȣ PK �������� ����
);


--�۰Խù� ��ȣ�� �ִ밪�� ���� ������ ����


SELECT NVL(MAX(NUM),0) AS MAXNUM FROM TBL_BOARD
;



--�Խù� �ۼ� ������ ���� 

INSERT INTO TBL_BOARD(NUM, NAME, PWD, EMAIL, SUBJECT, CONTENT, IPADDR, HITCOUNT, CREATED) VALUES(1, '����', '1234', 'soo@test.com', '�����׽�Ʈ', '�����׽�Ʈ', '211.238.142.60', 0, SYSDATE)
;


--DB���ڵ��� ������ �������� ������ ����

SELECT COUNT(*) AS COUNT FROM TBL_BOARD
;

--��Ư�� ������(���۹�ȣ - ����ȣ) �Խù��� ����� �о���� ������ ����
-- ��ȣ �̸� ���� ��ȸ�� �ۼ���


SELECT ROWNUM RNUM, DATA.*
FROM
(

SELECT NUM, NAME, SUBJECT, HITCOUNT, TO_CHAR(CREATED,'YYYY-MM-DD')AS CREATED 
FROM TBL_BOARD
ORDER BY NUM DESC

) DATA;


SELECT NUM, NAME, SUBJECT, HITCOUNT, TO_CHAR(CREATED,'YYYY-MM-DD')AS CREATED 
FROM TBL_BOARD
ORDER BY NUM DESC
WHERE NUM >=1 AND NUM <= 10
ORDER BY NUM DESC;


SELECT NUM, NAME, SUBJECT, HITCOUNT, CREATED FROM(SELECT ROWNUM RNUM, DATA.* FROM (SELECT NUM, NAME, SUBJECT, HITCOUNT, TO_CHAR(CREATED,'YYYY-MM-DD')AS CREATED FROM TBL_BOARD ORDER BY NUM DESC) DATA) WHERE RNUM >= 1 AND RNUM <=10
;

--��Ư�� �Խù� ��ȸ�� ���� ��ȸ Ƚ�� ���� ������ ����

--���� ���
UPDATE TBL_BOARD
SET HITCOUNT = HITCOUNT + 1
WHERE NUM =1;

UPDATE TBL_BOARD SET HITCOUNT = HITCOUNT + 1 WHERE NUM =1
;

COMMIT;


--��Ư�� �Խù��� ������ �о���� ������ ����
SELECT NUM, NAME, PWD, EMAIL, SUBJECT, CONTENT, IPADDR, HITCOUNT, TO_CHAR(CREATED, 'YYYY-MM-DD') AS CREATED FROM TBL_BOARD
;


--��Ư�� �Խù��� �����ϴ�(�����ϴ�) ������ ����
SELECT *
FROM TBL_BOARD
WHERE NUM = 1;

DELETE 
FROM TBL_BOARD
WHERE NUM = 1;


DELETE FROM TBL_BOARD WHERE NUM = 1
;


--�ѹ�
ROLLBACK;

--�� Ư�� �Խù��� �����ϴ� ������ ����
UPDATE TBL_BOARD
SET NAME='������', PWD='9876', EMAIL='young@test.com', SUBJECT='�����׽�Ʈ', CONTENT='���뺯��'
WHERE NUM = 1;

-->�� �� ����
UPDATE TBL_BOARD SET NAME='������', PWD='9876', EMAIL='young@test.com', SUBJECT='�����׽�Ʈ', CONTENT='���뺯��' WHERE NUM = 1
;

SELECT *
FROM TBL_BOARD;

ROLLBACK;


--������ �Խù��� ������ȣ �о���� ������ ����
SELECT NVL(MIN(NUM),-1) AS NEXTNUM FROM TBL_BOARD WHERE NUM > 500
;

--�۰Խù� ���� ��ȣ �о���� ������ ����

SELECT NVL(MAX(NUM),-1) AS BEFORENUM FROM TBL_BOARD WHERE NUM < 500
;


--�۰Խù� �˻� ��� ���� ������ ����
SELECT COUNT(*) AS COUNT FROM TBL_BOARD WHERE SUBJECT LIKE '%����%'
;

SELECT COUNT(*) AS COUNT
FROM TBL_BOARD
WHERE NAME LIKE '%����%';

SELECT COUNT(*) AS COUNT
FROM TBL_BOARD
WHERE CONTENT LIKE '%����%';
--�����ӵ� ����� Ȯ��
Select user
from dual;
-->YOODONGHYEN

--�����̺� ����(���̺� �� : TBL_ORAUSERTEST)
Create TABLE TBL_ORAUSERTEST
(NO  NUMBER(10)   --NO�ķ����� 10�ڸ��� ����
,NAME VARCHAR2(30) --���ڿ��� 30�ڱ��� �� ���ֵ����Ѵ�.
);

-->�����߻�
--ORA-01031: insufficient privileges
--01031. 00000 -  "insufficient privileges"
--���� ������ �̸� ������ CREATE SESSION ���Ѹ� ������ ������
--���̺��� ������ �� �ִ� ������ ������ ���� ���� �����̴�.
--�׷��Ƿ� �����ڷκ��� ���̺��� ������ ������ �޾ƾߵ�

--��SYS�� ���� CREATE TABLE ������ �ο����� ��
--�ٽ� ���̺� ����
Create TABLE TBL_ORAUSERTEST
(NO  NUMBER(10)   --NO�ķ����� 10�ڸ��� ����
,NAME VARCHAR2(30) --���ڿ��� 30�ڱ��� �� ���ֵ����Ѵ�.
);

--ORA-01950: no privileges on tablespace 'TBS_EDUA'
--����
--create session&table ������ �ο��޾�����
-->������ �̸������� DEFAULT TABLESPACE��
--TBS_EDUA �̸� �� ������ ���� �Ҵ緮�� �ο����� ���� �����̴�.
--�׷��Ƿ� �� ���̺� �����̽��� ����� ������ ���ٴ� �����޼���

Create TABLE TBL_ORAUSERTEST
(NO  NUMBER(10)   --NO�ķ����� 10�ڸ��� ����
,NAME VARCHAR2(30) --���ڿ��� 30�ڱ��� �� ���ֵ����Ѵ�.
);
-->Table TBL_ORAUSERTEST�� �����Ǿ����ϴ�.

select *
from User_TS_QUOTAS;
--TBS_EDUA	65536	-1	8	-1	NO
            --    ������

--�ۻ����� ���̺�(TBL    
select *
from tab;

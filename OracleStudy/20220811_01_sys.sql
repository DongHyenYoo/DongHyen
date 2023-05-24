Select user
From dual;
-->>Sys

select 1+5
from dual;

SELECT '����Ŭ ����'
from dual;
--����Ŭ ����

select 3.14 + 3.14
from dual;
--6.28


select 4/2.0
from dual;
--2

select 5/2
from dual;
--2.5  �˾Ƽ� �Ǽ������� �������

select 100-3.14
from dual;
--96.86

select '���¹�'+'������'
from dual;
/*
ORA-01722: invalid number
01722. 00000 -  "invalid number"
*Cause:    The specified number was invalid.
*Action:   Specify a valid number.
*/

select username, account_status
from dba_users;

/*
SYS	                OPEN
SYSTEM	            OPEN
ANONYMOUS	        OPEN
HR	                 OPEN
APEX_PUBLIC_USER	    LOCKED
FLOWS_FILES	        LOCKED
APEX_040000	        LOCKED
OUTLN	            EXPIRED & LOCKED
DIP	                EXPIRED & LOCKED
ORACLE_OCM	        EXPIRED & LOCKED
XS$NULL	            EXPIRED & LOCKED
MDSYS	            EXPIRED & LOCKED
CTXSYS	            EXPIRED & LOCKED
DBSNMP	            EXPIRED & LOCKED
XDB	                EXPIRED & LOCKED
APPQOSSYS	        EXPIRED & LOCKED
*/

select *
From DBA_Users;
/*
SYS	0		OPEN		23/02/05	SYSTEM	TEMP	14/05/29	DEFAULT	SYS_GROUP		10G 11G 	N	PASSWORD
SYSTEM	5		OPEN		23/02/05	SYSTEM	TEMP	14/05/29	DEFAULT	SYS_GROUP		10G 11G 	N	PASSWORD
ANONYMOUS	35		OPEN		14/11/25	SYSAUX	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP			N	PASSWORD
HR	43		OPEN		23/02/06	USERS	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
APEX_PUBLIC_USER	45		LOCKED	14/05/29	14/11/25	SYSTEM	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
FLOWS_FILES	44		LOCKED	14/05/29	14/11/25	SYSAUX	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
APEX_040000	47		LOCKED	14/05/29	14/11/25	SYSAUX	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
OUTLN	9		EXPIRED & LOCKED	22/08/09	22/08/09	SYSTEM	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
DIP	14		EXPIRED & LOCKED	14/05/29	14/05/29	SYSTEM	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
ORACLE_OCM	21		EXPIRED & LOCKED	14/05/29	14/05/29	SYSTEM	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
XS$NULL	2147483638		EXPIRED & LOCKED	14/05/29	14/05/29	SYSTEM	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
MDSYS	42		EXPIRED & LOCKED	14/05/29	22/08/09	SYSAUX	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
CTXSYS	32		EXPIRED & LOCKED	22/08/09	22/08/09	SYSAUX	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
DBSNMP	29		EXPIRED & LOCKED	14/05/29	14/05/29	SYSAUX	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
XDB	34		EXPIRED & LOCKED	14/05/29	14/05/29	SYSAUX	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
APPQOSSYS	30		EXPIRED & LOCKED	14/05/29	14/05/29	SYSAUX	TEMP	14/05/29	DEFAULT	DEFAULT_CONSUMER_GROUP		10G 11G 	N	PASSWORD
*/

-->DBA�� �����ϴ� Oracle Data Dictionary View ��
--������ ������ �������� �������� ��쿡�� ��ȸ�� �����ϴ�.
--���� ������ ��ųʸ� ������ ���� ���ص� �������.


--��HR ����� ������ ��� ���·� ����
alter user HR account lock;
--==> User HR��(��) ����Ǿ����ϴ�.

--�۴ٽ� ����� �������� ��ȸ

select username, account_status
from dba_users;

alter user HR identified by lion;
--User HR��(��) ����Ǿ����ϴ�.

--�� HR ����� ������ ����� ����
alter user HR account unlock;
--User HR��(��) ����Ǿ����ϴ�.

alter user HR account lock;

alter user HR account unlock;

------------------------------------------
--�� TABLE SPACE ����

--��TABLE SPACE��
--> ���׸�Ʈ�� ��Ƶδ�
-->����Ŭ�� ������ ���� ������ �ǹ��Ѵ�.

create tablespace TBS_EDUA --�����ϰڴ� tablespace�� tbs_edua��� �̸�����
DATAFILE 'C:\TESTDATA\TBS_EDUA01.DBF'  --�������� ���������� ��� �� �̸�
size 4M                                --������(�뷮)
EXTENT MANAGEMENT LOCAL               --����Ŭ ������ ���׸�Ʈ�� �˾Ƽ� ����
SEGMENT SPACE MANAGEMENT AUTO;        --���׸�Ʈ ���� ������ ����Ŭ ������ �˾Ƽ� ����

--�����̺����̽� ���� ������ �����ϱ� ����
--  �ش� ����� �������� ���͸� ���� �ʿ�

--�ۻ����� ���̺����̽� ��ȸ
select *
from DBA_TABLESPACES;
/*
SYSTEM	8192	65536		1	2147483645	2147483645		65536	ONLINE	PERMANENT	LOGGING	NO	LOCAL	SYSTEM	NO	MANUAL	DISABLED	NOT APPLY	NO	HOST	NO	
SYSAUX	8192	65536		1	2147483645	2147483645		65536	ONLINE	PERMANENT	LOGGING	NO	LOCAL	SYSTEM	NO	AUTO	DISABLED	NOT APPLY	NO	HOST	NO	
UNDOTBS1	8192	65536		1	2147483645	2147483645		65536	ONLINE	UNDO	LOGGING	NO	LOCAL	SYSTEM	NO	MANUAL	DISABLED	NOGUARANTEE	NO	HOST	NO	
TEMP	8192	1048576	1048576	1		2147483645	0	1048576	ONLINE	TEMPORARY	NOLOGGING	NO	LOCAL	UNIFORM	NO	MANUAL	DISABLED	NOT APPLY	NO	HOST	NO	
USERS	8192	65536		1	2147483645	2147483645		65536	ONLINE	PERMANENT	LOGGING	NO	LOCAL	SYSTEM	NO	AUTO	DISABLED	NOT APPLY	NO	HOST	NO	
TBS_EDUA	8192	65536		1	2147483645	2147483645		65536	ONLINE	PERMANENT	LOGGING	NO	LOCAL	SYSTEM	NO	AUTO	DISABLED	NOT APPLY	NO	HOST	NO	
*/

select *
from DBA_DATA_FILES
where file_name like '$TBS_EDUA%';

--�ۿ���Ŭ ����� ���� ����
CREATE USER yoodonghyen IDENTIFIED by java002$
DEFAULT TABLESPACE TBS_EDUA;

CREATE USER FOURTH IDENTIFIED BY java002$;

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO FOURTH;

ALTER USER FOURTH TEMPORARY TABLESPACE TFOURTH;

--yoodonghyen �̶�� ����ڰ����� �����ϰڴ�.
--�� ����� ������ �н������ java002$�� �ϰڴ�.
--�� ������ ���� �����ϴ� ����Ŭ ��ü��(���׸�Ʈ��)
--�⺻������ TS_EDUA ��� ���̺� �����̽��� ������ �� �ֵ���
--�����ϰڴ�.


--���ӽõ��� ���� ������ �Ұ����ϴٶ�� ����
--create session ������ ���ٶ�� ����

--�ۻ����� ����Ŭ ����� ������
--����Ŭ ���� ������ ������ �� �ֵ��� create session ���� �ο�

grant create session to yoodonghyen;

--Grant��(��) �����߽��ϴ�.

grant create table to yoodonghyen;
--������ ����Ŭ ����ڰ����� 
--���̺� ������ ���� �� ���ֵ��� create table ���� �ο�

--����Ŭ ����ڰ��� yoodonghyen�� 
--���̺� �����̽�(TBS_EDUA)���� ����� �� �ִ� ����(�Ҵ緮) ����
ALTER User yoodonghyen
QUOTA UNLIMITED ON TBS_EDUA; --QUOTA = �Ҵ緮
                            --ON TBS_EDUA = �� TBS�ȿ���
                            --UNLIMITED = ����������  3M(3mb) �� ��ü����

select username, account_status
from DBA_USERS;

---------------------------------------------------------------
--������ ����--
--�ۻ���� ���� ����(SCOTT / TIGER)

create user scott
identified by tiger;

-->User SCOTT �� �����߽��ϴ�.

--�ۻ���� ������ ����(��) �ο�
GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO SCOTT;

--��SCOTT ����� ������ �⺻ ���̺����̽��� USERS�� �����ϴ±���
ALTER USER SCOTT DEFAULT TABLESPACE USERS;


--��SCOTT�� �ӽ����� TABLESPACE�� TEMP�� �����Ѵ�.
ALTER USER SCOTT TEMPORARY TABLESPACE TEMP;









                            
                        


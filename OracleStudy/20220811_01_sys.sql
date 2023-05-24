Select user
From dual;
-->>Sys

select 1+5
from dual;

SELECT '오라클 수업'
from dual;
--오라클 수업

select 3.14 + 3.14
from dual;
--6.28


select 4/2.0
from dual;
--2

select 5/2
from dual;
--2.5  알아서 실수형으로 계산해줌

select 100-3.14
from dual;
--96.86

select '김태민'+'조현하'
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

-->DBA로 시작하는 Oracle Data Dictionary View 는
--오로지 관리자 권한으로 접속했을 경우에만 조회가 가능하다.
--아직 데이터 딕셔너리 개념을 잡지 못해도 상관없다.


--○HR 사용자 계정을 잠금 상태로 설정
alter user HR account lock;
--==> User HR이(가) 변경되었습니다.

--○다시 사용자 계정상태 조회

select username, account_status
from dba_users;

alter user HR identified by lion;
--User HR이(가) 변경되었습니다.

--○ HR 사용자 계정의 잠금을 해제
alter user HR account unlock;
--User HR이(가) 변경되었습니다.

alter user HR account lock;

alter user HR account unlock;

------------------------------------------
--○ TABLE SPACE 생성

--※TABLE SPACE란
--> 세그먼트를 담아두는
-->오라클의 논리적인 저장 구조를 의미한다.

create tablespace TBS_EDUA --생성하겠다 tablespace를 tbs_edua라는 이름으로
DATAFILE 'C:\TESTDATA\TBS_EDUA01.DBF'  --물리적인 데이터파일 경로 및 이름
size 4M                                --사이즈(용량)
EXTENT MANAGEMENT LOCAL               --오라클 서버가 세그먼트를 알아서 관리
SEGMENT SPACE MANAGEMENT AUTO;        --세그먼트 공간 관리도 오라클 서버가 알아서 관리

--※테이블스페이스 생성 구문을 실행하기 전에
--  해당 경로의 물리적인 디렉터리 생성 필요

--○생성된 테이블스페이스 조회
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

--○오라클 사용자 계정 생성
CREATE USER yoodonghyen IDENTIFIED by java002$
DEFAULT TABLESPACE TBS_EDUA;

CREATE USER FOURTH IDENTIFIED BY java002$;

GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO FOURTH;

ALTER USER FOURTH TEMPORARY TABLESPACE TFOURTH;

--yoodonghyen 이라는 사용자계정을 생성하겠다.
--이 사용자 계정의 패스워드는 java002$로 하겠다.
--이 계쩡을 통해 생성하는 오라클 객체는(세그먼트는)
--기본적으로 TS_EDUA 라는 테이블 스페이스에 생성할 수 있도록
--설정하겠다.


--접속시도시 계정 접속은 불가능하다라는 에러
--create session 권한이 없다라는 에러

--○생성된 오라클 사용자 계정에
--오라클 서버 접속이 가능할 수 있도록 create session 권한 부여

grant create session to yoodonghyen;

--Grant을(를) 성공했습니다.

grant create table to yoodonghyen;
--생성된 오라클 사용자계정에 
--테이블 생성이 가능 할 수있도록 create table 권한 부여

--오라클 사용자계정 yoodonghyen에 
--테이블 스페이스(TBS_EDUA)에서 사용할 수 있는 공간(할당량) 지정
ALTER User yoodonghyen
QUOTA UNLIMITED ON TBS_EDUA; --QUOTA = 할당량
                            --ON TBS_EDUA = 이 TBS안에서
                            --UNLIMITED = 무제한으로  3M(3mb) 로 대체가능

select username, account_status
from DBA_USERS;

---------------------------------------------------------------
--쌤이준 파일--
--○사용자 계정 생성(SCOTT / TIGER)

create user scott
identified by tiger;

-->User SCOTT 가 생성했습니다.

--○사용자 계정에 권한(롤) 부여
GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO SCOTT;

--○SCOTT 사용자 계정의 기본 테이블스페이스를 USERS로 지정하는구문
ALTER USER SCOTT DEFAULT TABLESPACE USERS;


--○SCOTT의 임시저장 TABLESPACE를 TEMP로 지정한다.
ALTER USER SCOTT TEMPORARY TABLESPACE TEMP;









                            
                        


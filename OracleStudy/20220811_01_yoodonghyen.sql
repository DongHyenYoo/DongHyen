--○접속된 사용자 확인
Select user
from dual;
-->YOODONGHYEN

--○테이블 생성(테이블 명 : TBL_ORAUSERTEST)
Create TABLE TBL_ORAUSERTEST
(NO  NUMBER(10)   --NO컴럼에는 10자리의 숫자
,NAME VARCHAR2(30) --문자열로 30자까지 들어갈 수있도록한다.
);

-->에러발생
--ORA-01031: insufficient privileges
--01031. 00000 -  "insufficient privileges"
--현재 각자의 이름 계정은 CREATE SESSION 권한만 가지고 있으며
--테이블을 생성할 수 있는 권한은 가지고 있지 않은 상태이다.
--그러므로 관리자로부터 테이블을 생성할 권한을 받아야됨

--○SYS로 부터 CREATE TABLE 권한을 부여받은 후
--다시 테이블 생성
Create TABLE TBL_ORAUSERTEST
(NO  NUMBER(10)   --NO컴럼에는 10자리의 숫자
,NAME VARCHAR2(30) --문자열로 30자까지 들어갈 수있도록한다.
);

--ORA-01950: no privileges on tablespace 'TBS_EDUA'
--에러
--create session&table 권한을 부여받았지만
-->각자의 이름계정의 DEFAULT TABLESPACE는
--TBS_EDUA 이며 이 공간에 대한 할당량을 부여받지 못한 상태이다.
--그러므로 이 테이블 스페이스를 사용할 권한이 없다는 에러메세지

Create TABLE TBL_ORAUSERTEST
(NO  NUMBER(10)   --NO컴럼에는 10자리의 숫자
,NAME VARCHAR2(30) --문자열로 30자까지 들어갈 수있도록한다.
);
-->Table TBL_ORAUSERTEST가 생성되었습니다.

select *
from User_TS_QUOTAS;
--TBS_EDUA	65536	-1	8	-1	NO
            --    무제한

--○생성된 테이블(TBL    
select *
from tab;

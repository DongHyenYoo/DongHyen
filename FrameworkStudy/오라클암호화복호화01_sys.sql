SELECT USER
FROM DUAL;


--■■■ 오라클 암호화&복호화01_SYS ■■■--

/*
암호화는 허용불가된 제 3자가 어떤내용인지 열람불가하게 하는것
복호화는 암호화된 데이터를 볼수있게 복원하는 과정으로
이건 특정 알고리즘에 대한것을 일반인도 구성할수있다.


1.오라클 암호화 기능을 사용하기 위해서는
 『DBMS_OBFUSCATION_TOOLKIT』 패키지를 이용한다.
  암호화, 복호화 알고리즘을 직접 구현하는 것도 가능하다.
  하지만, 편의상 오라클에서 제공해주는 패키지를 통해 구현할 수 있다.
  
2.『DBMS_OBFUSCATION_TOOLKIT』 패키지는
  기본적으로 사용할 수 없는 상태로 설정되어있다. (DEFAULT 설정 상)
   이 패키지를 사용하기 위해서는 추가 설치 과정이 필요하다.
   (dbmsobtk.sql, prvtobtk.plb 파일을 찾아서 실행할 수 있도록 한다.)


3. 이 패키지는 4개의 프로시저로 이루어져 있다.
VARCHAR2 타입을 Encrypt/Decrypt 할 수 있는 2개의 프로시저
RAW 타입을 Encrypt/Decrypt 할 수 있는 2개의 프로시저
(다른 타입은 지원하지 않기 때문에 NUMBER 타입인 경우 TO_CHAR 사용)

※ RAW, LONG RAW, ROWID 타입
 그래픽 이미지나 디지털 사운드를 저장
 HEXA-DECEMAL(16 진수) 형태로 RETURN
 RAW 는 VARCHAR2 와 유사
 LONG RAW 는 LONG 과 유사하나 다음과 같은 제한사항이 있다.
  - 저장과 추출만 가능하고, 데이터를 가공할 수 없다.
  - LONG RAW는 LONG 과 같은 제한 사항을 갖는다.
 
*/


--○암호화 복호화 패키지 위치

/*
C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin

@C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin\dbmsobtk.sql

@C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin\prvtobtk.plb
*/


--○ SCOTT 계정에 이 패키지를 사용할 수 있는 권한 부여 (SYS가..)
GRANT EXECUTE ON DBMS_OBFUSCATION_TOOLKIT TO SCOTT;
--Grant을(를) 성공했습니다.
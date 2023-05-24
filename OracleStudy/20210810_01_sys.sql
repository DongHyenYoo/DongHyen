
--1줄 주석문 처리(단일행 주석문 처리) --
/*
여러줄
(다중행)
주석문
처리
*/


--○현재 오라클 서버에 접속한 자신의 계정 조회
show user;
--==>>USER이(가) "SYS"입니다
--show user = sqlplus에서 사용하는 명령어

select user
from dual;
--이것이 여기서 사용하는 현재 사용자에대한 명령어

SELECT USER
FROM DUAL;
--==>SYS

FROM DUAL;
--Oracle에서 제공하는 더미 테이블

SELECT 1+2
FROM DUAL;
--3

SELECT                          1+2
FROM                           DUAL;
--3
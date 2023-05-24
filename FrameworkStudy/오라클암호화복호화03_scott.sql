SELECT USER
FROM DUAL;
--==>SCOTT

--■■■ 생성한 작성한 암호화/복호화 패키지 테스트 ■■■--

SELECT *
FROM TAB;


--○ 실습 테이블 생성
CREATE TABLE TBL_EXAM
( ID NUMBER
, PW VARCHAR2(30)
);
--==>> Table TBL_EXAM이 생성되었습니다.

--○데이터 입력
INSERT INTO TBL_EXAM(ID, PW) VALUES( 1, 'suer1234');

--○확인
SELECT *
FROM TBL_EXAM;
--==>>
/*
    ID  PW
    1   suer1234
*/

ROLLBACK;
--=>롤백


--○암호화/복호화 패키지의 암호화 함수를 활용하여 데이터 입력
INSERT INTO TBL_EXAM(ID, PW) VALUES( 1, CRYPTPACK.ENCRYPT('suer1234', 'SUPERMAN'));

--○확인
SELECT *
FROM TBL_EXAM;

/*
    ID  PW
--------------------
    1	Mp?T?
*/

--○커밋
COMMIT;
--==>>커밋 완료.

--테스트 및 관찰
SELECT ID, CRYPTPACK.DECRYPT(PW,'SUPERMAN')
FROM TBL_EXAM;
/*
    ID PW
-----------------
    1	suer1234
*/

SELECT ID, CRYPTPACK.DECRYPT(PW,'BATMAN') AS PW
FROM TBL_EXAM;
-- 1	!/??g  복호화 실패

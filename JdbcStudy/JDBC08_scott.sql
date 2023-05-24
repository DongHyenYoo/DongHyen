SELECT USER
FROM DUAL;

SELECT *
FROM TBL_MEMBER
ORDER BY SID
;


DESC TBL_MEMBER;
/*
이름   널?       유형           
---- -------- ------------ 
SID  NOT NULL NUMBER       
NAME          VARCHAR2(30) 
TEL           VARCHAR2(60) 
*/

--○ CallableStatement 실습을 위한 프로시저 생성(작성)
--   프로시저 명 : PRC_MEMBERINSERT
--   프로시저 기능 : TBL_MEMBER 테이블에 데이터를 입력하는 INSERT 프로시저

CREATE OR REPLACE PROCEDURE PRC_MEMBERINSERT
( VSID IN TBL_MEMBER.SID%TYPE
, VNAME IN TBL_MEMBER.NAME%TYPE
, VTEL IN TBL_MEMBER.TEL%TYPE
)

IS
    
BEGIN
    
    --데이터 입력 쿼리문 구성
    INSERT INTO TBL_MEMBER(SID, NAME, TEL)
    VALUES(VSID, VNAME, VTEL);
    
    --커밋
    COMMIT;
    
END;
--Procedure PRC_MEMBERINSERT이(가) 컴파일되었습니다.



EXEC PRC_MEMBERINSERT(9, '김보경', '010-4444-2222');




--○ CallableStatement 실습을 위한 프로시저 생성(작성)
--   프로시저 명 : PRC_MEMBERSELECT
--   프로시저 기능 : TBL_MEMBER 테이블에 데이터를 읽어오는 SELECT 프로시저
--   ※ 『SYS_REFURSOR』 자료형을 이용하여 커서 다루기

CREATE OR REPLACE PROCEDURE PRC_MEMBERSELECT
( VRESULT   OUT  SYS_REFCURSOR
)
IS
BEGIN
    OPEN VRESULT FOR
    SELECT SID, NAME, TEL
    FROM TBL_MEMBER
    ORDER BY SID;
    
    --CLOSE VRESULT; REF커서라 CLOSE안함
END;

--Procedure PRC_MEMBERSELECT이(가) 컴파일되었습니다.







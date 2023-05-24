SELECT USER
FROM DUAL;


SELECT * 
FROM TBL_MEMBER;

--¡ÛÅ×ÀÌºí »ı¼º
CREATE TABLE TBL_MEMBERLIST
(ID VARCHAR2(30) NOT NULL
, PW VARCHAR2(50) NOT NULL
, NAME VARCHAR2(50) NOT NULL
, TEL VARCHAR2(50) NOT NULL
, EMAIL VARCHAR2(100)
, CONSTRAINT MEMBERLIST_ID_PK PRIMARY KEY(ID)
);
--==>Table TBL_MEMBERLISTÀÌ(°¡) »ı¼º

--¡Û µ¥ÀÌÅÍ ÀÔ·Â(¾ÏÈ£È­ ÆĞÅ°Áö »ç¿ë)
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL)
VALUES('admin', CRYPTPACK.ENCRYPT('java002$', 'admin'), '°ü¸®ÀÚ', '010-1234-1234', 'admin@test.com');
--> ÇÑ ÁÙ ±¸¼º
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL) VALUES('admin', CRYPTPACK.ENCRYPT('java002$', 'admin'), '°ü¸®ÀÚ', '010-1234-1234', 'admin@test.com')
;
--==>> 1 Çà ÀÌ(°¡) »ğÀÔµÇ¾ú½À´Ï´Ù.

--¡ÛÈ®ÀÎ
SELECT *
FROM TBL_MEMBERLIST
--admin	??a?	°ü¸®ÀÚ	010-1234-1234	admin@test.com

--¡ÛÄ¿¹Ô
COMMIT;

--¡Û¸®½ºÆ® ÀüÃ¼ Á¶È¸ Äõ¸®¹® ±¸¼º
SELECT ID, NAME, TEL, EMAIL
FROM TBL_MEMBERLIST;
-->ÇÑ ÁÙ ±¸¼º
SELECT ID, NAME, TEL, EMAIL FROM TBL_MEMBERLIST
;
--==> admin	°ü¸®ÀÚ	010-1234-1234	admin@test.com

--¡Û µ¥ÀÌÅÍ ÀÔ·Â(¾ÏÈ£È­ ÆĞÅ°Áö »ç¿ë) ÀÚ½ÅÀÇ µ¥ÀÌÅÍ
INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL)
VALUES('YDH', CRYPTPACK.ENCRYPT('java002$', 'rucy'), 'À¯µ¿Çö', '010-3578-3912', 'wingit061@gmail.com');
--1 Çà ÀÌ(°¡) »ğÀÔµÇ¾ú½À´Ï´Ù.

SELECT ID, NAME, TEL, EMAIL FROM TBL_MEMBERLIST
;
/*
admin	°ü¸®ÀÚ	010-1234-1234	admin@test.com
YDH	À¯µ¿Çö	010-3578-3912	wingit061@gmail.com
*/

--¡ÛÄ¿¹Ô
COMMIT;

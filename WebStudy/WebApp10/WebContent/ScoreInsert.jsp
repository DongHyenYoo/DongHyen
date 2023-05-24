<%@page import="java.sql.Statement"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

String name = request.getParameter("userName");
String uKor = request.getParameter("userKor");
String uEng = request.getParameter("userEng");
String uMat = request.getParameter("userMat");

Connection conn = DBConn.getConnection();

Statement stmt = conn.createStatement();

String sql = String.format("INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT) VALUES(SCORESEQ.NEXTVAL, '%s', %s,%s,%s)", name,uKor,uEng,uMat);

int result = 0;
result = stmt.executeUpdate(sql);

stmt.close();
DBConn.close();

response.sendRedirect("Scorelist.jsp");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

</body>
</html>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.util.DBConn"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");


String uName = request.getParameter("userName");
String uTel = request.getParameter("userTel");

//데이터베이스 연결
Connection conn =   DBConn.getConnection();

//작업객체 생성
Statement stmt = conn.createStatement();

//sql 작성 -> Insert 쿼리문

String sql = String.format("INSERT INTO TBL_MEMBER(SID, NAME, TEL)"
		+"VALUES(MEMBERSEQ.nextval, '%1$s', '%2$s')", uName, uTel);

//DB액션 처리 -> 쿼리문
int result = 0;
result = stmt.executeUpdate(sql);


stmt.close();
DBConn.close();


if(result <1)
{
	//클라이언트에게 에러메세지를 다시 요청할수 있게한다.
	response.sendRedirect("Error002.jsp");
}

else
{
	// 데이터가 성공적으로 입력되었으니 Test002.jsp
	response.sendRedirect("Test002.jsp");

	
}




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
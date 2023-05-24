<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	String userName = (String)session.getAttribute("userName");
	
	String userBirth = (String)session.getAttribute("userBirth");
	
	String userId = request.getParameter("userId");
	
	String userPwd = request.getParameter("userPwd");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SessionTest03.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>

이름 : <%=userName %> 
<br>
생일 : <%=userBirth %>
<br>
아이디 : <%=userId %>
<br>
비밀번호 : <%=userPwd %>


</div>

</body>
</html>
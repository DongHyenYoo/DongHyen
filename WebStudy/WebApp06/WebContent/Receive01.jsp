<%@ page contentType="text/html; charset=UTF-8"%>

<%

		//이전 페이지 Send01.html로부터 데이터 수신
		// 수신데이터는 name, tel

		String user = request.getParameter("name");
		String tel = request.getParameter("tel");
		
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive01.jsp</title>

</head>
<body>

『<%=user %>님, 회원가입이 완료되었습니다.
 회원님께서 등록하신 전화번호는 <%=tel %> 입니다.』


</body>
</html>
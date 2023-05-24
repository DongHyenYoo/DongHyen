<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	//세션의 사용자 이름 삭제
	session.removeAttribute("userName");
	
	//세션에 저장되어 있는 모든 항목을 제거하고 세션을 초기화
	session.invalidate();
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
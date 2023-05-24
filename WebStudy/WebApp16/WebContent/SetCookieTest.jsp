<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	//쿠키 생성
	Cookie c = new Cookie("cookieTest", "studyCookie"); //쿠키 이름은 cookieTest
	//위 코드만 실행한다면
	//서버에 쿠키가 저장되고 나중에 클라이언트에 심는것 
	
	//쿠키 설정
	//c.setXxx()
	c.setMaxAge(3600);
	
	//쿠키 추가 //이를 해야 클라이언트에게 전달됨
	response.addCookie(c);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SetCookieTest</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>쿠기 설정 및 추가</h1>
	<hr>
</div>

<div>
	<a href="GetCookieTest.jsp"><button type="button" class="btn">쿠키 정보 확인</button></a>
	<a href="RemoveCookieTest.jsp"><button type="button" class="btn">쿠키 정보 삭제</button></a>
	

</div>

</body>
</html>
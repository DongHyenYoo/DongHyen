<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");


%>

<jsp:useBean id="ob" class="com.test.FriendDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="ob"/>

<!-- 반복문 필요(다중 선택으로 넘어온 배열 형태의 결과값 출력) -->


<%
String str ="";

if(ob.getIdelType() != null)
{
	for(String temp :ob.getIdelType())
	{
		str += temp + "  ";
	}
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

<div>
	<h1>JSP 액션 태그 실습</h1>
</div>

<div>
이름 : <%=ob.getName() %>
나이 : <%=ob.getAge() %>
성별 : <%=ob.getGender() %>
아이돌 : <%=str %>
</div>

</body>
</html>
<%@page import="java.util.Arrays"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");


	String name = request.getParameter("name");

	
	
	String[] idol = request.getParameterValues("checkGroup");

	//배열데이터를 수신하여 처리할 경우..
	//수신된 데이터가 전혀 없는경우는
	// 배열의 상태가 null이 되어버리기 때문에 
	//null 에 대한 검사가 반드시 필요하다.
	
	String str ="";
	
	if(idol != null)
	{
		for(String item : idol)
		{
			str += "[" + item + "] ";
		}
	}
	
	String memo = request.getParameter("memo");
	
	
	//jdk 1.5이후에서 사용가능
	//memo 의 \n을 모두 <br>로 대체
	memo = memo.replaceAll("\n", "<br>");

	
	
	

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
<h2>이름</h2>
<%=name %>
<br>

<h2>메모</h2>
<%=memo %>

</div>

<div>
<h1>이상형</h1>

<%=str

%>
</div>

</body>
</html>
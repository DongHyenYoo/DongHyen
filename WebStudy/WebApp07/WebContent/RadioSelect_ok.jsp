<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	
	String name = request.getParameter("name");
	
	String gender = request.getParameter("gender");
	
	String major = request.getParameter("major");
	
	String[] hobby = request.getParameterValues("hobby");
	
	String str = "";
	if(hobby != null)
	{
		for(int i=0; i<hobby.length;i++)
		str += "[" + hobby[i] + "]";
		
	}
	
	if(gender.equals("M"))
	{
		gender += "(남자)";
	}
	else if(gender.equals("W"))
	{
		gender+="(여자)";
	}
	else
	{
		gender = "확인안됨";
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
<h2>이름 : <%=name %></h2><br>
<h2>성별 : <%=gender %></h2><br>
<h2>전공 : <%=major %></h2><br>
<h2>취미 : <%=str %></h2><br>
</div>

</body>
</html>
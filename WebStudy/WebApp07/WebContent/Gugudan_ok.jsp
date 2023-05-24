<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");


//이전 페이지로(gugudan.jsp) 부터 데이터 수신

String str = request.getParameter("dan");


int n=0;

try
{
	n = Integer.parseInt(str);
}
catch(Exception e)
{
	System.out.println(e.toString());
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

 <%
for(int i=1; i<=9;i++)
{

%>

	<%=n %> * <%=i %> = <%=(n*i) %><br>

<%

//스크립릿 영역
}

%>

 
<%--  <%
 for (int i=1; i<=9; i++)
 {
	 out.print(n + "*" + i + "=" + (n*i)+"<br>");
 }
 %>
  --%>
 
</body>
</html>
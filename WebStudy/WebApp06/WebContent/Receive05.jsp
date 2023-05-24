<%@ page contentType="text/html; charset=UTF-8"%>
<%

int num = Integer.parseInt(request.getParameter("dan"));

String str = num+"단<br>";

for(int i=1; i<=9; i++)
{
	str += num + " * " + i + " = " + (num*i) + "<br>";
}


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=str %>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); 

String su1 = request.getParameter("su1");
String su2 = request.getParameter("su2");

int num2=0;
int num1=0;
try{
	
	num1 = Integer.parseInt(su1);
	num2 = Integer.parseInt(su2);
	
}
catch(Exception e)
{
	System.out.println(e.toString());
}

String startTable ="<Table border='1'>";
String endTable = "</Table>";

int n=1;


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AsampleJsp.jsp</title>

<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>


	<div>
		<h1>큰주제</h1>
		<hr>
	</div>


<%=startTable %>

<% 

for(int i=1;i<=num2;i++)
{
	out.print("<tr>");
	
	for(int j=1;j<=num1;j++)
	{
		out.print("<td>" + " </td>");
		
	}
	
	out.print("</tr>");
	
}




%>

<%=endTable%>


<div>
<table border="1">

<%
for(int i=0; i<num2; i++)
{
%>

<tr>
<%
for(int j=0;j<num1;j++)
{

%>
  <td><%=++n %></td>
  
<%
}
%>

</tr>

<%
}
%>

</table>

</div>


</body>
</html>
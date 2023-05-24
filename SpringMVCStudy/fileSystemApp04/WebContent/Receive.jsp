<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<%
	String name = request.getParameter("name");
	String upload = request.getParameter("upload");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
</head>
<body>
<div>
	<h1>관찰</h1>
	<hr>
</div>


<div>
	<h2>이름 : <%=name %></h2>
	<h2>파일 : <%=upload %></h2>
</div>

<!--
	※『Send.jsp』의 form엘리먼트 enctype 속성을
	『enctype="multipart/form-data"』와 같이 구성할 경우
	수신된 데이터는
	------------------
	이름 : null
	파일 : null
	------------------
	인것으로 확인된다.
	
	==> 이는, ㄴ

  -->


<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />


</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
	
	#body{
	background-color: rgb(228,225,223);
	}
	
	.title 
	{
	display: flex;
	align-items: center;
	background-color: teal;
	color:white;
	}
	.right-item
	{
	margin-left: auto;
	}
	.btn-primary
	{
	background-color: teal;
	font-size: 20px;
	font-weight: bold;
	}
	.btn-success
	{
	background-color: teal;
	font-size:15px;
	}
	
	table
	{
	width: 100%
	}
	
	th,td,.updateBtn
	{
	text-align: center;
	font-size: 15px;
	}
	
</style>

</head>
<body>


<div align="left" class="title">
	
	<a href="memberlist.action" style="color: white"><h1>학생 정보</h1></a><br>&nbsp;&nbsp;&nbsp;
	<a href="memberrecordlist.action" style="color: white"><h1>학생 성적 정보</h1></a>
	<div class="right-item">
		<button type="button" class="btn btn-primary" onclick="location.href='logout.action'">로그아웃</button>
	</div>
	
</div>

</body>
</html>
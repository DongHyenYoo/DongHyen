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
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

$(function()
{
	$(".updateBtn").click(function()
	{
		$(location).attr("href","memberrecordupdateform.action?scoreId="+$(this).val());
	});
	
	$(".deleteBtn").click(function()
	{
		$(location).attr("href","memberrecorddeleteform.action?scoreId="+$(this).val());
	});
	
});

</script>

</head>
<body id="body">

<div>
	<c:import url="MemberMenu.jsp"></c:import>
</div>

<button type="button" class="btn btn-success" onclick="location.href='memberrecordinsertform.action'">데이터 입력</button>

<br><br>

<table  class="table-bordered">
	
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>

<!-- 	<tr>
	<td>1</td>
	<td>유동현</td>
	<td>60</td>
	<td>70</td>
	<td>60</td>
	<td><button class="btn btn-primary updateBtn">수정</button></td>
	<td><button class="btn btn-primary updateBtn">삭제</button></td>
	</tr> -->
	
	<c:forEach var="memberrecord" items="${memberrecordList }">
	
	 	<tr>
		<td>${memberrecord.scoreId }</td>
		<td>${memberrecord.name }</td>
		<td>${memberrecord.kor }</td>
		<td>${memberrecord.eng }</td>
		<td>${memberrecord.mat }</td>
		<td><button class="btn btn-primary updateBtn" value="${memberrecord.scoreId }">수정</button></td>
		<td><button class="btn btn-primary deleteBtn" value="${memberrecord.scoreId }">삭제</button></td>
	</tr>
	
	
	</c:forEach>



</table>







</body>
</html>
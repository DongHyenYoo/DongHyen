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
<title>MemberList.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<style type="text/css">

 *
 {
 line-height: 150%;
 }
 
 #customers td,th
 {
 	text-align: center;
 }
 
 #submitBtn
 {
 	height: 150%;
 	width: 280px;
 	font-size: 18px;
 	font-weight: bold;
 	font-family: 맑은 고딕;
 }
 
 #error
 {
 	color : red;
 	font-size: small;
 	
 	display: none;
 }

</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	
	$(function()
	{
		$("#submitBtn").click(function()
		{
			//alert("버튼");
			
			
			$("#error").css("display","none");
			
			if($("#name").val()=="" || $("#telephone").val()=="")
			{
				$("#error").css("display","inline");
				return;
			}
			
			$("#memberForm").submit();
		});
	});


</script>



</head>
<body>

<div>
	<h1>회원 관리(MemberList.jsp)</h1>
	<hr>
</div>

<div>
	<form id="memberForm" action="memberinsert.action" method="post">
		이름 : <input type="text" name="name" id="name" class="control txt"><br>
		전화 : <input type="text" name="telephone" id="telephone" class="control txt">
		<br>
		<button type="button" id="submitBtn" class="btn">회원 추가</button><br>
		<span id="error">모든 항목을 입력해야 합니다.</span>
	</form>
	
	<br><br>
	
	<p>전체 인원 수 : ${count }명</p>
	
	<table id="customers" style="width: 500px;" class="table">
	
	<tr>
	<th>번호</th> <th>이름</th> <th>전화번호</th>
	</tr>
	
	<!-- EL, JSTL 표현에 의한 회원 리스트 출력 부분  -->
	<c:forEach var = "member" items="${memberList }">
	<tr>
		<%-- MemberDTO 객체의 getMid() - getTelephone() 메소드 호출할 수 있는 EL 표현 활용 부분  --%>
		<td>${member.mid }</td>
		<td>${member.name }</td>
		<td>${member.telephone }</td>
	
	</tr>
	
	</c:forEach>
	
	
	</table>
	
	
</div>

</body>
</html>
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
<title>GetTest02.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
   #resultDiv
   {
      width: 180px;
      height: 180px;
      border: 2px solid #499bd7;
   }
   
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">

$(function()
		{
			$("#loadBtn").click(function()
			{
				var userName = $("#userName").val();
				
				$.get("GetTest02ok.jsp", {"userName":userName}, function(result)
				{
					$("#resultDiv").html(result);
				});
				
			});
			
			$("#cleanBtn").click(function()
			{
				$("#resultDiv").empty(); //내용을 지우겠다.
			});
			
		});

</script>
</head>
<body>
<div>
   <h1>jquery 의 get() 메소드 실습</h1>
   <hr>
</div>

<form>
   <div>
      <input type="text" id= "userName" class="txt">
      <br /><br />
      
      <button type="button" id="loadBtn" class="btn">눌러보자</button>
      <button type="button" id="cleanBtn" class="btn">지우기</button>
      
   
   </div>

</form>
<br /><br />

<div id="resultDiv">
  
</div>

</body>
</html>
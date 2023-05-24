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
<link rel="stylesheet" type="text/css" href="css/main.css">

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">

$(function()
{
	$("#sendBtn").click(function()
	{
		
		var name = $.trim($("#name").val());
		var age = $.trim($("#age").val());
		var hobby = $.trim($("#hobby").val());
		
		var params = "name=" + name + "&age=" + age + "&hobby=" + hobby;
		
		$.ajax(
				{
					type:"POST"
					, url:"AjaxTest02ok.jsp"
					, data:params
					, success: function(args)
					{
						$("#resultDiv").html(args);
					}
					, beforeSend: showRequest
					, error: function(e)
					{
						alert(e.responseText);
					}
			
			
		});
		
	});
});


function showRequest()
{
	if(!$.trim($("#name").val()))
		{
		alert("이름을 입력해야 합니다.");
		$("#name").focus();
		return false;
		}
	
	
	
	return true;
	
}


</script>


</head>
<body>


<div>
	<h1>jquery의 ajax()메소드 실습</h1>
	<hr>
</div>


<div>
	이름 <input type="text" id="name" class="txt">
	<br><br>
	
	나이 <input type="text" id="age" class="txt">
	<br><br>
	
	취미 <input type="text" id="hobby" class="txt">
	<br><br>
	
	<button type="button" class="btn" id="sendBtn">등록하기</button>
	
	
</div>
<br><br>

<div id="resultDiv">

</div>


</body>
</html>
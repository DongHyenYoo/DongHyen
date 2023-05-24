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
<title>GetTest01.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">


	//○ 『$.get(url, data, callBack);』
	// - 매개변수로 전달받은 URL 을 사용하여 서버에 대한 GET 요청을 전송한다.
	$(function()
	{
		
		$("#sendBtn").click(function()
		{
			//alert("클릭");
			
			var su1 = $("#su1").val();
			var su2 = $("#su2").val();
			var oper = $("#oper").val();
			
			// $.get(요청 URL, {키:값, 키:값, 키:값}, function((ajax가 전달하는 전달받은 인자){ 인자에 대한 처리 -> 업무 처리;   });
			//$.get("GetTest01ok.jsp"
			//		, {키:값, 키:값, 키:값}, function((ajax가 전달하는 전달받은 인자){ 인자에 대한 처리 -> 업무 처리;   });
			  $.get("GetTest01ok.jsp"
			            , { 
			               su1:su1
			               , su2:su2
			               , oper:oper
			            },   function(args)
			            {
			               // 인자에 대한 처리 → 업무 처리
			               $("#result").html(args);
			            });

			
		});
		
		
		
	});

</script>

<style type="text/css">
	
	.txtNum
	{
		width: 100px;
		text-align:  right;
	}
	
</style>
</head>
<body>


<div>
	<h1>jquery의 get() 활용 실습</h1>
	<hr>
</div>

<div>
	<input type="text" id="su1" class="txt txtNum">
	
	<select id="oper">
		<option value="add">덧셈</option>
		<option value="sub">뺄셈</option>
		<option value="mul">곱셈</option>
		<option value="div">나눗셈</option>
	</select>
	
	<input type="text" id="su2" class="txt txtNum">
	
	<input type="button" value=" = " id="sendBtn" class="btn">
	
</div>

<br>


<div id="result">
</div>
<br><br>


</body>
</html>
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
<title>AjaxTest03.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="<%=cp%>/js/ajax.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">




function cal()
{
	//alert("");
	
	var n1 = document.getElementById("n1").value;
	var n2 = document.getElementById("n2").value;
	var eq = document.getElementById("eq").value;
	//url 정의
	var url = "test03.nhn?n1="+n1+"&n2="+n2+"&eq="+eq;
	
	//ajax.js 불러오기
	ajax = createAjax(); //ajax 객체 생성
	
	ajax.open("GET",url,true);
	
	//서버에서 요청처리후 응답준비가 완료된다면 == 4
	//ajax객체의 status속성(HttpStatus) 가 200번대라면 응답을 받아내도록
	ajax.onreadystatechange = function()
	{
	if(ajax.readyState == 4 && ajax.status == 200)
		{
			var data = ajax.responseText;
			
			$("#result").val(data);
		
		}
		
	}
	
	ajax.send("");
	
	
}


</script>

<style type="text/css">
	.short
	{
		width: 50px;
	}

</style>
</head>
<body>

<div>
	<h1>AJAX 기본 실습</h1>
	<hr>
</div>

<div>
	<input type="text">
	<br>
	<label>
	<input type="radio" name="rdo" id="rdo1">선택1
	</label>
	<label>
	<input type="radio" name="rdo" id="rdo2">선택2
	</label>
	<br>
</div>

<div>
	<input type="text" id="n1" class="short txt">
	<select id="eq">
		<option value="add">더하기</option>
		<option value="sub">빼기</option>
		<option value="mul">곱하기</option>
		<option value="div">나누기</option>
	</select>
	<input type="text" id="n2" class="short txt">
	<button type="button" class="btn" onclick="cal()">=</button>
	<input type="text" id="result" class="short txt">
</div>


</body>
</html>
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

$(document).ready(function()
{
	
	$("#sendBtn").click(function()
	{
		$("#result").load("LoadTest03Ok.jsp?su1="+$("#su1").val()+"&oper="+$("#oper").val()+"&su2="+$("#su2").val());
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
	<h1>jquery의 load() 활용 실습</h1>
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

<div>
	<h2>같은 페이지에 존재하는 다른 요소들</h2>
	
	<input type="text">
	<br><br>
	
	<label><input type="checkbox" name="chkBox" id="chk1">check1</label>
	<label><input type="checkbox" name="chkBox" id="chk2">check2</label>
	<br><br>
	
	<label><input type="radio" name="rdo" id="rdo1">rdo1</label>
	<label><input type="radio" name="rdo" id="rdo2">rdo2</label>
	<br><br>
	
	<select name="" id="sel">
      <option value="val1">val1</option>
      <option value="val2">val2</option>
      <option value="val3">val3</option>
   </select>

	
</div>

</body>
</html>
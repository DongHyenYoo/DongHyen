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
<title>AjaxXmlTest02.jsp</title>
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
		var count = $("#count").val();
		
		var params = "name=" + name + "&age=" + age + "&hobby=" + hobby+"&count="+count;
		
		$.ajax(
				{
					type:"POST"
					, url:"AjaxXmlTest02ok.jsp"
					, data: params
					, datatype:"xml"
					, success : function(args)
					{
						
						var result="";
					//	result = "아이템 갯수 :" + $(args).find("count").text();
						$(args).find("item").each(function()
								{
									//엘리먼트 내용
									var item = $(this); //item엘리먼트
									var id = item.attr("id");
									var name = item.find("name").text();
									var age = item.find("age").text();
									var hoddy = item.find("hobby").text();
									
									 result += "<br>========================";
									 result += "<br> >>id=" + id;
									 result += "<br> 이름 : " + name;
									 result += "<br> 나이 : " + age;
									 result += "<br> 취미 : " + hobby;
									 result += "<br>========================";
									
								});
								
								$("#resultDiv").html(result);
								$("#name").val("");
								$("#age").val("");
								$("#hobby").val("");
								
						
						
					}
					, beforeSend: showRequest
					, error:function(e)
					{
						alert(e.responseText);
					}
			
		});
		
		
	});
});


function showRequest()
{
	if(!$("#name").val())
		{
		alert("이름입력해");
		$("#name").focus();
		return false;
		}
	
	if(!$("#age").val())
		{
		alert("나이입력해");
		$("#age").focus();
		return false;
		}

	if(!$("#hobby").val())
		{
		alert("취미입력해");
		$("#hobby").focus();
		return false;
		}
	
	if(!$("#count").val())
		{
		alert("개수입력해");
		$("#count").focus();
		return false;
		}

	return true;
	
}

</script>


</head>
<body>

<div>
	<h1>jquery의 ajax() 관련 실습</h1>
	<p>xml control</p>
	<hr>
</div>

<div>
	이름 <input type="text" id="name" class="txt">
	<br>	
	나이 <input type="text" id="age" class="txt">
	<br>	
	취미 <input type="text" id="hobby" class="txt">
	<br>	
	
	아이템 갯수 <input type="text" id="count" class="txt">
	
	<input type="button" id="sendBtn" value="전송 확인">
	
</div>
<br><br>

<!-- 아이템 갯수 3을 입력했다면 -->

<div id="resultDiv">

>> id=3<br>
- 이름 : 정영준1<br>
- 나이 : 13<br>
- 취미 : 달리기<br>
</div>

</body>
</html>
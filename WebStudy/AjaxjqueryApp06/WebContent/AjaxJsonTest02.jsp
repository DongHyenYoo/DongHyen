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
<title>AjaxJsonTest02ok.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">


$(function()
{
	$("#sendBtn").click(function()
	{
		var param = "name=" + $("#name").val() + "&content=" + $("#content").val();
		
		
		$.ajax(
				{
					type:"POST"
					, url:"AjaxJsonTest02ok.jsp"
					, data: param
					, dataType:"json"
					, success: function(args)
					{
						var out="";
						
						for (var idx = 0; idx < args.length; idx++)
						{
							var num = args[idx].num;
							var name = args[idx].name;
							var content = args[idx].content;
							
							out += "<br>=========================";
							out += "<br>번호 : "+ num;						
							out += "<br>이름 : "+ name;
							out += "<br>내용 : "+ content;
							out += "<br>=========================";
							
						}
												
						$("#resultDiv").html(out);
						
						$("#name").val("");
						$("content").val("");
						$("#name").focus();
						
					}
					, beforeSend:showRequest
					, error: function(e)
					{
						alert(e.responseText);
					}
			
		});
		
	});
});

function showRequest()
{
   if (!$.trim($("#name").val()))
   {
      alert("이름을 입력해야 합니다.");
      $("#name").focus();
      
      return false;
   }
   
   if (!$.trim($("#content").val()))
   {
      alert("내용을 입력해야 합니다.");
      $("#content").focus();
      
      return false;
   }
   
   return true;
}

</script>

</head>
<body>

<div>
	<h1>jquery 의 ajax() 메소드 실습</h1>
	<p>json control</p>
</div>

<div>
	이름 <input type="text" id="name" class="txt">
	<br>
	
	내용
	<textarea rows="3" cols="50" id="content"></textarea>
	<br><br>
	
	
	<input type="button" id="sendBtn" value="등록하기" class="btn">
	<br><br>
</div>


<div id="resultDiv"></div>

</body>
</html>
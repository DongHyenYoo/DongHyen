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
<title>LoadingTest02.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
	
	#name {width: 50px;}
	
	#tel2{width: 70px;}
	#tel3{width: 70px;}

</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">


$(function()
{
	$("#sendBtn").click(function()
	{
		var name = $.trim($("#name").val());
		var tel1 = $("#tel1").val();
		var tel2 = $.trim($("#tel2").val());
		var tel3 = $.trim($("#tel3").val());
		var loc = $("#loc").val();
		tel1 += "-"+tel2;
		tel1 += "-"+tel3;
		
		var params = "name=" + name + "&tel="+tel1 +"&loc="+loc;
		
		$.ajax(
				
				{
					type : "POST"
					, url : "LoadingTest02ok.jsp"
					, data : params
					, dataType : "json"
					, success : function(args)
					{
						var out = "";
						/* name = args.name;
						var tel = args.tel;
						loc = args.loc; */
						
						
						name = args[0].name;
						var tel = args[0].tel;
						loc = args[0].loc;
						
						out += "<br>-------------------"
							out += "<br>이름 : " + name;
							out += "<br>전화번호 : " + tel;
							out += "<br>지역 : " + loc;
							out += "<br>-------------------"
							
						/* 
						out += "<br>-------------------"
						out += "<br>이름 : " + name1;
						out += "<br>전화번호 : " + tel;
						out += "<br>지역 : " + loc;
						out += "<br>-------------------"
						 */
						$("#name").val("");
						$("#tel2").val("");
						$("#tel3").val("");
						
						
						$("#resultDiv").html(out);
						
					}
				, beforeSend : showRequest
				, error : function(e)
				{
					alert(e.responseText);
				}
			
		});
		
		
	});
	
	$(document).ajaxStart(function()
	{
		$("#loading").show();
		$("#resultDiv").hide();
	}).ajaxComplete(function()
	{
		$("#loading").hide();
		$("#resultDiv").show();
		
	});
	
	
});

function showRequest()
{
	
	if(!$.trim($("#name").val()))
	{
		alert("이름입력");
		return false;
	
	}
	if(!$.trim($("#tel2").val()) || !$.trim($("#tel3").val()))
	{
		alert("전화번호 입력");
		return false;
	
	}
	
	
	return true;

	
}


</script>

</head>
<body>

<!-- 
이름 , 전화번호,             지역
[]      [010 ▼]- [] - []    [ ▼]
로딩 지연시켜서 만들기 
 -->
 
 <div>
 
 이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전화번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;지역  
 
 <br>
 
 <input type="text" id="name" class="txt">
 &nbsp;&nbsp;&nbsp;
 <select id="tel1">
 <option value="010">010</option>
 <option value="011">011</option>
 <option value="012">012</option>
 <option value="013">013</option>
 <option value="014">014</option>
 <option value="019">019</option>
 </select>
 -<input type="text" id="tel2" class="txt">
 -<input type="text" id="tel3" class="txt">
 
 <select id="loc">
 <option value="서울">서울</option>
 <option value="경기">경기</option>
 <option value="부산">부산</option>
 <option value="포항">포항</option>
 <option value="울산">울산</option>
 <option value="대전">대전</option>
 <option value="대구">대구</option>
 <option value="세종">세종</option>
 </select>
 
 <input type="button" id="sendBtn" value="전송">
 
 </div>
 
 <div id="loading" style="text-align: center; display: none;">
      <img src="<%=cp %>/images/loading01_1.gif" alt="loading" />
   </div>
 
 <div id="resultDiv">
 </div>
 
</body>
</html>
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
<title>LoginForm.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<style type="text/css">
	.desc
	{
		font-size: 5px;
		font-weight: normal;
		
	}
	
	.btn
	{
		height: 40px;
		width: 40%;
	}
	th
	{
		padding: 8px;
	}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">
	$(function()
	{
		$("#submitBtn").click(function()
		{
			//alert("로그인 버튼 클릭~!!!");
			
			if($("#id").val()=="" || $("#pw").val()=="")
				{
				
				$("#err").html("항목을 모두 입력해야 합니다.").css("display","inline");
				return;
				
				}
		
			$("#loginForm").submit();
		
		});
		
		
	});

</script>

</head>
<body>
  
   <div>
      <label>로그인</label>
      <hr>


      <!-- 콘텐츠 영역 -->
      <div id="content">
      
         <form action="login.action" method="post" id="loginForm">
            
            <table>
            	<tr>
            		<th>ID <span class="desc">(아이디)</span></th>
            		<td>
            			<input type="text" id="id" name="id" placeholder="아이디">
            			
            			<input type="checkbox" id="admin" name="admin" value="0" />
            			<label for="admin">관리자</label>
            		</td>
            	</tr>
            
            <tr>
            	<th>PW<span class="desc">비밀번호</span></th>
            	<td><input type="password" id="pw" name="pw" placeholder="패스워드" /></td>
            </tr>
		
		<tr>
			<th colspan="2">
			<input type="button"  value="로그인" id="submitBtn" class="btn"/>
			<input type="button" class="btn" value="취소" id="resetBtn"/>
			<br><br>
			
			<span id="err" style="color: red; display: none;"></span>
			</th>
		</tr>            
            
            
            </table>
            
         </form>
      </div>
   </div>   
</body>
</html>
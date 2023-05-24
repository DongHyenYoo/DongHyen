<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	//전달받은 데이터 userName, userBirth
	
	//request로 온 변수는 다시 request가 발생되면 새로발생된것으로 교체되어
	//다다음페이지까지 존재할수 없다.
	
	session.setAttribute("userName", request.getParameter("userName"));
	session.setAttribute("userBirth", request.getParameter("userBirth"));
	
	
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<script type="text/javascript">
   function sendIt()
   {   
      // 테스트 
      //alert("함수호출확인");
      
      var f = document.forms[0];
      //alert(f);
      
      if(!f.userId.value)
      {
         alert("아이디를 입력해야합니다.");
         f.userId.focus();
         return;
      }
      
      if(!f.userPwd.value)
      {
         alert("패스워드 입력");
         f.userPwd.focus();
         return;
      }
      
      f.submit();
      
   }
</script>

</head>
<body>

<div>
   <h1>아이디와 패스워드 (SessionTest02.jsp)</h1>
   <hr>
</div>

<div>
   <form action="SessionTest03.jsp" method="post">
      <table class="table">
         <tr>
            <th>아이디</th>
            <td>
               <input type="text" name="userId" size="10">
            </td>
         </tr>
         <tr>
            <th>패스워드</th>
            <td>
               <input type="text" name="userPwd" size="10">
            </td>
         </tr>
         <tr>
            <td colspan = "2">
               <button type="button" onclick="sendIt()" class="btn" 
               style="width: 400px; height: 40px; font-size: 17px;">
               다음 페이지로 전송</button>
            </td>
            <td>
            </td>
         </tr>
      </table>
   </form>
</div>
</body>
</html>
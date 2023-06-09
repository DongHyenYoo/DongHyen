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
<title>LoadingTest01.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
   
   $(function()
   {
      $("#sendBtn").click(function()
      {
         //alert("버튼클릭확인");
         
         var params = "name=" + $("#name").val() + "&content=" + $("#content").val();
         
         $.ajax(
         {
            type:"POST"
            , url:"LoadingTest01ok.jsp"
            , data:params
            // ↓ LoadingTest01ok.jsp 에서 받아온걸로 작업
            , success:function(args)
            {
               $("#resultDiv").html(args);
               
               $("#name").val("");
               $("#content").val("");
               $("#name").focus();
            }
            , beforeSend:showRequest
            , error:function(e)
            {
               alert(e.responseText);
            }
         });
      });
      
      // check
      // $(document).ajaxStart(기능,동작,행위).ajaxComplete(기능,동작,행위);
      // 로딩 이미지로 사용하지 않아도, 
      // 어떤 문구를 보이게 했다 안보이게 하는 것도 가능하다!!
      $(document).ajaxStart(function()
      {
         // AJAX 시작 시 기능..
         $("#loading").show();
         $("#resultDiv").hide();
         
      }).ajaxComplete(function()
      {
         // AJAX 종료 시 기능..
         $("#loading").hide();
         $("#resultDiv").show();
         
      });
      
   });
   
   function showRequest()
   {
      var flag = true;
      
      if (!$.trim($("#name").val()))
      {
         alert("이름을 입력해야 합니다.");
         $("#name").focus();
         
         flag = false;
      }
      
      if (!$.trim($("#content").val()))
      {
         alert("내용을 입력해야 합니다.");
         $("#content").focus();
         
         flag = false;
      }
      return flag;
   }
   
</script>
</head>
<body>

<div>
   <h1>jQuery()의 ajax() 활용 실습</h1>
   <p>로딩 이미지 적용</p>
   <hr />
</div>

<div>
   이름 : <input type="text" id="name" class="txt" />
   <br /><br />
   내용 : <textarea id="content" cols="50" rows="3"></textarea>
   <br /><br />
   
   <input type="button" value="등록하기" id="sendBtn" class="btn" />
   <br /><br />
   
   <div id="loading" style="text-align: center; display: none;">
      <img src="<%=cp %>/images/loading01_1.gif" alt="loading" />
   </div>
   
   <div id="resultDiv">
   </div>
   
</div>


</body>
</html>
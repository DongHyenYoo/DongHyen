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
<title>AjaxXmlTest01.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
   
   $(function()
   {
      $("#sendBtn").click(function()
      {
         var params = "title=" + $.trim($("#title").val())
                + "&content=" + $.trim($("#content").val());
         
         //$.ajax();
         //$.ajax({속성:값, 속성:값, 속성:값});
         /*
         $.ajax(
         {
            속성:값
            , 속성:값
            , 속성:값
         });
         */
         
         $.ajax(
         {
            type: "POST"
            , url: "AjaxXmlTest01ok.jsp"
            , data: params
            , dataType : "xml"      // check~!!
            , success : function(args)
            {
               var out = "";
               
               out = ">> 게시물 개수 : " + $(args).find("totalDataCount").text() + "<br>";
            
               //이제 ok.jsp에서 넘어온 xml문서 자체에서 다른 데이터값 가져오기
             	//엘리먼트 속성접근
               $(args).find("comment").each(function()  //각각의 엘리먼트에 접근하는 방법
			{		//			     -------
                   // 					  각각에 대한 처리
                   
                   //엘리먼트 내용접근
                   var item = $(this); //-- comment 엘리먼트
                   var num = item.attr("num");    //--comment 엘리먼트의 num속성
                   var title = item.find("title").text();
                   var content = item.find("content").text();
                   
                   out += "<br>========================";
                   out += "<br> 번호 : " + num;
                   out += "<br> 제목 : " + title;
                   out += "<br> 내용 : " + content;
                   out += "<br>========================";
				
			});
               
               
               
               $("#resultDiv").html(out);
               $("#title").val("");
               $("#content").val("");
               $("#title").focus();
               
            }
            , beforeSend :showRequest
            , error : function(e)
            {
               alert(e.responseText);
            }
         });
         
      });
   });
   
   function showRequest()
   {
      if (!$.trim($("#title").val()))
      {
         alert("제목을 입력해야 합니다.");
         $("#title").focus();
         
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
   <h1>jQuery ajax() 관련 실습</h1>
   <p>xml control</p>
   <hr />
</div>

<div>
   제목 <input type="text" id="title" class="txt" />
   <br /><br />
   
   내용 <input type="text" id="content" class="txt" />
   <br /><br />
   
   <input type="button" class="btn" id="sendBtn" value="전송 확인">
   
</div>

<div id="resultDiv">
</div>

</body>
</html>
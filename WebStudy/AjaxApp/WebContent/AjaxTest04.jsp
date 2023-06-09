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
<title></title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
<style type="text/css">

	#result
	{
		display: inline-block;
		width: 250px;
		color: #f33;
	}
	p
	{
		margin: 0px;
		
	}
	
</style>
<script type="text/javascript" src="<%=cp%>/js/ajax.js"></script>
<script type="text/javascript">
	
	function check()
	{
		//alert("");
		
		//데이터 수집
		var id = document.getElementById("id").value;
		
		//URL
		var url = "test04.do?id="+id;
	
		//AJAX 객체 생성 -> XMLHttpRequest 객체 생성)
		ajax= createAjax();
		
		//환경 설정 『oepn("메소드방식", "URL", "비동기,동기")』
		ajax.open("GET",url,true);
		
		//readyState 속성은 계속 변하고
		//readystatechange 이런 이벤트로 나타난다.
		//그리고 이런 이벤트가 나타나면 호출하라는 의미로
		ajax.onreadystatechange = function()
		{
			if(ajax.readyState == 4)
			{
				if(ajax.status == 200)
					{
						//업무 처리
						//아이디 중복 검사의 결과를 통보받아
						// 사용자에게 메세지 출력(안내)
						callBack();
					}
			}
			
		}
		
		ajax.send(""); //send가 있어야 open을 통해 환경설정한것을 실행한다.
		
	}//close check()
	
	//업무 처리 내용 추출
	function callBack()
	{
		var data = ajax.responseText;
		data = parseInt(data);
		
		if(data == 0)
			{
			document.getElementById("result").innerText = "사용가능한 아이디입니다.";
			}
		else
			{
			document.getElementById("result").innerText = "이미 사용중인 아이디입니다.";
			}
		
	}
	
	
	
</script>

</head>
<body>

<div>
   <h1>회원가입</h1>
   <h2>아이디 중복검사</h2>
   <hr />
   
   
   <p>-AjaxTest04.jsp</p>
   <p>-ajax.js</p>
   <p>-main.css</p>
   <p>-Test04Ok.jsp</p>
   <p>-web.xml</p>
   <p>-URL : test04.do</p>
   <p>-DB연동 →자료구조 활용</p>
</div>


<table class="table">
   <tr>
      <th>아이디</th>
      <td>
         <input type="text" id="id" class="control txt" />
         <input type="button" value="중복검사" class="control txt" onclick="check()" />
         <span id="result">
            사용가능한 아이디입니다.
            <!--  이미 사용중인 아이디입니다. -->
         </span>
      </td>
   </tr>
   
   <tr>
      <th>이름</th>
      <td>
         <input type="text" id="name" class="controltxt" />
      </td>
   </tr>
   
   <tr>
      <th>주소</th>
      <td>
         <input type="text" id="addr" class="controltxt" />
      </td>
   </tr>
</table>
<br /><br />

<div style="text-align : center;">
   :<br>
   :<br>
   :<br>
</div>

</body>
</html>
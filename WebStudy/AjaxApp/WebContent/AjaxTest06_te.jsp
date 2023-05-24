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
<title>AjaxTest06.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<style type="text/css">
	#search
	{
	width:500px;
	}

	#list
	{
		border: 1px solid gray;
		width: 500px;
		position: absolute;
		left: 70px;
		top: 134px;
		display: none;
	}
	
	#list .item
	{
		padding: 1px;
		
	}
	
	#list #footer
	{
		background-color: #ddd;
		text-align: right;
		padding: 2px;
		font-size: 6px;;
	}

</style>


<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="<%=cp%>/js/ajax.js"></script>
<script type="text/javascript">
//키보드 누를때 마다
//그 때 까지의 입력된 단어를 서버로 전송하고
//그에 맞는 추천 검색어를 받아올 수 있도록 처리
function search()
{
   //확인
   //alert("호출 확인");
   
   //데이터 수집
   var search = document.getElementById("search").value;
   if(search.replace(" ","")=="")
   {   
      document.getElementById("list").style.display = "none";
      return;
   }
   
   //완성형 한글인 경우에만 검색 키워드를 전송할 수 있도록 처리하기
   //→ 정규 표현식 사용
   var regEx = /^[가-힣]{1,}$/;
   
   if(!regEx.test(search)) //단어가 완성되지않으면 실행 안됨
   {
      return;
   }
   else
   {
      alert(search);   
   }
   
   //URL구성
   var url= "test06.nhn?str=" +search;
   
   //XMLHttpRequest 객체 생성( -> AJAX 객체)
   ajax = createAjax();
   
   ajax.open("GET",url, true);
   ajax.onreadystatechange = function()
{
	if(ajax.readyState == 4 && ajax.status == 200)
		{
		callBack();
		}
}
   
   ajax.send("");
   
   
}

//추출된 업무 내용
//XML 목록으로 받아온 검색어들을
//적당한 리스트로 생성해서 화면에 출력
function callBack()
{
	
	//XML 문서 객체 수신
	var doc = ajax.responseXML;
	
	//수신한 XML 문서의 최상위 엘리먼트 -> 지금은 <list>인 상황
	var root = doc.documentElement;
	
	//root를 기반으로 모든 <item>엘리먼트 수신
	var itemList = root.getElementsByTagName("item");
	/* 
	->ajax.responseXML.documentElement.getElementsByTagName("item");
	-----------------
	 doc
	                   ----------------
	                   root
	                                   --------------------------
	                                   item 태그들을 전부 배열로가져옴 */
	
	//검색 결과 삽입 이전에 items 박스 초기화
	document.getElementById("items").innerHTML = "";

	for (var i = 0; i < item.length; i++)
	{
		var word = itemList[i].firstChild.nodeValue;
		
		//item추가하기
		document.getElementById("items").innerHTML += "<div class='item'>" + word + "</div>";
	}
	
	//최종적으로 목록을 화면에 보일 수 있도록 처리하기 -> 스타일 제어
	document.getElementById("list").style.display = "block";



}



</script>


</head>
<body>


<div>
	<h1>추천 검색어 관련 실습</h1>
	<hr>
</div>


<div>
	검색어
	<input type="text" id="search" class="control" placeholder="검색어를 입력하세요" onkeyup="search()">
</div>

<div id="list">
	<div id="items">
	</div>
	
	<div id="footer">
	추천 검색어
	</div>
	
</div>

</body>
</html>
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
<script type="text/javascript">

$(function()
{
	$("#search").keyup(function()
	{
		var ajax = null;
		
		if(window.XMLHttpRequest)
			ajax = new XMLHttpRequest();
		else if(window.ActiveXObject)
			ajax = new ActiveXObject("Msxml2.XMLHTTP");
		else
			ajax = null;
		
		//url 제작
		
		var url = "test06.nhn?str="+$("#search").val();
		
		ajax.onreadystatechange = function()
		{
			if(ajax.readyState == 4 && ajax.status == 200 )
				{
				  callBack(ajax);
				}
		}
		
		ajax.open("GET",url,true);
		ajax.send("");
		
		
	})
});


function callBack(ajax)
{
	var doc = ajax.responseXML; //Test06Ok.jsp 자체
	
	var root = doc.documentElement; //루트 엘리먼트인 list
	
	var recoList = root.getElementsByTagName("reco");
	
	//alert(recoList.length);
	
	if(recoList.length == 0)
		{
		document.getElementById("list").style.display="none";
		}
	else
		{
		document.getElementById("list").style.display="inline";
		}
	
	document.getElementById("items").innerHTML = "";
	
	
	
	
	for (var i = 0; i < recoList.length; i++)
	{
		var searchReco = recoList[i].getElementsByTagName("searchReco")[0];   //Object Element
		var recoText = searchReco.firstChild.nodeValue;
		
		document.getElementById("items").innerHTML += "<div class='item'>"+recoText+"</div>";
	}	
	
	
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
	<input type="text" id="search" class="control" placeholder="검색어를 입력하세요" onchange="search()">
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
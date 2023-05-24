<%@page import="com.test.ScoreDTO"%>
<%@page import="com.test.ScoreDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

ScoreDAO dao = null;

StringBuffer table = new StringBuffer();

table.append("<table class = 'list' >");

try {
	dao = new ScoreDAO();

	dao.open();

	table.append("<tr>");
	table.append("<th colspan='7'>");
	table.append("전체인원수 : ");
	table.append(dao.count());
	table.append("</th>");
	table.append("</tr>");

	table.append("<tr>");

	table.append("<th>");
	table.append("번호");
	table.append("</th>");

	table.append("<th>");
	table.append("이름");
	table.append("</th>");

	table.append("<th>");
	table.append("국어점수");
	table.append("</th>");

	table.append("<th>");
	table.append("영어점수");
	table.append("</th>");

	table.append("<th>");
	table.append("수학점수");
	table.append("</th>");

	table.append("<th>");
	table.append("총점");
	table.append("</th>");

	table.append("<th>");
	table.append("평균");
	table.append("</th>");

	table.append("</tr>");

	for (ScoreDTO dto : dao.list()) {
		table.append("<tr>");

		table.append("<td>");
		table.append(dto.getSid());
		table.append("</td>");

		table.append("<td>");
		table.append(dto.getName());
		table.append("</td>");

		table.append("<td>");
		table.append(dto.getKor());
		table.append("</td>");

		table.append("<td>");
		table.append(dto.getEng());
		table.append("</td>");

		table.append("<td>");
		table.append(dto.getMat());
		table.append("</td>");

		table.append("<td>");
		table.append(dto.getTot());
		table.append("</td>");

		table.append("<td>");
		table.append(dto.getAvg());
		table.append("</td>");

		table.append("</tr>");

	}

} catch (Exception e) {
	System.out.println(e.toString());

} finally {
	try {
		dao.close();
	} catch (Exception e) {
		System.out.println(e.toString());
	}
}

table.append("</table>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ScoreList.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<style type="text/css">
.errMsg {
	display: none;
	color: red;
	font-size: small;
}

.list {
	text-align: center;
}
</style>

<script type="text/javascript">
	function formCheck()
	{
		//alert("수정중");'

		var userName = document.getElementById("userName").value;
		var userKor = document.getElementById("userKor").value;
		userKor = parseInt(userKor);
		var userEng = document.getElementById("userEng").value;
		userEng = parseInt(userEng);
		var userMat = document.getElementById("userMat").value;
		userMat = parseInt(userMat);

		var nameMsg = document.getElementById("nameMsg");
		var korMsg = document.getElementById("korMsg");
		var engMsg = document.getElementById("engMsg");
		var matMsg = document.getElementById("matMsg");

		nameMsg.style.display = "none";
		korMsg.style.display = "none";
		engMsg.style.display = "none";
		matMsg.style.display = "none";

		if (userName == "")
		{
			nameMsg.style.display = "inline";
			return false;

		}
		if(userKor <0 || userKor > 100 || isNaN(userKor) == true)
		{
		korMsg.style.display = "inline";
		return false;
		}
		
		if(userEng <0 || userEng > 100 || isNaN(userEng) == true)
		{
		engMsg.style.display = "inline";
		return false;
		}
		
		if(userMat <0 || userMat > 100 || isNaN(userMat) == true)
		{
		matMsg.style.display = "inline";
		return false;
		}
		
		return true;
		

	}
</script>

</head>
<body>

	<div>
		<form action="ScoreInsert.jsp" method="post" onsubmit="return formCheck()">
			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" id="userName" name="userName"
						class="txt"> <span class="errMsg" id="nameMsg">이름
							입력해주세요</span></td>
				</tr>
				<tr>
					<th>국어점수</th>
					<td><input type="text" id="userKor" name="userKor" class="txt">
						<span class="errMsg" id="korMsg">0~100점사이의 점수를 입력하세요</span></td>
				</tr>
				<tr>
					<th>영어점수</th>
					<td><input type="text" id="userEng" name="userEng" class="txt">
						<span class="errMsg" id="engMsg">0~100점사이의 점수를 입력하세요</span></td>
				</tr>
				<tr>
					<th>수학점수</th>
					<td><input type="text" id="userMat" name="userMat" class="txt">
						<span class="errMsg" id="matMsg">0~100점사이의 점수를 입력하세요</span></td>
				</tr>

				<tr>
					<td><button type="submit">전송</button></td>
				<tr>
			</table>
		</form>

	</div>
	<!--  입력부분끝  -->

	<!-- 출력부분 시작 -->

	<div>
		<%=table%>
	</div>




</body>
</html>
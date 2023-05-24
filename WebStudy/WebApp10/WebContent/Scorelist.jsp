<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	
//기본 TextArea구문
String basic = "번호  이름   국어점수   영어점수    수학점수   총점   평균\n--------------------------------------------------------------";

//select 로 받은 구문
String str = "";

//연결객체 생성
Connection conn = DBConn.getConnection();

//작업객체 생성
Statement stmt = conn.createStatement();

//sql구문
String sql = "SELECT SID,NAME,KOR,ENG,MAT , "
+"(KOR+ENG+MAT) AS TOT, ROUND((KOR+ENG+MAT)/3,1) AS AVG FROM TBL_SCORE";

ResultSet rs = stmt.executeQuery(sql);

while(rs.next())
{
	
	str += "\n"+rs.getString("SID")+"    ";
	str += rs.getString("NAME")+"    ";
	str += rs.getString("KOR")+"    ";
	str += rs.getString("ENG")+"    ";
	str += rs.getString("MAT")+"    ";
	str += rs.getString("TOT")+"    ";
	str += rs.getString("AVG")+"    ";
	
}

stmt.close();
DBConn.close();


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scorelist.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<style type="text/css">
	.txt{width: 100px;}
	.errMsg{color: red; display: none;}
</style>

<script type="text/javascript">

function formCheck()
{
	var uName=document.getElementById("userName");
	var uKor=document.getElementById("userKor");
	var kor = parseInt(uKor.value);
	var uEng=document.getElementById("userEng");
	var eng = parseInt(uEng.value);
	var uMat=document.getElementById("userMat");
	var mat = parseInt(uMat.value);
	
	var nameErr=document.getElementById("nameErr");
	var korErr=document.getElementById("korErr");
	var engErr=document.getElementById("engErr");
	var matErr=document.getElementById("matErr");
	
	
	nameErr.style.display ="none";
	korErr.style.display ="none";
	engErr.style.display ="none";
	matErr.style.display ="none";
	
	
	if(uName.value == "")
		{
		nameErr.style.display ="inline";
		return false;
		}
	
	if(kor <0 || kor>100 || isNaN(kor) == true)
		{
		korErr.style.display ="inline";
		return false;
		}
	if(eng <0 || eng>100 || isNaN(eng) == true)
		{
		engErr.style.display ="inline";
		return false;
		}
	if(mat <0 || mat>100 || isNaN(mat) == true)
		{
		matErr.style.display ="inline";
		return false;
		}
	
	return true;
	
	
	
	
	
	
}

</script>

</head>
<body>

<div>
<form action="ScoreInsert.jsp" method="post" onsubmit="return formCheck()">

이름(*)<input type="text" name="userName" id="userName" class="txt">
<span class="errMsg" id="nameErr">이름을 입력해주세요</span>
<br>
국어<input type="text" name="userKor" id="userKor" class="txt">
<span class="errMsg" id="korErr">0~100사이의 숫자를 입력해주세요</span>
<br>
영어<input type="text" name="userEng" id="userEng" class="txt">
<span class="errMsg " id="engErr">0~100사이의 숫자를 입력해주세요</span>
<br>
수학<input type="text" name="userMat" id="userMat" class="txt">
<span class="errMsg" id="matErr">0~100사이의 숫자를 입력해주세요</span>
<br>
<button>데이터입력</button>

</form>


</div>

<div>
<textarea rows="10" cols="70">
<%=basic %>
<%=str %>
</textarea>
</div>



</body>
</html>
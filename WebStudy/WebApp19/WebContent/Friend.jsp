<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<style type="text/css">
   #div01 {display: none;}
   #div02 {display: none;}
</style>


<script type="text/javascript">
	function sendIt()
	{

		var f = document.myForm;

		if (!f.name.value)
		{
			alert("이름을 입력해야합니다.");
			f.name.focus();
			return;
		}

		f.action="Friend_ok.jsp";
		f.submit();

	}

	function checkGender(obj)
	{

		var div01 = document.getElementById("div01");
		var div02 = document.getElementById("div02");

		div01.style.display = "none";
		div02.style.display = "none";
		
		if (obj.value == "남성")
		{
			div01.style.display = "inline";
		} 
		else
		{
			div02.style.display = "inline";
		}
		
		
		
	}
</script>

</head>
<body>

	<div>
		<h1>JSP 액션 태그 실습</h1>
		<hr>
	</div>
	<div>
		<p>데이터 등록</p>

		<form name="myForm">
			<table class="table">
				<tr>
					<th>이름(*)</th>
					<td><input type="text" class="txt" name="name"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="text" class="txt" name="age"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><label> <input type="radio" name="gender"
							id="male" value="남성" onclick="checkGender(this)">남성
					</label> <label> <input type="radio" name="gender" id="female"
							value="여성" onclick="checkGender(this)">여성
					</label></td>
				</tr>
				<tr>
					<th>친구이상형</th>
					<td>
						<div id="div01">
							<label> <input type="checkbox" name="idelType"
								id="idelType1" value="아이유"> 아이유
							</label> <label> <input type="checkbox" name="idelType"
								id="idelType5" value="카리나"> 카리나
							</label> <label> <input type="checkbox" name="idelType"
								id="idelType7" value="전효성"> 전효성
							</label>
						</div>

						<div id="div02">
							<label> <input type="checkbox" name="idelType"
								id="idelType2" value="소지섭"> 소지섭
							</label> <label> <input type="checkbox" name="idelType"
								id="idelType4" value="손석구"> 손석구
							</label> <label> <input type="checkbox" name="idelType"
								id="idelType6" value="김석진"> 김석진
							</label> <label> <input type="checkbox" name="idelType"
								id="idelType3" value="김영광"> 김영광
							</label>
						</div>

					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" onclick="sendIt()" class="btn"
							style="width: 100%; font-size: 16pt;">등록</button>
			</table>

		</form>
	</div>

</body>
</html>
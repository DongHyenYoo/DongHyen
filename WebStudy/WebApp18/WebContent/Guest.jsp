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

<script type="text/javascript">

function sendIt()
{
	
	var txtForm = document.forms[0];
	
	/* alert(txtForm1); */
	
	/* var txtForm1 = document.(form의 name) */
	
	if(!txtForm.userName.value)
	{
		alert("이름을 입력해주세요");
		return;
	}
	if(!txtForm.subject.value)
	{
		alert("제목을 입력해주세요");
		return;
	}
	if(!txtForm.content.value)
	{
		alert("내용을 입력해주세요");
		return;
	}
	txtForm.method="post";
	txtForm.action="Guest_ok.jsp";
	
	txtForm.submit();
	
}

</script>

</head>
<body>


<div>
	<p>간단한 기본 방명록 작성 실습</p>
	
	<form>
		<table class="table">
			<tr>
				<th>이름</th>
				<td>
					<input type="text" class="txt" name="userName">
				</td>
			</tr>
			
			<tr>
				<th>제목</th>
				<td>
					<input type="text" class="txt" name="subject">
				</td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="30" cols="30" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" class="btn" onclick="sendIt()" style="width: 100%;">방명록 작성</button>			
				</td>
			</tr>
		</table>
	
	</form>

</div>


</body>
</html>
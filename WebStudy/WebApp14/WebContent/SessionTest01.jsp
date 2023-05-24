<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	//Session의 userName(key)에 담겨있는 값(value)요청
	String userName = (String)session.getAttribute("userName");
	//최초 이페이지를 요청한 사용자나
	//로그인을 시도했지만 정상적인 로그인 과정을 거치지 못한 사용자는
	//userName을 얻지못한 상황이나
	//정상적인 로그인 과정을 거친 사용자는
	//userName에 "최동현" 값을 받아서 이 페이지를 방문한 상황
	//즉, SessionTest01_ok.jsp 에서 userName(key)에 "최동현"(value)을
	//담아서 이 페이지로 돌려보낸 상황
	//-- 『session.getAttribute()』는
	// Object 타입을 반환하므로 String 타입으로 변환하는 과정 필요
	
	
	// 세션 설정 변경 ------------------------------------
	
	//※ 세션 기본 시간(default)은 1800초,
	
	session.setMaxInactiveInterval(5);
	//--세션이 유지되는 시간을 3초로 변경하여 설정한 상태
	//
	
	
	// ======================================세션 설정 변경
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SessionTest01.jsp</title>
<link rel="stylesheet" type="text/css" href="css/MemberSelect.css">
<style type="text/css">
	.btn01{font-size: small; width: 100px;}
	.btn02{font-size: small; width: 100px;}
	
</style>

<script type="text/javascript">

function sendIt()
{
	//alert("try");
	//name을 이용하면 이렇게 쓸수있다.
	var f = document.myForm;
	
	if(!f.userId.value)
		{
			alert("아이디입력");
			f.userId.focus();
		}
	
	if(!f.userPwd.value)
		{
		alert("패스워드 입력");
		f.userPwd.focus();
		return;
		}
	
	f.submit();
	
	
	// myForm.submit(); 바람직하진 않다.
}

</script>

</head>
<body>

	<div>
		<h1>세션처리 - 로그인</h1>
		<hr>
	</div>


	<div>
		<table>
			<tr>
				<td><a href=""><button type="button" class="btn01">게시판</button></a>
					|</td>
				<td>
				<%
				if(userName==null)
				{
				%>
				
				<a href=""><button type="button" class="btn02">일정관리</button></a> |
				
				<%
				}
				else
				{
				%>		
						
				<a href="SessionTest02.jsp"><button type="button" class="btn01">일정관리</button></a> |
				
				<%
				}
				%>
				</td>
				
				<td>
				<%
				if(userName==null)
				{
				%>
				
				<a href=""><button type="button" class="btn02">친구관리</button></a>|
				
				<%
				}
				else
				{
				%>
				
				<a href="SessionTest03.jsp"><button type="button" class="btn01">친구관리</button></a>|
				<%
				}
				%>
								
				</td>
			</tr>
		</table>
	<br><br>
	</div>

<div>

<%
if(userName==null)
{
	
%>

	<table>
		<tr>
			<td>
				<form action="SessionTest01_ok.jsp" method="post" name="myForm">
					<table>
						<tr>
							<th>아이디</th>
							<td>
								<input type="text" name="userId" style="width: 200px;">
							</td>
						</tr>
						<tr>
							<th>패스워드</th>
							<td>
								<input type="password" name="userPwd" style="width: 200px;" >
							</td>
						</tr>
						<tr>
							<th colspan="2">
								<button type="button" style="width: 100%;" onclick="sendIt()">로그인</button>
							</th>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	
	<%}
	else
	{
	%>
	<h2><%=userName %>님 방문을 환영합니다.</h2>
	<h3>이제 일정관리와 친구관리 서비스를 이용하실 수 있습니다.</h3>
	<br><br>
	
	<p><a href="Logout.jsp">로그아웃</a>
	<%} %>
</div>

</body>
</html>
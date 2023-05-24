<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//이전 페이지(Send04_01.jsp)로부터 데이터 수신
	//-- userId, userPwd, userName, userTel
	// userGender, userCity, userSubject
	
	//한글 인코딩 처리
	request.setCharacterEncoding("UTF-8");

	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
	String userName = request.getParameter("userName");
	String userTel =  request.getParameter("userTel");
	
	
	String userGender = "확인불가";
	userGender = request.getParameter("userGender");
	String userCity = "확인불가";
	userCity = request.getParameter("userCity");
	
	//다중 선택 제어
	// 배열 수신
	
	String[] subjectArr = request.getParameterValues("userSubject");
	
	String userSubject = "";
	
	if(subjectArr.length != 0)
	{
		for(int i=0; i<subjectArr.length; i++)
		{
			userSubject += subjectArr[i].toString() + " ";
		}
		
	}
	else
	{
		userSubject = "선택항목없음";
	}
	
	
	//수신된 데이터를 
	//쿼리문을 통해  DB액션을 처리하는 방식을
	//생각하자
	
	

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>

<h3> 아이디 : <%=userId %></h3>
<h3> 비밀번호 : <%=userPwd %></h3>
<h3> 이름 : <%=userName %></h3>
<h3> 전화번호 : <%=userTel %></h3>
<h3> 성별 : <%=userGender %></h3>
<h3> 지역 : <%=userCity %></h3>
<h3> 수강과목 <%=userSubject %></h3>


</div>

</body>
</html>
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
<title>Test.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp%>/css/main.css">
</head>
<body>
<div>

<!-- 
		파일이 물리적으로 올라가게 하려면
		input type='file' 만 만든다고 되는게 아니다.
		
		실제로 얘를 전송하기 위해서는,
		form 에 enctype="multipart/form-data" 를 반드시 구성해줘야 한다!!!
	-->
	<!-- 
		전송하는 파일은 body에서 보내고, 읽는건 head 에서 읽기 때문에 
		전송방식도 post여야 한다!!
	-->
	<!-- 『enctype="multipart/form-data"』 : 물리적으로 업로드하기 위한 필수 속성 -->
	<!-- 『method="post"』 : 파일을 물리적으로 업로드하기 위한 요청 및 전송 방식 -->
	<form action="Test_ok.jsp" method="post" enctype="multipart/form-data" name="myform">
		작성자 : <input type="text" name="userName"  /><br />
		제목 : <input type="text" name="subject" /><br />
		파일 : <input type="file" name = "uploadFile"  /><br />
		
		<input type="submit" value="파일올리기" />
	</form>
</div>



</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	

	//연산페이지
	int firstNum = Integer.parseInt(request.getParameter("firstNum"));
	int secNum = Integer.parseInt(request.getParameter("secondNum"));
	String result = "";
	String vSign = request.getParameter("sign");
	
	
	switch(vSign)
	{
	case "*" : result = String.format("%d * %d = %d\n",firstNum,secNum,(firstNum*secNum));  break;
	case "/" : result = String.format("%d / %d = %.1f\n",firstNum,secNum,(firstNum/(double)secNum));  break;
	case "+" : result = String.format("%d + %d = %d\n",firstNum,secNum,(firstNum+secNum));  break;
	case "-" : result = String.format("%d - %d = %d\n",firstNum,secNum,(firstNum-secNum));  break;
	default : break;
	}
	
	request.setAttribute("result", result);
	
	
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward10.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<jsp:forward page="Receive10.jsp"></jsp:forward>

</body>
</html>
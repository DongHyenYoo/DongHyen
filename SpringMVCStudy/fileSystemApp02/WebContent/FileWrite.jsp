<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
String cp = request.getContextPath();
%>
<%
	// FileWrite.jsp
//1.어플리케이션 루트(경로) 얻어내기
String appRoot = "/";
appRoot = pageContext.getServletContext().getRealPath(appRoot);
//-->C:\SpringMVCStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\fileSystemApp02\

//2. 파일을 쓰기위해 File 객체를 생성
File newFile = new File(appRoot, "data/test.txt");
//-→ 이렇게 한다고 data라는 폴더나 test.txt 파일이 만들어지는 것은 아니다.
//-->C:\SpringMVCStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\fileSystemApp02\data\test.txt

//파일객체  
//------   
//파일객체가 만들어지기 위한 경로
//          ------------
//가 존재한다면 인데 앞에 ! 이므로 존재하지 않는다면  
//                        --------     
if (!newFile.getParentFile().exists())
{ //경로를 생성
	newFile.getParentFile().mkdirs();  //즉 여기서 data폴더가 생성됨
}
//즉 3. 파일이 존재할 경로(디렉터리)가 존재하지 않는 경우는
// 파일이 위치할 곳까지의 디렉터리를 생성해준다.

//4-1. 파일을 쓰기 위한 FileWriter 객체 생성
FileWriter fw = new FileWriter(newFile);
//-- newFile로 만든 test.txt 에 뭔가를 쓰기 위한 writer를 생성
//   writer 로 적으려면 하나하나 적어야 하기 때문에 PrintWriter 생성


//4-2. FileWriter 객체를 조금 더 편하게 사용하기 위해
//		PrintWriter 로 감싸주기
//    -> 출력스트림을 활용하여 건네는 구문으로 파일 구성을 하기 위해 처리
PrintWriter pw = new PrintWriter(fw);

//5. 실질적으로 파일에 내용을 작성
pw.println("테스트");
pw.println("확인");
//-→ printWriter 활용해서 문자 쭉~ 보냄(하나하나 보내지 않고)


//6-1 PrintWriter 리소스 반납(닫아줌)
pw.close();

//6-2. FileWriter 리소스 반납(닫아줌)
fw.close();

%>

<!-- 
	실행해도 시각적으로 뭐가 나오지 않지만,
	저 경로 들어가보면 data 폴더와 test.txt 파일도 만들어져 있고, 
	test.txt 파일 안에 파일에 적은 내용도 적혀있는 걸 확인할 수 있다.
-->
<!-- 
	이게 클라이언트가 서버로 뭘 전송한건아니다.
	서버쪽에서 파일 써서 내보내서, 서버 자원에 등록해서
	그 내용이 파일 형태로 얻어지는지 확인한 것이다.
-->
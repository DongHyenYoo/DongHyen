<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	
	
	//JSONObject jobj = new JSONObject();
	
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String loc = request.getParameter("loc");
	/* 
	jobj.put("name", name);
	jobj.put("tel", tel);          ---json Object활용
	jobj.put("loc", loc);
	
	out.println(jobj.toString());
	 */
	 
	 try{
		 
		 Thread.sleep(3000);
		 
	 }catch(Exception e)
	 {
		 System.out.print(e.toString());
	 }
	 
	 JSONArray arr = new JSONArray();
	 

		 JSONObject jobj = new JSONObject();
		 jobj.put("name", name);
		 jobj.put("tel", tel);    //--Json 배열 활용
		 jobj.put("loc", loc);
		 
		arr.add(jobj);
	 
	 
	 
	 out.println(arr.toString());
	 
	 
	 
	//LoadingTest01.jsp에서 그냥 .html(args) 하게되면
	//{"name":"132","tel":"010-324235-234325","loc":"서울"} 이런 결과를 얻는다.
	
	//즉 ajax자체를 바꿔줘야함
	
%>
<%-- 이름 : ${param.name}<br>
전화번호 : ${param.tel}<br>
지역 : ${param.loc}<br> --%>
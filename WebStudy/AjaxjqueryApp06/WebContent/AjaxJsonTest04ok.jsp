<%@page import="net.sf.json.JSONObject"%>
<%@page import="netscape.javascript.JSObject"%>
<%@page import="net.sf.json.JSONArray"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
String name = request.getParameter("name");
String content = request.getParameter("content");

String result = "";


//※ JSON 데이터 배열 구조
// [{"키1":"값1", "키2":"값2"}, {"키3":"값3","키4","값4"}]
		
		/* 
		[{"num":"1", "name":"고연수", "content":"블라블라"},
		{"num":"2", "name":"고연수", "content":"블라블라"},
		{"num":"3", "name":"고연수", "content":"블라블라"},
		{"num":"4", "name":"고연수", "content":"블라블라"},
		{"num":"5", "name":"고연수", "content":"블라블라"},
		 */
		
		 // ↓
		
		 /* 
		[{"num":"1", "name":"고연수", "content":"블라블라"},
		{"num":"2", "name":"고연수", "content":"블라블라"},
		{"num":"3", "name":"고연수", "content":"블라블라"},
		{"num":"4", "name":"고연수", "content":"블라블라"},
		{"num":"5", "name":"고연수", "content":"블라블라"} 끝에 , 없어야함
		 */
		
		 //↓
		 
		/* 
		{"num":"1", "name":"고연수", "content":"블라블라"},
		{"num":"2", "name":"고연수", "content":"블라블라"},
		{"num":"3", "name":"고연수", "content":"블라블라"},
		{"num":"4", "name":"고연수", "content":"블라블라"},
		{"num":"5", "name":"고연수", "content":"블라블라"}]
		 */
		
	/*	 
		 for(int n=1; n<=5; n++)
		 {
			 StringBuffer sb = new StringBuffer();
			 
			 sb.append("{\"num\":\""+ n+ "\"");
			 sb.append(", \"name\":\""+name+"\"");
			 sb.append(", \"content\":\""+content+"\"},");
			 
			 result += sb.toString();
			 
		 }
		 
		result = result.substring(0 , result.length()-1); //마지막 콤마떼기
		
		result = "[" + result + "]";
		
		out.println(result);
		
		*/
		
		JSONArray jarr = new JSONArray();
		
		for (int n=1; n<=5; n++)
		{
			JSONObject jobj = new JSONObject();
			jobj.put("num", n);
			jobj.put("name" , name);
			jobj.put("content", content);
		
			jarr.add(jobj);
			
		}
		
		out.println(jarr.toString()); //바로 더미로 구성하는것
		
		
%>
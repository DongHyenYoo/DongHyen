<%@page import="com.test.MemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
   // MemberDelete.jsp
   request.setCharacterEncoding("UTF-8");
   
   // 이전 페이지(MemberSelect.jsp)로부터 데이터 수신
   //-- sid
   String sid = request.getParameter("sid");
   
   MemberDAO dao = new MemberDAO();
   
   String strAddr = "";
   //삭제시도 결과에 따라 사용자에게 성적이 입력되어있어 삭제할수없다 or 삭제했으니 select로 돌아가라
   //를 결정할 url을 담당할 변수
   
   try
   {
      dao.connection();
      
      int checkCount = dao.refCount(sid);
      //TBL_MEMBER 테이블의 제거하고자 하는 데이터의
      //SID를 참조하는 TBL_MEMBERSCORE 테이블 내의 데이터 갯수(존재 여부) 확인
      
      if(checkCount == 0)
      {
    	  dao.remove(sid);
    	  strAddr = "MemberSelect.jsp";
      }
      else
      {
    	  strAddr = "Notice.jsp";
    	  //제거하지 못하는 사유를 안내하는 페이지
    	  //+ 리스트로 돌아가는 기능
      }
      
   }
   catch(Exception e)
   {
      System.out.println(e.toString());
   }
   finally
   {
      try
      {
         dao.close();
      }
      catch(Exception e)
      {
         System.out.println(e.toString());
      }
   }
   
   
   response.sendRedirect(strAddr);

%>
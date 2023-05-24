/*
 MemberListController.java
 - 사용자 정의 컨트롤러 클래스
 - 회원들의 목록(리스트) 출력 액션.
 - DAO 객체에 대한 의존성 주입을 위한 준비.
  →setter injection
   ① 인터페이스 형태의 자료형
   ② setter구성
*/

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MemberListController implements Controller
{
	// 인터페이스 자료형을 취하는 속성 구성
	private IMemberDAO dao;
	
	// setter 메소드 구성
	public void setDao(IMemberDAO dao)
	{
		this.dao = dao;
	}
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// 액션 코드 
		 ModelAndView mav = new ModelAndView();
	      
	      int count = 0;
	      ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
	      
	      try
	      {
	         count = dao.count();
	         memberList = dao.list();
	         
	      } catch (Exception e)
	      {
	         System.out.println(e.toString());
	      }
	      
	      mav.setViewName("/WEB-INF/view/MemberList.jsp");
	      mav.addObject("count", count); //"count"라는 이름으로 count를 넘겨줄게
	      mav.addObject("memberList", memberList); //"memberList"라는 이름으로 memberList를 넘겨줄게
	      
	      
	      return mav;
	}


}
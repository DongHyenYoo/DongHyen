/*=================================
	MemberInsertController.java
	- 사용자 정의 컨트롤러 클래스
	- 회원 데이터 추가 액션 처리 클래스
	- DAO 객체에 대한 의존성 주입을 위한 준비.
	 → setter injection
	  ① 인터페이스 형태의 자료형 구성
	  ② setter 구성
==================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.

// implements Controller 또는 extends AbstractController
// -- 서블릿에서 HttpServlet 을 상속받은 서블릿 객체 역할
public class MemberInsertController implements Controller
{
	//Spring 이 제공하는 
	//Controller 인페이스의 handleRequest()메소드 재정의
	
	private IMemberDAO dao;
	
	
	

	public void setDao(IMemberDAO dao)
	{
		this.dao = dao;
	}




	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		//하는 일은 doGet , doPost 와 같다.
		
		//컨트롤러 내부 액션 처리 코드
		int result = 0;
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		
		try
		{
			MemberDTO member = new MemberDTO();
			
			member.setName(name);
			member.setTelephone(telephone);
			
			result = dao.add(member);
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		ModelAndView mav = new ModelAndView();
		
		
		//mav.setViewName("/WEB-INF/view/MemberList.jsp");
			//→MemberListController 가 일을 할 수 있도록 처리
		//     → 이 컨트롤러에 의해 MemberList.jsp가 클라이언트를 만남
		mav.setViewName("redirect:memberlist.action");
		//Spring에게 이것이 리다이렉트를 하는것이니 클라이언트에게 memberlist.action으로 안내해줘라는 의미
		
		return mav;
	}

	
	
}

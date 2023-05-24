package com.test.mvc;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller
{
	
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		  //컨트롤러 내부 액션 처리 코드
	      ModelAndView mav = new ModelAndView();

	      
	      HttpSession session = request.getSession();
	      //session.invalidate();
	      
	      //session.setAttribute("name", null);
	      session.removeAttribute("name");
	      session.removeAttribute("admin");
	      
	      //로그아웃 뷰 페이지(정상적으로 로그아웃 처리되었다는 안내 페이지)
	      //삽입 가능~!!!
	      
	      mav.setViewName("redirect: loginform.action");
	      
	      
	      return mav;

	
	}
	

}

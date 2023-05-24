package com.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller
{

	private IMemberDAO dao;
	
	
	public void setDao(IMemberDAO dao)
	{
		this.dao = dao;
	}
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String admin = request.getParameter("admin");
		
		String name = null;
		
		try
		{
			if(admin == null)
			{
				name = dao.login(id, pw);
			}
			else
			{
				name = dao.loginAdmin(id, pw);
			}
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		if(name == null) // 로그인 실패
		{
			mav.setViewName("redirect:loginform.action");
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			
			if(admin == null) 
			{
				mav.setViewName("redirect:memberlist.action");
			}
			else
			{
				session.setAttribute("admin", "");
				
				mav.setViewName("redirect:memberlist.action");
			}
		}
		
		
		return mav;
	}

	
}

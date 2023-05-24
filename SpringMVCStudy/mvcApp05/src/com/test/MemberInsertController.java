package com.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class MemberInsertController implements Controller
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
		
		
		HttpSession session = request.getSession();
		if(session.getAttribute("name") == null)
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		else if(session.getAttribute("admin") == null)
		{
			mav.setViewName("redirect:logout.action");
			return mav;
		}
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String email = request.getParameter("email");
		String address = request.getParameter("eAddress");

		
		String tel = tel1 + "-" + tel2 + "-" + tel3;
		
		email = email + "@" + address;
		
		
		try
		{
			Member member = new Member();
			
			member.setId(id);
			member.setPw(pw);
			member.setName(name);
			member.setTel(tel);
			member.setEmail(email);
			
			dao.add(member);

			
			mav.setViewName("redirect:memberlist.action");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
		return mav;
	}

	
	
}
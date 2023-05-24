package com.test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MemberListController implements Controller
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
		
		ArrayList<Member> memberList = new ArrayList<Member>();
		
		try
		{
			memberList = dao.list();
			
			mav.addObject("memberList", memberList);
			
			
			mav.setViewName("MemberList");
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
		
		return mav;
	}
	

}

package com.test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class MemberRecordListController implements Controller
{

	private IMemberRecordDAO dao;
	
	public void setDao(IMemberRecordDAO dao)
	{
		this.dao = dao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
	
		
		
		ArrayList<MemberRecord> memberrecordList = new ArrayList<MemberRecord>();
		
		try
		{
			memberrecordList = dao.list();
			
			mav.addObject("memberrecordList", memberrecordList);
			mav.setViewName("MemberRecordList");
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}
}
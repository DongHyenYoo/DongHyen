package com.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MemberRecordInsertController implements Controller
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
		String kor = request.getParameter("kor");
		String eng = request.getParameter("eng");
		String mat = request.getParameter("mat");
		
		MemberRecord memberRecord = new MemberRecord();
		
		memberRecord.setId(id);
		memberRecord.setKor(Integer.parseInt(kor));
		memberRecord.setEng(Integer.parseInt(eng));
		memberRecord.setMat(Integer.parseInt(mat));
		
		dao.add(memberRecord);
		
		mav.setViewName("redirect:memberrecordlist.action");
		
		return mav;
	}
	
	

}

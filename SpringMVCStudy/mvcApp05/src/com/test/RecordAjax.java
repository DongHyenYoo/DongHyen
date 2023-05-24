package com.test;

import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class RecordAjax implements Controller
{
	private IMemberDAO memberDAO;
	
	public void setMemberDAO(IMemberDAO memberDAO)
	{
		this.memberDAO = memberDAO;
	}
	
	private IMemberRecordDAO memberRecordDAO;
	
	public void setMemberRecordDAO(IMemberRecordDAO memberRecordDAO)
	{
		this.memberRecordDAO = memberRecordDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		String id  = request.getParameter("id");
		
		ArrayList<Member> memberList = new ArrayList<Member>();
		ArrayList<MemberRecord> memberrecordList = new ArrayList<MemberRecord>();
		
		String result = "";
		
		try
		{
			memberList = memberDAO.list();
			memberrecordList = memberRecordDAO.list();
			
			for(Member member : memberList)
			{
				if(member.getId().equals(id))
				{
					result="존재하는 학생입니다.";
					break;
				}
				else
				{
					result="이 학생은 존재하지 않습니다.";
				}
			}
			
			if(result.equals("존재하는 학생입니다."))
			{
				for(MemberRecord memberrecord : memberrecordList)
				{
					if(memberrecord.getId().equals(id))
					{
						result="이미 성적이 입력되어있습니다.";
						break;
					}
					else
					{
						result="성적 입력이 가능합니다.";
					}
				}
			}
			
			mav.addObject("result", result);
			mav.setViewName("MemberRecordAjax");
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
	}

	
	
	
	
	
}

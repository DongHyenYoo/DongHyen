/*=================================
	HelloController.java
	- 사용자 정의 컨트롤러 클래스
==================================*/

package com.test.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller                  //-- 이거 쓴 것만으로 controller 역할 수행하게 된다.
public class MemberRecordController
{
	

	/*
	@RequestMapping("/URL 매핑주소"); 디스패처 서블릿에서 하던 URL매핑을 여기서 진행한다.
	public String 메소드이름(매개변수)
	{
		
		// ※ 비즈니스 로직 처리(모델 활용)
		// ...
		
		return "뷰이름.jsp";
		
	}
*/
	
	//데이터베이스로부터 멤버 리스트를 읽어오는 과정
	@RequestMapping("/memberlist.action")
	public String memberList(Model model)
	{
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDAO dao = new MemberDAO();
		
		try
		{
			dao.connect();
			list = dao.list();
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		finally {
			
			try
			{
				dao.disConnection();
			} catch (Exception e)
			{
				System.out.println(e.toString());
				// TODO: handle exception
			}
		}
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/view/MemberList.jsp";
		
	}
	
	//데이터 입력 폼 요청에 대한 처리 과정
	@RequestMapping("/memberinsertform.action")
	public String memberInsertForm()
	{
		String result = "/WEB-INF/view/MemberInsertForm.jsp";
		return result;
		
	}
	
	//데이터 입력 액션 요청에 대한 처리 과정
	@RequestMapping("/memberinsert.action")
	public String memberInsert(MemberDTO dto)
	{
		//Spring Container가 dto에 넘겨받은 데이터 다 set해줘서 dto를 생성해서 넘겨준다.
		
		MemberDAO dao = new MemberDAO();
		try
		{
			dao.connect();
			dao.insertQuery(dto);
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}finally {
			try
			{
				dao.disConnection();
			} catch (Exception e2)
			{
				System.out.println(e2.toString());
			}
		}
		
		
		return "/WEB-INF/view/MemberInsert.jsp";
		
	}
}

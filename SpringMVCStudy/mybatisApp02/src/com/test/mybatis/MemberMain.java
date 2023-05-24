package com.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberMain
{
	//주요 속성 구성
	//mybatis 객체 의존성(자동) 주입!~
	
	@Autowired
	private SqlSession sqlSession;
	
	//세터는 없어도 된다 이제
	
	
	@RequestMapping(value="/memberlist.action", method = RequestMethod.GET)
	public String memberList(ModelMap model)
	{
		//IMemberDAO dao = (IMemberDAO)new MemberDAO();
		//					-----------> 2개 타입 다르니까 명시적으로
		// 이제는 이게 아니라
		IMemberDAO dao = sqlSession.getMapper(IMemberDAO.class);
		// 따라해야하는 인터페이스 속성 넘겨주면 된다.
		// 그럼 인터페이스 반환해준다.
		// → 그럼에도 실제 생성되는 객체는 인터페이스가 아니라, 
		//    memberDAO 객체이다.
		//    dao.count(), dao.list() 쓸 수 있다.
		
		
		model.addAttribute("count", dao.count());
		model.addAttribute("list", dao.list());
		
		return "WEB-INF/view/MemberList.jsp";
	}
	
	@RequestMapping(value="/memberinsert.action", method = RequestMethod.POST)
	public String memberInsert(MemberDTO m)
	{
		IMemberDAO dao = sqlSession.getMapper(IMemberDAO.class);
		
		dao.add(m);
		//-- 알아서 name값과 dto의 속성 이름 같으면 setter로 들어가서 설정되는 거
		//   흐름 파악해야한다.
		
		//return "WEB-INF/view/MemberList.jsp";
		return "redirect:memberlist.action";
	}
	 
	
	@RequestMapping(value="/memberdelete.action", method = RequestMethod.GET)
	/* String mid 대신 MemberDTO m 으로 넘겨도 동일한 결과 나온다 */
	public String memberDelete(MemberDTO m)
	//public String memberDelete(int mid)
	{
		IMemberDAO dao = sqlSession.getMapper(IMemberDAO.class);
		
		dao.remove(m);
		//dao.remove(mid);
		
		return "redirect:memberlist.action";
	}
	

}

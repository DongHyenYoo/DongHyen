package com.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController
{
	@Autowired
	private SqlSession sqlSession;
	
	//매개변수를 등록하는 과정에서 매개변수 목록(인자리스트)에 적혀있는
	//클래스의 객체 정보는 스프링이 제공한다.
	
	//사용자의 요청주소와 메소드를 매핑하는 과정 필요
	// @RequestMapping(value="요청주소", method="전송방식")
	// 이 때, 전송 방식은 폼을 이용한 submit 액션인 경우만 POST
	// 나머지 모든 전송 방식은 GET으로 처리한다.
	
	
	@RequestMapping(value="/studentlist.action", method = RequestMethod.GET)
	public String StudentList(ModelMap model)
	{
		
		String result = null;
		
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
		
		try
		{
			model.addAttribute("studentList", dao.list());
			model.addAttribute("count", dao.count());
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
	  return "WEB-INF/view/StudentList.jsp";
		
	}
	
																//Form을 요청하는건 get방식으로
	@RequestMapping(value="/studentinsertform.action", method = RequestMethod.GET)
	public String studentInsertForm()
	{
		String result = null;
		
		result = "/WEB-INF/view/StudentInsertForm.jsp";
		
		return result;
	}
	
	
	
	@RequestMapping(value="/studentinsert.action",method = RequestMethod.POST)
	public String StudentInsert(StudentDTO dto)
	{
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
		
		try
		{
			dao.add(dto);
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		return "redirect:studentlist.action";
	}
	
	@RequestMapping(value = "/studentupdateform.action", method = RequestMethod.GET)
	public String studentUpdateForm(String sid,Model model)
	{
		String result = null;
		
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
		model.addAttribute("student", dao.search(sid));		
		
		result = "/WEB-INF/view/StudentUpdateForm.jsp";
		
		return result;
	}
	
	@RequestMapping(value = "/studentupdate.action", method = RequestMethod.POST)
	public String studentUpdate(StudentDTO dto)
	{
		String result = null;
		
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
		
		try
		{
			dao.modify(dto);
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		result = "redirect: studentlist.action";
		
		return result;
		
	}
	@RequestMapping(value = "/studentdelete.action", method = RequestMethod.GET)
	public String studentDelete(String sid,Model model)
	{
		String result = null;
		
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
		
		try
		{			
			dao.remove(sid);
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		result = "redirect: studentlist.action";
		
		return result;
		
		
	}
	
	
	
	@RequestMapping(value = "/gradelist.action",method = RequestMethod.GET)
	public String GradeList(ModelMap model)
	{
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		
		try
		{
			model.addAttribute("gradeList", dao.list());
			model.addAttribute("count", dao.count());
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		return "WEB-INF/view/GradeList.jsp";
		
		
	}
	
	@RequestMapping(value = "/gradeinsertform.action", method = RequestMethod.GET)
	public String gradeInsertForm()
	{
		String result = null;
		
		result = "/WEB-INF/view/GradeInsertForm.jsp";
		
		return result;
	}
	
	
	@RequestMapping(value = "gradeinsert.action", method = RequestMethod.POST)
	public String gradeInsert(GradeDTO g)
	{
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		
		try
		{
			dao.add(g);
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		return "redirect:gradelist.action";
		
	}
	
	@RequestMapping(value = "/gradeupdateform.action",method = RequestMethod.GET)
	public String gradeUpdateForm(String sid,Model model)
	{
		String result = null;
		
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		
		try
		{
			model.addAttribute("grade",dao.search(sid));
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		result = "/WEB-INF/view/GradeUpdateForm.jsp";
		
		return result;
		
	}
	
	@RequestMapping(value = "/gradeupdate.action", method = RequestMethod.POST)
	public String gradeUpdate(GradeDTO g)
	{
		String result = null;
		
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		
		dao.modify(g);
		
		result = "redirect:gradelist.action";
		return result;
		
	}
	
	@RequestMapping(value = "/gradedelete.action", method = RequestMethod.GET)
	public String gradeDelete(String sid)
	{
		String result = null;
		IGradeDAO dao = sqlSession.getMapper(IGradeDAO.class);
		
		dao.remove(sid);
		result = "redirect:gradelist.action";
		
		
		return result;
	}

}

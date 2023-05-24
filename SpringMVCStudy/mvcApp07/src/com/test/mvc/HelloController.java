/*=================================
	HelloController.java
	- 사용자 정의 컨트롤러 클래스
==================================*/

package com.test.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//※ Annotation 표기법으로 만든 컨트롤러 객체 지정
//→ 더 이상 Controller interface를 implements 할 필요 없다.
//→ 당연히 그러면 그 안에서 handleRequest()를 overriding 할 필요도 없다.

//※ Spring 이 제공하는 『Controller』 인터페이스를 구현함으로써
// 사용자 정의 컨트롤러 클래스를 구성한다.

@Controller                  //-- 이거 쓴 것만으로 controller 역할 수행하게 된다.
public class HelloController
{
	
	/*
	이제 dispatcher-servlet 에 bean 직접 등록하는 거 사라짐
	→ client 가 요청하는 url도 같이 사라지게 된다.
	~~~.action 에 따라서 어떤 액션하고 property 는 뭘 주입한다는 거 사라짐
	어떤 클래스가 controller야 라는 것도 사라지지만
	어떤 요청이 왔을 때 어떤 controller로 넘길거라는 것도 사라진다.
	 */
	
	// 그럴 때 사용하는게 → RequestMapping
	// 이 컨트롤러 안에서 어떤 액션 수행할 지는 그냥 사용자가 정의하면 된다.
	//※액션 처리를 위해 사용하는 메소드는 사용자가 알아서 정의 /지정
	
	/*
	@RequestMapping("/URL 매핑주소"); 디스패처 서블릿에서 하던 URL매핑을 여기서 진행한다.
	public String 메소드이름(매개변수)
	{
		
		// ※ 비즈니스 로직 처리(모델 활용)
		// ...
		
		return "뷰이름.jsp";
		
	}
*/
	
	  public String helloAct(Model model)
	  {
		  // ※비즈니스 로직 처리(모델 활용)
		  // ...
		  
		  model.addAttribute("hello", "SpringMVCAnnotation Test");
		  
		  return "/WEB-INF/view/Hello.jsp";
	  }
	
	
}

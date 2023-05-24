/*===================================
\\\\\\\\\\\컬렉션 프레임워크/////////
================================*/

/*
컬렉션 프레임워크(Collection Framework)
 = 컬렉션(Collection) + 프레임 워크(Framework)
        |                  환경,틀,약속에 관련된것
        |
        |
    집합 => 소장품,수집품 무리, 더비 수집 수거 (이 모아놓은것들에게 환경을 제공하고 틀을 제공하는 것이 프레임워크)
	
	이들의 구조가 자료구조이다. 그리고 이것을 어떻게 쓰는지 활용하는지가 알고리즘이다.

	
	
	정보
	  - 자료에 근거한 의사결정과 같은것

	자료
	 - 실제 팩트에 의한 것 //실제로 단순한 관찰과 츨정을 통해 수집된 사실이나 개념의 값들 또는 그 값들의 집합.

	 자료구조
	  -자료 처리를 위한 자료의 표현, 저장, 관계 ,관리 및
	  이용에 관한 방법 등의 개념을 이해하여 프로그램에 사용하고
	  컴퓨터에 의해 처리되는 과정에서 적절한 자료의 표현, 구성, 저장 및
	  처리를 위한 알고리즘 작성 및 선택과 이용 방법을 연구하는 분야.

	  컬렉션 프레임워크(Collection Framework)
	  컬렉션(모아놓은 데이터들)의 표현과 조작을 위한 통일된 아키텍처로
	  
	  구성요소는
	  1. 인터페이스(Interface)
		기본적으로 컬렉션에 필요한 데이터 관리 기능을 제공한다.
		예를 들어, list는 추가, 삭제, 검색 등의 기능을 제공하는
		컬렉션 인터페이스가 존재하며
		각 컬렉션마다 고유의 인터페이스가 정의되어 있다.
		
	  2.구현(Implementation)
	    인터페이스를 구현한 클래스로 각 컬렉션을
		실제 어떤 자료구조를 이용하여 표현했느냐에 따라
		컬렉션의 종류가 달라지게 된다.

	  3.알고리즘(Algoriths)
	    각 컬렉션들마다 유용하게 사용될 수 있는 메소드를 의미한다.

	자바의 컬렉션은 견고한 컬렉션 프레임워크 기반 위에 정의되어 있으므로
	각 컬렉션 종류마다 제공되는 메소드의 일관성이 있기 때문에
	한 가지 컬렉션을 익혀두면 다른 컬렉션을 사용하는데 용이하다.

	ex)인터페이스 : list   set  map   유리그릇  사기그릇  세라믹그릇 과 같이 rough한 범위 데이터
	            
									    유리컵
		                               유리접시 


	1. set : 순서가 필요가 없는 데이터를 쓰는것이 set (속이 안보이는 주머니같은것)
	         중복된 데이터를 넘길시 언제담았는지 순서를 모르므로 쓰면안된다.
	         
	2. list :순서가있게끔 자료를 격납할때 쓰는것이 list

	3. map : set과 비슷하나 각 자료마다 구별할 수 있는 label같은것이 붙어있는것 

	  
	알고리즘 : 유리컵 : 컴에 물을 담기 빼기  유리그릇 : 음식을 넣기 빼기등
	         기능과 행동을 의미하는것
	
	구현 : 유리그릇 의 종류 : 유리컵,유리그릇 과 같은 rough데이터의 요소들

*/


/*스택(stack)
	
  
  Stack 클래스는 오브젝트 후입선출(LIFO) 구조의 Stack 을 나타낸다. LIFO(Last Input First Output) 마지막으로 들어간 데이터가 먼저 꺼내진다는 뜻 위로 차곡차곡 쌓이는것이 stack의 구조다.
  이는 벡터(Vector)를 스택으로 처리하는 5개의 메소드로
  벡터(Vector)클래스를 확장하게 된다.

  통상의 push()메소드와 pop() 메소드가 제공되는 것 외에
  스택의 선두 항목으로 peek()을 실시하는 메소드
  스택이 비어있는지의 여부를 확인하는 메소드 isEmpty()
  스택으로 항목을 찾아서 제일 앞으로부터 몇번째인지를 찾아내는 메소드 등이 제공된다.

  스택이 처음으로 작성되었을 때, 항목은 존재하지 않는다.

  -boolean empty()
   스택이 비어있는지 확인한다.
  -E Object peek()
   스택의 맨 위의 객체를 스택에서 제거하지 않고 반환한다.
  -E Object pop()
   스택의 맨 위의 객체를 반환하고 스택에서 제거한다.
  -E Object push(E item)
   객체를 스택 자료구조에 저장한다.
  -int search(Object o)
   스택의 맨 위에서부터 파라미터 값으로 넘겨받은 객체까지의 거리를 반환한다.
   맨 위의 객체의 경우 1을 반환하고 그 아래 객체는 2를 반환하는 형식.

   메모리는 유한한 자원이므로
   컴퓨터 구동시 제일 처음에는 컴퓨터에게 가장 중요한 것들에게 메모리할당 하고

   제일나중에 메모리 할당받는 애들은 음악플레이어 등등의 중요도가 낮은것들이다.
   즉 나중에 메모리를 할당받은 애들일수록 더자주 메모리의 사용량을 확인한다.

   제일 처음에 할당받은 OS에 관련한 리소스일 수록 메모리 사용량 확인하는 시간이 길다.
   
   메소드 리스트를 보면 알겠지만 Stack 구조는 제일 앞에 있는 자료부터 꺼낸다.
*/

//제네릭, 제네릭 표현식
//Stack<String> 와같이 이 Stack자료구조에 String 형을 담아 쓸거라는 라벨을 붙이는것 혹은 Circle등 Stack이 쓰일곳을 표현하는것이다.
//<???>은 즉 stack안의 메소드들의 반환자료형인것이다.

import java.util.Stack;

public class Test154
{
	public static void main(String[] args)
	{
		//Stack 자료구조 생성
		Stack<Object> myStack = new Stack<Object>(); //Stack<Object> myStack = new Stack<Object>(); 즉 대부분의 객체를 stack에 담아낼수 있게됨 하지만 객체가 캐스팅 된다는 점을 고려할때 좋지않는 선언법
		
		String str1 = "임시연";
		String str2 = "장현성";
		String str3 = "정미경";
		String str4 = "조현하";

		//myStack 이라는 Stack 자료구조 안에 str1 ~4 까지 담기
		//add(),push()
		myStack.add(str1);
		myStack.add(str2);
		myStack.push(str3);
		myStack.push(str4);

		String val1 = (String)myStack.peek(); //myStack.peek는 Object형 객체이므로 다운캐스팅 해줘야 val1 에 들어가게 되버린다.
		System.out.println("val1" + val1);
		
		String val2 = (String)myStack.peek(); //peek는 객체를 반환하나 스택에서 제거하지 않으므로 조현하가 사라지지 않아서 계속 같은 결과가 나옴
		System.out.println("val2 : " + val2);

		String value = "";
		
		//myStack 이라는 이름을 가진 Stack 자료구조에
		//데이터가 비어있는 상태가 아니라면..(즉, 채워져 있는 상황이라면)
		//isEmpty()
									//현하 미경 현성 시연
		while(!myStack.isEmpty())	//현하 미경 현성 시연  /미경 현성 시연 / 현성 시연 /시연 /      StringToken에서 봤던것과 같다.
 		{
			value = (String)myStack.pop(); //스택 맨 위의 객체를 반환하나 peek()와 달리 제거한다.
			System.out.println("value : "+ value);
		}
		/*
		value : 조현하
		value : 정미경
		value : 장현성
		value : 임시연
		하나씩 꺼내서 스택에서 제거했으므로 넣은순서의 역순으로 나온다.
		*/


	}
}
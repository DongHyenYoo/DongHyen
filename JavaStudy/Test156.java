/*===================================
■■■컬렉션 프레임워크■■■
================================*/
/*
	ㅇ큐

	큐(Queue)는 선입선출의 FIFO(First Input First Output) 구조로
	먼저 입력된 자료를 먼저 출력하며

	Queue 인터페이스를 구현한 클래스는 큐와 관련한 다양한 기능을 제공한다.

	Queue의 인터페이스 인스턴스를 생성하기 위해서는
	new 연산자를 이용하여 Queue 인터페이스를 구현(Implements)한
	클래스의 생성자를 호출한다.

	ex) Queue ob = new LinkedList(); //Linked List는 Queue 와 list 인터페이스를 Implements하고있고 이 둘의 하위클래스이다.


	ㅇ주요 메소드

	-E element()
	큐의 head 요소를 반환하며 삭제하지 않는다.

	-boolean offer(E o)
	지정된 요소를 큐에 삽입한다.

	-E peek()
	큐의 head요소를 반환하고 삭제하지 않으며
	큐 자료구조가 empty 인 경우 null을 반환

	-E poll()
	큐의 head요소를 반환하고 삭제하며
	큐 자료구조가 empty인 경우 null을 반환한다.

	-E remove()
	큐의 head요소를 반환하고 삭제한다.

*/

import java.util.Queue;
import java.util.LinkedList;
public class Test156
{
	public static void main(String[] args)
	{
		//Queue myQue = new Queue(); // 인터페이스니까 이건 안됨 인터페이스로는 객체생성이 안되나 하위클래스가 추상이 아니라면 하위클래스의 업캐스팅을 통해 객체생성 가능 
		Queue<Object> myQue = new LinkedList<Object>();

		//데이터 준비
		String str1 = "최동현";
		String str2 = "정영훈";
		String str3 = "김태민";
		String str4 = "조현하";

		//myque라는 Queue자료구조에 데이터 추가

		myQue.offer(str1);
		myQue.offer(str2);
		myQue.offer(str3);
		//myQue.offer(str4);

		boolean test = myQue.offer(str4); 
		System.out.println(test); //str4라는 데이터가 적재되었는지 아닌지 true로 반환해서 알려준다.

		//테스트(확인)
		System.out.println(myQue);
		//=>[최동현, 정영훈, 김태민, 조현하] //이들을 더미 or 더미데이터

		//Queue자료구조에서는 head요소가 stack과 같이 출구에 가장가까이 있는 자료가 head 요소이다.

		System.out.println("값 1 : "+(String)myQue.element()); //head요소를 출력하고 제거하지는 않음
		

		System.out.println();

		String val;

		//1.

		//peek()
		//---큐의 head요소 반환, 제거 안함.
		//  큐가 empty 일 경우 null을 반환.
		while(myQue.peek() != null)
		{		//poll()
			//큐의 head 요소 반환. 제거함
			// 큐가 empty일 경우 null 을 반환.
			val = (String)myQue.poll();
			System.out.println("요소 : "+ val);
		}
		System.out.println();

		//다운 캐스팅 업캐스팅에 익숙해지기  위해 코드를 블럭을 잡아서 어떤 자료형인지 를 판단할줄 알아야 이코드가 가능할지 아닐지까지도 판단할 수 있다.

		/*
		while(myQue.poll() != null)
		{		//poll()
			//큐의 head 요소 반환. 제거함
			// 큐가 empty일 경우 null 을 반환.
			val = (String)myQue.poll();
			System.out.println("요소 : "+ val);
		}
		System.out.println();
		
		//2번째인 영훈 4번째인 현하만 출력
			*/
/*
		while(true)
		{
			val = (String)myQue.poll();

			if(val==null)
				break;
			else
				System.out.println("요소 : "+val);
		}
		System.out.println();
*/


		while(!myQue.isEmpty())
		{
			val = (String)myQue.poll();
			System.out.println("요소 : "+val);
		}
		System.out.println();

		



	}
}
/*===================================
■■■컬렉션 프레임워크■■■
================================*/
import java.util.Stack;

public class Test155
{
	//정적 문자열 배열 선언 및 초기화
	private static final String[] colors = {"검정","노랑","초록","빨강","파랑","연두"};

	//생성자
	public Test155()
	{
		//st라는 Stack자료구조 생성
		//제너릭을 활용하여 String데이터를 Stack에 담아 쓰겠다고 선언
		Stack<String> st = new Stack<String>();

		//st라는 Stack 자료구조에 데이터(colors) 담기
	
	//	st.push(colors[0]); 이렇게 죽 나열해도 댐


		for(String i : colors)
			st.push(i);

		st.push("보라");

		//st.push(10); //제네릭 으로 String을 선언했기에 일어나는 문제다.
			//에러 발생(컴파일 에러)
			//제네릭 표현식을 통해 선언된 자료형과 다른 자료형을 add하려고 하니 에러

		popStack(st);
	}

	private void popStack(Stack<String> st)
	{
		System.out.print(" pop : ");
		while(!st.empty())  //isEmpty()
		{
			System.out.print(st.pop()+" ");

		}
		System.out.println();

	}

	public static void main(String[] args)
	{
		new Test155();



	}
}
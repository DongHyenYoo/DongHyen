/*===================================
■■■컬렉션 프레임워크■■■
================================*/
import java.util.Queue;
import java.util.LinkedList;

public class Test157
{
	
	private static final String[] colors = {"검정","노랑","초록","빨강","파랑","연두"};

	public static void main(String[] args)
	{
		Queue<String> qu = new LinkedList<String>();
		// Queue 인터페이스 기반의 인스턴스를 생성하기 위해서는
		//new 연산자를 이용하여 Queue 인터페이스를 implements 한
		// 하위 클래스의 생성자를 호출해야 한다.

		//qu 라는 Queue 자료구조에
		//colors 배열의 데이터 입력
		
		for(String i : colors)
			qu.offer(i);

		//qu라는 Queue 자료구조의 모든 데이터 전체 출력

		System.out.print("색 : ");
		while(qu.isEmpty()==false)
		{
			System.out.print(qu.poll()+"  ");
			
			

		}

	}
}
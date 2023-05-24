/*===================================
■■■컬렉션 프레임워크■■■
================================*/
import java.util.Vector;
public class Test161
{
	private static final String[] colors = {"검정","노랑","초록","빨강","파랑","연두"};

	public static void main(String[] args)
	{
		Vector<String> v = new Vector<String>();

		//벡터 자료구조 v 에 colors 배열 데이터를 요소로 추가

		for(String color : colors)
			v.add(color);

		//벡터 자료구조 v의 전체 요소 출력
		System.out.print("전체 요소 출력 : ");
		
		for(String vi : v)
			System.out.print(vi + "  ");
		System.out.println();

		String s1 = "분홍";

		//indexOf()

		int i = v.indexOf(s1);
		System.out.println(s1 + "의 위치는 "+i); //-1 당연히 벡터에 안넣었으니까

		String s2 = "노랑";
		
		//v.contains(s) 
		//벡터 자료구조 v에 찾고자 하는 s 가 포함되어 있다면..
		//index 위치 확인 해서 true false

		if(v.contains(s2))
		{
			i = v.indexOf(s2);
			System.out.println(s2+ " -> index위치 :  "+i);

			v.remove(i);// 우선 index를 찾고 그걸 매개변수로 넘겨서 이렇게 제거해야됨 1.존재하는지 찾기 2.어디에 있는지 확인하고 3.확인했으면 삭제해라.
			
		}

		System.out.print("삭제후 전체 요소 출력:");
			for(String vi : v)
			System.out.print(vi + "  ");
		System.out.println();

		//System.out.println(v);
		//확인용 더미 데이터는
		//실제 요소가 아니기에
		//이를 활용하여 연산을 진행하고 처리해서는 안된다.


		
	}
}
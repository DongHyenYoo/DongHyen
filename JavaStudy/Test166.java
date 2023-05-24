/*===================================
■■■컬렉션 프레임워크■■■ 
================================*/

/*
  List 인터페이스
  -순서가 존재한다.,배열과 유사하다,데이터적인 측면에서 중복을 허용
  -주요 구현 클래스
   Vector(동기화 지원)
   ArrayList(동기화 지원x)
   LinkedList(체인.링크,결합,큐) 즉 앞의 데이터가 나가지 않으면 뒤도 못나가듯이 서로 연결되어있다.


*/
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
public class Test166
{
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();

		list.add("서울");
		list.add("부산");
		list.add("인천");
		list.add("대구");
		list.add("광주");
		list.add("대전");
		list.add("울산");
		list.add("세종");
		
		System.out.println(list);

		System.out.println(list.size());

		System.out.println("첫번째 요소 : "+list.get(0));

		System.out.println("마지막 요소 : "+list.get(list.size()-1));

		list.add(0,"한국");
		System.out.println(list);
		//더미 확인

		list.set(0,"대한민국");
		System.out.println(list);
		//더미 확인

		if(list.contains("서울"))
		{
			System.out.println("서울 존재");
		}
		int n = list.indexOf("서울");
		System.out.println("서울의 위치" +n);
		
		//list.remove("대한민국");
		//System.out.println(list);

		list.remove(0);
		System.out.println(list);

		System.out.println("전체 출력: ");
		for(int idx=0;idx<list.size();idx++)
		{
			System.out.print(list.get(idx)+" ");
		}
		System.out.println();


		System.out.println("역순 출력 : ");
		for(int idx=list.size()-1;idx>=0;idx--)
		{
		System.out.print(list.get(idx)+ "  ");
		}
		System.out.println();

		System.out.println("전체출력 방법2 :");
		for(String s : list)
		{
			System.out.print(s + " ");

		}
		System.out.println();

		System.out.println("전체 출력 방법 3 : ");
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			String s = it.next();
			System.out.print(s+ "  ");
		}
		System.out.println();


		System.out.println("전체출력 방법 4: ");
		ListIterator<String> li = list.listIterator();
		while(li.hasNext())
		{
			System.out.print(li.next() + " ");
		}
		
		System.out.println();

		System.out.println("역순 출력방법 2번째 ");
		while(li.hasPrevious())
		{
			String s = li.previous();
			System.out.print(s+"  ");
		}
	}
}
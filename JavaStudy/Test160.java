/*===================================
■■■컬렉션 프레임워크■■■
================================*/

import java.util.Vector;
import java.util.Iterator;
import java.util.Collections;


public class Test160
{
	private static final String[] colors = {"검정","노랑","초록","빨강","파랑","연두"};



	public static void main(String[] args)
	{

		Vector<String> v = new Vector<String>();

		for(String color : colors)
		{
			v.add(color);
		}

		System.out.println("첫번째 요소 : " + v.firstElement());
		System.out.println("두번째 요소 : " + v.get(1));
		System.out.println("마지막 요소 : " + v.lastElement());
		System.out.println("요소의 개수 : " + v.size());

		//첫 번째 요소를 "하양"으로 변경하기

		v.set(0,"하양"); //덮어쓰기

		System.out.println("두번째 요소 : "+v.get(1));
		

		//첫번째 요소에 주황을 추가하고싶다.

		v.add(0,"주황");
		//v.insertElementAt("주황",0);
		System.out.println(v.firstElement());
		System.out.print("전체 출력 : ");
		for(String str : v)
			System.out.print(str + "  ");
		
		//오름차순 정렬
		Collections.sort(v); //Collection 을 아우르는 Collections라는 것이있고 그것에 정적메소드 sort
		
		System.out.println();
		System.out.print("전체 출력 : ");
		for(String str : v)
			System.out.print(str + "  ");
		//전체 출력 : 노랑  빨강  연두  주황  초록  파랑  하양


		//검색
		//Collections.binarySearch();
		//검색기능을 수행
		//단, 오름차순 정렬이 되어있지 않다면 찾지 못한다. 즉 오름차순 정렬후 사용해야함
		//검색 결과가 존재하지 않을경우 음수를 반환

		System.out.println();
		int idxBlue =Collections.binarySearch(v,"파랑");
		System.out.print(idxBlue);//위치한 인덱스의 위치가 나온다.

		int idxNavi = Collections.binarySearch(v,"남색");
		System.out.print(idxNavi); //없어서 음수가 나옴


		//내림차순 정렬을 하는 메소드는 없다.
		Collections.sort(v,Collections.reverseOrder());
		
		System.out.println();
		System.out.print("전체 출력 : ");
		for(String str : v)
			System.out.print(str + "  ");

		System.out.println(Collections.binarySearch(v,"파랑")); //-8이라는 음수가 나옴 검색결과가 없다는 뜻

		Collections.sort(v,Collections.reverseOrder());
		
		System.out.println();
		System.out.print("전체 출력 : ");
		for(String str : v)
			System.out.print(str + "  ");
		
		idxBlue =Collections.binarySearch(v,"파랑",Collections.reverseOrder()); //찾을때 뒤집어서 찾아라
		System.out.println(idxBlue);



		

		
		


	}
}
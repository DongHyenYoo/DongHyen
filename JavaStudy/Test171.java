/*===================================
■■■컬렉션 프레임워크■■■ 
================================*/

//Map -> Hashtable, HashMap


/*

- java.util.Map 인터페이스는  //pair 즉 항상 짝꿍이 존재한다.
  키(key)를 값(value)에 매핑(mapping)하여 
  동일한 키를 등록할 수 없고, 유일해야 하며,
  각 키는 한 개의 값만을 매핑해야한다.
  즉, 하나의 키에 대응하는 하나의 값을 갖는 자료구조이다.
  
*/

/*
  HashMap<key,value>클래스
  -Hashtable 클래스와 마찬가지로 Map 인터페이스에서 상속받은
   HashMap 클래스의 기능은 Hashtable 과 동일하지만
   Synchronization 이 없기 때문에 동시성 문제가 없다면
   (즉, 멀티 스레드 프로그램이 아닌 경우라면) Multi Thread Unsafty
   HashMap을 사용하는것이 성능을 향상시킬수 있다.

   -또한 HashMap은 Hashtable 클래스와 달리 null을 허용한다.



*/
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test171
{
	public static void main(String[] args)throws IOException
	{
		//HashMap 자료구조 인스턴스 생성
		//HashMap<String, String>map = new HashMap<String,String>();
		Map<String,String> map = new HashMap<String,String>(); //HashMap은 클래스고 Map은 인터페이스이다. 즉 인터페이스 생성자를 불러오는것이 아니므로 객체 생성가능하다.
																//인터페이스의 생성자를 불러와 객체 생성하는게 아님을 기억
		

		//map 이라는 HashMap 자료구조에 요소 추가
		// put();
		map.put("영화","범죄도시2");
		map.put("드라마","이태원클라스");
		map.put("만화","슬램덩크");
		
		System.out.println(map);
		//{드라마=이태원클라스, 영화=범죄도시2, 만화=슬램덩크} 더미 출력 key와 value와 매핑되어있다.

		//데이터 요소 격납 순서가 추가 순서와 관계 없음
		//어짜피 key를 통해 꺼낼것이므로 순서가 의미없음 즉 뒤섞여도 상관이 없다.

		//null관련 처리
		//아래의 데이터 입력 유형에 따라 모든 종류의 데이터 입력이 가능하지만
		//마지막 null을 key로 매핑된 "모나리자"rk
		//최초 null을 key로 매핑하는 null을 덮어쓰는 상황이 일어난다.
		//즉 HashMap은 null을 하나의 고유한 key로 간주한다.


		map.put(null,null);
		System.out.println(map); //더미확인
		

		//테스트(확인) -> 더미 확인
		//{null=null, 드라마=이태원클라스, 영화=범죄도시2, 만화=슬램덩크}

		//value 가 null
		map.put("동화",null);
		//테스트(확인) -> 더미 확인
		System.out.println(map);
		//{null=null, 드라마=이태원클라스, 영화=범죄도시2, 동화=null, 만화=슬램덩크}

		//key가 null
		map.put(null,"모나리자");
		System.out.println(map);
		//{null=모나리자, 드라마=이태원클라스, 영화=범죄도시2, 동화=null, 만화=슬램덩크}2


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("카테고리, 타이틀 입력(컴마 구분) : ");
		String[] temp;
		for(String str; ((str = br.readLine()) != null);)
		{
			temp = str.split(",");
			if(temp.length<2)
			{
				System.out.print("카테고리,타이틀 입력");
				continue;
			}

		    map.put(temp[0].trim(), temp[1].trim());
			System.out.println(map);
			
		
		}

	}
}
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
 - Hashtable<K,V> 클래스 <Key, Value>

   -해시테이블 구조를 객체 모델한 클래스로
     검색이 용이하기 때문에 사용 빈도가 높은 편에 속한다.

   - 해시테이블이란 키(key)와 그에 상응하는 데이터(value)로
     구분된 데이터 구조이다.

   - 데이터를 저장하고, 검색하기 위해서 키(key)로 접근하며
     이구조에서는 키 값을 부여하면 해당 데이터가 반환된다.

   - 또한, Hashtable 클래스는 key 또는 value의 값으로 null을 허용하지 않는다.
*/

import java.util.Hashtable;
public class Test170
{
	private static final String[] names = {"조현하","민찬우","최나윤","고연수","정영준","반보영"};
	private static final String[] tels = {"010-7202-6306","010-2546-0266","010-7236-0813","010-4016-6208","010-4051-5510","010-3578-3912"};


	public static void main(String[] args)
	{
		//Hashtable 자료구조 인스턴스 생성
		Hashtable<String,String> ht = new Hashtable<String,String>();

		//ht 라는 Hashtable 자료구조에
		//배열(names,tels)에 담겨있는 데이터를 요소로 담아내기
		//put(key,value) 메소드;
		for(int i=0; i<names.length; i++)
		{
			ht.put(names[i],tels[i]);

		}

		//ht라는 Hashtable 자료구조에서
		//key를 이용하여 데이터 검색
		//get(key);
		String findName1 = "정영준";
		String str = ht.get(findName1);
		if(str != null)
		{
		System.out.println(findName1+"의 전화번호는 "+str);
		}
		else
			{
				System.out.println("그건없음");
			}
			System.out.println();

		//사전에 Hashtable 자료구조에 key가 존재하는지의 여부 확인
		//containsKey()
		String findName2 = "최동현";
		if(ht.containsKey(findName2))
		{
			System.out.println("데이터가 존재");
		}
		else
		{
			System.out.println("해당요소는 존재하지않음");
		}
		//최동현 데이터가 존재하지 않습니다.

		String findName3 = "최나윤";
		if(ht.containsKey(findName3))
		{
			System.out.println(findName3+"은(는)존재한다");
		}
		else
		{
			System.out.println("없엉");
		}

		//ht라는 Hashtable 자료구조에... value가 존재하는지의 여부 확인
		//contains()
		String findTel1 = "010-3578-3912";
		if(ht.contains(findTel1))
		{
			System.out.println(findTel1 + "데이터가 존재합니다.");
		}
		else
		{
			System.out.println(findTel1 + "데이터가 존재하지 않습니다.");
		}
		System.out.println();
		//010-2546-0266 데이터가 존재합니다.

		//ht 라는 Hashtable 자료구조에서 반보영 데이터 삭제
		//remove()
		ht.remove("반보영");
		//remove메소드는 인자값으로 key를 넘겨받으나 이때 key와 연결되어있는(매핑되어있는) value 값도 함께 없어진다.

		//삭제 이후 key가 존재하는지 확인
		if(ht.containsKey("반보영"))
			System.out.println("보영이가 존재");
		else
			System.out.println("없엉");

		//삭제 이후 value값이 존재하는지 확인
		
		if(ht.contains("010-3578-3912"))
			System.out.println("보영의 전화번호 있음");
		else
			System.out.println("아니");

		//null관련 처리 null = '아무것도 없다는 것의 상태값' 즉 우리나라에서쓰는 '존재하지 않는다' 와는 다른의미 '공백이 채워져있다는 것'이라고 의미하면 될듯
		//ht.put(null,null); //key 와 value 모두 null의 값
		//Exception in thread "main" java.lang.NullPointerException
		//at java.util.Hashtable.put(Hashtable.java:460)런타임 에러 발생
		
		//ht.put("도규희",null); //value에 null대입
		//Exception in thread "main" java.lang.NullPointerException
		
		//ht.put(null,"010-1234-5678");
		////Exception in thread "main" java.lang.NullPointerException
		
		//중복된 key 입력
		ht.put("민찬우","010-1222-2222"); //그냥 실행되버렸는디

		System.out.println(ht.get("민찬우"));
		//그냥 덮어쓰기가 됬다.
		//즉 중복된 key를 사용할경우 value 값이 덮어쓰기가된다.

		//중복된 value 입력
		ht.put("김태민","010-7202-6306");
		System.out.println(ht.get("조현하"));
		//조현하의 전화번호는 그대로 나온다.
		System.out.println(ht.get("김태민"));
		//태민이의 전화번호도 그대로나온다.
		//즉 value의 중복은 기존 데이터에 아무 영향을 미치지않는다.
		
		



	}
}
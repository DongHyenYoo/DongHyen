/*===================================
■■■컬렉션 프레임워크■■■ 
================================*/

//Set -> HashSet, TreeSet

//순서 없음.
//중복을 허용하지 않는 구조(기본)

/*
	TreeSet<E>클래스

	java.util.TreeSet<E>클래스

	java.tuil.TreeSet<E>클래스는
	Set 인터페이스를 상속산 SortedSet 인터페이스를 구현한 클래스로
	데이터를 추가하면 데이터들이 자동으로 오름차순 정렬이 된다. -> 성능저하

	
*/
//Vo = Value Object 비즈니스 로직을 포함하고 있는 객체 실무에서는 VO와 DTO를 딱히 구분하지 X
//DTO = Data Transfer Object 데이터 를 담아 한쪽 계층에서 처리후 다른쪽으로 전송 및 수신해서 보관
//DAO = Data Access Object 받은 DTO를 어떻게 처리할지 결정하는것을 DAO라고한다.

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;

class GradeVo
{
	private String hak;		  //학번
	private String name;      //이름
	private int kor, eng, mat;//국어,영어,수학 점수


	//생성자(사용자 정의 생성자) //5개의 매개변수를 가진 생성자
	GradeVo(String hak, String name, int kor, int eng, int mat)
	{
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;

	}
	//default 생성자 자동 사입 안되므로 default모양의 매개변수 없는 생성자를 사용자 정의로 만듬
	//매개변수가 존재하는 생성자를 사용자 정의 생성자로 구성하였기 때문에
	//default 생성자가 자동으로 삽입되지 않을 것을 우려하여
	//추가로 정의한 생성자


	GradeVo()
	{
		this("","",0,0,0);

	}

	public String getHak()
	{
		return this.hak;
	}
	public void setHak(String hak)
	{
		this.hak = hak;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}


	public int getKor()
	{
		return this.kor;
	}
	public void setKor(int kor)
	{
		this.kor = kor;
	}


	public int getEng()
	{
		return this.eng;
	}
	public void setEng(int eng)
	{
		this.eng = eng;
	}


	public int getMat()
	{
		return this.mat;
	}
	public void setMat(int mat)
	{
		this.mat = mat;
	}

	//추가 메소드 정의(총점 산출)
	public int getTot()
	{
		return this.kor+this.eng+this.mat;
	}
	
	


}

class MyComparator<T> implements Comparator<T> //컴페레터가 가지고있는 Compare메소드를 재정의하기 위한 것  //<T>가 의미하는것은 비교될 대상의 type이다.
{
	@Override

	public int compare(T o1, T o2) //compare 메소드 재정의
	{
		GradeVo s1 = (GradeVo)o1;
		GradeVo s2  = (GradeVo)o2; 
		/*
		//학번 기준(오름차순)
		return Integer.parseInt(s1.getHak()) - Integer.parseInt(s2.getHak()); //둘의 학번을 정수형으로 변환뒤 빼서 비교할수 있게하겠다.
		// Integer.parseInt(2206113) - Integer.parseInt(2206115);  = -2 가 나오고 앞의 -를 보고 뒤의 값을 가진 객체를 더 크게 인식하게만든다.

		//내림차순 구성하려면
		return Integer.parseInt(s2.getHak()) - Integer.parseInt(s1.getHak()); //+이므로 결과가 내림차순 정렬되어 나옫ㄴ다.
	*/
		//총점 기준 (오름차순)
		//	return s1.getTot() - s2.getTot();
		//총점 기준 (내림차순)
		return s2.getTot() - s1.getTot();

		//이름 기준 (오름차순)
		//return s1.getName().compareTo(s2.getName());
		
		//이름 기준(내림차순)
		//return s2.getName().compareTo(s1.getName());
		
	}
}

public class Test169
{
	public static void main(String[] args)
	{
		TreeSet<String> set = new TreeSet<String>();

		set.add("귀멸의칼날");
		set.add("명탐정 코난");
		set.add("하이큐");
		set.add("너의 이름은");
		set.add("포켓몬");
		set.add("센과 치히로의 행방불명");
		set.add("디지몬어드벤처");
		set.add("이웃집토토로");
		set.add("아이공룡둘리얼음별대모험");
		set.add("러브라이브");
		

		//Iteraotr 를 활용한 전체출력
		Iterator<String> it = set.iterator();

		while(it.hasNext())
		{
			System.out.print(it.next()+"  ");

		}
		System.out.println();
		//가나다 순으로 정렬해준다.
		//요소를 문자열로 구성할 경우
		//가나다순 -> 오름차순 정렬
		
		//TreeSet 자료구조 인스턴스 생성

		//TreeSet<GradeVo> set2 = new TreeSet<GradeVo>();
		//위와같이 compare를 Override 한후
		//다시 생성
		TreeSet<GradeVo> set2 = new TreeSet<GradeVo>(new MyComparator<GradeVo>()); 
		//TreeSet의 생성자에게 정렬 기준을 넘겨준다. 즉 내가 정한기준을 통해 자료를 정렬 할 수있음.

/*
		//TreeSet 자료구조 set2에 요소 추가
		set2.add(new GradeVo("2206113","도규희",90,80,70)); //Exception in thread "main" java.lang.ClassCastException: GradeVo cannot be cast to java.lang.Comparable 에러발생 
		set2.add(new GradeVo("2206115","최동현",91,81,71)); //TreeSet은 정렬을 하는 기능을 자동적으로 수행하고 저렇게 객체를 생성해버리면 특정한 값을 통해 비교를 하여 정렬을 수행할 수 없게된다.
		set2.add(new GradeVo("2206128","김인교",88,78,68)); //
		set2.add(new GradeVo("2206139","조영관",70,60,50));
		set2.add(new GradeVo("2206150","민찬우",99,82,72));

		Iterator<GradeVo> it2 = set2.iterator();

		while(it2.hasNext())
		{
			System.out.print(it2.next().getName()+"  ");
		}

*/	

		set2.add(new GradeVo("2206113","도규희",90,80,70)); 
		set2.add(new GradeVo("2206115","최동현",90,80,70)); 
		set2.add(new GradeVo("2206128","김인교",88,78,68)); 
		set2.add(new GradeVo("2206139","조영관",70,60,50));
		set2.add(new GradeVo("2206150","민찬우",99,82,72));

		Iterator<GradeVo> it2 = set2.iterator();

		while(it2.hasNext())
		{
			GradeVo vo =it2.next();
		
			System.out.println(vo.getHak()+"  "+vo.getName()+"  "+vo.getKor()+"  "+vo.getEng()+"  "+vo.getMat()+"  "+vo.getTot());
		
		}

		//char y = '뷁';
		//System.out.println((int)y);
		//출력해보면 학번기준으로 오름차순으로 정렬되어있다.

		//총점 기준 내림차순

		/*
		2206150  민찬우  99  82  72  253
		2206115  최동현  91  81  71  243
		2206113  도규희  90  80  70  240
		2206128  김인교  88  78  68  234
		2206139  조영관  70  60  50  180
		*/

		/*총점 기준 오름차순
		2206139  조영관  70  60  50  180
		2206128  김인교  88  78  68  234
		2206113  도규희  90  80  70  240
		2206115  최동현  91  81  71  243
		2206150  민찬우  99  82  72  253

		*/
		
		/*
		String dlfma1 = "유동현";
		String dlfma2 = "쥬동현";

		System.out.println(dlfma1.compareTo(dlfma2)); 
		//-588 1을 기준으로 1이 전의 한글이면 - 반환

		System.out.println(dlfma2.compareTo(dlfma1));
		//+588 
		*/
		//String dlfma1 = "유동현";
		//String dlfma2 = "규동현";

		//System.out.println(dlfma1.compareTo(dlfma2));
		//6468 1이 후의 한글이면 +




	}
}
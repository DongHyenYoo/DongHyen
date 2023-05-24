/*===================================
■■■컬렉션 프레임워크■■■ 매우매우 중요한 부분이라고하심
================================*/

//자료구조 객체 선언 및 생성 시
//사용자 정의 클래스 활용
//-> 자료형
//가장 자주쓰는 것은 Collection에 우리가 만든 class를 객체로서 담는것을 제일 많이 쓴다.

//클래스 -> 사용자 정의 자료형으로 활용
/*
1.속성만 존재하는 클래스
        |
2.사용자 정의 자료형 활용
        |
3.Data Transfer Object (DTO)
        |
4.Bean 

이들모두 결과적으로 1이다.
*/
import java.util.Vector;
import java.util.Iterator;
class MyData
{
	//주요 속성 구성 = 주요 변수 선언(멤버 변수)
	private String name;
	private int age; //기본적으로 클래스안에서만 쓸 변수는 private로 자동으로 써야한다.
	
	//getxxx() = getter
	//setxxx() = setter

	//getter / setter 구성 보통 public

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	
	public MyData(String name,int age)
	{
		this.name = name;
		this.age = age;
	}

	//사용자 정의 생성자가 구성될 경우 디폴트 생성자는 자동으로 삽입 안된다는걸 기억하자.
	//default 생성자 형태의 생성자를 사용자 정의 생성자로 
	//추가 구성하게 되는 것이 일반적인 클래스 설계 과정
	//(반드시 설계해야 한다는 문법적인 규칙은 없음)

	//생성자(매개변수 없는 생성자) -> 사용자 정의 생성자

	public MyData()
	{
		this("",0); //MyData("",0); 
		//name = "";
		//age = 0;
	}

	


	

}

public class Test162
{
	public static void main(String[] args)
	{
		
		Vector<MyData> v = new Vector<MyData>(); //MyData자료형을 Vector에 담을 것이다.
/*		
		MyData[] arr = new MyData[3];

		arr[0] = new MyData("정영준",13);
		arr[1] = new MyData("정미경",7);
		arr[2] = new MyData("한은영",3);
		
		
		for(int i=0;i<arr.length;i++)
		v.add(arr[i]);
		

		for(int i=0;i<3;i++)
		{
			String name = v.elementAt(i).getName();
			int age = v.get(i).getAge(); 
			System.out.println(name+"  "+age+"세");

		}
		*/
/*1
		MyData st1 = new MyData();
		st1.setName("정영준");
		st1.setAge(13);
		v.add(st1);

		MyData st2 = new MyData();
		st2.setName("정미경");
		st2.setAge(7);
		v.add(st2);

		MyData st3 = new MyData();
		st2.setName("한은영");
		st2.setAge(3);
		v.add(st3);
*/
/*2
		MyData st1 = new MyData("정영준",13);
		v.add(st1);
		MyData st2 = new MyData("정미경",7);
		v.add(st2);
		MyData st3 = new MyData("한은영",3);
		v.add(st3);

*/

		v.add(new MyData("정영준",13));
		v.add(new MyData("정미경",7));
		v.add(new MyData("한은영",3));
		
		/*
		for(MyData obj : v) //v에서 MyData형 obj를 꺼낸다.
		System.out.printf("이름 : %s  나이 : %d세\n",obj.getName(),obj.getAge());
*/

		for(Object temp :v) //vector에서 하나씩 MyData형 객체를 꺼내면 Object로 업캐스팅이 일어난다.
		{					//즉 출력할땐 다운캐스팅을 해줘야한다.
			System.out.printf("이름 : %s, 나이 %d세\n",((MyData)temp).getName(),((MyData)temp).getAge());		
		}

		
		
		


			


	}
}
/*===================================
■■■컬렉션 프레임워크■■■
================================*/

//Vector v = new Vector();
//--안에 요소들은 비어있는 Vector 자료구조 v 생성

//벡터의 생성자에 정수형태를 입력한다면
//Vector v = new Vector(8);
//--8개의 초기 elements 를 가진 Vector 자료구조 v 생성
//이 자료구조를 활용하는 과정에서
//8개가 모두 채워지게 되면 자동으로 확장시켜준다.

//Vector v = new Vector(3,5);
// 3개의 초기elements를 가진 Vecotr 자료 v 생성
//자료구조를 활용하는 과정에서
//3개가 모두 채워지게 되면 자동으로 5개가 증가된다.

//벡터는 데이터 요소로서 정수형,실수형,문자열,등을 
// 담아내는 것이 가능해졌다.
// 데이터 안정성을 확보 check를 해가면서 자료구조를 다뤄야 한다.
import java.util.Vector;
import java.util.Iterator;
class MyVector extends Vector<Object>//설계하면서 Vector 클래스를 상속해서 설계
{
	//생성자
	MyVector()
	{
		
		//Vector(슈퍼 클래스)의 생성자를 호출할것
		//super(); 가 자동으로 삽입됨
		//->Vector();
		super(1,1);
		//첫번째 인자 = 주어진 용량
		//두번째 인자 = 증가량
		

	}

	void addInt(int i)
	{
		addElement(new Integer(i));
	}

	void addFloat(float f)
	{
		addElement(new Float(f));
	}
	void addString(String s)
	{
		addElement(s);
	}
	void addCharArray(char[] a)
	{
		addElement(a);
	}
	void addObject(Record rec)
	{
		addElement(rec);
	}
	
	void write()
	{
		/*
		Iterator<Object> vi = this.iterator(); //this는 MyVector다...
	
	while(vi.hasNext())
		{
		System.out.println(vi.next());
		}*/
      /*
		Object o;
		int length = size();

		System.out.println("벡터 요소 갯수 : " + length);

		for(int i=0;i<length; i++)
		{
			o= elementAt(i);
			System.out.println(o);
		} //위에 한거랑 결과가 같다.. Iterator쓴거랑 결과가 같음 //이렇게 뒤죽박죽 쓸거같아서 제네릭이라는 것이 존재하는것
		*/

		Object o;
		int length = size();

		System.out.println("벡터 요소 갯수 : "+length);
		
		for(int i=0;i<length;i++)
		{
			o = elementAt(i);
			
			//instanceof 연산자
			//처리해야 하는 대상의 객체 타입 확인

			if(o instanceof char[])
			{
				//System.out.println("문자배열 : " + o);
				//System.out.println("문자배열 : "+o.toString());
				System.out.println("문자배열 : " +String.copyValueOf((char[])o)); //char[]로 다운캐스팅 한것이고 String클래스의 static 메소드인 copyValueOf라는 문자열 형태로 문자배열을 뽑아내주는 메소드이다.
			}
			else if(o instanceof String)
			{
				System.out.println("문자열 : " + o);
			}
			else if(o instanceof Integer)
			{
				System.out.println("정수형 : " + o);
			}
			else if(o instanceof Float)
			{
				System.out.println("실수형 : " + o);
			}
			else
			{
				System.out.println("type 확인 불가~!!!!");
			}

		}

	}

}

public class Test159
{
	public static void main(String[] args)
	{
		
		MyVector v = new MyVector();

		int digit = 5;
		float real = 3.14f;
		String s = new String("안녕하세요");
		char[] letters = {'s','t','u','d','y'};

		v.addInt(digit);		//벡터 자료구조에 정수 저장
		v.addFloat(real);		//벡터 자료구조에 실수 저장
		v.addString(s);			//벡터 자료구조에 문자열 저장
		v.addCharArray(letters);//벡터 자료구조에 문자 배열 저장
		v.write();



		//Object ob = 10; 은 첫번째 10이 Integer(10)으로 오토 박싱이 한번일어나고 (Object)(Integer(10)으로 업캐스팅이 한번 일어나서 되는것
	}
}
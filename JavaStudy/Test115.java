/*===================================
클래스 고급
-추상 클래스(abstract)
================================*/

/*
설계도가 완성되지 않은 클래스를 추상 클래스라고 한다.

이것도 오로지 상속을 위해서만 만들어진 클래스이다.

추상 클래스는
 선언만 있고 정의가 없는 하나 이상의 메소드(추상 메소드)를 가지는 클래스로
 하위클래스(자식 클래스)에서 오버라이딩 할 것으로 예상되는 메소드에 대해
 메모리 낭비 없이 미리 호출 계획을 세워두기 위해 만든다.

 형식 및 구조
 [접근제어지시자] abstract class 클래스명
 {

	[접근제어지시자] abstract 자료형 메소드명([매개변수],...); 
	
	//이것이 추상메소드로 {}를 쓰지않고 바로;을 찍은형태이다. 동시에 하는 기능도 없다.
	이것이 하나라도 들어있다면 클래스앞에 abstract를 넣어야한다.
	그러면 이 클래스를 통해 객체를 생성할 수 없다.

	단 추상메소드가 없어도 class앞에 abstract를 붙여 추상클래스가 될수 있다.
	다만 이때도 객체는 생성할 수 없다.

	다만 이 추상메소드를 상속받은 클래스에서 추상 메소드를 오버라이드 하게되면
	자식클래스는 더이상 추상 클래스가 아니게 된다.

	다만 추상 메소드를 오버라이드 하지 않는다면 자식클래스도 앞에 abstract를 붙여
	추상 클래스임을 알려야한다.

}

 특징
  
 클래스가 적어도 하나 이상의 추상 메소드를 포함할 때
 그 클래스는 클래스 앞에 abstract 키워드를 붙여
 추상 클래스로 명시해야 하며
 추상 클래스로 선언한 경우
 불완전한 형태의 클래스이므로 객체를 생성할 수 없다.
 추상 메소드가 존재하지 않는 추상 클래스마저도
 객체를 생성할 수 없는것이다.

 즉,추상 클래스는 독립적으로 존재할 수 없기 때문에
 상속을 위해서만 존재하며
 추상 클래스를 상속받은 하위 클래스에서는
 반드시 추상 메소드를 오버라이딩(재정의)해야 한다.

 abstract 키워드는
 클래스와 메소드에서만 사용할 수 있으며
 멤버 변수와 로컬 변수에서는 사용할 수 없다.


*/
abstract class SortInt115
{
	private int[] value;

	protected void sort(int[] value)
	{
		this.value = value;
		sorting();
	}

	protected abstract void sorting(); //추상메소드


	protected int dataLength()
	{
		return value.length;
	}

	protected final int compare(int i,int j)
	{
		int x = value[i];
		int y = value[j];

		if(x==y)
			return 0;
		else if(x>y)
			return 1;
		else
			return -1;
	}
	//final 키워드로인해 자식클래스에서 override 할수없다.
	protected final void swap(int i, int j)
	{
		int temp = value[i];
		value[i] = value[j];
		value[j] = temp;
	}
}
public class Test115 extends SortInt115
{
	int i,j;

	static int[] data = {7,10,3,28,7};

	@Override
	protected void sorting()
	{
	
		for(i=0;i<dataLength()-1;i++)
		{
			for(j=i+1;j<dataLength();j++)
			{
				int a = compare(i,j);
				switch(a)
				{
					case 0: continue;
					case 1: swap(i,j);break;
					case -1: continue;	 
			}
		}


	}
}


	public static void main(String[] args)
	{

		System.out.print("Source Data : ");
		for(int n : data)
			System.out.print(n + " ");
		System.out.println();
		//sort(data);
		Test115 ob = new Test115();

		ob.sort(data); //non 스태틱이니까 객체 생성전엔 안되;;

		System.out.print("Sorted Data : ");
		for(int n : data)
			System.out.print(n + " ");
		System.out.println();


	}


}
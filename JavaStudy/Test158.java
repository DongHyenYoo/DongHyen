/*===================================
■■■컬렉션 프레임워크■■■
================================*/

/*
	Vector(벡터)

	자바의 자료 구조 기능을 제공하는 클래스들 중 가장 기본적인 클래스로
	배열과 비슷하지만, 배열과 달리 다른 종류의 데이터 형을 가진
	데이터 요소들을 가질 수 있으며, 데이터가 가득 차면 자동으로 저장 영역을 확장시키게 된다.

	또한 객체 레퍼런스를 저장하기에
	JDK 1.5 이전에는 자바 기본형 데이터는 저장할 수 없었으나
	JDK 1.5 이후부터는 오토박싱/오토언박싱 기능이 지원되면서
	기본 데이터형도 저장이 가능하다.

	벡터 클래스의 기본 구조는
	시퀀스(Sequence) 데이터 구조에 기반하며   //시퀀스 구조 : 은행에서 대기표 받는것의 구조와 같다.

	시퀀스 데이터 접근을 순차적인 인덱스 값에 대한 위치로 접근하게 된다.
	따라서 자료구조의 양 끝단에서만 접근이 가능한 큐나
	한쪽 끝에서만 접근이 가능한 스택과 달리
	스퀀스 개념의 인덱스 값을 이용하여 자료구조의 임의의 지점에서
	저장 및 접근이 가능하다.

	벡터의 스퀀스 구조는
	List 인터페이스를 통해 제공받고 있기 때문에
	List 인터페이스의 모든 메소드를 사용할 수 있다.

		-void add(int index, E element)
		- void insertElementAt(E obj, int index)
		주어진 위치에 객체를 저장한다.
		주어진 위치의 객체부터 오른쪽으로 하나씩 이동한다.

		-void addElement(E obj)
		-boolean add(E e)
		객체를 벡터 끝에 추가한다.

		-void removeElementAt(int index)
		-E remove(int index)
		주어진 위치의 객체를 제거한다.
		제거 후 주어진 위치 다음의 객체부터 하나씩 왼쪽으로 이동한다.
		R remove(int index) 메소드는 저장되었던 객체를 반환한다.

		-boolean removeElement(Object obj)
		-boolean remove(Object obj)
		대상 객체를 제거한다.
		제거 후 주어진 위치 다음의 객체부터 하나씩 왼쪽으로 이동한다.
		객체가 정상적으로 제거되었으면 true를 반환한다.

		-void removeAllElement()
		-void clear()
		벡터의 모든 요소를 제거한다.

		-void setElementAt(E obj, int index)
		-E set(int index, E element)
		벡터의 index 위치에 주어진 객체를 저장한다.
		주어진 위치에 저장되어 있던 객체는 소멸한다.(-> 덮어쓰기의 개념)

		- E elementAt(int index)
		-E get(int index)
		주어진 위치에 저장된 객체를 반환한다.

		-Enumeration<E> elements()
		벡터의 모든 요소를 반환한다.

		-int indexOf(Object o)
		주어진 객체가 저장된 위치를 반환한다.
		존재하지 않을 경우 음수를 반환한다.

		-int indexOf(Object o, int index)
		주어진 객체가 저장된 위치를 index 위치부터 찾아서 반환한다.
		index 위치는 스캔을 시작하는 위치

		-boolean contains(Object o)
		벡터가 주어진 객체를 포함하고 있는지의 여부를 반환한다.

		-void ensureCapacity(int minCapacity)
		벡터의 용량을 주어진 크기보다 크도록 조절한다.

		-E firstElement()
		벡터의 첫번째 요소의 데이터를 반환한다.

		-E lastElement()
		벡터의 마지막 요소의 데이터를 반환한다.

		-void setSize(int newSize)
		벡터의 크기를 조절한다.
		만약 주어진 크기가 현재 크기보다 작다면 나머지는 버린다.
		반대로 주어진 크기가 현재 크기보다 크다면
		빈 공간은 null 객체로 채우게 된다.
		(객체를 찹조하지 않음을 의미)

		-int capacity()
		현재 벡터의 용량을 반환한다.

		-int size()
		현재 벡터의 용량을 반환한다.

		-int trimToSize()
		벡터의 용량을 저장된 객체의 갯수에 맞도록 최소화 한다.

		벡터는 인덱스를 통해 접근하고 시퀀스를 통해 처리

*/

import java.util.Vector;
import java.util.Iterator;

public class Test158
{
	private static final String[] colors = {"검정","노랑","초록","빨강","파랑","연두"};


	public static void main(String[] args)
	{
		int i;
		String str;

		//Vector 자료구조 생성
		Vector<Object[]> v = new Vector<Object[]>();

		//v라는 벡터 자료구조에 colors 배열에 답겨있는 데이터 담아내기

		for(int j=0;j<colors.length;j++)
			v.add(colors[j]);


		v.addElement("하양"); //제일 끝에 살포시 추가됨

		//firstElement
		str = (String)v.firstElement();
		System.out.println("첫번째 요소 :"+str);
		
		//get
		str = (String)v.get(1);
		System.out.println("두번째 요소 : "+str);

		//elementAt()
		str = (String)v.elementAt(1);
		System.out.println("두번째 요소 : "+ str);
		
		//lastElement()
		str = (String)v.lastElement();
		System.out.println("마지막 요소 : "+str);

		//line 128 데이터 추가 후
		//마지막요소 : 하양

		//벡터 자료구조에 요소 추가 시( add()/addElement())
		//인덱스 마지막(가장 끝)의 위치에 추가되는 것을 확인할 수 있다.

		//전체 요소를 출력
		//Iterator(이터 레이터 or 아이터레이터)
		
		//자료구조에게 기능을 추가해주는 것
		//hasNext() 메소드 : 다음 데이터 요소가 있는지 없는지 여부를 확인
		//next() : 실제로 헤더를 이동시키며 값을 반환하는  메소드
		//이들 두개의 순환자와 반복자를 제공하는 것이 이터레이터

		Iterator<Object> it = v.iterator();

		while(it.hasNext()) //true //true 반복 하고 연두까지 가져오면 false
		{
			str = (String)it.next(); //헤더가 -> 로 이동하며 검정색을 가져옴
			System.out.print(str+"  ");
		}
		System.out.println();
		/*
		▼->
		----------------------------
		검 노 초 빨 파 연
		----------------------------
		*/


	}
}
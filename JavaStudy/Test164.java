/*===================================
�����÷��� �����ӿ�ũ���� 
================================*/
/*
Enumeration �� Iterator �������̽�

 Collection Framework ����
 Enumeration �� Iterator��� �������̽��� �ִ�.
 �������� �ǹ̷δ� �ݺ�, ��ȯ �̶�� �ǹ̸� ������ ������
 � ��ü���� ������ ���� ��,
 �� ��ü���� � ������ ���� �ϳ��� �����Ͽ� ����ϱ� ����
 �������̽���� �� �� �ֵ�.

 -java.util.Enumeration<E>�������̽�
 : �� �������̽��� ���� �ΰ��� �޼ҵ常�� �����ϸ�
 hasMoreElements() �޼ҵ带 ����
 �������̽� �ȿ� ���� ��Ұ� �ִ����� ���� ���Ǹ� �Ѵ�.
 ���� true�� ��ȯ�Ǿ��ٸ� ���� �ε����� ��Ұ� �����Ѵٴ� �ǹ��̸�
 nextElement() �޼ҵ�� ���� ��Ҹ� ������ ����ϸ� �Ǵ� ���̴�.

 ex) v��� ���� �ڷᱸ���� ����� ��� ��� ���
 	for(Enumeration e = v.elements(); e.hasMoreElements(); )
	{
		System.out.println(e.nextElement());

	}

	java.util.Iterator<E> �������̽�
	: Enumeration���� �������� ���� remove() �޼ҵ尡 �߰��� �� ���̴�.
	Iterator�� ������ �ִ� hasNext()�� next() �޼ҵ��
	�̸��� �ణ �ٸ��� Enumeration �������̽��� ������ �ִ�
	hasMoreElements()�� �׸��� nextElement()�� ��Ȯ�� ��ġ�ϴ� ����� �����Ѵ�.
	Enumeration ��� Iterator�� JDK 1.2 ���� �߰��Ͽ� ����ϰ� �� ������
	Enumeration �������̽��� ���� ������ ��Ҹ� ������ ����� ���� ������
	�̸� �����ϱ� ���� ���� ���� Iterator �������̽��̴�.

*/
import java.util.Vector;
import java.util.Enumeration;
import java.util.Iterator;
public class Test164
{
	public static void main(String[] args)
	{
		Vector<String> v = new Vector<String>();
		v.add("Oracle");
		v.add("Jsp");
		v.add("Servlet");

		//1.Enumeration
		//  -hasMoreElements()
		// - nextElement()

		Enumeration<String> e = v.elements();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());

		}
		System.out.println();

		System.out.println("-----------------------------");

		//2.Iterator
		// -hasNext()
		//-next()

		Iterator<String> d = v.iterator();

		while(d.hasNext())
		{
			System.out.println(d.next());
		}

	}
}
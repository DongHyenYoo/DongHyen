/*===================================
�����÷��� �����ӿ�ũ����
================================*/

/*
	Vector(����)

	�ڹ��� �ڷ� ���� ����� �����ϴ� Ŭ������ �� ���� �⺻���� Ŭ������
	�迭�� ���������, �迭�� �޸� �ٸ� ������ ������ ���� ����
	������ ��ҵ��� ���� �� ������, �����Ͱ� ���� ���� �ڵ����� ���� ������ Ȯ���Ű�� �ȴ�.

	���� ��ü ���۷����� �����ϱ⿡
	JDK 1.5 �������� �ڹ� �⺻�� �����ʹ� ������ �� ��������
	JDK 1.5 ���ĺ��ʹ� ����ڽ�/�����ڽ� ����� �����Ǹ鼭
	�⺻ ���������� ������ �����ϴ�.

	���� Ŭ������ �⺻ ������
	������(Sequence) ������ ������ ����ϸ�   //������ ���� : ���࿡�� ���ǥ �޴°��� ������ ����.

	������ ������ ������ �������� �ε��� ���� ���� ��ġ�� �����ϰ� �ȴ�.
	���� �ڷᱸ���� �� ���ܿ����� ������ ������ ť��
	���� �������� ������ ������ ���ð� �޸�
	������ ������ �ε��� ���� �̿��Ͽ� �ڷᱸ���� ������ ��������
	���� �� ������ �����ϴ�.

	������ ������ ������
	List �������̽��� ���� �����ް� �ֱ� ������
	List �������̽��� ��� �޼ҵ带 ����� �� �ִ�.

		-void add(int index, E element)
		- void insertElementAt(E obj, int index)
		�־��� ��ġ�� ��ü�� �����Ѵ�.
		�־��� ��ġ�� ��ü���� ���������� �ϳ��� �̵��Ѵ�.

		-void addElement(E obj)
		-boolean add(E e)
		��ü�� ���� ���� �߰��Ѵ�.

		-void removeElementAt(int index)
		-E remove(int index)
		�־��� ��ġ�� ��ü�� �����Ѵ�.
		���� �� �־��� ��ġ ������ ��ü���� �ϳ��� �������� �̵��Ѵ�.
		R remove(int index) �޼ҵ�� ����Ǿ��� ��ü�� ��ȯ�Ѵ�.

		-boolean removeElement(Object obj)
		-boolean remove(Object obj)
		��� ��ü�� �����Ѵ�.
		���� �� �־��� ��ġ ������ ��ü���� �ϳ��� �������� �̵��Ѵ�.
		��ü�� ���������� ���ŵǾ����� true�� ��ȯ�Ѵ�.

		-void removeAllElement()
		-void clear()
		������ ��� ��Ҹ� �����Ѵ�.

		-void setElementAt(E obj, int index)
		-E set(int index, E element)
		������ index ��ġ�� �־��� ��ü�� �����Ѵ�.
		�־��� ��ġ�� ����Ǿ� �ִ� ��ü�� �Ҹ��Ѵ�.(-> ������� ����)

		- E elementAt(int index)
		-E get(int index)
		�־��� ��ġ�� ����� ��ü�� ��ȯ�Ѵ�.

		-Enumeration<E> elements()
		������ ��� ��Ҹ� ��ȯ�Ѵ�.

		-int indexOf(Object o)
		�־��� ��ü�� ����� ��ġ�� ��ȯ�Ѵ�.
		�������� ���� ��� ������ ��ȯ�Ѵ�.

		-int indexOf(Object o, int index)
		�־��� ��ü�� ����� ��ġ�� index ��ġ���� ã�Ƽ� ��ȯ�Ѵ�.
		index ��ġ�� ��ĵ�� �����ϴ� ��ġ

		-boolean contains(Object o)
		���Ͱ� �־��� ��ü�� �����ϰ� �ִ����� ���θ� ��ȯ�Ѵ�.

		-void ensureCapacity(int minCapacity)
		������ �뷮�� �־��� ũ�⺸�� ũ���� �����Ѵ�.

		-E firstElement()
		������ ù��° ����� �����͸� ��ȯ�Ѵ�.

		-E lastElement()
		������ ������ ����� �����͸� ��ȯ�Ѵ�.

		-void setSize(int newSize)
		������ ũ�⸦ �����Ѵ�.
		���� �־��� ũ�Ⱑ ���� ũ�⺸�� �۴ٸ� �������� ������.
		�ݴ�� �־��� ũ�Ⱑ ���� ũ�⺸�� ũ�ٸ�
		�� ������ null ��ü�� ä��� �ȴ�.
		(��ü�� �������� ������ �ǹ�)

		-int capacity()
		���� ������ �뷮�� ��ȯ�Ѵ�.

		-int size()
		���� ������ �뷮�� ��ȯ�Ѵ�.

		-int trimToSize()
		������ �뷮�� ����� ��ü�� ������ �µ��� �ּ�ȭ �Ѵ�.

		���ʹ� �ε����� ���� �����ϰ� �������� ���� ó��

*/

import java.util.Vector;
import java.util.Iterator;

public class Test158
{
	private static final String[] colors = {"����","���","�ʷ�","����","�Ķ�","����"};


	public static void main(String[] args)
	{
		int i;
		String str;

		//Vector �ڷᱸ�� ����
		Vector<Object[]> v = new Vector<Object[]>();

		//v��� ���� �ڷᱸ���� colors �迭�� ����ִ� ������ ��Ƴ���

		for(int j=0;j<colors.length;j++)
			v.add(colors[j]);


		v.addElement("�Ͼ�"); //���� ���� ������ �߰���

		//firstElement
		str = (String)v.firstElement();
		System.out.println("ù��° ��� :"+str);
		
		//get
		str = (String)v.get(1);
		System.out.println("�ι�° ��� : "+str);

		//elementAt()
		str = (String)v.elementAt(1);
		System.out.println("�ι�° ��� : "+ str);
		
		//lastElement()
		str = (String)v.lastElement();
		System.out.println("������ ��� : "+str);

		//line 128 ������ �߰� ��
		//��������� : �Ͼ�

		//���� �ڷᱸ���� ��� �߰� ��( add()/addElement())
		//�ε��� ������(���� ��)�� ��ġ�� �߰��Ǵ� ���� Ȯ���� �� �ִ�.

		//��ü ��Ҹ� ���
		//Iterator(���� ������ or �����ͷ�����)
		
		//�ڷᱸ������ ����� �߰����ִ� ��
		//hasNext() �޼ҵ� : ���� ������ ��Ұ� �ִ��� ������ ���θ� Ȯ��
		//next() : ������ ����� �̵���Ű�� ���� ��ȯ�ϴ�  �޼ҵ�
		//�̵� �ΰ��� ��ȯ�ڿ� �ݺ��ڸ� �����ϴ� ���� ���ͷ�����

		Iterator<Object> it = v.iterator();

		while(it.hasNext()) //true //true �ݺ� �ϰ� ���α��� �������� false
		{
			str = (String)it.next(); //����� -> �� �̵��ϸ� �������� ������
			System.out.print(str+"  ");
		}
		System.out.println();
		/*
		��->
		----------------------------
		�� �� �� �� �� ��
		----------------------------
		*/


	}
}
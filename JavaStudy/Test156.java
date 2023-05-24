/*===================================
�����÷��� �����ӿ�ũ����
================================*/
/*
	��ť

	ť(Queue)�� ���Լ����� FIFO(First Input First Output) ������
	���� �Էµ� �ڷḦ ���� ����ϸ�

	Queue �������̽��� ������ Ŭ������ ť�� ������ �پ��� ����� �����Ѵ�.

	Queue�� �������̽� �ν��Ͻ��� �����ϱ� ���ؼ���
	new �����ڸ� �̿��Ͽ� Queue �������̽��� ����(Implements)��
	Ŭ������ �����ڸ� ȣ���Ѵ�.

	ex) Queue ob = new LinkedList(); //Linked List�� Queue �� list �������̽��� Implements�ϰ��ְ� �� ���� ����Ŭ�����̴�.


	���ֿ� �޼ҵ�

	-E element()
	ť�� head ��Ҹ� ��ȯ�ϸ� �������� �ʴ´�.

	-boolean offer(E o)
	������ ��Ҹ� ť�� �����Ѵ�.

	-E peek()
	ť�� head��Ҹ� ��ȯ�ϰ� �������� ������
	ť �ڷᱸ���� empty �� ��� null�� ��ȯ

	-E poll()
	ť�� head��Ҹ� ��ȯ�ϰ� �����ϸ�
	ť �ڷᱸ���� empty�� ��� null�� ��ȯ�Ѵ�.

	-E remove()
	ť�� head��Ҹ� ��ȯ�ϰ� �����Ѵ�.

*/

import java.util.Queue;
import java.util.LinkedList;
public class Test156
{
	public static void main(String[] args)
	{
		//Queue myQue = new Queue(); // �������̽��ϱ� �̰� �ȵ� �������̽��δ� ��ü������ �ȵǳ� ����Ŭ������ �߻��� �ƴ϶�� ����Ŭ������ ��ĳ������ ���� ��ü���� ���� 
		Queue<Object> myQue = new LinkedList<Object>();

		//������ �غ�
		String str1 = "�ֵ���";
		String str2 = "������";
		String str3 = "���¹�";
		String str4 = "������";

		//myque��� Queue�ڷᱸ���� ������ �߰�

		myQue.offer(str1);
		myQue.offer(str2);
		myQue.offer(str3);
		//myQue.offer(str4);

		boolean test = myQue.offer(str4); 
		System.out.println(test); //str4��� �����Ͱ� ����Ǿ����� �ƴ��� true�� ��ȯ�ؼ� �˷��ش�.

		//�׽�Ʈ(Ȯ��)
		System.out.println(myQue);
		//=>[�ֵ���, ������, ���¹�, ������] //�̵��� ���� or ���̵�����

		//Queue�ڷᱸ�������� head��Ұ� stack�� ���� �ⱸ�� ���尡���� �ִ� �ڷᰡ head ����̴�.

		System.out.println("�� 1 : "+(String)myQue.element()); //head��Ҹ� ����ϰ� ���������� ����
		

		System.out.println();

		String val;

		//1.

		//peek()
		//---ť�� head��� ��ȯ, ���� ����.
		//  ť�� empty �� ��� null�� ��ȯ.
		while(myQue.peek() != null)
		{		//poll()
			//ť�� head ��� ��ȯ. ������
			// ť�� empty�� ��� null �� ��ȯ.
			val = (String)myQue.poll();
			System.out.println("��� : "+ val);
		}
		System.out.println();

		//�ٿ� ĳ���� ��ĳ���ÿ� �ͼ�������  ���� �ڵ带 ���� ��Ƽ� � �ڷ������� �� �Ǵ����� �˾ƾ� ���ڵ尡 �������� �ƴ��������� �Ǵ��� �� �ִ�.

		/*
		while(myQue.poll() != null)
		{		//poll()
			//ť�� head ��� ��ȯ. ������
			// ť�� empty�� ��� null �� ��ȯ.
			val = (String)myQue.poll();
			System.out.println("��� : "+ val);
		}
		System.out.println();
		
		//2��°�� ���� 4��°�� ���ϸ� ���
			*/
/*
		while(true)
		{
			val = (String)myQue.poll();

			if(val==null)
				break;
			else
				System.out.println("��� : "+val);
		}
		System.out.println();
*/


		while(!myQue.isEmpty())
		{
			val = (String)myQue.poll();
			System.out.println("��� : "+val);
		}
		System.out.println();

		



	}
}
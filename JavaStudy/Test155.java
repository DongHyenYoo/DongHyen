/*===================================
�����÷��� �����ӿ�ũ����
================================*/
import java.util.Stack;

public class Test155
{
	//���� ���ڿ� �迭 ���� �� �ʱ�ȭ
	private static final String[] colors = {"����","���","�ʷ�","����","�Ķ�","����"};

	//������
	public Test155()
	{
		//st��� Stack�ڷᱸ�� ����
		//���ʸ��� Ȱ���Ͽ� String�����͸� Stack�� ��� ���ڴٰ� ����
		Stack<String> st = new Stack<String>();

		//st��� Stack �ڷᱸ���� ������(colors) ���
	
	//	st.push(colors[0]); �̷��� �� �����ص� ��


		for(String i : colors)
			st.push(i);

		st.push("����");

		//st.push(10); //���׸� ���� String�� �����߱⿡ �Ͼ�� ������.
			//���� �߻�(������ ����)
			//���׸� ǥ������ ���� ����� �ڷ����� �ٸ� �ڷ����� add�Ϸ��� �ϴ� ����

		popStack(st);
	}

	private void popStack(Stack<String> st)
	{
		System.out.print(" pop : ");
		while(!st.empty())  //isEmpty()
		{
			System.out.print(st.pop()+" ");

		}
		System.out.println();

	}

	public static void main(String[] args)
	{
		new Test155();



	}
}
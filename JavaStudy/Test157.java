/*===================================
�����÷��� �����ӿ�ũ����
================================*/
import java.util.Queue;
import java.util.LinkedList;

public class Test157
{
	
	private static final String[] colors = {"����","���","�ʷ�","����","�Ķ�","����"};

	public static void main(String[] args)
	{
		Queue<String> qu = new LinkedList<String>();
		// Queue �������̽� ����� �ν��Ͻ��� �����ϱ� ���ؼ���
		//new �����ڸ� �̿��Ͽ� Queue �������̽��� implements ��
		// ���� Ŭ������ �����ڸ� ȣ���ؾ� �Ѵ�.

		//qu ��� Queue �ڷᱸ����
		//colors �迭�� ������ �Է�
		
		for(String i : colors)
			qu.offer(i);

		//qu��� Queue �ڷᱸ���� ��� ������ ��ü ���

		System.out.print("�� : ");
		while(qu.isEmpty()==false)
		{
			System.out.print(qu.poll()+"  ");
			
			

		}

	}
}
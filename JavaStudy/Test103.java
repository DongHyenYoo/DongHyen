/*===================================
Ŭ������ �ν��Ͻ�
�޼ҵ� �����ε�(�ߺ� ����)
================================*/

/*
�޼ҵ� �����ε��� ����

	�޼ҵ� �����ε��̶� �޼ҵ尡 ó���ϴ� ����� ����,
	�޼ҵ� ��ȣ���� ����,�Ű�����,�Ķ������ ������ �ٸ��ų�
	�ڷ����� �ٸ����
	�޼ҵ��� �̸��� ������ �̸����� �ο��Ͽ� �޼ҵ带 ������ �� �ֵ���
	���������� ����Ѱ�


*/
public class Test103
{
	public static void main(String[] args)
	{

	//static ���� drawLine�� �����߱⿡
	//main�� ź���� �Բ� ź���ϹǷ�
	//Test103.drawLine();�� �ҷ��� �����ϰ�
	//���� class�ȿ� �����Ƿ� drawLine();�ε� �����ϴ�.
	drawLine();

	drawLine('a'); //���� ���� ��ġ�ص� �޼ҵ� �����ε� ���п� ������ �ȴ�.

	drawLine('a',4);
	}

	public static void drawLine()
	{
		System.out.println("============");
	}

	public static void drawLine(char c)
	{
		for(int i=0;i<20;i++)
		{
			System.out.println("///////////////");
		}

		
	}

	public static void drawLine(char c,int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(c);
		}
		System.out.println();
	}
}
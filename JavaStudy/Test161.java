/*===================================
�����÷��� �����ӿ�ũ����
================================*/
import java.util.Vector;
public class Test161
{
	private static final String[] colors = {"����","���","�ʷ�","����","�Ķ�","����"};

	public static void main(String[] args)
	{
		Vector<String> v = new Vector<String>();

		//���� �ڷᱸ�� v �� colors �迭 �����͸� ��ҷ� �߰�

		for(String color : colors)
			v.add(color);

		//���� �ڷᱸ�� v�� ��ü ��� ���
		System.out.print("��ü ��� ��� : ");
		
		for(String vi : v)
			System.out.print(vi + "  ");
		System.out.println();

		String s1 = "��ȫ";

		//indexOf()

		int i = v.indexOf(s1);
		System.out.println(s1 + "�� ��ġ�� "+i); //-1 �翬�� ���Ϳ� �ȳ־����ϱ�

		String s2 = "���";
		
		//v.contains(s) 
		//���� �ڷᱸ�� v�� ã���� �ϴ� s �� ���ԵǾ� �ִٸ�..
		//index ��ġ Ȯ�� �ؼ� true false

		if(v.contains(s2))
		{
			i = v.indexOf(s2);
			System.out.println(s2+ " -> index��ġ :  "+i);

			v.remove(i);// �켱 index�� ã�� �װ� �Ű������� �Ѱܼ� �̷��� �����ؾߵ� 1.�����ϴ��� ã�� 2.��� �ִ��� Ȯ���ϰ� 3.Ȯ�������� �����ض�.
			
		}

		System.out.print("������ ��ü ��� ���:");
			for(String vi : v)
			System.out.print(vi + "  ");
		System.out.println();

		//System.out.println(v);
		//Ȯ�ο� ���� �����ʹ�
		//���� ��Ұ� �ƴϱ⿡
		//�̸� Ȱ���Ͽ� ������ �����ϰ� ó���ؼ��� �ȵȴ�.


		
	}
}
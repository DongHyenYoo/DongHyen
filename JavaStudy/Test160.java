/*===================================
�����÷��� �����ӿ�ũ����
================================*/

import java.util.Vector;
import java.util.Iterator;
import java.util.Collections;


public class Test160
{
	private static final String[] colors = {"����","���","�ʷ�","����","�Ķ�","����"};



	public static void main(String[] args)
	{

		Vector<String> v = new Vector<String>();

		for(String color : colors)
		{
			v.add(color);
		}

		System.out.println("ù��° ��� : " + v.firstElement());
		System.out.println("�ι�° ��� : " + v.get(1));
		System.out.println("������ ��� : " + v.lastElement());
		System.out.println("����� ���� : " + v.size());

		//ù ��° ��Ҹ� "�Ͼ�"���� �����ϱ�

		v.set(0,"�Ͼ�"); //�����

		System.out.println("�ι�° ��� : "+v.get(1));
		

		//ù��° ��ҿ� ��Ȳ�� �߰��ϰ�ʹ�.

		v.add(0,"��Ȳ");
		//v.insertElementAt("��Ȳ",0);
		System.out.println(v.firstElement());
		System.out.print("��ü ��� : ");
		for(String str : v)
			System.out.print(str + "  ");
		
		//�������� ����
		Collections.sort(v); //Collection �� �ƿ츣�� Collections��� �����ְ� �װͿ� �����޼ҵ� sort
		
		System.out.println();
		System.out.print("��ü ��� : ");
		for(String str : v)
			System.out.print(str + "  ");
		//��ü ��� : ���  ����  ����  ��Ȳ  �ʷ�  �Ķ�  �Ͼ�


		//�˻�
		//Collections.binarySearch();
		//�˻������ ����
		//��, �������� ������ �Ǿ����� �ʴٸ� ã�� ���Ѵ�. �� �������� ������ ����ؾ���
		//�˻� ����� �������� ������� ������ ��ȯ

		System.out.println();
		int idxBlue =Collections.binarySearch(v,"�Ķ�");
		System.out.print(idxBlue);//��ġ�� �ε����� ��ġ�� ���´�.

		int idxNavi = Collections.binarySearch(v,"����");
		System.out.print(idxNavi); //��� ������ ����


		//�������� ������ �ϴ� �޼ҵ�� ����.
		Collections.sort(v,Collections.reverseOrder());
		
		System.out.println();
		System.out.print("��ü ��� : ");
		for(String str : v)
			System.out.print(str + "  ");

		System.out.println(Collections.binarySearch(v,"�Ķ�")); //-8�̶�� ������ ���� �˻������ ���ٴ� ��

		Collections.sort(v,Collections.reverseOrder());
		
		System.out.println();
		System.out.print("��ü ��� : ");
		for(String str : v)
			System.out.print(str + "  ");
		
		idxBlue =Collections.binarySearch(v,"�Ķ�",Collections.reverseOrder()); //ã���� ����� ã�ƶ�
		System.out.println(idxBlue);



		

		
		


	}
}
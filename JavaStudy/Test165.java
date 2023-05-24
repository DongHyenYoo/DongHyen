/*===================================
�����÷��� �����ӿ�ũ���� 
================================*/
//List -> Vector, ArraryList, LinkedList.....
//���� ����
//�迭�� ����
//�ߺ��� ���

/*
	ArrayList Ŭ����

	-ArrayList�� Vector Ŭ������
	 List �� ũ�� ������ ������ �迭�� ������ ������
	 �������� Vector Ŭ������ ��ü�� �⺻������ ����ȭ ������,
	 ArrayList�� �׷��� �ʴٴ� ���̴�.

	 -�񵿱�ȭ �÷����� ����ȭ�� �÷��Ǻ��� �� ���� ������ �����ϸ�
	  ��������� �÷����� �������� �ʴ� ���α׷�������
	  �Ϲ������� ArrayList�� Vector���� �� ��ȣ�ϸ�,
	  ArrayList�� ����ȭ�� ������� ���� Vectoró�� ���������ν�
	  ������ ����ȭ�� ������ �δ��� ������ �ʱ⿡
	  Vector���� �� ������ ����ȴ�.

	  -null�� ������ ��� ��Ҹ� ����ϸ�
	  List �������̽��� �����ϴ� �� �ܿ� ����Ʈ�� �ݳ��ϱ� ����
	  ���������� ���Ǵ� �迭�� ����� �����ϴ� �޼ҵ带 �����Ѵ�.

*/

import java.util.ArrayList;
import java.util.Vector;
import java.util.List;
import java.util.ListIterator;


public class Test165
{
	public static void main(String[] args)
	{
		//ArrayList �ڷᱸ�� �ν��Ͻ� ����
		//ArrayList<String> list = new ArrayList<String>();
		//Vector<String> list = new Vector<String>();
		//List<String> list = new Vector<String>(); //Vector�� ����Ŭ������ List�� implements �ϰ��ִ�.
		List<String> list1 = new ArrayList<String>();
		
		//list1 �ڷᱸ���� ��� �߰� -> add()
		list1.add("���˵���2");
		list1.add("ž��2");
		list1.add("����2");

		List<String> list2 = new ArrayList<String>(list1); //list �ڷᱸ���� �Ѱܹ޴� �����ڰ� ArrayList�� �����Ѵ�.
		
		//list2�� ��� �߰� -> add()
		list2.add("�μ���");

		List<String> list3 = new ArrayList<String>();
		list3.addAll(list2);

		int i = list3.indexOf("ž��2");
		list3.add(i,"���������");
		//ž��2 �տ� ��������� �߰�

		


		//��� -> �����ͺ��̽� ���
		
		System.out.println(list1);
		//[���˵���2, ž��2, ����2]
		System.out.println(list2);
		//[���˵���2, ž��2, ����2, �μ���]
		System.out.println(list3);
		//[]

		System.out.println();

		//��� -> listIterator() �޼ҵ带 Ȱ���Ͽ� ���
		ListIterator<String> li = list3.listIterator(); //list���� �����ϴ� �޼ҵ�
		
		//��� ->�������� ����
		while(li.hasNext())
		{
			System.out.println(li.next());
		}

		while(li.hasPrevious()) //���״�� ���ʿ��� ���������� �̵��ϴ� ����� �����ʺ��� �������� �̵��ϰ��ϴ� ��
		{
			System.out.println(li.previous());
		}
	
	
	}	
}
/*===================================
�����÷��� �����ӿ�ũ���� 
================================*/

/*
  List �������̽�
  -������ �����Ѵ�.,�迭�� �����ϴ�,���������� ���鿡�� �ߺ��� ���
  -�ֿ� ���� Ŭ����
   Vector(����ȭ ����)
   ArrayList(����ȭ ����x)
   LinkedList(ü��.��ũ,����,ť) �� ���� �����Ͱ� ������ ������ �ڵ� ���������� ���� ����Ǿ��ִ�.


*/
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
public class Test166
{
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();

		list.add("����");
		list.add("�λ�");
		list.add("��õ");
		list.add("�뱸");
		list.add("����");
		list.add("����");
		list.add("���");
		list.add("����");
		
		System.out.println(list);

		System.out.println(list.size());

		System.out.println("ù��° ��� : "+list.get(0));

		System.out.println("������ ��� : "+list.get(list.size()-1));

		list.add(0,"�ѱ�");
		System.out.println(list);
		//���� Ȯ��

		list.set(0,"���ѹα�");
		System.out.println(list);
		//���� Ȯ��

		if(list.contains("����"))
		{
			System.out.println("���� ����");
		}
		int n = list.indexOf("����");
		System.out.println("������ ��ġ" +n);
		
		//list.remove("���ѹα�");
		//System.out.println(list);

		list.remove(0);
		System.out.println(list);

		System.out.println("��ü ���: ");
		for(int idx=0;idx<list.size();idx++)
		{
			System.out.print(list.get(idx)+" ");
		}
		System.out.println();


		System.out.println("���� ��� : ");
		for(int idx=list.size()-1;idx>=0;idx--)
		{
		System.out.print(list.get(idx)+ "  ");
		}
		System.out.println();

		System.out.println("��ü��� ���2 :");
		for(String s : list)
		{
			System.out.print(s + " ");

		}
		System.out.println();

		System.out.println("��ü ��� ��� 3 : ");
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			String s = it.next();
			System.out.print(s+ "  ");
		}
		System.out.println();


		System.out.println("��ü��� ��� 4: ");
		ListIterator<String> li = list.listIterator();
		while(li.hasNext())
		{
			System.out.print(li.next() + " ");
		}
		
		System.out.println();

		System.out.println("���� ��¹�� 2��° ");
		while(li.hasPrevious())
		{
			String s = li.previous();
			System.out.print(s+"  ");
		}
	}
}
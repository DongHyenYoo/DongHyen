/*===================================
�����÷��� �����ӿ�ũ���� 
================================*/

//Set -> HashSet, TreeSet

//���� ����.
//�ߺ��� ������� �ʴ� ����(�⺻)

/*
	TreeSet<E>Ŭ����

	java.util.TreeSet<E>Ŭ����

	java.tuil.TreeSet<E>Ŭ������
	Set �������̽��� ��ӻ� SortedSet �������̽��� ������ Ŭ������
	�����͸� �߰��ϸ� �����͵��� �ڵ����� �������� ������ �ȴ�. -> ��������

	
*/
//Vo = Value Object ����Ͻ� ������ �����ϰ� �ִ� ��ü �ǹ������� VO�� DTO�� ���� �������� X
//DTO = Data Transfer Object ������ �� ��� ���� �������� ó���� �ٸ������� ���� �� �����ؼ� ����
//DAO = Data Access Object ���� DTO�� ��� ó������ �����ϴ°��� DAO����Ѵ�.

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;

class GradeVo
{
	private String hak;		  //�й�
	private String name;      //�̸�
	private int kor, eng, mat;//����,����,���� ����


	//������(����� ���� ������) //5���� �Ű������� ���� ������
	GradeVo(String hak, String name, int kor, int eng, int mat)
	{
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;

	}
	//default ������ �ڵ� ���� �ȵǹǷ� default����� �Ű����� ���� �����ڸ� ����� ���Ƿ� ����
	//�Ű������� �����ϴ� �����ڸ� ����� ���� �����ڷ� �����Ͽ��� ������
	//default �����ڰ� �ڵ����� ���Ե��� ���� ���� ����Ͽ�
	//�߰��� ������ ������


	GradeVo()
	{
		this("","",0,0,0);

	}

	public String getHak()
	{
		return this.hak;
	}
	public void setHak(String hak)
	{
		this.hak = hak;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}


	public int getKor()
	{
		return this.kor;
	}
	public void setKor(int kor)
	{
		this.kor = kor;
	}


	public int getEng()
	{
		return this.eng;
	}
	public void setEng(int eng)
	{
		this.eng = eng;
	}


	public int getMat()
	{
		return this.mat;
	}
	public void setMat(int mat)
	{
		this.mat = mat;
	}

	//�߰� �޼ҵ� ����(���� ����)
	public int getTot()
	{
		return this.kor+this.eng+this.mat;
	}
	
	


}

class MyComparator<T> implements Comparator<T> //���䷹�Ͱ� �������ִ� Compare�޼ҵ带 �������ϱ� ���� ��  //<T>�� �ǹ��ϴ°��� �񱳵� ����� type�̴�.
{
	@Override

	public int compare(T o1, T o2) //compare �޼ҵ� ������
	{
		GradeVo s1 = (GradeVo)o1;
		GradeVo s2  = (GradeVo)o2; 
		/*
		//�й� ����(��������)
		return Integer.parseInt(s1.getHak()) - Integer.parseInt(s2.getHak()); //���� �й��� ���������� ��ȯ�� ���� ���Ҽ� �ְ��ϰڴ�.
		// Integer.parseInt(2206113) - Integer.parseInt(2206115);  = -2 �� ������ ���� -�� ���� ���� ���� ���� ��ü�� �� ũ�� �ν��ϰԸ����.

		//�������� �����Ϸ���
		return Integer.parseInt(s2.getHak()) - Integer.parseInt(s1.getHak()); //+�̹Ƿ� ����� �������� ���ĵǾ� ��������.
	*/
		//���� ���� (��������)
		//	return s1.getTot() - s2.getTot();
		//���� ���� (��������)
		return s2.getTot() - s1.getTot();

		//�̸� ���� (��������)
		//return s1.getName().compareTo(s2.getName());
		
		//�̸� ����(��������)
		//return s2.getName().compareTo(s1.getName());
		
	}
}

public class Test169
{
	public static void main(String[] args)
	{
		TreeSet<String> set = new TreeSet<String>();

		set.add("�͸���Į��");
		set.add("��Ž�� �ڳ�");
		set.add("����ť");
		set.add("���� �̸���");
		set.add("���ϸ�");
		set.add("���� ġ������ ���Ҹ�");
		set.add("�������庥ó");
		set.add("�̿��������");
		set.add("���̰���Ѹ������������");
		set.add("������̺�");
		

		//Iteraotr �� Ȱ���� ��ü���
		Iterator<String> it = set.iterator();

		while(it.hasNext())
		{
			System.out.print(it.next()+"  ");

		}
		System.out.println();
		//������ ������ �������ش�.
		//��Ҹ� ���ڿ��� ������ ���
		//�����ټ� -> �������� ����
		
		//TreeSet �ڷᱸ�� �ν��Ͻ� ����

		//TreeSet<GradeVo> set2 = new TreeSet<GradeVo>();
		//���Ͱ��� compare�� Override ����
		//�ٽ� ����
		TreeSet<GradeVo> set2 = new TreeSet<GradeVo>(new MyComparator<GradeVo>()); 
		//TreeSet�� �����ڿ��� ���� ������ �Ѱ��ش�. �� ���� ���ѱ����� ���� �ڷḦ ���� �� ������.

/*
		//TreeSet �ڷᱸ�� set2�� ��� �߰�
		set2.add(new GradeVo("2206113","������",90,80,70)); //Exception in thread "main" java.lang.ClassCastException: GradeVo cannot be cast to java.lang.Comparable �����߻� 
		set2.add(new GradeVo("2206115","�ֵ���",91,81,71)); //TreeSet�� ������ �ϴ� ����� �ڵ������� �����ϰ� ������ ��ü�� �����ع����� Ư���� ���� ���� �񱳸� �Ͽ� ������ ������ �� ���Եȴ�.
		set2.add(new GradeVo("2206128","���α�",88,78,68)); //
		set2.add(new GradeVo("2206139","������",70,60,50));
		set2.add(new GradeVo("2206150","������",99,82,72));

		Iterator<GradeVo> it2 = set2.iterator();

		while(it2.hasNext())
		{
			System.out.print(it2.next().getName()+"  ");
		}

*/	

		set2.add(new GradeVo("2206113","������",90,80,70)); 
		set2.add(new GradeVo("2206115","�ֵ���",90,80,70)); 
		set2.add(new GradeVo("2206128","���α�",88,78,68)); 
		set2.add(new GradeVo("2206139","������",70,60,50));
		set2.add(new GradeVo("2206150","������",99,82,72));

		Iterator<GradeVo> it2 = set2.iterator();

		while(it2.hasNext())
		{
			GradeVo vo =it2.next();
		
			System.out.println(vo.getHak()+"  "+vo.getName()+"  "+vo.getKor()+"  "+vo.getEng()+"  "+vo.getMat()+"  "+vo.getTot());
		
		}

		//char y = '��';
		//System.out.println((int)y);
		//����غ��� �й��������� ������������ ���ĵǾ��ִ�.

		//���� ���� ��������

		/*
		2206150  ������  99  82  72  253
		2206115  �ֵ���  91  81  71  243
		2206113  ������  90  80  70  240
		2206128  ���α�  88  78  68  234
		2206139  ������  70  60  50  180
		*/

		/*���� ���� ��������
		2206139  ������  70  60  50  180
		2206128  ���α�  88  78  68  234
		2206113  ������  90  80  70  240
		2206115  �ֵ���  91  81  71  243
		2206150  ������  99  82  72  253

		*/
		
		/*
		String dlfma1 = "������";
		String dlfma2 = "�굿��";

		System.out.println(dlfma1.compareTo(dlfma2)); 
		//-588 1�� �������� 1�� ���� �ѱ��̸� - ��ȯ

		System.out.println(dlfma2.compareTo(dlfma1));
		//+588 
		*/
		//String dlfma1 = "������";
		//String dlfma2 = "�Ե���";

		//System.out.println(dlfma1.compareTo(dlfma2));
		//6468 1�� ���� �ѱ��̸� +




	}
}
/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
Object Ŭ����
================================*/

class Test 
{

	private int a = 10;

	public void write()
	{
		System.out.println("a : " +a);
	}
}


public class Test128
{
	public static void main(String[] args)
	{
	Test ob1 = new Test();
	Test ob2 = new Test();

	System.out.println("10 == 9: " + (10 == 9));
	

	int a=10;
	int b=10;

	System.out.println("a == b : " + (a==b));

	//=�� �����ڴ� �ǿ������� ũ�⸦ ������ Ȯ��(����)

	System.out.println("ob1 == ob2 : "+ (ob1 == ob2));
	System.out.println("ob1 == ob2 : "+ ob1.equals(ob2));
	//��ü�� ���ϰ� �Ǹ� ��ü�� (�ĺ�)9�ּҸ� ���Ѵ�. ũ�⸦ ������ ����
	//�� ���� �����Ŷ�� 
	//equals �޼ҵ带 ���� ��ü�� �ĺ��ּҸ� ���ϰ� ���ϰ��� boolean�̴� boolean������
	

	System.out.println();
	System.out.println("---------------------------------------------------------------");
	System.out.println();
	System.out.println("ob1 : "+ ob1);
	System.out.println("ob1.toString() : "+ob1.toString());

	System.out.println("ob2 : "+ob2);
	System.out.println("ob2.toString() :"+ob2.toString());

	//Ŭ������@�ؽ��ڵ�

	//�ؽ��ڵ�
	//	�ڹ� ���������� ��ü�� �����ϱ� ���� ����ϴ� ��.
	//�޸��� �ּҰ����� �����ϸ� ����� �ȵȴ�.

	//��ü�� ������ hashcode�� ������
	//  hashcode�� ���ٰ��ؼ� ���� ��ü�� �ƴϴ�.
	


	}
}

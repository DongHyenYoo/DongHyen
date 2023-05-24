/*===================================
Ŭ���� ���
�������̽�
================================*/

interface ADemo
{
	public void write();
}

interface BDemo
{
	public void print();
}

//�������̽��� 2�� �̻��� ������ ���ִ�. 
//Ŭ�������� ���� ����� ���� �ʴ� �κ��� �����ϴ� ����

//abstract  class DemoImpl implements ADemo, BDemo 
class DemoImpl implements ADemo, BDemo
{
	@Override //�������̽��� �������̵�� JDK1.6���ʹ�
			  //�� ��ӹ��� Ŭ������ �޼ҵ带 �������̵��Ҷ��� 1.5������ ����
	public void write()
	{
		System.out.println("ADemo �������̽� �޼ҵ� write");
	}
	
	@Override
	public void print()
	{
		System.out.println("BDemo �������̽� �޼ҵ� print");
	}

}


public class Test118
{
	public static void main(String[] args)
	{
		//ADemo ob = new ADemo();
		//BDemo ob = new BDemo();
		DemoImpl ob0 = new DemoImpl();

		DemoImpl ob = new DemoImpl();

		ob.write();
		ob.print();

		ADemo ob2 = new DemoImpl();//(ADemo)ob0;
		BDemo ob3 = new DemoImpl(); //(BDemo)ob0;
		
		ob3.print();
		
		ob2.write();

		((BDemo)ob2).print(); //��� ��ġ�� B�� �̵��߱⿡ write�� �Ⱥ��δ�. ->�ڽ� -> A�������̽� -> B�������̽��� ��ġ ����
		((ADemo)ob3).write(); //���� ����� ��Ȳ
		//DemoImpl Ŭ������ �� �������̽��� ��� �����߱⿡
		// �̿� ���� ó���� �����ϴ�.
		//���� DemoImpl Ŭ������ �� �������̽��� �� �� �������̽��� �����ߴٸ�
		//�� ������ ��Ÿ�� ������ �߻��ϴ� �����̵ȴ�.

		((DemoImpl)ob2).write(); //�̰� �ٿ�ĳ����
	}
}
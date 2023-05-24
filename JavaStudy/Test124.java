/*===================================
Ŭ���� ���
��ø Ŭ����
================================*/
class InnerOuterTest
{
	static int a = 10;
	int b =20;

	class InnerNested
	{
		int c = 30;

		void write()
		{
			System.out.println("Inner�� write()...");
			System.out.println("a: "+a);
			System.out.println("b: "+b);
			System.out.println("c: "+c);
		}
	}

	void write()
	{  
		System.out.println("outer�� write()..");
		
		InnerNested ob1 = new InnerNested();
		ob1.write(); //inner �� write() �޼ҵ� ȣ��
	
	}

}
//main() �޼ҵ带 �����ϰ� �ִ� �ܺ��� �ٸ� Ŭ����

public class Test124
{
	public static void main(String[] args)
	{
		//InnerOuterTest(outer) Ŭ���� ��� �ν��Ͻ� ����
		InnerOuterTest ob2 = new InnerOuterTest();
		ob2.write(); //outer�� write �޼ҵ� ȣ��

		//InnerNested ob3 = new InnerNested();
		
		//InnerOuterTest.InnerNested ob4 = new InnerOuterTest.InnerNested(); //�Ʊ�� inner�� static�̾ Ŭ���������� ȣ���� �����ߴ��Ű� �̰� �ȵ� 
	
		//��ø ���� Ŭ����(static ��ø Ŭ����)�ʹ� �޸�
		//�ܺ� Ŭ������ �ν��Ͻ�(��ü)�� ������� �ʰ�
		//�ܵ����� ���� Ŭ������ �ν��Ͻ��� �����ϴ� ���� �Ұ����ϴ�.
		//->�ܺ� Ŭ������ ��ü�� ����ϸ�
		//���� Ŭ������ ��ü�� �����ϴ� ���� �����ϴ�.

		InnerOuterTest.InnerNested ob5 = ob2.new InnerNested();
		ob5.write();

		InnerOuterTest.InnerNested ob6 = new InnerOuterTest().new InnerNested();
		ob6.write();

		//outerŬ������.innerŬ������ ���������� = new outer������().new inner������();

		//cf) static - ���� ���� Ŭ����
		//outerŬ������.innerŬ������ ���������� = new outerŬ������.inner������();
	}
}
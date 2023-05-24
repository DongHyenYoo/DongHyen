/*===================================
Ŭ������ �ν��Ͻ�
static ������ static �޼ҵ�
================================*/

//1.static : ź������
//
//2.static : ����


//�ǽ� ���ǻ� �������������� ����


public class Test100
{

	//Ŭ���� ���� �Ǵ� Ŭ���� �޼ҵ��
	//Ŭ���� ������ �ε��Ǵ� ���� �޸� �Ҵ��� �̷������
	//	Ŭ���� �̸� �Ǵ� ��ü�� ���� ������ �� �ִ�.
	//	�� new�����ڸ� ���� �޸𸮸� ���Ҵ� ���� �ʾƵ� ����� �����ϴ�.


	static int a = 10;   //static ����(Ŭ���� ����) ,���� ����


	//�ν��Ͻ� ���� �Ǵ� �ν��Ͻ� �޼ҵ��
	//������ Ŭ������ �޼ҵ忡���� �ٷ� �����ϴ� ���� ����������
	//Ŭ���� �޼ҵ忡���� �����Ҽ� ����.

	int b = 20;          //non static ����(�ν��Ͻ� ����),

	void write()	//�ν��Ͻ� �޼ҵ�
	{
		System.out.println("Ŭ���� ���� a"+a);
		System.out.println("�ν��Ͻ� ���� b"+b);
	}

	static void print() //����ƽ �޼ҵ� (Ŭ���� �޼ҵ�, ���� �޼ҵ�)
	{	
		System.out.println("Ŭ���� ���� a"+a);
		//System.out.println("�ν��Ͻ� ���� b"+b); //����
	}




	public static void main(String[] args)
	{

		System.out.println("main() -> Ŭ���� ���� a   "+Test100.a); //�̷��� static ������ �θ��� �ִ�.
																  //�۷��� ������ �����ϱ����ؼ���
																  //Ŭ������.������ �� ���·� Ŭ������ �̸��� ����
																  //�����ϴ� ���� ����


		System.out.println("main() -> Ŭ���� ���� a   "+a);    //���� Ŭ������ ����־ �׳� ������ �����ߴ���

		
		Test100.print();//������ �̷��� �ҷ����Ѵ�. Ŭ������.�޼ҵ�();

		print();//���� Ŭ���� �ȿ������� ����
		//System.out.println("main() -> �ν��Ͻ� ���� b"+b); //����

		//Test100.write(); //���� ��ü ���� �ȉ����Ƿ�

		//write(); //���� ��ü ���� �ȉ����Ƿ�

		//Test100 Ŭ���� ��� ��ü ����

		Test100 ob = new Test100();

		ob.write(); 
		System.out.println("main() -> �ν��Ͻ� ���� b"+ob.b);
		//write(); �̰͵� �ȴ� ������ ������ ��ü�� ���ؼ� ���;� �Ѵ�. static���� �����Ϸ��� ó�� ��ĵ�ϸ鼭 �޸𸮿� �ۿø��� �ʾ����Ƿ�

		//static ���� �޼ҵ�� ������ ��ü.����  ��ü.�޼ҵ�()�ε� ȣ���� �� �ֵ�.

		//������ �ν��Ͻ��� ���� Ŭ���� ���� ȣ��
		System.out.println("main() -> Ŭ�������� a :"+ob.a);

		//������ �ν��Ͻ��� ���� Ŭ���� �޼ҵ� ȣ��
		ob.write();

		//Ŭ���� ������ �޼ҵ��
		// �������ν��Ͻ���.������
		// �������ν��Ͻ���.�޼ҵ��()
		//�� ���·ε� ȣ���� �����ϳ�
		//	Ŭ������.������
		//	Ŭ������.�޼ҵ��()
		//	�� ���·� ȣ���ϴ°��� �Ϲ����� ���̴�.

		System.out.println("main() -> Ŭ���� ���� a : " + a);
		System.out.println("main() -> Ŭ�������� a   :" +Test100.a);
		System.out.println("main() -> Ŭ�������� a   :" +ob.a);
		

		/*
		main() -> Ŭ���� ���� a : 10;
		main() -> Ŭ���� ���� a : 10
		main() -> Ŭ���� ���� a : 10
		*/
		
		System.out.println(); //����

		//Test100 Ŭ���� ��� �ν��Ͻ� ����

		Test100 ob2 = new Test100();

		ob2.a = 10000;	//Ŭ���� ���� �ʱ�ȭ
		ob2.b = 20000; //�ν��Ͻ� ���� �ʱ�ȭ

		ob2.write();

		ob.write(); //Ŭ���� ������ Ŭ���� ������ �ʱ�ȭ �ص� �̰��� �����Ǽ� ���� a�� 10000�� �Ǿ���.

		




	}
}
/*===================================
Ŭ������ �ν��Ͻ�
-���� ���а� ���� ���� ������(���� ������, ���� ������, ���� ������, ���� ������
================================*/

class CircleTest2
{	
	//circleTest2�� ��� ���� num Ȥ�� �ν��Ͻ� ������� �Ѵ�.
	//����������� �� (�� Ŭ���� ��ü���� �ٺ��̱⿡)
	int num;

	
	//private int num; //���� ������ ����
					//private��� ���������������� ������
					//Ŭ���� ���ο����� ���� �� ������ �����ϰ� �ϰڴٴ� �ǹ�
					//int �� ���� ���� -> �ڵ����� 0���� �ʱ�ȭ
					//�ܺο����� num�� �ִ� ���� �������� ������ ����.

	//�ؼ� ���� �ְԸ������ ���� getter/setter�� �����Ѵ�. ��������� private���� �����ߴٸ� ����/���͸� ����°��� �Ϲ����� ����̴�.

/*
	int getter() //����Ŭ������ �޼ҵ忡���� private�� ������ ������
	{
		return num; //num���� ��������� �������ִ� ��
	}

	void setter(int num) //��������� ���� �ڷ����� �����°��� �������ִ� ����
	{
		this.num = num;
	}
*/

	void input()
	{
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.print("������ �Է�");
		num = sc.nextInt();
	}

	double calArea()
	{
		return num*num*3.141592;
	}

	void write(double area)
	{
		System.out.println("������"+num);
		System.out.println("���� ����"+area);
	}





}



public class Test098
{
	public static void main(String[] args)
	{
		CircleTest2 ob = new CircleTest2();

		//ob.num = 10; //�̰� �Ǵ°���
		//Test098.java:33: error: num has private access in CircleTest2 �׸��� ���� �ȵ� 
		
		//ob.setter(10);

		//System.out.println(ob.getter());

		ob.input();//private�� �ǰ� ��ü�� ��������� �����ϰ� num�� �����Ҽ� �ִ� ���
		//ob.num = �츮�� �Է����ִ� ��

		double area = ob.calArea();
		ob.write(area);

		/*
		������ �Է�500
������500
���� ����785398.0
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/



	}
}
public class Test068
{

	//Ŭ������ ����

	//���� ���� a ����(Ŭ������������ ���� ���̴� ����

	int a; //Ŭ�������� ������ ����a
	double b;
	char c;
	boolean d;


	public static void main(String[] args)
	{

		Test068 ob = new Test068();//�ν��Ͻ� ���� //�ۿ÷��� Test068�� �޸𸮿� �Ҵ��ϰ� ob���� Test068Ŭ������ �ۿ÷��� �޸��� �ּҰ� ����ְ� 
		//ob.a; //�� ���� class Test068�� �ۿ÷��� �޸𸮸� �����Ͽ� int a�� �ҷ��ü� �ִ�.
		System.out.println("a : "+ob.a);
		System.out.println("b : "+ob.b);
		System.out.println("c : "+ob.c);
		System.out.println("d : "+ob.d);
/*
		a : 0 int �� 0���� �ʱ�ȭ�� ������
		b : 0.0    double �� 0.0���� �ʱ�ȭ
		c :        char �� ���ڷ� �ʱ�ȭ
		d : false boolean �� false�� �ʱ�ȭ
		����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . . �� ���� ���� ���´�.
		�� ���������� �ʱ�ȭ�� ��Ű�� ������ ������ ������
		���������� �ʱ�ȭ�� ��Ű�� �ʰ� �����ص� �ʱ�ȭ�� �����ش�.
*/





	}

}
/*
Test068.java:13: error: non-static variable a cannot be referenced from a static context
                System.out.println("a : "+a);
                                          ^
1 error
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . .

069�� �޸� �ʱ�ȭ �Ǿ����� �ʾ� �߻��ϴ� ������ �ƴ�

static ������ �ƴ϶� ������ �߻��Ѵ�. ��� ��������

main���� static�� �پ������� class�ȿ��� �پ���������


������ �������� �Ѵ� ���� �ʱ�ȭ ��Ű�� ������ ����

Ŭ�������� �����������ص� �׳� ���� ���� class�� ��üȭ �Ǿ�� ��

�� Test068 Ŭ������ ������� �ν��Ͻ� ������ �ʿ�



*/

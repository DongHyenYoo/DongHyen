//Ŭ������ �ν��Ͻ�
// Test071�� CircleTest.java���ϰ� ��Ʈ��
//���� ���̿� �ѷ��� ���ϱ�
//(Ŭ������ : CircleTest) -> CircleTest.java
//BufferedReader �� readLine();

//���� ���� = ������ * ������ * 3.141592
//���� �ѷ� = ������ * 2*3.141592

//���� ��

//������ �Է�

//�������� xxx�� ����
//����

//�ѷ�����ϰ� �ϱ�
//���� Ŭ�������� �޼ҵ尡 ����.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CircleTest
{  //�ֿ� �Ӽ�(������) �̰��� �������ִ� �������� CircleTest�� ��� ���� / �������ִ� �޼ҵ�� ��� �޼ҵ��� �Ѵ�. �� �ҼӰ��踦 �ǹ��ϴ°�
	//�̰͸� �ְ� �������ϸ� ������ �����Ѵ� = main�޼ҵ尡 �����Ƿ�
	int r;
	double PI = 3.141592;


	//�ֿ� ���(����, ����) -> ��� �޼ҵ�
	// ������ �Է� ��� -> �޼ҵ� ����

	//���� ��� ��� -> �޼ҵ� ����
	// �ѷ� ��� ��� -> �޼ҵ� ����
	//��� ��� ��� -> �޼ҵ� ����

	void input()throws IOException{ //�Է��� �� �ȿ����� �������� ���̱⿡ �̾ȿ��� ����ó���� �ؾ��Ѵ�.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //class �� ������ �ٰ� ��ü���� �����ϴ� ������ �������� �׷��� ���� ����
																				  //main���� �� class�� �޸𸮿� �ۿø��µ� �̶� class������ ������ ��ü�� �ٷ� �޸𸮿� �ۿ÷���
		System.out.print("������ �Է� : ");										  //�� ���� �ʿ信 ���� ��ü�� �޸𸮿� �ö� �� �Է¹��� ��Ȳ�� �ƴѵ��� Buffered ��ü�� ��� �޸𸮿� ������ -> ������ ���Ҷ��� ��� ����Ʋ�����Ͱ�����.
		r = Integer.parseInt(br.readLine());									   //input�� Buffered ��ü�� ������ ��� input�� ȣ���������� �� ��ü�� �����Ǿ��ٰ� �޸𸮿��� ������
																					//�� Ŭ���� ������ BufferedReader br�� �����ϰ� �޼ҵ�ȿ��� �������� �ۼ��ϸ� ��� �޼ҵ尡 br�� ����Ѵٸ� �̰� �������ʴ�.
	}

	double callRound(){

		double result;

		result = 2*r*PI;

		return result;
		
		
	}

	double callArea(){
		double result;

		result = r*r*PI;
		return result;

}

	void print(double a, double b){

		System.out.printf("�ѷ��� %d�� ����\n",r);
		System.out.printf("���� : %.2f\n",a);
		System.out.printf("�ѷ� : %.2f\n",b);

	}
}
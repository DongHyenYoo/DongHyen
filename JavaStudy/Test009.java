//�ڹ��� ���� �� Ư¡
//������ �ڷ��� - 5����
//������ �ڷ��� �ǽ� �� �׽�Ʈ : double
//������ ���� �ǽ�

public class Test009{

	public static void main(String[] args){

		//������ ������ ������
		double a = 1/2;
		//double a = 0;
		System.out.println("double a : " +a);
		//--==>> double a : 0.0

		double b = (double)1/2; // 1�� double�� ���� ������ ���� �ϳ��� �Ǽ���� �Ǽ������ ������ �����Ѵ�.
		                        //1.0 /2 �� �Ǿ� �Ǽ� ������ �����ϴ°��� �°�
								//(double)0 �� �Ǵ� ���� �ƴϴ�.
		//double a = (double)0;
		System.out.println("double b : " + b);
		//--==>>double b : 0.5

		// double c = 1/2 + 1/2;  ����� 0.0�� ����
		
		double c = 1/2 + 1/2;
		System.out.println("double c : " + c); // 0.0

		double d = 1 / 2.0; //�� �����ڷ� �Ǽ��� ���ԵǾ� �ִ� ������ ����
		System.out.println("double d : " + d);
		//����� 0.5
		//������ ����� �����Ͽ� 
		//�ǿ����� �� �Ǽ��� �ϳ��� ���ԵǾ� �ִٸ�
		// ������ �Ǽ� ����� ������ ����Ǹ�
		//��� �� ���� �Ǽ� ���·� ��ȯ

		double e = 3/2 + 1/2;
		//double e = 1 + 1/2;
		//double e  = 1 + 0;
		//double e = 1;
		System.out.println("double e : " + e);
	    // ����� �Ǽ������� ��ȯ�Ǿ� 1.0
		
		double f = 3/2 + 1/2.0;
		//f = 1 + 1/2.0
		//f = 1 + 0.5;
		//f = 1.5;
		System.out.println("double f : " + f);
		//double f : 1.5




	}




}
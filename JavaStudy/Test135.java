/*===================================
�ڹ��� �ֿ� Ŭ����
-�ڹٿ��� �⺻������ �����ϴ� �ֿ� Ŭ������
Wrapper Ŭ����
================================*/


public class Test135
{
	public static void main(String[] args)
	{

		System.out.println(Integer.MAX_VALUE); //�������� �ִ밪�� �����ش�.
		System.out.println(Integer.MIN_VALUE);  //Ŭ������.�����Ƿ� Integer�� Ŭ������ Ŭ���� ������ MIN_VALUE,MAX_VALUE

		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);

		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);

		//2147483647
		//-2147483648

		//9223372036854775807
		//-9223372036854775808
		//1.7976931348623157E308
		//4.9E-324


		System.out.println(); 


		//�Ǽ� ����� ������ ���� ���� �������� ��� ����
		//

		System.out.println(" 1 : " + 3.0/0); //0���γ����� ���Ѵ밡 �����Ƿ� ��°�� ����
		System.out.println(" 2 : " + -3.0/0); //0���γ����� ���Ѵ밡 �����Ƿ� ��°�� ���̳ʽ� ����

		System.out.println(" 3: " + (3.0/0 == 3.0/0));
		System.out.println(" 4: " + (3.0/0 == -3.0/0));
		//true
		//false

		//Double.isInfinite() ���� is�̹Ƿ� �´��� �ƴ��� �Ǵ��ؼ� true false�� ��ȯ

		System.out.println(" 5 : "+ Double.isInfinite(3.0/0));
		System.out.println(" 6 : "+ Double.isInfinite(-3.0/0));
		//5 : true
		//6 : true

		System.out.println(" 7 : " + (3.0/0 + -3.0/0)); 
		//NaN (Not a Number)
		System.out.println(" 8 : "+ (0.0/0));
		//NaN

		System.out.println("9 : " + (0.0/0 == 0.0/0));
		//false �Ѵ� NaN�ε�?? �ǿ����ڿ� NaN�� ���Ե�������� ������ false�� ���´�.
		System.out.println("10 : " + (0.0/0 != 0.0/0));
		//true

		//NaN ���� ������ ����
		// ũ�� �񱳸� �����ϴ� == �����ڸ� ���� �� ������ �����ϰ� �Ǹ�
		// ����� ������ false�� ��ȯ�Ѵ�.

		//if(x == NaN) �̷����̸� ������ if �� ������ �ȵȴ�. false��
		
		//Double.isNaN()
		System.out.println("11 : " + Double.isNaN(0.0/0)); //true NaN�̹Ƿ�
		System.out.println("12 : " + Double.isNaN(1.1+2.2)); //false  NaN�� �ƴϹǷ� false
	}
}
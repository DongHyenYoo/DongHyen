/*===================================
Ŭ������ �ν��Ͻ�
�޼ҵ� �����ε�(�ߺ� ����)�� ������ ���¿� �Ұ����� ����
================================*/

public class Test104
{
	public static void main(String[] args)
	{

		print(4.0);
		
		
	}

	public static void print(int i){
		System.out.println("1");
	}
	//public static void print(int j){} �Ű������� �̸��� ����̾���.
	
	public static void print(char c){
		System.out.println("2");
	} //���������� �̷������δ� ���� �ʾƾߵȴ�.
//int char�� �ڵ�����ȯ ��Ģ�� �ش�Ǽ� ���ϼ� �ִ�.
	//'a'�� �Ѱ������� 65�� �ڵ�����ȯ�� �����ϴ�.

	public static void print(double d){
		System.out.println("3");
	} //int -> double char -> double�� �ڵ�����ȯ ��Ģ�� �����ؾ��Ѵ�.
//	public static double print(double e){return 10.0;}
}
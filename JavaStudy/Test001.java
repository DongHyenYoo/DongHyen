import java.io.IOException;

class ForTest
	{
}


public class Test001
{
	public static void main(String[] args)throws IOException
	{
		//	System.out.println("welcome to java");
		//	System.out.println("first java programming");
			
	//		Integer a = 1;
	//	Integer b = 2;

	//		int c= a.compareTo(b);
	//		System.out.print(c);

			Character plus=' ';

			do
		{
			System.out.print("�߰� �����Ͻðڽ��ϱ�? (Y/N): ");
			plus = plus.toUpperCase((char)System.in.read());
			
		}
		while (!plus.equals('Y') || !plus.equals('N'));
	}




}
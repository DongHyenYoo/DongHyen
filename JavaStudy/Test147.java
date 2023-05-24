/*===================================
\\\\\\\\\\\���� ó��/////////
================================*/

/*���α׷����� �߻��ϴ� ������

1.�߸��� ������ ����ϰų� �������� �������� ���� ���¿���
  ��������ν� ������ �ܰ迡�� �߻��ϴ� �������� ����(Error)��

  2.���α׷��� �����ϴ� �������� �߻��Ǵ� ��Ÿ�� ����(Error)��
  ������ �ִ�.

  -���� �м��� �߸��ϰų� �Ǽ��� ����
	�߸��� ����� �������� �Ǵ� ������ ����(Error)��

  -�ý��� �̻󿡼� �߻��Ǵ� �ý��� ����(Error),�׸���

  -���α׷� ���� �� �߻��Ǵ� ���������� ��Ȳ�� �ǹ��ϴ�
   ���ܻ���(Exception)�� �ִ�.

   ���� ���
   -� ���� 0���� �����ų�
   -�迭�� �����ϴ� �������� ÷�ڸ� ����� ��Ȳ�� �߻��ϰų�
   -�������� �ʴ� ������ �����Ͽ� �о���δٰų�

   =>�����ڰ� �̷� ���� ������ �߻��� ��츦 �̸� �����Ͽ�
   ������ �����ϱ� ���� ������ �����ϵ��� ������ ������ ���� ����
   ����ó����

  ������ ���� ����! (Exception Ŭ����)

  -���ܴ� ���α׷� ���� �߿� �߻��� �� �ִ�
	��ɾ��� �������� �帧�� �����ϴ� �̺�Ʈ��
	�ڹٿ��� ���ܴ� �ϳ��� ������Ʈ(Object, ��ü)�̴�.

	-���α׷� ���� �߿� �޼ҵ� �ȿ��� ����(Error)�� �߻��� ���
	�޼ҵ�� �� ������ �ش��ϴ� ���� ������Ʈ�� �����
	�װ��� �ڹ� ��Ÿ�� �ý���(Runtime System)�� ������ �ش�.

	-�ڹٿ����� ��� ���� Ŭ������ Throwable Ŭ������
	Throwable Ŭ������ ���� Ŭ������ ��ӹ޾� ����Ѵ�.

	-Throwable Ŭ������ ���ܸ� �����ϴ� �����̳�
	���ܰ� �߻��� ���� ���α׷��� ���¿� ���� ������ �����ϰ� �ִ�.

	-Throwable Ŭ�������� �Ļ��� Ŭ����

		Exception Ŭ����
		Exception ���� Ŭ������ �Ϲ������� ���α׷��ӿ� ����
		������ �� �ִ� ���� ��Ȳ����
		�޼ҵ尡 ���� �߿� ������ ���ܸ� ����Ų��.

		ErrorŬ����
		�ɰ��� ������ ���·� �����ڰ� ������ �� ���� ������ �����̴�.

-==������ ����

-checked exception
	�޼ҵ� ������ ���ܰ� �߻��� ���
	�޼ҵ带 ������ �� throws ���� �޼ҵ� ������ �߻��� �� �ִ�
	���ܵ��� ����� �ְų� �Ǵ� �� ���ܸ� try-catch�ؼ�
	ó���� �־�߸� �ϴ� �����̴�.
	�����Ϸ��� ������ �ϴ� �������� checked exception��
	throws�Ǵ°��� ���� Ȥ�� try-catch�Ǵ����� ���θ� �Ǵ��Ͽ�
	���α׷����� ���ܸ� � ������ε� ó������ ������
	������ ��ü�� �Ұ����ϴ�.

	-unchecked exception
	������ ó������ �ʾƵ� �����Ϸ��� üũ���� �ʴ�
	��Ÿ�� �ÿ� �߻��� �� �ִ� �����̴�.
	//�迭 ũ�� �������� ��� �������� �Ǵµ� ��Ÿ�ӿ����� ����. 
	//�װ� ��ý ����


	��� Exception�� ���� �� �ִ�.

		*/

	/*
java.lang.Throwable Ŭ������ �ֿ� �޼ҵ�

-String toString()
:Throwable ������ ���� ������ ���ڿ� ���·� ��ȯ�Ѵ�.

-void printStackTrace(PrintStream s)
-void pirntStackTrace(PrintWriter w)
:ǥ�� ��� ��Ʈ���� ���� ȣ�� ����� ������ �޼ҵ���� ����Ѵ�.

�ֿ� ��Ÿ�� ���� Ŭ����

-ArithmeticException
:��ġ ������ ����(0���� ������ ��)

-ArrayStoreException
:�迭�� �߸��� ������ ���� �����Ϸ� ���� ��� �߻��ϴ� ����
-IndexOutofBoundsException
 : �迭,���ڿ�,���� ��� �ε��� ������ ��� ��� �߻��ϴ� ����
-ClassCastException
:Ŭ���� ��ȯ�� �߸��� ��� �߻��ϴ� ����
-NullPointerException
:�� ��ü�� �����ϴ� ���(�ʱ�ȭ ���� ���� ���� ��� ��)
 �߻��ϴ� ����
-SecurityException
 :�ڹ��� ���� ���� ������ �����Ͽ������ �߻��ϴ� ����

	 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test147
{                                           //1.�������������� ������ ������
	public static void main(String[] args) //throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�ֿ� ���� ����
		int a,b,c;
	
		/*2 3
		try //������ �������� �ڵ�
		{
			System.out.print("ù ��° ���� �Է� : ");
		a = Integer.parseInt(br.readLine());
		System.out.print("�ι�° ���� �Է� :");
		b= Integer.parseInt(br.readLine());

		c = a+b;

		System.out.println("��� : "+c);
			
		}
		catch (IOException e) //IOException�� ����Ų ������ ������� ��ƶ�
		{
			//�߻��� ���ܸ� ó���ϴ� ����� �ۼ��ϴ� ����
			//�߻��� ���� IOException = checked exception
			//�޼ҵ带 �����ϴ� �������� throws �� ����
			// ��Ƴ��ų� ������ ������� ������ ������ �߻��ϴ� �����̴�.
			System.out.println(e.toString());
			//ù ��° ���� �Է� : asd
			//Exception in thread "main" java.lang.NumberFormatException: For input string: "asd"
			//�츮�� �ѹ������� ���Ǿ��ߴµ� �ɸ��� ���� �ѹ������� Unchecked Exception�̴�.
		}
		catch (NumberFormatException e2)
		{
			//NumberFormatException = unchecked Exception
			//��Ÿ�ӽ� �߻��� �� �ִ� ���ܷ�
			//�ݵ�� �����ʿ䵵, ��Ƴ� �ʿ䵵���� ������°�
			System.out.println(e2.toString());
			System.out.println("���������� �������Է�������");
			//java.lang.NumberFormatException: For input string: "asd"
			//���������� �������Է��ϼ���
			//ThrowableŬ������ ��ӹ��� �͵��̹Ƿ� Object�� toString�� Throwable���� �������̵���
		}
		*/


/* 4
		try //������ �������� �ڵ�
		{
			System.out.print("ù ��° ���� �Է� : ");
		a = Integer.parseInt(br.readLine());
		System.out.print("�ι�° ���� �Է� :");
		b= Integer.parseInt(br.readLine());

		c = a+b;

		System.out.println("��� : "+c);
			
		}
		catch (Exception e) //Exception���� ����Ŭ���� �� ������ ��ĳ������ �߻�
		{
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			System.out.println("printStackTrace...");
			e.printStackTrace();
			}

	*/

		try //������ �������� �ڵ�
		{
			System.out.print("ù ��° ���� �Է� : ");
		a = Integer.parseInt(br.readLine()); //Integer.parseInt���� ���ڿ��̶� ������ ��ȯ�Ҽ� ���� ������ �߻�
		System.out.print("�ι�° ���� �Է� :");//������ ������ �߻��ؼ� �� ������ ����ȵ� 
		b= Integer.parseInt(br.readLine());

		c = a+b;

		System.out.println("��� : "+c);
			
		}
		catch (Exception e) // main ���� throws Exception�ϸ� ��κ��� ������ ������.
					       //�츮�� ����ó���� �Ϸ��°��� �ƴ϶� ���ܸ� ��� �м��Ϸ��°��̹Ƿ� ���������� ��
		{
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			System.out.println("printStackTrace...");
			e.printStackTrace();
		}
		finally //���ܰ� �߻��ϰų� �߻����� �ʰų� ������ ����Ǵ� ���� 
		{
			System.out.println("����d");

		}

		//���� ȣ��Ǵ� �޼ҵ忡�� throws���� �ʰ� try catch�� ��ƹ�����
		//ȣ���� �޼ҵ忡���� ����ó�� �� �ʿ� ����.

		//checked Exception = 1,2�� �̿� ������ ����
		//unchecked Exception = 3,4 5�� �̿� ��Ÿ�� ����

	}
}
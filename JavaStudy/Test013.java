import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Test013{



	public static void main(String[] args)throws IOException
		{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int height, width;
		double area;

		System.out.print("�ﰢ���� ���� �Է� : ");
		
		height = Integer.parseInt(br.readLine());

		System.out.print("\n�ﰢ���� �غ� �Է� : ");
		width = Integer.parseInt(br.readLine());

		//����ڰ� �Է��� ������(���ڿ�)�� ���� ���·� ��ȯ�� ��
		//���� width�� ��Ƴ���
		//br.readLine() �̺κ��� ������͸� �Է��ϵ� ���ڿ������� �����ͷ� ��ȯ�ϰԵ�
		//Inter.parInt��� ������ ���ؼ� �� ���ڿ��� �������·� ��ȯ�Ͽ� width�� ��Ƴ���.


		area = (double)(height * width)/2;

		
		

		System.out.printf("\n�غ��� %d ���̰� %d�� �ﰢ���� ���� : %.2f\n",width,height,area);
		



/*�ﰢ���� ���� �Է� : 3

�ﰢ���� �غ� �Է� : 5

�غ��� 5 ���̰� 3�� �ﰢ���� ���� : 7.50
*/


	}








}
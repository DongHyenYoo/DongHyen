//�ڹ� ���α׷���
//-��� ������
//-BufferedReader
//-printf()


/*����ڷκ��� ������ ������ �ι� �Է¹޾�
��Ģ���� �� ������ ������ �����Ͽ�
�� ����� ����ϴ� ���α׷� ����
�� �Է¹޴� ������ BufferedReader�� Ȱ���� �� �ֵ��� �ϰ�
��¹޴°����� printf �޼ҵ� Ȱ���� �� �ֵ��� �Ѵ�.
���� ������ ������ ���ǻ� ���� ������� ó���Ѵ�.

//ù ��° ���� �Է� : 10
//�� ��° ���� �Է� : 2

10 + 2 = 12
10 - 2 = 8
10 * 2
10 /2 
10 % 2
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test021{

	public static void main(String[] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int strNum1, strNum2;

		int f,g;

		
		
		System.out.print("ù ��° ���� �Է� : ");
		strNum1 = Integer.parseInt(br.readLine());
		System.out.print("\n�� ��° ���� �Է� : ");
		strNum2 = Integer.parseInt(br.readLine());

		f = strNum1/strNum2;
		g = strNum1%strNum2;

		System.out.printf("\n%d + %d = %d",strNum1,strNum2,(strNum1+strNum2));
		System.out.printf("\n%d - %d = %d",strNum1,strNum2,(strNum1-strNum2));
		System.out.printf("\n%d * %d = %d",strNum1,strNum2,(strNum1*strNum2));

		System.out.printf("\n%d / %d = %d",strNum1,strNum2,(strNum1/strNum2));
		System.out.printf("\n%d %% %d = %d",strNum1,strNum2,(strNum1%strNum2));
		//printf�� ������ %�� ���� �ڿ� ������������ �����ϱ⿡ %�ϳ��� ���� ������
		//System.out.println("\n"+strNum1+" /" + strNum2 + "=" + (strNum1/strNum2));
		System.out.println("\n"+strNum1+"%" + strNum2 + "=" + (strNum1%strNum2));










	}







}
//������ �Է¹ް� ����
// ���������� ū�������� ���� ���Ͽ� ����� ����ض�

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test052
{
	public static void main(String[] args)throws IOException
		{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a,b,min,max,tot;
		tot = 0;
		
		System.out.print("ù ��° ���� �Է� : ");
		a = Integer.parseInt(br.readLine());
		System.out.print("\n�� ��° ���� �Է� : ");
		b = Integer.parseInt(br.readLine());

		if(a>b){
			max = a; 
			min = b; //if�ȿ� while�� �־ ���ó���� ����
		}
		else{   // else if �ȿ��� �־ ���ó������  //����ϱ� : if else �� �����ʱ�ȭ�� ��������� ������
			max = b;                                    //if-else if�� ������ ������ �ǵ帮�� �������ִٸ� ������ �����ʱ�ȭ
			min = a;
		}
		
		int i = min; //�Է¹��� ���� �������� �޴� i


		while(i<=max){ //min ��� i�� max�� �ɶ����� ���ϴµ� �̷��� max�� ���������� �׳� ���͹���
			tot += i;
			i++;

		}

		System.out.printf("\n%d ~ %d ������ �� : %d\n",min,max,tot);





	}

}
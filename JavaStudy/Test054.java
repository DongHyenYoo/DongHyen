//����ڷκ��� ���ϴ� ���� �Է¹޾�
//�ش��ϴ� �������� ����ϴ� ���α׷��� �����Ѵ�.
//��, 1��~9�ܻ����� ���� �Է¹��� ��Ȳ�̾ƴ϶��
// �̿����� �ȳ��� ���� ���α׷��� ������ �� �ֵ��� ó��;

//���� ��
//���ϴ� �� �Է� : 7
// 7 * 1 = 7
//~ 7 * 9 = 63


//���ϴ� ������ �Է� : 11
// 1���� 9������ ������ �Է��� ����


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Test054
{
	public static void main(String[] args)throws IOException
	{


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("���ϴ� �� �Է� : ");

		int num = Integer.parseInt(br.readLine());

		if(num > 9)
			{ // num > 9 || num<1 �� �� ������!
			System.out.print("1���� 9������ ������ �Է��� ����\n");
			return;
		}

		int i =1; //������ �������ٳ�

		while(i<=9){
			
			System.out.printf("%d * %d = %d\n",num,i,(num*i));
			i++;
		}

	
	}


}
//Ŭ������ �ν��Ͻ�

//����ڷκ��� ������ ������ �Է¹޾�
//1���� �Է¹��� �� ������ ���� �����Ͽ�
//������� ����ϴ� ���α׷��� �����Ѵ�.

//��, ���ݱ��� ó�� main() �޼ҵ忡 ������� �����ϴ� ���� �ƴ϶�
//Ŭ������ �ν��Ͻ��� ������ Ȳ���Ͽ� ó���� �� �ֵ����Ѵ�.
//hap Ŭ���� ����
//���� ������ ó�� �Է°������� BufferedReader�� readLine�� ����ϸ�
//�Էµ����Ͱ� 1���� �۰ų� 1000���� ū���
//�ٽ� �Է¹��� �� �ִ� ó���� �����Ͽ� ���α׷��� ���� �� �� �ֵ��� �Ѵ�.

//���� ��)
//������ ���� �Է�(1~1000) : 

//do while�� ���µ� 
//>> 1~ n������ ���� ~��
//
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Hap
{
	int n;
	//int result=0; result�� �ʿ��� ������ �����ϸ� �ȴ�.



	void input()throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//while(true){ //���� �ݺ� do while�ȿ����� �ᵵ�� //�����ϰ��� while�� �ʿ������.

			do
			{
				System.out.print("������ ������ �Է�(1~1000) : ");
				n = Integer.parseInt(br.readLine());
			}
			while (n<1||n>1000);
			
		

	}

	//}


	int sum(){

		int result = 0;

		for(int i=1;i<=n;i++){
			result += i; 

		}
		return result;

		//System.out.printf("1���� %d ������ ���� : %d�Դϴ�\n",n,result);
		//���ϰ��� int�ε� System.out.�� �Ἥ�׷���.
		

	}

	void print(int result){

		System.out.printf("1���� %d������ ���� %d\n",n,result);


	}

	
}


//import java.io.IOException; �� ���� �ȿ����� ����ó�� �ι����ص��� import�� class���� ����Ǳ�
//������ ��� �����־���Ѵ�.

public class Test072
{
	public static void main(String[] args)throws IOException
	{

		Hap ob = new Hap();  //��� �ν��Ͻ� ȣ���� 
		//�� class.input(); �̷��Դ� ������? �̰� �ٸ������� �����߱⿡
		//������ �ν��Ͻ��� ���� �Է� �޼ҵ� ȣ�� -> input()
		// --------------------
		//  ���������� Ȱ���ؾ��Ѵ�.

		ob.input();  //== new Hap().input(); �� ����.
		int result = ob.sum();
		ob.print(result); //ob.print(ob.sum()); �ص� �ȴ�.

		//main�ȿ� �ϴ��� ���γ����� �Ѵٰ�������� 
		//�ڹٴ� ���� Ŀ�ٶ��� ��ġū �ϳ��� Ŭ�������� ���� �������� Ŭ������ �ξ� ����.
		//�����ϰ� �������� �������� Ŭ�������� ����� �������ؾ��Ѵ�.
		

	}


}
//while
// 1/2 + 2/3 + 3/4 + 4/5 ..... 9/10
//�� ���� ó�� ����� ����ϴ� ���α׷��� �����Ѵ�.
//������ : xxx


public class Test049
{

	public static void main(String[] args)
	{
		int n = 1;
		double tot =0;

		while(n<=9){
			
			//temp = n;
			//++n;
			//tot += (float)temp/n;
			tot += (float)n/++n; // n�� ������ float�� ���� ��ȯ�� ������ �����Ѵ�.
    /*
	int n = 0;
	while(n<9)
		n++; //���������� �ݺ����� ������ ����Ʈ���� ����

		tot = n/(n+1)

	*/


		}

		System.out.printf("������ : %.4f ",tot); //printf���� �Ǽ� �ڸ��� ������ ���������� �ڵ����� 6�ڸ����� ����Ѵ�.






	}
}





//�� �ȴٻ����������� �ٽû����ϰ� ����
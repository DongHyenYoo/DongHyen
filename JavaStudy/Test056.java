//�������� ���� ������ �Է¹ް�
//�� ���� ����Ͽ� ����ϴ� ���α׷��� �ۼ��Ѵ�.
//�� -1�� �Ǵ� ���� �Է� ������ ����
//-1�� �Է����� Ŀ�ǵ�� ���
//do while���� Ȱ���Ͽ� ������ �ذ� �� �� �ֵ��� �Ѵ�.



public class Test056
{
	public static void main(String[] args)
	{

		java.util.Scanner sc = new java.util.Scanner(System.in);

		int num, i;
		i=0;
		int tot =0;

		do
		{	

			i++;
			System.out.printf("%d ��° ���� �Է�(-1 ����) : ",i);
			num = sc.nextInt();
			if(num == -1)

			tot += num;
			
		}
		while (num != -1); // �� num == -1 �� �ƴѰ� �翬�� ���ǽ��� ���̾���귯���µ�
		                   // �̰� -1�̾�� true�� �Ǵ°��̹Ƿ� �翬�� num != -1 �̴�.

			System.out.printf("������� �Էµ� ������ �� : %d ",(tot+1)); //



	}


}
//��Ʈ������
//�� ������ ����ִ� ����(��) �ٲٱ� -> swap
//xor ������ Ȱ��

public class Test024
{


	public static void main(String[] args)
		{

		int x = 20 , y = 23;

		//int temp;

		System.out.printf(" x -> %d, y -> %d\n", x, y);
		
		/* temp = x;
		x = y;
		y = temp; */

		x= x ^ y; // x = 0001 0100
		          // y = 0001 0111
				  //     0000 0011 = 3
				  //x =3


		y = y ^ x; // y = 0001 0111
		           // x = 0000 0011
				   //     0001 0100 = 20 = y

		x = x^ y; // x = 0000 0011
		          // y = 0001 0100
				  //     0001 0111 = 23 =x 

		System.out.printf(" x -> %d, y -> %d\n", x, y);






	}
}






/*===================================
�迭
-�迭�� �⺻�� Ȱ��
-�迭�� ����� �ʱ�ȭ
================================*/


//���� 
// ����ڷκ��� ������ �л� ���� �Է¹ް�
//�׸�ŭ�� ����(���� ����)�� �Է¹޾�
// ��ü �л� ������ ��, ���, ������ ���ؼ�

//����� ����ϴ� ���α׷��� ����

//�л��� �Է� : 4
//1�� �л��� ���� �Է� :98
//2�� �л��� ���� �Է�:65
//2�� �л��� ���� �Է�:78
//2�� �л��� ���� �Է�:6521

//�� : ~~~
//��� : 74
//���� :  (���������� - ��հ�)
//1���л� 90���� ���� : -16
//2���л� 65���� ���� : +9
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//2���� �迭�� �޼ҵ带 �̿��غ��� ���� ����
class Student									//���̵�� ����
{												//[�Է¹�����][2] �� �迭 ����
	int num;									//[2]���� �л��� ������ ������ �ִ´�.
												//[�Է¹�����+1][2]���� �հ� ����� �־��
	Student()throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�л��� ���� �Է� : ");
		num = Integer.parseInt(br.readLine());
	}

	int[][] scoreArr()throws IOException							//2���� �迭�� �Ѱ����ٴ� ������ �Ѱ����°���
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[num+1][2];

		for(int i=0;i<num;i++)							//arr.length�� �ϸ� �հ� ������ ���� ���� ������ ä����
		{
			alert(i+1);
			arr[i][0] = Integer.parseInt(br.readLine()); 
		}

		return arr;
	}

	void alert(int i)								//n��° �л��� ���� ����� alert�޼ҵ�
	{
		System.out.printf("%d��° �л��� ���� : ",i);
	}

	int sum(int[][] arr)							//�л����� ������ ��� �迭�� �޾� ���� ������ sum�޼ҵ�
	{
		int result=0;
		for(int i=0;i<num;i++)
		{
			result += arr[i][0];
		}
		return result;
	}

	int average(int sum)
	{
		int result = sum/num;
		return result;
	}

	int[][] deviation(int[][] arr, int average)
	{
		
		for(int i=0;i<num;i++)
		{
			arr[i][1] = arr[i][0]-average;
		}


		return arr;

	}
	
	void print(int[][] arr)
	{
		System.out.printf("�� : %2d\n",arr[arr.length-1][0]);
		System.out.printf("��� : %2d\n",arr[arr.length-1][1]);
		for(int i=0;i<arr.length-1;i++)
		{
			System.out.printf("%d�� �л��� ���� :%2d\n",i+1,arr[i][1]);

		}

	}



}
public class Test084
{

	public static void main(String[] args)throws IOException
	{
		Student ob = new Student();
		int arr[][] = new int[ob.num+1][2];
		int num = arr.length-1;					//�迭��0���� �����̴�.��� ���� ���� �迭�� �迭 ������ -1
		arr = ob.scoreArr();
		
		//for(int i=0;i<arr.length;i++)		//arr.length�� num+1���� ����. ��µ� ����
		//	System.out.println(arr[i][0]);

		arr[num][0] = ob.sum(arr);	//sum�޼ҵ�κ��� ���������� ���� �޾ƿ��°� Ȯ��
		int sum = arr[num][0];
		//System.out.println(sum);

		arr[num][1] = ob.average(sum);
		int average = arr[num][1];
		//System.out.println(average);	//sum���� �޾� ����� �޾ƿ°� Ȯ��

		arr = ob.deviation(arr,average);

		ob.print(arr);
		
/*�л��� ���� �Է� : 4
1��° �л��� ���� : 90
2��° �л��� ���� : 65
3��° �л��� ���� : 67
4��° �л��� ���� : 87
�� : 309
��� : 77
1�� �л��� ���� :13
2�� �л��� ���� :-12
3�� �л��� ���� :-10
4�� �л��� ���� :10
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .

*/




		


	
	}
}



/*		�޼ҵ带 �̿��� ���� ����
class Student
{
	int num;									//��������� �Է¹��� �л���
	

	Student()throws IOException					//��ü ������ ���ÿ� �л��� �ޱ�
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�л��� �Է� :\t");
		this.num = Integer.parseInt(br.readLine());
	}

												//�ʿ��� �޼ҵ�� ����?
												//�Է¹��� ������ �迭�ν� �����ϰ� ������ int[] �޼ҵ�
												//�Ѱܹ��� �����迭���� ���� ���� �޼ҵ�
												//����� ���� �޼ҵ�
												//������ ������ ������ �޼ҵ�
												//�� 3���� ������� �޼ҵ�
	
	int[] scoreArr()throws IOException			//�Է¹��� ������ �迭�ν� �����ϰ� ������ int[] �޼ҵ�
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[this.num];		
		for(int i=0;i<arr.length;i++)
		{
			alert(i);							//printf���� �̿��� n��° �л��� ������� �޼ҵ� �ݺ�ȣ��
			arr[i] = Integer.parseInt(br.readLine()); //�Է¹������� scoreArr���� ������ arr�迭�� ����
		}
		return arr;								//�Է¹��� ���� �迭�� ����
	}



	void alert(int i)							//void�� ������ �ٸ��ڷ��� �޼ҵ忡���� printf�� �������Ѵ�. �ؼ� scoreArr�� �ݺ����� ����i�� �޾ƿ� n�� �л����� ��� ����� �޼ҵ� alert
	{
		System.out.printf("%d�� �л��� ���� �Է� :",i+1);
	}

	int sum(int[] arr)						//�Ѱܹ��� �����迭���� ���� ���ϰ� ����� �޼ҵ�sum
	{
		int result=0;						//result�� ���� ��� ���س������̹Ƿ� �ʱ�ȭ
		for(int i=0;i<arr.length;i++)
		{
			result += arr[i];
		}
		
		return result;
	}

	
	int average(int totalScore)			//�Ѱܹ��� ��ü �տ��� ����� ���ϰ� �ѱ�޼ҵ� average
	{
		int result = totalScore/this.num;

		return result;
	}

	int[] deviation(int[] arr, int average)		//�л����� ���� �迭��, ��հ��� �޾� ������ ������ �迭�� �����ؼ� �Ѱ��� �޼ҵ� Deviation
	{
		int result[] = new int[arr.length];		//�л��� ���� ������ ���� ����.
		
		for(int i=0;i<result.length;i++)
		{
			result[i] = arr[i]-average;
		}

		return result;
	}

	void print(int sum, int average, int[] arrDevi)
	{	
		System.out.printf("\n�л����� �� ������ :%2d\n",sum);
		System.out.printf("�л����� ��հ� :%2d\n",sum);
		System.out.println();
		for(int i=0;i<arrDevi.length;i++)
		System.out.printf("%d�� �л��� ���� : %2d\n",i+1,arrDevi[i]);

	}

	


}
public class Test084
{

	public static void main(String[] args)throws IOException
	{
		Student ob = new Student();
		System.out.println();

		int arr[] = new int[ob.num];

		arr = ob.scoreArr();					//1.�Է¹��� �������� �������� �޼ҵ� ȣ��

		//for(int i=0;i<arr.length;i++)			//�Է¹��� ���� �迭�� ����� ����Ǵ��� ���Ȯ��
		//System.out.printf("%d\t",arr[i]);     //��µ�
		
		//int sum = ob.sum(arr);				//�հ� ��½õ�
		//System.out.println(sum);				//��µ�

		//int average = ob.average(sum);		//��հ� ��½õ�
		//System.out.println(average);

		//int arrDevi[] = new int[ob.num];		//������ ���� �迭 ����
		
		//arrDevi = ob.deviation(arr,average);	//������ �迭�� ���� ���

		//for(int i=0;i<arrDevi.length;i++)		//���� ��½õ�
		//	System.out.printf("%d�� �л��� ������ : %d\n",(i+1),arrDevi[i]);


		int sum = ob.sum(arr);				//2.�迭�� �Ѱ��ְ� ���� �����ִ� �޼ҵ� ȣ��
		int average = ob.average(sum);		//3.���� �Ѱ��ְ� ����� �����ִ� �޼ҵ� ȣ��
		int arrDevi[] = new int[ob.num];   //4.����������  �л��� ���� ���� ���� �迭�� ����
		arrDevi = ob.deviation(arr,average); //5.������ ����� �޼ҵ忡 �л����� ������ ��հ� �Ѱ� ȣ��

		ob.print(sum,average,arrDevi);
		
		

	}
}�޼ҵ带 �̿��� ���� ��*/


//�׳� ������
/*public class Test084
{

	public static void main(String[] args)throws IOException
	{

		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�Է��� �л��� �� : ");
		int num = Integer.parseInt(br.readLine());

		int arr[] = new int[num];
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.printf("%d�� �л��� ���� �Է� : ",i+1);
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		int sum=0;

		for(int i=0;i<arr.length;i++)
		{
			sum += arr[i];
		}

		int average;
		average = sum/num;

		System.out.printf("\n�л����� ������ �� : %2d\n",sum);
		System.out.printf("������ ��� %2d\n",average);
		System.out.println();

		for(int i=0;i<arr.length;i++)
		{	
			int deviation = arr[i]-average;
			System.out.printf("%d�� �л��� ���� : %2d\n",i+1,deviation);
		}

		


		

		



	}


}*/ //�׳� ������ ��
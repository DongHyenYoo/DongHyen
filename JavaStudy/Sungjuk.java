import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
/*
public class Sungjuk
{
	int num; //�ο���
	Record[] rc; //�ǳ�
	
	void input()throws IOException //main���� ȣ�����״� main�� ����ó�� //�ο����� �Է¹ް� num�� ������ �޼ҵ�
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
		System.out.print("�Է��� �л����� �Է��ϼ��� : ");
		num = Integer.parseInt(br.readLine());
		}
		while (num<1 || num>100); //�ߵǴ°� Ȯ����
		 rc = new Record[num];
	}

	void saveData()throws IOException
	{
		String name;
		int k=1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i=0;i<num;i++)
		{
			int[] arr = new int[3];
			int total=0;
			double average=0.0;//�ʱ�ȭ ����
			System.out.printf("%d��° �л��� �̸� �Է� : ",i+1);
			name = br.readLine();
				switch(k)
				{
					case 1 : System.out.print("�������� �Է� : ");
							 arr[0] = Integer.parseInt(br.readLine());
							 total += arr[0];
					case 2 : System.out.print("�������� �Է� : ");
							 arr[1] = Integer.parseInt(br.readLine());
							 total += arr[1];
					case 3 : System.out.print("�������� �Է� : ");
							 arr[2] = Integer.parseInt(br.readLine());
							 total += arr[2];
							 break;
				}
			//System.out.printf("%d",total);
			average= total/(float)arr.length;
			//System.out.printf("%.2f",average);
			rc[i] = new Record(name,arr,total,average); //�ε�������?...��ǲ���� �ٷ� ��ü �迭���� �����ϸ� �ȴ�.
			}
				
		}
/*
		void saveData()throws IOException
	{
		String name;
		int total=0;
		double average;
		int[] arr = new int[3];
		int k=1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i=0;i<num;i++)
		{
			rc[i] = new Record();
			System.out.printf("%d��° �л��� �̸� �Է� : ",i+1);
			rc[i].name = br.readLine();
				switch(k)
				{
					case 1 : System.out.print("�������� �Է� : ");
							 rc[i].score[0] = Integer.parseInt(br.readLine());
							 rc[i].tot += rc[i].score[0];
					case 2 : System.out.print("�������� �Է� : ");
							 rc[i].score[1] = Integer.parseInt(br.readLine());
							 rc[i].tot += rc[i].score[1];
					case 3 : System.out.print("�������� �Է� : ");
							 rc[i].score[2] = Integer.parseInt(br.readLine());
							 rc[i].tot += rc[i].score[2];
							 break;
				}
			//System.out.printf("%d",total);
			rc[i].avg= rc[i].tot/3;
			//System.out.printf("%.2f",average);
			//rc[i] = new Record(name,arr,total,average); �ε�������?...
			}
				
		}


	void print()
	{

		//�������ϱ� 0~num���� i=1�� ������ �ٽ� 0~num�������ϱ� ������ ���ϴ� �������۴ٸ� *������* rank���� �ϳ��� ���ϱ�

		for(int i=0;i<num;i++) //�ϳ��� ������ ���� ���� �񱳰� �ȵǳ�
		{
			for(int j=0;j<num;j++)
			{
				if(rc[i].tot<rc[j].tot)
					rc[i].rank+=1;
			}
			
				
		}


		System.out.println();
		System.out.println();

		for(int i=0;i<num;i++)
		{
			System.out.printf("�̸� : %3s����:%2d ����:%2d ����:%2d ���� :%2d ��� :%.2f ��� : %d\n",rc[i].name,rc[i].score[0],rc[i].score[1],rc[i].score[2],rc[i].tot,rc[i].avg,rc[i].rank+1);
		}
	}

	
	
	
	
	
	
	
	}

*/
public class Sungjuk
{
	//�ֿ� �Ӽ� ���� ����2�� �޼ҵ� 4��

	int inwon;
	Record[] rec;		//Record �迭(�л� �Ѹ�� Record �迭 �� �Ѱ� Ȱ��)
						//Record�� ������� ������ ��ü�� ��Ƴ� �� �ִ� �迭

	//1.�ο��� �Է� �޼ҵ�
	public void set()	
	{
		Scanner sc = new Scanner(System.in);


	do
	{
		System.out.print("�ο� �� �Է�(1~100)");
		inwon = sc.nextInt();

	}
	while (inwon <1 || inwon >100);
	
	//���ڵ� Ŭ������ ������� ������ ��ü�� ���� �� �ִ� 
	//�迭���� inwon ��ŭ ������ ������
	//RecordŬ������ �ν��Ͻ��� ������ ���� �ƴϴ�.

	rec = new Record[inwon];
	}





	//2.�� ������ �Է�(���� �� ��� ���� ��� ����
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		String[] title = {"���� ���� : ","���� ���� : ","���� ���� : "};
		//�ο� �� ��ŭ �ݺ� -> �ο� ���� ����Ͽ� ������� �迭�� ���̸�ŭ �ݺ�
	for (int i=0;i<inwon;i++)
	{
		
		rec[i] = new Record();

		
		System.out.printf("%d��° �л��� �̸� �Է� :", i+1);
		rec[i].name = sc.next();
		
		for(int j=0;j<title.length;j++)
		{
		System.out.print(title[j]);
		rec[i].score[j] = sc.nextInt();
		rec[i].tot += rec[i].score[j];
		}

		rec[i].avg = rec[i].tot/3.0;
		}
		

	}


	//3.��� ���
	public void print()
	{
		System.out.println();
		ranking();//��ŷ �޼ҵ� ȣ��
		for(int i=0;i<inwon;i++)
		{
			System.out.printf("%5s",rec[i].name);

			for(int j=0;j<3;j++)
			System.out.printf("%4d",rec[i].score[j]);

			System.out.printf("%5d", rec[i].tot);
			System.out.printf("%8.2f", rec[i].avg);
			System.out.printf("%d", rec[i].rank);
			System.out.println();
	}

	
}

	//4.���� ���� �޼ҵ� �߰�
	//Ŭ���� ���ο��� Ȱ���� �޼ҵ�� ���� - �������������� private
	private void ranking()  //Record�迭�� rank�Ӽ� �ʱ�ȭ ����� �����ϹǷ� void 
	{
		for(int i=0;i<inwon;i++)
			rec[i].rank = 1;

		
		for(int i=0;i<inwon-1;i++)
			for(int j=i+1;j<inwon;j++)
		{
			if(rec[i].avg>rec[j].avg)
				rec[j]+=1;
		
			else if(rec[i].avg<rec[j].avg)//�񱳴���� ����� �񱳱����� ��պ��� ũ�ٸ�
				rec[i].avg+=1;
				//�񱳱����� rank�� 1��ŭ ����
				
		}


	}


}

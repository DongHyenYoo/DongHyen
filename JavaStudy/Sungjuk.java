import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
/*
public class Sungjuk
{
	int num; //인원수
	Record[] rc; //되네
	
	void input()throws IOException //main에서 호출할테니 main도 예외처리 //인원수를 입력받고 num에 저장할 메소드
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
		System.out.print("입력할 학생수를 입력하세요 : ");
		num = Integer.parseInt(br.readLine());
		}
		while (num<1 || num>100); //잘되는거 확인함
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
			double average=0.0;//초기화 조심
			System.out.printf("%d번째 학생의 이름 입력 : ",i+1);
			name = br.readLine();
				switch(k)
				{
					case 1 : System.out.print("국어점수 입력 : ");
							 arr[0] = Integer.parseInt(br.readLine());
							 total += arr[0];
					case 2 : System.out.print("영어점수 입력 : ");
							 arr[1] = Integer.parseInt(br.readLine());
							 total += arr[1];
					case 3 : System.out.print("수학점수 입력 : ");
							 arr[2] = Integer.parseInt(br.readLine());
							 total += arr[2];
							 break;
				}
			//System.out.printf("%d",total);
			average= total/(float)arr.length;
			//System.out.printf("%.2f",average);
			rc[i] = new Record(name,arr,total,average); //인덱스에러?...인풋에서 바로 객체 배열길이 선언하면 된다.
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
			System.out.printf("%d번째 학생의 이름 입력 : ",i+1);
			rc[i].name = br.readLine();
				switch(k)
				{
					case 1 : System.out.print("국어점수 입력 : ");
							 rc[i].score[0] = Integer.parseInt(br.readLine());
							 rc[i].tot += rc[i].score[0];
					case 2 : System.out.print("영어점수 입력 : ");
							 rc[i].score[1] = Integer.parseInt(br.readLine());
							 rc[i].tot += rc[i].score[1];
					case 3 : System.out.print("수학점수 입력 : ");
							 rc[i].score[2] = Integer.parseInt(br.readLine());
							 rc[i].tot += rc[i].score[2];
							 break;
				}
			//System.out.printf("%d",total);
			rc[i].avg= rc[i].tot/3;
			//System.out.printf("%.2f",average);
			//rc[i] = new Record(name,arr,total,average); 인덱스에러?...
			}
				
		}


	void print()
	{

		//석차구하기 0~num까지 i=1이 됬으면 다시 0~num까지비교하기 본인이 비교하는 수보다작다면 *본인의* rank값을 하나씩 더하기

		for(int i=0;i<num;i++) //하나만 있으면 앞의 값과 비교가 안되네
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
			System.out.printf("이름 : %3s국어:%2d 영어:%2d 수학:%2d 총점 :%2d 평균 :%.2f 등수 : %d\n",rc[i].name,rc[i].score[0],rc[i].score[1],rc[i].score[2],rc[i].tot,rc[i].avg,rc[i].rank+1);
		}
	}

	
	
	
	
	
	
	
	}

*/
public class Sungjuk
{
	//주요 속성 구성 변수2개 메소드 4개

	int inwon;
	Record[] rec;		//Record 배열(학생 한명당 Record 배열 방 한개 활용)
						//Record를 기반으로 생성된 객체만 담아낼 수 있는 배열

	//1.인원수 입력 메소드
	public void set()	
	{
		Scanner sc = new Scanner(System.in);


	do
	{
		System.out.print("인원 수 입력(1~100)");
		inwon = sc.nextInt();

	}
	while (inwon <1 || inwon >100);
	
	//레코드 클래스를 기반으로 생성된 객체를 담을 수 있는 
	//배열방을 inwon 만큼 생성한 것이지
	//Record클래스의 인스턴스를 생성한 것은 아니다.

	rec = new Record[inwon];
	}





	//2.상세 데이터 입력(총점 및 평균 산출 기능 포함
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		String[] title = {"국어 점수 : ","영어 점수 : ","수학 점수 : "};
		//인원 수 만큼 반복 -> 인원 수에 기반하여 만들어진 배열의 길이만큼 반복
	for (int i=0;i<inwon;i++)
	{
		
		rec[i] = new Record();

		
		System.out.printf("%d번째 학생의 이름 입력 :", i+1);
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


	//3.결과 출력
	public void print()
	{
		System.out.println();
		ranking();//랭킹 메소드 호출
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

	//4.석차 산출 메소드 추가
	//클래스 내부에서 활용할 메소드로 정의 - 접근제어지시자 private
	private void ranking()  //Record배열의 rank속성 초기화 기능을 수행하므로 void 
	{
		for(int i=0;i<inwon;i++)
			rec[i].rank = 1;

		
		for(int i=0;i<inwon-1;i++)
			for(int j=i+1;j<inwon;j++)
		{
			if(rec[i].avg>rec[j].avg)
				rec[j]+=1;
		
			else if(rec[i].avg<rec[j].avg)//비교대상의 평균이 비교기준의 평균보다 크다면
				rec[i].avg+=1;
				//비교기준의 rank를 1만큼 증가
				
		}


	}


}

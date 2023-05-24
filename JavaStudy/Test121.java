/*===================================
클래스 고급
인터페이스
================================*/

//실습 문제

//성적 처리 프로그램을 구현한다.
//단 인터페이스 활용 할것

//실행 예)
//인원 수 입력(1~10) : 11
//인원 수 입력(1~10) : 2

//1번째 학생의 학번과 이름 입력(공백 구분) :20227123 유동현
//국어 영어 수학 점수 입력 (공백구분):90 100 85
//2번째 학생의 학번과 이름 입력 : 2208225 최나윤
//국어 영어 수학 점수 입력 (공백 구분) : 85 70 65

//학번 최동현 90 100 85  총점  평균
//            수  수 우
//학번 최나윤 90 100 85  총점  평균
//            우 미  양

//인터페이스와 클래스만으로 위를 구현하자
// 인터페이스에는 메소드만 드가면 될듯
// 속성만 존재하는 클래스 -> 자료형
import java.util.Scanner;


interface SungJuk
{
	public void set(); //인원
	public void input(); //데이터 입력
	public void print(); //결과 출력
}

class Record 
{
	String hak, name;
	int kor, eng, mat;
	int tot;
	double avg;
}



class SungjukImpl implements SungJuk
{
	private int inwon;
	private Record[] rec;

	//내부적으로 등급에 대한 판정을 수행할 메소드
	
	@Override
		public void set()
	{
		Scanner sc = new Scanner(System.in);
		do
		{
		System.out.print("인원 수 입력(1~10) : ");
		inwon = sc.nextInt();
		}
		while (inwon<1 || inwon>10);

		rec = new Record[inwon];
	}

	@Override
		public void input() //데이터 입력
	{
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<rec.length;i++)//클래스형 배열에 객체를 넣는다.
		{
			rec[i] = new Record();//배열에 객체 넣기
			System.out.printf("%d번째 학생의 학번과 이름 입력 : ",i+1);
			rec[i].hak = sc.next();
			rec[i].name = sc.next();
			
			System.out.printf("국어 영어 수학 점수 입력 : ");
			rec[i].kor = sc.nextInt();
			rec[i].tot += rec[i].kor;

			rec[i].eng = sc.nextInt();
			rec[i].tot += rec[i].eng;

			rec[i].mat = sc.nextInt();
			rec[i].tot += rec[i].mat;

			rec[i].avg = rec[i].tot/3.0;
		}
	}


	@Override
		public void print()
	{   
		System.out.println();
		System.out.println();
		
		for(int i=0;i<rec.length;i++)
		{
			System.out.printf("%s %4s %3d %3d %3d %4d %7.2f",rec[i].hak,rec[i].name,rec[i].kor,rec[i].eng,rec[i].mat,rec[i].tot,rec[i].avg);
			System.out.printf("\n\t\t   %2s %2s %2s",panjung(rec[i].kor),panjung(rec[i].eng),panjung(rec[i].mat));
			System.out.println("\n");
		}		
	}


	private String panjung(int score) //점수 입력받아서 수우미양가 정하기
	{
		
		if(score>=90)
			return "수";
		else if(score>=80)	
			return "우";
		else if(score>=70)			
			return "미";
		else if(score>=60)	
			return "양";
		else
			return "가";
	}

}




public class Test121
{
	public static void main(String[] args)
	{

		SungjukImpl ob0 = new SungjukImpl();
		SungJuk ob = (SungJuk)ob0;
		//SungJuk ob = new SungjukImpl(); 같은거다
		ob.set();
		ob.input();
		ob.print();
	
	}
}
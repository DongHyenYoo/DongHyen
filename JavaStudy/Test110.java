/*===================================
정렬 알고리즘
과제
사용자로부터 여러 학생의 성적 데이터를 입력받아
점수가 높은 학생부터 낮은 순으로 등수를 부여하여
결과를 출력하는 프로그램을 구현
단 배열과 정렬 알고리즘을 활용하여 작성할 수 있도록 한다.

예)
인원수 입력 : input메소드

이름점수입력(1, 공백 구분) : 장현성 90
이름점수입력(2, 공백 구분) : 유동현 85
이름점수입력(3, 공백 구분) : 김태민 80

-------------------
1등 장현성 90
2등 유동현 85
.
.
.
.
.------------------
계속하려면 아무키나 누르세요
================================*/
import java.util.Scanner;

class Student //학생 클래스로 학생형 배열 만들장
{
	int score;
	String name;
	int rankNum;
}


class Ranking
{
	int num;
	Student[] ob;

	void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("인원수 입력하세요 : ");
		num = sc.nextInt();
		ob = new Student[num+1];
	}
	
	void score()
	{
		Scanner sc = new Scanner(System.in);
		int score;
		String name;

		for(int i=0;i<num;i++)
		{
			ob[i] = new Student();
			System.out.printf("이름 성적 입력 공백구분(%d) : ",i+1);
			ob[i].name=sc.next();
			ob[i].score=sc.nextInt();
			
		}
		ob[num] = new Student();
	}
		

	void rank() //score 비교해서 랭크 매기기
	{	
		for(int i=0;i<ob.length-1;i++)
			ob[i].rankNum=1;


		for(int i=0;i<ob.length-2;i++)
		{
			for(int j=1+i;j<ob.length-1;j++)
			{
				if(ob[i].score>ob[j].score)
				{
					ob[j].rankNum+=1;
				}
				else if(ob[i].score<ob[j].score)
				{
					ob[i].rankNum+=1;
				}

			}
		}

		reArr();

	}


	void reArr()
	{
		int pass=1;
		boolean flag;
		do
		{
			flag=false;
			pass++;
			for(int i=0;i<ob.length-pass;i++)
			{
				if(ob[i].rankNum>ob[i+1].rankNum) //랭크값 기반으로 1등부터 오름차순 정렬
				{
					ob[num] = ob[i];
					ob[i] = ob[i+1];
					ob[i+1] = ob[num];
					flag=true;
				}


			}
			

		}
		while (flag);
	}

	void print()
	{
		System.out.print("-----------------------------\n");
		for(int i=0;i<ob.length-1;i++)
			System.out.printf("%d등%4s%3d\n",ob[i].rankNum,ob[i].name,ob[i].score);

		System.out.print("-----------------------------");
	}


}

public class Test110
{
	public static void main(String[] args)
	{
		Ranking ob = new Ranking();
		ob.input();
		ob.score();
		ob.rank();
		ob.print();

	/*
	인원수 입력하세요 : 6
이름 성적 입력 공백구분(1) : 민찬우 87
이름 성적 입력 공백구분(2) : 엄소연 76
이름 성적 입력 공백구분(3) : 김보경 84
이름 성적 입력 공백구분(4) : 김유림 91
이름 성적 입력 공백구분(5) : 김인교 93
이름 성적 입력 공백구분(6) : 유동현 65
-----------------------------
1등 김인교 93
2등 김유림 91
3등 민찬우 87
4등 김보경 84
5등 엄소연 76
6등 유동현 65
-----------------------------계속하려면 아무 키나 누르십시오 . . .


	*/
	}

}
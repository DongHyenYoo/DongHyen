//이 클래스로 객체를 생성시 학생 한명의 객체가 만들어지게 해라

public class Record
{
	//학생 한명을 표현할 수 있는 속성들로 구성
	//String[] name;
	//int[] kor;

	String name;
	int[] score = new int[3]; 

	int tot;	//총점
	double avg;	//평균
	int rank; //석차

	public Record()//String name, int[] score, int total, double average)
	{
	//	this.name = name;
	//	this.score = score;
	//	this.tot = total;
		//for(int i=0;i<score.length;i++)
		//	this.tot += score[i];

	//	this.avg = average;
		//this.avg = this.tot/3; 
		//주석은 안됬을때 예비용
	}

}

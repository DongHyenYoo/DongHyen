//��� �ǽ�
// if��
//if - else �� �ǽ�

//���α׷��� �ۼ��� �� �־��� ���ǿ� ����
//	�б� ������ ���ϱ� ���� ����ϴ� �������
//  if�� if ~ else ��. ���� ������ , ���� if �� )if �� ��ø
//  switch�����ִ�.

//2.if���� if ������ ������ ���� ���
//	Ư�� ������ �����ϰ��� �� �� ���Ǵ� �����̴�.

// ����ڷκ��� �̸�. ��������. ��������. ���������� �Է¹޾�
//����� ��� ���� �������� ó���Ѵ�.

//90�� �̻� A
//80�� �̻� 90�� �̸� : B
//70 �� �̻� 80�� �̸� : c
// 60�� �̻� 70�� �̸� : D
// 60�� �̸� : F
//BufferReader Ȱ���� ������ �Է¹ް� �ϸ�
//printf �޼ҵ� ���� ���


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Test031
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/*
		String name;
		int kor,eng,mat;
		double totav;
		char grade;

		totav = (kor+eng+mat)/3.0;

		System.out.print("����� �̸��� �Է� : ");
		name = br.readLine();

		System.out.print("\n����� ���������� �Է� : ");
		kor = Integer.parseInt(br.readLine());

		System.out.print("\n����� ���������� �Է� : ");
		eng = Integer.parseInt(br.readLine());

		System.out.print("\n����� ���������� �Է� : ");
		mat = Integer.parseInt(br.readLine());*/


//������ �������� ���� ���Ƽ� ����°� �ƴ� �׶��׶� �����ϴ°��� ������������.

		String strName = br.readLine();
		String strKor = br.readLine();
		String strEng = br.readLine();
		String strMat = br.readLine();

		int nKor = Integer.parseInt(strKor);
		int nEng = Integer.parseInt(strEng);
		int nMat = Integer.parseInt(strMat);

		int nTot = nKor + nEng + nMat;
		double fAvg = nTot / 3.0;

		char grade;




		if(fAvg >= 90){

			grade = 'A';
		}
			

			else if( fAvg >= 80){ //���� ���ж����� ����� 90�̸��� ������ ���ԵǾ��ֵ�.
				grade = 'B';

			}
			
			else if(fAvg >= 70 ){

				grade = 'C';

			}
			else if(fAvg >= 60){

				grade = 'D';
			}
			else
			{
				grade = 'F';

			}
		
		//���⼭ else�� ������ ������ ���µ� �̴� else�� ����� �ƴ϶� 
		// ��±������� grade�� �ۼ��Ǿ��ִ�. java�� ���߿� ���������� ������ ����Ű����� �ȳѾ�µ�
		//else�� ������ grade �� ����ġ ���ϴٰ� �����ϰ� ���쿡���� grade�� ���� ä������ �Ѵٰ� ������
		//�ؼ� D���� <= 70���� �ٲٴ��� �������� ���� �������� ������ ���������Ƿ� �ȵ�

	   //���� char grade = 'F'�� �⺻������ ä��� �ȴٸ� else�� ��� ��±����� ������ ���ٰ� �Ǵ��ؼ� �����
	   //if ȥ�� ��밡�� else ȥ�ڻ�� �Ұ��� 
	   //if else�� �ϳ��� ȥ��ü�� �����ϴµ� if/else���̿��� ��Ѱ͵� ���������� ���ü� ���⿡
	   //if�� �ȿ��� int�� ���� �ڷ����� ���� ������ �� �ִ�. �� �̰��� �� ���� �ȿ� ���ӵǸ� ������ ������ ����.

	   //���� main���� �����ٸ� ���ο� �޼ҵ带 �����ϰ� ���� �̸��� ������ �����ص� �ȴ�.

			

		
		System.out.printf("����� �̸��� %s �Դϴ�.%n",strName);
		System.out.printf("���������� %d �Դϴ�.%n",nKor);
		System.out.printf("���������� %d �Դϴ�.%n",nEng);
		System.out.printf("���������� %d �Դϴ�.%n",nMat);
		System.out.printf("��������� %.2f �Դϴ�.%n",fAvg);
		System.out.printf("������ : %c%n",grade);


		//���ǹ����� ����Ұ�
		//














	}







}
public class Test045
{
	public static void main(String[] args){

	int n =0, evenSum= 0;

	while(++n <= 100){

		//n++; n=0 일때 조건식에 <와 함께 씀
		 ++n;

			evenSum += n;

		}


	System.out.println(evenSum);
	
	
	}

}
/*===================================
■■■컬렉션 프레임워크■■■ 
================================*/
//List -> String[] : List.toArray(); list에 담긴걸 문자열 배열로
//String[] -> List : Arrays.asList();

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Test167
{
	public static void main(String[] args)
	{
		List<String> mList = new ArrayList<String>();

		mList.add("1");
		mList.add("2");
		mList.add("3");

		System.out.print(mList.get(1));

		String[] sArrays = mList.toArray(new String[mList.size()]); //List -> String[]
		System.out.print(sArrays.length);
		
		for(String str :sArrays)
			System.out.print(str + "  ");

		System.out.println();


		
		List<String> list2 = Arrays.asList(sArrays);//이 메소드의 반환자료형 = List					//String[] -> List 
		
		for(String str : list2)
			System.out.print(str + "  ");
		System.out.println();

		
	}
}
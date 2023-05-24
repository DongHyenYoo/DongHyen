/*===================================
�����÷��� �����ӿ�ũ���� 
================================*/
//List -> String[] : List.toArray(); list�� ���� ���ڿ� �迭��
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


		
		List<String> list2 = Arrays.asList(sArrays);//�� �޼ҵ��� ��ȯ�ڷ��� = List					//String[] -> List 
		
		for(String str : list2)
			System.out.print(str + "  ");
		System.out.println();

		
	}
}
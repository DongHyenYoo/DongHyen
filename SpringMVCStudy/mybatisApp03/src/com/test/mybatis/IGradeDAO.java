package com.test.mybatis;

import java.util.ArrayList;

public interface IGradeDAO
{
	public int count();
	public ArrayList<GradeDTO> list();
	public int add(GradeDTO g);
	
	public GradeDTO search(String sid);
	public int modify(GradeDTO g);
	public int remove(String sid);

}

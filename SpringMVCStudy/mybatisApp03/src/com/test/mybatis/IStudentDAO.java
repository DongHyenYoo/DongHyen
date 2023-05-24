package com.test.mybatis;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IStudentDAO
{
	
	public ArrayList<StudentDTO> list() throws SQLException;
	public int add(StudentDTO dto) throws SQLException; 
	public int count();
	public StudentDTO search(String sid);
	public int modify(StudentDTO dto) throws SQLException;
	public int remove(String sid);

}

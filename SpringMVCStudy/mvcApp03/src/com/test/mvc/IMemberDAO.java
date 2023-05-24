package com.test.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IMemberDAO
{
	
	
	
	public ArrayList<MemberDTO> list() throws SQLException ;
	
	public int add(MemberDTO member) throws SQLException;
	
	public int count() throws SQLException;
	
	
}

package com.test.spr;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDAO
{
	//실행 정리
	//IDAO생성
	//DTO생성
	//DAO생성
	//List생성
	//main
	
	public ArrayList<MemberDTO> list() throws ClassNotFoundException, SQLException;

}

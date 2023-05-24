/*
 #07. IRegionDAO.java
 - 인터페이스
 */

package com.test.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.servlet.mvc.Controller;

public interface IRegionDAO
{
	
	//추후 RegionDAO에서 정의할 것으로 예상되는 메소드에 대한 선언
	
	public ArrayList<Region> list() throws SQLException; //--출력
	public int add(Region region) throws SQLException;  //--입력
	public int remove(String regionId) throws SQLException;   //--삭제
	public int modify(Region region) throws SQLException;
	public Region serarchId(String regionId) throws SQLException;
	
	public ArrayList<Region> regList() throws SQLException;
}

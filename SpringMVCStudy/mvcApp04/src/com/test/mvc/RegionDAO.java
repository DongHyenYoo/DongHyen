/*
 #11. RegionDAO.java
 - 데이터베이스 액션 처리 클래스
				   직원 데이터 입출력 및 수정 삭제 액션
				   Connection 객체에 대한 의존성 주입 준비
				   (인터페이스 속성 구성 / setter 정의)
 */

package com.test.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class RegionDAO implements IRegionDAO
{
	
	private DataSource dataSource;
	
	

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Region> list() throws SQLException
	{
		
		ArrayList<Region> result = new ArrayList<Region>();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT REGIONID, REGIONNAME, DELCHECK"
				  + " FROM REGIONVIEW ORDER BY REGIONID";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			Region region = new Region();
			region.setRegionId(rs.getString("REGIONID"));
			region.setRegionName(rs.getString("REGIONNAME"));
			region.setDelCheck(rs.getInt("DELCHECK"));
			
			result.add(region);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public int add(Region region) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "INSERT INTO REGION(REGIONID, REGIONNAME) VALUES(REGIONSEQ.NEXTVAL, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, region.getRegionName());
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public int remove(String regionId) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "DELETE FROM REGION WHERE REGIONID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(regionId));
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public int modify(Region region) throws SQLException
	{
		int result = 0;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "UPDATE REGION SET REGIONNAME=? WHERE REGIONID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, region.getRegionName());
		pstmt.setInt(2, Integer.parseInt(region.getRegionId()));
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public Region serarchId(String regionId) throws SQLException
	{
		System.out.println(regionId);
		Region region = new Region();
		String regionName=null;
		Connection conn = dataSource.getConnection();
		
		String sql="SELECT REGIONNAME FROM REGION WHERE REGIONID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, regionId);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		if (rs.next())
		{
			regionName = rs.getString("REGIONNAME");
			region.setRegionId(regionId);
			region.setRegionName(regionName);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return region;
	}

	@Override
	public ArrayList<Region> regList() throws SQLException
	{
ArrayList<Region> result = new ArrayList<Region>();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT REGIONID, REGIONNAME"
				  + " FROM REGIONVIEW ORDER BY REGIONID";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			Region region = new Region();
			region.setRegionId(rs.getString("REGIONID"));
			region.setRegionName(rs.getString("REGIONNAME"));
			result.add(region);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	
	
	

}

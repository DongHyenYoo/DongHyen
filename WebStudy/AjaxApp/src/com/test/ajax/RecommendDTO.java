package com.test.ajax;

public class RecommendDTO
{
	String searchReco;

	
	public RecommendDTO()
	{
		
		this("");
		// TODO Auto-generated constructor stub
	}
	
	public RecommendDTO(String searchReco)
	{
		this.searchReco = searchReco;
		
	}
	
	
	public String getSearchReco()
	{
		return searchReco;
	}

	public void setSearchReco(String searchReco)
	{
		this.searchReco = searchReco;
	}
	
	

}

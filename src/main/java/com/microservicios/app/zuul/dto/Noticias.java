package com.microservicios.app.zuul.dto;

import java.util.List;

public class Noticias {

	private List<articles> articles;
	
	private String status;
	
	private Integer totalResults;

	/**
	 * 
	 */
	public Noticias() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param articles
	 * @param status
	 * @param totalResults
	 */
	public Noticias(List<articles> articles, String status, Integer totalResults) {
		super();
		this.articles = articles;
		this.status = status;
		this.totalResults = totalResults;
	}

	public List<articles> getArticles() {
		return articles;
	}

	public void setArticles(List<articles> articles) {
		this.articles = articles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}
	
	
	
	
}

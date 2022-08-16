package com.microservicios.app.zuul.dto;

import java.util.List;

public class clima {
	
	private String cod;
	
	private Integer message;
	
	private Integer cnt;
	
	private List<list> list;

	/**
	 * @param cod
	 * @param message
	 * @param cnt
	 * @param list
	 */
	public clima(String cod, Integer message, Integer cnt, List<com.microservicios.app.zuul.dto.list> list) {
		super();
		this.cod = cod;
		this.message = message;
		this.cnt = cnt;
		this.list = list;
	}

	/**
	 * 
	 */
	public clima() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Integer getMessage() {
		return message;
	}

	public void setMessage(Integer message) {
		this.message = message;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public List<list> getList() {
		return list;
	}

	public void setList(List<list> list) {
		this.list = list;
	}
	
	

}

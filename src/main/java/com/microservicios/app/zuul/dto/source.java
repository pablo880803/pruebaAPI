package com.microservicios.app.zuul.dto;

public class source {

	private String id;
	private String name;
	
	 
		public source() {
			super();
		}
	
	/**
	 * @param id
	 * @param name
	 */
	public source(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

package com.microservicios.app.zuul.security;

public class Usuario {
	
	private String usuario;
	
	private String password;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param usuario
	 * @param password
	 */
	public Usuario(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

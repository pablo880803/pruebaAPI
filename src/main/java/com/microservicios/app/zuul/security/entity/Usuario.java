package com.microservicios.app.zuul.security.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Data
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    
    @Lob
    @Column(length = 65535)
    private String estado;
    
    @Lob
    @Column(length = 65535)
    private String nombre;
    
    @Lob
    @Column(length = 65535, unique = true)
    private String usuario;
    
    @Lob
    @Column(length = 65535)
    private String apellidos;
    
    @Lob
    @Column(length = 65535)
    private String correo;
    
    @Column(length = 45)
    private String telefono;
    
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 65535)
    private String password;
    
    @Column(columnDefinition="tinyint(1) default 1")
    private boolean enabled;
    
    @JsonIgnoreProperties
    @ManyToOne(optional = false)
    @JoinColumn(name = "rol_id",referencedColumnName = "id", nullable = false)
    private Rol rol;
    

	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	

	/**
	 * @param id
	 * @param estado
	 * @param nombre
	 * @param apellidos
	 * @param correo
	 * @param telefono
	 * @param password
	 * @param enabled
	 * @param rol
	 */
	


	public String getUsuario() {
		return usuario;
	}




	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}




	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
    
    
}

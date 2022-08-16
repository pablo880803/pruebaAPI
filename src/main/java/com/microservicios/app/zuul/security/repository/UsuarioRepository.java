package com.microservicios.app.zuul.security.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicios.app.zuul.security.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
	
	public abstract Usuario findByUsuario(String usuario);

}

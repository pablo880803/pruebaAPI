package com.microservicios.app.zuul.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservicios.app.zuul.security.entity.Usuario;
import com.microservicios.app.zuul.security.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	UsuarioRepository UsuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario obj= UsuarioRepository.findByUsuario(username);
		List<GrantedAuthority> privilegios=new ArrayList<>();
		privilegios.add(new SimpleGrantedAuthority(obj.getRol().getNombre()));
		
		System.out.println(encoder.encode(obj.getPassword()));
		System.out.println(obj.getRol().getNombre());
		//		return new User(obj.getUsuario(),obj.getPassword(),obj.isEnabled(),obj.isEnabled(),obj.isEnabled(),obj.isEnabled(),privilegios);

		return new User(obj.getUsuario(),encoder.encode(obj.getPassword()),obj.isEnabled(),obj.isEnabled(),obj.isEnabled(),obj.isEnabled(),privilegios);
	}
	
	
	
	public List<GrantedAuthority> listRoles(Usuario usuario){
		
		return null;
	}

}

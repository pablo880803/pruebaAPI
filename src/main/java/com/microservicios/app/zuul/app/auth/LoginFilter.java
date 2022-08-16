package com.microservicios.app.zuul.app.auth;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicios.app.zuul.security.Usuario;

public class LoginFilter extends AbstractAuthenticationProcessingFilter{
	
	private static Logger LOG= LoggerFactory.getLogger(LoginFilter.class);
	
	
	
	public LoginFilter(String url, AuthenticationManager auth) {
		// TODO Auto-generated constructor stub
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(auth);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		InputStream body = request.getInputStream();
		
		Usuario user= new ObjectMapper().readValue(body, Usuario.class);
		
		LOG.info(user.getUsuario());
		LOG.info(user.getPassword());
		
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
				user.getUsuario(), 
				user.getPassword(),
				Collections.emptyList()
				));
	}
	
	

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		JwtUtil.addAuthentication(response, authResult);
	}
	
	

	

}

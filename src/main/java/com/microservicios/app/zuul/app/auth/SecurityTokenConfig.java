package com.microservicios.app.zuul.app.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.microservicios.app.zuul.security.service.UsuarioService;

@EnableWebSecurity 	// Enable security config. This annotation denotes config for spring security.
@Configuration
@CrossOrigin(origins = "*")
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	UsuarioService UsuarioService;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(UsuarioService);
		//auth.userDetailsService(UsuarioService).passwordEncoder(passwordEncoder());
//		auth.inMemoryAuthentication().
//        withUser("user").password("{noop}123").roles("USER")
//    .and()
//        .withUser("admin").password("{noop}123").roles("ADMIN");
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		//PasswordEncoder defaultEncoder = new StandardPasswordEncoder();
	    Map<String, PasswordEncoder> encoders = new HashMap<>();
	    encoders.put("bcrypt", new BCryptPasswordEncoder());
	    encoders.put("scrypt", new SCryptPasswordEncoder());
	    encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());

	    DelegatingPasswordEncoder passworEncoder = new DelegatingPasswordEncoder(
	      "bcrypt", encoders);
	    //passworEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);

	    return passworEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.cors().and().csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "*").permitAll()  
		.antMatchers("/api/usuarios").hasAuthority("ADMIN")
		.antMatchers("/api/qrcode/**").hasAuthority("ADMIN")		
//		.antMatchers("/api/usuarios").hasAnyRole("ADMIN")
		.antMatchers("/actuator/**").permitAll()
		.anyRequest().authenticated()
		.and()
		
		.formLogin()
		.loginPage("/login")
		.permitAll()
		
		.and()
		.addFilterBefore(new LoginFilter("/login",authenticationManager()), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
		.logout()
		.permitAll();;
		
	}
	
	
//	@Override
//  	protected void configure(HttpSecurity http) throws Exception {
//    	   http.cors().and().csrf().disable()
//		    // make sure we use stateless session; session won't be used to store user's state.
//	 	    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 	
//		.and()
//		    // handle an authorized attempts 
//		    .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Error de Autenticacion")) 	
//		// .exceptionHandling().authenticationEntryPoint(unauthorizedHandler) 	
//		.and()
//		   // Add a filter to validate the tokens with every request
//		   .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
//		// authorization requests config
//		.authorizeRequests()
//		   // allow all who are accessing "auth" service
//		   .antMatchers(HttpMethod.OPTIONS, jwtConfig.getUri()).permitAll()  
//		   .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()  
//		   .antMatchers(HttpMethod.POST, "/api/clientes/postdata/**").permitAll()  
//		   .antMatchers(HttpMethod.GET, "/api/clientes/campanya/uploads/img/**").permitAll()  
//		   
//		   // must be an admin if trying to access admin area (authentication is also required here)
//		//  .antMatchers("/api/clientes/**").hasAuthority("Administrador")
//		  // .antMatchers("/api/usuarios" ).hasRole("ADMIN")
//		   // Any other request must be authenticated
//		   .anyRequest().authenticated(); 
//	}
	
	
	
}
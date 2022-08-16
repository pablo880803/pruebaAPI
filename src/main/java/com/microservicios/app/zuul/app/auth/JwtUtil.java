package com.microservicios.app.zuul.app.auth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	static void addAuthentication(HttpServletResponse response, Authentication username) {

//		final String authorities = username.getAuthorities().stream()
//				.map(GrantedAuthority::getAuthority)
//				.collect(Collectors.joining(","));
//		
//		String token= Jwts.builder()
//				.setSubject(username.getName())
////				.claim("AUTHORITIES_KEY", authorities)
//				.claim("authorities", username.getAuthorities().stream()
//						.map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
//				.signWith(SignatureAlgorithm.HS512, "@CICLOPE2021")
//				.compact();
//		
//		response.addHeader("Authorization", "Bearer "+token);

		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username.getName())
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				//.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, "@CICLOPE2021").compact();
		
		response.addHeader("Access-Control-Expose-Headers", "Authorization");
		response.addHeader("Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type, Accept");

		response.addHeader("Authorization", "Bearer " + token);
		

	}

	static UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

		try {
			String token = request.getHeader("Authorization");

			if (token != null) {

				final JwtParser jwtParser = Jwts.parser().setSigningKey("@CICLOPE2021");
				final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token.replace("Bearer", ""));
				final Claims claims = claimsJws.getBody();
				String user = claims.getSubject();

				if (user != null) {

					@SuppressWarnings("unchecked")
					List<String> authorities = (List) claims.get("authorities");

					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
							claims.getSubject(), null,
							authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
					SecurityContextHolder.getContext().setAuthentication(auth);

					return auth;

				}
				return null;

				// UserDetails users=new
				// org.springframework.security.core.userdetails.User(user, user, null)

//				String user=Jwts.parser()
//						.setSigningKey("@CICLOPE2021")
//						.parseClaimsJws(token.replace("Bearer", ""))
//						.getBody()
//						.getSubject();

//				final Collection<SimpleGrantedAuthority> authorities =
//						Arrays.stream(claims.get("authorities").toString().split(","))
//								.map(SimpleGrantedAuthority::new)
//								.collect(Collectors.toList());
//				
//				return user != null ? new UsernamePasswordAuthenticationToken(user,"", Collections.emptyList()) : null;

			}

			return null;
		} catch (Exception e) {
			return null;
		}
		//return null;
	}

}

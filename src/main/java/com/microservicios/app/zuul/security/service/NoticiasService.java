package com.microservicios.app.zuul.security.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservicios.app.zuul.dto.Noticias;

@Service
public class NoticiasService {

	@Autowired(required=true)
    RestTemplate restTemplate;
	
public String getNoticiasAll() {
		
		String response =
                restTemplate.getForObject(
                "https://newsapi.org/v2/everything?q=Apple&from=2022-08-16&sortBy=popularity&apiKey=9a72da3d9fc64b87b3afd1845d110ba3",
                String.class);
		//Noticias movies = response.getBody();
		
		System.out.println(response);
              //Noticias m = movies;
		
		return response;
	}
}

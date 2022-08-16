package com.microservicios.app.zuul.security.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservicios.app.zuul.dto.Noticias;

@Service
public class ClimaService {

	@Autowired(required=true)
    RestTemplate restTemplate;
	
public String getClimaCali() {
		
		String response =
                restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/forecast?lat=33&lon=-99&appid=e3966c528af561d4eaa9f3a23dab96b5",
                String.class);
		//Noticias movies = response.getBody();
		
		System.out.println(response);
              //Noticias m = movies;
		
		return response;
	}
}

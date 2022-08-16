package com.microservicios.app.zuul.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicios.app.zuul.dto.Noticias;
import com.microservicios.app.zuul.dto.clima;


@RestController
public class ClimaController {
	
	@Autowired(required=true)
	com.microservicios.app.zuul.security.service.ClimaService ClimaService;
	
	@GetMapping("/api/clima")
	public clima getClimaCalis() throws JsonMappingException, JsonProcessingException {
		
		String m =  ClimaService.getClimaCali();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		clima n=null;
		try {
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			n = objectMapper.readValue(m, clima.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}

}

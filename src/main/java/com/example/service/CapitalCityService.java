package com.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.Country;

@Service
public class CapitalCityService {
	List<Country> allCountries =null;
	
	@Value("${url}")
	private String ROOT_URI;
	
	@Autowired
	RestTemplate restTemplate;
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@PostConstruct
	public void init() {
		 ResponseEntity<Country[]> response = restTemplate.getForEntity(ROOT_URI, Country[].class);
		 allCountries = Arrays.asList(response.getBody());
	}

	public Set<String> getFilteredCapitals(String input)
	{
		Set<String> capitals = allCountries.stream().filter(a -> a.getName().toLowerCase().contains(input.toLowerCase())).map(Country::getCapital).collect(Collectors.toSet());
		capitals.addAll(allCountries.stream().filter(a -> a.getAlpha2Code().toLowerCase().contains(input.toLowerCase())).map(Country::getCapital).collect(Collectors.toSet()));
		capitals.addAll(allCountries.stream().filter(a -> a.getAlpha3Code().toLowerCase().contains(input.toLowerCase())).map(Country::getCapital).collect(Collectors.toSet()));
		return capitals;
	}
}

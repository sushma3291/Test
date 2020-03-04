package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CapitalCityService;

@RestController
public class CapitalCityRestController {

	@Autowired
	CapitalCityService capitalCityService;
	@GetMapping("/capital/{input}")
	public ResponseEntity<Object> getCapitalCities(@PathVariable String input){
		return new ResponseEntity<Object>(capitalCityService.getFilteredCapitals(input), HttpStatus.OK);
	}
	
}

package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class Controller {

	@Autowired
	private WeatherService service;

//	@RequestMapping(value = "/city", method = RequestMethod.GET)
//	public String doSomething(@RequestParam String miasto) throws JsonMappingException, JsonProcessingException {
//		return service.ShowWeatherInCity(service.getWeatherObjectOfCertainCity(miasto));
//	}

	@RequestMapping(value = "city", method = RequestMethod.GET)
	public String doSomething() {
		return "Hello";
	}

//	@RequestMapping(value = "/city", method = RequestMethod.POST)
//	public String showJSON() {
//		
//	}

}

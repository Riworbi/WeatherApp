package com.example.demo.Controller;

import java.util.List;

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
	
	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	public String getWeather(@RequestParam List<String> miasta) throws JsonMappingException, JsonProcessingException {

		
		String result = "";
		for(String miasto : miasta) {
			result += service.showResultsWeather(service.getWeatherObjectOfCertainCity(miasto)).toString();
		}
		return result;
	}

}

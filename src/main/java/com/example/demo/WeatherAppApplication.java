package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Service.WeatherService;
import com.example.demo.Weather.WeatherMainClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
public class WeatherAppApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		SpringApplication.run(WeatherAppApplication.class, args);

		WeatherService service = new WeatherService();
		WeatherMainClass WeatherExample = service.getWeatherObjectOfCertainCity();
	}
}
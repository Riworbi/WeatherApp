package com.example.demo.Service;

import org.springframework.web.client.RestTemplate;

import com.example.demo.Weather.WeatherMainClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherService {

	private RestTemplate template = new RestTemplate();
	private ObjectMapper mapper = new ObjectMapper();
	private WeatherMainClass Weather = new WeatherMainClass();

	private String City = "New York";
	private final String keyAPI = "ebe9d8b6a648e4e4887101d3feeb435d";
	private String URL = "http://api.openweathermap.org/data/2.5/weather?q=" + City + "&APPID=" + keyAPI;

	private String weatherStringJSON = template.getForObject(URL, String.class);

	public WeatherMainClass getWeatherObjectOfCertainCity() throws JsonMappingException, JsonProcessingException {
		Weather = mapper.readValue(weatherStringJSON, WeatherMainClass.class);
		return Weather;
	}

}

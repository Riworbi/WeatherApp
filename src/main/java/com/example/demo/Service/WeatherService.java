package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.AppConfig.AppConfig;
import com.example.demo.City.City;
import com.example.demo.City.CityRepository;
import com.example.demo.Weather.WeatherMainClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Setter;

@Service
@Setter
public class WeatherService {

	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private AppConfig appConfig;
	@Autowired
	private CityRepository cityRepository;

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	@Bean
	public WeatherMainClass Weather() {
		return new WeatherMainClass();
	}

	public List<City> findAll() {
		return cityRepository.findAll();
	}

	private City CheckIfCityIsAvailible(List<City> cities, String city) {
		for (City City : cities) {
			if (City.getName().equals(city)) {
				return City;
			}
		}
		return null;
	}

	public WeatherMainClass getWeatherObjectOfCertainCity(String city) throws JsonMappingException, JsonProcessingException {
		String JSON = getJSONofCity(city);
		return mapper.readValue(JSON, WeatherMainClass.class);
	}
	
	public String getJSONofCity(String City) {
		List<City> cities = cityRepository.findAll();
		City city = CheckIfCityIsAvailible(cities, City);
		String URL = appConfig.getURL() + "lat=" + city.getLon() + "&lon=" + city.getLat() + "&appid="
				+ appConfig.getKeyAPI();
		return template().getForObject(URL, String.class);
	}

}

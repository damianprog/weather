package org.damianprog.service;

import org.damianprog.entities.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	Webservice webservice;

	@Override
	public Weather getWeather(String city) {

		return webservice.getWeatherForCity(city);

	}

	@Override
	public boolean cityExists(String city) {

		Weather weather = webservice.getWeatherForCity(city);

		if (weather.getQuery().getResults() == null) {
			return false;

		}

		return true;
	}

}

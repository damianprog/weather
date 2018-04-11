package org.damianprog.service;

import java.io.IOException;

import org.damianprog.entities.Weather;
import org.damianprog.utils.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class WebserviceImpl implements Webservice{

	@Autowired
	JsonGetter jsonGetter;
	
	@Override
	public Weather getWeatherForCity(String city) {
		String json = null;

		try {
			json = jsonGetter.get("https://query.yahooapis.com/v1/public/yql?q=select * from weather.forecast where "
					+ "woeid in (select woeid from geo.places(1) where text=\"" + city + "\")&format=json");
		} catch (IOException e) {

			e.printStackTrace();
		}

		Gson gson = new Gson();

		return gson.fromJson(json, Weather.class);
	}

	
	
}

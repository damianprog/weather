package org.damianprog.service;

import java.io.IOException;

import org.damianprog.entities.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class MainServiceImpl implements MainService {

	OkHttpClient client = new OkHttpClient();

	public String getJSON(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	@Override
	public Weather getWeather(String city) {

		String json = null;

		try {
			json = getJSON(
		"https://query.yahooapis.com/v1/public/yql?q=select * from weather.forecast where "
		+ "woeid in (select woeid from geo.places(1) where text=\"" + city + "\")&format=json");
		} catch (IOException e) {

			e.printStackTrace();
		}

		Gson gson = new Gson();

		Weather weather = gson.fromJson(json, Weather.class);
		
		if(weather.getQuery().getResults() == null) {
			weather = null;
		}

		return weather;

	}

}

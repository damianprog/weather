package org.damianprog.service;

import org.damianprog.entities.Weather;

public interface MainService {

	public Weather getWeather(String city);

	public boolean cityExists(String city);
	
}

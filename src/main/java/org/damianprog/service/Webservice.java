package org.damianprog.service;

import org.damianprog.entities.Weather;

public interface Webservice {

	public Weather getWeatherForCity(String city);
	
}

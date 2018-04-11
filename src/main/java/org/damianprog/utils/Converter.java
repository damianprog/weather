package org.damianprog.utils;

import org.springframework.stereotype.Component;

@Component
public class Converter {

	public int farenheitToCelcius(int farenheit) {
		int celcius = ((farenheit - 32) * 5) / 9;
		return celcius;
	}
	
}

package org.damianprog.utils;

import org.damianprog.entities.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ForecastInitializer {

	@Autowired
	Converter converter;
	
	public Forecast[] init(Forecast[] forecast) {
		
		for (Forecast f : forecast) {

			int farenheitLow = Integer.valueOf(f.getLow());
			int celciusLow = converter.farenheitToCelcius(farenheitLow);
			f.setLow(String.valueOf(celciusLow));

			int farenheitHigh = Integer.valueOf(f.getHigh());
			int celciusHigh = converter.farenheitToCelcius(farenheitHigh);
			f.setHigh(String.valueOf(celciusHigh));

			switch (f.getDay()) {
			case "Mon":
				f.setDay("Monday");
				break;

			case "Tue":
				f.setDay("Tuesday");
				break;

			case "Wed":
				f.setDay("Wednsday");
				break;

			case "Thu":
				f.setDay("Thursday");
				break;

			case "Fri":
				f.setDay("Friday");
				break;

			case "Sat":
				f.setDay("Saturday");
				break;

			case "Sun":
				f.setDay("Sunday");
				break;
			}
		}
		return forecast;
		
		
	}
	
}

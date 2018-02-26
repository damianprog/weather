package org.damianprog.controllers;

import org.damianprog.entities.Channel;
import org.damianprog.entities.Condition;
import org.damianprog.entities.Forecast;
import org.damianprog.entities.Item;
import org.damianprog.entities.Query;
import org.damianprog.entities.Results;
import org.damianprog.entities.Weather;
import org.damianprog.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	MainService mainService;
	
	@GetMapping("/main")
	public String main(Model theModel,@RequestParam(value="city",required=false) String city) {
		
		Weather weather;
		
		if(city==null) {
			weather = mainService.getWeather("oslo");
		} else {
				weather = mainService.getWeather(city);
				if(weather == null) {
					weather = mainService.getWeather("oslo");
					theModel.addAttribute("cannotFind",true);
				}
			}
		
		Query query = weather.getQuery();
		Results results = query.getResults();
		Channel channel = results.getChannel();	
		Item item = channel.getItem();
		Condition condition = item.getCondition();
		
		String temperature = condition.getTemp();
		int temperatureInt = Integer.valueOf(temperature);
		
		Forecast[] forecast = initializeForecast(item.getForecast());
		
		int celcius = farenheitToCelcius(temperatureInt);
		
		theModel.addAttribute("temperature",celcius);
		theModel.addAttribute("city",channel.getLocation().getCity());
		theModel.addAttribute("country",channel.getLocation().getCountry());
		theModel.addAttribute("forecast",forecast);
		theModel.addAttribute("channel",channel);
		
		return "main";
	}
	
	@GetMapping("/changeCity")
	public String changeCity(Model theModel,@RequestParam("city") String city,RedirectAttributes ra) {
		
		ra.addAttribute("city",city);
		
		return "redirect:/weather/main";
	}
	
	public Forecast[] initializeForecast(Forecast[] forecast) {
		
		for(Forecast f: forecast) {
			
			int farenheitLow = Integer.valueOf(f.getLow());
			int celciusLow = farenheitToCelcius(farenheitLow);
			f.setLow(String.valueOf(celciusLow));
			
			int farenheitHigh = Integer.valueOf(f.getHigh());
			int celciusHigh = farenheitToCelcius(farenheitHigh);
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
	
	public int farenheitToCelcius(int farenheit) {
		int celcius = ((farenheit - 32)*5)/9;
		return celcius;
	}
}

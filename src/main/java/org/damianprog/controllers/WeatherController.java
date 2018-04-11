package org.damianprog.controllers;

import org.damianprog.entities.Forecast;
import org.damianprog.entities.WeatherInfo;
import org.damianprog.service.MainService;
import org.damianprog.utils.Converter;
import org.damianprog.utils.ForecastInitializer;
import org.damianprog.utils.WeatherInfoGetter;
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

	@Autowired
	WeatherInfoGetter weatherInfoGetter;

	@Autowired
	ForecastInitializer forecastInitializer;

	@Autowired
	Converter converter;

	@GetMapping("/start")
	public String start(RedirectAttributes ra) {

		ra.addAttribute("city", "oslo");

		return "redirect:/weather/main";

	}

	@GetMapping("/main")
	public String main(Model theModel, @RequestParam(value = "city", required = false) String city) {

		if (!mainService.cityExists(city)) {
			city = "oslo";
			theModel.addAttribute("cannotFind", true);
		}

		WeatherInfo weatherInfo = weatherInfoGetter.get(city);

		theModel.addAttribute("temperature", converter.farenheitToCelcius(weatherInfo.getTemp()));
		theModel.addAttribute("city", weatherInfo.getLocation().getCity());
		theModel.addAttribute("country", weatherInfo.getLocation().getCountry());
		theModel.addAttribute("forecast", forecastInitializer.init(weatherInfo.getItem().getForecast()));
		theModel.addAttribute("channel", weatherInfo.getChannel());

		return "main";
	}

}

package org.damianprog.utils;

import org.damianprog.entities.Channel;
import org.damianprog.entities.Condition;
import org.damianprog.entities.Item;
import org.damianprog.entities.Query;
import org.damianprog.entities.Results;
import org.damianprog.entities.Weather;
import org.damianprog.entities.WeatherInfo;
import org.damianprog.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherInfoGetter {

	@Autowired
	MainService mainService;

	public WeatherInfo get(String city) {
		
		WeatherInfo weatherInfo = new WeatherInfo();

		Weather weather = mainService.getWeather(city);

		Query query = weather.getQuery();
		Results results = query.getResults();
		Channel channel = results.getChannel();
		Item item = channel.getItem();
		Condition condition = item.getCondition();

		weatherInfo.setQuery(query);
		weatherInfo.setResults(results);
		weatherInfo.setChannel(channel);
		weatherInfo.setItem(item);
		weatherInfo.setCondition(condition);
		weatherInfo.setTemp(Integer.valueOf(condition.getTemp()));
		weatherInfo.setLocation(channel.getLocation());

		return weatherInfo;
	}

}

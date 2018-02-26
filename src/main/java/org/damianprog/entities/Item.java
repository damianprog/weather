package org.damianprog.entities;

public class Item {
	private String pubDate;

	private Forecast[] forecast;

	private Condition condition;

	private String longg;

	private String lat;

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public Forecast[] getForecast() {
		return forecast;
	}

	public void setForecast(Forecast[] forecast) {
		this.forecast = forecast;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public String getLongg ()
    {
        return longg;
    }

	public void setLong (String longg)
    {
        this.longg = longg;
    }

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

}

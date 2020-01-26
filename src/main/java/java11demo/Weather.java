package java11demo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"city", "state", "country", "forecast"})
public class Weather {
	private String city;
	private String state;
	private String country;
	private String forecast;

	public String getCity() {
		return city;
	}

	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	@XmlElement
	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	@XmlElement
	public void setCountry(String country) {
		this.country = country;
	}

	public String getForecast() {
		return forecast;
	}

	@XmlElement
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

}

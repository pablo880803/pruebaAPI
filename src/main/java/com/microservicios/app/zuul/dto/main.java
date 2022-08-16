package com.microservicios.app.zuul.dto;

public class main {

	private String temp;
	
	private String feels_like;
	private String temp_min;
	private String temp_max;
	private String pressure;
	private String sea_level;
	private String grnd_level;
	private String humidity;
	private String temp_kf;
	/**
	 * @param temp
	 * @param feels_like
	 * @param temp_min
	 * @param temp_max
	 * @param pressure
	 * @param sea_level
	 * @param grnd_level
	 * @param humidity
	 * @param temp_kf
	 */
	public main(String temp, String feels_like, String temp_min, String temp_max, String pressure, String sea_level,
			String grnd_level, String humidity, String temp_kf) {
		super();
		this.temp = temp;
		this.feels_like = feels_like;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.pressure = pressure;
		this.sea_level = sea_level;
		this.grnd_level = grnd_level;
		this.humidity = humidity;
		this.temp_kf = temp_kf;
	}
	/**
	 * 
	 */
	public main() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(String feels_like) {
		this.feels_like = feels_like;
	}
	public String getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(String temp_min) {
		this.temp_min = temp_min;
	}
	public String getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(String temp_max) {
		this.temp_max = temp_max;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getSea_level() {
		return sea_level;
	}
	public void setSea_level(String sea_level) {
		this.sea_level = sea_level;
	}
	public String getGrnd_level() {
		return grnd_level;
	}
	public void setGrnd_level(String grnd_level) {
		this.grnd_level = grnd_level;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getTemp_kf() {
		return temp_kf;
	}
	public void setTemp_kf(String temp_kf) {
		this.temp_kf = temp_kf;
	}
	
	
	
	
	
}

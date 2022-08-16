package com.microservicios.app.zuul.dto;

import java.util.List;

public class list {

	private main main;
	
	private String dt;
	
	private String visibility;
	
	private String pop;	
	
	private String dt_txt;
	
	private Object sys;
	
	private Object clouds;
	
	private Object wind;
	
	private List<Object> weather;
	
	
	public list() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param main
	 * @param dt
	 * @param visibility
	 * @param pop
	 * @param dt_txt
	 * @param sys
	 * @param clouds
	 * @param wind
	 * @param weather
	 */
	public list(com.microservicios.app.zuul.dto.main main, String dt, String visibility, String pop,
			String dt_txt, Object sys, Object clouds, Object wind, List<Object> weather) {
		super();
		this.main = main;
		this.dt = dt;
		this.visibility = visibility;
		this.pop = pop;
		this.dt_txt = dt_txt;
		this.sys = sys;
		this.clouds = clouds;
		this.wind = wind;
		this.weather = weather;
	}


	public main getMain() {
		return main;
	}


	public void setMain(main main) {
		this.main = main;
	}


	public String getDt() {
		return dt;
	}


	public void setDt(String dt) {
		this.dt = dt;
	}


	public String getVisibility() {
		return visibility;
	}


	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}


	public String getPop() {
		return pop;
	}


	public void setPop(String pop) {
		this.pop = pop;
	}


	public String getDt_txt() {
		return dt_txt;
	}


	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}


	public Object getSys() {
		return sys;
	}


	public void setSys(Object sys) {
		this.sys = sys;
	}


	public Object getClouds() {
		return clouds;
	}


	public void setClouds(Object clouds) {
		this.clouds = clouds;
	}


	public Object getWind() {
		return wind;
	}


	public void setWind(Object wind) {
		this.wind = wind;
	}


	public List<Object> getWeather() {
		return weather;
	}


	public void setWeather(List<Object> weather) {
		this.weather = weather;
	}

	
	
	
	
}

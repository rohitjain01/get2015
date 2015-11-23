package com.metacube.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TemperatureConverter {
	
	@WebMethod
	public double convert(double farenheit) {
		return (farenheit - 32) * 5/9;
	}

}

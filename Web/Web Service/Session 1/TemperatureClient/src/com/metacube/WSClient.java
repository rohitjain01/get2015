package com.metacube;

import com.metacube.webservices.TemperatureConverter;
import com.metacube.webservices.TemperatureConverterServiceLocator;

public class WSClient {

	public static void main(String[] args) {
		
		TemperatureConverterServiceLocator calcCTCWebServiceImplServiceLocator = new TemperatureConverterServiceLocator();
		calcCTCWebServiceImplServiceLocator.setTemperatureConverterEndpointAddress("http://localhost:8080/SimpleSOAPExample/services/TemperatureConverter");
		
		try {
			TemperatureConverter calcCTCWebService = calcCTCWebServiceImplServiceLocator.getTemperatureConverter();
			
			System.out.println(calcCTCWebService.convert(10));
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}

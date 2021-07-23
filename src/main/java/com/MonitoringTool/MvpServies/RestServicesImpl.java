package com.MonitoringTool.MvpServies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServicesImpl implements RestServices{
	
	private RestTemplate rest;
	
	
	@Override
	public boolean call(String URL) {
		System.out.println(URL);
		rest = new RestTemplate();
		ResponseEntity<String> res = rest.getForEntity(URL, String.class);
//		System.out.println(res.getStatusCode());
//		System.out.println(HttpStatus.OK);
		if(res.getStatusCode().compareTo(HttpStatus.OK)==0) {
			return true;
		}
		return false;
	}

}

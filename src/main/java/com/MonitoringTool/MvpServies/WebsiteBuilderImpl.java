package com.MonitoringTool.MvpServies;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.MonitoringTool.DAO.MvpDAO;
import com.MonitoringTool.MvpModel.WebModel;

@Component
public class WebsiteBuilderImpl implements WebsiteBuilder{
		private WebModel website;
		
		@Autowired
		private RestServices rest;
	
		@Autowired
		private TimeUtil timeUtil;
	
		@Value("${website.status.on}")
		private String webStatusOn;
	
		@Value("${website.status.off}")
		private String webStatusOff;
	
		@Override
		public WebModel build(MvpDAO model) {
			try {
				website = new WebModel();
				website.setWebURL(model.getSiteUrl()).
				setFrequency(model.getFrequency())
				.setFrequencyFormat(model.getFrequencyFormat())
				.setNext_Moniter_Time(timeUtil.time_hours_minute(timeUtil.time_current_Time(), model.getFrequency(), model.getFrequencyFormat()))
				.setLast_Status_Frequency(1);
				
				if(checkStatus(model.getSiteUrl())) {
					website.setLastStatus(webStatusOn);
				}
				else {
					website.setLastStatus(webStatusOff);
				}
				return website;
			}
			catch(Exception e) {
				throw new ServiceException("Exception occur in websitebuilder : "+e.getMessage());
			}
		}

		
		@Override
		public WebModel build(WebModel model) {
		try {
			model.setNext_Moniter_Time(timeUtil.time_hours_minute(timeUtil.time_current_Time(), model.getFrequency(), model.getFrequencyFormat()));
			model.setLast_Status_Frequency(model.getLastStatus().equals(webStatusOn)?model.getFrequency()+1:1);
			if(checkStatus(model.getWebURL())) {
					model.setLastStatus(webStatusOn);
			}
			else {
				model.setLastStatus(webStatusOff);
			}
			return model;
		}
		catch(Exception e) {
			throw new ServiceException("Exception occur in websitebuilder : "+e.getMessage());
		}
		}
		
		
		private boolean checkStatus(String URL) {
			return rest.call(URL);
		}
}

package com.MonitoringTool.MvpServies.Sechduler;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.MonitoringTool.MvpModel.WebModel;
import com.MonitoringTool.MvpModel.WebSiteMoniter;
import com.MonitoringTool.MvpServies.TimeUtil;
import com.MonitoringTool.MvpServies.WebsiteBuilder;
import com.MonitoringTool.Repos.WebMoniterRepo;
import com.MonitoringTool.Repos.WebSiteRepo;

@Service
public class SechdulerServicesImpl implements SechdulerServices{
		
	@Autowired
	WebSiteRepo webrepo;
	
	@Autowired
	TimeUtil timeUtil;
	
	@Autowired
	WebsiteBuilder webBuilder;
	
	@Autowired
	WebMoniterRepo moniterrepo;
	
	@Value("${website.status.on}")
	String webStatusOn;
	
	@Value("${website.status.off}")
	String webStatusOff;
	
	@Transactional
	@Scheduled(fixedDelay = 60000)
	public void job() {
		try {
			//getting the list of all website 
			List<WebModel> list = webrepo.findAll();
			for(WebModel model : list) {
				
			//comparing the current time with the next moniter time
			if(timeUtil.compare(timeUtil.time_current_Time(),model.getNext_Moniter_Time())==0 || timeUtil.compare(timeUtil.time_current_Time(),model.getNext_Moniter_Time())==1) {
					
					//changing the data in model object 
					model = webBuilder.build(model);
					
					//checking the last status of model object
					if(model.getLastStatus().equals(webStatusOn)) {
						
						//updating the data in database table
						WebSiteMoniter moniter = new WebSiteMoniter().setStatus(webStatusOn).setTime(timeUtil.time_current_Time()).setWebId(model);
						moniterrepo.save(moniter);
						
					}
					else {
						//if web site is down handle by below code
						WebSiteMoniter moniter = new WebSiteMoniter().setStatus(webStatusOff).setTime(timeUtil.time_current_Time()).setWebId(model);
						moniterrepo.save(moniter);
					}
					
				}
					//save the data webobject
					webrepo.save(model);
			}
		}
		catch(Exception e) {
			throw new ServiceException("excption occur in Schedule service : "+e.getMessage());
			
		}
	}

	
}

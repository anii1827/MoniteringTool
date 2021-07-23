package com.MonitoringTool;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.MonitoringTool.MvpModel.User;
import com.MonitoringTool.MvpModel.WebModel;
import com.MonitoringTool.MvpServies.TimeUtil;
import com.MonitoringTool.MvpServies.UserServices;
import com.MonitoringTool.Repos.UserRepo;
import com.MonitoringTool.Repos.WebSiteRepo;

@SpringBootTest
class MonitoringToolApplicationTests {
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	WebSiteRepo webrepo;
	
	@Autowired
	TimeUtil timeUtil;
	
	@Autowired
	UserServices service;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void requestToserver() {
		
		
	}
	@Test
	public void check2()
	{
//		MvpDAO dao = new MvpDAO();
//		dao.setName("Anil Tailor");
//		dao.setFrequency(5);
//		dao.setFrequencyFormat("Hours");
//		dao.setSiteUrl("https://www.google.com/");
//		service.register(dao);
//		
		
		
//		LocalTime time = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
//		System.out.println("before "+ time);
//		String s = time.format(format).toString();
//		System.out.println(time.getHour());
//		System.out.println(time.getMinute());
//		time = LocalTime.of(23, 56);
//		LocalTime t2 =  timeUtil.time_hours_minute(time, 5, "Hours");
//		System.out.println("after "+t2);
//
//		LocalTime time2 = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
//	
//		LocalTime time3 = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
//		
//		System.out.println(time2.compareTo(time3));
//		System.out.println(t2.compareTo(time2));
	}
	
	@Test()
	void check() {
		
		
//		try {
//		User user = new User();
//		user.setName("anil");
//		WebModel model = new WebModel();
//		model.setWebURL("www.google.com").setFrequency(5).setFrequencyFormat("Minute").setLastStatus("ON").setLast_Status_Frequency(1)
//		.setNext_Moniter_Time(timeUtil.time_hours_minute(timeUtil.time_current_Time(), model.getFrequency(), model.getFrequencyFormat()));
//		
//		
//		WebModel model2 = new WebModel();
//		model2.setWebURL("www.google.com").setFrequency(3).setFrequencyFormat("Hours").setLastStatus("ON").setLast_Status_Frequency(1)
//		.setNext_Moniter_Time(timeUtil.time_hours_minute(timeUtil.time_current_Time(), model2.getFrequency(), model2.getFrequencyFormat()));
//
//		
//		
//		List<WebModel> website = new ArrayList<>();
//		website.add(model);
//		website.add(model2);
//		
//		user.setWebsite(website);
//		repo.save(user);
////	
////		
////		webrepo.deleteById(2l);
//		
//		
//		//retrive the data
//		
////		System.out.println();
////		for(WebModel we : repo.getById(15l).getWebsite()) {
////			LocalTime t = we.getNext_Moniter_Time();
////			System.out.println(t);
////			System.out.println(we);
////		}
////		System.out.println();
////		
//	}
//	catch(Exception e) {
//		System.out.println("Message "+e.getMessage());
//	}
}
	
	@Test
	void udpateInserDate()
	{
//		try {
//		WebSiteMoniter moniter1 = new WebSiteMoniter();
//		moniter1.setStatus("UP").setMoniterId(1l).setTime(LocalTime.now().toString());
//		WebSiteMoniter moniter2 = new WebSiteMoniter();
//		moniter2.setStatus("Down").setMoniterId(2l).setTime(LocalTime.now().toString());
//		WebSiteMoniter moniter3 = new WebSiteMoniter();
//		moniter3.setStatus("UP").setMoniterId(3l).setTime(LocalTime.now().toString());
//		
//		WebModel model = webrepo.getById(2l);
//		List<WebSiteMoniter> list = model.getMoniter();
//		
//		list.add(moniter1);
//		list.add(moniter2);
//		list.add(moniter3);
//		
//		model.setMoniter(list);
//		
//		webrepo.save(model);
//		
//		}
//		catch(Exception e) {
//			System.out.println("Excepiton : "+e.getMessage());
//		}
	}	

}

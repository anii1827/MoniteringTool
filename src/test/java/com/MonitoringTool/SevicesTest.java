package com.MonitoringTool;

import java.util.LinkedHashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.MonitoringTool.DAO.MvpDAO;
import com.MonitoringTool.DAO.UserDao;
import com.MonitoringTool.MvpModel.User;
import com.MonitoringTool.MvpModel.WebModel;
import com.MonitoringTool.MvpServies.TimeUtil;
import com.MonitoringTool.MvpServies.UserServices;
import com.MonitoringTool.Repos.WebMoniterRepo;
import com.MonitoringTool.Repos.WebSiteRepo;
import com.MonitoringTool.ServiceException.serviceException;


@SpringBootTest
public class SevicesTest {

			@Autowired 
			UserServices services;
	
			@Autowired
			WebMoniterRepo repo;
			
			@Autowired
			TimeUtil util;
			
			@Autowired
			WebSiteRepo webrepo;
			
			@Test
			void getall(){
				LinkedHashSet<WebModel> list =services.getAllWebsite(1l);
				for(WebModel web : list) {
					System.out.println(web);
				}
				
			}
			
			
			@Test
			void addtheUserandweb(){
				UserDao user = new UserDao().setEmail("Aniltailor500@gmail.com").setName("Anil").setPassword("Mahi@1827");
				services.register(user);
			}
			
			@Test
			void addweb(){
				MvpDAO dao = new MvpDAO().setSiteUrl("https://www.instagram.com/").setFrequency(10).setFrequencyFormat("Minutes");
				services.addWebsiteToMoniter(dao, 1l);
				
			}
			@Test
			void Updateweb(){
				MvpDAO dao = new MvpDAO().setSiteUrl("https://www.instagram.com/").setFrequency(5).setFrequencyFormat("Hours");
				List<WebModel> updateTheWebsite = services.updateTheWebsite(1l, 1l, dao);
				System.out.println(updateTheWebsite);
			}
			
			@Test
			void deletweb(){
				services.removeWebSite(7l, 20l);
			}
			
			@Test()
			void allUser() {
				List<User> getListUser = services.GetListUser();
//				LinkedHashSet<User> list = new LinkedHashSet<>(getListUser);
				System.out.println(getListUser.size());
				try {
				System.out.println();
				for(User user : getListUser) {
					System.out.println(user);
				}
				System.out.println();
				}
				catch(serviceException e) {
					System.out.println(e.getErrorMessage());
					System.out.println(e.getErrorCode());
				}
			}
	
			@Test()
			void deleteUser() {
				try {
				services.delete(7l);
				allUser();
				}
				catch(serviceException e) {
					System.out.println(e.getErrorMessage());
					System.out.println(e.getErrorCode());
				}
				
			}
			
			
			
			@Test()
			void updatewebsite() {
//				WebModel model = new WebModel();
//				model.setWebURL("https://www.outlook.com/").setFrequency(10).setFrequencyFormat("Hours");
//				services.updateTheWebsite(33l, 17l, model);
			}
			
}

package com.MonitoringTool.MvpServies;

import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MonitoringTool.DAO.MvpDAO;
import com.MonitoringTool.DAO.UserDao;
import com.MonitoringTool.MvpModel.User;
import com.MonitoringTool.MvpModel.WebModel;
import com.MonitoringTool.MvpModel.WebSiteMoniter;
import com.MonitoringTool.Repos.UserRepo;
import com.MonitoringTool.Repos.WebSiteRepo;
import com.MonitoringTool.ServiceException.serviceException;

@Service
public class UserServicesImpl implements UserServices{
	private User user;
	private WebModel website;
	
	@Autowired
	private TimeUtil timeUtil;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	WebsiteBuilder webBuilder;
	
	@Autowired
	WebSiteRepo webRepo;
	
	@Transactional
	@Override
	public User register(UserDao model) {
		try {
		if(model==null) {
			throw new serviceException("701", "User data is null");
		}
		user = new User().setName(model.getName()).setEmail(model.getEmail()).setPassword(model.getPassword());
		return userRepo.save(user);
		}
		catch(Exception e) {
			throw new serviceException("701", e.getMessage());
		}
	}

	@Transactional
	@Override
	public void delete(Long UserId){
		try {
			user = userRepo.getById(UserId);
			if(user==null) {
				throw new serviceException("702","User Not Found.");
			}
			userRepo.deleteById(UserId);
		}
		catch(EntityNotFoundException e) {
			throw new serviceException("702", "no user available with id "+UserId);
		}
		catch(Exception e) {
			throw new serviceException("702", e.getMessage());
		}
		 
	}

	@Override
	public List<User> GetListUser() {
		List<User> list = userRepo.findAll();
		if(list.size()<=0) {
			throw new serviceException("703", "there is no User present in database.");
		}
		return list;
	}
	
	
	

	@Transactional
	@Override
	public List<WebModel> addWebsiteToMoniter(MvpDAO dao, Long UserId) {
		if(dao==null) {
			throw new serviceException("Website data is null", "701");
		}
		
		try {
		//getting the user from the database
		user = userRepo.getById(UserId);
		if(user==null) {
			throw new serviceException("702", "User Not Found.");
		}
		//converting dao to model ojbect
		website = webBuilder.build(dao);
		
		//mapping the user with user
		website.setUser(user);
		
		//adding data in database
		webRepo.save(website);
		
		//returning all website List
		return user.getWebsite();
		
		}
		catch(EntityNotFoundException e) {
			throw new serviceException("702", "no user available with id "+UserId);
		}
		catch(Exception e) {
			throw new serviceException("709", e.getMessage());
		}
	}
	
	@Transactional
	@Override
	public List<WebModel> removeWebSite(Long UserId, Long WebId) {
		try {
				
				System.out.println("working");
				user = userRepo.getById(UserId);
				if(user==null) {
					throw new serviceException("702", "User Not Found.");
				}
//				System.out.println(user);
				
				website = webRepo.getById(WebId);
				if(website==null) {
					throw new serviceException("702", "Web Data Not Foundt");
				}
			
//				System.out.println(website);
				
				List<WebModel> list = user.getWebsite();
				
//				getting the list 
				list.remove(website);
				user.setWebsite(list);
				userRepo.save(user);
				return userRepo.getById(UserId).getWebsite();
		}
		catch(EntityNotFoundException e) {
			throw new serviceException("702", "no data available with id "+UserId);
		}
		catch(Exception e) {
		
			System.out.println(e.getMessage());
			throw new serviceException("708", e.getMessage());
		
		}
			
	}
	
	@Transactional
	@Override
	public List<WebModel> updateTheWebsite(Long UserId, Long Webid, MvpDAO model) {
		try {
			
			user = userRepo.getById(UserId);
			if(user==null) {
				throw new serviceException("702", "User Not Found.");
			}
			
			website = webRepo.getById(Webid);
			if(website==null) {
				throw new serviceException("702", "Web Data Not Foundt");
			}
			if(website.getWebURL().equals(model.getSiteUrl())) {
			
			//updating the details of website
			 website.setFrequency(model.getFrequency())
			.setFrequency(model.getFrequency())
			.setFrequencyFormat(model.getFrequencyFormat())
			.setNext_Moniter_Time(timeUtil.time_hours_minute(timeUtil.time_current_Time(), website.getFrequency(), website.getFrequencyFormat()))
			.setUser(user);
			
			//updating the website details
			webRepo.save(website);
			
			//return the list of website for particular user
			return userRepo.getById(UserId).getWebsite();

		}
		else { 
			System.out.println("message");
			throw new serviceException("706", "WebSite url is different");
		}
	}
		catch(EntityNotFoundException e) {
			throw new serviceException("702", "no user available with id "+UserId);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			throw new serviceException("707", e.getMessage());
		}
		
	}

	@Transactional
	@Override
	public User updateUserDetails(long UserId, UserDao dao) {
		if(dao==null) {
			throw new serviceException("701", "User data is null");
		}
		user = userRepo.getById(UserId);
		if(user==null) {
			throw new serviceException("702", "User Not Found.");
		}
		
		user  = userRepo.getById(UserId);
		user.setEmail(dao.getEmail()).setName(dao.getName()).setPassword(dao.getPassword());
		return userRepo.save(user);
	}

	@Override
	public LinkedHashSet<WebModel> getAllWebsite(Long UserId) {
		try {
		user = userRepo.getById(UserId);
		if(user==null) {
			throw new serviceException("702","User Not Found.");
		}
		return new LinkedHashSet<>(user.getWebsite());
		}
		catch(EntityNotFoundException e) {
			throw new serviceException("702", "no user available with id "+UserId);
		}
		catch(Exception e) {
			throw new serviceException("705",e.getMessage());
		}
	}

	@Override
	public List<WebSiteMoniter> getMoniteringDetails(long WebId) {
		try {
		website = webRepo.getById(WebId);
		if(website==null) {
			throw new serviceException("702", "Data Not Found for id "+WebId);
		}
		return website.getMoniter();
		}
		catch(EntityNotFoundException e)
		{
			throw new serviceException("702", "Data Not Found for id "+WebId);
		}
		catch(serviceException s) {
			throw new serviceException(s.getErrorCode(), s.getErrorMessage());
		}
		catch(Exception e) {
			throw new serviceException("706", e.getMessage());	
		}
	}	
}

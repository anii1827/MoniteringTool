package com.MonitoringTool.MvpServies;

import java.util.LinkedHashSet;
import java.util.List;

import com.MonitoringTool.DAO.MvpDAO;
import com.MonitoringTool.DAO.UserDao;
import com.MonitoringTool.MvpModel.User;
import com.MonitoringTool.MvpModel.WebModel;
import com.MonitoringTool.MvpModel.WebSiteMoniter;

public interface UserServices {
	public List<WebModel>addWebsiteToMoniter(MvpDAO dao, Long UserId);
	
	public List<WebModel>removeWebSite(Long UserId, Long WebId);
	
	public List<WebModel>updateTheWebsite(Long UserId, Long Webid, MvpDAO model);
	
	public LinkedHashSet<WebModel>getAllWebsite(Long UserId);
	
	public User register(UserDao dao);
	
	public void delete(Long UserId);
	
	public User updateUserDetails(long UserId, UserDao dao);
		
	public List<User> GetListUser();
	
	public List<WebSiteMoniter> getMoniteringDetails(long WebId);
}



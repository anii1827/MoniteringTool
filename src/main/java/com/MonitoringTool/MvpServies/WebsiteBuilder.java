package com.MonitoringTool.MvpServies;

import com.MonitoringTool.DAO.MvpDAO;
import com.MonitoringTool.MvpModel.WebModel;

public interface WebsiteBuilder {
		
		public WebModel build(MvpDAO model);
		
		public WebModel build(WebModel model);
}

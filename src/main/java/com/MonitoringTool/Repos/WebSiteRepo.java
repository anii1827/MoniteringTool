package com.MonitoringTool.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MonitoringTool.MvpModel.WebModel;

public interface WebSiteRepo extends JpaRepository<WebModel, Long>{
	
	

}

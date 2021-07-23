package com.MonitoringTool.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MonitoringTool.MvpModel.WebSiteMoniter;

public interface WebMoniterRepo extends JpaRepository<WebSiteMoniter, Long>{
		
}

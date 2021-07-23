package com.MonitoringTool.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MonitoringTool.DAO.MvpDAO;
import com.MonitoringTool.MvpModel.WebModel;
import com.MonitoringTool.MvpModel.WebSiteMoniter;
import com.MonitoringTool.MvpServies.UserServices;
import com.MonitoringTool.ServiceException.serviceException;

@RestController
public class MvpWebController {
		
	@Autowired
	UserServices userServices;
		
//	adding the website
	@PostMapping("/Web/{UserId}")
	ResponseEntity<?> webSiteRegister(@PathVariable("UserId") long UserId, @Valid @RequestBody MvpDAO dao){
		List<WebModel> addWebsiteToMoniter = userServices.addWebsiteToMoniter(dao, UserId);
		return new ResponseEntity<List<WebModel>>(addWebsiteToMoniter, HttpStatus.OK);
	}
	
//	updating the website
	@PutMapping("/Web/{UserId}/{WebId}")
	ResponseEntity<?> UpdateWebDetails(@PathVariable("UserId") long UserId,@PathVariable("WebId") long WebId, @RequestBody MvpDAO dao){
		List<WebModel> addWebsiteToMoniter = userServices.updateTheWebsite(UserId, WebId, dao);
		return new ResponseEntity<List<WebModel>>(addWebsiteToMoniter, HttpStatus.ACCEPTED);
	}
	
	//removing the webstie
	@DeleteMapping("/Web/{UserId}/{WebId}")
	ResponseEntity<?> DeleteWeb(@PathVariable("UserId") long UserId,@PathVariable("WebId") long WebId){
		List<WebModel> addWebsiteToMoniter = userServices.removeWebSite(UserId, WebId);
		return new ResponseEntity<List<WebModel>>(addWebsiteToMoniter, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("Web/{WebId}")
	ResponseEntity<?> getMoniteringData(@PathVariable("WebId") long WebId)
	{
			List<WebSiteMoniter> moniteringDetails = userServices.getMoniteringDetails(WebId);
			if(moniteringDetails.size()==0) {
				throw new serviceException("702", "No web Site available to moniter");
			}
			return new ResponseEntity<List<WebSiteMoniter>>(moniteringDetails, HttpStatus.ACCEPTED);
	}
	
}

package com.MonitoringTool.Controller;

import java.util.LinkedHashSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MonitoringTool.DAO.UserDao;
import com.MonitoringTool.MvpModel.User;
import com.MonitoringTool.MvpModel.WebModel;
import com.MonitoringTool.MvpServies.UserServices;
import com.MonitoringTool.ServiceException.BusinessException;


@RestController
public class MvpController {
		
		@Autowired
		UserServices userServices;
	
	
		@GetMapping("/")
		public ResponseEntity<?> getall(){
			List<User> getListUser = userServices.GetListUser();
			return new ResponseEntity<List<User>>(getListUser, HttpStatus.OK);
		}
		
		@GetMapping("/{UserId}")
		public ResponseEntity<?> getall(@PathVariable long UserId){
			System.out.println(UserId);
			BusinessException b;
			
			LinkedHashSet<WebModel> allWebsite = userServices.getAllWebsite(UserId);
			if(allWebsite.size()==0) {
				b = new BusinessException("702","No website available to moniter");
				throw b;
			}
			System.out.println("size : "+allWebsite.size());
			return new ResponseEntity<LinkedHashSet<WebModel>>(allWebsite, HttpStatus.OK);
			
		}
		
		@PostMapping("/")
		public ResponseEntity<?> register(@Valid @RequestBody UserDao model) {			
			BusinessException b;
			
				if(model==null) {
					b = new BusinessException("701","User Data null");
					throw b;
				}
//				System.out.println(model);
				User user = userServices.register(model);
				return new ResponseEntity<User>(user, HttpStatus.OK);
			
		}
		
		@PutMapping("{UserId}")
		public ResponseEntity<?> UpdateDetails(@Valid @RequestBody UserDao userdao, @PathVariable long UserId) {
			BusinessException b;
			
				if(userdao==null) {
					b = new BusinessException("701","User Data null");
					throw b;
				}
				
			User updateUserDetails = userServices.updateUserDetails(UserId, userdao);
			return new ResponseEntity<User>(updateUserDetails, HttpStatus.OK);
			
		}
}

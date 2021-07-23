package com.MonitoringTool.DAO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDao {
	
	@NotNull(message = "please provide email Id")
	@Email(message = "Email id not valid")
	private String email;
	
	@Size(min=3, max=15, message = "UserName size between 3 to 15")
	@NotNull(message = "please provide User Name")
	private String name;
	
	@NotNull(message = "password is required")
	@Size(min = 5, message = "password size should be greater then 5")
	private String password;
	
	@Override
	public String toString() {
		return "UserDao [Email=" + email + ", name=" + name + ", Password=" + password + "]";
	}
	public UserDao() {
		
	}
	public String getEmail() {
		return email;
	}
	public UserDao setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getName() {
		return name;
	}
	public UserDao setName(String name) {
		this.name = name;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public UserDao setPassword(String password) {
		this.password = password;
		return this;
	}
	
	
}

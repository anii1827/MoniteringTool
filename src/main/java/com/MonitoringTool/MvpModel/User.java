package com.MonitoringTool.MvpModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "User")
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column
	String name;
	
	@Column
	String Password;
	
	@Column
	String Email;
	
	@JsonIgnore
	public String getPassword() {
		return Password;
	}
	
	@JsonIgnore
	public User setPassword(String password) {
		Password = password;
		return this;
	}
	public String getEmail() {
		return Email;
	}

	public User setEmail(String email) {
		Email = email;
		return this;
	}

	@JsonIgnore
	@OneToMany(orphanRemoval = true,  mappedBy = "user", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	 List<WebModel> website;
	 
	
	public Long getId() {
		return id;
	}

	public User setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public List<WebModel> getWebsite() {
		if(website==null) {
			this.website = new ArrayList<>();
		}
		return website;
	}

	public User setWebsite(List<WebModel> website) {
		this.website = website;
		return this;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", website=" + website + "]";
	}

}

package com.MonitoringTool.MvpModel;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class WebModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "webId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<WebSiteMoniter> moniter;
	
	@Column
	private String WebURL;
	
	@JsonIgnore
	@Column
	private int frequency;
	
	@JsonIgnore
	@Column
	private String frequencyFormat;

	@Column
	private LocalTime Next_Moniter_Time;
	
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User user;

	
	@Column
	private String LastStatus;
	
	@Column
	private int Last_Status_Frequency;
	
	@JsonIgnore
	public User getUser() {
		return user;
	}

	@JsonIgnore
	public WebModel setUser(User user) {
		this.user = user;
		return this;
	}

	public Long getId() {
		return id;
	}

	public WebModel setId(Long id) {
		this.id = id;
		return this;
	}
	
	@JsonIgnore
	public List<WebSiteMoniter> getMoniter() {
		if(moniter==null) {
			moniter = new ArrayList<WebSiteMoniter>();
		}
		return moniter;
	}

	@JsonIgnore
	public WebModel setMoniter(List<WebSiteMoniter> moniter) {
		this.moniter = moniter;
		return this;
		
	}

	public String getWebURL() {
		return WebURL;
	}

	public WebModel setWebURL(String webURL) {
		WebURL = webURL;
		return this;
	}

	public int getFrequency() {
		return frequency;
	}

	public WebModel setFrequency(int frequency) {
		this.frequency = frequency;
		return this;
	}

	public String getFrequencyFormat() {
		return frequencyFormat;
	}

	public WebModel setFrequencyFormat(String frequencyFormat) {
		this.frequencyFormat = frequencyFormat;
		return this;
	}

	public String getLastStatus() {
		return LastStatus;
	}

	public WebModel setLastStatus(String lastStatus) {
		LastStatus = lastStatus;
		return this;
	}

	public int getLast_Status_Frequency() {
		return Last_Status_Frequency;
	}

	public WebModel setLast_Status_Frequency(int last_Status_Frequency) {
		Last_Status_Frequency = last_Status_Frequency;
		return this;
	}

	@JsonIgnore
	public LocalTime getNext_Moniter_Time() {
		return Next_Moniter_Time;
	}
	
	@JsonIgnore
	public WebModel setNext_Moniter_Time(LocalTime next_Moniter_Time) {
		Next_Moniter_Time = next_Moniter_Time;
		return this;
	}

	@Override
	public String toString() {
		return "WebModel [id=" + id + ", WebURL=" + WebURL + ", frequency=" + frequency
				+ ", frequencyFormat=" + frequencyFormat + ", LastStatus=" + LastStatus + ", Last_Status_Frequency="
				+ Last_Status_Frequency + ", Next_Moniter_Time=" + Next_Moniter_Time + "]";
	}
}

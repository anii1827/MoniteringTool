package com.MonitoringTool.MvpModel;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class WebSiteMoniter {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long MoniterId;

		@Column
		LocalTime time;
		
		@Column
		String status;

		public Long getMoniterId() {
			return MoniterId;
		}
		
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name = "webId")
		private WebModel webId;
		
		
		public WebModel getWebId() {
			return webId;
		}

		public  WebSiteMoniter setWebId(WebModel webId) {
			this.webId = webId;
			return this;
		}

		public WebSiteMoniter setMoniterId(Long moniterId) {
			this.MoniterId = moniterId;
			return this;
		}

		public LocalTime getTime() {
			return time;
		}

		public WebSiteMoniter setTime(LocalTime time) {
			this.time = time;
			return this;
		}

		public String getStatus() {
			return status;
		}

		public WebSiteMoniter setStatus(String status) {
			this.status = status;
			return this;
		}

		@Override
		public String toString() {
			return "WebSiteMoniter [MoniterId=" + MoniterId + ", time=" + time + ", status=" + status + ", webId="
					+ webId + "]";
		}
}

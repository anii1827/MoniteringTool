package com.MonitoringTool.DAO;

import javax.validation.constraints.NotNull;

public class MvpDAO {
		@NotNull(message = "please provide site URL")
		private String siteUrl;
		
		@NotNull(message = "please provide frequency")
		private Integer frequency;
		
		@NotNull(message = "please provide frequency format hours or minute")
		private String frequencyFormat;
		
		public String getSiteUrl() {
			return siteUrl;
		}
		public MvpDAO setSiteUrl(String siteUrl) {
			this.siteUrl = siteUrl;
			return this;
		}
		public int getFrequency() {
			return frequency;
		}
		public MvpDAO setFrequency(int frequency) {
			this.frequency = frequency;
			return this;
		}
		public String getFrequencyFormat() {
			return frequencyFormat;
		}
		public MvpDAO setFrequencyFormat(String frequencyFormat) {
			this.frequencyFormat = frequencyFormat;
			return this;
		}
		
}

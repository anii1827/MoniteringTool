package com.MonitoringTool.ServiceException;

import java.util.Date;

public class errorMessage {
	private String ErrorCode;
	private Date TimeStamp;
	private String message;
	public errorMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public errorMessage(Date timeStamp, String message, String code) {
		super();
		TimeStamp = timeStamp;
		this.message = message;
		this.ErrorCode=code;
	}

	public Date getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		TimeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	
}

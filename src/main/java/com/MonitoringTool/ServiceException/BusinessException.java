package com.MonitoringTool.ServiceException;

public class BusinessException extends RuntimeException{
		private String ErroCode;
		private String Message;
	
		public BusinessException() {
			
		}
		public BusinessException(String message) {
			super(message);
			this.Message=message;
		}
		
		public BusinessException(String Errcode, String Message) {
			super(Message);
			this.ErroCode=Errcode;
			this.Message=Message;
		}

		public String getErroCode() {
			return ErroCode;
		}

		public void setErroCode(String erroCode) {
			ErroCode = erroCode;
		}

		public String getMessage() {
			return Message;
		}

		public void setMessage(String message) {
			Message = message;
		}
		
}

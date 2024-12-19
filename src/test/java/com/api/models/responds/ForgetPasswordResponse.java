package com.api.models.responds;

public class ForgetPasswordResponse {
	private String message;
	public ForgetPasswordResponse() {
		// TODO Auto-generated constructor stub
	}	

	public ForgetPasswordResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ForgetPasswordRequest [email=" + message + "]";
	}
	

}

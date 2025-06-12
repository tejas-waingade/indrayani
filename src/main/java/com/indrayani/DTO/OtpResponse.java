package com.indrayani.DTO;

public class OtpResponse {

	private String message;
	private String token;

	public OtpResponse(String message, String token) {
		this.message = message;
		this.token = token;
	}

	public OtpResponse(String message) {
		this.message = message;
		this.token = null;
	}

	public String getMessage() {
		return message;
	}

	public String getToken() {
		return token;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
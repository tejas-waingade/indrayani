package com.indrayani.DTO;

public class SignUpResponse {

	private Long userId;
	private String message;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SignUpResponse(Long userId, String message) {
		super();
		this.userId = userId;
		this.message = message;
	}

}

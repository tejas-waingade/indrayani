package com.indrayani.entity;

public class AuthRequest {

	private String mobile;
	private String fcmToken;
	private String otp;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public AuthRequest(String mobile, String fcmToken, String otp) {
		super();
		this.mobile = mobile;
		this.fcmToken = fcmToken;
		this.otp = otp;
	}

	public AuthRequest() {
		super();
	}
}

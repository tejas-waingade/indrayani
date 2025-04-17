package com.indrayani.entity;

import java.util.UUID;

public class AuthRequest {

	private String mobile;
	private String fcmToken;
	private String otp;
	private String googleId;
	private String email;

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

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AuthRequest(String mobile, String fcmToken, String otp, String email, String googleId) {
		super();
		this.mobile = mobile;
		this.fcmToken = fcmToken;
		this.otp = otp;
		this.email = email;
		this.googleId = googleId;
	}

	public AuthRequest() {
		super();
	}

	public AuthRequest(String mobile, String fcmToken, String email, String googleId) {
		super();
		this.mobile = mobile;
		this.fcmToken = fcmToken;
		this.email = email;
		this.googleId = googleId;
	}
}
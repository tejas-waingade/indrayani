package com.indrayani.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class SignUpRequest {

	@NotEmpty(message = "First name cannot be empty")
	private String firstName;

	@NotEmpty(message = "Last name cannot be empty")
	private String lastName;

	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Invalid email format")
	private String email;

	@NotEmpty(message = "Mobile cannot be empty")
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
	private String mobile;

	private String education;
	private String city;
	private String district;
	private String state;
	private String pinCode;
	private String fcmToken;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public SignUpRequest(String firstName, String lastName, String email, String mobile, String education, String city,
			String district, String state, String pinCode, String fcmToken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.education = education;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pinCode = pinCode;
		this.fcmToken = fcmToken;
	}

}

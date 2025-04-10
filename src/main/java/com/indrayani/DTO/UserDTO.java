package com.indrayani.DTO;

import java.time.LocalDateTime;

public class UserDTO {

	private String mobile;
	private String email;
	private String firstName;
	private String lastName;
	private String education;
	private String optedClasses;
	private String city;
	private String district;
	private String state;
	private String pincode;
	private String addressRole;
	private Boolean isActive;
	private Boolean isDeleted;
	private Boolean isMobileVerified;
	private Boolean isEmailVerified;
	private String emailOtp;
	private String mobileOtp;
	private LocalDateTime emailOtpGeneratedAt;
	private LocalDateTime mobileOtpGeneratedAt;
	private String fcmToken;
	private LocalDateTime createdAt;
	private String createdBy;
	private String updatedBy;
	private LocalDateTime updatedAt;
	private String googleId;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOptedClasses() {
		return optedClasses;
	}

	public void setOptedClasses(String optedClasses) {
		this.optedClasses = optedClasses;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddressRole() {
		return addressRole;
	}

	public void setAddressRole(String addressRole) {
		this.addressRole = addressRole;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getIsMobileVerified() {
		return isMobileVerified;
	}

	public void setIsMobileVerified(Boolean isMobileVerified) {
		this.isMobileVerified = isMobileVerified;
	}

	public Boolean getIsEmailVerified() {
		return isEmailVerified;
	}

	public void setIsEmailVerified(Boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public String getEmailOtp() {
		return emailOtp;
	}

	public void setEmailOtp(String emailOtp) {
		this.emailOtp = emailOtp;
	}

	public String getMobileOtp() {
		return mobileOtp;
	}

	public void setMobileOtp(String mobileOtp) {
		this.mobileOtp = mobileOtp;
	}

	public LocalDateTime getEmailOtpGeneratedAt() {
		return emailOtpGeneratedAt;
	}

	public void setEmailOtpGeneratedAt(LocalDateTime emailOtpGeneratedAt) {
		this.emailOtpGeneratedAt = emailOtpGeneratedAt;
	}

	public LocalDateTime getMobileOtpGeneratedAt() {
		return mobileOtpGeneratedAt;
	}

	public void setMobileOtpGeneratedAt(LocalDateTime mobileOtpGeneratedAt) {
		this.mobileOtpGeneratedAt = mobileOtpGeneratedAt;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public UserDTO(String mobile, String email, String firstName, String lastName, String education,
			String optedClasses, String city, String district, String state, String pincode, String addressRole,
			Boolean isActive, Boolean isDeleted, Boolean isMobileVerified, Boolean isEmailVerified, String emailOtp,
			String mobileOtp, LocalDateTime emailOtpGeneratedAt, LocalDateTime mobileOtpGeneratedAt, String fcmToken,
			LocalDateTime createdAt, String createdBy, String updatedBy, LocalDateTime updatedAt, String googleId) {
		super();
		this.mobile = mobile;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.education = education;
		this.optedClasses = optedClasses;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.addressRole = addressRole;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.isMobileVerified = isMobileVerified;
		this.isEmailVerified = isEmailVerified;
		this.emailOtp = emailOtp;
		this.mobileOtp = mobileOtp;
		this.emailOtpGeneratedAt = emailOtpGeneratedAt;
		this.mobileOtpGeneratedAt = mobileOtpGeneratedAt;
		this.fcmToken = fcmToken;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
		this.googleId = googleId;
	}

	public UserDTO() {
	}

	public void setId(Long id) {
	}

	public Long getId() {
		return null;
	}

}
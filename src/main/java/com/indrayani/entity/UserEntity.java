package com.indrayani.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "mobile")
	private String mobile;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_first_name")
	private String firstName;
	@Column(name = "user_last_name")
	private String lastName;
	@Column(name = "user_education")
	private String education;
	@Column(name = "user_opted_classes")
	private String optedClasses;
	@Column(name = "user_city")
	private String city;
	@Column(name = "user_district")
	private String district;
	@Column(name = "user_state")
	private String state;
	@Column(name = "user_pin_code")
	private String pincode;
	@Column(name = "user_address_role")
	private String addressRole;
	@Column(name = "user_is_active")
	private Boolean isActive;
	@Column(name = "user_is_deleted")
	private Boolean isDeleted;
	@Column(name = "user_is_mobile_verified")
	private Boolean isMobileVerified;
	@Column(name = "is_email_verified")
	private Boolean isEmailVerified;
	@Column(name = "email_otp")
	private String emailOtp;
	@Column(name = "user_mobile_otp")
	private String mobileOtp;
	@Column(name = "email_otp_generated_at")
	private LocalDateTime emailOtpGeneratedAt;
	@Column(name = "user_mobile_otp_generated_at")
	private LocalDateTime mobileOtpGeneratedAt;
	@Column(name = "user_fcm_token")
	private String fcmToken;
	@Column(name = "user_created_at")
	private LocalDateTime createdAt;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	@Column(name = "google_id")
	private String googleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public UserEntity(Long id, String mobile, String email, String firstName, String lastName, String education,
			String optedClasses, String city, String district, String state, String pincode, String addressRole,
			Boolean isActive, Boolean isDeleted, Boolean isMobileVerified, Boolean isEmailVerified, String emailOtp,
			String mobileOtp, LocalDateTime emailOtpGeneratedAt, LocalDateTime mobileOtpGeneratedAt, String fcmToken,
			LocalDateTime createdAt, String createdBy, String updatedBy, LocalDateTime updatedAt, String googleId) {
		super();
		this.id = id;
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

	public UserEntity() {
		super();
	}

}

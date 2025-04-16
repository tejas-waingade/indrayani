package com.indrayani.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "usersSignUp")
public class UserSignUpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "education")
	private String education;
	@Column(name = "city")
	private String city;
	@Column(name = "district")
	private String district;
	@Column(name = "state")
	private String state;
	@Column(name = "pin_code")
	private String pinCode;
	@Column(name = "fcm_token")
	private String fcmToken;
	@Column(name = "google_id", unique = true)
	private String googleId;

	@PrePersist
	public void generateGoogleId() {
		if (this.googleId == null) {
			this.googleId = java.util.UUID.randomUUID().toString();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public UserSignUpEntity(String firstName, String lastName, String email, String mobile, String education,
	        String city, String district, String state, String pinCode, String fcmToken) {
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
	
	public UserSignUpEntity() {
		super();
	}

}

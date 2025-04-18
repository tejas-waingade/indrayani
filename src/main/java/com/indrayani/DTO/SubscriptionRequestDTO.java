package com.indrayani.DTO;

public class SubscriptionRequestDTO {

	private String examCode;
	private String status;

	public SubscriptionRequestDTO() {
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
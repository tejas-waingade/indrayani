package com.indrayani.DTO;

public class SubscriptionDTO {

	private Integer subId;
	private Integer userId;
	private String examCode;
	private String orderId;
	private String startDate;
	private String endDate;
	private String status;
	private String createdAt;

	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public SubscriptionDTO(Integer subId, Integer userId, String examCode, String orderId, String startDate,
			String endDate, String status, String createdAt) {
		super();
		this.subId = subId;
		this.userId = userId;
		this.examCode = examCode;
		this.orderId = orderId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.createdAt = createdAt;
	}

	public SubscriptionDTO() {
		super();
	}

}
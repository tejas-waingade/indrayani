package com.indrayani.DTO;

import java.time.LocalDateTime;

public class TransactionDTO {

	private String transactionId;
	private String orderId;
	private Double price;
	private LocalDateTime transactionDate;
	private String transactionStatus;
	private String examCode;
	private String createdBy;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public TransactionDTO(String transactionId, String orderId, Double price, LocalDateTime transactionDate,
			String transactionStatus, String examCode, String createdBy) {
		super();
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.price = price;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
		this.examCode = examCode;
		this.createdBy = createdBy;
	}

	public TransactionDTO() {
		super();
	}

}
package com.indrayani.DTO;

import java.time.LocalDateTime;

public class TransactionDTO {

	private String transactionId;
	private String orderId;
	private Double price;
	private String banktransId;
	private LocalDateTime transactionDate;
	private String transactionStatus;
	private LocalDateTime createdAt;
	private String createdBy;
	private LocalDateTime updatedAt;
	private String updatedBy;

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

	public String getBanktransId() {
		return banktransId;
	}

	public void setBanktransId(String banktransId) {
		this.banktransId = banktransId;
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

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public TransactionDTO(String transactionId, String orderId, Double price, String banktransId,
			LocalDateTime transactionDate, String transactionStatus, LocalDateTime createdAt, String createdBy,
			LocalDateTime updatedAt, String updatedBy) {
		super();
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.price = price;
		this.banktransId = banktransId;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	public TransactionDTO() {
		super();

	}

}
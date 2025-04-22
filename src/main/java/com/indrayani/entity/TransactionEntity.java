package com.indrayani.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private Long id;

	@Column(name = "transaction_id", unique = true, nullable = false)
	private String transactionId;

	@Column(name = "order_id", unique = true, nullable = false)
	private String orderId;

	@Column(nullable = false)
	private Double price;

	@Column(name = "transaction_date", nullable = false)
	private LocalDateTime transactionDate;

	@Column(name = "transaction_status", nullable = false)
	private String transactionStatus;

	@Column(name = "exam_code", nullable = false)
	private String examCode;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public TransactionEntity(Long id, String transactionId, String orderId, Double price, LocalDateTime transactionDate,
			String transactionStatus, String examCode, String createdBy) {
		super();
		this.id = id;
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.price = price;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
		this.examCode = examCode;
		this.createdBy = createdBy;
	}

	public TransactionEntity() {
		super();
	}

}

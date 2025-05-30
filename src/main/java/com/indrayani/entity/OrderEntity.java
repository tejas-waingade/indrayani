package com.indrayani.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "orders_order_id")
	private String orderId;
	@Column(name = "orders_user_id")
	private Long userId;
	@Column(name = "orders_total_amount")
	private BigDecimal totalAmount;
	@Column(name = "orders_payable_amount")
	private BigDecimal payableAmount;
	@Column(name = "orders_discount")
	private BigDecimal discount;
	@Column(name = "orders_created_at")
	private LocalDateTime createdAt;
	@Column(name = "orders_updated_at")
	private LocalDateTime updatedAt;
	@Column(name = "orders_updated_by")
	private String updatedBy;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderExamMap> orderExamMaps;

	private String razorpayOrderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
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

	public List<OrderExamMap> getOrderExamMaps() {
		return orderExamMaps;
	}

	public void setOrderExamMaps(List<OrderExamMap> orderExamMaps) {
		this.orderExamMaps = orderExamMaps;
	}

	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}

	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}

	public OrderEntity(Long id, String orderId, Long userId, BigDecimal totalAmount, BigDecimal payableAmount,
			BigDecimal discount, LocalDateTime createdAt, LocalDateTime updatedAt, String updatedBy,
			List<OrderExamMap> orderExamMaps, String razorpayOrderId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.payableAmount = payableAmount;
		this.discount = discount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.orderExamMaps = orderExamMaps;
		this.razorpayOrderId = razorpayOrderId;
	}

	public OrderEntity() {
		super();
	}

}

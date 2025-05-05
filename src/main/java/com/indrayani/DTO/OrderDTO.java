package com.indrayani.DTO;

import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {

	private Long userId;
	private Long orderId;
	private BigDecimal totalAmount;
	private BigDecimal payableAmount;
	private BigDecimal discount;
	private List<String> examCodes;

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

	public List<String> getExamCodes() {
		return examCodes;
	}

	public void setExamCodes(List<String> examCodes) {
		this.examCodes = examCodes;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public OrderDTO(Long userId, Long orderId, BigDecimal totalAmount, BigDecimal payableAmount, BigDecimal discount,
			List<String> examCodes) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.payableAmount = payableAmount;
		this.discount = discount;
		this.examCodes = examCodes;
	}

	public OrderDTO() {
		super();
	}

}

package com.indrayani.DTO;

import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {

	private Long userId;
	private BigDecimal totalAmount;
	private BigDecimal payableAmount;
	private BigDecimal discount;
	private List<Long> examIds;

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

	public List<Long> getExamIds() {
		return examIds;
	}

	public void setExamIds(List<Long> list) {
		this.examIds = list;
	}

	public OrderDTO(Long userId, BigDecimal totalAmount, BigDecimal payableAmount, BigDecimal discount,
			List<Long> examIds) {
		super();
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.payableAmount = payableAmount;
		this.discount = discount;
		this.examIds = examIds;
	}

	public OrderDTO() {
		super();
	}

}

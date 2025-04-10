package com.indrayani.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TrendingExamDTO {
	private Long id;
	private String examCode;
	private String type;
	private Integer orderNo;
	private LocalDate launchDate;
	private LocalDateTime createdAt;
	private String createdBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public LocalDate getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(LocalDate launchDate) {
		this.launchDate = launchDate;
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

	public TrendingExamDTO(Long id, String examCode, String type, Integer orderNo, LocalDate launchDate,
			LocalDateTime createdAt, String createdBy) {
		super();
		this.id = id;
		this.examCode = examCode;
		this.type = type;
		this.orderNo = orderNo;
		this.launchDate = launchDate;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
	}

	public TrendingExamDTO() {
		super();
	}

}

package com.indrayani.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "trending_upcoming_exams")
public class TrendingExamEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "rending_upcoming_exams_exam_code")
	private String examCode;
	@Column(name = "rending_upcoming_exams_type")

	private String type;
	@Column(name = "rending_upcoming_exams_order_no")

	private Integer orderNo;
	@Column(name = "rending_upcoming_exams_launch_date")

	private LocalDate launchDate;
	@Column(name = "rending_upcoming_exams_created_at")

	private LocalDateTime createdAt;
	@Column(name = "rending_upcoming_exams_created_by")

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

	public TrendingExamEntity(Long id, String examCode, String type, Integer orderNo, LocalDate launchDate,
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

	public TrendingExamEntity() {
		super();

	}

}

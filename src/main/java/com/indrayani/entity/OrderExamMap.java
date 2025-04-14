package com.indrayani.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "order_exam_map")
public class OrderExamMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;

	@ManyToOne
	@JoinColumn(name = "exam_id")
	private ExamEntity exam;

	@Column(name = "exam_code")
	private String examCode;
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public ExamEntity getExam() {
		return exam;
	}

	public void setExam(ExamEntity exam) {
		this.exam = exam;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public OrderExamMap(Long id, OrderEntity order, ExamEntity exam, String examCode, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.order = order;
		this.exam = exam;
		this.examCode = examCode;
		this.createdAt = createdAt;
	}

	public OrderExamMap() {
		super();

	}
}
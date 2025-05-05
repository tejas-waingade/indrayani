package com.indrayani.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "order_exam_map",uniqueConstraints = {
		@UniqueConstraint(columnNames= {"order_id", "exam_code"})
})
public class OrderExamMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private OrderEntity order;

	@Column(name = "exam_code")
	private String examCode;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
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

	public OrderExamMap(Long id, OrderEntity order, String examCode, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.order = order;
		this.examCode = examCode;
		this.createdAt = createdAt;
	}

	public OrderExamMap() {
		super();

	}
}
package com.indrayani.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoriesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "categories_category_name")
	private String categoryName;

	@Column(name = "image")
	private String image;

	@Column(name = "categories_description")
	private String description;

	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "categories_parent_category")
	private String parentCategory;

	@Column(name = "categories_created_at")
	private LocalDateTime createdAt;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "categories_isActive")
	private Boolean isActive;

	@JsonIgnore
	@ManyToMany(mappedBy = "categories")
	private List<ExamEntity> exams;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<ExamEntity> getExams() {
		return exams;
	}

	public void setExams(List<ExamEntity> exams) {
		this.exams = exams;
	}

	public CategoriesEntity(Long id, String categoryName, String image, String description, String orderNumber,
			String parentCategory, LocalDateTime createdAt, String createdBy, String updatedBy, LocalDateTime updatedAt,
			Boolean isActive, List<ExamEntity> exams) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.image = image;
		this.description = description;
		this.orderNumber = orderNumber;
		this.parentCategory = parentCategory;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
		this.exams = exams;
	}

	public CategoriesEntity() {
		super();
	}

}

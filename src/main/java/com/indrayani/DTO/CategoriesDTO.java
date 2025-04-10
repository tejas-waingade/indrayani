package com.indrayani.DTO;

import java.time.LocalDateTime;

public class CategoriesDTO {

	private String categoryName;
	private String image;
	private String description;
	private String orderNumber;
	private String parentCategory;
	private LocalDateTime createdAt;
	private String createdBy;
	private String updatedBy;
	private LocalDateTime updatedAt;
	private Boolean isActive;

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

	public CategoriesDTO(String categoryName, String image, String description, String orderNumber,
			String parentCategory, LocalDateTime createdAt, String createdBy, String updatedBy, LocalDateTime updatedAt,
			Boolean isActive) {
		super();

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
	}

	public CategoriesDTO() {
		super();
	}

	public Long getId() {
		return null;
	}

}

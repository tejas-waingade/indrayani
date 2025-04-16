package com.indrayani.DTO;

import java.time.OffsetDateTime;

public class CatExamDTO {

	private Long id;
	private Integer categoryId;
	private String categoryName;
	private Integer parentCategory;
	private String examCode;
	private String examName;
	private String examDesc;
	private String examType;
	private Integer price;
	private Integer examDuration;
	private Integer totalQuestions;
	private Integer totalMarks;
	private Integer passingMarks;
	private Integer passingPercent;
	private String difficultyLevel;
	private String img;
	private Integer rightAns;
	private Integer wrongAns;
	private Integer skipAns;
	private Integer isActive;
	private OffsetDateTime createdAt;
	private Integer createdBy;
	private Integer updatedBy;
	private OffsetDateTime updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Integer parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamDesc() {
		return examDesc;
	}

	public void setExamDesc(String examDesc) {
		this.examDesc = examDesc;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getExamDuration() {
		return examDuration;
	}

	public void setExamDuration(Integer examDuration) {
		this.examDuration = examDuration;
	}

	public Integer getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Integer getPassingMarks() {
		return passingMarks;
	}

	public void setPassingMarks(Integer passingMarks) {
		this.passingMarks = passingMarks;
	}

	public Integer getPassingPercent() {
		return passingPercent;
	}

	public void setPassingPercent(Integer passingPercent) {
		this.passingPercent = passingPercent;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getRightAns() {
		return rightAns;
	}

	public void setRightAns(Integer rightAns) {
		this.rightAns = rightAns;
	}

	public Integer getWrongAns() {
		return wrongAns;
	}

	public void setWrongAns(Integer wrongAns) {
		this.wrongAns = wrongAns;
	}

	public Integer getSkipAns() {
		return skipAns;
	}

	public void setSkipAns(Integer skipAns) {
		this.skipAns = skipAns;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public OffsetDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(OffsetDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public CatExamDTO(Long id, Integer categoryId, String categoryName, Integer parentCategory, String examCode,
			String examName, String examDesc, String examType, Integer price, Integer examDuration,
			Integer totalQuestions, Integer totalMarks, Integer passingMarks, Integer passingPercent,
			String difficultyLevel, String img, Integer rightAns, Integer wrongAns, Integer skipAns, Integer isActive,
			OffsetDateTime createdAt, Integer createdBy, Integer updatedBy, OffsetDateTime updatedAt) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.parentCategory = parentCategory;
		this.examCode = examCode;
		this.examName = examName;
		this.examDesc = examDesc;
		this.examType = examType;
		this.price = price;
		this.examDuration = examDuration;
		this.totalQuestions = totalQuestions;
		this.totalMarks = totalMarks;
		this.passingMarks = passingMarks;
		this.passingPercent = passingPercent;
		this.difficultyLevel = difficultyLevel;
		this.img = img;
		this.rightAns = rightAns;
		this.wrongAns = wrongAns;
		this.skipAns = skipAns;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
	}

	public CatExamDTO() {
		super();
	}

}

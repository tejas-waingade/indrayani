package com.indrayani.entity;

import java.time.OffsetDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "catExam")
public class CatExamEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "category_id")
	private Integer categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "parent_category")
	private Integer parentCategory;

	@Column(name = "exam_code")
	private String examCode;

	@Column(name = "exam_name")
	private String examName;

	@Column(name = "exam_desc")
	private String examDesc;

	@Column(name = "exam_type")
	private String examType;

	@Column(name = "price")
	private Integer price;

	@Column(name = "exam_duration")
	private Integer examDuration;

	@Column(name = "total_questions")
	private Integer totalQuestions;

	@Column(name = "total_marks")
	private Integer totalMarks;

	@Column(name = "passing_marks")
	private Integer passingMarks;

	@Column(name = "passing_percent")
	private Integer passingPercent;

	@Column(name = "difficulty_level")
	private String difficultyLevel;

	@Column(name = "img")
	private String img;

	@Column(name = "right_ans")
	private Integer rightAns;

	@Column(name = "wrong_ans")
	private Integer wrongAns;

	@Column(name = "skip_ans")
	private Integer skipAns;

	@Column(name = "is_active")
	private Integer isActive;

	@Column(name = "created_at")
	private OffsetDateTime createdAt;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "updated_at")
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

	public CatExamEntity(Long id, Integer categoryId, String categoryName, Integer parentCategory, String examCode,
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

	public CatExamEntity() {
		super();
	}

}

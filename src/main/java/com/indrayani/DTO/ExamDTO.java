package com.indrayani.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ExamDTO {

	private List<Long> categoryIds;
	private String examCode;
	private String examName;
	private String examDesc;
	private String examType;
	private int price;
	private int examDuration;
	private int totalQuestions;
	private int totalMarks;
	private int passingMarks;
	private BigDecimal passingPercent;
	private String difficultyLevel;
	private String img;
	private int rightAns;
	private int wrongAns;
	private int skipAns;
	private Boolean isActive;
	private LocalDateTime createdAt;
	private String createdBy;
	private LocalDateTime updatedAt;
	private String updatedBy;

	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getExamDuration() {
		return examDuration;
	}

	public void setExamDuration(int examDuration) {
		this.examDuration = examDuration;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getPassingMarks() {
		return passingMarks;
	}

	public void setPassingMarks(int passingMarks) {
		this.passingMarks = passingMarks;
	}

	public BigDecimal getPassingPercent() {
		return passingPercent;
	}

	public void setPassingPercent(BigDecimal passingPercent) {
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

	public int getRightAns() {
		return rightAns;
	}

	public void setRightAns(int rightAns) {
		this.rightAns = rightAns;
	}

	public int getWrongAns() {
		return wrongAns;
	}

	public void setWrongAns(int wrongAns) {
		this.wrongAns = wrongAns;
	}

	public int getSkipAns() {
		return skipAns;
	}

	public void setSkipAns(int skipAns) {
		this.skipAns = skipAns;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public ExamDTO(List<Long> categoryIds, String examCode, String examName, String examDesc, String examType,
			int price, int examDuration, int totalQuestions, int totalMarks, int passingMarks,
			BigDecimal passingPercent, String difficultyLevel, String img, int rightAns, int wrongAns, int skipAns,
			Boolean isActive, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
		super();
		this.categoryIds = categoryIds;
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
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	public ExamDTO() {
		super();
	}

}
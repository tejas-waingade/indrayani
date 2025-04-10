package com.indrayani.DTO;

import java.time.LocalDateTime;

public class ExamDTO {

	private String examCode;
	private String examName;
	private String examDesc;
	private String examType;
	private int price;
	private int examDuration;
	private int totalMarks;
	private int passingMarks;
	private int passingPercent;
	private String difficultyLevel;
	private String img;
	private int rightAns;
	private int wrongAns;
	private int skipAns;
	private Boolean isActive;
	private int totalQuestions;
	private LocalDateTime createdAt;
	private String createdBy;
	private String updatedBy;
	private LocalDateTime updatedAt;

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

	public int getPassingPercent() {
		return passingPercent;
	}

	public void setPassingPercent(int passingPercent) {
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

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
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

	public ExamDTO(String examCode, String examName, String examDesc, String examType, int price, int examDuration,
			int totalMarks, int passingMarks, int passingPercent, String difficultyLevel, String img, int rightAns,
			int wrongAns, int skipAns, Boolean isActive, int totalQuestions, LocalDateTime createdAt, String createdBy,
			String updatedBy, LocalDateTime updatedAt) {
		super();
		this.examCode = examCode;
		this.examName = examName;
		this.examDesc = examDesc;
		this.examType = examType;
		this.price = price;
		this.examDuration = examDuration;
		this.totalMarks = totalMarks;
		this.passingMarks = passingMarks;
		this.passingPercent = passingPercent;
		this.difficultyLevel = difficultyLevel;
		this.img = img;
		this.rightAns = rightAns;
		this.wrongAns = wrongAns;
		this.skipAns = skipAns;
		this.isActive = isActive;
		this.totalQuestions = totalQuestions;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
	}

	public ExamDTO() {
		super();
	}

}

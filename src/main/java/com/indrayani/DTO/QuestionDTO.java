package com.indrayani.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionDTO {

	private Long id;
	private String questionText;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String rightOption;
	private String difficultyLevel;
	private String description;
	private String note;
	private List<String> mapExam;
	private LocalDateTime createdAt;
	private String createdBy;
	private String updatedBy;
	private LocalDateTime updatedAt;
	private Boolean isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getRightOption() {
		return rightOption;
	}

	public void setRightOption(String rightOption) {
		this.rightOption = rightOption;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<String> getMapExam() {
		return mapExam;
	}

	public void setMapExam(List<String> mapExam) {
		this.mapExam = mapExam;
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

	public QuestionDTO(Long id, String questionText, String option1, String option2, String option3, String option4,
			String rightOption, String difficultyLevel, String description, String note, List<String> mapExam,
			LocalDateTime createdAt, String createdBy, String updatedBy, LocalDateTime updatedAt, Boolean isActive) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rightOption = rightOption;
		this.difficultyLevel = difficultyLevel;
		this.description = description;
		this.note = note;
		this.mapExam = mapExam;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
	}

	public QuestionDTO() {
		super();

	}
}

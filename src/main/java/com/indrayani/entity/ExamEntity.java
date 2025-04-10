package com.indrayani.entity;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "exams")
public class ExamEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "exam_code", nullable = false)
	private String examCode;
	
	@Column(name = "exam_name", nullable = false)
	private String examName;

	@Column(name = "exams_desc")
	private String examDesc;

	@Column(name = "exams_type")
	private String examType;

	@Column(name = "exams_price")
	private int price;

	@Column(name = "exams_duration")
	private int examDuration;

	@Column(name = "exams_total_marks")
	private int totalMarks;

	@Column(name = "exams_passing_marks")
	private int passingMarks;

	@Column(name = "exams_passing_percent")
	private int passingPercent;

	@Column(name = "exams_difficulty_level")
	private String difficultyLevel;

	@Column(name = "exams_img")
	private String img;

	@Column(name = "exams_right_ans")
	private int rightAns;

	@Column(name = "exams_wrong_ans")
	private int wrongAns;

	@Column(name = "exams_skip_ans")
	private int skipAns;

	@Column(name = "exams_is_active")
	private Boolean isActive;

	@Column(name = "exams_total_questions")
	private int totalQuestions;

	@Column(name = "exams_created_at")
	private LocalDateTime createdAt;

	@Column(name = "exams_created_by")
	private String createdBy;

	@Column(name = "exams_updated_by")
	private String updatedBy;

	@Column(name = "exams_updated_at")
	private LocalDateTime updatedAt;

	@ManyToMany
	@JoinTable(name = "exam_category_mapping", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<CategoriesEntity> categories;

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

	public List<CategoriesEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoriesEntity> categories) {
		this.categories = categories;
	}

	public ExamEntity(Long id, String examCode, String examName, String examDesc, String examType, int price,
			int examDuration, int totalMarks, int passingMarks, int passingPercent, String difficultyLevel, String img,
			int rightAns, int wrongAns, int skipAns, Boolean isActive, int totalQuestions, LocalDateTime createdAt,
			String createdBy, String updatedBy, LocalDateTime updatedAt, List<CategoriesEntity> categories) {
		super();
		this.id = id;
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
		this.categories = categories;
	}

	public ExamEntity() {
		super();

	}
}

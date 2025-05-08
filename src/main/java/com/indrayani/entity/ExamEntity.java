package com.indrayani.entity;

import java.math.BigDecimal;
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

	@Column(name = "exam_desc")
	private String examDesc;

	@Column(name = "exam_type")
	private String examType;

	@Column(name = "price")
	private int price;

	@Column(name = "duration")
	private int examDuration;

	@Column(name = "total_questions")
	private int totalQuestions;

	@Column(name = "total_marks")
	private int totalMarks;

	@Column(name = "passing_marks")
	private int passingMarks;

	@Column(name = "passing_percent")
	private BigDecimal passingPercent;

	@Column(name = "difficulty_level")
	private String difficultyLevel;

	@Column(name = "img")
	private String img;

	@Column(name = "right_ans")
	private int rightAns;

	@Column(name = "wrong_ans")
	private int wrongAns;

	@Column(name = "skip_ans")
	private int skipAns;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "updated_by")
	private String updatedBy;

	@ManyToMany
	@JoinTable(name = "exam_cat_map", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
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

	public List<CategoriesEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoriesEntity> categories) {
		this.categories = categories;
	}

	public ExamEntity(Long id, String examCode, String examName, String examDesc, String examType, int price,
			int examDuration, int totalQuestions, int totalMarks, int passingMarks, BigDecimal passingPercent,
			String difficultyLevel, String img, int rightAns, int wrongAns, int skipAns, Boolean isActive,
			LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy,
			List<CategoriesEntity> categories) {
		super();
		this.id = id;
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
		this.categories = categories;
	}

	public ExamEntity() {
		super();
	}
}
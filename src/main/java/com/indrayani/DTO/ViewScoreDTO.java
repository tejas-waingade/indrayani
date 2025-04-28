package com.indrayani.DTO;

import java.time.LocalDateTime;

public class ViewScoreDTO {

	private Long id;
	private String user;
	private String email;
	private String mobile;
	private String examCode;
	private String exam;
	private Double score;
	private LocalDateTime attemptedOn;
	private Integer timeTaken;
	private Double averageTimeSpendPerQuestion;
	private Integer questionsAttempted;
	private Integer questionsUnattempted;
	private Integer incorrectAnswers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public LocalDateTime getAttemptedOn() {
		return attemptedOn;
	}

	public void setAttemptedOn(LocalDateTime attemptedOn) {
		this.attemptedOn = attemptedOn;
	}

	public Integer getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Integer timeTaken) {
		this.timeTaken = timeTaken;
	}

	public Double getAverageTimeSpendPerQuestion() {
		return averageTimeSpendPerQuestion;
	}

	public void setAverageTimeSpendPerQuestion(Double averageTimeSpendPerQuestion) {
		this.averageTimeSpendPerQuestion = averageTimeSpendPerQuestion;
	}

	public Integer getQuestionsAttempted() {
		return questionsAttempted;
	}

	public void setQuestionsAttempted(Integer questionsAttempted) {
		this.questionsAttempted = questionsAttempted;
	}

	public Integer getQuestionsUnattempted() {
		return questionsUnattempted;
	}

	public void setQuestionsUnattempted(Integer questionsUnattempted) {
		this.questionsUnattempted = questionsUnattempted;
	}

	public Integer getIncorrectAnswers() {
		return incorrectAnswers;
	}

	public void setIncorrectAnswers(Integer incorrectAnswers) {
		this.incorrectAnswers = incorrectAnswers;
	}

	public ViewScoreDTO(Long id, String user, String email, String mobile, String examCode, String exam, Double score,
			LocalDateTime attemptedOn, Integer timeTaken, Double averageTimeSpendPerQuestion,
			Integer questionsAttempted, Integer questionsUnattempted, Integer incorrectAnswers) {
		super();
		this.id = id;
		this.user = user;
		this.email = email;
		this.mobile = mobile;
		this.examCode = examCode;
		this.exam = exam;
		this.score = score;
		this.attemptedOn = attemptedOn;
		this.timeTaken = timeTaken;
		this.averageTimeSpendPerQuestion = averageTimeSpendPerQuestion;
		this.questionsAttempted = questionsAttempted;
		this.questionsUnattempted = questionsUnattempted;
		this.incorrectAnswers = incorrectAnswers;
	}

	public ViewScoreDTO() {
		super();
	}
}

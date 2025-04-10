package com.indrayani.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exam_results")
public class ExamResultEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(name = "result_id")
	private int resultId;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "exam_code")
	private String examCode;
	@Column(name = "score")
	private String score;
	@Column(name = "attempted_at")
	private String attemptedAt;
	@Column(name = "time_taken")
	private String timeTaken;
	@Column(name = "skip_ans")
	private String skipAns;
	@Column(name = "unskip_ans")
	private String unskipAns;
	@Column(name = "wrong_ans")
	private String wrongAns;
	@Column(name = "right_ans")
	private String rightAns;
	@Column(name = "total_questions")
	private String totalQuestions;
	@Column(name = "question_avg_time")
	private String questionAvgTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getAttemptedAt() {
		return attemptedAt;
	}

	public void setAttemptedAt(String attemptedAt) {
		this.attemptedAt = attemptedAt;
	}

	public String getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getSkipAns() {
		return skipAns;
	}

	public void setSkipAns(String skipAns) {
		this.skipAns = skipAns;
	}

	public String getUnskipAns() {
		return unskipAns;
	}

	public void setUnskipAns(String unskipAns) {
		this.unskipAns = unskipAns;
	}

	public String getWrongAns() {
		return wrongAns;
	}

	public void setWrongAns(String wrongAns) {
		this.wrongAns = wrongAns;
	}

	public String getRightAns() {
		return rightAns;
	}

	public void setRightAns(String rightAns) {
		this.rightAns = rightAns;
	}

	public String getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(String totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public String getQuestionAvgTime() {
		return questionAvgTime;
	}

	public void setQuestionAvgTime(String questionAvgTime) {
		this.questionAvgTime = questionAvgTime;
	}

	public ExamResultEntity(Long id, int resultId, int userId, String examCode, String score, String attemptedAt,
			String timeTaken, String skipAns, String unskipAns, String wrongAns, String rightAns, String totalQuestions,
			String questionAvgTime) {
		super();
		this.id = id;
		this.resultId = resultId;
		this.userId = userId;
		this.examCode = examCode;
		this.score = score;
		this.attemptedAt = attemptedAt;
		this.timeTaken = timeTaken;
		this.skipAns = skipAns;
		this.unskipAns = unskipAns;
		this.wrongAns = wrongAns;
		this.rightAns = rightAns;
		this.totalQuestions = totalQuestions;
		this.questionAvgTime = questionAvgTime;
	}

	public ExamResultEntity() {
		super();
	}

}

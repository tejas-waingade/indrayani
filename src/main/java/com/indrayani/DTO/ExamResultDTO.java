package com.indrayani.DTO;


public class ExamResultDTO {

	private int resultId;
	private int userId;
	private String examCode;
	private String score;
	private String attemptedAt;
	private String timeTaken;
	private String skipAns;
	private String unskipAns;
	private String wrongAns;
	private String rightAns;
	private String totalQuestions;
	private String questionAvgTime;

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

	public ExamResultDTO(int resultId, int userId, String examCode, String score, String attemptedAt, String timeTaken,
			String skipAns, String unskipAns, String wrongAns, String rightAns, String totalQuestions,
			String questionAvgTime) {
		super();
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

}

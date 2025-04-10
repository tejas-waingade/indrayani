package com.indrayani.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exam_result_details")
public class ExamDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(name = "result_id")
	private int resultid;
	@Column(name = "question_id")
	private int questionid;
	@Column(name = "selection")
	private String selection;
	@Column(name = "time_taken")
	private String timeTaken;
	@Column(name = "iscorrectopt")
	private String isCorrectOpt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getResultid() {
		return resultid;
	}

	public void setResultid(int resultid) {
		this.resultid = resultid;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public String getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getIsCorrectOpt() {
		return isCorrectOpt;
	}

	public void setIsCorrectOpt(String isCorrectOpt) {
		this.isCorrectOpt = isCorrectOpt;
	}

	public ExamDetailsEntity(Long id, int resultid, int questionid, String selection, String timeTaken,
			String isCorrectOpt) {
		super();
		this.id = id;
		this.resultid = resultid;
		this.questionid = questionid;
		this.selection = selection;
		this.timeTaken = timeTaken;
		this.isCorrectOpt = isCorrectOpt;
	}

	public ExamDetailsEntity() {
		super();
	}
}

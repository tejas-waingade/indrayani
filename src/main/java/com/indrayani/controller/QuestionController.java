package com.indrayani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.indrayani.DTO.QuestionDTO;
import com.indrayani.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@GetMapping("/{id}")
	public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable Long id) {
		QuestionDTO questionDTO = questionService.getQuestionById(id);
		if (questionDTO != null) {
			return ResponseEntity.ok(questionDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
 
	@GetMapping
	public ResponseEntity<List<QuestionDTO>> getAllQuestions() {
		List<QuestionDTO> questions = questionService.getAllQuestions();
		return ResponseEntity.ok(questions);
	}

	@PostMapping
	public ResponseEntity<QuestionDTO> addQuestion(@RequestBody QuestionDTO questionDTO) {
		QuestionDTO addedQuestion = questionService.addQuestion(questionDTO);
		return new ResponseEntity<>(addedQuestion, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<QuestionDTO> updateQuestion(@PathVariable Long id, @RequestBody QuestionDTO questionDTO) {
		QuestionDTO updatedQuestion = questionService.updateQuestion(id, questionDTO);
		if (updatedQuestion != null) {
			return ResponseEntity.ok(updatedQuestion);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
		questionService.deleteQuestion(id);
		return ResponseEntity.noContent().build();
	}
}

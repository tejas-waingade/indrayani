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
import com.indrayani.DTO.ExamResultDTO;
import com.indrayani.service.ExamResultService;

@RestController
@RequestMapping("/examresult")
public class ExamResultController {

	@Autowired
	private ExamResultService examResultService;

	@GetMapping
	public ResponseEntity<List<ExamResultDTO>> getAllExamResults() {
		List<ExamResultDTO> examResultDTOs = examResultService.getAllExamResults();
		return ResponseEntity.ok(examResultDTOs);
	}

	@PostMapping
	public ResponseEntity<ExamResultDTO> createExamResult(@RequestBody ExamResultDTO examResultDTO) {
		ExamResultDTO createdResult = examResultService.createExamResult(examResultDTO);
		return new ResponseEntity<>(createdResult, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExamResultDTO> updateExamResult(@PathVariable Long id,
			@RequestBody ExamResultDTO examResultDTO) {
		ExamResultDTO updatedResult = examResultService.updateExamResult(id, examResultDTO);
		return new ResponseEntity<>(updatedResult, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExamResult(@PathVariable Long id) {
		examResultService.deleteExamResult(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

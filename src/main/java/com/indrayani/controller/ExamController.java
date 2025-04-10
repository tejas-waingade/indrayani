package com.indrayani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.indrayani.DTO.ExamDTO;
import com.indrayani.entity.ExamEntity;
import com.indrayani.service.ExamService;

@RestController
@RequestMapping("/exams")
public class ExamController {

	@Autowired
	private ExamService examService;

	@Value("${project.image}")
	private String path;

	@GetMapping
	public List<ExamDTO> getallExams() {
		return examService.getAllExams();

	}

	@GetMapping("/{id}")
	public ResponseEntity<ExamDTO> getExamById(@PathVariable Long id) {
		ExamDTO examDTO = examService.getExamById(id);
		if (examDTO != null) {
			return ResponseEntity.ok(examDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<ExamDTO> addExam(@RequestBody ExamDTO examDTO) {
		ExamDTO ExamDTOObj = examService.addExam(examDTO);
		return new ResponseEntity<>(ExamDTOObj, HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	public ResponseEntity<ExamDTO> updateExam(@PathVariable Long id, @RequestBody ExamDTO examDTO) {
		ExamDTO updatedExam = examService.updateExam(id, examDTO);
		if (updatedExam == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedExam);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ExamEntity> deleteExamById(@PathVariable Long id) {
		examService.deleteExamById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/upload/image/{id}")
	public ResponseEntity<String> uploadExamImage(@RequestParam MultipartFile file, @PathVariable("id") Long examId) {
		boolean isUploaded = examService.uploadExamImage(file, examId);
		if (isUploaded) {
			return new ResponseEntity<>("Image uploaded successfully for examId " + examId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to upload image for examId:" + examId,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}

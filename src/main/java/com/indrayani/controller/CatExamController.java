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
import com.indrayani.DTO.CatExamDTO;
import com.indrayani.service.CatExamService;

@RestController
@RequestMapping("/catExams")
public class CatExamController {

	@Autowired
	private CatExamService catExamService;

	@GetMapping
	public ResponseEntity<List<CatExamDTO>> getAllCatExams() {
		return new ResponseEntity<>(catExamService.getAllCatExams(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CatExamDTO> getCatExamById(@PathVariable Long id) {
		try {
			CatExamDTO catExamDTO = catExamService.getCatExamById(id);
			return new ResponseEntity<>(catExamDTO, HttpStatus.OK);
		} catch (org.springframework.web.server.ResponseStatusException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<CatExamDTO> createCatExam(@RequestBody CatExamDTO catExamDTO) {
		return new ResponseEntity<>(catExamService.createCatExam(catExamDTO), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CatExamDTO> updateCatExam(@PathVariable Long id, @RequestBody CatExamDTO catExamDTO) {
		try {
			return new ResponseEntity<>(catExamService.updateCatExam(id, catExamDTO), HttpStatus.OK);
		} catch (org.springframework.web.server.ResponseStatusException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCatExam(@PathVariable Long id) {
		try {
			catExamService.deleteCatExam(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (org.springframework.web.server.ResponseStatusException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

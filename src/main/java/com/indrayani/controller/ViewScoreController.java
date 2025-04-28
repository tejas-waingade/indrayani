package com.indrayani.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.indrayani.DTO.ViewScoreDTO;
import com.indrayani.service.ViewScoreService;

@RestController
@RequestMapping("/viewscore")
public class ViewScoreController {

	@Autowired
	private ViewScoreService viewScoreService;

	@GetMapping
	public ResponseEntity<List<ViewScoreDTO>> getAllViewScores() {
		List<ViewScoreDTO> viewScoreDTOs = viewScoreService.getAllViewScores();
		return ResponseEntity.ok(viewScoreDTOs);
	}

	@PostMapping
	public ResponseEntity<ViewScoreDTO> createViewScore(@RequestBody ViewScoreDTO viewScoreDTO) {
		ViewScoreDTO createdViewScore = viewScoreService.createViewScore(viewScoreDTO);
		return new ResponseEntity<>(createdViewScore, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ViewScoreDTO> updateViewScore(@PathVariable Long id, @RequestBody ViewScoreDTO viewScoreDTO) {
		ViewScoreDTO updatedViewScore = viewScoreService.updateViewScore(id, viewScoreDTO);
		return new ResponseEntity<>(updatedViewScore, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteViewScore(@PathVariable Long id) {
		viewScoreService.deleteViewScore(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

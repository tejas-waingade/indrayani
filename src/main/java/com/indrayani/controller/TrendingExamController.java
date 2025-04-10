package com.indrayani.controller;

import com.indrayani.DTO.TrendingExamDTO;
import com.indrayani.service.TrendingExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trending-exams")
public class TrendingExamController {

	private final TrendingExamService service;

	public TrendingExamController(TrendingExamService service) {
		this.service = service;
	}

	@PostMapping
	public TrendingExamDTO create(@RequestBody TrendingExamDTO dto) {
		return service.save(dto);
	}

	@GetMapping
	public List<TrendingExamDTO> getAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public TrendingExamDTO getById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PutMapping("/{id}")
	public TrendingExamDTO update(@PathVariable Long id, @RequestBody TrendingExamDTO dto) {
		return service.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
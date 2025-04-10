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
import com.indrayani.DTO.CategoriesDTO;
import com.indrayani.entity.CategoriesEntity;
import com.indrayani.service.CategoriesService;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;

	@GetMapping
	public List<CategoriesDTO> getallCategories() {
		return categoriesService.getAllCategories();

	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriesDTO> getCategoriesById(@PathVariable Long id) {
		CategoriesDTO categoriesDTO = categoriesService.getCategoriesById(id);
		if (categoriesDTO != null) {
			return ResponseEntity.ok(categoriesDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<CategoriesDTO> addCategories(@RequestBody CategoriesDTO categoriesDTO) {
		CategoriesDTO CategoriesDTOObj = categoriesService.addCategories(categoriesDTO);
		return new ResponseEntity<>(CategoriesDTOObj, HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriesDTO> updateCategories(@PathVariable Long id,@RequestBody CategoriesDTO categoriesDTO) {
		CategoriesDTO updatedCategories = categoriesService.updateCategories(id, categoriesDTO);
		if (updatedCategories == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedCategories);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CategoriesEntity> deleteCategoriesById(@PathVariable Long id) {
		categoriesService.deleteCategoriesById(id);
		return ResponseEntity.noContent().build();

	}

}

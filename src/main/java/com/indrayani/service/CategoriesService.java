package com.indrayani.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.indrayani.DTO.CategoriesDTO;
import com.indrayani.entity.CategoriesEntity;
import com.indrayani.mapper.CategoriesMapper;
import com.indrayani.repository.CategoriesRepository;

@Service
public class CategoriesService {
	@Autowired
	private final CategoriesRepository categoriesRepository;
	@Autowired
	private final CategoriesMapper categoriesMapper;

	public CategoriesService(CategoriesRepository categoriesRepository, CategoriesMapper categoriesMapper) {
		this.categoriesRepository = categoriesRepository;
		this.categoriesMapper = categoriesMapper;
	}

	public void save(CategoriesEntity categoriesEntity) {
	}

	private CategoriesDTO convertEntityToDto(CategoriesEntity categoriesEntity) {
		return categoriesMapper.toDTO(categoriesEntity);
	}

	public List<CategoriesDTO> getAllCategories() {
		return categoriesRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	public CategoriesDTO getCategoriesById(Long id) {
		return categoriesRepository.findById(id).map(this::convertEntityToDto).orElse(null);
	}

	public List<CategoriesEntity> getCategoriesData() {
		return categoriesRepository.findAll();
	}

	public Optional<CategoriesEntity> findByID(Long id) {
		return categoriesRepository.findById(id);

	}

	public List<CategoriesEntity> getActiveCategories(Boolean active) {
		return categoriesRepository.getActiveCategories(active);

	}

	public CategoriesDTO addCategories(CategoriesDTO categoriesDTO) {
		CategoriesEntity categoriesEntity = categoriesMapper.toEntity(categoriesDTO);
		CategoriesEntity categoriesEntityObj = categoriesRepository.save(categoriesEntity);
		CategoriesDTO categoriesDto = categoriesMapper.toDTO(categoriesEntityObj);
		return categoriesDto;
	}

	public CategoriesDTO updateCategories(Long id, CategoriesDTO categoriesDTO) {
		CategoriesEntity categoriesEntity = categoriesMapper.toEntity(categoriesDTO);
		categoriesEntity.setId(id);
		CategoriesEntity updatedCategoriesEntity = categoriesRepository.save(categoriesEntity);
		return categoriesMapper.toDTO(updatedCategoriesEntity);
	}

	public void deleteCategoriesById(Long id) {
		categoriesRepository.deleteById(id);
	}

}

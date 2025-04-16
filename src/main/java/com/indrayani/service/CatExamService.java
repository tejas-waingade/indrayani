package com.indrayani.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.indrayani.DTO.CatExamDTO;
import com.indrayani.entity.CatExamEntity;
import com.indrayani.mapper.CatExamMapper;
import com.indrayani.repository.CatExamRepository;

@Service
public class CatExamService {

	@Autowired
	private CatExamRepository catExamRepository;

	@Autowired
	private CatExamMapper catExamMapper;

	public List<CatExamDTO> getAllCatExams() {
		List<CatExamEntity> catExamEntities = catExamRepository.findAll();
		return catExamEntities.stream().map(catExamMapper::catExamEntityToCatExamDTO).collect(Collectors.toList());
	}

	public CatExamDTO getCatExamById(Long id) {
		Optional<CatExamEntity> optionalCatExam = catExamRepository.findById(id);
		if (optionalCatExam.isPresent()) {
			return catExamMapper.catExamEntityToCatExamDTO(optionalCatExam.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat Exam not found");
		}
	}

	public CatExamDTO createCatExam(CatExamDTO catExamDTO) {
		CatExamEntity catExamEntity = catExamMapper.catExamDTOToCatExamEntity(catExamDTO);
		CatExamEntity savedEntity = catExamRepository.save(catExamEntity);
		return catExamMapper.catExamEntityToCatExamDTO(savedEntity);
	}

	public CatExamDTO updateCatExam(Long id, CatExamDTO catExamDTO) {
		Optional<CatExamEntity> optionalCatExam = catExamRepository.findById(id);
		if (optionalCatExam.isPresent()) {
			CatExamEntity existingEntity = optionalCatExam.get();
			CatExamEntity updatedEntity = catExamMapper.catExamDTOToCatExamEntity(catExamDTO);
			updatedEntity.setId(existingEntity.getId());
			CatExamEntity savedEntity = catExamRepository.save(updatedEntity);
			return catExamMapper.catExamEntityToCatExamDTO(savedEntity);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat Exam not found");
		}
	}

	public void deleteCatExam(Long id) {
		if (catExamRepository.existsById(id)) {
			catExamRepository.deleteById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat Exam not found");
		}
	}
}

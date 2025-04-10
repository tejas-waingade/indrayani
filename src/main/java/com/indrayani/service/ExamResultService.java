package com.indrayani.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.indrayani.DTO.ExamResultDTO;
import com.indrayani.entity.ExamResultEntity;
import com.indrayani.mapper.ExamResultMapper;
import com.indrayani.repository.ExamResultRepository;

@Service
public class ExamResultService {

	@Autowired
	private ExamResultRepository examResultRepository;

	@Autowired
	private ExamResultMapper examResultMapper;

	public List<ExamResultDTO> getAllExamResults() {
		List<ExamResultEntity> examResultEntities = examResultRepository.findAll();
		return examResultEntities.stream().map(examResultMapper::toDTO).collect(Collectors.toList());
	}

    public ExamResultDTO createExamResult(ExamResultDTO examResultDTO) {
        ExamResultEntity examResultEntity = examResultMapper.toEntity(examResultDTO);
        ExamResultEntity savedEntity = examResultRepository.save(examResultEntity);
        return examResultMapper.toDTO(savedEntity);
    }
    
    public ExamResultDTO updateExamResult(Long id, ExamResultDTO examResultDTO) {
        Optional<ExamResultEntity> optionalExamResult = examResultRepository.findById(id);
        if (optionalExamResult.isPresent()) {
            ExamResultEntity existingEntity = optionalExamResult.get();
            ExamResultEntity updatedEntity = examResultMapper.toEntity(examResultDTO);
            updatedEntity.setId(existingEntity.getId()); 
            ExamResultEntity savedEntity = examResultRepository.save(updatedEntity);
            return examResultMapper.toDTO(savedEntity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exam result not found");
        }
    }

    public void deleteExamResult(Long id) {
        if (examResultRepository.existsById(id)) {
            examResultRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exam result not found");
        }
    }
}

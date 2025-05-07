package com.indrayani.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.indrayani.DTO.ExamDTO;
import com.indrayani.entity.CategoriesEntity;
import com.indrayani.entity.ExamEntity;
import com.indrayani.mapper.ExamMapper;
import com.indrayani.repository.CategoriesRepository;
import com.indrayani.repository.ExamRepository;

@Service
public class ExamService {

	@Autowired
	private ExamRepository examRepository;

	@Autowired
	private CategoriesRepository categoriesRepository;

	@Autowired
	private ExamMapper examMapper;

	@Value("${project.image}")
	private String uploadDir;

	public List<ExamDTO> getAllExams() {
		return examRepository.findAll().stream().map(examMapper::toDTO).collect(Collectors.toList());
	}

	public ExamDTO getExamById(Long id) {
		return examRepository.findById(id).map(examMapper::toDTO).orElse(null);
	}

	@Transactional
	public ExamDTO addExam(ExamDTO examDTO) {
		ExamEntity examEntity = examMapper.toEntity(examDTO);
		List<CategoriesEntity> categories = new ArrayList<>();
		if (examDTO.getCategoryIds() != null) {
			for (Long categoryId : examDTO.getCategoryIds()) {
				CategoriesEntity category = categoriesRepository.findById(categoryId)
						.orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
				categories.add(category);
			}
			examEntity.setCategories(categories);
		}
		examEntity = examRepository.save(examEntity);
		return examMapper.toDTO(examEntity);
	}

	@Transactional
	public ExamDTO updateExam(Long id, ExamDTO examDTO) {
		return examRepository.findById(id).map(existingExam -> {
			examDTO.setCreatedAt(existingExam.getCreatedAt());
			ExamEntity updatedExamEntity = examMapper.toEntity(examDTO);
			updatedExamEntity.setId(id);

			List<CategoriesEntity> updatedCategories = new ArrayList<>();

			if (examDTO.getCategoryIds() != null) {
				for (Long categoryId : examDTO.getCategoryIds()) {
					CategoriesEntity category = categoriesRepository.findById(categoryId)
							.orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
					updatedCategories.add(category);
				}
				updatedExamEntity.setCategories(updatedCategories);
			} else {

				updatedExamEntity.setCategories(existingExam.getCategories());
			}

			updatedExamEntity = examRepository.save(updatedExamEntity);
			return examMapper.toDTO(updatedExamEntity);
		}).orElseThrow(() -> new RuntimeException("Exam not found with ID: " + id));
	}

	@Transactional
	public void deleteExamById(Long id) {
		if (!examRepository.existsById(id)) {
			throw new RuntimeException("Exam not found with ID: " + id);
		}
		examRepository.deleteById(id);
	}

	public boolean uploadExamImage(MultipartFile file, Long examId) {
		try {
			Path examDir = Paths.get(uploadDir, Long.toString(examId));
			Files.createDirectories(examDir);
			String filename = file.getOriginalFilename();
			Path filePath = examDir.resolve(filename);
			file.transferTo(filePath.toFile());

			ExamEntity examEntity = examRepository.findById(examId)
					.orElseThrow(() -> new RuntimeException("Exam not found with ID: " + examId));
			examEntity.setImg(filename);
			examRepository.save(examEntity);

			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ExamMapper getExamMapper() {
		return examMapper;
	}

	public void setExamMapper(ExamMapper examMapper) {
		this.examMapper = examMapper;
	}
}
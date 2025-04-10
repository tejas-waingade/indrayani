package com.indrayani.service;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.indrayani.DTO.ExamDTO;
import com.indrayani.entity.ExamEntity;
import com.indrayani.mapper.ExamMapper;
import com.indrayani.repository.ExamRepository;

@Service
public class ExamService {

	@Autowired
	private ExamRepository examRepository;

	@Autowired
	private ExamMapper examMapper;

	@Value("${project.image}")
	private String uploadDir;

	public List<ExamDTO> getAllExams() {
		return examRepository.findAll().stream().map(ExamMapper::toDTO).collect(Collectors.toList());
	}

	public ExamDTO getExamById(Long id) {
		return examRepository.findById(id).map(ExamMapper::toDTO).orElse(null);
	}

	public ExamDTO addExam(ExamDTO examDTO) {
		ExamEntity examEntity = ExamMapper.toEntity(examDTO);
		examEntity = examRepository.save(examEntity);
		return ExamMapper.toDTO(examEntity);
	}

	public ExamDTO updateExam(Long id, ExamDTO examDTO) {
		if (!examRepository.existsById(id)) {
			throw new RuntimeException("Exam not found with ID: " + id);
		}

		ExamEntity examEntity = ExamMapper.toEntity(examDTO);
		examEntity.setId(id);
		examEntity = examRepository.save(examEntity);

		return ExamMapper.toDTO(examEntity);
	}

	public void deleteExamById(Long id) {
		examRepository.deleteById(id);
	}

	public boolean uploadExamImage(MultipartFile file, Long examId) {
		Path examDir = Paths.get(uploadDir, Long.toString(examId));

		try {
			Files.createDirectories(examDir);

			String filename = file.getOriginalFilename();
			Path filePath = examDir.resolve(filename);
			file.transferTo(filePath.toFile());

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

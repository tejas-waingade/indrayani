package com.indrayani.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import com.indrayani.DTO.QuestionDTO;
import com.indrayani.entity.QuestionEntity;
import com.indrayani.mapper.QuestionMapper;
import com.indrayani.repository.QuestionRepository;

import jakarta.transaction.Transactional;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuestionMapper questionMapper;

	public QuestionDTO getQuestionById(Long id) {
		return questionRepository.findById(id).map(QuestionMapper::toDTO).orElse(null);
	}

	public List<QuestionDTO> getAllQuestions() {
		return questionRepository.findAll().stream().map(QuestionMapper::toDTO).collect(Collectors.toList());
	}

	public QuestionDTO addQuestion(QuestionDTO questionDTO) {
		QuestionEntity questionEntity = questionMapper.toEntity(questionDTO);
		QuestionEntity savedQuestion = questionRepository.save(questionEntity);
		return questionMapper.toDTO(savedQuestion);
	}

	@Transactional
	public QuestionDTO updateQuestion(Long id, QuestionDTO questionDTO) {
		if (questionRepository.existsById(id)) {
			questionDTO.setId(id);
			QuestionEntity updatedQuestion = questionRepository.save(questionMapper.toEntity(questionDTO));
			return questionMapper.toDTO(updatedQuestion);
		}
		return null;
	}

	public void deleteQuestion(Long id) {
		questionRepository.deleteById(id);
	}
}

package com.indrayani.mapper;

import org.springframework.stereotype.Service;
import com.indrayani.DTO.ViewScoreDTO;
import com.indrayani.entity.ViewScoreEntity;

@Service
public class ViewScoreMapper {

    public ViewScoreDTO toDTO(ViewScoreEntity entity) {
        if (entity == null) return null;

        ViewScoreDTO dto = new ViewScoreDTO();

        dto.setId(entity.getId());
        dto.setUser(entity.getUser());
        dto.setEmail(entity.getEmail());
        dto.setMobile(entity.getMobile());
        dto.setExamCode(entity.getExamCode());
        dto.setExam(entity.getExam());
        dto.setScore(entity.getScore());
        dto.setAttemptedOn(entity.getAttemptedOn());
        dto.setTimeTaken(entity.getTimeTaken());
        dto.setAverageTimeSpendPerQuestion(entity.getAverageTimeSpendPerQuestion());
        dto.setQuestionsAttempted(entity.getQuestionsAttempted());
        dto.setQuestionsUnattempted(entity.getQuestionsUnattempted());
        dto.setIncorrectAnswers(entity.getIncorrectAnswers());

        return dto;
    }

    public ViewScoreEntity toEntity(ViewScoreDTO dto) {
        if (dto == null) return null;

        ViewScoreEntity entity = new ViewScoreEntity();

        entity.setId(dto.getId());
        entity.setUser(dto.getUser());
        entity.setEmail(dto.getEmail());
        entity.setMobile(dto.getMobile());
        entity.setExamCode(dto.getExamCode());
        entity.setExam(dto.getExam());
        entity.setScore(dto.getScore());
        entity.setAttemptedOn(dto.getAttemptedOn());
        entity.setTimeTaken(dto.getTimeTaken());
        entity.setAverageTimeSpendPerQuestion(dto.getAverageTimeSpendPerQuestion());
        entity.setQuestionsAttempted(dto.getQuestionsAttempted());
        entity.setQuestionsUnattempted(dto.getQuestionsUnattempted());
        entity.setIncorrectAnswers(dto.getIncorrectAnswers());

        return entity;
    }
}

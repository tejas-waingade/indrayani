package com.indrayani.mapper;

import org.springframework.stereotype.Service;

import com.indrayani.DTO.QuestionDTO;
import com.indrayani.entity.QuestionEntity;
@Service
public class QuestionMapper {

    public static QuestionDTO toDTO(QuestionEntity entity) {
        if (entity == null) return null;

        QuestionDTO dto = new QuestionDTO();
        dto.setId(entity.getId());
        dto.setQuestionText(entity.getQuestionText());
        dto.setOption1(entity.getOption1());
        dto.setOption2(entity.getOption2());
        dto.setOption3(entity.getOption3());
        dto.setOption4(entity.getOption4());
        dto.setRightOption(entity.getRightOption());
        dto.setDifficultyLevel(entity.getDifficultyLevel());
        dto.setDescription(entity.getDescription());
        dto.setNote(entity.getNote());
        dto.setMapExam(entity.getMapExam());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setIsActive(entity.getIsActive());

        return dto;
    }

    public static QuestionEntity toEntity(QuestionDTO dto) {
        if (dto == null) return null;

        QuestionEntity entity = new QuestionEntity();
        entity.setId(dto.getId());
        entity.setQuestionText(dto.getQuestionText());
        entity.setOption1(dto.getOption1());
        entity.setOption2(dto.getOption2());
        entity.setOption3(dto.getOption3());
        entity.setOption4(dto.getOption4());
        entity.setRightOption(dto.getRightOption());
        entity.setDifficultyLevel(dto.getDifficultyLevel());
        entity.setDescription(dto.getDescription());
        entity.setNote(dto.getNote());
        entity.setMapExam(dto.getMapExam());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setIsActive(dto.getIsActive());

        return entity;
    }
}

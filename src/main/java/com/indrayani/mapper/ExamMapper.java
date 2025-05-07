package com.indrayani.mapper;

import com.indrayani.DTO.ExamDTO;
import com.indrayani.entity.CategoriesEntity;
import com.indrayani.entity.ExamEntity;
import com.indrayani.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamMapper {

    private final CategoriesRepository categoriesRepository;

    @Autowired
    public ExamMapper(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public ExamDTO toDTO(ExamEntity entity) {
        if (entity == null) return null;

        ExamDTO dto = new ExamDTO();
        dto.setExamCode(entity.getExamCode());
        dto.setExamName(entity.getExamName());
        dto.setExamDesc(entity.getExamDesc());
        dto.setExamType(entity.getExamType());
        dto.setPrice(entity.getPrice());
        dto.setExamDuration(entity.getExamDuration());
        dto.setTotalMarks(entity.getTotalMarks());
        dto.setPassingMarks(entity.getPassingMarks());
        dto.setPassingPercent(entity.getPassingPercent());
        dto.setDifficultyLevel(entity.getDifficultyLevel());
        dto.setImg(entity.getImg());
        dto.setRightAns(entity.getRightAns());
        dto.setWrongAns(entity.getWrongAns());
        dto.setSkipAns(entity.getSkipAns());
        dto.setIsActive(entity.getIsActive());
        dto.setTotalQuestions(entity.getTotalQuestions());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());

        if (entity.getCategories() != null) {
            List<Long> categoryIds = entity.getCategories().stream()
                .map(CategoriesEntity::getId)
                .collect(Collectors.toList());
            dto.setCategoryIds(categoryIds); 
        }

        return dto;
    }

    public ExamEntity toEntity(ExamDTO dto) {
        if (dto == null) return null;

        ExamEntity entity = new ExamEntity();
        entity.setExamCode(dto.getExamCode());
        entity.setExamName(dto.getExamName());
        entity.setExamDesc(dto.getExamDesc());
        entity.setExamType(dto.getExamType());
        entity.setPrice(dto.getPrice());
        entity.setExamDuration(dto.getExamDuration());
        entity.setTotalMarks(dto.getTotalMarks());
        entity.setPassingMarks(dto.getPassingMarks());
        entity.setPassingPercent(dto.getPassingPercent());
        entity.setDifficultyLevel(dto.getDifficultyLevel());
        entity.setImg(dto.getImg());
        entity.setRightAns(dto.getRightAns());
        entity.setWrongAns(dto.getWrongAns());
        entity.setSkipAns(dto.getSkipAns());
        entity.setIsActive(dto.getIsActive());
        entity.setTotalQuestions(dto.getTotalQuestions());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setUpdatedAt(dto.getUpdatedAt());

        if (dto.getCategoryIds() != null && !dto.getCategoryIds().isEmpty()) {
            List<CategoriesEntity> categories = dto.getCategoryIds().stream()
                .map(categoryId -> categoriesRepository.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId)))
                .collect(Collectors.toList());
            entity.setCategories(categories);
        }

        return entity;
    }
}
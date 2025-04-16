package com.indrayani.mapper;

import org.springframework.stereotype.Service;

import com.indrayani.DTO.CatExamDTO;
import com.indrayani.entity.CatExamEntity;

@Service
public class CatExamMapper {


    public CatExamDTO catExamEntityToCatExamDTO(CatExamEntity catExamEntity) {
        if (catExamEntity == null) {
            return null;
        }

        CatExamDTO catExamDTO = new CatExamDTO();

        catExamDTO.setId(catExamEntity.getId());
        catExamDTO.setCategoryId(catExamEntity.getCategoryId());
        catExamDTO.setCategoryName(catExamEntity.getCategoryName());
        catExamDTO.setParentCategory(catExamEntity.getParentCategory());
        catExamDTO.setExamCode(catExamEntity.getExamCode());
        catExamDTO.setExamName(catExamEntity.getExamName());
        catExamDTO.setExamDesc(catExamEntity.getExamDesc());
        catExamDTO.setExamType(catExamEntity.getExamType());
        catExamDTO.setPrice(catExamEntity.getPrice());
        catExamDTO.setExamDuration(catExamEntity.getExamDuration());
        catExamDTO.setTotalQuestions(catExamEntity.getTotalQuestions());
        catExamDTO.setTotalMarks(catExamEntity.getTotalMarks());
        catExamDTO.setPassingMarks(catExamEntity.getPassingMarks());
        catExamDTO.setPassingPercent(catExamEntity.getPassingPercent());
        catExamDTO.setDifficultyLevel(catExamEntity.getDifficultyLevel());
        catExamDTO.setImg(catExamEntity.getImg());
        catExamDTO.setRightAns(catExamEntity.getRightAns());
        catExamDTO.setWrongAns(catExamEntity.getWrongAns());
        catExamDTO.setSkipAns(catExamEntity.getSkipAns());
        catExamDTO.setIsActive(catExamEntity.getIsActive());
        catExamDTO.setCreatedAt(catExamEntity.getCreatedAt());
        catExamDTO.setCreatedBy(catExamEntity.getCreatedBy());
        catExamDTO.setUpdatedBy(catExamEntity.getUpdatedBy());
        catExamDTO.setUpdatedAt(catExamEntity.getUpdatedAt());

        return catExamDTO;
    }

    public CatExamEntity catExamDTOToCatExamEntity(CatExamDTO catExamDTO) {
        if (catExamDTO == null) {
            return null;
        }

        CatExamEntity catExamEntity = new CatExamEntity();

        catExamEntity.setId(catExamDTO.getId());
        catExamEntity.setCategoryId(catExamDTO.getCategoryId());
        catExamEntity.setCategoryName(catExamDTO.getCategoryName());
        catExamEntity.setParentCategory(catExamDTO.getParentCategory());
        catExamEntity.setExamCode(catExamDTO.getExamCode());
        catExamEntity.setExamName(catExamDTO.getExamName());
        catExamEntity.setExamDesc(catExamDTO.getExamDesc());
        catExamEntity.setExamType(catExamDTO.getExamType());
        catExamEntity.setPrice(catExamDTO.getPrice());
        catExamEntity.setExamDuration(catExamDTO.getExamDuration());
        catExamEntity.setTotalQuestions(catExamDTO.getTotalQuestions());
        catExamEntity.setTotalMarks(catExamDTO.getTotalMarks());
        catExamEntity.setPassingMarks(catExamDTO.getPassingMarks());
        catExamEntity.setPassingPercent(catExamDTO.getPassingPercent());
        catExamEntity.setDifficultyLevel(catExamDTO.getDifficultyLevel());
        catExamEntity.setImg(catExamDTO.getImg());
        catExamEntity.setRightAns(catExamDTO.getRightAns());
        catExamEntity.setWrongAns(catExamDTO.getWrongAns());
        catExamEntity.setSkipAns(catExamDTO.getSkipAns());
        catExamEntity.setIsActive(catExamDTO.getIsActive());
        catExamEntity.setCreatedAt(catExamDTO.getCreatedAt());
        catExamEntity.setCreatedBy(catExamDTO.getCreatedBy());
        catExamEntity.setUpdatedBy(catExamDTO.getUpdatedBy());
        catExamEntity.setUpdatedAt(catExamDTO.getUpdatedAt());

        return catExamEntity;
    }
}


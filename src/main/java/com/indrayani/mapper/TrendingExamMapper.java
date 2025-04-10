package com.indrayani.mapper;

import org.springframework.stereotype.Service;

import com.indrayani.DTO.TrendingExamDTO;
import com.indrayani.entity.TrendingExamEntity;

@Service
public class TrendingExamMapper {

    public static TrendingExamDTO toDTO(TrendingExamEntity entity) {
    	TrendingExamDTO dto = new TrendingExamDTO();
        dto.setId(entity.getId());
        dto.setExamCode(entity.getExamCode());
        dto.setType(entity.getType());
        dto.setOrderNo(entity.getOrderNo());
        dto.setLaunchDate(entity.getLaunchDate());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        return dto;
    }

    public static TrendingExamEntity toEntity(TrendingExamDTO dto) {
    	TrendingExamEntity entity = new TrendingExamEntity();
        entity.setId(dto.getId());
        entity.setExamCode(dto.getExamCode());
        entity.setType(dto.getType());
        entity.setOrderNo(dto.getOrderNo());
        entity.setLaunchDate(dto.getLaunchDate());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setCreatedBy(dto.getCreatedBy());
        return entity;
    }
}

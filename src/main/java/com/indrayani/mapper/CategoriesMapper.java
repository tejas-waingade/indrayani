package com.indrayani.mapper;

import org.springframework.stereotype.Service;

import com.indrayani.DTO.CategoriesDTO;
import com.indrayani.entity.CategoriesEntity;

@Service
public class CategoriesMapper {

    public static CategoriesDTO toDTO(CategoriesEntity entity) {
        if (entity == null) return null;

        CategoriesDTO dto = new CategoriesDTO();
        dto.setCategoryName(entity.getCategoryName());
        dto.setImage(entity.getImage());
        dto.setDescription(entity.getDescription());
        dto.setOrderNumber(entity.getOrderNumber());
        dto.setParentCategory(entity.getParentCategory());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setCategoryId(entity.getId());

        return dto;
    }

    public static CategoriesEntity toEntity(CategoriesDTO dto) {
        if (dto == null) return null;

        CategoriesEntity entity = new CategoriesEntity();
        entity.setCategoryName(dto.getCategoryName());
        entity.setImage(dto.getImage());
        entity.setDescription(dto.getDescription());
        entity.setOrderNumber(dto.getOrderNumber());
        entity.setParentCategory(dto.getParentCategory());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setId(dto.getCategoryId()); 

        return entity;
    }
}
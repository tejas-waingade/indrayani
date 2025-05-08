package com.indrayani.mapper;

import com.indrayani.DTO.TransactionDTO;
import com.indrayani.entity.TransactionEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionMapper {

    public TransactionDTO toDTO(TransactionEntity entity) {
        if (entity == null) return null;

        TransactionDTO dto = new TransactionDTO();
        dto.setTransactionId(entity.getTransactionId());
        dto.setOrderId(entity.getOrderId());
        dto.setPrice(entity.getPrice());
        dto.setBanktransId(entity.getBanktransId());
        dto.setTransactionDate(entity.getTransactionDate());
        dto.setTransactionStatus(entity.getTransactionStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());

        return dto;
    }

    public TransactionEntity toEntity(TransactionDTO dto) {
        if (dto == null) return null;

        TransactionEntity entity = new TransactionEntity();
        entity.setTransactionId(dto.getTransactionId());
        entity.setOrderId(dto.getOrderId());
        entity.setPrice(dto.getPrice());
        entity.setBanktransId(dto.getBanktransId());
        entity.setTransactionDate(dto.getTransactionDate());
        entity.setTransactionStatus(dto.getTransactionStatus());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setUpdatedBy(dto.getUpdatedBy());

        return entity;
    }

    public void updateEntityFromDto(TransactionDTO dto, TransactionEntity entity) {
        if (dto.getTransactionId() != null) entity.setTransactionId(dto.getTransactionId());
        if (dto.getOrderId() != null) entity.setOrderId(dto.getOrderId());
        if (dto.getPrice() != null) entity.setPrice(dto.getPrice());
        if (dto.getBanktransId() != null) entity.setBanktransId(dto.getBanktransId());
        if (dto.getTransactionDate() != null) entity.setTransactionDate(dto.getTransactionDate());
        if (dto.getTransactionStatus() != null) entity.setTransactionStatus(dto.getTransactionStatus());
        if (dto.getCreatedAt() != null) entity.setCreatedAt(dto.getCreatedAt());
        if (dto.getCreatedBy() != null) entity.setCreatedBy(dto.getCreatedBy());
        if (dto.getUpdatedAt() != null) entity.setUpdatedAt(dto.getUpdatedAt());
        if (dto.getUpdatedBy() != null) entity.setUpdatedBy(dto.getUpdatedBy());
    }

    public TransactionDTO toDto(TransactionEntity entity) {
        return toDTO(entity); 
    }

}

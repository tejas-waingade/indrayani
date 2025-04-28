package com.indrayani.mapper;

import com.indrayani.DTO.TransactionDTO;
import com.indrayani.entity.TransactionEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class TransactionMapper {

    public TransactionEntity toEntity(TransactionDTO transactionDto) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setPrice(transactionDto.getPrice());
        transactionEntity.setTransactionStatus(transactionDto.getTransactionStatus());
        transactionEntity.setExamCode(transactionDto.getExamCode());
        transactionEntity.setCreatedBy(transactionDto.getCreatedBy()); 
        transactionEntity.setTransactionId(UUID.randomUUID().toString());
        transactionEntity.setOrderId(UUID.randomUUID().toString());
        transactionEntity.setTransactionDate(LocalDateTime.now());
        return transactionEntity;
    }

    public TransactionDTO toDto(TransactionEntity transactionEntity) {
        return new TransactionDTO(
                transactionEntity.getTransactionId(),
                transactionEntity.getOrderId(),
                transactionEntity.getPrice(),
                transactionEntity.getTransactionDate(),
                transactionEntity.getTransactionStatus(), 
                transactionEntity.getExamCode(),
                transactionEntity.getCreatedBy() 
        );
    }

    public void updateEntityFromDto(TransactionDTO transactionDto, TransactionEntity transactionEntity) {
        transactionEntity.setPrice(transactionDto.getPrice());
        transactionEntity.setTransactionStatus(transactionDto.getTransactionStatus());
        transactionEntity.setExamCode(transactionDto.getExamCode());
        transactionEntity.setCreatedBy(transactionDto.getCreatedBy()); 
    }
}
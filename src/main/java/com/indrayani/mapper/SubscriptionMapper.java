package com.indrayani.mapper;

import com.indrayani.DTO.SubscriptionRequestDTO;
import com.indrayani.DTO.SubscriptionResponseDTO;
import com.indrayani.entity.SubscriptionEntity;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class SubscriptionMapper {

	public SubscriptionEntity toEntity(SubscriptionRequestDTO requestDTO) {
		if (requestDTO == null) {
			return null;
		}
		SubscriptionEntity entity = new SubscriptionEntity();
		entity.setUserId(generateUserId());
		entity.setExamCode(requestDTO.getExamCode());
		entity.setOrderId(generateOrderId());
		entity.setStartDate(OffsetDateTime.now());
		entity.setEndDate(generateEndDate());
		entity.setStatus(requestDTO.getStatus());
		return entity;
	}

	public SubscriptionResponseDTO toDTO(SubscriptionEntity entity) {
		if (entity == null) {
			return null;
		}
		SubscriptionResponseDTO dto = new SubscriptionResponseDTO();
		dto.setSubId(entity.getSubId());
		dto.setUserId(entity.getUserId());
		dto.setExamCode(entity.getExamCode());
		dto.setOrderId(entity.getOrderId());
		dto.setStartDate(entity.getStartDate());
		dto.setEndDate(entity.getEndDate());
		dto.setStatus(entity.getStatus());
		dto.setCreatedAt(entity.getCreatedAt());
		return dto;
	}

	private String generateOrderId() {
		return UUID.randomUUID().toString();
	}

	private Integer generateUserId() {
		return ThreadLocalRandom.current().nextInt(10, 100);
	}

	private OffsetDateTime generateEndDate() {
		return OffsetDateTime.now().plusYears(1);
	}
}
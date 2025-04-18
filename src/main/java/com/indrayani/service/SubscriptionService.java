package com.indrayani.service;

import com.indrayani.DTO.SubscriptionRequestDTO;
import com.indrayani.DTO.SubscriptionResponseDTO;
import com.indrayani.entity.SubscriptionEntity;
import com.indrayani.mapper.SubscriptionMapper;
import com.indrayani.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

	private final SubscriptionRepository subscriptionRepository;
	private final SubscriptionMapper subscriptionMapper;

	@Autowired
	public SubscriptionService(SubscriptionRepository subscriptionRepository, SubscriptionMapper subscriptionMapper) {
		this.subscriptionRepository = subscriptionRepository;
		this.subscriptionMapper = subscriptionMapper;
	}

	public SubscriptionResponseDTO createSubscription(SubscriptionRequestDTO requestDTO) {
		SubscriptionEntity subscription = subscriptionMapper.toEntity(requestDTO);
		SubscriptionEntity savedSubscription = subscriptionRepository.save(subscription);
		return subscriptionMapper.toDTO(savedSubscription);
	}
}
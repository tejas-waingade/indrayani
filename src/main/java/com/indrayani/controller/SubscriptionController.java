package com.indrayani.controller;

import com.indrayani.DTO.SubscriptionRequestDTO;
import com.indrayani.DTO.SubscriptionResponseDTO;
import com.indrayani.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

	private final SubscriptionService subscriptionService;

	@Autowired
	public SubscriptionController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@PostMapping
	public ResponseEntity<SubscriptionResponseDTO> createSubscription(@RequestBody SubscriptionRequestDTO requestDTO) {
		SubscriptionResponseDTO createdSubscription = subscriptionService.createSubscription(requestDTO);
		return new ResponseEntity<>(createdSubscription, HttpStatus.CREATED);
	}
}
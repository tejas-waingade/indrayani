package com.indrayani.service;

import com.indrayani.DTO.OrderDTO;
import com.indrayani.entity.ExamEntity;
import com.indrayani.entity.OrderEntity;
import com.indrayani.entity.OrderExamMap;
import com.indrayani.mapper.OrderMapper;
import com.indrayani.repository.ExamRepository;
import com.indrayani.repository.OrderExamMapRepository;
import com.indrayani.repository.OrderRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderExamMapRepository orderExamMapRepository;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private RazorpayClient razorpayClient;

	@Autowired
	private ExamRepository examRepository;

	@Transactional
	public OrderEntity createOrder(OrderDTO orderDTO) {
		OrderEntity orderEntity = OrderMapper.toEntity(orderDTO);
		orderEntity.setOrderId(UUID.randomUUID().toString());

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		orderEntity.setUpdatedBy(authentication != null ? authentication.getName() : "System");

		orderEntity.setCreatedAt(LocalDateTime.now());
		orderEntity.setUpdatedAt(LocalDateTime.now());

		JSONObject options = new JSONObject();
		options.put("amount", orderDTO.getPayableAmount().multiply(BigDecimal.valueOf(100)));
		options.put("currency", "INR");
		options.put("receipt", orderEntity.getOrderId());

		try {
			Order razorpayOrder = razorpayClient.orders.create(options);
			orderEntity.setRazorpayOrderId(razorpayOrder.get("id"));
		} catch (RazorpayException e) {
			throw new RuntimeException("Razorpay order creation failed", e);
		}

		orderEntity = orderRepository.save(orderEntity);
		final OrderEntity savedOrder = orderEntity;
		
		List<OrderExamMap> orderExamMaps = orderDTO.getExamIds().stream().map(id -> Long.parseLong(id)).map(examId -> {
			ExamEntity exam = examRepository.findById(examId)
					.orElseThrow(() -> new RuntimeException("Exam not found with id: " + examId));

			OrderExamMap map = new OrderExamMap();
			map.setOrder(savedOrder);
			map.setExam(exam);
			map.setExamCode(exam.getExamCode());
			map.setCreatedAt(LocalDateTime.now());
			return map;
		}).collect(Collectors.toList());

		orderExamMapRepository.saveAll(orderExamMaps);
		orderEntity.setOrderExamMaps(orderExamMaps);

		return orderEntity;
	}

	@Transactional
	public OrderEntity updateOrder(Long id, OrderDTO dto) {
		OrderEntity existing = orderRepository.findById(id).orElseThrow();

		existing.setUserId(dto.getUserId());
		existing.setTotalAmount(dto.getTotalAmount());
		existing.setPayableAmount(dto.getPayableAmount());
		existing.setDiscount(dto.getDiscount());
		existing.setUpdatedAt(LocalDateTime.now());

		return orderRepository.save(existing);
	}

}

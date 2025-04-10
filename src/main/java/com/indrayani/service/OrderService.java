package com.indrayani.service;
/*
import com.indrayani.DTO.OrderDTO;
import com.indrayani.entity.OrderEntity;
import com.indrayani.entity.OrderExamMap;
import com.indrayani.mapper.OrderMapper;
import com.indrayani.repository.OrderExamMapRepository;
import com.indrayani.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
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

	@Transactional
	public OrderEntity createOrder(OrderDTO orderDTO) {
		OrderEntity orderEntity = OrderMapper.toEntity(orderDTO);

		orderEntity.setOrderId(UUID.randomUUID().toString());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			String username = authentication.getName();
			orderEntity.setUpdatedBy(username);
		} else {
			orderEntity.setUpdatedBy("System");
		}

		orderEntity.setCreatedAt(LocalDateTime.now());
		orderEntity.setUpdatedAt(LocalDateTime.now());
		orderEntity = orderRepository.save(orderEntity);
		
		List<OrderExamMap> orderExamMaps = orderDTO.getExamIds().stream().map(examId -> {
			OrderExamMap map = new OrderExamMap();
			map.setOrder(orderEntity);
			map.setExamCode(examId);
			map.setCreatedAt(LocalDateTime.now());
			return map;
		}).collect(Collectors.toList());

		orderExamMapRepository.saveAll(orderExamMaps);
		orderEntity.setOrderExamMaps(orderExamMaps);

		return orderEntity;
	}
		
		
}
	*/
	
	
	
	
	
	
	
	
	
	
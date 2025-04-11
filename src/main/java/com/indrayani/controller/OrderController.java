package com.indrayani.controller;

import com.indrayani.DTO.OrderDTO;
import com.indrayani.entity.OrderEntity;
import com.indrayani.service.OrderService;
import com.indrayani.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderRepository orderRepository;

	@PostMapping
	public OrderEntity createOrder(@RequestBody OrderDTO orderDTO) {
		return orderService.createOrder(orderDTO);
	}

	@GetMapping
	public List<OrderEntity> getAllOrders() {
		return orderRepository.findAll();
	}

	@GetMapping("/{id}")
	public OrderEntity getOrderById(@PathVariable Long id) {
		return orderRepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public OrderEntity updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
		return orderService.updateOrder(id, orderDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		orderRepository.deleteById(id);
	}
}

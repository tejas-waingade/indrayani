package com.indrayani.controller;

import com.indrayani.DTO.OrderDTO;
import com.indrayani.entity.OrderEntity;
import com.indrayani.service.OrderService;
import com.indrayani.service.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderService orderService;

    @Value("${razorpay.key.secret}")
    private String razorpaySecret;

    @PostMapping("/createOrder")
    public ResponseEntity<Map<String, String>> createRazorpayOrder(@RequestParam int amount, @RequestParam String currency)
            throws RazorpayException {
        Map<String, String> orderResponse = paymentService.createOrder(amount, currency);
        return ResponseEntity.ok(orderResponse);
    }

    @PostMapping("/createOrderWithExams")
    public ResponseEntity<OrderEntity> createOrderWithExams(@RequestBody OrderDTO orderDTO) {
        OrderEntity orderEntity = orderService.createOrder(orderDTO);
        return new ResponseEntity<>(orderEntity, HttpStatus.CREATED);
    }
}

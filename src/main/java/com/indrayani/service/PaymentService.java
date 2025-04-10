package com.indrayani.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private RazorpayClient razorpayClient;

    @Value("${razorpay.key.secret}")
    private String razorpaySecret; 

    public Map<String, String> createOrder(int amount, String currency) throws RazorpayException {
        try {
            JSONObject options = new JSONObject();
            options.put("amount", amount * 100);
            options.put("currency", currency);
            options.put("receipt", "order_rcptid_11");

            Order order = razorpayClient.orders.create(options);
            Map<String, String> orderResponse = new HashMap<>();
            orderResponse.put("orderId", order.get("id"));
            orderResponse.put("currency", order.get("currency"));
            orderResponse.put("amount", order.get("amount").toString());
            logger.info("Razorpay order created: {}", orderResponse);
            return orderResponse;
        } catch (RazorpayException e) {
            logger.error("Error creating Razorpay order: {}", e.getMessage());
            throw e;
        }
    }
}
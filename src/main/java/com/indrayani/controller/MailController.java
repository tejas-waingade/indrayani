package com.indrayani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indrayani.service.SendOtp;

@RestController
public class MailController {

	@Autowired
	private SendOtp sendOtp;

	@PostMapping("/emailOtp/{email}")
	public ResponseEntity<String> sendOtpToMail(@PathVariable("email") String email) {
		try {
			sendOtp.sendOtp(email);
			return ResponseEntity.ok("OTP sent successfully to: " + email);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Invalid email address: " + email);
		}
	}
}

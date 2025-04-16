package com.indrayani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.indrayani.DTO.SignUpRequest;
import com.indrayani.DTO.SignUpResponse;
import com.indrayani.service.UserSignupService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/signUp")
public class UserSignUpController {

	@Autowired
	private UserSignupService userSignupService;

	@PostMapping
	public ResponseEntity<SignUpResponse> signup(@Valid @RequestBody SignUpRequest signupRequest,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest()
					.body(new SignUpResponse(null, bindingResult.getFieldErrors().get(0).getDefaultMessage()));
		}
		return userSignupService.registerUser(signupRequest);
	}
}

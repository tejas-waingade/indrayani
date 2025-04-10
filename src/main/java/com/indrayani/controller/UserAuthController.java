package com.indrayani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.indrayani.DTO.OtpResponse;
import com.indrayani.DTO.VerifyOtpResponse;
import com.indrayani.entity.AuthRequest;
import com.indrayani.entity.UserEntity;
import com.indrayani.repository.UserRepository;
import com.indrayani.service.JwtService;
import com.indrayani.service.OtpService;
import com.indrayani.service.UserInfoService;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private OtpService otpService;

	@PostMapping("/login")
	public ResponseEntity<OtpResponse> login(@RequestBody AuthRequest authRequest) {
		String otp = userInfoService.authenticateAndGenerateOtp(authRequest);
		OtpResponse response = new OtpResponse("Otp sent to mobile", otp);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/verifyOtp")
	public ResponseEntity<VerifyOtpResponse> verifyOtp(@RequestBody AuthRequest authRequest) {
		if (otpService.validateOtp(authRequest.getMobile(), authRequest.getOtp())) {
			String token = jwtService.generateToken(authRequest.getMobile());
			UserEntity user = userInfoService.findUserByMobile(authRequest.getMobile());
			if (user == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new VerifyOtpResponse("User not found", null));
			}
			VerifyOtpResponse response = new VerifyOtpResponse("Sign in Successful",
					new VerifyOtpResponse.Data(token, user.getId()));
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new VerifyOtpResponse("Invalid OTP", null));
		}
	}

}
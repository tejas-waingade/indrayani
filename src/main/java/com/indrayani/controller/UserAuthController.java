package com.indrayani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.indrayani.DTO.OtpResponse;
import com.indrayani.DTO.VerifyOtpResponse;
import com.indrayani.entity.AuthRequest;
import com.indrayani.entity.UserEntity;
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
		if (authRequest.getOtp() != null && !authRequest.getOtp().isEmpty()) {
			// Mobile/OTP verification
			return handleMobileOtpVerification(authRequest);
		} else if (authRequest.getGoogleId() != null) {

			return handleGoogleIdVerification(authRequest);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new VerifyOtpResponse("Invalid request", null));
		}
	}

	private ResponseEntity<VerifyOtpResponse> handleMobileOtpVerification(AuthRequest authRequest) {
		if (otpService.validateOtp(authRequest.getMobile(), authRequest.getOtp())) {
			String token = jwtService.generateToken(authRequest.getMobile());
			UserEntity user = userInfoService.findUserByMobile(authRequest.getMobile());
			if (user == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new VerifyOtpResponse("User not found", null));
			}
			VerifyOtpResponse response = new VerifyOtpResponse("Sign in Successful",
					new VerifyOtpResponse.Data(token, user.getId(), user.getGoogleId(), user.getEmail()));
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new VerifyOtpResponse("Invalid OTP", null));
		}
	}

	private ResponseEntity<VerifyOtpResponse> handleGoogleIdVerification(AuthRequest authRequest) {
		if (otpService.validateGoogleId(authRequest.getGoogleId())) {
			UserEntity user = userInfoService.findUserByGoogleId(authRequest.getGoogleId());
			if (user == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new VerifyOtpResponse("User not found", null));
			}
			String token = jwtService.generateToken(user.getMobile());
			VerifyOtpResponse response = new VerifyOtpResponse("Sign in Successful",
					new VerifyOtpResponse.Data(token, user.getId(), user.getGoogleId(), user.getEmail()));
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new VerifyOtpResponse("Invalid Google ID", null));
		}
	}
}
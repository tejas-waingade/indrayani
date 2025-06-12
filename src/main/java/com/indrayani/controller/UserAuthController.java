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
		String mobile = authRequest.getMobile();

		if (mobile == null || mobile.trim().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new OtpResponse("Mobile number is required"));
		}

		try {
			String otpResult = otpService.regenerateAndSendOtpToMobileUser(mobile);

			if (otpResult != null && otpResult.startsWith("OTP sent")) {
				UserEntity user = userInfoService.findUserByMobile(mobile);

				if (user == null) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body(new OtpResponse("User not found after OTP generation"));
				}

				String token = jwtService.generateToken(user.getMobile());
				String responseMessage = String.format("OTP sent successfully. User ID: %d", user.getId());

				return ResponseEntity.ok(new OtpResponse(responseMessage, token));
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new OtpResponse(otpResult));
			}

		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new OtpResponse(e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new OtpResponse("An unexpected error occurred during login: " + e.getMessage()));
		}
	}

	@PostMapping("/verifyOtp")
	public ResponseEntity<VerifyOtpResponse> verifyOtp(@RequestBody AuthRequest authRequest) {
		if (authRequest == null) {
			return ResponseEntity.badRequest().body(new VerifyOtpResponse("Request body is missing", null));
		}

		if (authRequest.getOtp() != null && !authRequest.getOtp().isEmpty() && authRequest.getMobile() != null
				&& !authRequest.getMobile().isEmpty()) {
			return handleMobileOtpVerification(authRequest);
		} else if (authRequest.getGoogleId() != null && !authRequest.getGoogleId().isEmpty()) {
			return handleGoogleIdVerification(authRequest);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new VerifyOtpResponse("Invalid request: Mobile number and OTP, or Google ID is required", null));
		}
	}

	private ResponseEntity<VerifyOtpResponse> handleMobileOtpVerification(AuthRequest authRequest) {
		String mobile = authRequest.getMobile();

		try {
			boolean isOtpValid = otpService.validateUserOtp(mobile, authRequest.getOtp());

			if (isOtpValid) {
				UserEntity user = userInfoService.findUserByMobile(mobile);

				if (user == null) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body(new VerifyOtpResponse("User not found after OTP verification", null));
				}

				user.setIsMobileVerified(true);

				String token = jwtService.generateToken(user.getMobile());
				VerifyOtpResponse.Data data = new VerifyOtpResponse.Data(token, user.getId(), user.getGoogleId(),
						user.getEmail());

				return ResponseEntity.ok(new VerifyOtpResponse("Sign in successful", data));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new VerifyOtpResponse("Invalid OTP", null));
			}
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new VerifyOtpResponse(e.getMessage(), null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new VerifyOtpResponse(
					"An unexpected error occurred during OTP verification: " + e.getMessage(), null));
		}
	}

	private ResponseEntity<VerifyOtpResponse> handleGoogleIdVerification(AuthRequest authRequest) {
		UserEntity user = userInfoService.findUserByGoogleId(authRequest.getGoogleId());

		if (user != null) {
			String token = jwtService.generateToken(user.getMobile());
			VerifyOtpResponse.Data data = new VerifyOtpResponse.Data(token, user.getId(), user.getGoogleId(),
					user.getEmail());

			return ResponseEntity.ok(new VerifyOtpResponse("Sign in successful with Google ID", data));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new VerifyOtpResponse("Invalid Google ID or User not found with this Google ID", null));
		}
	}
}
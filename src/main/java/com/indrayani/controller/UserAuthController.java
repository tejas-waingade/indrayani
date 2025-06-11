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
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new OtpResponse("Mobile number is required", null));
		}

		try {
			String formattedMobile = formatMobile(mobile);

			String result = otpService.regenerateAndSendOtpToMobileUser(formattedMobile);

			if (result.startsWith("OTP sent")) {
				UserEntity user = userInfoService.findUserByMobile(formattedMobile);

				if (user == null) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new OtpResponse("User not found", null));
				}

				String token = jwtService.generateToken(formattedMobile);
				String responseMessage = String.format("OTP sent successfully. UserId: %d", user.getId());

				return ResponseEntity.ok(new OtpResponse(responseMessage, token));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new OtpResponse(result, null));
			}

		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new OtpResponse(e.getMessage(), null));
		}
	}

	@PostMapping("/verifyOtp")
	public ResponseEntity<VerifyOtpResponse> verifyOtp(@RequestBody AuthRequest authRequest) {
		if (authRequest == null) {
			return ResponseEntity.badRequest().body(new VerifyOtpResponse("Request body is missing", null));
		}

		if (authRequest.getOtp() != null && !authRequest.getOtp().isEmpty()) {
			return handleMobileOtpVerification(authRequest);
		} else if (authRequest.getGoogleId() != null && !authRequest.getGoogleId().isEmpty()) {
			return handleGoogleIdVerification(authRequest);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new VerifyOtpResponse("Invalid request: OTP or Google ID is required", null));
		}
	}

	private ResponseEntity<VerifyOtpResponse> handleMobileOtpVerification(AuthRequest authRequest) {
		String formattedMobile;
		try {
			formattedMobile = formatMobile(authRequest.getMobile());
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new VerifyOtpResponse(e.getMessage(), null));
		}

		boolean isOtpValid = otpService.validateUserOtp(formattedMobile, authRequest.getOtp());

		if (isOtpValid) {
			UserEntity user = userInfoService.findUserByMobile(formattedMobile);

			if (user == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new VerifyOtpResponse("User not found", null));
			}

			String token = jwtService.generateToken(formattedMobile);
			VerifyOtpResponse.Data data = new VerifyOtpResponse.Data(token, user.getId(), user.getGoogleId(),
					user.getEmail());

			return ResponseEntity.ok(new VerifyOtpResponse("Sign in successful", data));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new VerifyOtpResponse("Invalid OTP", null));
		}
	}

	private ResponseEntity<VerifyOtpResponse> handleGoogleIdVerification(AuthRequest authRequest) {
		boolean isValid = otpService.validateGoogleId(authRequest.getGoogleId());

		if (isValid) {
			UserEntity user = userInfoService.findUserByGoogleId(authRequest.getGoogleId());

			if (user == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new VerifyOtpResponse("User not found", null));
			}

			String token = jwtService.generateToken(user.getMobile());
			VerifyOtpResponse.Data data = new VerifyOtpResponse.Data(token, user.getId(), user.getGoogleId(),
					user.getEmail());

			return ResponseEntity.ok(new VerifyOtpResponse("Sign in successful", data));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new VerifyOtpResponse("Invalid Google ID", null));
		}
	}

	private String formatMobile(String mobile) {
		if (mobile == null)
			throw new IllegalArgumentException("Mobile number is null");

		String cleaned = mobile.replaceAll("[^\\d]", "");

		if (cleaned.length() == 12 && cleaned.startsWith("91")) {
			cleaned = cleaned.substring(2);
		}

		if (cleaned.length() == 10) {
			return "+91" + cleaned;
		} else {
			throw new IllegalArgumentException("Invalid mobile number. Enter 10 digits or +91XXXXXXXXXX");
		}
	}
}

package com.indrayani.service;

import com.indrayani.DTO.SignUpRequest;
import com.indrayani.DTO.SignUpResponse;
import com.indrayani.entity.UserSignUpEntity;
import com.indrayani.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSignupService {

	@Autowired
	private SignUpRepository userRepository;

	public ResponseEntity<SignUpResponse> registerUser(SignUpRequest signupRequest) {
		try {
			Optional<UserSignUpEntity> existingMobileUser = userRepository.findByMobile(signupRequest.getMobile());

			if (existingMobileUser.isPresent()) {
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(new SignUpResponse(null, "Mobile number already exists"));
			}

			Optional<UserSignUpEntity> existingEmailUser = userRepository.findByEmail(signupRequest.getEmail());

			if (existingEmailUser.isPresent()) {
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(new SignUpResponse(null, "Email already exists"));
			}
 
			UserSignUpEntity user = new UserSignUpEntity(signupRequest.getFirstName(), signupRequest.getLastName(),
					signupRequest.getEmail(), signupRequest.getMobile(), signupRequest.getEducation(),
					signupRequest.getCity(), signupRequest.getDistrict(), signupRequest.getState(),
					signupRequest.getPinCode(), signupRequest.getFcmToken());

			UserSignUpEntity savedUser = userRepository.save(user);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new SignUpResponse(savedUser.getId(), "User registered successfully"));

		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new SignUpResponse(null, "Database constraint violation: " + e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new SignUpResponse(null, "An error occurred: " + e.getMessage()));
		}
	}
}
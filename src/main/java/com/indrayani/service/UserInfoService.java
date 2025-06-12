package com.indrayani.service;

import com.indrayani.entity.AuthRequest;
import com.indrayani.entity.UserEntity;
import com.indrayani.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OtpService otpService;

	@Override
	public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
		String formattedMobile = formatMobileForLookup(mobile);
		Optional<UserEntity> userDetail = userRepository.findByMobile(formattedMobile);
		return userDetail.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with mobile: " + mobile));
	}

	public String authenticateAndGenerateOtp(AuthRequest authRequest) {
		String mobile = authRequest.getMobile();
		if (mobile == null || mobile.trim().isEmpty()) {
			logger.warn("Mobile number is null or empty for authentication request.");
			throw new IllegalArgumentException("Mobile number is required for authentication.");
		}

		String formattedMobile = formatMobileForLookup(mobile);

		Optional<UserEntity> userOptional = userRepository.findByMobile(formattedMobile);

		if (userOptional.isEmpty()) {
			logger.warn("User not found with mobile: {}", formattedMobile);
			return null;
		}

		UserEntity user = userOptional.get();
		String otp = otpService.generateOtp(formattedMobile);

		otpService.sendOtp(formattedMobile, otp);
		logger.info("OTP sent to mobile: {}", formattedMobile);
		return otp;
	}

	public UserEntity findUserByMobile(String mobile) {
		if (mobile == null || mobile.trim().isEmpty()) {
			return null;
		}
		String formattedMobile = formatMobileForLookup(mobile);
		return userRepository.findByMobile(formattedMobile).orElse(null);
	}

	public UserEntity findUserByGoogleId(String googleId) {
		return userRepository.findByGoogleId(googleId).orElse(null);
	}

	private String formatMobileForLookup(String mobile) {
		if (mobile == null) {
			throw new IllegalArgumentException("Mobile number cannot be null.");
		}
		String cleaned = mobile.replaceAll("\\D+", "");

		if (cleaned.length() == 12 && cleaned.startsWith("91")) {
			return "+" + cleaned;
		} else if (cleaned.length() == 10) {
			return "+91" + cleaned;
		} else {
			throw new IllegalArgumentException(
					"Invalid mobile number format for lookup: must be 10 digits or start with +91.");
		}
	}
}
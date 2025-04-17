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
		Optional<UserEntity> userDetail = userRepository.findByMobile(mobile);
		return userDetail.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + mobile));
	}

	public String authenticateAndGenerateOtp(AuthRequest authRequest) {
		Optional<UserEntity> userOptional = userRepository.findByMobile(authRequest.getMobile());

		if (userOptional.isEmpty()) {
			logger.warn("User not found with mobile: {}", authRequest.getMobile());
			return null;
		}

		UserEntity user = userOptional.get();
		String otp = otpService.generateOtp(authRequest.getMobile());

		otpService.sendOtp(authRequest.getMobile(), otp);
		logger.info("OTP sent to mobile: {}", authRequest.getMobile());
		return otp;
	}

	public UserEntity findUserByMobile(String mobile) {
		return userRepository.findByMobile(mobile).orElse(null);
	}

	public UserEntity findUserByGoogleId(String googleId) {
		return null;
	}
}

package com.indrayani.service;

import com.indrayani.entity.UserEntity;
import com.indrayani.repository.UserRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OtpService {

	@Value("${twilio.phone.number}")
	private String twilioPhoneNumber;

	@Value("${twilio.account.sid}")
	private String accountSid;

	@Value("${twilio.auth.token}")
	private String authToken;

	@Autowired
	private UserRepository userRepository;

	private final SecureRandom random = new SecureRandom();
	private final int OTP_LENGTH = 4;

	@PostConstruct
	public void init() {
		Twilio.init(accountSid, authToken);
	}

	private String generateOtpCode() {
		int min = (int) Math.pow(10, OTP_LENGTH - 1);
		int max = (int) Math.pow(10, OTP_LENGTH) - 1;
		return String.valueOf(random.nextInt(max - min + 1) + min);
	}

	public String regenerateAndSendOtpToMobileUser(String mobile) {
		Optional<UserEntity> optionalUser = userRepository.findByMobile(mobile);

		if (optionalUser.isPresent()) {
			UserEntity user = optionalUser.get();

			String newOtp = generateOtpCode();
			user.setMobileOtp(newOtp);
			user.setMobileOtpGeneratedAt(LocalDateTime.now());
			userRepository.save(user);

			String messageBody = "Your OTP is: " + newOtp;
			Message message = Message
					.creator(new PhoneNumber(user.getMobile()), new PhoneNumber(twilioPhoneNumber), messageBody)
					.create();

			return "OTP sent to existing user. SID: " + message.getSid();
		} else {
			return "User not found with mobile: " + mobile;
		}
	}

	public boolean validateUserOtp(String mobile, String otp) {
		Optional<UserEntity> optionalUser = userRepository.findByMobile(mobile);
		if (optionalUser.isPresent()) {
			UserEntity user = optionalUser.get();
			return otp.equals(user.getMobileOtp());
		}
		return false;
	}

	public boolean validateGoogleId(String googleId) {
		if (googleId == null || googleId.isEmpty()) {
			return true;
		}
		return userRepository.findByGoogleId(googleId).isPresent();
	}

	public String generateOtp(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	public void sendOtp(String mobile, String otp) {
		// TODO Auto-generated method stub

	}
}

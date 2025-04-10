package com.indrayani.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import ch.qos.logback.classic.Logger;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
public class OtpService {

	@Value("${twilio.phone.number}")
	private String twilioPhoneNumber;

	private final Map<String, OtpData> otpMap = new HashMap<>();
	private final SecureRandom random = new SecureRandom();
	private final int OTP_LENGTH = 4;

	public String generateOtp(String mobile) {
		String otp = String.valueOf(generateRandomNumber(OTP_LENGTH));
		otpMap.put(mobile, new OtpData(otp));
		return otp;
	}

	public boolean validateOtp(String mobile, String otp) {
		OtpData otpData = otpMap.get(mobile);
		if (otpData == null) {
			return false;
		}
		boolean isValid = otpData.otp.equals(otp);
		if (isValid) {
			otpMap.remove(mobile);
		}
		return isValid;
	}

	private int generateRandomNumber(int length) {
		int min = (int) Math.pow(10, length - 1);
		int max = (int) Math.pow(10, length) - 1;
		return random.nextInt(max - min + 1) + min;
	}

	private static class OtpData {
		String otp;

		public OtpData(String otp) {
			this.otp = otp;
		}
	}

	public String sendOtp(String userPhoneNumber, String otp) {
		String messageBody = "Your OTP is: " + otp;

		Message message = Message
				.creator(new PhoneNumber(userPhoneNumber), new PhoneNumber(twilioPhoneNumber), messageBody).create();

		return "OTP Sent Successfully! SID: " + message.getSid();
	}
}

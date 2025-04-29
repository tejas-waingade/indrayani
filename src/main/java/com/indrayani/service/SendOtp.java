package com.indrayani.service;

import java.security.SecureRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendOtp {
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendOtp(String email) {
		String otp = generateOtp();

		try {
			sendOtpToMail(email, otp);

		} catch (MessagingException e) {
			throw new IllegalArgumentException("Invalid email address: " + email);
		}
	}

	private String generateOtp() {

		SecureRandom random = new SecureRandom();
		int otp = 1000 + random.nextInt(9000);
		return String.valueOf(otp);
	}

	private void sendOtpToMail(String email, String otp) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(email);
		mimeMessageHelper.setSubject("Your Otp is :");
		mimeMessageHelper.setText(otp);
		javaMailSender.send(mimeMessage);

	}

}

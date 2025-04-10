package com.indrayani.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;

@Component
@Configuration
public class TwilioConfig {

	@Value("${twilio.account.sid}")
	private String accountSid;

	@Value("${twilio.auth.token}")
	private String authToken;

	@PostConstruct
	public void init() {
		Twilio.init(accountSid, authToken);
	}
}

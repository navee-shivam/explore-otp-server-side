package com.example.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class DoSendEmailServiceImpl implements DoSendEmailService {

	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail() {
		SimpleMailMessage smp = new SimpleMailMessage();
		smp.setTo("naveenkumar58957@gmail.com");
		smp.setSubject("Test Mail");
		smp.setText("Welcome");
		javaMailSender.send(smp);
		System.out.println("Success in sending");
	}

}

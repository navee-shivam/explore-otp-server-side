package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.DoSendEmailService;

@RestController
@RequestMapping("/mail")
public class SendEmailController {

	@Autowired
	private DoSendEmailService doSendEmailService;

	@RequestMapping("/")
	public String getHome() {
		sendEmail();
		return "Success";
	}

	@RequestMapping("/sendEmail")
	public void sendEmail() {
//		doSendEmailService.sendEmail();
	}

}

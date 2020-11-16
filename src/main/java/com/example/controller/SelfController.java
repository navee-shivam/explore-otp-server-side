package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Contact;
import com.example.service.OTPGenerateService;


@RestController
@CrossOrigin
public class SelfController {

	@Autowired
	public OTPGenerateService otpGenerateService;

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

	@PostMapping("/doGenerateOTP")
	public void doGenerateOTP(@RequestBody String email) {
		otpGenerateService.doRandomNumberGeneration(email);
	}
	
	@GetMapping("/doCheck/{email}")
	public List<Contact> doCheck(@PathVariable("email") String email) {
		return otpGenerateService.getEmailData(email);
	}
	
	@RequestMapping("/doCheckOTP")
	public String doValidate(@RequestParam("email") String email, @RequestParam("code") int code) {
		System.out.println("doOTP");
		return otpGenerateService.doValidateOTP(email,code);
	}

}

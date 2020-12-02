package com.example.service;

import java.util.List;

import com.example.model.Contact;

public interface OTPGenerateService {

	public int doRandomNumberGeneration(String mailId);

	public List<Contact> getEmailData(String email);

	public String doValidateOTP(String email, int code);
	
	public int doResendOTP(String email);

	public String doDeleteData(String email);

}

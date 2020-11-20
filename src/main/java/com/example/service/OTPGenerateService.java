package com.example.service;

import java.util.List;

import com.example.model.Contact;

public interface OTPGenerateService {

	public void doRandomNumberGeneration(String mailId);

	public List<Contact> getEmailData(String email);

	public String doValidateOTP(String email, int code);
	
	public int doResendOTP(String email);

	public void doDeleteData(String email);

}

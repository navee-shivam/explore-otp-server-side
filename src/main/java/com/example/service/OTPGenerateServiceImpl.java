package com.example.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.SaveRandomWithEmailDao;
import com.example.model.Contact;

@Service
public class OTPGenerateServiceImpl implements OTPGenerateService {

	@Autowired
	private SaveRandomWithEmailDao saveRandomWithEmailDao;

	@Override
	public void doRandomNumberGeneration(String mailId) {
		Contact contactModel = MakeEntity(mailId);
		saveRandomWithEmailDao.save(contactModel);
		System.out.println("Inserted : " + contactModel.toString());
	}

	@Override
	public List<Contact> getEmailData(String mailId) {
		return saveRandomWithEmailDao.findByEmail(mailId);
	}

	private Contact MakeEntity(String mailId) {
		List<Contact> fetchExist = getEmailData(mailId);
		Contact contactModel = new Contact();
		if (fetchExist.isEmpty()) {
			contactModel.setEmail(mailId);
			contactModel.setOtp(new Random().nextInt(9999));
		} else {
			contactModel.setId(fetchExist.get(0).getId());
			contactModel.setEmail(mailId);
			contactModel.setOtp(new Random().nextInt(9999));
		}
		return contactModel;
	}

	@Override
	public String doValidateOTP(String email, int code) {
		List<Contact> contact = getEmailData(email);
		if (isPresentCode(contact, code)) {
			System.out.println("pass");
			return "success";
		}
		System.out.println("fail");
		return "failure";
	}

	@Override
	public int doResendOTP(String email) {
		List<Contact> contact = getEmailData(email);
		return contact.get(0).getOtp();
	}

	private boolean isPresentCode(List<Contact> contact, int code) {
		if (!contact.isEmpty())
			if (contact.get(0).getOtp() == code)
				return true;
		return false;
	}

	@Override
	public void doDeleteData(String email) {
		List<Contact> contact = getEmailData(email);
		saveRandomWithEmailDao.deleteById(contact.get(0).getId());
	}

}

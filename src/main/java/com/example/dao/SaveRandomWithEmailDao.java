package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Contact;

@Repository
public interface SaveRandomWithEmailDao extends JpaRepository<Contact, Integer> {

	List<Contact> findByEmail(String email);
}

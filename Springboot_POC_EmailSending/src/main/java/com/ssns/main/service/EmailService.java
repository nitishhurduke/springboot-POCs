package com.ssns.main.service;

import com.ssns.main.models.EmailSender;

public interface EmailService {

	String sendMail(EmailSender es);

	String sendEmailWithAttach(EmailSender es);

	
}

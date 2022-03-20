package com.ssns.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssns.main.models.EmailSender;
import com.ssns.main.service.EmailService;

@RestController
@CrossOrigin("*")
public class EmailController {

	@Autowired
	EmailService service;

	@Value("${spring.mail.username}")
	private String fromMail;

	@PostMapping("/send")
	public String sendEmail(@RequestBody EmailSender es) {
		String response = "Something went wrong...Email NOT sent!!";

		es.setFromEmail(fromMail);

		response = service.sendMail(es);

		return response;
	}

	@PostMapping("/attach")
	public String sendEmailWithAttach(@RequestBody EmailSender es) {
		String response = "Something went wrong...Email NOT sent!!";

		es.setFromEmail(fromMail);

		response = service.sendEmailWithAttach(es);

		return response;

	}
}

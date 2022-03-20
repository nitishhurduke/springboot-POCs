package com.ssns.main.serviceImpl;

import java.nio.file.attribute.AclEntry;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ssns.main.models.EmailSender;
import com.ssns.main.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public String sendMail(EmailSender es) {

		String response= "Something went wrong...Email NOT sent!!";		
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
			
			try {
			mailMessage.setFrom(es.getFromEmail());
			mailMessage.setTo(es.getToEmail());
			mailMessage.setSubject(es.getSubject());
			mailMessage.setText(es.getTxtmsg());
			}catch(Exception e) {
				e.printStackTrace();
				response = "Problem while setting mail data...Email NOT sent!!";
			}
			try {
				
				javaMailSender.send(mailMessage);			
				response = "Mail Sent Successfully...";
			}catch(Exception e) {
				e.printStackTrace();
				response= "Java Mail Sender Exception...Email NOT sent!!";		
			}
			
		return response;
	}

	@Override
	public String sendEmailWithAttach(EmailSender es) {
		
		String response= "Something went wrong...Email NOT sent!!";		

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		try {
			
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			
			helper.setTo(es.getToEmail());
			helper.setFrom(es.getFromEmail());
			helper.setSubject(es.getSubject());
			helper.setText(es.getTxtmsg());
			
			FileSystemResource file = new FileSystemResource("/home/prong/Nits-PC/Workspace/SpringBoot Workspace/Springboot_EmailSendingPOC/src/main/resources/static/attachments/shopping.jpeg");
			helper.addAttachment(file.getFilename(), file);
			
			javaMailSender.send(mimeMessage);
			
			response = "Mail Sent Successfully...";
			
		}catch(Exception e) {
			e.printStackTrace();
			response= "Java Mail Sender Exception...Email NOT sent!!";		
		}
		
		return response;
	}

}
;
package com.usingjwttokens.example.tokenbased.service;



import com.usingjwttokens.example.tokenbased.models.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service
public class MailServiceImpl implements MailService
{
	@Autowired
	private JavaMailSender javaMailSender;

	
//	@Override
	public void sendEmail(Mail mail)
	{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom()));
			mimeMessageHelper.setTo(mail.getMailTo());
			mimeMessageHelper.setText(mail.getMailContent());
			javaMailSender.send(mimeMessageHelper.getMimeMessage());

			// http://localhost:8085/forgotPwd/1234567899
		} 
		catch (javax.mail.MessagingException e) {
			e.printStackTrace();
		}
	}


}

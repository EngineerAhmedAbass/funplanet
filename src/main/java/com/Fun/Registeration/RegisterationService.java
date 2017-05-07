package com.Fun.Registeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RegisterationService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public RegisterationService(JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
	}
	
	public void SendMail(int Code , String mail)throws MailException
	{
		SimpleMailMessage Message = new SimpleMailMessage();
		Message.setTo(mail);
		Message.setFrom("FunPlanet@gmail.com");
		Message.setSubject("Confirmation Code");
		String te="Your Registration Code For Fun Planet Account IS   "+Code;
		Message.setText(te);
		
		javaMailSender.send(Message);
		
	}
}

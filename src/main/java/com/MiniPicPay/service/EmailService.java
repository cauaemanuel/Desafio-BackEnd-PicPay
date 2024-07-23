package com.MiniPicPay.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.MiniPicPay.model.Transaction;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailsender;

	@Value("${spring.mail.username}")
	private String remetente;

	public void enviarEmailSender(Transaction tr) {

		try {
			MimeMessage message = javaMailsender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(remetente);
			helper.setTo(tr.getSender().getEmail());
			helper.setSubject("Pagamento Confirmado");

			String template = carregarTemplateEmailSender();
			template = template.replace("#{nome}", tr.getSender().getNomeCompleto());
			template = template.replace("#{valor}", tr.getAmout().toString());
			template = template.replace("#{data}", tr.getTimestamp().toString());
			template = template.replace("#{receiver}", tr.getReceiver().getNomeCompleto());

			helper.setText(template, true);

			javaMailsender.send(message);

		} catch (Exception e) {
			System.out.println("A mensagem não foi enviada");
		}
	}

	public void enviarEmailReceiver(Transaction tr) {

		try {
			MimeMessage message = javaMailsender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(remetente);
			helper.setTo(tr.getReceiver().getEmail());
			helper.setSubject("Pagamento Recebido");

			String template = carregarTemplateEmailReceiver();
			template = template.replace("#{nome}", tr.getReceiver().getNomeCompleto());
			template = template.replace("#{valor}", tr.getAmout().toString());
			template = template.replace("#{data}", tr.getTimestamp().toString());
			template = template.replace("#{sender}", tr.getSender().getNomeCompleto());

			helper.setText(template, true);

			javaMailsender.send(message);

		} catch (Exception e) {
			System.out.println("A mensagem não foi enviada");
		}
	}

	public String carregarTemplateEmailSender() throws IOException {

		ClassPathResource resource = new ClassPathResource("sender.html");
		return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

	}

	public String carregarTemplateEmailReceiver() throws IOException {

		ClassPathResource resource = new ClassPathResource("receiver.html");
		return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
	}

	public void notifyPayMent(Transaction tr) {
		enviarEmailSender(tr);
		enviarEmailReceiver(tr);

	}
}

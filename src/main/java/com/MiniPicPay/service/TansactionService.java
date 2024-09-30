package com.MiniPicPay.service;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MiniPicPay.DTO.TransactionDTO;
import com.MiniPicPay.client.Response;
import com.MiniPicPay.client.authorizeClient;
import com.MiniPicPay.model.Transaction;
import com.MiniPicPay.model.Usuario;
import com.MiniPicPay.repository.TransactionRepository;

@Service
public class TansactionService {

	@Autowired
	private UserService userservice;

	@Autowired
	private EmailService emailService;

	@Autowired
	private authorizeClient auth;

	@Autowired
	private TransactionRepository repository;

	public Transaction createTransaction(TransactionDTO transaction) throws Exception {
		Usuario sender = userservice.findById(transaction.senderid());
		Usuario receiver = userservice.findById(transaction.receiver());

		userservice.validateTransactions(sender, transaction.value());

		boolean isAuthorize = authorizeTransaction(sender, transaction.value());
		if (!isAuthorize) {

			throw new Exception("A transação não foi autorizada");
		}
		Transaction newTransaction = new Transaction();

		newTransaction.setSender(sender);
		newTransaction.setAmout(transaction.value());
		newTransaction.setReceiver(receiver);

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime datenow = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0, 0);

		newTransaction.setTimestamp(datenow);

		sender.setBalance(sender.getBalance().subtract(transaction.value()));
		receiver.setBalance(receiver.getBalance().add(transaction.value()));

		this.repository.save(newTransaction);
		userservice.saveUser(sender);
		userservice.saveUser(receiver);

		emailService.notifyPayMent(newTransaction);

		return newTransaction;

	}

	private boolean authorizeTransaction(Usuario sender, BigDecimal value) {
		Response response = auth.getAuthorize();
		String authorized = response.getAuthorized();

		return "success".equals(authorized);
	}
}

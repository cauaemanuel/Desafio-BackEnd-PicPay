package com.MiniPicPay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiniPicPay.DTO.TransactionDTO;
import com.MiniPicPay.model.Transaction;
import com.MiniPicPay.service.TansactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TansactionService transactionservice;
	
	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception{
	     
		Transaction newTransaction = transactionservice.createTransaction(transaction);
		return new ResponseEntity<>(newTransaction, HttpStatus.OK);
	}
}

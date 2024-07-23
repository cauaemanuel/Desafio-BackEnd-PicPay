package com.MiniPicPay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MiniPicPay.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}

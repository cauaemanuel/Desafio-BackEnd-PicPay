package com.MiniPicPay.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "transactions")
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	private BigDecimal amout;
	
	@ManyToOne
	@JoinColumn(name = "sender-id")
	private Usuario sender;
	
	@ManyToOne
	@JoinColumn(name = "receiver-id")
	private Usuario receiver;
	
	
	private LocalDateTime timestamp;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public BigDecimal getAmout() {
		return amout;
	}


	public void setAmout(BigDecimal amout) {
		this.amout = amout;
	}


	public Usuario getSender() {
		return sender;
	}


	public void setSender(Usuario sender) {
		this.sender = sender;
	}


	public Usuario getReceiver() {
		return receiver;
	}


	public void setReceiver(Usuario receiver) {
		this.receiver = receiver;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public Transaction(Integer id, BigDecimal amout, Usuario sender, Usuario receiver, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.amout = amout;
		this.sender = sender;
		this.receiver = receiver;
		this.timestamp = timestamp;
	}

	
	public Transaction() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(id, other.id);
	}
	
	
}



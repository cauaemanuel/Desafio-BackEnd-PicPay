package com.MiniPicPay.model;

import java.math.BigDecimal;

import com.MiniPicPay.DTO.UsuarioDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb-user")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nomeCompleto")
	private String nomeCompleto;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "document", unique = true)
	private String document;

	@Column(name = "senha")
	private String senha;

	@Column(name = "balance")
	private BigDecimal balance;
	
	
	@Enumerated(EnumType.STRING)
	private UserType userType;

	public Usuario() {
		
	}
	public Usuario(UsuarioDTO user) {
		this.nomeCompleto = user.NomeCompleto();
		this.balance = user.balance();
		this.document = user.document();
		this.email = user.email();
		this.senha = user.senha();
		this.userType = user.usertype();
	}

	public Usuario(Long id, String nomeCompleto, String email, String document, String senha, BigDecimal balance,
			UserType userType) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.document = document;
		this.senha = senha;
		this.balance = balance;
		this.userType = userType;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDocument() {
		return document;
	}


	public void setDocument(String document) {
		this.document = document;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public BigDecimal getBalance() {
		return balance;
	}


	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
}

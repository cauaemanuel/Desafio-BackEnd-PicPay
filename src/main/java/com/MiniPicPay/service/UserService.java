package com.MiniPicPay.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MiniPicPay.DTO.UsuarioDTO;
import com.MiniPicPay.model.UserType;
import com.MiniPicPay.model.Usuario;
import com.MiniPicPay.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public void validateTransactions(Usuario sender, BigDecimal amout) throws Exception {
		if(sender.getUserType() == UserType.MERCHANT) {
			throw new Exception("Lojistas só recebem transferências, não enviam dinheiro para ninguém");
			
		}
		if(sender.getBalance().compareTo(amout) < 0) {
			throw new Exception("Saldo insuficiente");
		}
	}
	
	public Usuario findById(Long id) throws Exception {
		return this.repository.findById(id).orElseThrow(() -> new Exception("O usuario não foi encontrado"));
	}
	
	public void saveUser(Usuario user) {
		repository.save(user);
		
	}
	
	public Usuario createUsuario(UsuarioDTO uiser) {
		Usuario user = new Usuario(uiser);
		this.saveUser(user);
		return user;
	}
	
	public List<Usuario> getAllUser(){
		return this.repository.findAll();
	}
}

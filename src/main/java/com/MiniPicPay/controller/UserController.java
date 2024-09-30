package com.MiniPicPay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiniPicPay.DTO.UsuarioDTO;
import com.MiniPicPay.model.Usuario;
import com.MiniPicPay.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userservice;
	@PostMapping
	public ResponseEntity<Usuario> createuser(@RequestBody UsuarioDTO User){
		Usuario newUser = userservice.createUsuario(User);
	   
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUser(){
		List<Usuario> users = this.userservice.getAllUser();
	
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
}

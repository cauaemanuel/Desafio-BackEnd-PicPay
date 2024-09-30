package com.MiniPicPay.DTO;

import java.math.BigDecimal;

import com.MiniPicPay.model.UserType;

public record UsuarioDTO(String NomeCompleto, BigDecimal balance, String email, String senha, String document, UserType usertype) {

	
	
}

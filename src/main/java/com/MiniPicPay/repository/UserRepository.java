package com.MiniPicPay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MiniPicPay.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findUsuarioByDocument(String document);
}

package com.MiniPicPay.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.MiniPicPay.DTO.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException exception) {
		ExceptionDTO excpetionDTO = new ExceptionDTO("Usuario ja cadastrado", "400");
		return ResponseEntity.badRequest().body(excpetionDTO);
	}
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity threat404(EntityNotFoundException exception) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity threatGeneralException(Exception e) {
		ExceptionDTO excpetionDTO = new ExceptionDTO(e.getMessage(), "500");
		return ResponseEntity.badRequest().body(excpetionDTO);
	}
}

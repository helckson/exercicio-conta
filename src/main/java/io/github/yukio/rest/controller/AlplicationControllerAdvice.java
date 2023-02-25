package io.github.yukio.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.yukio.exception.BancoNaoEncontradoException;
import io.github.yukio.exception.PessoaNaoEncontradaException;
import io.github.yukio.rest.ApiErrors;

@RestControllerAdvice
public class AlplicationControllerAdvice {

	@ExceptionHandler(PessoaNaoEncontradaException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors handlePessoaNaoEncontradaException(PessoaNaoEncontradaException ex) {
		return new ApiErrors(ex.getMessage());
	}
	
	@ExceptionHandler(BancoNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors handleBancoNaoEncontradoException(BancoNaoEncontradoException ex) {
		return new ApiErrors(ex.getMessage());
	}
}

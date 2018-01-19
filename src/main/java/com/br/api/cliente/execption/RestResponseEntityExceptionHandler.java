package com.br.api.cliente.execption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> conflitoDeIntegridade(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "This should be application specific";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = { NegocioExecption.class })
	protected ResponseEntity<Object> erroBadRequest(NegocioExecption ex, WebRequest request) {
		String bodyOfResponse = "Erro nos dados da sua requisição";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> erroGenerico(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Erro inesperado";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
				request);
	}
}

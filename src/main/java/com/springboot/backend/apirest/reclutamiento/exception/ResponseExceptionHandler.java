package com.springboot.backend.apirest.reclutamiento.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ValidationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(Exception ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		errors.add(ex.getMessage());
		errors.add(request.getDescription(false));
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), errors);
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ModeloNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> manejarModeloException(ModeloNotFoundException ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		errors.add(ex.getMessage());
		errors.add(request.getDescription(false));
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), errors);
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
				.collect(Collectors.toList());
		errors.add(request.getDescription(false));
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), errors);
		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public final ResponseEntity<ExceptionResponse> manejarPLSQLExcepciones(DataIntegrityViolationException ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		errors.add(ex.getCause().getCause().getMessage());
		errors.add(request.getDescription(false));
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), errors);
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public final ResponseEntity<ExceptionResponse> manejarNumberFormatExcepciones(MethodArgumentTypeMismatchException ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		errors.add(ex.getMessage());
		errors.add(ex.getCause().toString());
		errors.add(request.getDescription(false));
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), errors);
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(ValidationException.class)
	public final ResponseEntity<ExceptionResponse> manejarValidacionesExcepciones(ValidationException ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		errors.add(ex.getMessage());
		errors.add(ex.getCause().toString());
		errors.add(request.getDescription(false));
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), errors);
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.NOT_ACCEPTABLE);
	}
	
}

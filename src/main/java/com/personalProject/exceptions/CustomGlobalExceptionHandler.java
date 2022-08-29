package com.personalProject.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// Method Argument Not Valid Exception
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customError = new CustomErrorDetails(new Date(), "Method Argument Not Valid Exception",
				ex.getMessage());

		return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);

	}

	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customError = new CustomErrorDetails(new Date(),
				"Http Request Method Not Supported - Method not allowed", ex.getMessage());

		return new ResponseEntity<>(customError, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(UserNameNotFoundException.class)
	public final ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex,
			WebRequest request) {

		CustomErrorDetails customError = new CustomErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);

	}

	// constraint violation exception
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstrainViolationException(ConstraintViolationException ex,
			WebRequest request) {

		CustomErrorDetails customError = new CustomErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);

	}
}
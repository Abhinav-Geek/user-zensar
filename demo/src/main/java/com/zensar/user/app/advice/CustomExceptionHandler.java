package com.zensar.user.app.advice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest request) {

		Map<String, Object> map = new HashMap<>();
		map.put("timestamp", new Date());
		map.put("status", httpStatus.value());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		map.put("errors", errors);
		return new ResponseEntity<>(map, httpHeaders, httpStatus);

	}
	
	@ExceptionHandler(UserInfoDuplicateException.class)
	public ResponseEntity<Object>  handleException(final UserInfoDuplicateException exception, WebRequest request) {

		Map<String, Object> map = new HashMap<>();
		map.put("timestamp", new Date());

		List<String> errors = new ArrayList<String>();
		errors.add(exception.getMessage()); 
		map.put("errors", errors);
		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

package com.isoqualtech.plateformAPI.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JwtErrorHandler extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JwtTokenUtil jwtTokenUtil;
	
	@ExceptionHandler(value = JwtErrorHandler.class)

	public ResponseEntity<Object> exception(JwtErrorHandler exception) {
		return  new ResponseEntity<>("Jwt error", HttpStatus.NOT_FOUND);
	}
}

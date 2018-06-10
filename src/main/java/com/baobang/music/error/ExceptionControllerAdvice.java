package com.baobang.music.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.baobang.music.model.EndPoint;

/**
  * @author BaoBang
  * @Created Apr 17, 2018
  * 
  */
@ControllerAdvice
@RestController
public class ExceptionControllerAdvice {
 
	@ExceptionHandler(Exception.class)
	public EndPoint<Object> exceptionHandler(Exception ex) {
		return new EndPoint<Object>(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				null);
	}
	
}
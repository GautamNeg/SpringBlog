package com.project.blog.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.blog.payload.apiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleNoResource(ResourceNotFoundException r){
		String m=r.getMessage();
		return new ResponseEntity<String>(m,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<apiResponse> noelement(NoSuchElementException m){
		
		return new ResponseEntity<apiResponse>(new apiResponse("No such id change it"),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> validate(MethodArgumentNotValidException m){
		Map<String,String> ma=new HashMap<>();
		m.getBindingResult().getAllErrors().forEach((error)->{
			String fieldname=((FieldError)error).getField();
			String value=error.getDefaultMessage();
		ma.put(fieldname,value);
		});
		return new ResponseEntity<Map<String,String>>(ma,HttpStatus.BAD_GATEWAY);
	}
}

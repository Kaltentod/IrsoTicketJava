package com.irsoticket.backjava.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.irsoticket.backjava.models.ErrorInfo;

@RestControllerAdvice
public class GlobalExceptionHandle {

	//Revienta al no encontrar un usuario 
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundExceptions.class)
	public ErrorInfo handleResourceNotFound(ResourceNotFoundExceptions resourceNotFoundExceptions){
		return new ErrorInfo(resourceNotFoundExceptions.getMensaje(),"404");
	}
	
	//Revienta al querer borrar un usuario y no encontrarlo en la base de datos
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ErrorInfo handleResourceNotInDataBase(EmptyResultDataAccessException resourceNotFoundExceptions){
		return new ErrorInfo(resourceNotFoundExceptions.getLocalizedMessage(),"404");
	}
	
	//Revienta al querer dar de alta un usuario informando mierda  
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public ErrorInfo handleBadRequestException(BadRequestException badRequestException){
		return new ErrorInfo(badRequestException.getMessage(),"400");
	}
	
	//Revienta cuando un recurso se informa como null
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ErrorInfo handleHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException){
		return new ErrorInfo("El body se encuentra vacio","400");
	}
	
	//Revienta al no informar un campo
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorInfo handleHttpMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		return new ErrorInfo("campo: " + ex.getBindingResult().getFieldError().getField() + " " + ex.getBindingResult().getFieldError().getDefaultMessage(),"400");
	}
	
	//Revienta al no informar un campo de una tabla relacionada por ejemplo la de localidad
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ErrorInfo handleDataIntegrityViolationException(DataIntegrityViolationException ex){
		return new ErrorInfo("campo: " + ((org.postgresql.util.PSQLException)ex.getMostSpecificCause()).getServerErrorMessage().getColumn()+" debe estar informado","400");
	}
}


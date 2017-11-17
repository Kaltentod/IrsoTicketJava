package com.irsoticket.backjava.exceptions;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.irsoticket.backjava.dto.ErrorInfo;

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
		return new ErrorInfo("El body se encuentra vacio o hay un error en el formato","400");
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
	
	//Revienta al no informar un campo de una tabla relacionada al hacer una modificacion
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(TransactionSystemException.class)
		public ErrorInfo handleTransactionSystemException(TransactionSystemException ex){
			ConstraintViolationException e = (ConstraintViolationException)ExceptionUtils.getRootCause(ex);
			ConstraintViolation<?> constraint = e.getConstraintViolations().iterator().next();
			String message = constraint.getPropertyPath()+" " + constraint.getMessage();
			return new ErrorInfo(message,"400");
		}
		
	//Revienta al informar una localidad invalida
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(InvalidDataAccessApiUsageException.class)
		public ErrorInfo handleInvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException ex){
			return new ErrorInfo("La localidad ingresada no existe","400");
		}
}


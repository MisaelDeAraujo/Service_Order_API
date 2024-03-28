package com.misael.service.order.handlers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.misael.service.order.exceptions.PersonNotFoundException;
import com.misael.service.order.exceptions.ServiceOrderNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> personNotFoundHandler(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person não encontada");
    }

    @ExceptionHandler(ServiceOrderNotFoundException.class)
    public ResponseEntity<String> serviceOrderNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order não encontrada");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handlerValidation(MethodArgumentNotValidException ex) {
    	List<String> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
    			.map(FieldError::getDefaultMessage).collect(Collectors.toList());
    	String errorMessage = fieldErrors.toString();
    	return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage);
    }
    
    

}

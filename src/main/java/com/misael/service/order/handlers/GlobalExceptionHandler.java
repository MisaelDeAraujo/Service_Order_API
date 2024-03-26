package com.misael.service.order.handlers;

import com.misael.service.order.entities.Person;
import com.misael.service.order.exceptions.PersonNotFoundException;
import com.misael.service.order.exceptions.ServiceOrderNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> personNotFoundHandler(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person Not Found");
    }

    @ExceptionHandler(ServiceOrderNotFoundException.class)
    public ResponseEntity<String> serviceOrderNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Not Found");
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Problem> handleBindException(BindException ex) {
        // Mapear os erros de validação para o formato Problem Details
        Problem problem = Problem.builder()
                .withStatus(Status.BAD_REQUEST)
                .withTitle("Erro de validação")
                .withDetail("Um ou mais campos estão inválidos. Corrija-os e tente novamente.")
                .with("fieldErrors", getFieldErrors(ex))
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    private List<FieldError> getFieldErrors(BindException ex) {
        return ex.getBindingResult().getFieldErrors();
    }

}

package com.ombrodrigo.crudrest.resources.exception;

import javax.servlet.http.HttpServletRequest;

import com.ombrodrigo.crudrest.services.exception.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(
        ObjectNotFoundException exception,
        HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        
        StandardError error = new StandardError(
            System.currentTimeMillis(),
            status.value(),
            "Não encontrado",
            exception.getMessage(),
            request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);
    }
}
package com.kimdev.trackarate.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kimdev.trackarate.exceptions.ObjectsValidationException;
import com.kimdev.trackarate.exceptions.OperationNotAllowedException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectsValidationException.class)
    public ResponseEntity<ExceptionRepresentation> exceptionHandler(ObjectsValidationException exception) {
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("Object not valid exception has occurred.")
                .errorSource(exception.getViolationSource())
                .validationErrors(exception.getViolations())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(representation);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionRepresentation> exceptionHandler(EntityNotFoundException exception) {
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("Entity not found exception has occurred.")
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(representation);
    }

    @ExceptionHandler(OperationNotAllowedException.class)
    public ResponseEntity<ExceptionRepresentation> exceptionHandler(OperationNotAllowedException exception) {
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("Entity not found exception has occurred.")
                .build();
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(representation);
    }

}

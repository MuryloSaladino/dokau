package org.saladino.dokau.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.saladino.dokau.exceptions.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController {

    public record Message(String message) {}

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();

        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

        Map<String, Object> result = new HashMap<>();
        result.put("message", "Your request is out of the accepted format");
        result.put("errors", errors);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<Message> responseError(ResponseException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(ex.getCode())
                .body(new Message(ex.getMessage()));
    }
}

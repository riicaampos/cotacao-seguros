package br.com.seguros.seguros.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> manageException(Exception e) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseBody.put("message", "Ocorreu um erro ao processar a requisição: " + e.getMessage());
        responseBody.put("timestamp", Calendar.getInstance());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(responseBody);
    }

}

package br.com.jr.contatos.controller.exceptions;

import br.com.jr.contatos.exceptions.ExistingEmailException;
import br.com.jr.contatos.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardException> resourceNotFoundException(
            ResourceNotFoundException e, HttpServletRequest request){
        StandardException error = new StandardException();
        error.setTimeStamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
                 HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ExistingEmailException.class)
    public ResponseEntity<StandardException> handleExistingEmailException(
            ExistingEmailException e, HttpServletRequest request){
        StandardException error = new StandardException();
        error.setTimeStamp(Instant.now());
        error.setStatus(HttpStatus.CONFLICT.value());
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

}


package com.spring.bakery.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GlobalErrorHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNoFound.class)
    public ResponseEntity<ErrorDetails> ResourceNoFoundException(ResourceNoFound excepcion, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), excepcion.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND  );
    }

    @ExceptionHandler(AppError.class)
    public ResponseEntity<ErrorDetails> BlogAppException(ResourceNoFound excepcion, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), excepcion.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> GlobalException(ResourceNoFound excepcion, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), excepcion.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->{
            String nombre = ((FieldError)error).getField();
            String mensaje = error.getDefaultMessage();
            errores.put(nombre,mensaje);
        });
        return new ResponseEntity<>(errores,HttpStatus.BAD_REQUEST);
    }

}

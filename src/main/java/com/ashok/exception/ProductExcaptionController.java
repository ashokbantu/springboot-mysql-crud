package com.ashok.exception;

import com.ashok.ExceptionMessage;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductExcaptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<ExceptionMessage> handleResourceNotFound(Exception resourceNotFoundException){
        ExceptionMessage errorMessage= new ExceptionMessage();
        errorMessage.setErrorCode("404");
        errorMessage.setErrorMessage("Resource is not found for this path");
        return new ResponseEntity<ExceptionMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

  }

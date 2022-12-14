package com.rakibulh.apiboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String BAD_CREDENTIALS = "bad_credentials";
    private static final String ACCESS_DENIED = "access_denied";
    private static final String CONFLICT = "conflict";
    private static final String INVALID_DATA = "invalid_input_data";

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
    @ExceptionHandler({InternalServerException.class, NumberFormatException.class,
            NullPointerException.class, RuntimeException.class, Exception.class})
    public ResponseEntity<?>  handlerAnyServerError(RuntimeException ex, WebRequest request){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

package dev.java10x.MagicFridgeAI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String handlerDataNotFoundException(DataNotFoundException ex){
        return ex.getMessage();
    }
}

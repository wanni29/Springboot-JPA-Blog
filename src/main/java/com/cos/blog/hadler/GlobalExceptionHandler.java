package com.cos.blog.hadler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // 모든 exception 이 발동하면 이쪽으로 다 모인다.
@RestController
public class GlobalExceptionHandler {
    

    // @ExceptionHandler(value = IllegalArgumentException.class) // IllegalArgumentException <- 이거에 해당되는 exception 만 처리가능
    @ExceptionHandler(value = Exception.class) // Exception.class 모든 Exception 처리해줌
    public String handleArgumentException(IllegalArgumentException e) {
        return "<h1>" + e.getMessage() + "</h1>";
    }
}

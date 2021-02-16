/*
package com.matrimony.athiest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity exception(Exception exception){
        System.out.print(exception.getMessage());
        return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserExist.class)
        public ResponseEntity userExist(UserExist ex){
            return new ResponseEntity<>("User already exist", HttpStatus.BAD_REQUEST);
        }

}
*/

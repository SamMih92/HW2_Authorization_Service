package ru.netology.HW2_Authorization_Service.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.HW2_Authorization_Service.exceptions.InvalidCredentials;
import ru.netology.HW2_Authorization_Service.exceptions.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials e) {
        // ошибка 400 + сообщение
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser e) {
        // Печать в консоль
        System.out.println(e.getMessage());
        // ошибка 401 + сообщение
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}

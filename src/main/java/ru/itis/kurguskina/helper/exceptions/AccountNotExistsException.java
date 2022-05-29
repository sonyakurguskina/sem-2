package ru.itis.kurguskina.helper.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountNotExistsException extends RuntimeException {
    public AccountNotExistsException() {
        super();
    }
}

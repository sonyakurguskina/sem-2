package ru.itis.kurguskina.helper.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArticleNotExistsException extends RuntimeException {
    public ArticleNotExistsException(Long postId) {
        super("Post with id <" + postId + "> is not exists");
    }
}

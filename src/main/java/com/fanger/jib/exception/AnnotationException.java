package com.fanger.jib.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Administrator
 */
@Getter
@Setter
public class AnnotationException extends Exception {

    private String message;
    private Throwable throwable;

    public AnnotationException(String message) {
        super(message);
        this.message = message;
    }

    public AnnotationException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
        this.throwable = throwable;
    }

}

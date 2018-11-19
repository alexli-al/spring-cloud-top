package com.dogbro.exception;

/**
 * @description
 * @auther dogbro
 * @date 2018-11-19 16:34
 */
public class CustomException extends RuntimeException {

    /**
     *
     */
    public CustomException() {
        super();
    }

    /**
     *
     * @param message
     */
    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

}

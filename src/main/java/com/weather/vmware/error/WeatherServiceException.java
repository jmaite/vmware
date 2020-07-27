package com.weather.vmware.error;

import org.springframework.http.HttpStatus;

public class WeatherServiceException extends RuntimeException {
    private HttpStatus httpStatusCode;

    public WeatherServiceException(String message) {
        super(message);
    }

    public WeatherServiceException(String message, HttpStatus errorCode) {
        super(message);
        this.httpStatusCode = errorCode;
    }

    public WeatherServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherServiceException(String message, Throwable cause, HttpStatus errorCode) {
        super(message, cause);
        this.httpStatusCode = errorCode;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }
}
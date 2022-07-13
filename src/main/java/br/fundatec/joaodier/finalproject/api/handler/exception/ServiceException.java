package br.fundatec.joaodier.finalproject.api.handler.exception;

public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }
}

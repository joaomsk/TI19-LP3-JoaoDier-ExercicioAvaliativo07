package br.fundatec.joaodier.finalproject.api.handler.exception;

public class NotFoundException extends ServiceException {
    public NotFoundException(String message) {
        super(message);
    }
}

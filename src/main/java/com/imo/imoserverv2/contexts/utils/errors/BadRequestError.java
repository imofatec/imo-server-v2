package com.imo.imoserverv2.contexts.utils.errors;

public class BadRequestError extends DomainError {
    public BadRequestError(String message) {
        super(message);
    }

    public BadRequestError() {
        super("Bad Request");
    }
}

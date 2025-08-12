package com.imo.imoserverv2.contexts.utils.errors;

public class NotFoundError extends DomainError {
    public NotFoundError(String message) {
        super(message);
    }

    public NotFoundError() {
        super("Not Found");
    }
}

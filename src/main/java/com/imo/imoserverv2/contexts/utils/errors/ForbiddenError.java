package com.imo.imoserverv2.contexts.utils.errors;

public class ForbiddenError extends DomainError {
    public ForbiddenError(String message) {
        super(message);
    }

    public ForbiddenError() {
        super("Forbidden");
    }
}

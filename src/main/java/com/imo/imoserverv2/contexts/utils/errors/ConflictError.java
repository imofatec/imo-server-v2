package com.imo.imoserverv2.contexts.utils.errors;

public class ConflictError extends DomainError {
    public ConflictError(String message) {
        super(message);
    }

    public ConflictError() {
        super("Conflict");
    }
}

package com.imo.imoserverv2.contexts.utils.errors;

public class DomainError extends RuntimeException {
    public DomainError(String message) {
        super(message);
    }

    public DomainError() {
    }
}

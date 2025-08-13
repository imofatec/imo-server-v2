package com.imo.imoserverv2.contexts.shared.user_management.domain.object_values;

public record Biography(String value) {
    public Biography {
        if (value.length() > 1000) {
            throw new IllegalArgumentException("Biografia tem o limite de mil caracteres");
        }
    }
}

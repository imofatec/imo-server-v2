package com.imo.imoserverv2.contexts.shared.user_management.domain.object_values;

import java.util.regex.Pattern;

public record Email(String value) {
    private static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public Email {
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Email inválido: " + value);
        }
    }
}


package com.imo.imoserverv2.contexts.shared.user_management.domain.object_values;

import com.imo.imoserverv2.contexts.utils.errors.BadRequestError;
import org.springframework.util.Assert;

public record Password(String value) {
    public Password {
        Assert.notNull(value, "Senha não pode estar vazia");

        if (value.trim().length() == 0) {
            throw new BadRequestError("Senha não pode estar vazia");
        }
    }
}

package com.imo.imoserverv2.contexts.shared.user_management.domain.object_values;

import com.imo.imoserverv2.contexts.utils.errors.BadRequestError;
import org.springframework.util.Assert;

public record Username(String value) {
    public Username {
        Assert.notNull(value, "Nome não pode estar vazio");

        if (value.length() > 100) {
            throw new BadRequestError("Nome tem limite de 100 caracteres");
        }
    }
}

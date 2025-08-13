package com.imo.imoserverv2.contexts.shared.user_management.application.generic_dtos;

import com.imo.imoserverv2.contexts.shared.user_management.domain.Admin;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Role;

public record AdminDTO(String id, String email, String username, int age, Role role) {
    public static AdminDTO fromDomain(Admin admin) {
        return new AdminDTO(
                admin.getId().toString(),
                admin.getEmail().value(),
                admin.getUsername().value(),
                admin.getAge(),
                admin.getRole()
        );
    }
}

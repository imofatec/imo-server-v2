package com.imo.imoserverv2.contexts.shared.user_management.application.usecases.admin.register_admin;

public record RegisterAdminRequest(String email, String username, String password, int age) {
}

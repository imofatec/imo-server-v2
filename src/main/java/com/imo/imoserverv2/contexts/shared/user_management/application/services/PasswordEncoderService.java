package com.imo.imoserverv2.contexts.shared.user_management.application.services;

public interface PasswordEncoderService {
    String encode(String plain);

    boolean matches(String plain, String encodedPassword);
}

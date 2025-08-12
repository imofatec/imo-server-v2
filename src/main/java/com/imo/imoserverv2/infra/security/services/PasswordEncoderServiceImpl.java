package com.imo.imoserverv2.infra.security.services;

import com.imo.imoserverv2.contexts.shared.user_management.application.services.PasswordEncoderService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderServiceImpl implements PasswordEncoderService {
  private final PasswordEncoder passwordEncoder;

  public PasswordEncoderServiceImpl(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public String encode(String plain) {
    return this.passwordEncoder.encode(plain);
  }

  @Override
  public boolean matches(String plain, String encodedPassword) {
    return this.passwordEncoder.matches(
        plain,
        encodedPassword
    );
  }
}

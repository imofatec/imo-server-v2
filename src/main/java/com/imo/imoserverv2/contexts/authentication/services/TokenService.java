package com.imo.imoserverv2.contexts.authentication.services;

import com.imo.imoserverv2.contexts.authentication.usecases.LoginResponse;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Role;

import java.util.Map;

public interface TokenService {
  LoginResponse generateToken(String id, Role role);

  Map<String, String> getPayload(String token);
}

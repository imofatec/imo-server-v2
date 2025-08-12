package com.imo.imoserverv2.infra.security.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imo.imoserverv2.contexts.authentication.TokenSubject;
import com.imo.imoserverv2.contexts.authentication.services.TokenService;
import com.imo.imoserverv2.contexts.authentication.usecases.LoginResponse;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Role;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
public class JwtService implements TokenService {
  private final JwtEncoder jwtEncoder;

  private final JwtDecoder jwtDecoder;

  private final ObjectMapper objectMapper;

  public JwtService(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder, ObjectMapper objectMapper) {
    this.jwtEncoder = jwtEncoder;
    this.jwtDecoder = jwtDecoder;
    this.objectMapper = objectMapper;
  }

  @Override
  public LoginResponse generateToken(String id, Role role) {
    String sub;

    try {
      sub = objectMapper.writeValueAsString(new TokenSubject(
          id,
          role.toString()
      ));
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }

    var now = Instant.now();
    var expiresIn = 18000L;

    var claims = JwtClaimsSet.builder()
        .issuer("IMOv2")
        .issuedAt(now)
        .subject(sub)
        .expiresAt(now.plusSeconds(expiresIn))
        .build();
    String token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

    return new LoginResponse(
        token,
        expiresIn
    );
  }

  @Override
  public Map<String, String> getPayload(String token) {
    Jwt payload = jwtDecoder.decode(token.substring(7));

    String subAsString = payload.getClaim("sub");

    Map<String, String> subAsMap;

    try {
      subAsMap = objectMapper.readValue(
          subAsString,
          new TypeReference<Map<String, String>>() {
          }
      );
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }

    return subAsMap;
  }
}

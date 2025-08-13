package com.imo.imoserverv2.presentation;

import com.imo.imoserverv2.contexts.authentication.usecases.LoginRequest;
import com.imo.imoserverv2.contexts.authentication.usecases.LoginResponse;
import com.imo.imoserverv2.contexts.authentication.usecases.LoginUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
  private final LoginUseCase loginUseCase;

  public LoginController(LoginUseCase loginUseCase) {
    this.loginUseCase = loginUseCase;
  }

  @PostMapping
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
    var loginResponse = this.loginUseCase.execute(loginRequest);
    return ResponseEntity.ok(loginResponse);
  }
}

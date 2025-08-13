package com.imo.imoserverv2.contexts.authentication.usecases;

import com.imo.imoserverv2.contexts.authentication.services.TokenService;
import com.imo.imoserverv2.contexts.shared.user_management.application.services.PasswordEncoderService;
import com.imo.imoserverv2.contexts.shared.user_management.domain.AdminRepository;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Email;
import com.imo.imoserverv2.contexts.utils.UseCase;
import com.imo.imoserverv2.contexts.utils.errors.ForbiddenError;
import com.imo.imoserverv2.contexts.utils.errors.NotFoundError;

@UseCase
public class LoginUseCase {
  private final AdminRepository adminRepository;

  private final PasswordEncoderService passwordEncoderService;

  private final TokenService tokenService;

  public LoginUseCase(
      AdminRepository adminRepository,
      PasswordEncoderService passwordEncoderService,
      TokenService tokenService
  ) {
    this.adminRepository = adminRepository;
    this.passwordEncoderService = passwordEncoderService;
    this.tokenService = tokenService;
  }

  public LoginResponse execute(LoginRequest request) {
    var foundAdmin = this.adminRepository.findByEmail(new Email(request.email()))
        .orElseThrow(NotFoundError::new);

    var validPassword = this.passwordEncoderService.matches(
        request.password(),
        foundAdmin.getPassword().value()
    );

    if (!validPassword) {
      throw new ForbiddenError();
    }

    return this.tokenService.generateToken(
        foundAdmin.getId().toString(),
        foundAdmin.getRole()
    );
  }
}

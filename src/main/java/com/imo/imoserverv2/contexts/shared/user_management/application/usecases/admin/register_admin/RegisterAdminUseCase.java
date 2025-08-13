package com.imo.imoserverv2.contexts.shared.user_management.application.usecases.admin.register_admin;

import com.imo.imoserverv2.contexts.shared.user_management.application.generic_dtos.AdminDTO;
import com.imo.imoserverv2.contexts.shared.user_management.application.services.PasswordEncoderService;
import com.imo.imoserverv2.contexts.shared.user_management.domain.Admin;
import com.imo.imoserverv2.contexts.shared.user_management.domain.AdminRepository;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Email;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Password;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Username;
import com.imo.imoserverv2.contexts.utils.UseCase;
import com.imo.imoserverv2.contexts.utils.errors.ConflictError;

import java.util.Optional;

@UseCase
public class RegisterAdminUseCase {
  private final AdminRepository adminRepository;

  private final PasswordEncoderService passwordEncoderService;

  public RegisterAdminUseCase(
      AdminRepository adminRepository,
      PasswordEncoderService passwordEncoderService
  ) {
    this.adminRepository = adminRepository;
    this.passwordEncoderService = passwordEncoderService;
  }

  public AdminDTO execute(RegisterAdminRequest registerAdminRequest) {

    this.verifyEmail(registerAdminRequest.email());

    var encodedPassword = this.passwordEncoderService.encode(registerAdminRequest.password());

    var admin = new Admin(
        new Email(registerAdminRequest.email()),
        new Username(registerAdminRequest.username()),
        new Password(encodedPassword),
        registerAdminRequest.age()
    );

    Admin newAdmin = this.adminRepository.save(admin);

    return AdminDTO.fromDomain(newAdmin);
  }

  private void verifyEmail(String email) {
    Optional<Admin> uniqueUser = this.adminRepository.findByEmail(new Email(email));

    if (uniqueUser.isPresent()) {
      throw new ConflictError("Usuário ja existente");
    }
  }
}

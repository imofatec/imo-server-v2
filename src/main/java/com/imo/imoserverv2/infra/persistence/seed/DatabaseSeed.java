package com.imo.imoserverv2.infra.persistence.seed;

import com.imo.imoserverv2.contexts.shared.user_management.application.services.PasswordEncoderService;
import com.imo.imoserverv2.contexts.shared.user_management.domain.Admin;
import com.imo.imoserverv2.contexts.shared.user_management.domain.AdminRepository;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Email;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Password;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Username;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile({ "dev", "test" })
public class DatabaseSeed {
  private final AdminRepository adminRepository;

  private final PasswordEncoderService passwordEncoderService;

  public DatabaseSeed(
      AdminRepository adminRepository,
      PasswordEncoderService passwordEncoderService) {
    this.adminRepository = adminRepository;
    this.passwordEncoderService = passwordEncoderService;
  }

  public void seed() {
  }

  public void reset() {
  }

  public void seedDefaultAdminUser() {
    var defaultEmail = "admin@admin.com";
    if (this.adminRepository.findByEmail(new Email(defaultEmail)).isEmpty()) {
      var password = "admin";

      var admin = new Admin(
          new Email(defaultEmail),
          new Username("admin"),
          new Password(this.passwordEncoderService.encode(password)),
          20);

      this.adminRepository.save(admin);

      log.info("Admin user of development environment has been created");
    }
  }
}

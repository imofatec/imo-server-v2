package com.imo.imoserverv2.presentation;

import com.imo.imoserverv2.contexts.shared.user_management.application.generic_dtos.AdminDTO;
import com.imo.imoserverv2.contexts.shared.user_management.application.usecases.admin.register_admin.RegisterAdminRequest;
import com.imo.imoserverv2.contexts.shared.user_management.application.usecases.admin.register_admin.RegisterAdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterAdminController extends AdminController {
  private final RegisterAdminUseCase registerAdminUseCase;

  public RegisterAdminController(RegisterAdminUseCase registerAdminUseCase) {
    this.registerAdminUseCase = registerAdminUseCase;
  }

  @PostMapping
  public ResponseEntity<AdminDTO> registerAdmin(
      @RequestBody RegisterAdminRequest registerAdminRequest
  ) {
    var newAdmin = this.registerAdminUseCase.execute(registerAdminRequest);
    return new ResponseEntity<>(
        newAdmin,
        HttpStatus.CREATED
    );
  }
}

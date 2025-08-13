package com.imo.imoserverv2.contexts.shared.user_management.domain;

import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Email;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Password;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Role;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Username;
import com.imo.imoserverv2.contexts.utils.EntityId;

import java.time.LocalDateTime;

public class Admin extends User {
  public Admin(Email email, Username username, Password password, int age) {
    super(
        email,
        username,
        Role.ADMIN,
        password,
        age,
        true
    );
  }

  public Admin(
      EntityId id,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      Email email,
      Username username,
      Password password,
      int age
  ) {
    super(
        id,
        createdAt,
        updatedAt,
        email,
        username,
        Role.ADMIN,
        password,
        age,
        true
    );
  }
}

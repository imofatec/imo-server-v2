package com.imo.imoserverv2.contexts.shared.user_management.domain;

import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Email;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Password;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Role;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Username;
import com.imo.imoserverv2.contexts.utils.BaseEntity;
import com.imo.imoserverv2.contexts.utils.EntityId;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class User extends BaseEntity {
  private Email email;

  private Username username;

  private Role role;

  private Password password;

  private int age;

  private boolean isActive;

  public User(
      EntityId entityId,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      Email email,
      Username username,
      Role role,
      Password password,
      int age,
      boolean isActive
  ) {
    super(entityId,
          createdAt,
          updatedAt);
    this.setEmail(email);
    this.setUsername(username);
    this.setRole(role);
    this.setPassword(password);
    this.setAge(age);
    this.setActive(isActive);
  }

  public User(
      Email email,
      Username username,
      Role role,
      Password password,
      int age,
      boolean isActive
  ) {
    super();
    this.setEmail(email);
    this.setUsername(username);
    this.setRole(role);
    this.setPassword(password);
    this.setAge(age);
    this.setActive(isActive);
  }
}

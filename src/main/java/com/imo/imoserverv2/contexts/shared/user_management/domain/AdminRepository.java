package com.imo.imoserverv2.contexts.shared.user_management.domain;

import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Email;
import com.imo.imoserverv2.contexts.utils.EntityId;

import java.util.Optional;

public interface AdminRepository {
  Admin save(Admin admin);

  Optional<Admin> findById(EntityId id);

  Optional<Admin> findByEmail(Email email);
}

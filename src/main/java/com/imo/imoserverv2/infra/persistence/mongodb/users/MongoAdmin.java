package com.imo.imoserverv2.infra.persistence.mongodb.users;

import com.imo.imoserverv2.contexts.shared.user_management.domain.Admin;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Email;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Password;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Role;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Username;
import com.imo.imoserverv2.contexts.utils.EntityId;
import com.imo.imoserverv2.infra.persistence.mongodb.MongoEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@AllArgsConstructor
public class MongoAdmin extends MongoEntity {
  public String domainId;

  public String email;

  public String username;

  public Role role;

  public String password;

  public int age;

  public boolean isActive;

  public static MongoAdmin toPersistence(Admin admin) {
    return new MongoAdmin(
        admin.getId().toString(),
        admin.getEmail().value(),
        admin.getUsername().value(),
        admin.getRole(),
        admin.getPassword().value(),
        admin.getAge(),
        admin.isActive()
    );
  }

  public static Admin toDomain(MongoAdmin mongoAdmin) {
    return new Admin(
        new EntityId(mongoAdmin.domainId),
        mongoAdmin.createdAt,
        mongoAdmin.updatedAt,
        new Email(mongoAdmin.email),
        new Username(mongoAdmin.username),
        new Password(mongoAdmin.password),
        mongoAdmin.age
    );
  }
}

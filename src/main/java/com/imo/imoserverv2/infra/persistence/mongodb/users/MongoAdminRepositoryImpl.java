package com.imo.imoserverv2.infra.persistence.mongodb.users;

import com.imo.imoserverv2.contexts.shared.user_management.domain.Admin;
import com.imo.imoserverv2.contexts.shared.user_management.domain.AdminRepository;
import com.imo.imoserverv2.contexts.shared.user_management.domain.object_values.Email;
import com.imo.imoserverv2.contexts.utils.EntityId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MongoAdminRepositoryImpl implements AdminRepository {
  private final MongoTemplate mongoTemplate;

  public MongoAdminRepositoryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public Admin save(Admin admin) {
    MongoAdmin raw = MongoAdmin.toPersistence(admin);
    var newAdmin = this.mongoTemplate.save(raw);
    return MongoAdmin.toDomain(newAdmin);
  }

  @Override
  public Optional<Admin> findById(EntityId id) {
    var query = new Query(Criteria.where("domainId").is(id.toString()));
    Optional<MongoAdmin> foundAdmin = Optional.ofNullable(this.mongoTemplate.findOne(
        query,
        MongoAdmin.class
    ));
    return foundAdmin.map(MongoAdmin::toDomain);
  }

  @Override
  public Optional<Admin> findByEmail(Email email) {
    var query = new Query(Criteria.where("email").is(email.value()));
    Optional<MongoAdmin> foundAdmin = Optional.ofNullable(this.mongoTemplate.findOne(
        query,
        MongoAdmin.class
    ));
    return foundAdmin.map(MongoAdmin::toDomain);
  }
}

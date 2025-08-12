package com.imo.imoserverv2.contexts.utils;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class BaseEntity {
  private final EntityId id;

  private final LocalDateTime createdAt;

  private final LocalDateTime updatedAt;

  public BaseEntity(EntityId id, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public BaseEntity() {
    this.id = new EntityId();
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }
}

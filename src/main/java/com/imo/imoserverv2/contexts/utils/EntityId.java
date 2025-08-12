package com.imo.imoserverv2.contexts.utils;

import java.util.UUID;

public class EntityId {
    private final UUID value;

    public EntityId() {
        this.value = UUID.randomUUID();
    }

    public EntityId(String value) {
        this.value = this.fromString(value);
    }

    public String toString() {
        return this.value.toString();
    }

    public UUID fromString(String value) {
        return UUID.fromString(value);
    }
}

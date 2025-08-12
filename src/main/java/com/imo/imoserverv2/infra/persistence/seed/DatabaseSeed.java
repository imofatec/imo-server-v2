package com.imo.imoserverv2.infra.persistence.seed;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DatabaseSeed {
    public void seed() {
    }

    public void reset() {
    }
}

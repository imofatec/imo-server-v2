package com.imo.imoserverv2.infra.persistence.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class SeedCommandLineRunner implements CommandLineRunner {
    private final DatabaseSeed databaseSeed;

    public SeedCommandLineRunner(DatabaseSeed databaseSeed) {
        this.databaseSeed = databaseSeed;
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            return;
        }

        switch (args[0]) {
            case "seed" -> {
                this.databaseSeed.seed();
            }
            case "reset" -> {
                this.databaseSeed.reset();
            }
        }
    }
}

package com.imo.imoserverv2.infra.config.envs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Envs {
    @Value("${client.url}")
    private String clientUrl;
}

package com.imo.imoserverv2.contexts.authentication.usecases;

public record LoginResponse(String accessToken, Long expiresIn) {
}

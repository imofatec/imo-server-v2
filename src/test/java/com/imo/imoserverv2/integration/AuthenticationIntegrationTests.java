package com.imo.imoserverv2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imo.imoserverv2.contexts.authentication.usecases.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Profile({"dev", "test"})
public class AuthenticationIntegrationTests {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void itShouldAuthenticate() throws Exception {
    var defaultLogin = new LoginRequest(
        "admin@admin.com",
        "admin"
    );
    this.mockMvc.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON)
                             .content(this.objectMapper.writeValueAsString(defaultLogin)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.accessToken").exists())
        .andExpect(jsonPath("$.expiresIn").exists());
  }
}

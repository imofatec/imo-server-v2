package com.imo.imoserverv2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imo.imoserverv2.contexts.shared.user_management.application.usecases.admin.register_admin.RegisterAdminRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminIntegrationTests {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  @Order(1)
  void itShouldCreateAdmin() throws Exception {
    var registerPayload = new RegisterAdminRequest(
        "admin@admin.com",
        "admin",
        "senha123",
        20
    );

    this.mockMvc.perform(
            post("/api/admin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerPayload)))
        .andDo(print())
        .andExpect(status().isCreated());
  }
}

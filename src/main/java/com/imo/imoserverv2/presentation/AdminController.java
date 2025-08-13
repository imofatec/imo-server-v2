package com.imo.imoserverv2.presentation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Admin")
@RequestMapping("/api/admin")
public abstract class AdminController {
}

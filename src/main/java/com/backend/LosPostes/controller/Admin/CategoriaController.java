package com.backend.LosPostes.controller.Admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class CategoriaController {
    @GetMapping("/hola")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("¡Hola! Bienvenido a la API");
    }
}

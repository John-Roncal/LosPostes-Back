package com.backend.LosPostes.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;
    
    @PostMapping("/registrar")
    public ResponseEntity<AuthResponse> registrar(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.registrar(request));
    }
    
    @PostMapping("/autenticar")
    public ResponseEntity<AuthResponse> autenticar(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.autenticar(request));
    }
}
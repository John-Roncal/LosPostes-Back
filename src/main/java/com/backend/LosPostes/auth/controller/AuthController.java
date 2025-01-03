package com.backend.LosPostes.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.LosPostes.auth.dto.AuthResponse;
import com.backend.LosPostes.auth.dto.AuthenticationRequest;
import com.backend.LosPostes.auth.dto.RefreshTokenRequest;
import com.backend.LosPostes.auth.dto.RegisterRequest;
import com.backend.LosPostes.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@CrossOrigin
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

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(authService.refreshToken(request.getRefreshToken()));
    }
}
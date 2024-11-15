package com.backend.LosPostes.auth;

public interface AuthService {
  
    AuthResponse registrar (RegisterRequest request);

    AuthResponse autenticar (AuthenticationRequest request);
}

package com.backend.LosPostes.auth.service;

import com.backend.LosPostes.auth.dto.AuthResponse;
import com.backend.LosPostes.auth.dto.AuthenticationRequest;
import com.backend.LosPostes.auth.dto.RegisterRequest;

public interface AuthService {
  
    AuthResponse registrar (RegisterRequest request);

    AuthResponse autenticar (AuthenticationRequest request);

    AuthResponse refreshToken (String refreshToken);
}

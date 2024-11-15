package com.backend.LosPostes.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.config.JwtService;
import com.backend.LosPostes.entity.Rol;
import com.backend.LosPostes.entity.Usuario;
import com.backend.LosPostes.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse registrar(RegisterRequest request) {
        // Si no se especifica un rol, asignar ROLE_USER por defecto
        Rol userRole = (request.getRol() != null) ? request.getRol() : Rol.ROLE_USER;
        
        var user = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(userRole)
                .estado(true)
                .empleadoID(1)
                .build();
        
        userRepository.save(user);
        var jwt = jwtService.generaToken(user);
        
        return AuthResponse.builder()
                .token(jwt)
                .build();
    }

    @Override
    public AuthResponse autenticar(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        
        var user = userRepository.findUsuarioByUsername(request.getUsername()).orElseThrow();
        var jwt = jwtService.generaToken(user);
        
        return AuthResponse.builder()
                .token(jwt)
                .rol(user.getRol().name())
                .build();
    }
}

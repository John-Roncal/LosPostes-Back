package com.backend.LosPostes.auth.service;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.auth.dto.AuthResponse;
import com.backend.LosPostes.auth.dto.AuthenticationRequest;
import com.backend.LosPostes.auth.dto.RegisterRequest;
import com.backend.LosPostes.config.jwt.JwtService;
import com.backend.LosPostes.user.entity.Rol;
import com.backend.LosPostes.user.entity.Usuario;
import com.backend.LosPostes.user.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse registrar(RegisterRequest request) {
        // Si no se especifica un rol, asignar ROLE_MESERO por defecto
        Rol userRole = (request.getRol() != null) ? request.getRol() : Rol.ROLE_MESERO;

        Optional<Usuario> existingUsuario = userRepository.findUsuarioByUsername(request.getUsername());

        if (existingUsuario.isPresent()) {
            throw new RuntimeException("Ya existe un usuario con ese username");
        }
        
        var user = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(userRole)
                .estado(true)
                .empleadoID(1)
                .build();
        
        userRepository.save(user);
        
        return createAuthResponse(user);
    }

    @Override
    public AuthResponse autenticar(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getUsername(), 
                    request.getPassword()
                )
            );
            
            var user = userRepository.findUsuarioByUsername(request.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
            
            return createAuthResponse(user);
            
        } catch (AuthenticationException e) {
            log.error("Error en la autenticación para el usuario {}: {}", 
                    request.getUsername(), e.getMessage());
            throw new RuntimeException("Credenciales inválidas");
        }
    }

    @Override
    public AuthResponse refreshToken(String refreshToken) {
        try {
            final String username = jwtService.getUserName(refreshToken);
            if (username == null) {
                throw new IllegalArgumentException("Token inválido");
            }

            var user = userRepository.findUsuarioByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

            if (!jwtService.validateToken(refreshToken, user)) {
                throw new IllegalArgumentException("Refresh token expirado o inválido");
            }

            return createAuthResponse(user);
            
        } catch (Exception e) {
            log.error("Error al procesar el refresh token: {}", e.getMessage());
            throw new RuntimeException("Error al procesar el refresh token");
        }
    }

    private AuthResponse createAuthResponse(Usuario user) {
        return AuthResponse.builder()
                .token(jwtService.generaToken(user))
                .refreshToken(jwtService.generaRefreshToken(user))
                .rol(user.getRol())
                .username(user.getUsername())
                .empleadoID(user.getEmpleadoID())
                .build();
    }
}

package com.backend.LosPostes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.auth.RegisterRequest;
import com.backend.LosPostes.entity.Rol;
import com.backend.LosPostes.entity.Usuario;
import com.backend.LosPostes.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    @Autowired
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario registrar(RegisterRequest request) {
        // Si no se especifica un rol, asignar ROLE_MESERO por defecto
       Rol userRole = (request.getRol() != null) ? request.getRol() : Rol.ROLE_MESERO;
        
        var user = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .estado(true)
                .rol(userRole)
                .build();
        
        return usuarioRepository.save(user);
    }
}

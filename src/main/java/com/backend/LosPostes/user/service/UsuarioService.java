package com.backend.LosPostes.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.user.entity.Rol;
import com.backend.LosPostes.user.entity.Usuario;
import com.backend.LosPostes.user.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    @Autowired
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Usuario> getUsuario() {
        return this.usuarioRepository.findAllActivos();
    }

    public Usuario registrar(Usuario usuario) {
        // Si no se especifica un rol, asignar ROLE_MESERO por defecto
       Rol userRole = (usuario.getRol() != null) ? usuario.getRol() : Rol.ROLE_MESERO;
        
        var user = Usuario.builder()
                .username(usuario.getUsername())
                .password(passwordEncoder.encode(usuario.getPassword()))
                .estado(true)
                .rol(userRole)
                .empleadoID(usuario.getEmpleadoID())
                .build();
        
        return usuarioRepository.save(user);
    }
}

package com.backend.LosPostes.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Usuario> getUsuario() {
        return this.usuarioRepository.findAllActivos();
    }

    public Usuario registrar(Usuario usuario) {
       Rol userRole = (usuario.getRol() != null) ? usuario.getRol() : Rol.ROLE_MESERO;

    Optional<Usuario> existingUsuario = usuarioRepository.findUsuarioByUsername(usuario.getUsername());

    if (existingUsuario.isPresent()) {
        throw new RuntimeException("Ya existe un usuario con ese username");
    }
    
    var user = Usuario.builder()
            .username(usuario.getUsername())
            .password(usuario.getPassword())
            .rol(userRole)
            .estado(true)
            .empleadoID(1)
            .build();
    
        return usuarioRepository.save(user);
    }
}

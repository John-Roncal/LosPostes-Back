package com.backend.LosPostes.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.LosPostes.exception.JSend.JSendResponse;
import com.backend.LosPostes.user.entity.Usuario;
import com.backend.LosPostes.user.service.UsuarioService;

@RestController
@RequestMapping("/admin/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path="/listar")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Object> getUsuario() {
        return JSendResponse.success(usuarioService.getUsuario());
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario savedUsuario = usuarioService.registrar(usuario);
            return JSendResponse.success(savedUsuario);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }
}

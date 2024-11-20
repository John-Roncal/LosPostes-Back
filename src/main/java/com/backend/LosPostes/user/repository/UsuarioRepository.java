package com.backend.LosPostes.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.user.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findUsuarioByUsername(String username);

    @Query("SELECT u FROM Usuario u WHERE u.estado = true")
    List<Usuario> findAllActivos();
}

package com.backend.LosPostes.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.user.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findUsuarioByUsername(String username);

    @Query("SELECT u FROM Usuario u WHERE u.estado = true")
    List<Usuario> findAllActivos();

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END " +
                   "FROM Usuarios " +
                   "WHERE Username = :username AND Password = crypt(:password, Password)", 
           nativeQuery = true)
    boolean verifyPassword(@Param("username") String username, @Param("password") String password);
}

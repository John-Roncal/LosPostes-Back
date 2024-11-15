package com.backend.LosPostes.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioID") // Especifica el nombre exacto de la columna
    private Integer usuarioID; 
    
    @Column(name = "UserName", length = 20) // Especifica el nombre y longitud de la columna
    private String username;
    
    @Column(name = "Password", length = 100) 
    private String password;
    
    @Column(name = "Estado") 
    private boolean estado;

    @Column(name = "EmpleadoID")
    private Integer empleadoID;

    @Column(name = "Roles")
    private Rol rol;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }
}

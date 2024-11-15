package com.backend.LosPostes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.LosPostes.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    Optional<Cliente> findClienteByNombre(String nombre);
}

package com.backend.LosPostes.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.data.model.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    Optional<Cliente> findClienteByDni(String dni);

    @Query("SELECT c FROM Cliente c WHERE c.estado = true")
    List<Cliente> findAllActivos();
}

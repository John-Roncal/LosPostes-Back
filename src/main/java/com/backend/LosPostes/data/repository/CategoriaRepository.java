package com.backend.LosPostes.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.data.model.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    Optional<Categoria> findCategoriaByNombre(String nombre);

    @Query("SELECT c FROM Categoria c WHERE c.estado = true")
    List<Categoria> findAllActivos();
}

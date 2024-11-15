package com.backend.LosPostes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.LosPostes.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    Optional<Categoria> findCategoriaByNombre(String nombre);

}

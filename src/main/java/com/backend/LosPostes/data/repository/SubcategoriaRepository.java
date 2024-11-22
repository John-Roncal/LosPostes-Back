package com.backend.LosPostes.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.data.model.entity.SubCategoria;

@Repository
public interface SubcategoriaRepository extends JpaRepository<SubCategoria, Integer> {
    Optional<SubCategoria> findSubcategoriaByNombre(String nombre);
    
    List<SubCategoria> findByEstadoTrue();  
} 
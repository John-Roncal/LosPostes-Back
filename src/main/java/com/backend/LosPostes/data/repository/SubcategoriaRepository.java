package com.backend.LosPostes.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.LosPostes.data.model.entity.Subcategoria;
import java.util.List;

public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Integer> {
    List<Subcategoria> findByEstadoTrue();
} 
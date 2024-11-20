package com.backend.LosPostes.data.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.data.model.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    @Query("SELECT p FROM Producto p WHERE p.estado = true")
    List<Producto> findAllActivos();
}

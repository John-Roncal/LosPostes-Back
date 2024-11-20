package com.backend.LosPostes.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.data.model.entity.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer>{
    @Query("SELECT m FROM Mesa m WHERE m.estado = true")
    List<Mesa> findAllActivos();
}

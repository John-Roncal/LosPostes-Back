package com.backend.LosPostes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.entity.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer>{
    @Query("SELECT m FROM Mesa m WHERE m.estado = true")
    List<Mesa> findAllActivos();
}

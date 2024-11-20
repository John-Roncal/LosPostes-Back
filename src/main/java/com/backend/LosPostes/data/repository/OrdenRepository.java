package com.backend.LosPostes.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.data.model.entity.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer>{
    
}
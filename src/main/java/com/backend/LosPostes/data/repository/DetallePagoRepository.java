package com.backend.LosPostes.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.data.model.entity.DetallePago;

@Repository
public interface DetallePagoRepository extends JpaRepository<DetallePago, Integer>{
    
}

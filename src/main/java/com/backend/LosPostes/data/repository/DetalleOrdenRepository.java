package com.backend.LosPostes.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<com.backend.LosPostes.data.model.entity.DetalleOrden, Integer>{

}

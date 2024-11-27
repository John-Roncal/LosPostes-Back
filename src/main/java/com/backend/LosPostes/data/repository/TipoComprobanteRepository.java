package com.backend.LosPostes.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.data.model.entity.TipoComprobante;

@Repository
public interface TipoComprobanteRepository extends JpaRepository<TipoComprobante, Integer>{
    Optional<TipoComprobante> findTipoComprobanteByNombre(String nombre);
    
    List<TipoComprobante> findByEstadoTrue(); 
}
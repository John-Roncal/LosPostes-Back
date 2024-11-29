package com.backend.LosPostes.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.data.model.entity.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer>{
    @Query("SELECT o FROM Orden o WHERE o.mesaID = :mesaid AND o.condicion = 'Atendiendo'")
    Optional<Orden> findOrdenByMesaCondicion(@Param("mesaid")Integer mesaid);
}
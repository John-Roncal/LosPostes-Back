package com.backend.LosPostes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.LosPostes.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
    @Query("SELECT e FROM Empleado e WHERE e.estado = true")
    List<Empleado> findAllActivos();
}

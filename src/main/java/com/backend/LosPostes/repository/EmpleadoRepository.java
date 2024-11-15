package com.backend.LosPostes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.LosPostes.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

}

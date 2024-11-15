package com.backend.LosPostes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.LosPostes.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}

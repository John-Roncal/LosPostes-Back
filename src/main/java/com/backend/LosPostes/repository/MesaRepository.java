package com.backend.LosPostes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.LosPostes.entity.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer>{

}

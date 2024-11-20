package com.backend.LosPostes.data.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "subcategoria")
public class Subcategoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subcategoriaID;
    
    private String nombre;
    
    private String descripcion;
    
    private Boolean estado = true;

    private Integer categoriaID;
} 
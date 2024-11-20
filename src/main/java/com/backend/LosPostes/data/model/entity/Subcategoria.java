package com.backend.LosPostes.data.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "subcategorias")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subcategoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subcategoriaID;
    
    private String nombre;
    
    private String descripcion;
    
    private Boolean estado;

    private Integer categoriaID;
} 
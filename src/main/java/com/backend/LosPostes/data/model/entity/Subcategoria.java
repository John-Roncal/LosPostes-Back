package com.backend.LosPostes.data.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subcategoria")
public class Subcategoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    
    private Double precio;
    
    private Boolean estado = true;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
} 
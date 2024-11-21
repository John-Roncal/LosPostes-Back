package com.backend.LosPostes.data.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Categoria { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoriaID")
    private Integer categoriaID;
    
    @Column(name = "Nombre", length = 50)
    private String nombre;
    
    @Column(name = "Descripcion") 
    private String descripcion;

    @Column(name = "Estado") 
    private boolean estado;
}
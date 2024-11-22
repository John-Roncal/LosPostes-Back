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
@Table(name = "categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Categoria { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoriaid")
    private Integer categoriaID;
    
    @Column(name = "nombre", length = 50)
    private String nombre;
    
    @Column(name = "descripcion") 
    private String descripcion;

    @Column(name = "estado") 
    private boolean estado;
}
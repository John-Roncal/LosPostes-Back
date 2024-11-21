package com.backend.LosPostes.data.model.entity;

import jakarta.persistence.Column;
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
@Table(name = "SubCategorias")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subcategoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubCategoriaID")
    private Integer subcategoriaID;

    @Column(name = "Nombre", length=50)
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Estado")
    private Boolean estado;

    @Column(name = "Categorias_CategoriaID")
    private Integer categoriaID;
} 
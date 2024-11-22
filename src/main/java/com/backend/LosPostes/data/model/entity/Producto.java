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

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productoid")
    private Integer productoID;
    
    @Column(name = "nombre", length = 100)
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio") 
    private Double precio;

    @Column(name = "subcategorias_subcategoriaid") 
    private Integer subcategoriaID;

    @Column(name = "estado")
    private boolean estado;
}

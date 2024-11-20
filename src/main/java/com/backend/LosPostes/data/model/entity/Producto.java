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
@Table(name = "Productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductoID") // Especifica el nombre exacto de la columna
    private Integer productoID;
    
    @Column(name = "Nombre", length = 100) // Especifica el nombre y longitud de la columna
    private String nombre;
    
    @Column(name = "Descripcion") 
    private String descripcion;

    @Column(name = "Precio") 
    private float precio;

    @Column(name = "CategoriaID") 
    private Integer categoriaID;

    @Column(name = "Estado") 
    private boolean estado;
}

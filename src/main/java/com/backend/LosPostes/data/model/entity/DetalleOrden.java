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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "detalleordenes")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalleordenid")
    private Integer detalleOrdenId;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "subtotal")
    private Double subTotal;
    
    @Column(name = "comentario")
    private String comentario;
    
    @Column(name = "productos_productoid")
    private Integer productoID;
    
    @Column(name = "ordenes_ordenid")
    private Integer ordenID;
}
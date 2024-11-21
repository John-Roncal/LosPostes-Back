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
@Table(name = "DetalleOrdenes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DetalleOrdenID")
    private Integer ordenDetalleID;
    
    @Column(name = "Productos_ProductoID") 
    private Integer productoID;

    @Column(name = "Cantidad") 
    private Integer cantidad;

    @Column(name = "SubTotal") 
    private Double subTotal;

    @Column(name = "Comentario") 
    private String comentario;

    @Column(name = "Ordenes_OrdenID") 
    private Integer ordenID;
}

package com.backend.LosPostes.data.model.entity;

import java.time.LocalDateTime;

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
@Table(name = "ordenes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordenid")
    private Integer ordenID;
    
    @Column(name = "fechaorden")
    private LocalDateTime fecha;
    
    @Column(name = "condicion", length=20) 
    private String condicion;

    @Column(name = "montototal") 
    private Double montoTotal;

    @Column(name = "empleados_empleadoid") 
    private Integer empleadoID;

    @Column(name = "mesas_mesaid") 
    private Integer mesaID;
}

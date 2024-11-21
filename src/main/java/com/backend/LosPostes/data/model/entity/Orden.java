package com.backend.LosPostes.data.model.entity;

import java.sql.Date;

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
@Table(name = "Ordenes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrdenID")
    private Integer ordenID;
    
    @Column(name = "FechaOrden")
    private Date fecha;
    
    @Column(name = "Condicion", length=20) 
    private String condicion;

    @Column(name = "MontoTotal") 
    private Double montoTotal;

    @Column(name = "Empleados_EmpleadoID") 
    private Integer empleadoID;

    @Column(name = "Mesas_MesaID") 
    private Integer mesaID;
}

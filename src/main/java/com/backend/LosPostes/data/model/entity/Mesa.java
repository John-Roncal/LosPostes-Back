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
@Table(name = "Mesas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MesaID")
    private Integer mesaID;
    
    @Column(name = "Numero")
    private int numero;
    
    @Column(name = "Capacidad")
    private Integer capacidad;

    @Column(name = "Condicion", length= 20) 
    private String condicion;

    @Column(name = "Estado") 
    private Boolean estado;
}
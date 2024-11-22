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
@Table(name = "mesas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mesaid")
    private Integer mesaID;
    
    @Column(name = "numero")
    private int numero;
    
    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "condicion", length= 20) 
    private String condicion;

    @Column(name = "estado") 
    private Boolean estado;
}

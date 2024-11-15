package com.backend.LosPostes.entity;

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
    @Column(name = "MesaID") // Especifica el nombre exacto de la columna
    private Integer mesaID;
    
    @Column(name = "Numero")
    private int numero;
    
    @Column(name = "Capacidad")
    private int capacidad;

    @Column(name = "Estado", length= 20) 
    private String estado;
}

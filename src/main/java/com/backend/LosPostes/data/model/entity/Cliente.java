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
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clienteif")
    private Integer clienteID;
    
    @Column(name = "dni", length = 8)
    private String dni;
    
    @Column(name = "nombre", length = 50) 
    private String nombre;

    @Column(name = "apellido", length = 50) 
    private String apellido;

    @Column(name = "telefono", length = 9)
    private String telefono;

    @Column(name = "estado") 
    private boolean estado;
}

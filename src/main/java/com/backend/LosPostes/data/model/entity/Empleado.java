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
@Table(name = "empleados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleadoid")
    private Integer empleadoID;
    
    @Column(name = "dni", length = 8)
    private String dni;
    
    @Column(name = "nombre", length = 50) 
    private String nombre;

    @Column(name = "apellido", length = 50) 
    private String apellido;

    @Column(name = "cargo", length = 20)
    private String cargo;

    @Column(name = "estado") 
    private boolean estado;
}

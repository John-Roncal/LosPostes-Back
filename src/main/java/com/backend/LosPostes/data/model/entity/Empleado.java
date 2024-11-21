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
@Table(name = "Empleados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpleadoID")
    private Integer empleadoID;
    
    @Column(name = "DNI", length = 8)
    private String dni;
    
    @Column(name = "Nombre", length = 50) 
    private String nombre;

    @Column(name = "Apellido", length = 50) 
    private String apellido;

    @Column(name = "Cargo", length = 20)
    private String cargo;

    @Column(name = "Estado") 
    private boolean estado;
}

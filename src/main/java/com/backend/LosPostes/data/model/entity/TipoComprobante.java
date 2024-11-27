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
@Table(name = "tipocomprobantes")
public class TipoComprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipocomprobanteid")
    private Integer tipoComprobanteId;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "requiereidentificacion")
    private Boolean requiereId;

    @Column(name = "estado")
    private Boolean estado;
}

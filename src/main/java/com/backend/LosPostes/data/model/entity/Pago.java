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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pagoid")
    private Integer pagoId;
    
    @Column(name = "fechapago")
    private LocalDateTime fecha;
    
    @Column(name = "estadopago", length=20)
    private String estadoPago;

    @Column(name = "ordenes_ordenid")
    private Integer ordenID;

    @Column(name = "tipocomprobantes_tipocomprobanteid")
    private Integer tipocomprobanteID;
}
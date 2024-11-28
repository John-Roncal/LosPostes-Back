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
@Table(name = "detallepagos")
public class DetallePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detallepagoid")
    private Integer detallePagoId;

    @Column(name = "cliente_tipodocumento", length=3)
    private String tipoDoc;

    @Column(name = "cliente_numerodocumento", length=11)
    private String numeroDoc;

    @Column(name = "izipay_comprobante", length=20)
    private String iziPay;
    
    @Column(name = "subtotal")
    private Double subTotal;
    
    @Column(name = "igv")
    private Double igv;

    @Column(name = "total")
    private Double total;

    @Column(name = "pagos_pagoid")
    private Integer pagoID;
}

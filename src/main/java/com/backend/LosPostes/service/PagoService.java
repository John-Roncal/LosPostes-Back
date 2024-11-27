package com.backend.LosPostes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.data.model.entity.Pago;
import com.backend.LosPostes.data.repository.PagoRepository;


@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> getPago() {
        return this.pagoRepository.findAll();
    }
    
    public Pago newPago(Pago pago) {

        var nuevoPago = Pago.builder()
            .fecha(LocalDateTime.now())
            .estadoPago(pago.getEstadoPago())
            .ordenID(pago.getOrdenID())
            .tipocomprobanteID(pago.getTipocomprobanteID())
            .build();
        return pagoRepository.save(nuevoPago);
    }

    public Pago updatePagoEstado(Pago pago) {
        Optional<Pago> existingPago = pagoRepository.findById(pago.getPagoId());
        if (existingPago.isEmpty()) {
            throw new RuntimeException("No se encontró el pago a actualizar");
        }

        Pago updatedPago = existingPago.get();
        updatedPago.setEstadoPago(pago.getEstadoPago());
        return pagoRepository.save(updatedPago);
    }
}

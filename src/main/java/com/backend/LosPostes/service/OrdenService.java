package com.backend.LosPostes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.data.model.entity.Orden;
import com.backend.LosPostes.data.repository.OrdenRepository;

@Service
public class OrdenService{
    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> getOrden() {
        return this.ordenRepository.findAll();
    }
    
    public Orden newOrden(Orden orden) {

        var nuevoOrden = Orden.builder()
            .fecha(LocalDateTime.now())
            .condicion(orden.getCondicion())
            .montoTotal(orden.getMontoTotal())
            .empleadoID(orden.getEmpleadoID())
            .mesaID(orden.getMesaID())
            .build();
        return ordenRepository.save(nuevoOrden);
    }

    public Orden updateOrden(Orden orden) {
        Optional<Orden> existingOrden = ordenRepository.findById(orden.getOrdenID());
        if (existingOrden.isEmpty()) {
            throw new RuntimeException("No se encontró el orden a actualizar");
        }

        Orden updatedOrden = existingOrden.get();
        updatedOrden.setCondicion(orden.getCondicion());
        updatedOrden.setMontoTotal(orden.getMontoTotal());
        updatedOrden.setEmpleadoID(orden.getEmpleadoID());
        updatedOrden.setMesaID(orden.getMesaID());

        return ordenRepository.save(updatedOrden);
    }
}

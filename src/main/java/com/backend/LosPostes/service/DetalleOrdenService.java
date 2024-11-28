package com.backend.LosPostes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.data.model.entity.DetalleOrden;
import com.backend.LosPostes.data.repository.DetalleOrdenRepository;

@Service
public class DetalleOrdenService {
    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    public List<DetalleOrden> getDetalleOrden(Integer id) {
        return this.detalleOrdenRepository.findDetalleOrdenByOrdenID(id);
    }
    
    public DetalleOrden newDetalleOrden(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    public DetalleOrden updateDetalleOrdenCondicion(DetalleOrden detalleOrden) {
        Optional<DetalleOrden> existingDetalleOrden = detalleOrdenRepository.findById(detalleOrden.getDetalleOrdenId());
        if (existingDetalleOrden.isEmpty()) {
            throw new RuntimeException("No se encontró el detalle de la orden a actualizar");
        }

        DetalleOrden updatedDetalleOrden = existingDetalleOrden.get();
        updatedDetalleOrden.setCondicion(detalleOrden.getCondicion());
        return detalleOrdenRepository.save(updatedDetalleOrden);
    }
}

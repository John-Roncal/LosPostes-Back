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

    public List<DetalleOrden> getDetalleOrden() {
        return this.detalleOrdenRepository.findAll();
    }
    
    public DetalleOrden newDetalleOrden(DetalleOrden detalleOrden) {

        var nuevoDetalleOrden = DetalleOrden.builder()
            .cantidad(detalleOrden.getCantidad())
            .subTotal(detalleOrden.getSubTotal())
            .comentario(detalleOrden.getComentario())
            .condicion(detalleOrden.getCondicion())
            .productoID(detalleOrden.getProductoID())
            .ordenID(detalleOrden.getOrdenID())
            .build();
        return detalleOrdenRepository.save(nuevoDetalleOrden);
    }

    public DetalleOrden updateDetalleOrdenCondicion(DetalleOrden detalleOrden) {
        Optional<DetalleOrden> existingDetalleOrden = detalleOrdenRepository.findById(detalleOrden.getDetalleOrdenId());
        if (existingDetalleOrden.isEmpty()) {
            throw new RuntimeException("No se encontró el DetalleOrden a actualizar");
        }

        DetalleOrden updatedDetalleOrden = existingDetalleOrden.get();
        updatedDetalleOrden.setCondicion(detalleOrden.getCondicion());
        return detalleOrdenRepository.save(updatedDetalleOrden);
    }
}

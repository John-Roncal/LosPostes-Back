package com.backend.LosPostes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.data.model.entity.TipoComprobante;
import com.backend.LosPostes.data.repository.TipoComprobanteRepository;


@Service
public class TipoComprobanteService {
    @Autowired
    private TipoComprobanteRepository tipocomprobanteRepository;
    
    public List<TipoComprobante> getTipoComprobante() {
        return tipocomprobanteRepository.findByEstadoTrue();
    }
    
    public TipoComprobante newTipoComprobante(TipoComprobante tipocomprobante) {
        Optional<TipoComprobante> existingTipocomprobante = tipocomprobanteRepository.findTipoComprobanteByNombre(tipocomprobante.getNombre());

        if (existingTipocomprobante.isPresent() && tipocomprobante.getTipoComprobanteId() == null) {
            throw new RuntimeException("Ya existe un tipo de comprobante con ese nombre");
        }

        var nuevoTipocomprobante = TipoComprobante.builder()
            .nombre(tipocomprobante.getNombre())
            .requiereId(tipocomprobante.getRequiereId())
            .estado(true)
            .build();

        return tipocomprobanteRepository.save(nuevoTipocomprobante);
    }
    
    public TipoComprobante updateTipoComprobante(TipoComprobante tipocomprobante) {
        if (!tipocomprobanteRepository.existsById(tipocomprobante.getTipoComprobanteId())) {
            throw new RuntimeException("Tipo de comprobante no encontrado");
        }
        return tipocomprobanteRepository.save(tipocomprobante);
    }
    
    public void disableTipoComprobante(Integer id) {
        TipoComprobante tipocomprobante = tipocomprobanteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tipo de comprobante no encontrado"));
            tipocomprobante.setEstado(false);
            tipocomprobanteRepository.save(tipocomprobante);
    }
}

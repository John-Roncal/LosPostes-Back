package com.backend.LosPostes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.data.model.entity.DetallePago;
import com.backend.LosPostes.data.repository.DetallePagoRepository;

@Service
public class DetallePagoService {
    @Autowired
    private DetallePagoRepository detallePagoRepository;

    public List<DetallePago> getDetallePago() {
        return this.detallePagoRepository.findAll();
    }
    
    public DetallePago newDetallePago(DetallePago detallePago) {

        var nuevoDetallePago = DetallePago.builder()
            .detallePagoId(detallePago.getDetallePagoId())
            .subTotal(detallePago.getSubTotal())
            .IGV(detallePago.getIGV())
            .total(detallePago.getTotal())
            .pagoID(detallePago.getPagoID())
            .build();
        return detallePagoRepository.save(nuevoDetallePago);
    }
}

package com.backend.LosPostes.controller.Mozo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.LosPostes.data.model.entity.DetalleOrden;
import com.backend.LosPostes.exception.JSend.JSendResponse;
import com.backend.LosPostes.service.DetalleOrdenService;

@RestController
@RequestMapping("/mozo/detalleOrden")
@CrossOrigin
public class DetalleOrdenController {
    @Autowired
    private DetalleOrdenService detalleOrdenService;

    @GetMapping(path="/listar")
    @PreAuthorize("hasAnyRole('MESERO')")
    public ResponseEntity<Object> getDetalleOrdenes() {
        return JSendResponse.success(detalleOrdenService.getDetalleOrden());
    }

    @PostMapping(path="/guardar")
    @PreAuthorize("hasRole('MESERO')")
    public ResponseEntity<Object> registrarDetalleOrden(@RequestBody DetalleOrden detalleOrden) {
        try {
            DetalleOrden savedDetalleOrden = detalleOrdenService.newDetalleOrden(detalleOrden);
            return JSendResponse.success(savedDetalleOrden);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/actualizar")
    @PreAuthorize("hasRole('MESERO')")
    public ResponseEntity<Object> actualizarDetalleOrden(@RequestBody DetalleOrden detalleOrden) {
        try {
            DetalleOrden updatedDetalleOrden = detalleOrdenService.updateDetalleOrden(detalleOrden);
            return JSendResponse.success(updatedDetalleOrden);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }
}

package com.backend.LosPostes.controller.Mozo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.LosPostes.data.model.entity.Orden;
import com.backend.LosPostes.exception.JSend.JSendResponse;
import com.backend.LosPostes.service.OrdenService;

@RestController
@RequestMapping("/mozo/orden")
@CrossOrigin
public class OrdenController {
    @Autowired
    private OrdenService ordenService;

    @GetMapping(path="/listar")
    public ResponseEntity<Object> getOrdenes() {
        return JSendResponse.success(ordenService.getOrden());
    }

    @GetMapping(path="/obtenerOrden/{mesaId}")
    public ResponseEntity<Object> getOrdenMesaCondicion(@PathVariable("mesaId") Integer mesaid) {
        return JSendResponse.success(ordenService.getOrdenMesaCondicion(mesaid));
    }

    @PostMapping(path="/guardar")
    @PreAuthorize("hasRole('MESERO')")
    public ResponseEntity<Object> registrarOrden(@RequestBody Orden orden) {
        try {
            Orden savedOrden = ordenService.newOrden(orden);
            return JSendResponse.success(savedOrden);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/actualizar")
    public ResponseEntity<Object> actualizarOrden(@RequestBody Orden orden) {
        try {
            Orden updatedOrden = ordenService.updateOrden(orden);
            return JSendResponse.success(updatedOrden);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }
}
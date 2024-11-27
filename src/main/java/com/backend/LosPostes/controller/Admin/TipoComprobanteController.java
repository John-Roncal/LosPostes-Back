package com.backend.LosPostes.controller.Admin;

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

import com.backend.LosPostes.data.model.entity.TipoComprobante;
import com.backend.LosPostes.exception.JSend.JSendResponse;
import com.backend.LosPostes.service.TipoComprobanteService;

@RestController
@RequestMapping("/admin/tipocomprobante")
@CrossOrigin
public class TipoComprobanteController {
    @Autowired
    private TipoComprobanteService tipocomprobanteService;

    @GetMapping(path="/listar")
    public ResponseEntity<Object> getTipoComprobante() {
        return JSendResponse.success(tipocomprobanteService.getTipoComprobante());
    }

    @PostMapping(path="/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> registrarTipoComprobante(@RequestBody TipoComprobante tipocomprobante) {
        try {
            TipoComprobante savedTipoComprobante = tipocomprobanteService.newTipoComprobante(tipocomprobante);
            return JSendResponse.success(savedTipoComprobante);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> actualizarSubcategoria(@RequestBody TipoComprobante tipocomprobante) {
        try {
            TipoComprobante updatedTipoComprobante = tipocomprobanteService.updateTipoComprobante(tipocomprobante);
            return JSendResponse.success(updatedTipoComprobante);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @GetMapping(path="/inhabilitar/{tipocomprobanteId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> inhabilitarTipoComprobante(@PathVariable("tipocomprobanteId") Integer id) {
        try {
            tipocomprobanteService.disableTipoComprobante(id);
            return JSendResponse.success("Tipo de comprobante inhabilitado");
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }
}

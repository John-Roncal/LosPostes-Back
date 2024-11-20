package com.backend.LosPostes.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.LosPostes.data.model.entity.Mesa;
import com.backend.LosPostes.exception.JSend.JSendResponse;
import com.backend.LosPostes.service.MesaService;

@RestController
@RequestMapping("/admin/mesa")
public class MesaController {
    @Autowired
    private MesaService mesaService;

    @GetMapping(path="/listar")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Object> getMesa() {
        return JSendResponse.success(mesaService.getMesa());
    }

    @PostMapping(path="/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> registrarMesa(@RequestBody Mesa mesa) {
        try {
            Mesa savedMesa = mesaService.newMesa(mesa);
            return JSendResponse.success(savedMesa);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> actualizarMesa(@RequestBody Mesa mesa) {
        try {
            Mesa updatedMesa = mesaService.updateMesa(mesa);
            return JSendResponse.success(updatedMesa);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/condicion")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> actualizarCondicion(@RequestBody Mesa mesa) {
        try {
            Mesa updatedMesa = mesaService.updateCondicion(mesa.getMesaID(), mesa.getCondicion());
            return JSendResponse.success(updatedMesa);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @GetMapping(path="/inhabilitar/{mesaId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> inhabilitarMesa(@PathVariable("mesaId") Integer id) {
        try {
            mesaService.disableMesa(id);
            return JSendResponse.success("Mesa Inhabilitado");
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }
}

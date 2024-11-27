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

import com.backend.LosPostes.data.model.entity.DetallePago;
import com.backend.LosPostes.exception.JSend.JSendResponse;
import com.backend.LosPostes.service.DetallePagoService;

@RestController
@RequestMapping("/mozo/detallePago")
@CrossOrigin
public class DetallePagoController {
    @Autowired
    private DetallePagoService detallePagoService;

    @GetMapping(path="/listar")
    public ResponseEntity<Object> getDetallePago() {
        return JSendResponse.success(detallePagoService.getDetallePago());
    }

    @PostMapping(path="/guardar")
    @PreAuthorize("hasRole('MESERO')")
    public ResponseEntity<Object> registrarDetallePago(@RequestBody DetallePago detallePago) {
        try {
            DetallePago savedDetallePago = detallePagoService.newDetallePago(detallePago);
            return JSendResponse.success(savedDetallePago);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }
}

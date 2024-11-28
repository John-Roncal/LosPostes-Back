package com.backend.LosPostes.controller.Mozo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.LosPostes.data.model.entity.Pago;
import com.backend.LosPostes.exception.JSend.JSendResponse;
import com.backend.LosPostes.service.PagoService;

@RestController
@RequestMapping("/mozo/pago")
@CrossOrigin
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @GetMapping(path="/listar")
    public ResponseEntity<Object> getPago() {
        return JSendResponse.success(pagoService.getPago());
    }

    @PostMapping(path="/guardar")
    public ResponseEntity<Object> registrarPago(@RequestBody Pago pago) {
        try {
            Pago savedPago = pagoService.newPago(pago);
            return JSendResponse.success(savedPago);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/actualizar")
    public ResponseEntity<Object> actualizarPagoEstado(@RequestBody Pago pago) {
        try {
            Pago updatedPago = pagoService.updatePagoEstado(pago);
            return JSendResponse.success(updatedPago);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }
}

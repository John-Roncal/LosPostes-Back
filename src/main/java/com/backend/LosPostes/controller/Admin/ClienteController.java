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

import com.backend.LosPostes.JSend.JSendResponse;
import com.backend.LosPostes.entity.Cliente;
import com.backend.LosPostes.service.ClienteService;

@RestController
@RequestMapping("/admin/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping(path="/listar")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Object> getCliente() {
        return JSendResponse.success(clienteService.getCliente());
    }

    @PostMapping(path="/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> registrarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente savedCliente = clienteService.newCliente(cliente);
            return JSendResponse.success(savedCliente);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> actualizarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente updatedCliente = clienteService.updateCliente(cliente);
            return JSendResponse.success(updatedCliente);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/inhabilitar/{clienteId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> inhabilitarCliente(@PathVariable("clienteId") Integer id) {
        try {
            clienteService.disableCliente(id);
            return JSendResponse.success("Cliente Inhabilitado");
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }
}

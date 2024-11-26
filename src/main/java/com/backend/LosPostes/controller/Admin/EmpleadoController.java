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

import com.backend.LosPostes.data.model.entity.Empleado;
import com.backend.LosPostes.exception.JSend.JSendResponse;
import com.backend.LosPostes.service.EmpleadoService;

@RestController
@RequestMapping("/admin/empleado")
@CrossOrigin
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping(path="/listar")
    public ResponseEntity<Object> getEmpleado() {
        return JSendResponse.success(empleadoService.getEmpleado());
    }

    @PostMapping(path="/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> registrarempleado(@RequestBody Empleado empleado) {
        try {
            Empleado savedEmpleado = empleadoService.newEmpleado(empleado);
            return JSendResponse.success(savedEmpleado);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> actualizarEmpleado(@RequestBody Empleado empleado) {
        try {
            Empleado updatedEmpleado = empleadoService.updateEmpleado(empleado);
            return JSendResponse.success(updatedEmpleado);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @GetMapping(path="/inhabilitar/{empleadoId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> inhabilitarEmpleado(@PathVariable("empleadoId") Integer id) {
        try {
            empleadoService.disableEmpleado(id);
            return JSendResponse.success("Empleado Inhabilitado");
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }
}

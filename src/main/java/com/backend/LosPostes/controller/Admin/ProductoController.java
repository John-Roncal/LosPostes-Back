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

import com.backend.LosPostes.data.model.entity.Producto;
import com.backend.LosPostes.exception.JSend.JSendResponse;
import com.backend.LosPostes.service.ProductoService;

@RestController
@RequestMapping("/admin/producto")
@CrossOrigin
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping(path="/listar")
    public ResponseEntity<Object> getProducto() {
        return JSendResponse.success(productoService.getProducto());
    }

    @PostMapping(path="/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> registrarProducto(@RequestBody Producto producto) {
        try {
            Producto savedProducto = productoService.newProducto(producto);
            return JSendResponse.success(savedProducto);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> actualizarProducto(@RequestBody Producto producto) {
        try {
            Producto updatedProducto = productoService.updateProducto(producto);
            return JSendResponse.success(updatedProducto);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @GetMapping(path="/inhabilitar/{productoId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> inhabilitarProducto(@PathVariable("productoId") Integer id) {
        try {
            productoService.disableProducto(id);
            return JSendResponse.success("Producto inhabilitado");
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }   
}

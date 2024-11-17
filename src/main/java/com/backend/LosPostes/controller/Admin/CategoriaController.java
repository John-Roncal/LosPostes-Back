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

import com.backend.LosPostes.JSend.JSendResponse;
import com.backend.LosPostes.entity.Categoria;
import com.backend.LosPostes.service.CategoriaService;

@RestController
@RequestMapping("/admin/categoria")
@CrossOrigin(origins = "http://localhost:4200")

public class CategoriaController {
    
   @Autowired
    private CategoriaService categoriaService;

    @GetMapping(path="/listar")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Object> getCategoria() {
        return JSendResponse.success(categoriaService.getCategoria());
    }

    @PostMapping(path="/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> registrarCategoria(@RequestBody Categoria categoria) {
        try {
            Categoria savedCategoria = categoriaService.newCategoria(categoria);
            return JSendResponse.success(savedCategoria);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> actualizarCategoria(@RequestBody Categoria categoria) {
        try {
            Categoria updatedCategoria = categoriaService.updateCategoria(categoria);
            return JSendResponse.success(updatedCategoria);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/inhabilitar/{categoriaId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> inhabilitarCategoria(@PathVariable("categoriaId") Integer id) {
        try {
            categoriaService.disableCategoria(id);
            return JSendResponse.success("Categoria inhabilitada");
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }   
}

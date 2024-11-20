package com.backend.LosPostes.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.backend.LosPostes.data.model.entity.Subcategoria;
import com.backend.LosPostes.exception.JSend.JSendResponse;
import com.backend.LosPostes.service.SubcategoriaService;

@RestController
@RequestMapping("/admin/subcategoria")
@CrossOrigin
public class SubcategoriaController {
    
    @Autowired
    private SubcategoriaService subcategoriaService;

    @GetMapping(path="/listar")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Object> getSubcategorias() {
        return JSendResponse.success(subcategoriaService.getSubcategorias());
    }

    @PostMapping(path="/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> registrarSubcategoria(@RequestBody Subcategoria subcategoria) {
        try {
            Subcategoria savedSubcategoria = subcategoriaService.newSubcategoria(subcategoria);
            return JSendResponse.success(savedSubcategoria);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> actualizarSubcategoria(@RequestBody Subcategoria subcategoria) {
        try {
            Subcategoria updatedSubcategoria = subcategoriaService.updateSubcategoria(subcategoria);
            return JSendResponse.success(updatedSubcategoria);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @GetMapping(path="/inhabilitar/{subcategoriaId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> inhabilitarSubcategoria(@PathVariable("subcategoriaId") Integer id) {
        try {
            subcategoriaService.disableSubcategoria(id);
            return JSendResponse.success("Subcategoria inhabilitada");
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }
} 
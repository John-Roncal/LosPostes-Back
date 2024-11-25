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

import com.backend.LosPostes.data.model.entity.SubCategoria;
import com.backend.LosPostes.exception.JSend.JSendResponse;
import com.backend.LosPostes.service.SubcategoriaService;

@RestController
@RequestMapping("/admin/subcategoria")
@CrossOrigin
public class SubcategoriaController {
    
    @Autowired
    private SubcategoriaService subcategoriaService;

    @GetMapping(path="/listar")
    @PreAuthorize("hasAnyRole('ADMIN', 'MESERO')")
    public ResponseEntity<Object> getSubcategorias() {
        return JSendResponse.success(subcategoriaService.getSubcategorias());
    }

    @PostMapping(path="/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> registrarSubcategoria(@RequestBody SubCategoria subcategoria) {
        try {
            SubCategoria savedSubcategoria = subcategoriaService.newSubcategoria(subcategoria);
            return JSendResponse.success(savedSubcategoria);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PostMapping(path="/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> actualizarSubcategoria(@RequestBody SubCategoria subcategoria) {
        try {
            SubCategoria updatedSubcategoria = subcategoriaService.updateSubcategoria(subcategoria);
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
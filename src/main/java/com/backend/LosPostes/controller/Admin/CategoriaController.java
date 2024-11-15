package com.backend.LosPostes.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.LosPostes.service.CategoriaService;

@RestController
@RequestMapping("/admin")
public class CategoriaController {
    
   // @Autowired
    //private CategoriaService categoriaService;

    
    /*
    @GetMapping(path="/listar")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Object> getcategorias() {
        return JSendResponse.success(categoriaService.getCategoria());
    }
     * @PostMapping(path="/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> registrarcategoriao(@RequestBody categoria categoria) {
        try {
            categoria savedcategoria = categoriaService.newcategoria(categoria);
            return JSendResponse.success(savedcategoria);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @PutMapping(path="/actualizar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> actualizarcategoriao(@RequestBody categoria categoria) {
        try {
            categoria updatedcategoria = categoriaService.updatecategoria(categoria);
            return JSendResponse.success(updatedcategoria);
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }

    @DeleteMapping(path="/eliminar/{categoriaId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> eliminar(@PathVariable("categoriaId") long id) {
        try {
            categoriaService.deletecategoria(id);
            return JSendResponse.success("categoriao eliminado");
        } catch (Exception e) {
            return JSendResponse.error(e.getMessage());
        }
    }
     */
    
}

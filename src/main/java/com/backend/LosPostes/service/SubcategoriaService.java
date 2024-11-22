package com.backend.LosPostes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.data.model.entity.SubCategoria;
import com.backend.LosPostes.data.repository.SubcategoriaRepository;


@Service
public class SubcategoriaService {
    
    @Autowired
    private SubcategoriaRepository subcategoriaRepository;
    
    public List<SubCategoria> getSubcategorias() {
        return subcategoriaRepository.findByEstadoTrue();
    }
    
    public SubCategoria newSubcategoria(SubCategoria subcategoria) {
        Optional<SubCategoria> existingSubcategoria = subcategoriaRepository.findSubcategoriaByNombre(subcategoria.getNombre());

        if (existingSubcategoria.isPresent() && subcategoria.getSubCategoriaId() == null) {
            throw new RuntimeException("Ya existe una subcategoria con ese nombre");
        }

        var nuevaSubcategoria = SubCategoria.builder()
            .nombre(subcategoria.getNombre())
            .descripcion(subcategoria.getDescripcion())
            .estado(true)
            .categoriaID(subcategoria.getCategoriaID())
            .build();

        return subcategoriaRepository.save(nuevaSubcategoria);
    }
    
    public SubCategoria updateSubcategoria(SubCategoria subcategoria) {
        if (!subcategoriaRepository.existsById(subcategoria.getSubCategoriaId())) {
            throw new RuntimeException("Subcategoria no encontrada");
        }
        return subcategoriaRepository.save(subcategoria);
    }
    
    public void disableSubcategoria(Integer id) {
        SubCategoria subcategoria = subcategoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Subcategoria no encontrada"));
        subcategoria.setEstado(false);
        subcategoriaRepository.save(subcategoria);
    }
}
package com.backend.LosPostes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.data.model.entity.Subcategoria;
import com.backend.LosPostes.data.repository.SubcategoriaRepository;


@Service
public class SubcategoriaService {
    
    @Autowired
    private SubcategoriaRepository subcategoriaRepository;
    
    public List<Subcategoria> getSubcategorias() {
        return subcategoriaRepository.findByEstadoTrue();
    }
    
    public Subcategoria newSubcategoria(Subcategoria subcategoria) {
        Optional<Subcategoria> existingSubcategoria = subcategoriaRepository.findSubcategoriaByNombre(subcategoria.getNombre());

        if (existingSubcategoria.isPresent() && subcategoria.getSubcategoriaID() == null) {
            throw new RuntimeException("Ya existe una subcategoria con ese nombre");
        }

        var nuevaSubcategoria = Subcategoria.builder()
            .nombre(subcategoria.getNombre())
            .descripcion(subcategoria.getDescripcion())
            .estado(true)
            .categoriaID(subcategoria.getCategoriaID())
            .build();

        return subcategoriaRepository.save(nuevaSubcategoria);
    }
    
    public Subcategoria updateSubcategoria(Subcategoria subcategoria) {
        if (!subcategoriaRepository.existsById(subcategoria.getSubcategoriaID())) {
            throw new RuntimeException("Subcategoria no encontrada");
        }
        return subcategoriaRepository.save(subcategoria);
    }
    
    public void disableSubcategoria(Integer id) {
        Subcategoria subcategoria = subcategoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Subcategoria no encontrada"));
        subcategoria.setEstado(false);
        subcategoriaRepository.save(subcategoria);
    }
} 
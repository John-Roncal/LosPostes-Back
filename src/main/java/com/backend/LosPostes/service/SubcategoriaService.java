package com.backend.LosPostes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.data.model.entity.Subcategoria;
import com.backend.LosPostes.data.repository.SubcategoriaRepository;

import java.util.List;

@Service
public class SubcategoriaService {
    
    @Autowired
    private SubcategoriaRepository subcategoriaRepository;
    
    public List<Subcategoria> getSubcategorias() {
        return subcategoriaRepository.findByEstadoTrue();
    }
    
    public Subcategoria newSubcategoria(Subcategoria subcategoria) {
        return subcategoriaRepository.save(subcategoria);
    }
    
    public Subcategoria updateSubcategoria(Subcategoria subcategoria) {
        if (!subcategoriaRepository.existsById(subcategoria.getId())) {
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
package com.backend.LosPostes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.LosPostes.entity.Categoria;
import com.backend.LosPostes.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getCategoria() {
        return this.categoriaRepository.findAll();
    }

    public Categoria newCategoria(Categoria categoria) {
        Optional<Categoria> existingCategoria = categoriaRepository.findCategoriaByNombre(categoria.getNombre());

        if (existingCategoria.isPresent() && categoria.getCategoriaID() == null) {
            throw new RuntimeException("Ya existe una categoria con ese nombre");
        }

        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Categoria categoria) {
        Optional<Categoria> existingCategoria = categoriaRepository.findById(categoria.getCategoriaID());

        if (existingCategoria.isEmpty()) {
            throw new RuntimeException("No se encontró la categoria a actualizar");
        }

        Categoria updatedCategoria = existingCategoria.get();
        updatedCategoria.setNombre(categoria.getNombre());
        updatedCategoria.setDescripcion(categoria.getDescripcion());

        return categoriaRepository.save(updatedCategoria);
    }

    public void disableCategoria(Integer id) {
        Optional<Categoria> existingCategoria = categoriaRepository.findById(id);

        if (existingCategoria.isEmpty()) {
            throw new RuntimeException("No se encontró la categoria a inhabilitar");
        }
        
        Categoria updatedCategoria = existingCategoria.get();
        updatedCategoria.setEstado(false);
        categoriaRepository.save(updatedCategoria);
    }
}

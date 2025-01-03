package com.backend.LosPostes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.data.model.entity.Producto;
import com.backend.LosPostes.data.repository.ProductoRepository;
import com.backend.LosPostes.data.repository.SubcategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    public List<Producto> getProducto() {
        return this.productoRepository.findAllActivos();
    }
    
    public Producto newProducto(Producto producto) {
        if (!subcategoriaRepository.existsById(producto.getSubcategoriaID())) {
            throw new EntityNotFoundException("Subcategoria no encontrada");
        }
        var nuevoProducto = Producto.builder()
            .nombre(producto.getNombre())
            .descripcion(producto.getDescripcion())
            .precio(producto.getPrecio())
            .subcategoriaID(producto.getSubcategoriaID())
            .estado(true)
            .build();  
        return productoRepository.save(nuevoProducto);
    }

    public Producto updateProducto(Producto producto) {
        Optional<Producto> existingProducto = productoRepository.findById(producto.getProductoID());
        if (existingProducto.isEmpty()) {
            throw new RuntimeException("No se encontró el producto a actualizar");
        }

        Producto updatedProducto = existingProducto.get();
        updatedProducto.setNombre(producto.getNombre());
        updatedProducto.setDescripcion(producto.getDescripcion());
        updatedProducto.setPrecio(producto.getPrecio());
        updatedProducto.setSubcategoriaID(producto.getSubcategoriaID());

        return productoRepository.save(updatedProducto);
    }

    public void disableProducto(Integer id) {
        Optional<Producto> existingProducto = productoRepository.findById(id);

        if (existingProducto.isEmpty()) {
            throw new RuntimeException("No se encontró el producto a inhabilitar");
        }
        
        Producto updatedProducto = existingProducto.get();
        updatedProducto.setEstado(false);
        productoRepository.save(updatedProducto);
    }
}

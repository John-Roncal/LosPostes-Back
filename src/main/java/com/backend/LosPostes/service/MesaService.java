package com.backend.LosPostes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.entity.Mesa;
import com.backend.LosPostes.repository.MesaRepository;

@Service
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> getMesa() {
        return this.mesaRepository.findAll();
    }

    public Mesa newMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa updateMesa(Mesa mesa) {
        Optional<Mesa> existingMesa = mesaRepository.findById(mesa.getMesaID());
        if (existingMesa.isEmpty()) {
            throw new RuntimeException("No se encontró la mesa a actualizar");
        }

        Mesa updatedMesa = existingMesa.get();
        updatedMesa.setNumero(mesa.getNumero());
        updatedMesa.setCapacidad(mesa.getCapacidad());      

        return mesaRepository.save(updatedMesa);
    }

    public Mesa updateCondicion(Integer id, String condicion) {
        Optional<Mesa> existingMesa = mesaRepository.findById(id);
        if (existingMesa.isEmpty()) {
            throw new RuntimeException("No se encontró la mesa");
        }

        Mesa updatedMesa = existingMesa.get();
        updatedMesa.setCondicion(condicion);      

        return mesaRepository.save(updatedMesa);
    }   

    public void disableMesa(Integer id) {
        Optional<Mesa> existingMesa = mesaRepository.findById(id);

        if (existingMesa.isEmpty()) {
            throw new RuntimeException("No se encontró la mesa a inhabilitar");
        }
        
        Mesa updatedMesa = existingMesa.get();
        updatedMesa.setEstado(false);
        mesaRepository.save(updatedMesa);
    }
}

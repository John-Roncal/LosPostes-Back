package com.backend.LosPostes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.data.model.entity.Cliente;
import com.backend.LosPostes.data.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getCliente() {
        return this.clienteRepository.findAllActivos();
    }

    public Cliente newCliente(Cliente cliente) {
        Optional<Cliente> existingCliente = clienteRepository.findClienteByDni(cliente.getDni());

        if (existingCliente.isPresent() && cliente.getClienteID() == null) {
            throw new RuntimeException("Ya existe un cliente con ese DNI");
        }

        var nuevoCliente = Cliente.builder()
            .dni(cliente.getDni())
            .nombre(cliente.getNombre())
            .apellido(cliente.getApellido())
            .telefono(cliente.getTelefono())
            .estado(true)
            .build();

        return clienteRepository.save(nuevoCliente);
    }

    public Cliente updateCliente(Cliente cliente) {
        Optional<Cliente> existingCliente = clienteRepository.findById(cliente.getClienteID());

        if (existingCliente.isEmpty()) {
            throw new RuntimeException("No se encontró el cliente a actualizar");
        }

        Cliente updatedCliente = existingCliente.get();
        updatedCliente.setDni(cliente.getDni());
        updatedCliente.setNombre(cliente.getNombre());
        updatedCliente.setApellido(cliente.getApellido());
        updatedCliente.setTelefono(cliente.getTelefono());

        return clienteRepository.save(updatedCliente);
    }

    public void disableCliente(Integer id) {
        Optional<Cliente> existingCliente = clienteRepository.findById(id);

        if (existingCliente.isEmpty()) {
            throw new RuntimeException("No se encontró el cliente a inhabilitar");
        }
        
        Cliente updatedCliente = existingCliente.get();
        updatedCliente.setEstado(false);
        clienteRepository.save(updatedCliente);
    }
}

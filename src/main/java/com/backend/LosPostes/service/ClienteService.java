package com.backend.LosPostes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.LosPostes.entity.Cliente;
import com.backend.LosPostes.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getcliente() {
        return this.clienteRepository.findAll();
    }

    public Cliente newcliente(Cliente cliente) {
        Optional<Cliente> existingCliente = clienteRepository.findClienteByNombre(cliente.getNombre());

        if (existingCliente.isPresent() && cliente.getClienteID() == null) {
            throw new RuntimeException("Ya existe un cliente con ese nombre");
        }

        return clienteRepository.save(cliente);
    }

    public Cliente updatecliente(Cliente cliente) {
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

    public void disablecliente(Integer id) {
        Optional<Cliente> existingCliente = clienteRepository.findById(id);

        if (existingCliente.isEmpty()) {
            throw new RuntimeException("No se encontró el cliente a inhabilitar");
        }
        
        Cliente updatedCliente = existingCliente.get();
        updatedCliente.setEstado(false);
        clienteRepository.save(updatedCliente);
    }
}

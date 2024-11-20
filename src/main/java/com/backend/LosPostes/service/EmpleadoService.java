package com.backend.LosPostes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.LosPostes.data.model.entity.Empleado;
import com.backend.LosPostes.data.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getEmpleado() {
        return this.empleadoRepository.findAllActivos();
    }

    public Empleado newEmpleado(Empleado empleado) {
        var nuevoEmpleado = Empleado.builder()
            .dni(empleado.getDni())
            .nombre(empleado.getNombre())
            .apellido(empleado.getApellido())
            .cargo(empleado.getCargo())
            .estado(true)
            .build();

        return empleadoRepository.save(nuevoEmpleado);
    }

    public Empleado updateEmpleado(Empleado empleado) {
        Optional<Empleado> existingEmpleado = empleadoRepository.findById(empleado.getEmpleadoID());
        if (existingEmpleado.isEmpty()) {
            throw new RuntimeException("No se encontró el empleado a actualizar");
        }

        Empleado updatedEmpleado = existingEmpleado.get();
        updatedEmpleado.setDni(empleado.getDni());
        updatedEmpleado.setNombre(empleado.getNombre());
        updatedEmpleado.setApellido(empleado.getApellido());
        updatedEmpleado.setCargo(empleado.getCargo());

        return empleadoRepository.save(updatedEmpleado);
    }

    public void disableEmpleado(Integer id) {
        Optional<Empleado> existingEmpleado = empleadoRepository.findById(id);

        if (existingEmpleado.isEmpty()) {
            throw new RuntimeException("No se encontró el empleado a inhabilitar");
        }
        
        Empleado updatedEmpleado = existingEmpleado.get();
        updatedEmpleado.setEstado(false);
        empleadoRepository.save(updatedEmpleado);
    }
}

package com.clinica.farmacia.service;

import com.clinica.farmacia.model.Medicamento;
import com.clinica.farmacia.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository repository;

    public List<Medicamento> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Medicamento> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Medicamento guardar(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    public Medicamento actualizar(Long id, Medicamento nuevo) {
        Medicamento med = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicamento no encontrado"));
        med.setNombre(nuevo.getNombre());
        med.setDescripcion(nuevo.getDescripcion());
        med.setStock(nuevo.getStock());
        med.setPrecio(nuevo.getPrecio());
        med.setFechaVencimiento(nuevo.getFechaVencimiento());
        return repository.save(med);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
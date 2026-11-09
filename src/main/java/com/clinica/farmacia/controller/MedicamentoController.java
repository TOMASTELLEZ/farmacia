package com.clinica.farmacia.controller;

import com.clinica.farmacia.model.Medicamento;
import com.clinica.farmacia.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
@CrossOrigin(origins = "*")
public class MedicamentoController {

    @Autowired
    private MedicamentoService service;

    @GetMapping
    public List<Medicamento> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Medicamento crear(@RequestBody Medicamento medicamento) {
        return service.guardar(medicamento);
    }

    @PutMapping("/{id}")
    public Medicamento actualizar(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        return service.actualizar(id, medicamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
package com.kaukaukids.pago.controller;

import com.kaukaukids.pago.model.pagoModel;
import com.kaukaukids.pago.service.pagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pagos")
@CrossOrigin(origins = "*")
public class pagoController {

    @Autowired
    private pagoService service;

    // POST: Registrar un pago (http://localhost:8083/api/v1/pagos)
    @PostMapping
    public ResponseEntity<pagoModel> crearPago(@RequestBody pagoModel nuevoPago) {
        pagoModel guardado = service.registrarPago(nuevoPago);
        return ResponseEntity.ok(guardado);
    }

    // GET: Ver historial de transacciones (http://localhost:8083/api/v1/pagos)
    @GetMapping
    public ResponseEntity<List<pagoModel>> listarPagos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    // GET: Buscar un pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<pagoModel> buscarPorId(@PathVariable Long id) {
        pagoModel encontrado = service.obtenerPorId(id);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontrado);
    }
}
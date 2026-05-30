package com.kaukaukids.evento.controller;

import com.kaukaukids.evento.model.evento;
import com.kaukaukids.evento.service.eventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/eventos")
@CrossOrigin(origins = "*")
public class eventoController {

    @Autowired
    private eventoService service;

    // POST: Registrar una nueva solicitud (App Móvil del cliente)
    @PostMapping
    public ResponseEntity<evento> crearSolicitudEvento(@RequestBody evento nuevoEvento) {
        evento guardado = service.registrarEvento(nuevoEvento);
        return ResponseEntity.ok(guardado);
    }

    // GET: Ver todas las solicitudes (Panel Administrativo)
    @GetMapping
    public ResponseEntity<List<evento>> listarSolicitudes() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    // GET: Ver un evento en específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<evento> buscarPorId(@PathVariable Long id) {
        evento encontrado = service.obtenerPorId(id);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontrado);
    }
}
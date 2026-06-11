package com.kaukaukids.servicio.controller;

import com.kaukaukids.servicio.model.servicioModel;
import com.kaukaukids.servicio.service.servicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/servicios")
@CrossOrigin(origins = "*") // Permite conexión futura con el frontend
public class servicioController {

    @Autowired
    private servicioService service;

    // POST: Agregar un servicio (http://localhost:8085/api/v1/servicios)
    @PostMapping
    public ResponseEntity<servicioModel> crearServicio(@RequestBody servicioModel nuevoServicio) {
        servicioModel guardado = service.guardarServicio(nuevoServicio);
        return ResponseEntity.ok(guardado);
    }

    // GET: Listar todo el catálogo (http://localhost:8085/api/v1/servicios)
    @GetMapping
    public ResponseEntity<List<servicioModel>> listarServicios() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    // GET: Buscar un único servicio por ID (http://localhost:8085/api/v1/servicios/{id})
    @GetMapping("/{id}")
    public ResponseEntity<servicioModel> buscarPorId(@PathVariable Long id) {
        servicioModel encontrado = service.obtenerPorId(id);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontrado);
    }
}
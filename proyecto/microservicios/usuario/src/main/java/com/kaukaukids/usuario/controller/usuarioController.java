package com.kaukaukids.usuario.controller;

import com.kaukaukids.usuario.model.usuarioModel;
import com.kaukaukids.usuario.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin(origins = "*")
public class usuarioController {

    @Autowired
    private usuarioService service;

    // POST: Registrar un usuario (http://localhost:8084/api/v1/usuarios)
    @PostMapping
    public ResponseEntity<usuarioModel> crearUsuario(@RequestBody usuarioModel nuevoUsuario) {
        usuarioModel guardado = service.registrarUsuario(nuevoUsuario);
        return ResponseEntity.ok(guardado);
    }

    // GET: Listar usuarios (http://localhost:8084/api/v1/usuarios)
    @GetMapping
    public ResponseEntity<List<usuarioModel>> listarUsuarios() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    // GET: Buscar usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<usuarioModel> buscarPorId(@PathVariable Long id) {
        usuarioModel encontrado = service.obtenerPorId(id);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontrado);
    }
}
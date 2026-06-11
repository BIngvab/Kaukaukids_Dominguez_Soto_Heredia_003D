package com.kaukaukids.staff.controller;

import com.kaukaukids.staff.model.StaffModel;
import com.kaukaukids.staff.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
@CrossOrigin(origins = "*")
public class StaffController {

    @Autowired
    private StaffService service;

    // POST: Registrar personal (http://localhost:8086/api/v1/staff)
    @PostMapping
    public ResponseEntity<StaffModel> crearStaff(@RequestBody StaffModel nuevoStaff) {
        StaffModel guardado = service.guardarStaff(nuevoStaff);
        return ResponseEntity.ok(guardado);
    }

    // GET: Listar todo el personal (http://localhost:8086/api/v1/staff)
    @GetMapping
    public ResponseEntity<List<StaffModel>> listarStaff() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    // GET: Buscar personal por ID (http://localhost:8086/api/v1/staff/{id})
    @GetMapping("/{id}")
    public ResponseEntity<StaffModel> buscarPorId(@PathVariable Long id) {
        StaffModel encontrado = service.obtenerPorId(id);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontrado);
    }
}
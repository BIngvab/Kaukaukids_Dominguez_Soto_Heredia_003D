package com.kaukaukids.minuta.controller;

import com.kaukaukids.minuta.model.minutaModel;
import com.kaukaukids.minuta.service.minutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/minuta")
public class minutaController {

    @Autowired
    private minutaService service;

    @PostMapping("/calcular")
    public ResponseEntity<Map<String, Object>> calcularMinuta(@RequestBody minutaModel request) {
        Map<String, Object> resultado = service.calcularYGuardarMinuta(request);
        return ResponseEntity.ok(resultado);
    }
}
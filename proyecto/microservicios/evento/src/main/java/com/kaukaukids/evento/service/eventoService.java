package com.kaukaukids.evento.service;

import com.kaukaukids.evento.model.evento;
import com.kaukaukids.evento.repository.eventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class eventoService {

    @Autowired
    private eventoRepository repository;

    // Guardar una nueva solicitud de evento (Paso 1 y 2 del flujo normal)
    public evento registrarEvento(evento nuevoEvento) {
        nuevoEvento.setEstado("Pendiente de Cálculo");
        return repository.save(nuevoEvento);
    }

    // Listar todos los eventos (Para la bandeja del Administrador)
    public List<evento> obtenerTodos() {
        return repository.findAll();
    }

    // Buscar por ID
    public evento obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
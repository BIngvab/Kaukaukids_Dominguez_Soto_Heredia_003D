package com.kaukaukids.servicio.service;

import com.kaukaukids.servicio.model.servicioModel;
import com.kaukaukids.servicio.repository.servicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class servicioService {

    @Autowired
    private servicioRepository repository;

    // Guardar un nuevo servicio en el catálogo
    public servicioModel guardarServicio(servicioModel servicio) {
        return repository.save(servicio);
    }

    // Listar todo el catálogo disponible
    public List<servicioModel> obtenerTodos() {
        return repository.findAll();
    }

    // Buscar un servicio específico por ID
    public servicioModel obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
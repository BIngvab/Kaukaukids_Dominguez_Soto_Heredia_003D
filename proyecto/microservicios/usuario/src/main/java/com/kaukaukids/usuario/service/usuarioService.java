package com.kaukaukids.usuario.service;

import com.kaukaukids.usuario.model.usuarioModel;
import com.kaukaukids.usuario.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class usuarioService {

    @Autowired
    private usuarioRepository repository;

    // Registrar un nuevo usuario en la plataforma
    public usuarioModel registrarUsuario(usuarioModel usuario) {
        if (usuario.getRol() == null || usuario.getRol().isEmpty()) {
            usuario.setRol("ROLE_CLIENTE"); // Rol por defecto seguro
        }
        return repository.save(usuario);
    }

    // Listar todos los usuarios (Útil para el panel de administración)
    public List<usuarioModel> obtenerTodos() {
        return repository.findAll();
    }

    // Buscar usuario por ID
    public usuarioModel obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
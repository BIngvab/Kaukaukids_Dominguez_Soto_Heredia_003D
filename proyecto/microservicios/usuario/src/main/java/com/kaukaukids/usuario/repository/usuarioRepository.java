package com.kaukaukids.usuario.repository;

import com.kaukaukids.usuario.model.usuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface usuarioRepository extends JpaRepository<usuarioModel, Long> {
    // Método para buscar por email en procesos de autenticación
    Optional<usuarioModel> findByEmail(String email);
}
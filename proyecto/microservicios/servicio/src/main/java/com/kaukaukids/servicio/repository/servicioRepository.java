package com.kaukaukids.servicio.repository;

import com.kaukaukids.servicio.model.servicioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface servicioRepository extends JpaRepository<servicioModel, Long> {
}
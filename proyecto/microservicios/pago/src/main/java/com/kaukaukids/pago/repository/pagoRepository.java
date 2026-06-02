package com.kaukaukids.pago.repository;

import com.kaukaukids.pago.model.pagoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pagoRepository extends JpaRepository<pagoModel, Long> {
    // Hereda todas las operaciones CRUD automáticamente
}
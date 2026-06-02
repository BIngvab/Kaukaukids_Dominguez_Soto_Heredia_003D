package com.kaukaukids.pago.service;

import com.kaukaukids.pago.model.pagoModel;
import com.kaukaukids.pago.repository.pagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class pagoService {

    @Autowired
    private pagoRepository repository;

    // Registrar un nuevo pago (Valida la intención de reserva)
    public pagoModel registrarPago(pagoModel nuevoPago) {
        nuevoPago.setFechaPago(LocalDateTime.now()); // Asigna la fecha actual automáticamente
        return repository.save(nuevoPago);
    }

    // Listar todos los pagos para los reportes administrativos financieros
    public List<pagoModel> obtenerTodos() {
        return repository.findAll();
    }

    // Buscar pagos de un evento en específico
    public pagoModel obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
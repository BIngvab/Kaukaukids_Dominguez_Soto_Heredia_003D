package com.kaukaukids.staff.service;

import com.kaukaukids.staff.model.StaffModel;
import com.kaukaukids.staff.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository repository;

    // Registrar un nuevo miembro del personal
    public StaffModel guardarStaff(StaffModel staff) {
        return repository.save(staff);
    }

    // Listar a todo el personal
    public List<StaffModel> obtenerTodos() {
        return repository.findAll();
    }

    // Buscar personal específico por ID
    public StaffModel obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
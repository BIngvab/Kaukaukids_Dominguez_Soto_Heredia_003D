package com.kaukaukids.staff.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff")
public class StaffModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String rol; 
    private String telefono;
    private Boolean disponible;

    // Constructor vacío
    public StaffModel() {
    }

    // Constructor con parámetros
    public StaffModel(Long id, String nombre, String rol, String telefono, Boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.telefono = telefono;
        this.disponible = disponible;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
}
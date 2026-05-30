package com.kaukaukids.evento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventos")
public class evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tipoMinuta;
    private int adults;
    private int children;
    private String estado; // Ejemplo: "Pendiente de Cálculo"

    // Constructor Vacío (Obligatorio para JPA)
    public evento() {
    }

    // Constructor con parámetros
    public evento(Long id, String tipoMinuta, int adults, int children, String estado) {
        this.id = id;
        this.tipoMinuta = tipoMinuta;
        this.adults = adults;
        this.children = children;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipoMinuta() { return tipoMinuta; }
    public void setTipoMinuta(String tipoMinuta) { this.tipoMinuta = tipoMinuta; }

    public int getAdults() { return adults; }
    public void setAdults(int adults) { this.adults = adults; }

    public int getChildren() { return children; }
    public void setChildren(int children) { this.children = children; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
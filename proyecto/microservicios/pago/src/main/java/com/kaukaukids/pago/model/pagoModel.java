package com.kaukaukids.pago.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
public class pagoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long eventoId; // Vincula el pago con el microservicio de Eventos
    private double monto;
    private String metodoPago; // Ejemplo: "Transferencia", "Efectivo", "Webpay"
    private LocalDateTime fechaPago;

    // Constructor vacío (Obligatorio para JPA)
    public pagoModel() {
    }

    // Constructor con parámetros
    public pagoModel(Long id, Long eventoId, double monto, String metodoPago, LocalDateTime fechaPago) {
        this.id = id;
        this.eventoId = eventoId;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = fechaPago;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEventoId() { return eventoId; }
    public void setEventoId(Long eventoId) { this.eventoId = eventoId; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }
}
package com.ev02prometheus.web.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidad que representa a un Inquilino.
 * Se almacena en la base de datos mediante JPA.
 */
@Entity
@Table(name = "inquilinos")
public class Inquilino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincremental
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 20)
    private String documento;

    @Column(length = 15)
    private String telefono;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructor vacío (obligatorio para JPA)
    public Inquilino() {}

    // Constructor completo
    public Inquilino(Long id, String nombre, String documento, String telefono,
                     LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    /**
     * Callback que se ejecuta antes de insertar un registro.
     * Se asigna la fecha de creación.
     */
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Callback que se ejecuta antes de actualizar un registro.
     * Se asigna la fecha de modificación.
     */
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
package com.ev02prometheus.web.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidad JPA que representa un Perfil (usuario/perfil) del sistema.
 * Mapea a la tabla 'perfil' en la base de datos.
 */
@Entity
@Table(name = "perfil")
public class Perfil {

    /** Identificador PK autogenerado */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre completo */
    @Column(nullable = false, length = 100)
    private String nombre;

    /** Documento (cédula / identificación) - único */
    @Column(nullable = false, length = 50, unique = true)
    private String documento;

    /** Teléfono de contacto */
    @Column(length = 20)
    private String telefono;

    /** Correo electrónico - único */
    @Column(nullable = false, length = 120, unique = true)
    private String correo;

    /** Contraseña (almacenar hasheada en producción) */
    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;

    /** Auditoría: fecha de creación (no actualizable) */
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    /** Auditoría: fecha de última modificación */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // ---------- Constructores ----------

    /** Constructor vacío (obligatorio para JPA) */
    public Perfil() {}

    /** Constructor completo */
    public Perfil(Long id, String nombre, String documento, String telefono,
                  String correo, String contrasena,
                  LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    // ---------- Getters / Setters ----------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    // ---------- Callbacks JPA para auditoría ----------

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
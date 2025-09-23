package com.ev02prometheus.web.model;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Entidad que representa a un usuario del sistema.
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L; // <- agregado para quitar advertencia

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Usar Long en lugar de long

    private String nombre;
    private String correo;
    private String contraseña;

    // Constructor vacío (obligatorio para JPA)
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(Long id, String nombre, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
}
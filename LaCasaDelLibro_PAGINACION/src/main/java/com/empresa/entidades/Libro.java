package com.empresa.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "libros")
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    private String isbn;
    private Double precio;

    // --- GETTERS Y SETTERS MANUALES (Para que Thymeleaf no falle) ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
}
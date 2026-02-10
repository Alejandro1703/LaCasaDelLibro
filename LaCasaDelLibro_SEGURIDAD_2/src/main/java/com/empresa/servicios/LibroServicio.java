package com.empresa.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.empresa.entidades.Libro;
import com.empresa.repositorios.LibroRepositorio;

@Service
public class LibroServicio {

    private final LibroRepositorio repositorio;

    public LibroServicio(LibroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Page<Libro> listarTodos(Pageable pageable) {
        return repositorio.findAll(pageable);
    }

    public void guardar(Libro libro) {
        repositorio.save(libro);
    }

    public Libro obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
package com.empresa.servicios;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entidades.Libro;
import com.empresa.repositorios.LibroRepositorio;

@Service
public class LibroServicio {

    private final LibroRepositorio repositorio;

    public LibroServicio(LibroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Libro> listarTodos() {
        return repositorio.findAll();
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
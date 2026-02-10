package com.empresa.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empresa.entidades.Libro;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
}
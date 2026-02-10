package com.empresa.controladores;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.empresa.servicios.LibroServicio;
import com.empresa.entidades.Libro;

import java.security.Principal;

@Controller
@RequestMapping("/libros")
public class LibroControlador {

    private final LibroServicio servicio;

    public LibroControlador(LibroServicio servicio) {
        this.servicio = servicio;
    }

    // Acepta tanto /libros como /libros/
    @GetMapping({"", "/"})
    public String listar(@RequestParam(defaultValue = "0") int page, Model model, Principal principal) {
        Page<Libro> paginaLibros = servicio.listarTodos(
            PageRequest.of(page, 10, Sort.by("titulo").ascending())
        );

        model.addAttribute("libros", paginaLibros.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", paginaLibros.getTotalPages());
        
        // Principal contiene el nombre 'admin' definido en el properties
        model.addAttribute("usuario", principal != null ? principal.getName() : "Invitado");
        
        return "libros/lista";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("libro", new Libro());
        return "libros/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("libro") Libro libro) {
        servicio.guardar(libro);
        return "redirect:/libros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("libro", servicio.obtenerPorId(id));
        return "libros/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return "redirect:/libros";
    }
}
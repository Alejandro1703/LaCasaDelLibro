package com.empresa.controladores;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.empresa.entidades.Libro;
import com.empresa.entidades.Usuario;
import com.empresa.servicios.LibroServicio;
import com.empresa.servicios.UsuarioServicio;

@Controller
@RequestMapping("/libros")
public class LibroControlador {

    private final LibroServicio libroServicio;
    private final UsuarioServicio usuarioServicio;

    public LibroControlador(LibroServicio libroServicio, UsuarioServicio usuarioServicio) {
        this.libroServicio = libroServicio;
        this.usuarioServicio = usuarioServicio;
    }

    // El ajuste {"", "/"} permite entrar con /libros y con /libros/ sin errores 404
    @GetMapping({"", "/"})
    public String listar(Model model, @PageableDefault(size = 10, sort = "titulo") Pageable pageable) {
        
        // 1. Obtenemos la página de libros
        Page<Libro> paginaLibros = libroServicio.listarTodos(pageable);
        
        // 2. Obtenemos el usuario conectado para mostrar su nombre en el layout
        Usuario usuarioConectado = usuarioServicio.obtenerUsuarioConectado();

        // 3. Pasamos los atributos al modelo
        model.addAttribute("usuario", usuarioConectado);
        model.addAttribute("libros", paginaLibros.getContent());
        model.addAttribute("currentPage", paginaLibros.getNumber());
        model.addAttribute("totalPages", paginaLibros.getTotalPages());
        model.addAttribute("totalElements", paginaLibros.getTotalElements());

        // Esto busca: src/main/resources/templates/libros/lista.html
        return "libros/lista";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("usuario", usuarioServicio.obtenerUsuarioConectado());
        return "libros/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("libro") Libro libro) {
        libroServicio.guardar(libro);
        return "redirect:/libros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("libro", libroServicio.obtenerPorId(id));
        model.addAttribute("usuario", usuarioServicio.obtenerUsuarioConectado());
        return "libros/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        libroServicio.eliminar(id);
        return "redirect:/libros";
    }
}
package com.empresa.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empresa.servicios.UsuarioServicio;
import com.empresa.entidades.enumerado.Rol; 

@Controller
public class RegistroControlador {

    private final UsuarioServicio usuarioServicio;

    public RegistroControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro"; 
    }

    @PostMapping("/registro")
    public String registrar(@RequestParam String username, @RequestParam String password) {
        usuarioServicio.crear(username, password, Rol.USUARIO);
        return "redirect:/login";
    }
}
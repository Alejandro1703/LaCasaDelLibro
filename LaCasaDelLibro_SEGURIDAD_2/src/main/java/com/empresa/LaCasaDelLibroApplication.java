package com.empresa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LaCasaDelLibroApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaCasaDelLibroApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(com.empresa.servicios.UsuarioServicio servicio) {
	    return args -> {
	        // Borramos el admin antiguo si existe para evitar errores de duplicado o hash viejo
	        if (servicio.obtenerPorNombre("admin") != null) {
	            // Puedes borrarlo manualmente en SQL o simplemente no hacer nada si ya funciona
	        } else {
	            servicio.crear("admin", "admin", com.empresa.entidades.enumerado.Rol.ADMIN);
	            System.out.println(">>> USUARIO ADMIN CREADO EXITOSAMENTE (PASS: admin) <<<");
	        }
	    };
	}
}

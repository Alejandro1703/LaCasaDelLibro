package com.empresa.servicios;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.empresa.entidades.Usuario;
import com.empresa.entidades.enumerado.Rol;

public interface UsuarioServicio {
    Usuario crear(String nombre, String contrasenaEnClaro, Rol rol);
    Usuario actualizar(Long id, String nuevoNombre, Rol nuevoRol);
    void cambiarContrasena(Long id, String contrasenaActualEnClaro, String nuevaContrasenaEnClaro);
    Usuario obtenerPorId(Long id);
    Usuario obtenerPorNombre(String nombre);
    List<Usuario> listar();
    Page<Usuario> listar(Pageable pageable);
    void eliminar(Long id);
    Usuario obtenerUsuarioConectado(); 
}
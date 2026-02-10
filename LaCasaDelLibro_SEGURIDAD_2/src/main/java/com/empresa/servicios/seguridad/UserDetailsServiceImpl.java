package com.empresa.servicios.seguridad;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.empresa.entidades.Usuario;
import com.empresa.repositorios.UsuarioRepositorio;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepositorio repo;

    public UserDetailsServiceImpl(UsuarioRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = repo.findByNombre(username);
        if (u == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        
        return User.withUsername(u.getNombre())
                .password(u.getContrasena())
                .authorities("ROLE_" + u.getRol().name()) 
                .build();
    }
}
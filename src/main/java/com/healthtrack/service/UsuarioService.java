package com.healthtrack.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;
import com.healthtrack.model.Usuario;


@Service
public class UsuarioService {
    private final ConcurrentHashMap<String, Usuario> usuarios = new ConcurrentHashMap<>();

    public void registrar(Usuario usuario) {
        usuarios.put(usuario.getNombre(), usuario);
    }

    public Usuario obtener(String nombre) {
        return usuarios.get(nombre);
    }

    public void actualizarPeso(String nombre, double nuevoPeso) {
        Usuario usuario = usuarios.get(nombre);
        if (usuario != null) usuario.setPeso(nuevoPeso);
    }
}

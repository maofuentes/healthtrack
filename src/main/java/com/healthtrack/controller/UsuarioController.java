package com.healthtrack.controller;

import com.healthtrack.model.Usuario;
import com.healthtrack.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public String formularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Usuario usuario) {
        service.registrar(usuario);
        return "redirect:/dashboard?nombre=" + usuario.getNombre();
    }

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam String nombre, Model model) {
        Usuario usuario = service.obtener(nombre);
        model.addAttribute("usuario", usuario);
        return "dashboard";
    }

    @PostMapping("/actualizar")
    public String actualizar(@RequestParam String nombre, @RequestParam double nuevoPeso) {
        service.actualizarPeso(nombre, nuevoPeso);
        return "redirect:/dashboard?nombre=" + nombre;
    }
}

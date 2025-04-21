package com.example.microservicio_usuarios_mascotas.controller;

import com.example.microservicio_usuarios_mascotas.model.usuario;
import com.example.microservicio_usuarios_mascotas.service.usuarioservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*") // <--- ESTA LÍNEA
@RestController
@RequestMapping("/usuarios")
public class usuariocontroller {

    private final usuarioservice usuarioservice;

    public usuariocontroller(usuarioservice usuarioservice) {
        this.usuarioservice = usuarioservice;
    }

    @GetMapping
    public List<usuario> obtenerTodos() {
        return usuarioservice.obtenerTodos();
    }
    
    @GetMapping("/{id}")
    public Optional<usuario> obtenerPorId(@PathVariable Long id) {
        return usuarioservice.obtenerPorId(id);
    }

    @GetMapping("/rol/{rol}")
    public List<usuario> obtenerPorRol(@PathVariable String rol) {
        return usuarioservice.obtenerPorRol(rol);
    }

    @GetMapping("/login")
    public Optional<usuario> login(@RequestParam String email, @RequestParam String contraseña) {
        return usuarioservice.login(email, contraseña);
    }

    @GetMapping("/login/mensaje")
    public String loginConMensaje(@RequestParam String email, @RequestParam String contraseña) {
        return usuarioservice.loginConMensaje(email, contraseña);
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@RequestBody usuario nuevoUsuario) {
        System.out.println("📩 Registro recibido: " + nuevoUsuario.getEmail());
        return usuarioservice.registrar(
            nuevoUsuario.getNombre(),
            nuevoUsuario.getEmail(),
            nuevoUsuario.getContraseña(),
            nuevoUsuario.getRol()
        );
    }
    
    @PutMapping("/{id}")
    public String actualizarUsuario(@PathVariable Long id, @RequestBody usuario usuarioActualizado) {
        return usuarioservice.actualizarUsuario(id, usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        return usuarioservice.eliminarUsuario(id);
    }

    
}

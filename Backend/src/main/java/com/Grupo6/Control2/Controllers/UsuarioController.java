package com.Grupo6.Control2.Controllers;

import com.Grupo6.Control2.Services.UsuarioService;
import com.Grupo6.Control2.models.Usuario;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/CrearUsuario")
    @ResponseBody
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.crearUsuario(usuario);
    }

    @DeleteMapping("/BorrarUsuario/{id_usuario}")
    public void borrarUsuario(@PathVariable("id_usuario") Long id_usario){
        usuarioService.borrarUsuario(id_usario);
    }

    @PutMapping("/ActualizarUsuario/{id_usuario}")
    @ResponseBody
    public void actualizarUsuario(@RequestBody Usuario usuario, @PathVariable("id_usuario") Long id_usario){
        usuarioService.actualizarUsuario(usuario, id_usario);
    }

    @GetMapping("/MostrarUsuarios")
    public List<Usuario> obtenerUsuarios()
    {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/MostrarUsuario/{id_usuario}")
    public Usuario obtenerUsuario(@PathVariable("id_usuario") Long id_usuario){
        return usuarioService.obtenerUsuario(id_usuario);
    }
    @GetMapping("/MostrarUsuarioPorNombre/{nombre_usuario}")
    public Usuario obtenerUsuarioPorNombre(@PathVariable("nombre_usuario") String nombre_usuario){
        return usuarioService.obtenerUsuarioPorNombre(nombre_usuario);
    }

    @PostMapping("/Login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {

        Usuario usuario1 = usuarioService.obtenerUsuarioPorNombre(usuario.getNombre_usuario());
        if (usuario1 != null && usuario1.getContrasena().equals(usuario.getContrasena())) {
            System.out.println("Login exitoso");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Login exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login fallido");
        }

    }

}

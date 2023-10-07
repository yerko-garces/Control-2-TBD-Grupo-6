package com.Grupo6.Control2.models.Controllers;

import com.Grupo6.Control2.Services.UsuarioService;
import com.Grupo6.Control2.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/CrearUsuario")
    @ResponseBody
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        Usuario resultado = usuarioService.crearUsuario(usuario);
        return resultado;
    }

    @DeleteMapping("BorrarUsuario/{id_usuario}")
    public void borrarUsuario(@PathVariable("id_usuario") Long id_usario){
        usuarioService.borrarUsuario(id_usario);
    }

    @PutMapping("ActualizarUsuario/{id_usuario}")
    @ResponseBody
    public void actualizarUsuario(@RequestBody Usuario usuario, @PathVariable("id_usuario") Long id_usario){
        usuarioService.actualizarUsuario(usuario, id_usario);
    }

    @GetMapping("MostrarUsuarios")
    public List<Usuario> obtenerUsuarios()
    {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("MostrarUsuario/{id_usuario}")
    public Usuario obtenerUsuario(@PathVariable("id_usuario") Long id_usuario){
        return usuarioService.obtenerUsuario(id_usuario);
    }
    @GetMapping("MostrarUsuarioPorNombre/{nombre_usuario}")
    public Usuario obtenerUsuarioPorNombre(@PathVariable("nombre_usuario") String nombre_usuario){
        return usuarioService.obtenerUsuarioPorNombre(nombre_usuario);
    }

}

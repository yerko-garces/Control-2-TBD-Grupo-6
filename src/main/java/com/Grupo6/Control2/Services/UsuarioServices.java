package com.Grupo6.Control2.Services;

import com.Grupo6.Control2.models.Usuario;
import com.Grupo6.Control2.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UsuarioServices {

    private final UsuarioRepository UsuarioRepository;

    UsuarioServices(UsuarioRepository UsuarioRepository){this.UsuarioRepository = UsuarioRepository;}

    @PostMapping("/CrearUsuario")
    @ResponseBody
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        Usuario resultado = UsuarioRepository.crearUsuario(usuario);
        return resultado;
    }

    @DeleteMapping("BorrarUsuario/{id_usuario}")
    public void borrarUsuario(@PathVariable("id_usuario") Long id_usario){
        UsuarioRepository.borrarUsuario(id_usario);
    }

    @PutMapping("ActualizarUsuario/{id_usuario}")
    @ResponseBody
    public void actualizarUsuario(@RequestBody Usuario usuario, @PathVariable("id_usuario") Long id_usario){
        UsuarioRepository.actualizarUsuario(usuario, id_usario);
    }

    @GetMapping("MostrarUsuarios")
    public List<Usuario> obtenerUsuarios()
    {
        return UsuarioRepository.getUsuarios();
    }

}

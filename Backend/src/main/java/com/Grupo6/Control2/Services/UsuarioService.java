package com.Grupo6.Control2.Services;
import com.Grupo6.Control2.models.Usuario;
import com.Grupo6.Control2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario crearUsuario(Usuario usuario){
        Usuario resultado = usuarioRepository.crearUsuario(usuario);
        return resultado;
    }
    public void borrarUsuario(Long id_usuario){
        usuarioRepository.borrarUsuario(id_usuario);
    }
    public void actualizarUsuario(Usuario usuario, Long id_us){
        usuarioRepository.actualizarUsuario(usuario, id_us);
    }
    public ArrayList<Usuario> obtenerUsuarios(){
        return usuarioRepository.getUsuarios();
    }
    public Usuario obtenerUsuario(Long id_usuario){
        return usuarioRepository.getUsuario(id_usuario);
    }
    public Usuario obtenerUsuarioPorNombre(String nombre_usuario){
        return usuarioRepository.getUsuarioPorNombre(nombre_usuario);
    }

    public Long obtenerIdUsuarioPorNombre(String nombre_usuario){
        Usuario usuario = usuarioRepository.getUsuarioPorNombre(nombre_usuario);
        Long id = usuario.getId_usuario();
        return  id;
    }
}

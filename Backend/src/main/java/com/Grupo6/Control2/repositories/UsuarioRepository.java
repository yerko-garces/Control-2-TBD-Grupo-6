package com.Grupo6.Control2.repositories;

import com.Grupo6.Control2.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public interface UsuarioRepository {
    public Usuario crearUsuario(Usuario usuario);
    public boolean borrarUsuario(Long id_usuario);
    public boolean actualizarUsuario(Usuario usuario, Long id_us);
    public ArrayList<Usuario> getUsuarios();
    public Usuario getUsuario(Long id_usuario);
    public Usuario getUsuarioPorNombre(String nombre_usuario);

}

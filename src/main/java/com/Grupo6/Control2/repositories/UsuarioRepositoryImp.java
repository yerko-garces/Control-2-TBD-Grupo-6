package com.Grupo6.Control2.repositories;

import com.Grupo6.Control2.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImp implements UsuarioRepository{

    private Sql2o sql2o;
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Usuario (id_usuario, nombre_usuario, contrasena" +
                    "VALUES (:id_usuario, :nombre_usuario, :contrasena";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario", usuario.getId_usuario())
                    .addParameter("nombre_usuario", usuario.getNombre_usuario())
                    .addParameter("contrasena",usuario.getContrasena())
                    .executeUpdate();
            return usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean borrarUsuario(Long id_us) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Usuario WHERE id_usuario=id_usuario";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario", id_us)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Usuario SET id_usuario:id_usuario, nombre_usuario:nombre_usuario, contrasena:contrasena";
            conn.createQuery(sql)
                    .addParameter("id_usuario", usuario.getId_usuario())
                    .addParameter("nombre_usuario", usuario.getNombre_usuario())
                    .addParameter("contrasena",usuario.getContrasena())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Usuario> getUsuarios() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM Usuario";
            List<Usuario> usuarios = conn.createQuery(sql).executeAndFetch(Usuario.class);
            return usuarios;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
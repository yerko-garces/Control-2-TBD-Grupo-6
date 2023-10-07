package com.Grupo6.Control2.repositories;

import com.Grupo6.Control2.models.Usuario;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoryImp implements UsuarioRepository{

    @Autowired
    private Sql2o sql2o;
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Usuario (id_usuario, nombre_usuario, contrasena)" +
                    "VALUES (:id_usuario, :nombre_usuario, :contrasena)";
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
    public boolean borrarUsuario(Long id_usuario) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM Usuario WHERE id_usuario=:id_usuario";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario", id_usuario)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario, Long id_us) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Usuario SET id_usuario=:id_usuario, nombre_usuario=:nombre_usuario, contrasena=:contrasena WHERE id_usuario=:id_us";
            conn.createQuery(sql)
                    .addParameter("id_us", id_us)
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
    public ArrayList<Usuario> getUsuarios() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM Usuario";
            List<Usuario> usuarios = conn.createQuery(sql).executeAndFetch(Usuario.class);
            return (ArrayList<Usuario>) usuarios;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Usuario getUsuario(Long id) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM Usuario WHERE id_usuario=:id_usuario";
            return conn.createQuery(sql)
                    .addParameter("id_usuario", id)
                    .executeAndFetchFirst(Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Usuario getUsuarioPorNombre(String nombre) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM Usuario WHERE nombre_usuario=:nombre_usuario";
            return conn.createQuery(sql)
                    .addParameter("nombre_usuario", nombre)
                    .executeAndFetchFirst(Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}